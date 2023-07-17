package net.invictusslayer.slayersbeasts.block;

import net.invictusslayer.slayersbeasts.block.flammable.FlammableLeavesBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;

public class WillowLeavesBlock extends FlammableLeavesBlock implements BonemealableBlock {
    public WillowLeavesBlock(Properties properties) {
        super(properties, 60, 30);
    }

    public boolean isValidBonemealTarget(LevelReader pLevel, BlockPos pPos, BlockState pState, boolean pIsClient) {
        return pLevel.getBlockState(pPos.below()).isAir();
    }

    public boolean isBonemealSuccess(Level pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        return true;
    }

    public void performBonemeal(ServerLevel pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        pLevel.setBlock(pPos.below(), SBBlocks.WILLOW_BRANCH.get().defaultBlockState(), 2);
    }
}
