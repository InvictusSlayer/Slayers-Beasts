package net.invictusslayer.slayersbeasts.common.entity;

import net.invictusslayer.slayersbeasts.common.init.SBEntities;
import net.invictusslayer.slayersbeasts.common.init.SBSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
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
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

import java.util.Objects;

public class Mantis extends Monster {
	private static final EntityDataAccessor<Boolean> DATA_IS_STRIKING = SynchedEntityData.defineId(Mantis.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> DATA_IS_SCUTTLING = SynchedEntityData.defineId(Mantis.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> DATA_IS_LEAPING = SynchedEntityData.defineId(Mantis.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDimensions SCUTTLING_DIMENSIONS = EntityDimensions.scalable(SBEntities.MANTIS.get().getWidth(), SBEntities.MANTIS.get().getHeight() - 0.8F);
	public final AnimationState flapAnimationState = new AnimationState();
	public final AnimationState strikeAnimationState = new AnimationState();

	public Mantis(EntityType<Mantis> type, Level level) {
		super(type, level);
	}

	protected void registerGoals() {
		goalSelector.addGoal(0, new FloatGoal(this));
		goalSelector.addGoal(1, new MantisScuttleGoal(this, 1.5D, 32.0F, 8.0F));
		goalSelector.addGoal(2, new MantisLeapGoal(this, 0.6F));
		goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0D, true));
		goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 0.8D));
		goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 8.0F));
		goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		goalSelector.addGoal(7, new MantisPreenGoal(this));
		targetSelector.addGoal(1, new HurtByTargetGoal(this));
		targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes()
				.add(Attributes.MOVEMENT_SPEED, 0.25F)
				.add(Attributes.FOLLOW_RANGE, 24.0D)
				.add(Attributes.MAX_HEALTH, 15.0D)
				.add(Attributes.ATTACK_DAMAGE, 2.0D)
				.add(Attributes.ATTACK_SPEED, 2.0D)
				.add(Attributes.ATTACK_KNOCKBACK, 1.0D);
	}

	public boolean doHurtTarget(ServerLevel level, Entity entity) {
		if (!super.doHurtTarget(level, entity)) {
			return false;
		}
		if (entity instanceof LivingEntity livingEntity && random.nextBoolean()) {
			livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 30), this);
		}
		return true;
	}

	protected SoundEvent getAmbientSound() {
		return SBSounds.MANTIS_AMBIENT.get();
	}

	protected SoundEvent getDeathSound() {
		return SBSounds.MANTIS_DEATH.get();
	}

	protected SoundEvent getHurtSound(DamageSource damageSource) {
		return SBSounds.MANTIS_HURT.get();
	}

	public static boolean canSpawn(EntityType<Mantis> entity, LevelAccessor level, EntitySpawnReason reason, BlockPos pos, RandomSource random) {
		return PathfinderMob.checkMobSpawnRules(entity, level, reason, pos, random) && level instanceof Level level1 && level1.getDifficulty() != Difficulty.PEACEFUL;
	}

	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(DATA_IS_STRIKING, false);
		builder.define(DATA_IS_SCUTTLING, false);
		builder.define(DATA_IS_LEAPING, false);
	}

	public void tick() {
		super.tick();

		if (getTarget() != null) setStriking(getTarget().distanceToSqr(this) < 8.0F);
		else setStriking(false);

		if (level().isClientSide()) {
			setupAnimationStates();
		}
	}

	private void setupAnimationStates() {
		flapAnimationState.animateWhen(isLeaping(), tickCount);
		strikeAnimationState.animateWhen(isStriking(), tickCount);
	}

	public boolean isStriking() {
		return entityData.get(DATA_IS_STRIKING);
	}

	public void setStriking(boolean striking) {
		entityData.set(DATA_IS_STRIKING, striking);
	}

	public boolean isScuttling() {
		return entityData.get(DATA_IS_SCUTTLING);
	}

	public void setScuttling(boolean scuttling) {
		entityData.set(DATA_IS_SCUTTLING, scuttling);
	}

	public boolean isLeaping() {
		return entityData.get(DATA_IS_LEAPING);
	}

	public void setLeaping(boolean leaping) {
		entityData.set(DATA_IS_LEAPING, leaping);
	}

	public EntityDimensions getDefaultDimensions(Pose pose) {
		return isScuttling() ? SCUTTLING_DIMENSIONS.scale(getScale()) : super.getDefaultDimensions(pose);
	}

	static class MantisScuttleGoal extends MoveTowardsTargetGoal {
		private final Mantis mantis;
		private final float outside;

		public MantisScuttleGoal(Mantis mantis, double speedModifier, float within, float outside) {
			super(mantis, speedModifier, within);
			this.mantis = mantis;
			this.outside = outside;
		}

		public boolean canUse() {
			return super.canUse() && Objects.requireNonNull(mantis.getTarget()).distanceToSqr(mantis) > outside * outside;
		}

		public void start() {
			mantis.setScuttling(true);
			super.start();
		}

		public void stop() {
			mantis.setScuttling(false);
			super.stop();
		}
	}

	static class MantisLeapGoal extends LeapAtTargetGoal {
		private final Mantis mantis;

		public MantisLeapGoal(Mantis mantis, float yd) {
			super(mantis, yd);
			this.mantis = mantis;
		}

		public void start() {
			mantis.setLeaping(true);
			super.start();
		}

		public void stop() {
			mantis.setLeaping(false);
		}
	}

	static class MantisPreenGoal extends Goal {
		private final Mantis mantis;
		private int preenTime;

		public MantisPreenGoal(Mantis mantis) {
			this.mantis = mantis;
		}

		public boolean canUse() {
			return mantis.onGround() && mantis.getRandom().nextFloat() < 0.02F;
		}

		public boolean canContinueToUse() {
			return preenTime >= 0;
		}

		public void start() {
			preenTime = 15 + mantis.getRandom().nextInt(15);
		}

		public boolean requiresUpdateEveryTick() {
			return true;
		}

		public void tick() {
			--preenTime;
		}
	}
}
