package net.invictusslayer.slayersbeasts.common.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class BaseAnthillBlockEntity extends BlockEntity {
	private BlockPos parentNestPos;

	public BaseAnthillBlockEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
		super(pType, pPos, pBlockState);
	}

	protected void saveAdditional(CompoundTag pTag) {
		super.saveAdditional(pTag);
		pTag.put("ParentNestPos", NbtUtils.writeBlockPos(getParentNestPos()));
	}

	public void load(CompoundTag pTag) {
		super.load(pTag);
		setParentNestPos(NbtUtils.readBlockPos(pTag.getCompound("ParentNestPos")));
	}

	public BlockPos getParentNestPos() {
		return parentNestPos;
	}
	public void setParentNestPos(BlockPos parentNestPos) {
		this.parentNestPos = parentNestPos;
	}
}
