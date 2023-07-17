package net.invictusslayer.slayersbeasts.block;

import net.invictusslayer.slayersbeasts.block.flammable.FlammableLeavesBlock;
import net.invictusslayer.slayersbeasts.entity.SBEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class CajoleLeavesBlock extends FlammableLeavesBlock {
    public CajoleLeavesBlock(Properties properties) {
        super(properties, 60, 30);
    }

    private void spawnInfestation(ServerLevel pLevel, BlockPos pPos) {
        int randInt = RandomSource.create().nextInt(5);
        Mob mob = SBEntities.MANTIS.get().create(pLevel);
        if (randInt < 2) {
            if (randInt == 0) {
                mob = SBEntities.WORKER_ANT.get().create(pLevel);
            }
            assert mob != null;
            mob.moveTo((double) pPos.getX() + 0.5D, pPos.getY(), (double) pPos.getZ() + 0.5D, 0.0F, 0.0F);
            pLevel.addFreshEntity(mob);
            mob.spawnAnim();
        }
    }

    @SuppressWarnings("deprecation")
    public void spawnAfterBreak(BlockState pState, ServerLevel pLevel, BlockPos pPos, ItemStack pStack, boolean pDropExperience) {
        this.spawnInfestation(pLevel, pPos);
    }

    public void wasExploded(Level pLevel, BlockPos pPos, Explosion pExplosion) {
        if (pLevel instanceof ServerLevel) {
            this.spawnInfestation((ServerLevel)pLevel, pPos);
        }
    }
}
