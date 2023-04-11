package net.invictusslayer.slayersbeasts.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class BaseAnthillExtension extends BlockEntity {
    private BlockPos parentNestPos;

    public BaseAnthillExtension(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    public BlockPos getParentNestPos() {
        return parentNestPos;
    }
    public void setParentNestPos(BlockPos parentNestPos) {
        this.parentNestPos = parentNestPos;
    }
}
