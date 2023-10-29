package net.invictusslayer.slayersbeasts.world.feature.tree;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.AbstractHugeMushroomFeature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;

public class HugeBlackMushroomFeature extends AbstractHugeMushroomFeature {
	public HugeBlackMushroomFeature(Codec<HugeMushroomFeatureConfiguration> codec) {
		super(codec);
	}

	protected void placeTrunk(LevelAccessor level, RandomSource random, BlockPos pos, HugeMushroomFeatureConfiguration config, int maxHeight, BlockPos.MutableBlockPos mutableBlockPos) {
		for (int i = 0; i < maxHeight - 1; ++i) {
			mutableBlockPos.set(pos).move(Direction.UP, i);
			if (!level.getBlockState(mutableBlockPos).isSolidRender(level, mutableBlockPos)) {
				setBlock(level, mutableBlockPos, config.stemProvider.getState(random, pos).setValue(HugeMushroomBlock.UP, false).setValue(HugeMushroomBlock.DOWN, false));
			}
		}
	}

	protected void makeCap(LevelAccessor level, RandomSource random, BlockPos pos, int height, BlockPos.MutableBlockPos mutableBlockPos, HugeMushroomFeatureConfiguration config) {
		for (int y = height - 6; y <= height; ++y) {
			int stage = height - y;
			int radius = stage < 2 ? 1 : 3;

			for (int x = -radius; x <= radius; ++x) {
				for (int z = -radius; z <= radius; ++z) {
					if (isBlock(x, z, stage, random)) {
						mutableBlockPos.setWithOffset(pos, x, y, z);

						if (!level.getBlockState(mutableBlockPos).isSolidRender(level, mutableBlockPos)) {
							boolean flag = stage < 2;
							boolean north = flag || z < 0;
							boolean south = flag || z > 0;
							boolean east = flag || x > 0;
							boolean west = flag || x < 0;

							BlockState state = config.capProvider.getState(random, pos).setValue(HugeMushroomBlock.DOWN, y == height).setValue(HugeMushroomBlock.WEST, west).setValue(HugeMushroomBlock.EAST, east).setValue(HugeMushroomBlock.NORTH, north).setValue(HugeMushroomBlock.SOUTH, south);
							setBlock(level, mutableBlockPos, state);
						}
					}
				}
			}
		}
	}

	private static boolean isBlock(int x, int z, int stage, RandomSource random) {
		int xRad = Math.abs(x);
		int zRad = Math.abs(z);
		int sum = xRad + zRad;

		if (stage == 0) return sum < 2;
		if (stage == 1 || stage == 2) return xRad < 2 && zRad < 2;
		if (stage == 3 || (stage == 4 && random.nextInt(4) == 0)) return (xRad == 2) != (zRad == 2) && sum < 4;

//		if (stage == 0) return sum < 2;
//		if (stage == 1) return xRad < 2 && zRad < 2;
//		if (stage == 2 || stage == 3) return (xRad == 2) != (zRad == 2) && sum < 4;
//		if (stage == 4 || (stage == 5 && random.nextInt(4) == 0)) return ((xRad == 3) != (zRad == 3) && sum < 5) || (sum == 4 && xRad * zRad == 4);

		return false;
	}

	protected int getTreeHeight(RandomSource random) {
		int i = random.nextInt(3) + 6;
		if (random.nextInt(12) == 0) i += 6;

		return i;
	}

	protected int getTreeRadiusForHeight(int i, int height, int radius, int y) {
		if (y <= height && y >= height - 5) return radius;
		return 0;
	}
}
