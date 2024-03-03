package net.invictusslayer.slayersbeasts.block;

import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WillowBranchBlock extends GrowingPlantHeadBlock {
    protected static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

	protected WillowBranchBlock(Properties properties) {
		super(properties, Direction.DOWN, SHAPE, false, 0.1D);
	}

	public BlockState getStateForPlacement(LevelAccessor level) {
		return this.defaultBlockState().setValue(AGE, level.getRandom().nextInt(10));
	}

	protected int getBlocksToGrowWhenBonemealed(RandomSource random) {
		return 1;
	}

	protected boolean canGrowInto(BlockState state) {
		return state.isAir();
	}

	protected Block getBodyBlock() {
		return SBBlocks.WILLOW_BRANCH_PLANT.get();
	}

	public BlockState getMaxAgeState(BlockState state) {
		return state.setValue(AGE, 10);
	}

	public boolean isMaxAge(BlockState state) {
		return state.getValue(AGE) == 10;
	}
}
