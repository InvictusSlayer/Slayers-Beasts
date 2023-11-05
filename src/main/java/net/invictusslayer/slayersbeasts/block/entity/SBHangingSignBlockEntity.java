package net.invictusslayer.slayersbeasts.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SBHangingSignBlockEntity extends SignBlockEntity {
	public SBHangingSignBlockEntity(BlockPos pos, BlockState state) {
		super(SBBlockEntities.HANGING_SIGN.get(), pos, state);
	}

	public int getTextLineHeight() {
		return 9;
	}

	public int getMaxTextLineWidth() {
		return 60;
	}
}
