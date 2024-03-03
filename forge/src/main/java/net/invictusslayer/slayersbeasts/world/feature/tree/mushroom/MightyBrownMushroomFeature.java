package net.invictusslayer.slayersbeasts.world.feature.tree.mushroom;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;

public class MightyBrownMushroomFeature extends AbstractMightyMushroomFeature {
	public MightyBrownMushroomFeature(Codec<HugeMushroomFeatureConfiguration> codec) {
		super(codec);
	}

	protected void placeCap(LevelAccessor level, RandomSource random, BlockPos origin, HugeMushroomFeatureConfiguration config, int height, BlockPos.MutableBlockPos mutableBlockPos) {
		for (int y = height - 2; y <= height; ++y) {
			int stage = height - y;
			int radius = stage == 1 ? 4 : 3;

			for (int x = -radius; x <= radius + 1; ++x) {
				for (int z = -radius; z <= radius + 1; ++z) {
					if (isBlock(x, z, stage)) {
						mutableBlockPos.setWithOffset(origin, x, y, z);
						if (!level.getBlockState(mutableBlockPos).isSolidRender(level, mutableBlockPos)) {
							boolean flag = stage < 2;
							boolean north = flag && z <= 0;
							boolean south = flag && z >= 0;
							boolean east = flag && x >= 0;
							boolean west = flag && x <= 0;

							BlockState state = config.capProvider.getState(random, origin).setValue(HugeMushroomBlock.DOWN, false).setValue(HugeMushroomBlock.WEST, west).setValue(HugeMushroomBlock.EAST, east).setValue(HugeMushroomBlock.NORTH, north).setValue(HugeMushroomBlock.SOUTH, south);
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

		if (stage == 0) return sum < 4 || (xRad == 2 && zRad == 2);
		if (stage == 1) return sum < 5 || xRad * zRad == 6;
		if (stage == 2) return sum < 3;

		return false;
	}

	protected int getTreeRadiusForHeight(int i, int height, int radius, int y) {
		if (y <= height && y >= height - 2) return radius;
		return 0;
	}
}
