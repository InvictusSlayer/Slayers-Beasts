package net.invictusslayer.slayersbeasts.world.feature.mushroom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BranchingMushroomFeature extends Feature<BranchingMushroomFeature.Configuration> {
	private final boolean[] branchChecks = new boolean[5];

	public BranchingMushroomFeature(Codec<Configuration> codec) {
		super(codec);
	}

	public boolean place(FeaturePlaceContext<Configuration> context) {
		WorldGenLevel level = context.level();
		BlockPos origin = context.origin();
		RandomSource random = context.random();
		Configuration config = context.config();

		int height = config.height.sample(random);
		BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
		if (!isValidPosition(level, origin, height, mutableBlockPos, config)) return false;

		List<CapAttachment> attachments = placeStem(level, random, origin, config, height, mutableBlockPos);
		attachments.forEach(attachment -> placeCap(level, random, attachment.origin, config, mutableBlockPos, attachment.variant));
		return true;
	}

	private void placeCap(LevelAccessor level, RandomSource random, BlockPos pos, Configuration config, BlockPos.MutableBlockPos mutableBlockPos, int variant) {
		BlockState state = config.capProvider.getState(random, pos).setValue(HugeMushroomBlock.DOWN, variant < 2);

		setBlock(level, pos, state);
		if (variant < 2) setBlock(level, pos.above(), state);

		Direction.Plane.HORIZONTAL.forEach(direction -> {
			if (variant == 1) setBlock(level, pos.relative(direction).below(), state);
			if (variant == 3) setBlock(level, pos.relative(direction).relative(direction.getClockWise()), state);
			if (variant < 4) setBlock(level, pos.relative(direction), state);
		});
	}

	private List<CapAttachment> placeStem(LevelAccessor level, RandomSource random, BlockPos pos, Configuration config, int maxHeight, BlockPos.MutableBlockPos mutableBlockPos) {
		BlockState state = config.stemProvider.getState(random, pos);
		List<CapAttachment> attachments = new ArrayList<>();
		Arrays.fill(branchChecks, true);
		int height = 3 + random.nextInt(3);
		int max = 0;

		List<Direction> directions = new ArrayList<>(List.of(Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST));
		for (int i = 0; i < random.nextInt(3); i++) {
			Direction direction = directions.remove(0);
			directions.add(direction);
		}
		for (int i = 0; i < 2 + random.nextInt(3); i++) {
			Direction direction = directions.get(i);
			int h = height - random.nextInt(3);
			attachments.add(placeBranch(level, random, pos.above(h), state, config, maxHeight - h, mutableBlockPos, direction, i));
			max = Math.max(max, h);
		}

		setBlock(level, mutableBlockPos.set(pos), state);
		for (int i = 0; i < max; ++i) setBlock(level, mutableBlockPos.move(Direction.UP), state);

		return attachments;
	}

	private CapAttachment placeBranch(LevelAccessor level, RandomSource random, BlockPos pos, BlockState state, Configuration config, int maxHeight, BlockPos.MutableBlockPos mutableBlockPos, Direction direction, int j) {
		boolean flag = false;
		int height = random.nextInt(maxHeight);

		mutableBlockPos.set(pos);
		setBlock(level, mutableBlockPos.move(direction), state);

		if (branchChecks[0] && random.nextInt(6 - j) == 0) flag = true;
		else setBlock(level, mutableBlockPos.move(direction), state);

		if (random.nextInt(5 - j) == 0) {
			if (random.nextBoolean()) {
				if (branchChecks[check(j, true)]) {
					branchChecks[check(j, true)] = false;
					setBlock(level, mutableBlockPos.move(direction.getClockWise()), state);
					if (flag) {
						if (random.nextBoolean()) branchChecks[0] = false;
						else setBlock(level, mutableBlockPos.move(direction.getClockWise()), state);
					}
				}
			} else if (branchChecks[check(j, false)]) {
				branchChecks[check(j, false)] = false;
				setBlock(level, mutableBlockPos.move(direction.getCounterClockWise()), state);
				if (flag) {
					if (random.nextBoolean()) branchChecks[0] = false;
					else setBlock(level, mutableBlockPos.move(direction.getCounterClockWise()), state);
				}
			}
		} else if (flag) branchChecks[0] = false;
		flag = true;

		for (int i = 0; i < height; i++) {
			setBlock(level, mutableBlockPos.move(Direction.UP), state);
			if (flag && random.nextFloat() > 0.75F && i > 1 && i < height - 2) {
				flag = false;
				Direction dir = List.of(direction, direction.getClockWise(), direction.getCounterClockWise()).get(random.nextInt(3));
				setBlock(level, mutableBlockPos.move(dir), state);
			}
		}

		return new CapAttachment(mutableBlockPos.above(), height < 2 ? 4 : random.nextInt(4));
	}

	private int check(int i, boolean clockwise) {
		return clockwise ? i + 1 : i == 0 ? 4 : i;
	}

	private boolean isValidPosition(LevelAccessor level, BlockPos origin, int maxHeight, BlockPos.MutableBlockPos mutableBlockPos, Configuration config) {
		if (origin.getY() <= level.getMinY() || origin.getY() + maxHeight > level.getMaxY()) return false;

		BlockState state = level.getBlockState(origin.below());
		if (!isDirt(state) && !state.is(BlockTags.MUSHROOM_GROW_BLOCK)) return false;

		for (int y = 0; y <= maxHeight; y++) {
			for (int x = -3; x <= 3; x++) {
				for (int z = -3; z <= 3; z++) {
					BlockState blockState = level.getBlockState(mutableBlockPos.setWithOffset(origin, x, y, z));
					if (!blockState.isAir() && !blockState.is(BlockTags.LEAVES)) return false;
				}
			}
		}
		return true;
	}

	public record CapAttachment(BlockPos origin, int variant) {}

	public record Configuration(IntProvider height, BlockStateProvider capProvider, BlockStateProvider stemProvider) implements FeatureConfiguration {
		public static final Codec<Configuration> CODEC = RecordCodecBuilder.create(instance ->
				instance.group(IntProvider.CODEC.fieldOf("height").forGetter(Configuration::height),
								BlockStateProvider.CODEC.fieldOf("cap_provider").forGetter(Configuration::capProvider),
								BlockStateProvider.CODEC.fieldOf("stem_provider").forGetter(Configuration::stemProvider))
						.apply(instance, Configuration::new));
	}
}
