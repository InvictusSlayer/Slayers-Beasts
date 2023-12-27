package net.invictusslayer.slayersbeasts.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public abstract class AbstractEnt extends PathfinderMob {
	public AbstractEnt(EntityType<? extends AbstractEnt> type, Level level) {
		super(type, level);
	}

	public void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, false));
		this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 0.8D));
		this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
	}

	protected SoundEvent getAmbientSound() {
		return SoundEvents.GRASS_HIT;
	}
	protected SoundEvent getDeathSound() {
		return SoundEvents.WOOD_FALL;
	}
	protected SoundEvent getHurtSound(DamageSource source) {
		return SoundEvents.WOOD_BREAK;
	}

	public void tick() {
		super.tick();
		if (level().isClientSide()) {
			setupAnimationStates();
		}
	}

	protected abstract void setupAnimationStates();
}
