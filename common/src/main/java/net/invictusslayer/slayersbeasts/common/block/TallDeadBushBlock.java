package net.invictusslayer.slayersbeasts.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class TallDeadBushBlock extends DoublePlantBlock {
	private static final VoxelShape UPPER = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 14.0D, 14.0D);
	private static final VoxelShape LOWER = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);

	public TallDeadBushBlock(Properties properties) {
		super(properties);
	}

	protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
		return state.is(BlockTags.DEAD_BUSH_MAY_PLACE_ON);
	}

	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return state.getValue(DoublePlantBlock.HALF) == DoubleBlockHalf.LOWER ? LOWER : UPPER;
	}
}
