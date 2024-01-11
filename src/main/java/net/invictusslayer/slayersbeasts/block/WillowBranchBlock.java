package net.invictusslayer.slayersbeasts.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WillowBranchBlock extends GrowingPlantHeadBlock {
    public static final MapCodec<WillowBranchBlock> CODEC = simpleCodec(WillowBranchBlock::new);
    protected static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    protected WillowBranchBlock(Properties pProperties) {
        super(pProperties, Direction.DOWN, SHAPE, false, 0.1D);
    }

    protected MapCodec<? extends GrowingPlantHeadBlock> codec() {
        return CODEC;
    }

    public BlockState getStateForPlacement(LevelAccessor pLevel) {
        return this.defaultBlockState().setValue(AGE, pLevel.getRandom().nextInt(10));
    }

    protected int getBlocksToGrowWhenBonemealed(RandomSource pRandom) {
        return 1;
    }

    protected boolean canGrowInto(BlockState pState) {
        return pState.isAir();
    }

    protected Block getBodyBlock() {
        return SBBlocks.WILLOW_BRANCH_PLANT.get();
    }

    public BlockState getMaxAgeState(BlockState pState) {
        return pState.setValue(AGE, 10);
    }

    public boolean isMaxAge(BlockState pState) {
        return pState.getValue(AGE) == 10;
    }
}
