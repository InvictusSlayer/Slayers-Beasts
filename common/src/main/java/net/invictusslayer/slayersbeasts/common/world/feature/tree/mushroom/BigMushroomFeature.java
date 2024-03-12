package net.invictusslayer.slayersbeasts.common.world.feature.tree.mushroom;

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

public class BigMushroomFeature extends Feature<BigMushroomFeature.Configuration> {
	public BigMushroomFeature(Codec<Configuration> codec) {
		super(codec);
	}

	public boolean place(FeaturePlaceContext<Configuration> context) {
		WorldGenLevel level = context.level();
		BlockPos origin = context.origin();
		RandomSource random = context.random();
		Configuration config = context.config();

		int height = config.height.sample(random);
		BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();

		if (!isValidPosition(level, origin, mutableBlockPos, height)) return false;

		BlockState cap = config.capProvider.getState(random, origin);
		if (cap.hasProperty(HugeMushroomBlock.DOWN)) cap = cap.setValue(HugeMushroomBlock.DOWN, false);
		BlockState stem = config.stemProvider.getState(random, origin);
		if (stem.hasProperty(HugeMushroomBlock.DOWN)) stem = stem.setValue(HugeMushroomBlock.DOWN, false).setValue(HugeMushroomBlock.UP, false);

		mutableBlockPos.set(origin);
		for (int y = 0; y <= height - 1; ++y) {
			checkAndSetBlock(level, mutableBlockPos, stem);
			mutableBlockPos.move(Direction.UP);
		}

		for (int x = -1; x <= 1; ++x) {
			for (int z = -1; z <= 1; ++z) {
				if (x * z == 0) checkAndSetBlock(level, mutableBlockPos.setWithOffset(origin, x, height, z), cap);
				checkAndSetBlock(level, mutableBlockPos.setWithOffset(origin, x, height - 1, z), cap);
			}
		}

		return true;
	}

	private void checkAndSetBlock(WorldGenLevel level, BlockPos pos, BlockState state) {
		if (!level.getBlockState(pos).isSolidRender(level, pos)) {
			setBlock(level, pos, state);
		}
	}

	private boolean isValidPosition(LevelAccessor level, BlockPos pos, BlockPos.MutableBlockPos mutableBlockPos, int height) {
		int i = pos.getY();
		if (i >= level.getMinBuildHeight() + 1 && i + height + 1 < level.getMaxBuildHeight()) {
			BlockState below = level.getBlockState(pos.below());
			if (!isDirt(below) && !below.is(BlockTags.MUSHROOM_GROW_BLOCK)) return false;

			for (int y = 0; y <= height; ++y) {
				for (int x = -1; x <= 1; ++x) {
					for (int z = -1; z <= 1; ++z) {
						BlockState state = level.getBlockState(mutableBlockPos.setWithOffset(pos, x, y, z));
						if (!state.isAir() && !state.is(BlockTags.LEAVES)) {
							return false;
						}
					}
				}
			}
			return true;
		}
		return false;
	}

	public record Configuration(IntProvider height, BlockStateProvider capProvider, BlockStateProvider stemProvider) implements FeatureConfiguration {
		public static final Codec<Configuration> CODEC = RecordCodecBuilder.create(instance ->
				instance.group(IntProvider.CODEC.fieldOf("height").forGetter(Configuration::height),
								BlockStateProvider.CODEC.fieldOf("cap_provider").forGetter(Configuration::capProvider),
								BlockStateProvider.CODEC.fieldOf("stem_provider").forGetter(Configuration::stemProvider))
						.apply(instance, Configuration::new));
	}
}
