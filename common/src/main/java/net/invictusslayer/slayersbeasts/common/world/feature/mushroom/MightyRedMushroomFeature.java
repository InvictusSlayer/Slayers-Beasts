package net.invictusslayer.slayersbeasts.common.world.feature.mushroom;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;

public class MightyRedMushroomFeature extends AbstractMightyMushroomFeature {
	public MightyRedMushroomFeature(Codec<HugeMushroomFeatureConfiguration> codec) {
		super(codec);
	}

	protected void placeCap(LevelAccessor level, RandomSource random, BlockPos origin, HugeMushroomFeatureConfiguration config, int height, BlockPos.MutableBlockPos mutableBlockPos) {
		for (int y = height - 6; y <= height; ++y) {
			int stage = height - y;
			int radius = stage < 2 ? 2 : 3;

			for (int x = -radius; x <= radius + 1; ++x) {
				for (int z = -radius; z <= radius + 1; ++z) {
					if (isBlock(x, z, stage)) {
						mutableBlockPos.setWithOffset(origin, x, y, z);
						if (!level.getBlockState(mutableBlockPos).isSolidRender(level, mutableBlockPos)) {
							boolean north = z <= 0;
							boolean south = z >= 0;
							boolean east = x >= 0;
							boolean west = x <= 0;

							BlockState state = config.capProvider.getState(random, origin).setValue(HugeMushroomBlock.DOWN, stage > 4).setValue(HugeMushroomBlock.WEST, west).setValue(HugeMushroomBlock.EAST, east).setValue(HugeMushroomBlock.NORTH, north).setValue(HugeMushroomBlock.SOUTH, south);
							setBlock(level, mutableBlockPos, state);
						}
					}
				}
			}
		}
	}

	private static boolean isBlock(int x, int z, int stage) {
		int xRad = Math.min(Math.abs(x), Math.abs(x - 1));
		int zRad = Math.min(Math.abs(z), Math.abs(z - 1));
		int sum = xRad + zRad;

		if (stage == 0) return sum < 3;
		if (stage == 1) return sum < 4;
		if (stage == 2) return sum == 3;
		if (stage == 3) return sum == 3 || (xRad == 2 && zRad == 2);
		if (stage == 4 || stage == 5) return sum == 4 || (sum == 3 && xRad * zRad == 0);
		if (stage == 6) return sum == 3 && xRad * zRad == 0;

		return false;
	}

	protected int getTreeRadiusForHeight(int radius, int height) {
		return height < 7 ? radius : 0;
	}
}
