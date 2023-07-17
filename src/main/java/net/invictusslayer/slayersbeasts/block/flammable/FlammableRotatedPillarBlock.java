package net.invictusslayer.slayersbeasts.block.flammable;

import net.invictusslayer.slayersbeasts.block.SBBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;

import javax.annotation.Nullable;

public class FlammableRotatedPillarBlock extends RotatedPillarBlock {
    public FlammableRotatedPillarBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 5;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if (context.getItemInHand().getItem() instanceof AxeItem) {
            if (state.is(SBBlocks.ASPEN_LOG.get())) {
                return SBBlocks.STRIPPED_ASPEN_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(SBBlocks.ASPEN_WOOD.get())) {
                return SBBlocks.STRIPPED_ASPEN_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(SBBlocks.CAJOLE_LOG.get())) {
                return SBBlocks.STRIPPED_CAJOLE_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(SBBlocks.CAJOLE_WOOD.get())) {
                return SBBlocks.STRIPPED_CAJOLE_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(SBBlocks.DESERT_OAK_LOG.get())) {
                return SBBlocks.STRIPPED_DESERT_OAK_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(SBBlocks.DESERT_OAK_WOOD.get())) {
                return SBBlocks.STRIPPED_DESERT_OAK_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(SBBlocks.EUCALYPTUS_LOG.get())) {
                return SBBlocks.STRIPPED_EUCALYPTUS_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(SBBlocks.EUCALYPTUS_WOOD.get())) {
                return SBBlocks.STRIPPED_EUCALYPTUS_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(SBBlocks.KAPOK_LOG.get())) {
                return SBBlocks.STRIPPED_KAPOK_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(SBBlocks.KAPOK_WOOD.get())) {
                return SBBlocks.STRIPPED_KAPOK_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(SBBlocks.REDWOOD_LOG.get())) {
                return SBBlocks.STRIPPED_REDWOOD_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(SBBlocks.REDWOOD_WOOD.get())) {
                return SBBlocks.STRIPPED_REDWOOD_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }
        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
