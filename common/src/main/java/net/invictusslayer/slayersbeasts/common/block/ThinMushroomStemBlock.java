package net.invictusslayer.slayersbeasts.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ThinMushroomStemBlock extends Block {
	private static final VoxelShape SHAPE = Block.box(4, 0, 4, 12, 16, 12);

	public ThinMushroomStemBlock(Properties properties) {
		super(properties);
	}

	@SuppressWarnings("deprecation")
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}
}
