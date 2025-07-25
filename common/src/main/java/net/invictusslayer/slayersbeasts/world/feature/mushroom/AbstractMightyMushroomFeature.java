package net.invictusslayer.slayersbeasts.world.feature.mushroom;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;

import java.util.List;

public abstract class AbstractMightyMushroomFeature extends Feature<HugeMushroomFeatureConfiguration> {
	public AbstractMightyMushroomFeature(Codec<HugeMushroomFeatureConfiguration> codec) {
		super(codec);
	}

	public boolean place(FeaturePlaceContext<HugeMushroomFeatureConfiguration> context) {
		WorldGenLevel level = context.level();
		BlockPos origin = context.origin();
		RandomSource random = context.random();
		HugeMushroomFeatureConfiguration config = context.config();

		int height = getTreeHeight(random);
		BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
		if (!isValidPosition(level, origin, height, mutableBlockPos, config)) return false;

		placeCap(level, random, origin, config, height, mutableBlockPos);
		placeStem(level, random, origin, config, height, mutableBlockPos);
		return true;
	}

	protected abstract void placeCap(LevelAccessor level, RandomSource random, BlockPos pos, HugeMushroomFeatureConfiguration config, int height, BlockPos.MutableBlockPos mutableBlockPos);

	protected void placeStem(LevelAccessor level, RandomSource random, BlockPos pos, HugeMushroomFeatureConfiguration config, int maxHeight, BlockPos.MutableBlockPos mutableBlockPos) {
		for (int i = 0; i < maxHeight - 1; ++i) {
			mutableBlockPos.set(pos).move(Direction.UP, i);
			if (!level.getBlockState(mutableBlockPos).isSolidRender()) {
				setBlock(level, mutableBlockPos, config.stemProvider.getState(random, pos));
				setBlock(level, mutableBlockPos.south(), config.stemProvider.getState(random, pos));
				setBlock(level, mutableBlockPos.east(), config.stemProvider.getState(random, pos));
				setBlock(level, mutableBlockPos.south().east(), config.stemProvider.getState(random, pos));
			}
		}
	}

	protected int getTreeHeight(RandomSource random) {
		int i = random.nextInt(8) + 8;
		if (random.nextInt(12) == 0) i *= 2;

		return i;
	}

	protected boolean isValidPosition(LevelAccessor level, BlockPos pos, int maxHeight, BlockPos.MutableBlockPos mutableBlockPos, HugeMushroomFeatureConfiguration config) {
		if (pos.getY() <= level.getMinY() || pos.getY() + maxHeight > level.getMaxY()) return false;

		List<BlockPos> posList = List.of(pos.below(), pos.below().south(), pos.below().east(), pos.below().south().east());
		for (BlockPos blockPos : posList) {
			BlockState state = level.getBlockState(blockPos);
			if (!isDirt(state) && !state.is(BlockTags.MUSHROOM_GROW_BLOCK)) return false;
		}

		for (int y = 0; y <= maxHeight; ++y) {
			int radius = getTreeRadiusForHeight(config.foliageRadius, maxHeight - y);

			for (int x = -radius; x <= radius + 1; ++x) {
				for (int z = -radius; z <= radius + 1; ++z) {
					BlockState state = level.getBlockState(mutableBlockPos.setWithOffset(pos, x, y, z));
					if (!state.isAir() && !state.is(BlockTags.LEAVES)) return false;
				}
			}
		}
		return true;
	}

	protected abstract int getTreeRadiusForHeight(int radius, int height);
}
