package net.invictusslayer.slayersbeasts.world.feature.mushroom;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.AbstractHugeMushroomFeature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;

public class HugeWhiteMushroomFeature extends AbstractHugeMushroomFeature {
	public HugeWhiteMushroomFeature(Codec<HugeMushroomFeatureConfiguration> codec) {
		super(codec);
	}

	protected void placeTrunk(LevelAccessor level, RandomSource random, BlockPos pos, HugeMushroomFeatureConfiguration config, int maxHeight, BlockPos.MutableBlockPos mutableBlockPos) {
		for (int i = 0; i < maxHeight - 1; ++i) {
			mutableBlockPos.set(pos).move(Direction.UP, i);
			if (!level.getBlockState(mutableBlockPos).isSolidRender()) {
				setBlock(level, mutableBlockPos, config.stemProvider.getState(random, pos).setValue(HugeMushroomBlock.UP, false).setValue(HugeMushroomBlock.DOWN, false));
			}
		}
	}

	protected void makeCap(LevelAccessor level, RandomSource random, BlockPos origin, int height, BlockPos.MutableBlockPos mutableBlockPos, HugeMushroomFeatureConfiguration config) {
		Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);

		for (int y = height - 5; y <= height; ++y) {
			int stage = height - y;
			int radius = stage == 5 ? 2 : 1;

			for (int x = -radius; x <= radius; ++x) {
				for (int z = -radius; z <= radius; ++z) {
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
				mutableBlockPos.setWithOffset(origin, 0, y, 0).move(direction);
				if (!level.getBlockState(mutableBlockPos).isSolidRender()) {
					BlockState state = config.capProvider.getState(random, origin);
					setBlock(level, mutableBlockPos, state);
				}
			}
		}
	}

	private static boolean isBlock(int x, int z, int stage) {
		int xRad = Math.abs(x);
		int zRad = Math.abs(z);
		int sum = xRad + zRad;

		if (stage == 1) return sum == 0;
		if (stage == 2 || stage == 3) return sum < 2;
		if (stage == 4) return xRad < 2 && zRad < 2;
		if (stage == 5) return  (xRad == 2) != (zRad == 2) && sum < 4;

		return false;
	}

	protected int getTreeHeight(RandomSource random) {
		int i = random.nextInt(3) + 7;
		if (random.nextInt(12) == 0) i += 6;

		return i;
	}

	protected int getTreeRadiusForHeight(int j, int height, int radius, int y) {
		if (y <= height && y >= height - 5) return radius;
		return 0;
	}
}
