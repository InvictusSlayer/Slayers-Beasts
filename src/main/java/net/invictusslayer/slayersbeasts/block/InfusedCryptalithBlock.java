package net.invictusslayer.slayersbeasts.block;

import com.google.common.base.Predicates;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.pattern.BlockPatternBuilder;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;

public class InfusedCryptalithBlock extends Block {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty ACTIVE = BlockStateProperties.EYE;
    private static BlockPattern portalShape;

    public InfusedCryptalithBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(ACTIVE, false));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, ACTIVE);
    }

    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite()).setValue(ACTIVE, false);
    }

    public static BlockPattern getOrCreatePortalShape() {
        if (portalShape == null) {
            portalShape = BlockPatternBuilder.start().aisle("?vv?", ">??<", ">??<", "?^^?")
                    .where('?', BlockInWorld.hasState(BlockStatePredicate.ANY))
                    .where('^', BlockInWorld.hasState(BlockStatePredicate.forBlock(SBBlocks.INFUSED_CRYPTALITH.get())
                            .where(ACTIVE, Predicates.equalTo(true)).where(FACING, Predicates.equalTo(Direction.SOUTH))))
                    .where('>', BlockInWorld.hasState(BlockStatePredicate.forBlock(SBBlocks.INFUSED_CRYPTALITH.get())
                            .where(ACTIVE, Predicates.equalTo(true)).where(FACING, Predicates.equalTo(Direction.WEST))))
                    .where('v', BlockInWorld.hasState(BlockStatePredicate.forBlock(SBBlocks.INFUSED_CRYPTALITH.get())
                            .where(ACTIVE, Predicates.equalTo(true)).where(FACING, Predicates.equalTo(Direction.NORTH))))
                    .where('<', BlockInWorld.hasState(BlockStatePredicate.forBlock(SBBlocks.INFUSED_CRYPTALITH.get())
                            .where(ACTIVE, Predicates.equalTo(true)).where(FACING, Predicates.equalTo(Direction.EAST)))).build();
        }

        return portalShape;
    }

    @SuppressWarnings("deprecation")
    public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
        return false;
    }
}
