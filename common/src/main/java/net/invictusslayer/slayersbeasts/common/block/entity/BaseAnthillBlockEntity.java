package net.invictusslayer.slayersbeasts.common.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
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

	protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
		super.saveAdditional(tag, registries);
		tag.put("ParentNestPos", NbtUtils.writeBlockPos(getParentNestPos()));
	}

	public void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
		super.loadAdditional(tag, registries);
		setParentNestPos(NbtUtils.readBlockPos(tag, "ParentNestPos").orElse(null));
	}

	public BlockPos getParentNestPos() {
		return parentNestPos;
	}
	public void setParentNestPos(BlockPos parentNestPos) {
		this.parentNestPos = parentNestPos;
	}
}
