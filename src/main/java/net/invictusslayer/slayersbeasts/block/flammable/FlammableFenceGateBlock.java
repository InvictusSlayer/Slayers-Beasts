package net.invictusslayer.slayersbeasts.block.flammable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.BlockState;

public class FlammableFenceGateBlock extends FenceGateBlock {
    int flammability;
    int fireSpreadSpeed;

    public FlammableFenceGateBlock(Properties properties, int flammability, int fireSpreadSpeed) {
        super(properties, SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN);
        this.flammability = flammability;
        this.fireSpreadSpeed = fireSpreadSpeed;
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return flammability;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return fireSpreadSpeed;
    }
}
