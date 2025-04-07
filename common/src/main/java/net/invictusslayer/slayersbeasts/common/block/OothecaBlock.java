package net.invictusslayer.slayersbeasts.common.block;

import net.invictusslayer.slayersbeasts.common.init.SBEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class OothecaBlock extends Block {
	public OothecaBlock(Properties properties) {
		super(properties);
	}

	private void spawnInfestation(ServerLevel level, BlockPos pos) {
		Mob mob = SBEntities.MANTIS.get().create(level, EntitySpawnReason.TRIGGERED);
		if (mob != null) {
			mob.moveTo((double) pos.getX() + 0.5D, pos.getY(), (double) pos.getZ() + 0.5D, 0.0F, 0.0F);
			level.addFreshEntity(mob);
			mob.spawnAnim();
		}
	}

	public void spawnAfterBreak(BlockState state, ServerLevel pLevel, BlockPos pPos, ItemStack pStack, boolean pDropExperience) {
		spawnInfestation(pLevel, pPos);
	}

	public void wasExploded(ServerLevel level, BlockPos pos, Explosion explosion) {
		spawnInfestation(level, pos);
	}
}
