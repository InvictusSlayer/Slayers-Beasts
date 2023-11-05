package net.invictusslayer.slayersbeasts.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SBSignBlockEntity extends SignBlockEntity {
	public SBSignBlockEntity(BlockPos pos, BlockState state) {
		super(SBBlockEntities.SIGN.get(), pos, state);
	}
}
