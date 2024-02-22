package net.invictusslayer.slayersbeasts.world.feature.icicle;

import net.invictusslayer.slayersbeasts.block.IcicleBlock;
import net.invictusslayer.slayersbeasts.block.SBBlocks;
import net.invictusslayer.slayersbeasts.datagen.tag.SBTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DripstoneThickness;

import java.util.function.Consumer;

public class IcicleUtils {
	protected static double getIcicleHeight(double radius, double maxRadius, double scale, double minRadius) {
		if (radius < minRadius) {
			radius = minRadius;
		}

		double d1 = radius / maxRadius * 0.384D;
		double d2 = scale * (0.75D * Math.pow(d1, 4D / 3D) - Math.pow(d1, 2D / 3D) - Math.log(d1) / 3D);
		return Math.max(d2, 0.0D) / 0.384D * maxRadius;
	}

	protected static boolean isBaseEmbeddedInStone(WorldGenLevel level, BlockPos pos, int radius) {
		if (isEmptyOrWaterOrLava(level, pos)) return false;

		float i = 6.0F / radius;

		for (float v = 0.0F; v < Mth.PI * 2F; v += i) {
			int x = (int) (Mth.cos(v) * radius);
			int z = (int) (Mth.sin(v) * radius);
			if (isEmptyOrWaterOrLava(level, pos.offset(x, 0, z))) {
				return false;
			}
		}

		return true;

	}

	protected static boolean isEmptyOrWater(LevelAccessor level, BlockPos pos) {
		return level.isStateAtPosition(pos, IcicleUtils::isEmptyOrWater);
	}

	protected static boolean isEmptyOrWaterOrLava(LevelAccessor level, BlockPos pos) {
		return level.isStateAtPosition(pos, IcicleUtils::isEmptyOrWaterOrLava);
	}

	protected static void buildBaseToTipColumn(Direction direction, int height, boolean mergeTip, Consumer<BlockState> consumer) {
		if (height >= 3) {
			consumer.accept(createIcicle(direction, DripstoneThickness.BASE));

			for (int i = 0; i < height - 3; ++i) {
				consumer.accept(createIcicle(direction, DripstoneThickness.MIDDLE));
			}
		}

		if (height >= 2) {
			consumer.accept(createIcicle(direction, DripstoneThickness.FRUSTUM));
		}

		if (height >= 1) {
			consumer.accept(createIcicle(direction, mergeTip ? DripstoneThickness.TIP_MERGE : DripstoneThickness.TIP));
		}

	}

	protected static void growIcicle(LevelAccessor level, BlockPos pos, Direction direction, int height, boolean mergeTip) {
		if (isIcicleBase(level.getBlockState(pos.relative(direction.getOpposite())))) {
			BlockPos.MutableBlockPos mutableBlockPos = pos.mutable();
			buildBaseToTipColumn(direction, height, mergeTip, state -> {
				if (state.is(SBBlocks.ICICLE.get())) {
					state = state.setValue(IcicleBlock.WATERLOGGED, level.isWaterAt(mutableBlockPos));
				}

				level.setBlock(mutableBlockPos, state, 2);
				mutableBlockPos.move(direction);
			});
		}
	}

	protected static boolean placeIceIfPossible(LevelAccessor level, BlockPos pos) {
		BlockState blockstate = level.getBlockState(pos);
		if (blockstate.is(SBTags.Blocks.ICICLE_REPLACEABLE)) {
			level.setBlock(pos, Blocks.PACKED_ICE.defaultBlockState(), 2);
			return true;
		} else {
			return false;
		}
	}

	private static BlockState createIcicle(Direction direction, DripstoneThickness thickness) {
		return SBBlocks.ICICLE.get().defaultBlockState().setValue(IcicleBlock.TIP_DIRECTION, direction).setValue(IcicleBlock.THICKNESS, thickness);
	}

	public static boolean isIcicleBaseOrLava(BlockState state) {
		return isIcicleBase(state) || state.is(Blocks.LAVA);
	}

	public static boolean isIcicleBase(BlockState state) {
		return state.is(Blocks.PACKED_ICE) || state.is(SBTags.Blocks.ICICLE_REPLACEABLE);
	}

	public static boolean isEmptyOrWater(BlockState state) {
		return state.isAir() || state.is(Blocks.WATER);
	}

	public static boolean isNeitherEmptyNorWater(BlockState state) {
		return !isEmptyOrWater(state);
	}

	public static boolean isEmptyOrWaterOrLava(BlockState state) {
		return state.isAir() || state.is(Blocks.WATER) || state.is(Blocks.LAVA);
	}
}
