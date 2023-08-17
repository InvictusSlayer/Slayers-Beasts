package net.invictusslayer.slayersbeasts.item;

import net.invictusslayer.slayersbeasts.block.CryptPortalFrameBlock;
import net.invictusslayer.slayersbeasts.block.SBBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.pattern.BlockPattern;

public class CryptPortalItem extends Item {
    public CryptPortalItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos clickedPos = pContext.getClickedPos();
        BlockState blockState = level.getBlockState(clickedPos);
        if (blockState.is(SBBlocks.RUNIC_CRYPTALITH.get()) && !blockState.getValue(CryptPortalFrameBlock.ACTIVE)) {
            if (level.isClientSide) {
                return InteractionResult.SUCCESS;
            } else {
                BlockState state = blockState.setValue(CryptPortalFrameBlock.ACTIVE, true);
                Block.pushEntitiesUp(blockState, state, level, clickedPos);
                level.setBlock(clickedPos, state, 2);
                pContext.getItemInHand().shrink(1);
                level.levelEvent(1503, clickedPos, 0);
                BlockPattern.BlockPatternMatch patternMatch = CryptPortalFrameBlock.getOrCreatePortalShape().find(level, clickedPos);
                if (patternMatch != null) {
                    BlockPos pos = patternMatch.getFrontTopLeft().offset(-2, 0, -2);

                    for (int i = 0; i < 2; ++i) {
                        for (int j = 0; j < 2; ++j) {
                            level.setBlock(pos.offset(i, 0, j), SBBlocks.CRYPT_PORTAL.get().defaultBlockState(), 2);
                        }
                    }
                }

                return InteractionResult.CONSUME;
            }
        } else {
            return InteractionResult.PASS;
        }
    }
}
