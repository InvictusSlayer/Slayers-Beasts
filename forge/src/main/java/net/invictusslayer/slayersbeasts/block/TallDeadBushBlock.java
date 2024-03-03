package net.invictusslayer.slayersbeasts.block;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.IForgeShearable;
import net.minecraftforge.common.PlantType;

public class TallDeadBushBlock extends DoublePlantBlock implements IForgeShearable {
	private static final VoxelShape UPPER = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 14.0D, 14.0D);
	private static final VoxelShape LOWER = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);

	public TallDeadBushBlock(Properties properties) {
		super(properties);
	}

	public PlantType getPlantType(BlockGetter level, BlockPos pos) {
		return PlantType.DESERT;
	}

	protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
		return state.is(BlockTags.DEAD_BUSH_MAY_PLACE_ON);
	}

	@SuppressWarnings("deprecation")
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return state.getValue(DoublePlantBlock.HALF) == DoubleBlockHalf.LOWER ? LOWER : UPPER;
	}
}
