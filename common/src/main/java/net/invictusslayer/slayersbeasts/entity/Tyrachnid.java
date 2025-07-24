package net.invictusslayer.slayersbeasts.entity;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class Tyrachnid extends Monster implements RangedAttackMob {
	private static final EntityDataAccessor<Boolean> DATA_IS_RESTING = SynchedEntityData.defineId(Tyrachnid.class, EntityDataSerializers.BOOLEAN);

	public Tyrachnid(EntityType<Tyrachnid> type, Level level) {
		super(type, level);
	}

	protected void registerGoals() {
		super.registerGoals();
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
				.add(Attributes.MOVEMENT_SPEED, 0.35F)
				.add(Attributes.FOLLOW_RANGE, 30.0D)
				.add(Attributes.MAX_HEALTH, 150.0D)
				.add(Attributes.ATTACK_DAMAGE, 15.0D)
				.add(Attributes.ATTACK_SPEED, 5.0D)
				.add(Attributes.ATTACK_KNOCKBACK, 3.0D);
	}

	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(DATA_IS_RESTING, true);
	}

	public boolean isResting() {
		return entityData.get(DATA_IS_RESTING);
	}
	public void setResting(Boolean resting) {
		entityData.set(DATA_IS_RESTING, resting);
	}

	public TarantulaPose getTarantulaPose() {
		if (isResting()) {
			return TarantulaPose.RESTING;
		} else if (isAggressive()) {
			return TarantulaPose.HOSTILE;
		} else {
			return TarantulaPose.PASSIVE;
		}
	}

	public void performRangedAttack(LivingEntity target, float velocity) {

	}

	public enum TarantulaPose {
		RESTING,
		PASSIVE,
		HOSTILE,
		CHARGING_SHOT,
		CHARGING_LARGE_SHOT
	}
}
