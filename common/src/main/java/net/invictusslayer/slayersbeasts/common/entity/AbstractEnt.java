package net.invictusslayer.slayersbeasts.common.entity;

import net.invictusslayer.slayersbeasts.common.data.tag.SBTags;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;

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

	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(DATA_VARIANT, 0);
	}

	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putInt("Variant", getVariant().getId());
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

	public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType type, SpawnGroupData spawnData) {
		Variant variant = getRandomEntType(level);
		if (spawnData instanceof EntGroupData antData) variant = antData.variant;
		else spawnData = new EntGroupData(variant);

		setVariant(variant);
		return spawnData;
	}

	private Variant getRandomEntType(LevelAccessor level) {
		Holder<Biome> holder = level.getBiome(blockPosition());
		if (holder.is(SBTags.Biomes.SPAWNS_OAK_ENTS)) return Variant.OAK;
		if (holder.is(SBTags.Biomes.SPAWNS_BIRCH_ENTS)) return Variant.BIRCH;
		return Variant.byId(level.getRandom().nextInt(Variant.values().length));
	}

	public static class EntGroupData implements SpawnGroupData {
		private final Variant variant;
		private EntGroupData(Variant variant) {
			this.variant = variant;
		}
	}

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
