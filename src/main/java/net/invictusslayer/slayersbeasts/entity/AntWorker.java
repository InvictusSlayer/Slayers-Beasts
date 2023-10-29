package net.invictusslayer.slayersbeasts.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.ForgeMod;

public class AntWorker extends AbstractAnt {
	public AntWorker(EntityType<AntWorker> type, Level level) {
		super(type, level);
	}

	protected void registerGoals() {
		super.registerGoals();
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes()
				.add(Attributes.MOVEMENT_SPEED, 0.22D)
				.add(Attributes.MAX_HEALTH, 5D)
				.add(ForgeMod.ENTITY_GRAVITY.get(), 0.1D);
	}

	public static boolean canSpawn(EntityType<AntWorker> entity, LevelAccessor levelAccess, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
		return PathfinderMob.checkMobSpawnRules(entity, levelAccess, spawnType, pos, random);
	}
}
