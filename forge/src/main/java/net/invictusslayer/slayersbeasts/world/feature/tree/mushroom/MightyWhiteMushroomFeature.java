package net.invictusslayer.slayersbeasts.world.feature.tree.mushroom;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;

public class MightyWhiteMushroomFeature extends AbstractMightyMushroomFeature {
	public MightyWhiteMushroomFeature(Codec<HugeMushroomFeatureConfiguration> codec) {
		super(codec);
	}

	protected void placeStem(LevelAccessor level, RandomSource random, BlockPos pos, HugeMushroomFeatureConfiguration config, int maxHeight, BlockPos.MutableBlockPos mutableBlockPos) {
		for (int i = 0; i < maxHeight - 2; ++i) {
			mutableBlockPos.set(pos).move(Direction.UP, i);
			if (!level.getBlockState(mutableBlockPos).isSolidRender(level, mutableBlockPos)) {
				setBlock(level, mutableBlockPos, config.stemProvider.getState(random, pos));
				setBlock(level, mutableBlockPos.south(), config.stemProvider.getState(random, pos));
				setBlock(level, mutableBlockPos.east(), config.stemProvider.getState(random, pos));
				setBlock(level, mutableBlockPos.south().east(), config.stemProvider.getState(random, pos));
			}
		}
	}

	protected void placeCap(LevelAccessor level, RandomSource random, BlockPos origin, HugeMushroomFeatureConfiguration config, int height, BlockPos.MutableBlockPos mutableBlockPos) {
		int i = random.nextInt(4);
		int x1 = i < 2 ? 0 : 1;
		int x2 = i < 2 ? -1 : 2;
		int z1 = i % 2 == 0 ? 0 : 1;
		int z2 = i % 2 == 0 ? -1 : 2;

		for (int y = height - 8; y <= height; ++y) {
			int stage = height - y;
			int radius = stage < 6 ? 1 : stage == 6 ? 2 : 3;

			for (int x = -radius; x <= radius + 1; ++x) {
				for (int z = -radius; z <= radius + 1; ++z) {
					if (isBlock(x, z, stage)) {
						mutableBlockPos.setWithOffset(origin, x, y, z);
						if (!level.getBlockState(mutableBlockPos).isSolidRender(level, mutableBlockPos)) {
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
		if (!level.getBlockState(mutableBlockPos).isSolidRender(level, mutableBlockPos)) {
			setBlock(level, mutableBlockPos, state);
		}
	}

	private static boolean isBlock(int x, int z, int stage) {
		int xRad = Math.min(Math.abs(x), Math.abs(x - 1));
		int zRad = Math.min(Math.abs(z), Math.abs(z - 1));
		int sum = xRad + zRad;

		if (stage == 2) return sum < 1;
		if (stage == 3 || stage == 4) return sum < 2;
		if (stage == 5) return sum < 3;
		if (stage == 6) return sum < 4;
		if (stage == 7) return sum == 3 || (xRad == 2 && zRad == 2);
		if (stage == 8) return (sum == 4 && xRad * zRad != 4) || xRad * zRad == 6;

		return false;
	}

	protected int getTreeRadiusForHeight(int i, int height, int radius, int y) {
		if (y <= height && y >= height - 8) return radius;
		return 0;
	}
}
