package net.invictusslayer.slayersbeasts.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class AnthillHatcheryBlockEntity extends BaseAnthillExtension {

    public AnthillHatcheryBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.ANTHILL_HATCHERY_BLOCK_ENTITY.get(), pPos, pBlockState);
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, AnthillHatcheryBlockEntity entity) {

    }
}
