package net.invictusslayer.slayersbeasts.common.entity;

import com.google.common.collect.Lists;
import net.invictusslayer.slayersbeasts.common.block.entity.AnthillBlockEntity;
import net.invictusslayer.slayersbeasts.common.data.tag.SBTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiRecord;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.pathfinder.Path;

import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractAnt extends PathfinderMob {
	private static final EntityDataAccessor<Integer> DATA_VARIANT = SynchedEntityData.defineId(AbstractAnt.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> DATA_CARGO_TYPE = SynchedEntityData.defineId(AbstractAnt.class, EntityDataSerializers.INT);
	private int cooldownToEnterNest;
	private int cooldownToLocateNest;
	private int failedForagingTime;
	BlockPos nestPos;
	AntGoToNestGoal antGoToNestGoal;

	public AbstractAnt(EntityType<? extends AbstractAnt> entityType, Level level) {
		super(entityType, level);
	}

	protected void registerGoals() {
		super.registerGoals();
		goalSelector.addGoal(0, new FloatGoal(this));
		goalSelector.addGoal(1, new AntEnterNestGoal(this));
		goalSelector.addGoal(2, new AntLocateNestGoal(this));
		antGoToNestGoal = new AntGoToNestGoal(this);
		goalSelector.addGoal(3, antGoToNestGoal);
		goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 0.8D));
		goalSelector.addGoal(5, new RandomLookAroundGoal(this));
		targetSelector.addGoal(1, new AntAttackedGoal(this).setAlertOthers());
	}

	public MobType getMobType() {
		return MobType.ARTHROPOD;
	}

	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		if (nestPos != null) tag.put("NestPos", NbtUtils.writeBlockPos(nestPos));
		tag.putInt("CooldownToEnterNest", cooldownToEnterNest);
		tag.putInt("FailedForagingTime", failedForagingTime);
		tag.putInt("Variant", getVariant().getId());
		tag.putInt("CargoType", getCargoType());
	}

	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		nestPos = tag.contains("NestPos") ? NbtUtils.readBlockPos(tag.getCompound("NestPos")) : null;
		setCooldownToEnterNest(tag.getInt("CooldownToEnterNest"));
		failedForagingTime = tag.getInt("FailedForagingTime");
		setVariant(Variant.byId(tag.getInt("Variant")));
		setCargoType(tag.getInt("CargoType"));
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		entityData.define(DATA_VARIANT, 0);
		entityData.define(DATA_CARGO_TYPE, 0);
	}

	public void setCooldownToEnterNest(int cooldown) {
		cooldownToEnterNest = cooldown;
	}

	public int getCargoType() {
		return entityData.get(DATA_CARGO_TYPE);
	}

	public void setCargoType(int type) {
		if (type != 99) failedForagingTime = 0;
		entityData.set(DATA_CARGO_TYPE, type);
	}

	public void aiStep() {
		super.aiStep();
		if (cooldownToEnterNest > 0) --cooldownToEnterNest;
		if (cooldownToLocateNest > 0) --cooldownToLocateNest;

		if (getCargoType() == 99) ++failedForagingTime;

		if (tickCount % 20 == 0 && !hasValidNest()) nestPos = null;
	}

	public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType type, SpawnGroupData spawnData, CompoundTag tag) {
		Variant variant = getRandomAntType(level);
		if (spawnData instanceof AntGroupData antData) variant = antData.variant;
		else spawnData = new AntGroupData(variant);

		setVariant(variant);
		return spawnData;
	}

	private Variant getRandomAntType(LevelAccessor level) {
		Holder<Biome> holder = level.getBiome(blockPosition());
		if (holder.is(SBTags.Biomes.WOOD_ANT_HABITAT)) return Variant.WOOD;
		if (holder.is(SBTags.Biomes.LEAFCUTTER_ANT_HABITAT)) return Variant.LEAFCUTTER;
		if (holder.is(SBTags.Biomes.MEADOW_ANT_HABITAT)) return Variant.MEADOW;
		return Variant.byId(level.getRandom().nextInt(Variant.values().length));
	}

	public static class AntGroupData implements SpawnGroupData {
		private final Variant variant;
		private AntGroupData(Variant variant) {
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
		WOOD(0, "wood"),
		LEAFCUTTER(1, "leafcutter"),
		MEADOW(2, "meadow");

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

	boolean hasValidNest() {
		if (nestPos == null) return false;

		BlockEntity blockEntity = level().getBlockEntity(nestPos);
		return blockEntity instanceof AnthillBlockEntity;
	}

	private boolean nestHasSpace(BlockPos nestPos) {
		BlockEntity blockEntity = level().getBlockEntity(nestPos);
		if (blockEntity instanceof AnthillBlockEntity anthill) {
			return !anthill.isFull() && (anthill.getInhabitantVariant() == null || anthill.getInhabitantVariant() == getVariant());
		}
		return false;
	}

	protected boolean wantsToEnterNest(AbstractAnt ant) {
		if (cooldownToEnterNest > 0) return false;
		return failedForagingTime > 3600 || getCargoType() != 99 || level().isRaining() || ant instanceof AntQueen;
	}

	boolean closerThan(BlockPos pos, double distance) {
		return pos.closerThan(blockPosition(), distance);
	}

	static class AntAttackedGoal extends HurtByTargetGoal {
		AntAttackedGoal(AbstractAnt ant) {
			super(ant);
		}

		public boolean canContinueToUse() {
			return mob instanceof AntSoldier ant && ant.isAngry() && super.canContinueToUse();
		}

		protected void alertOther(Mob mob, LivingEntity target) {
			if (mob instanceof AntSoldier soldier && this.mob.hasLineOfSight(target) && ((AbstractAnt) this.mob).getVariant() == soldier.getVariant()) {
				mob.setTarget(target);
			}
		}
	}

	static class AntGoToNestGoal extends Goal {
		int travellingTicks;
		final List<BlockPos> blacklistedTargets = Lists.newArrayList();
		private Path lastPath;
		private int timeStuck;
		private final AbstractAnt ant;

		AntGoToNestGoal(AbstractAnt ant) {
			this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP));
			this.ant = ant;
			this.travellingTicks = ant.level().random.nextInt(10);
		}

		public boolean canUse() {
			return ant.nestPos != null && !ant.hasRestriction() && ant.wantsToEnterNest(ant) && ant.nestHasSpace(ant.nestPos)
					&& !this.hasReachedTarget(ant.nestPos) && ant.level().getBlockState(ant.nestPos).is(SBTags.Blocks.ANTHILLS);
		}

		public boolean canContinueToUse() {
			return this.canUse();
		}

		public void start() {
			travellingTicks = 0;
			timeStuck = 0;
		}

		public void stop() {
			travellingTicks = 0;
			timeStuck = 0;
			ant.navigation.stop();
		}

		public void tick() {
			if (ant.nestPos != null) {
				++travellingTicks;
				if (travellingTicks > adjustedTickDelay(600)) {
					blacklistNest();
				} else if (!ant.navigation.isInProgress()) {
					if (!ant.closerThan(ant.nestPos, 16)) {
						if (!ant.closerThan(ant.nestPos, 32)) dropNest();
						else moveToNest(ant.nestPos);
					} else {
						if (!moveToNest(ant.nestPos)) blacklistNest();
						else if (lastPath != null && lastPath.sameAs(ant.navigation.getPath())) {
							++timeStuck;
							if (timeStuck > 60) {
								dropNest();
								timeStuck = 0;
							}
						} else lastPath = ant.navigation.getPath();
					}
				}
			}
		}

		private boolean moveToNest(BlockPos pPos) {
			ant.navigation.moveTo(ant.navigation.createPath(new BlockPos(pPos), 0), 1D);
			return ant.navigation.getPath() != null && ant.navigation.getPath().canReach();
		}

		private boolean hasReachedTarget(BlockPos target) {
			return ant.position().distanceToSqr(target.getX() + 0.5D, target.getY() + 1D, target.getZ() + 0.5D) <= 0.4D;
		}

		private void dropNest() {
			ant.nestPos = null;
			ant.cooldownToLocateNest = 200;
		}

		private void blacklistNest() {
			if (ant.nestPos != null) {
				blacklistedTargets.add(ant.nestPos);
			}
			while (blacklistedTargets.size() > 3) {
				blacklistedTargets.remove(0);
			}
			dropNest();
		}

		boolean isTargetBlacklisted(BlockPos pPos) {
			return blacklistedTargets.contains(pPos);
		}

		void clearBlacklist() {
			blacklistedTargets.clear();
		}
	}

	static class AntEnterNestGoal extends Goal {
		private final AbstractAnt ant;

		public AntEnterNestGoal(AbstractAnt ant) {
			setFlags(EnumSet.of(Flag.MOVE));
			this.ant = ant;
		}

		public boolean canUse() {
			return ant.nestPos != null && ant.wantsToEnterNest(ant) && ant.nestHasSpace(ant.nestPos) && ant.position()
					.distanceToSqr(ant.nestPos.getX() + 0.5D, ant.nestPos.getY() + 1D, ant.nestPos.getZ() + 0.5D) <= 0.4D;
		}

		public boolean canContinueToUse() {
			return false;
		}

		public void start() {
			BlockEntity blockEntity = ant.level().getBlockEntity(ant.nestPos);
			if (blockEntity instanceof AnthillBlockEntity anthill) {
				anthill.addOccupant(ant, ant.getVariant(), ant.getCargoType() != 99);
			}
		}
	}

	static class AntLocateNestGoal extends Goal {
		private final AbstractAnt ant;

		public AntLocateNestGoal(AbstractAnt ant) {
			this.ant = ant;
		}

		public boolean canUse() {
			return ant.cooldownToLocateNest == 0 && ant.nestPos == null && ant.wantsToEnterNest(ant);
		}

		public boolean canContinueToUse() {
			return false;
		}

		public void start() {
			ant.cooldownToLocateNest = 200;
			List<BlockPos> list = findNestWithSpace();
			if (list.isEmpty()) return;

			for (BlockPos pos : list) {
				if (!ant.antGoToNestGoal.isTargetBlacklisted(pos)) {
					ant.nestPos = pos;
					return;
				}
			}
			ant.antGoToNestGoal.clearBlacklist();
			ant.nestPos = list.get(0);
		}

		private List<BlockPos> findNestWithSpace() {
			BlockPos pos = ant.blockPosition();
			PoiManager poiManager = ((ServerLevel) ant.level()).getPoiManager();
			Stream<PoiRecord> stream = poiManager.getInRange(poiType -> poiType.is(SBTags.PoiTypes.ANT_HOME), pos, 20, PoiManager.Occupancy.ANY);
			return stream.map(PoiRecord::getPos).filter(ant::nestHasSpace).sorted(Comparator.comparingDouble(key -> key.distSqr(pos))).collect(Collectors.toList());
		}
	}
}
