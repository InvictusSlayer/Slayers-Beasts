package net.invictusslayer.slayersbeasts.common.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class WitherSpider extends Spider {
	public WitherSpider(EntityType<WitherSpider> type, Level level) {
		super(type, level);
	}

	protected void registerGoals() {
		goalSelector.addGoal(0, new FloatGoal(this));
		goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, false));
		goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 0.8D));
		goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
		goalSelector.addGoal(4, new RandomLookAroundGoal(this));
		targetSelector.addGoal(1, new HurtByTargetGoal(this));
		targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes()
				.add(Attributes.MOVEMENT_SPEED, 0.24F)
				.add(Attributes.FOLLOW_RANGE, 16.0D)
				.add(Attributes.MAX_HEALTH, 15.0D)
				.add(Attributes.ATTACK_DAMAGE, 2.0D)
				.add(Attributes.ATTACK_SPEED, 2.0D)
				.add(Attributes.ATTACK_KNOCKBACK, 1.0D);
	}

	protected SoundEvent getAmbientSound() {
		return SoundEvents.WITHER_SKELETON_AMBIENT;
	}
	protected SoundEvent getDeathSound() {
		return SoundEvents.WITHER_SKELETON_DEATH;
	}
	protected SoundEvent getHurtSound(DamageSource source) {
		return SoundEvents.WITHER_SKELETON_HURT;
	}

	public static boolean canSpawn(EntityType<WitherSpider> entity, LevelAccessor level, EntitySpawnReason reason, BlockPos pos, RandomSource random) {
		return PathfinderMob.checkMobSpawnRules(entity, level, reason, pos, random) && level instanceof Level level1 && level1.getDifficulty() != Difficulty.PEACEFUL;
	}

	public boolean doHurtTarget(ServerLevel level, Entity entity) {
		if (!super.doHurtTarget(level, entity)) return false;
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.WITHER, 200), this);
		}
		return true;
	}

	public boolean canBeAffected(MobEffectInstance instance) {
		return instance.getEffect() != MobEffects.WITHER && super.canBeAffected(instance);
	}
}
