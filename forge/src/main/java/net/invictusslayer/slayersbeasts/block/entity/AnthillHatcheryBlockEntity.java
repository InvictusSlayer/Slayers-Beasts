package net.invictusslayer.slayersbeasts.block.entity;

import net.invictusslayer.slayersbeasts.block.AnthillHatcheryBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class AnthillHatcheryBlockEntity extends BaseAnthillBlockEntity {
	public AnthillHatcheryBlockEntity(BlockPos pos, BlockState state) {
		super(SBBlockEntities.ANTHILL_HATCHERY_BLOCK_ENTITY.get(), pos, state);
	}

	public static int getLarvalStage(BlockState state) {
		return state.getValue(AnthillHatcheryBlock.LARVAL_STAGE);
	}
	public static int getLarva(BlockState state) {
		return state.getValue(AnthillHatcheryBlock.LARVA);
	}

	public static void serverTick(Level level, BlockPos pos, BlockState state, AnthillHatcheryBlockEntity entity) {
		if (entity.getParentNestPos() == null) {

		}
	}

	public void storeEgg(Level level, BlockPos pos) {
		int larva = getLarva(getBlockState());
		int larvalStage = getLarvalStage(getBlockState());
		if (larvalStage == 0) {
			level.setBlockAndUpdate(pos, getBlockState().setValue(AnthillHatcheryBlock.LARVAL_STAGE, 1));
		} else if (larva < 3) {
			level.setBlockAndUpdate(pos, getBlockState().setValue(AnthillHatcheryBlock.LARVA, larva + 1));
		}
	}
}
