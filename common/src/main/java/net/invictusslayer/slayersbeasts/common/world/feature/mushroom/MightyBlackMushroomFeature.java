package net.invictusslayer.slayersbeasts.common.world.feature.mushroom;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;

public class MightyBlackMushroomFeature extends AbstractMightyMushroomFeature {
	public MightyBlackMushroomFeature(Codec<HugeMushroomFeatureConfiguration> codec) {
		super(codec);
	}

	protected void placeCap(LevelAccessor level, RandomSource random, BlockPos origin, HugeMushroomFeatureConfiguration config, int height, BlockPos.MutableBlockPos mutableBlockPos) {
		for (int y = height - 6; y <= height; ++y) {
			int stage = height - y;
			int radius = stage < 3 ? 1 : stage < 5 ? 3 : 4;

			for (int x = -radius; x <= radius + 1; ++x) {
				for (int z = -radius; z <= radius + 1; ++z) {
					if (isBlock(x, z, stage, random)) {
						mutableBlockPos.setWithOffset(origin, x, y, z);
						if (!level.getBlockState(mutableBlockPos).isSolidRender()) {
							boolean north = z <= 0;
							boolean south = z >= 0;
							boolean east = x >= 0;
							boolean west = x <= 0;

							BlockState state = config.capProvider.getState(random, origin).setValue(HugeMushroomBlock.DOWN, false).setValue(HugeMushroomBlock.WEST, west).setValue(HugeMushroomBlock.EAST, east).setValue(HugeMushroomBlock.NORTH, north).setValue(HugeMushroomBlock.SOUTH, south);
							setBlock(level, mutableBlockPos, state);
						}
					}
				}
			}
		}
	}

	private static boolean isBlock(int x, int z, int stage, RandomSource random) {
		int xRad = Math.min(Math.abs(x), Math.abs(x - 1));
		int zRad = Math.min(Math.abs(z), Math.abs(z - 1));
		int sum = xRad + zRad;

		if (stage == 0) return sum < 1;
		if (stage == 1 || stage == 2) return sum < 2;
		if (stage == 3) return sum < 3;
		if (stage == 4) return sum == 3;
		if (stage == 5 || (random.nextInt(4) == 0 && stage == 6)) return sum == 4 || xRad * zRad == 6;

		return false;
	}

	protected int getTreeRadiusForHeight(int radius, int height) {
		return height < 7 ? radius : 0;
	}
}
