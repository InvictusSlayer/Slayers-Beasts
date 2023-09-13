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

public class EntOak extends AbstractEnt {
	protected EntOak(EntityType<EntOak> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	protected void registerGoals() {
		super.registerGoals();
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes()
				.add(Attributes.MOVEMENT_SPEED, 0.21F)
				.add(Attributes.FOLLOW_RANGE, 24.0D)
				.add(Attributes.MAX_HEALTH, 35.0D)
				.add(Attributes.ATTACK_DAMAGE, 5.0D)
				.add(Attributes.ATTACK_SPEED, 1.0D)
				.add(Attributes.ATTACK_KNOCKBACK, 3.0D);
	}

	public static boolean canSpawn(EntityType<EntOak> entity, LevelAccessor levelAccess, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
		return PathfinderMob.checkMobSpawnRules(entity, levelAccess, spawnType, pos, random);
	}
}