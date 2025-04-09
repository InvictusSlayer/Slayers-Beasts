package net.invictusslayer.slayersbeasts.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.util.AirAndWaterRandomPos;
import net.minecraft.world.entity.ai.util.HoverRandomPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;
import java.util.Optional;
import java.util.function.Predicate;

public class Damselfly extends PathfinderMob {
	private static final EntityDataAccessor<Integer> DATA_DAMSELFLY_TYPE = SynchedEntityData.defineId(Damselfly.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Boolean> DATA_IS_FLYING = SynchedEntityData.defineId(Damselfly.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> DATA_IS_PERCHED = SynchedEntityData.defineId(Damselfly.class, EntityDataSerializers.BOOLEAN);
	public static final AnimationState flyAnimationState = new AnimationState();
	public static final AnimationState perchAnimationState = new AnimationState();
	BlockPos savedPerchPos;
	private int ticksUntilPerch;

	public Damselfly(EntityType<Damselfly> type, Level level) {
		super(type, level);
		moveControl = new FlyingMoveControl(this, 20, true);
		navigation = createNavigation(level);
		resetTicksUntilPerch();
	}

	protected void registerGoals() {
		super.registerGoals();
		goalSelector.addGoal(0, new DamselflyPerchGoal(this));
		goalSelector.addGoal(1, new DamselflyWanderGoal(this));
		goalSelector.addGoal(2, new FloatGoal(this));
		goalSelector.addGoal(3, new DamselflyHoverGoal(this));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes()
				.add(Attributes.MAX_HEALTH, 8.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.25D)
				.add(Attributes.FLYING_SPEED, 0.4D);
	}

	public static boolean canSpawn(EntityType<Damselfly> type, LevelAccessor level, EntitySpawnReason reason, BlockPos pos, RandomSource random) {
		return PathfinderMob.checkMobSpawnRules(type, level, reason, pos, random);
	}

	public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, EntitySpawnReason reason, SpawnGroupData spawnData) {
		setDamselflyType(random.nextInt(2));
		return new DamselflyGroupData();
	}

	protected PathNavigation createNavigation(Level level) {
		FlyingPathNavigation navigation = new FlyingPathNavigation(this, level);
		navigation.setCanOpenDoors(false);
		navigation.setCanFloat(false);
		navigation.setCanOpenDoors(true);
		return navigation;
	}

	public void travel(Vec3 vec3) {
		if (isEffectiveAi() || isControlledByLocalInstance()) {
			moveRelative(getSpeed(), vec3);
			move(MoverType.SELF, getDeltaMovement());
			setDeltaMovement(getDeltaMovement().scale(0.5D));
		}
	}

	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		if (savedPerchPos != null) {
			tag.put("PerchPos", NbtUtils.writeBlockPos(savedPerchPos));
		}

		tag.putInt("TicksSincePerch", ticksUntilPerch);
		tag.putInt("DamselflyType", getDamselflyType());
	}

	public void readAdditionalSaveData(CompoundTag tag) {
		savedPerchPos = NbtUtils.readBlockPos(tag, "PerchPos").orElse(null);

		super.readAdditionalSaveData(tag);
		ticksUntilPerch = tag.getInt("TicksSincePerch");
		setDamselflyType(tag.getInt("DamselflyType"));
	}


	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(DATA_DAMSELFLY_TYPE, 0);
		builder.define(DATA_IS_FLYING, false);
		builder.define(DATA_IS_PERCHED, false);
	}

	public int getDamselflyType() {
		return entityData.get(DATA_DAMSELFLY_TYPE);
	}
	public void setDamselflyType(int type) {
		entityData.set(DATA_DAMSELFLY_TYPE, type);
	}

	public boolean isFlying() {
		return entityData.get(DATA_IS_FLYING);
	}
	public void setFlying(boolean flying) {
		entityData.set(DATA_IS_FLYING, flying);
	}

	public boolean isPerched() {
		return entityData.get(DATA_IS_PERCHED);
	}
	public void setPerched(boolean perched) {
		entityData.set(DATA_IS_PERCHED, perched);
	}

	public boolean causeFallDamage(float fallDistance, float multiplier, DamageSource source) {
		return false;
	}
	protected void checkFallDamage(double y, boolean onGround, BlockState state, BlockPos pos) {}

	public void resetTicksUntilPerch() {
		ticksUntilPerch = 100 + getRandom().nextInt(100);
	}

	boolean isTooFarAway(Vec3 pos) {
		return !pos.closerThan(position(), 32);
	}

	public void tick() {
		super.tick();
		if (!isPerched()) --ticksUntilPerch;

		if (level().isClientSide()) setupAnimationStates();
	}

	private void setupAnimationStates() {
		flyAnimationState.animateWhen(isFlying(), tickCount);
		perchAnimationState.animateWhen(isPerched(), tickCount);
	}

	static class DamselflyPerchGoal extends Goal {
		private final Damselfly mob;
		private int perchTicks;
		private Vec3 perchPos;
		private final Predicate<BlockState> VALID_PERCH_BLOCKS = state -> {
			if (state.hasProperty(BlockStateProperties.WATERLOGGED) && state.getValue(BlockStateProperties.WATERLOGGED)) {
				return false;
			} else if (state.is(Blocks.TALL_GRASS)) {
				return state.getValue(DoublePlantBlock.HALF) == DoubleBlockHalf.UPPER;
			} else {
				return false;
			}
		};

		DamselflyPerchGoal(Damselfly mob) {
			setFlags(EnumSet.of(Flag.MOVE));
			this.mob = mob;
		}

		public boolean canUse() {
			if (mob.ticksUntilPerch > 0) {
				return false;
			} else {
				Optional<BlockPos> optional = findNearbyPerch();
				if (optional.isPresent()) {
					mob.savedPerchPos = optional.get();
					perchPos = Vec3.atBottomCenterOf(mob.savedPerchPos).add(0.0D, 1.0D, 0.0D);
					perchTicks = 120 + mob.getRandom().nextInt(80);
					return true;
				} else {
					mob.resetTicksUntilPerch();
					return false;
				}
			}
		}

		public boolean canContinueToUse() {
			return perchTicks > 0;
		}

		public boolean requiresUpdateEveryTick() {
			return true;
		}

		public void stop() {
			mob.setPerched(false);
			mob.setFlying(true);
			mob.resetTicksUntilPerch();
		}

		public void tick() {
			if (mob.savedPerchPos == null) {
				perchTicks = 0;
			}
			if (mob.position().distanceTo(perchPos) <= 0.1D) {
				mob.setFlying(false);
				mob.setPerched(true);
				--perchTicks;
			} else {
				if (mob.navigation.isDone()) {
					if (mob.isTooFarAway(perchPos)) {
						mob.savedPerchPos = null;
					} else {
						mob.setFlying(true);
						mob.setPerched(false);
						mob.navigation.moveTo(mob.navigation.createPath(new BlockPos((int) perchPos.x, (int) perchPos.y, (int) perchPos.z), 1), 1.0D);
						setWantedPos();
					}
				}
			}
		}

		private void setWantedPos() {
			mob.getMoveControl().setWantedPosition(perchPos.x, perchPos.y, perchPos.z, 0.4D);
		}

		private Optional<BlockPos> findNearbyPerch() {
			return findNearestBlock(VALID_PERCH_BLOCKS);
		}

		private Optional<BlockPos> findNearestBlock(Predicate<BlockState> predicate) {
			BlockPos blockPos = mob.blockPosition();
			BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();

			for (int y = 0; y <= 5; y = y > 0 ? -y : 1 - y) {
				for (int i = 0; i < 5; ++i) {
					for (int x = 0; x <= i; x = x > 0 ? -x : 1 - x) {
						for (int z = x < i && x > -i ? i : 0; z <= i; z = z > 0 ? -z : 1 - z) {
							mutableBlockPos.setWithOffset(blockPos, x, y - 1, z);
							if (blockPos.closerThan(mutableBlockPos, 5.0) &&
									predicate.test(mob.level().getBlockState(mutableBlockPos))) {
								return Optional.of(mutableBlockPos);
							}
						}
					}
				}
			}

			return Optional.empty();
		}
	}

	static class DamselflyHoverGoal extends Goal {
		private final Damselfly mob;
		private int hoverTime;

		DamselflyHoverGoal(Damselfly mob) {
			setFlags(EnumSet.of(Flag.MOVE));
			this.mob = mob;
		}

		public boolean canUse() {
			return mob.navigation.isDone();
		}

		public boolean canContinueToUse() {
			return mob.navigation.isDone() && hoverTime >= 0;
		}

		public void start() {
			mob.setFlying(true);
			hoverTime = 40 + mob.getRandom().nextInt(40);
		}

		public void tick() {
			--hoverTime;
		}
	}

	class DamselflyWanderGoal extends Goal {
		private final Damselfly mob;

		DamselflyWanderGoal(Damselfly mob) {
			setFlags(EnumSet.of(Flag.MOVE));
			this.mob = mob;
		}

		public boolean canUse() {
			return mob.navigation.isDone() && mob.random.nextInt(20) == 0;
		}

		public boolean canContinueToUse() {
			return mob.navigation.isInProgress();
		}

		public void start() {
			mob.setFlying(true);
			Vec3 vec3 = findPos();
			if (vec3 != null) {
				mob.navigation.moveTo(mob.navigation.createPath(new BlockPos((int) vec3.x, (int) vec3.y, (int) vec3.z), 1), 1.0D);
			}
		}

		private Vec3 findPos() {
			Vec3 vec3 = getViewVector(0.0F);
			Vec3 pos = HoverRandomPos.getPos(mob, 8, 7, vec3.x, vec3.z, Mth.PI / 2F, 3, 1);
			return pos != null ? pos : AirAndWaterRandomPos.getPos(mob, 8, 4, -2, vec3.x, vec3.z, Mth.PI / 2F);
		}
	}

	public static class DamselflyGroupData implements SpawnGroupData {
		private DamselflyGroupData() {}
	}
}
