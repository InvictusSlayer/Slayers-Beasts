package net.invictusslayer.slayersbeasts.block.flammable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ModFlammableLeavesBlock extends LeavesBlock {
    private final int flammability;
    private final int fireSpreadSpeed;

    public ModFlammableLeavesBlock(Properties properties, int flammability, int fireSpreadSpeed) {
        super(properties);
        this.flammability = flammability;
        this.fireSpreadSpeed = fireSpreadSpeed;
    }

    public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return true;
    }

    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return flammability;
    }

    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return fireSpreadSpeed;
    }
}
