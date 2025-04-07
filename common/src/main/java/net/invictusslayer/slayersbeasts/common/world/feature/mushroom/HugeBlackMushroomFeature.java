package net.invictusslayer.slayersbeasts.common.world.feature.mushroom;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
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

	protected void makeCap(LevelAccessor level, RandomSource random, BlockPos pos, int height, BlockPos.MutableBlockPos mutableBlockPos, HugeMushroomFeatureConfiguration config) {
		for (int y = height - 6; y <= height; ++y) {
			int stage = height - y;
			int radius = stage < 2 ? 1 : 3;

			for (int x = -radius; x <= radius; ++x) {
				for (int z = -radius; z <= radius; ++z) {
					if (isBlock(x, z, stage, random)) {
						mutableBlockPos.setWithOffset(pos, x, y, z);
						if (!level.getBlockState(mutableBlockPos).isSolidRender()) {
							boolean north = z <= 0;
							boolean south = z >= 0;
							boolean east = x >= 0;
							boolean west = x <= 0;

							BlockState state = config.capProvider.getState(random, pos).setValue(HugeMushroomBlock.DOWN, false).setValue(HugeMushroomBlock.WEST, west).setValue(HugeMushroomBlock.EAST, east).setValue(HugeMushroomBlock.NORTH, north).setValue(HugeMushroomBlock.SOUTH, south);
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
