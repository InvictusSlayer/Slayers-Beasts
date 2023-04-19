package net.invictusslayer.slayersbeasts.block;

import net.invictusslayer.slayersbeasts.entity.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class OothecaBlock extends Block {
    public OothecaBlock(Properties properties) {
        super(properties);
    }

    private void spawnInfestation(ServerLevel pLevel, BlockPos pPos) {
        Mob mob = ModEntities.MANTIS_ENTITY.get().create(pLevel);
        if (mob != null) {
            mob.moveTo((double) pPos.getX() + 0.5D, pPos.getY(), (double) pPos.getZ() + 0.5D, 0.0F, 0.0F);
            pLevel.addFreshEntity(mob);
            mob.spawnAnim();
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void spawnAfterBreak(BlockState pState, ServerLevel pLevel, BlockPos pPos, ItemStack pStack, boolean pDropExperience) {
        this.spawnInfestation(pLevel, pPos);
    }

    public void wasExploded(Level pLevel, BlockPos pPos, Explosion pExplosion) {
        if (pLevel instanceof ServerLevel) {
            this.spawnInfestation((ServerLevel)pLevel, pPos);
        }
    }

}
