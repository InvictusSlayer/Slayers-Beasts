package net.invictusslayer.slayersbeasts.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class Sporetrap extends PathfinderMob {
	public Sporetrap(EntityType<Sporetrap> type, Level level) {
		super(type, level);
	}

	protected void registerGoals() {
		super.registerGoals();
		goalSelector.addGoal(0, new FloatGoal(this));
		goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, false));
		goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 16.0F));
		targetSelector.addGoal(1, new HurtByTargetGoal(this));
		targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes()
				.add(Attributes.MOVEMENT_SPEED, 0.1F)
				.add(Attributes.KNOCKBACK_RESISTANCE, 5.0D)
				.add(Attributes.FOLLOW_RANGE, 16.0D)
				.add(Attributes.MAX_HEALTH, 35.0D)
				.add(Attributes.ATTACK_DAMAGE, 8.0D)
				.add(Attributes.ATTACK_SPEED, 5.0D)
				.add(Attributes.ATTACK_KNOCKBACK, 0.0D);
	}

	public static boolean canSpawn(EntityType<Sporetrap> entity, LevelAccessor levelAccess, EntitySpawnReason reason, BlockPos pos, RandomSource random) {
		return PathfinderMob.checkMobSpawnRules(entity, levelAccess, reason, pos, random) && levelAccess instanceof final Level level && level.getDifficulty() != Difficulty.PEACEFUL;
	}
}
