package net.invictusslayer.slayersbeasts.block.custom;

import net.invictusslayer.slayersbeasts.entity.MantisEntity;
import net.invictusslayer.slayersbeasts.init.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class CajoleLeavesBlock extends Block {
    public CajoleLeavesBlock(Properties properties) {
        super(properties);
    }

    private void spawnInfestation(ServerLevel pLevel, BlockPos pPos) {
        int randInt = RANDOM.nextInt(5);
        Mob mob = null;
        if (randInt == 0) {
            mob = ModEntities.MANTIS_ENTITY.get().create(pLevel);
        }
        if (randInt == 1) {
            mob = ModEntities.VENUS_FLYTRAP_ENTITY.get().create(pLevel);
        }
        if (mob != null) {
            mob.moveTo((double) pPos.getX() + 0.5D, (double) pPos.getY(), (double) pPos.getZ() + 0.5D, 0.0F, 0.0F);
            pLevel.addFreshEntity(mob);
            mob.spawnAnim();
        }
    }

    @Override
    public void spawnAfterBreak(BlockState pState, ServerLevel pLevel, BlockPos pPos, ItemStack pStack) {
        if (pLevel.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS) && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, pStack) == 0) {
            this.spawnInfestation(pLevel, pPos);
        }
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
