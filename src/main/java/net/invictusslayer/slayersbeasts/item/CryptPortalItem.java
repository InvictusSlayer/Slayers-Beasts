package net.invictusslayer.slayersbeasts.item;

import net.invictusslayer.slayersbeasts.block.DepletedCryptalithBlock;
import net.invictusslayer.slayersbeasts.block.InfusedCryptalithBlock;
import net.invictusslayer.slayersbeasts.block.SBBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public class CryptPortalItem extends Item {
    public CryptPortalItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos clickedPos = pContext.getClickedPos();
        BlockState blockState = level.getBlockState(clickedPos);
        if (blockState.is(SBBlocks.INFUSED_CRYPTALITH.get()) && !blockState.getValue(InfusedCryptalithBlock.ACTIVE)) {
            if (level.isClientSide) {
                return InteractionResult.SUCCESS;
            } else {
                BlockState state = blockState.setValue(InfusedCryptalithBlock.ACTIVE, true);
                Block.pushEntitiesUp(blockState, state, level, clickedPos);
                level.setBlock(clickedPos, state, 2);
                pContext.getItemInHand().shrink(1);
                level.levelEvent(1503, clickedPos, 0);
                BlockPattern.BlockPatternMatch patternMatch = InfusedCryptalithBlock.getOrCreatePortalShape().find(level, clickedPos);
                if (patternMatch != null) {
                    BlockPos pos = patternMatch.getFrontTopLeft().offset(-2, 0, -2);

                    for (int i = 0; i < 2; ++i) {
                        for (int j = 0; j < 2; ++j) {
                            level.setBlock(pos.offset(i, 0, j), SBBlocks.CRYPT_PORTAL.get().defaultBlockState(), 2);
                        }
                    }

                    level.setBlock(pos.offset(-1, 0, 0), SBBlocks.DEPLETED_CRYPTALITH.get().defaultBlockState().setValue(DepletedCryptalithBlock.FACING, Direction.WEST), 2);
                    level.setBlock(pos.offset(-1, 0, 1), SBBlocks.DEPLETED_CRYPTALITH.get().defaultBlockState().setValue(DepletedCryptalithBlock.FACING, Direction.WEST), 2);
                    level.setBlock(pos.offset(2, 0, 0), SBBlocks.DEPLETED_CRYPTALITH.get().defaultBlockState().setValue(DepletedCryptalithBlock.FACING, Direction.WEST), 2);
                    level.setBlock(pos.offset(2, 0, 1), SBBlocks.DEPLETED_CRYPTALITH.get().defaultBlockState().setValue(DepletedCryptalithBlock.FACING, Direction.WEST), 2);
                    level.setBlock(pos.offset(0, 0, -1), SBBlocks.DEPLETED_CRYPTALITH.get().defaultBlockState().setValue(DepletedCryptalithBlock.FACING, Direction.NORTH), 2);
                    level.setBlock(pos.offset(1, 0, -1), SBBlocks.DEPLETED_CRYPTALITH.get().defaultBlockState().setValue(DepletedCryptalithBlock.FACING, Direction.NORTH), 2);
                    level.setBlock(pos.offset(0, 0, 2), SBBlocks.DEPLETED_CRYPTALITH.get().defaultBlockState().setValue(DepletedCryptalithBlock.FACING, Direction.NORTH), 2);
                    level.setBlock(pos.offset(1, 0, 2), SBBlocks.DEPLETED_CRYPTALITH.get().defaultBlockState().setValue(DepletedCryptalithBlock.FACING, Direction.NORTH), 2);
                }

                return InteractionResult.CONSUME;
            }
        } else {
            return InteractionResult.PASS;
        }
    }
}
