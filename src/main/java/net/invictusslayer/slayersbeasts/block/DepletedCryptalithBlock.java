package net.invictusslayer.slayersbeasts.block;

import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public class DepletedCryptalithBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public DepletedCryptalithBlock(Properties pProperties) {
		super(pProperties);
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(FACING);
	}

	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		return defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
	}
}
