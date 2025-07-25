package net.invictusslayer.slayersbeasts.block;

import net.invictusslayer.slayersbeasts.init.SBEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;

public class CajoleLeavesBlock extends LeavesBlock {
	public CajoleLeavesBlock(Properties properties) {
		super(properties);
	}

	private void spawnInfestation(ServerLevel level, BlockPos pos) {
		int randInt = RandomSource.create().nextInt(5);
		Mob mob = SBEntities.MANTIS.get().create(level, EntitySpawnReason.TRIGGERED);
		if (randInt < 2) {
			if (randInt == 0) {
				mob = SBEntities.ANT_WORKER.get().create(level, EntitySpawnReason.TRIGGERED);
			}
			assert mob != null;
			mob.moveTo((double) pos.getX() + 0.5D, pos.getY(), (double) pos.getZ() + 0.5D, 0.0F, 0.0F);
			level.addFreshEntity(mob);
			mob.spawnAnim();
		}
	}

	public void spawnAfterBreak(BlockState state, ServerLevel level, BlockPos pos, ItemStack item, boolean dropExperience) {
//		spawnInfestation(level, pos);
	}

	public void wasExploded(ServerLevel level, BlockPos pos, Explosion explosion) {
//		spawnInfestation((ServerLevel)level, pos);
	}
}
