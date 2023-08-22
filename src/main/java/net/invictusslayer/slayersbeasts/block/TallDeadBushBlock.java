package net.invictusslayer.slayersbeasts.block;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.IForgeShearable;

public class TallDeadBushBlock extends DoublePlantBlock implements IForgeShearable {
	public TallDeadBushBlock(Properties pProperties) {
		super(pProperties);
	}

	protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
		return pState.is(BlockTags.DEAD_BUSH_MAY_PLACE_ON);
	}
}
