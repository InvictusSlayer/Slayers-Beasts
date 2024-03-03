package net.invictusslayer.slayersbeasts.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.function.IntFunction;

public abstract class AbstractEnt extends PathfinderMob {
	private static final EntityDataAccessor<Integer> DATA_VARIANT = SynchedEntityData.defineId(AbstractEnt.class, EntityDataSerializers.INT);

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

	protected void defineSynchedData() {
		super.defineSynchedData();
		entityData.define(DATA_VARIANT, 0);
	}

	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putInt("Variant", getVariant().id);
	}

	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		setVariant(Variant.byId(tag.getInt("Variant")));
	}

	public void tick() {
		super.tick();
		if (level().isClientSide()) {
			setupAnimationStates();
		}
	}

	protected abstract void setupAnimationStates();

	public Variant getVariant() {
		return Variant.byId(entityData.get(DATA_VARIANT));
	}

	public void setVariant(Variant variant) {
		entityData.set(DATA_VARIANT, variant.ordinal());
	}

	public enum Variant implements StringRepresentable {
		OAK(0, "oak"),
		BIRCH(1, "birch"),
		JUNGLE(2, "jungle");

		private static final IntFunction<Variant> BY_ID = ByIdMap.continuous(Variant::getId, values(), ByIdMap.OutOfBoundsStrategy.CLAMP);
		final int id;
		final String name;

		Variant(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public static Variant byId(int id) {
			return BY_ID.apply(id);
		}

		public int getId() {
			return id;
		}

		public String getSerializedName() {
			return name;
		}
	}
}
