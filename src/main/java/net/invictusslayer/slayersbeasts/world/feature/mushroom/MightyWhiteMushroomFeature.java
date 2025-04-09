package net.invictusslayer.slayersbeasts.world.feature.mushroom;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;

public class MightyWhiteMushroomFeature extends AbstractMightyMushroomFeature {
	public MightyWhiteMushroomFeature(Codec<HugeMushroomFeatureConfiguration> codec) {
		super(codec);
	}

	protected void placeCap(LevelAccessor level, RandomSource random, BlockPos origin, HugeMushroomFeatureConfiguration config, int height, BlockPos.MutableBlockPos mutableBlockPos) {
		int i = random.nextInt(4);
		int x1 = i < 2 ? 0 : 1;
		int x2 = i < 2 ? -1 : 2;
		int z1 = i % 2 == 0 ? 0 : 1;
		int z2 = i % 2 == 0 ? -1 : 2;

		for (int y = height - 8; y <= height; ++y) {
			int stage = height - y;
			int radius = stage < 6 ? 1 : 3;

			for (int x = -radius; x <= radius + 1; ++x) {
				for (int z = -radius; z <= radius + 1; ++z) {
					if (isBlock(x, z, stage)) {
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

			if (stage == 0) {
				BlockState state = config.capProvider.getState(random, origin);
				setBlockIfEmpty(level, mutableBlockPos.setWithOffset(origin, x2, y, z2), state);
			}
			if (stage == 1) {
				BlockState state = config.capProvider.getState(random, origin);
				setBlockIfEmpty(level, mutableBlockPos.setWithOffset(origin, x1, y, z1), state);
				setBlockIfEmpty(level, mutableBlockPos.setWithOffset(origin, x1, y, z2), state);
				setBlockIfEmpty(level, mutableBlockPos.setWithOffset(origin, x2, y, z1), state);
			}
		}
	}

	private void setBlockIfEmpty(LevelAccessor level, BlockPos.MutableBlockPos mutableBlockPos, BlockState state) {
		if (!level.getBlockState(mutableBlockPos).isSolidRender()) {
			setBlock(level, mutableBlockPos, state);
		}
	}

	private static boolean isBlock(int x, int z, int stage) {
		int xRad = Math.min(Math.abs(x), Math.abs(x - 1));
		int zRad = Math.min(Math.abs(z), Math.abs(z - 1));
		int sum = xRad + zRad;

		if (stage == 2 || stage == 3) return sum < 1;
		if (stage == 4 || stage == 5) return sum < 2;
		if (stage == 6) return sum == 2;
		if (stage == 7) return sum == 3 || (xRad == 2 && zRad == 2);

		return false;
	}

	protected int getTreeRadiusForHeight(int radius, int height) {
		return height < 8 ? radius : 0;
	}
}
