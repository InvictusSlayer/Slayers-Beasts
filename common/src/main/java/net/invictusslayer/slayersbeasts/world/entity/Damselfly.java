package net.invictusslayer.slayersbeasts.world.entity;

import net.invictusslayer.slayersbeasts.data.tags.SBTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.DifficultyInstance;
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
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;
import java.util.Optional;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public class Damselfly extends PathfinderMob implements VariantHolder<Damselfly.Variant>, FlyingAnimal {
	private static final EntityDataAccessor<Integer> DATA_VARIANT = SynchedEntityData.defineId(Damselfly.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Boolean> DATA_IS_FLYING = SynchedEntityData.defineId(Damselfly.class, EntityDataSerializers.BOOLEAN);
	public final AnimationState flyAnimationState = new AnimationState();
	public final AnimationState perchAnimationState = new AnimationState();
	BlockPos savedPerchPos;
	private int ticksUntilPerch;

	public Damselfly(EntityType<Damselfly> type, Level level) {
		super(type, level);
		moveControl = new FlyingMoveControl(this, 20, true);
		navigation = createNavigation(level);
		resetTicksUntilPerch();
	}

	@Override
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

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, EntitySpawnReason reason, SpawnGroupData spawnData) {
		setVariant(Variant.byId(level.getRandom().nextInt(Variant.values().length)));
		return new DamselflyGroupData();
	}

	@Override
	protected PathNavigation createNavigation(Level level) {
		FlyingPathNavigation navigation = new FlyingPathNavigation(this, level);
		navigation.setCanOpenDoors(false);
		navigation.setCanFloat(false);
		navigation.setCanOpenDoors(true);
		return navigation;
	}

	@Override
	public void travel(Vec3 vec3) {
		if (isEffectiveAi() || isControlledByLocalInstance()) {
			moveRelative(getSpeed(), vec3);
			move(MoverType.SELF, getDeltaMovement());
			setDeltaMovement(getDeltaMovement().scale(0.5D));
		}
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		if (savedPerchPos != null) tag.put("PerchPos", NbtUtils.writeBlockPos(savedPerchPos));
		tag.putInt("TicksSincePerch", ticksUntilPerch);
		tag.putInt("Variant", getVariant().getId());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		savedPerchPos = NbtUtils.readBlockPos(tag, "PerchPos").orElse(null);
		ticksUntilPerch = tag.getInt("TicksSincePerch");
		setVariant(Variant.byId(tag.getInt("Variant")));
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData();
		entityData.define(DATA_VARIANT, 0);
		entityData.define(DATA_IS_FLYING, false);
	}

	@Override
	public Variant getVariant() {
		return Variant.byId(entityData.get(DATA_VARIANT));
	}

	@Override
	public void setVariant(Variant variant) {
		entityData.set(DATA_VARIANT, variant.ordinal());
	}

	@Override
	public boolean isFlying() {
		return entityData.get(DATA_IS_FLYING);
	}

	public void setFlying(boolean flying) {
		entityData.set(DATA_IS_FLYING, flying);
	}

	@Override
	protected void checkFallDamage(double y, boolean onGround, BlockState state, BlockPos pos) {}

	public void resetTicksUntilPerch() {
		ticksUntilPerch = 150 + getRandom().nextInt(100);
	}

	boolean isTooFarAway(Vec3 pos) {
		return !pos.closerThan(position(), 32);
	}

	public void tick() {
		super.tick();
		if (isFlying()) --ticksUntilPerch;

		if (level().isClientSide()) setupAnimationStates();
	}

	private void setupAnimationStates() {
		flyAnimationState.animateWhen(isFlying(), tickCount);
		perchAnimationState.animateWhen(!isFlying(), tickCount);
	}

	static class DamselflyPerchGoal extends Goal {
		private final Damselfly mob;
		private int travelTicks, perchTicks;
		private Vec3 perchPos;
		private final Predicate<BlockState> VALID_PERCH_BLOCKS = state -> {
			if (!state.is(SBTags.Blocks.DAMSELFLY_PERCH)) return false;
			if (state.hasProperty(BlockStateProperties.WATERLOGGED) && state.getValue(BlockStateProperties.WATERLOGGED)) return false;
			if (state.hasProperty(BlockStateProperties.DOUBLE_BLOCK_HALF)) return state.getValue(DoublePlantBlock.HALF) == DoubleBlockHalf.UPPER;
			return true;
		};

		DamselflyPerchGoal(Damselfly mob) {
			setFlags(EnumSet.of(Flag.MOVE));
			this.mob = mob;
		}

		@Override
		public boolean canUse() {
			if (mob.ticksUntilPerch > 0) return false;

			Optional<BlockPos> optional = findNearbyPerch();
			if (optional.isPresent()) {
				mob.savedPerchPos = optional.get();
				BlockState state = mob.level().getBlockState(mob.savedPerchPos);
				double y = state.getShape(mob.level(), mob.savedPerchPos).max(Direction.Axis.Y);
				perchPos = Vec3.atBottomCenterOf(mob.savedPerchPos).add(0.0D, 1.0D, 0.0D);
				return true;
			}

			mob.resetTicksUntilPerch();
			return false;
		}

		@Override
		public boolean canContinueToUse() {
			return perchTicks > 0 && perchPos != null;
		}

		@Override
		public void start() {
			travelTicks = 0;
			perchTicks = 120 + mob.getRandom().nextInt(80);
		}

		@Override
		public void stop() {
			mob.setFlying(true);
			mob.resetTicksUntilPerch();
			mob.savedPerchPos = null;
			mob.navigation.stop();
		}

		@Override
		public void tick() {
			if (!VALID_PERCH_BLOCKS.test(mob.level().getBlockState(mob.savedPerchPos))) {
				perchPos = null;
				return;
			}

			++travelTicks;
			if (travelTicks > adjustedTickDelay(600)) {
				perchPos = null;
				return;
			}

			if (mob.position().distanceTo(perchPos) <= 0.1D) {
				mob.setFlying(false);
				return;
			}

			if (mob.navigation.isDone()) {
				if (mob.isTooFarAway(perchPos)) {
					perchPos = null;
				} else {
					mob.setFlying(true);
					mob.navigation.moveTo(perchPos.x, perchPos.y, perchPos.z, 1.0D);
					setWantedPos();
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
			BlockPos pos = mob.blockPosition();
			BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();

			for (int y = 0; y <= 5; y = y > 0 ? -y : 1 - y) {
				for (int i = 0; i < 5; ++i) {
					for (int x = 0; x <= i; x = x > 0 ? -x : 1 - x) {
						for (int z = x < i && x > -i ? i : 0; z <= i; z = z > 0 ? -z : 1 - z) {
							mutable.setWithOffset(pos, x, y - 1, z);
							if (pos.closerThan(mutable, 5.0) && predicate.test(mob.level().getBlockState(mutable)))
								return Optional.of(mutable);
						}
					}
				}
			}
			return Optional.empty();
		}
	}

	static class DamselflyHoverGoal extends Goal {
		private final Damselfly mob;
		private int hoverTicks;

		DamselflyHoverGoal(Damselfly mob) {
			setFlags(EnumSet.of(Flag.MOVE));
			this.mob = mob;
		}

		@Override
		public boolean canUse() {
			return mob.navigation.isDone();
		}

		@Override
		public boolean canContinueToUse() {
			return mob.navigation.isDone() && hoverTicks >= 0;
		}

		@Override
		public void start() {
			mob.setFlying(true);
			hoverTicks = 40 + mob.getRandom().nextInt(40);
		}

		@Override
		public void tick() {
			--hoverTicks;
		}
	}

	class DamselflyWanderGoal extends Goal {
		private final Damselfly mob;

		DamselflyWanderGoal(Damselfly mob) {
			setFlags(EnumSet.of(Flag.MOVE));
			this.mob = mob;
		}

		@Override
		public boolean canUse() {
			return mob.navigation.isDone() && mob.random.nextInt(20) == 0;
		}

		@Override
		public boolean canContinueToUse() {
			return mob.navigation.isInProgress();
		}

		@Override
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

	public enum Variant implements StringRepresentable {
		BLUE(0, "blue"),
		GREEN(1, "green"),
		YELLOW(2, "yellow");

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
