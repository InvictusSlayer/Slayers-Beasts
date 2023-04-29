package net.invictusslayer.slayersbeasts.block;

import net.invictusslayer.slayersbeasts.entity.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;

public class CajoleLeavesBlock extends LeavesBlock {
    public CajoleLeavesBlock(Properties properties) {
        super(properties);
    }

    private void spawnInfestation(ServerLevel pLevel, BlockPos pPos) {
        int randInt = RandomSource.create().nextInt(5);
        Mob mob;
        if (randInt < 2) {
            if (randInt == 0) {
                mob = ModEntities.WORKER_ANT.get().create(pLevel);
            } else {
                mob = ModEntities.MANTIS.get().create(pLevel);
            }
            mob.moveTo((double) pPos.getX() + 0.5D, (double) pPos.getY(), (double) pPos.getZ() + 0.5D, 0.0F, 0.0F);
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

    @Override
    public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 60;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 30;
    }
}
