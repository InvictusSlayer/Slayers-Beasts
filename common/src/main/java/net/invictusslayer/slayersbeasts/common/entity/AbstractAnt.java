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
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractAnt extends PathfinderMob {
	private static final EntityDataAccessor<Integer> DATA_ANT_TYPE = SynchedEntityData.defineId(AbstractAnt.class, EntityDataSerializers.INT);
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

	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		if (nestPos != null) {
			tag.put("NestPos", NbtUtils.writeBlockPos(nestPos));
		}

		tag.putInt("CooldownToEnterNest", cooldownToEnterNest);
		tag.putInt("FailedForagingTime", failedForagingTime);
		tag.putInt("CargoType", getCargoType());
		tag.putInt("AntType", getAntType());
	}

	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		nestPos = null;
		if (tag.contains("NestPos")) {
			nestPos = NbtUtils.readBlockPos(tag.getCompound("NestPos"));
		}

		setCooldownToEnterNest(tag.getInt("CooldownToEnterNest"));
		failedForagingTime = tag.getInt("FailedForagingTime");
		setCargoType(tag.getInt("CargoType"));
		setAntType(tag.getInt("AntType"));
	}

	public MobType getMobType() {
		return MobType.ARTHROPOD;
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		entityData.define(DATA_ANT_TYPE, 0);
		entityData.define(DATA_CARGO_TYPE, 0);
	}

	public void setCooldownToEnterNest(int cooldown) {
		this.cooldownToEnterNest = cooldown;
	}

	public int getAntType() {
		return this.entityData.get(DATA_ANT_TYPE);
	}
	public void setAntType(int type) {
		this.entityData.set(DATA_ANT_TYPE, type);
	}

	public int getCargoType() {
		return this.entityData.get(DATA_CARGO_TYPE);
	}
	public void setCargoType(int type) {
		if (type != 99) {
			failedForagingTime = 0;
		}
		this.entityData.set(DATA_CARGO_TYPE, type);
	}

	public void aiStep() {
		super.aiStep();
		if (cooldownToEnterNest > 0) {
			--cooldownToEnterNest;
		}

		if (cooldownToLocateNest > 0) {
			--cooldownToLocateNest;
		}

		if (this.getCargoType() == 99) {
			++failedForagingTime;
		}

		if (tickCount % 20 == 0 && !hasValidNest()) {
			nestPos = null;
		}
	}

	public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType type, SpawnGroupData spawnData, CompoundTag tag) {
		int randomAntType = getRandomAntType(level);
		if (spawnData instanceof AntGroupData antData) {
			randomAntType = antData.antType;
		} else {
			spawnData = new AntGroupData(randomAntType);
		}

		this.setAntType(randomAntType);
		return spawnData;
	}

	private int getRandomAntType(LevelAccessor level) {
		Holder<Biome> holder = level.getBiome(blockPosition());
		if (holder.is(SBTags.Biomes.WOOD_ANT_HABITAT)) return 0;
		if (holder.is(SBTags.Biomes.LEAFCUTTER_ANT_HABITAT)) return 1;
		if (holder.is(SBTags.Biomes.MEADOW_ANT_HABITAT)) return 2;
		return level.getRandom().nextInt(3);
	}

	public static class AntGroupData implements SpawnGroupData {
		private final int antType;
		private AntGroupData(int antType) {
			this.antType = antType;
		}
	}

	boolean hasValidNest() {
		if (nestPos == null) {
			return false;
		} else {
			BlockEntity blockEntity = level().getBlockEntity(nestPos);
			return blockEntity instanceof AnthillBlockEntity;
		}
	}

	private boolean nestHasSpace(BlockPos nestPos) {
		BlockEntity blockEntity = level().getBlockEntity(nestPos);
		if (blockEntity instanceof AnthillBlockEntity anthill) {
			return !anthill.isFull() && (anthill.getInhabitantType() == 99 || anthill.getInhabitantType() == getAntType());
		}
		return false;
	}

	protected boolean wantsToEnterNest(AbstractAnt ant) {
		if (this.cooldownToEnterNest <= 0) {
			return failedForagingTime > 3600 || getCargoType() != 99 || level().isRaining() || ant instanceof AntQueen;
		}
		return false;
	}

	boolean closerThan(BlockPos pos, double distance) {
		return pos.closerThan(blockPosition(), distance);
	}

	static class AntAttackedGoal extends HurtByTargetGoal {
		AntAttackedGoal(AbstractAnt mob) {
			super(mob);
		}

		public boolean canContinueToUse() {
			return mob instanceof AntSoldier ant && ant.isAngry() && super.canContinueToUse();
		}

		protected void alertOther(Mob mob, LivingEntity target) {
			if (mob instanceof AntSoldier soldier && this.mob.hasLineOfSight(target) && ((AbstractAnt) this.mob).getAntType() == soldier.getAntType()) {
				mob.setTarget(target);
			}
		}
	}

	static class AntGoToNestGoal extends Goal {
		int travellingTicks;
		final List<BlockPos> blacklistedTargets = Lists.newArrayList();
		private Path lastPath;
		private int timeStuck;
		private final AbstractAnt mob;

		AntGoToNestGoal(AbstractAnt mob) {
			this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP));
			this.mob = mob;
			this.travellingTicks = this.mob.level().random.nextInt(10);
		}

		public boolean canUse() {
			return mob.nestPos != null && !mob.hasRestriction() && mob.wantsToEnterNest(mob) && mob.nestHasSpace(mob.nestPos)
					&& !this.hasReachedTarget(mob.nestPos) && mob.level().getBlockState(mob.nestPos).is(SBTags.Blocks.ANTHILLS);
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
			mob.navigation.stop();
		}

		public void tick() {
			if (mob.nestPos != null) {
				++travellingTicks;
				if (travellingTicks > adjustedTickDelay(600)) {
					blacklistNest();
				} else if (!mob.navigation.isInProgress()) {
					if (!mob.closerThan(mob.nestPos, 16)) {
						if (!mob.closerThan(mob.nestPos, 32)) {
							dropNest();
						} else {
							moveToNest(mob.nestPos);
						}
					} else {
						boolean flag = moveToNest(mob.nestPos);
						if (!flag) {
							blacklistNest();
						} else if (lastPath != null && lastPath.sameAs(mob.navigation.getPath())) {
							++timeStuck;
							if (timeStuck > 60) {
								dropNest();
								timeStuck = 0;
							}
						} else {
							lastPath = mob.navigation.getPath();
						}
					}
				}
			}
		}

		private boolean moveToNest(BlockPos pPos) {
			mob.navigation.moveTo(mob.navigation.createPath(new BlockPos(pPos), 0), 1D);
			return mob.navigation.getPath() != null && mob.navigation.getPath().canReach();
		}

		private boolean hasReachedTarget(BlockPos target) {
			return mob.position().distanceToSqr(target.getX() + 0.5D, target.getY() + 1D, target.getZ() + 0.5D) <= 0.4D;
		}

		private void dropNest() {
			mob.nestPos = null;
			mob.cooldownToLocateNest = 200;
		}

		private void blacklistNest() {
			if (mob.nestPos != null) {
				blacklistedTargets.add(mob.nestPos);
			}
			while (blacklistedTargets.size() > 3) {
				blacklistedTargets.remove(0);
			}
			this.dropNest();
		}

		boolean isTargetBlacklisted(BlockPos pPos) {
			return blacklistedTargets.contains(pPos);
		}

		void clearBlacklist() {
			blacklistedTargets.clear();
		}
	}

	static class AntEnterNestGoal extends Goal {
		private final AbstractAnt mob;

		public AntEnterNestGoal(AbstractAnt mob) {
			setFlags(EnumSet.of(Flag.MOVE));
			this.mob = mob;
		}

		public boolean canUse() {
			return mob.nestPos != null && mob.wantsToEnterNest(mob) && mob.nestHasSpace(mob.nestPos) && mob.position()
					.distanceToSqr(mob.nestPos.getX() + 0.5D, mob.nestPos.getY() + 1D, mob.nestPos.getZ() + 0.5D) <= 0.4D;
		}

		public boolean canContinueToUse() {
			return false;
		}

		public void start() {
			BlockEntity blockEntity = mob.level().getBlockEntity(mob.nestPos);
			if (blockEntity instanceof AnthillBlockEntity anthillBlockEntity) {
				anthillBlockEntity.addOccupant(mob, mob.getAntType(), mob.getCargoType() != 99);
			}
		}
	}

	static class AntLocateNestGoal extends Goal {
		private final AbstractAnt mob;

		public AntLocateNestGoal(AbstractAnt mob) {
			this.mob = mob;
		}

		public boolean canUse() {
			return mob.cooldownToLocateNest == 0 && mob.nestPos == null && mob.wantsToEnterNest(mob);
		}

		public boolean canContinueToUse() {
			return false;
		}

		public void start() {
			mob.cooldownToLocateNest = 200;
			List<BlockPos> list = findNestWithSpace();
			if (!list.isEmpty()) {
				for (BlockPos blockPos : list) {
					if (!mob.antGoToNestGoal.isTargetBlacklisted(blockPos)) {
						mob.nestPos = blockPos;
						return;
					}
				}
				mob.antGoToNestGoal.clearBlacklist();
				mob.nestPos = list.get(0);
			}
		}

		private List<BlockPos> findNestWithSpace() {
			BlockPos blockPos = mob.blockPosition();
			PoiManager poiManager = ((ServerLevel) mob.level()).getPoiManager();
			Stream<PoiRecord> stream = poiManager.getInRange(poiType ->
					poiType.is(SBTags.PoiTypes.ANT_HOME), blockPos, 20, PoiManager.Occupancy.ANY);
			return stream.map(PoiRecord::getPos).filter(mob::nestHasSpace).sorted(Comparator.comparingDouble(key ->
					key.distSqr(blockPos))).collect(Collectors.toList());
		}
	}
}
