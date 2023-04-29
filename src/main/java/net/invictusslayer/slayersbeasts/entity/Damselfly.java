package net.invictusslayer.slayersbeasts.entity;

import net.invictusslayer.slayersbeasts.entity.poses.DamselflyPose;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.Optional;
import java.util.function.Predicate;

public class Damselfly extends PathfinderMob {
    private static final EntityDataAccessor<Boolean> DATA_IS_FLYING = SynchedEntityData.defineId(Damselfly.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> DATA_IS_PERCHED = SynchedEntityData.defineId(Damselfly.class, EntityDataSerializers.BOOLEAN);
    @Nullable BlockPos savedPerchPos;
    private int ticksUntilPerch;

    public Damselfly(EntityType<Damselfly> entityType, Level level) {
        super(entityType, level);
        this.moveControl = new FlyingMoveControl(this, 20, true);
        this.navigation = this.createNavigation(level);
        this.resetTicksUntilPerch();
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new DamselflyPerchGoal(this));
        this.goalSelector.addGoal(1, new DamselflyWanderGoal(this));
        this.goalSelector.addGoal(2, new FloatGoal(this));
        this.goalSelector.addGoal(3, new DamselflyHoverGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 8.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.FLYING_SPEED, 0.4D);
    }

    public @NotNull MobType getMobType() {
        return MobType.ARTHROPOD;
    }

    public static boolean canSpawn(EntityType<Damselfly> entity, LevelAccessor levelAccess, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return PathfinderMob.checkMobSpawnRules(entity, levelAccess, spawnType, pos, random);
    }

    protected PathNavigation createNavigation(Level pLevel) {
        FlyingPathNavigation flyingpathnavigation = new FlyingPathNavigation(this, pLevel);
        flyingpathnavigation.setCanOpenDoors(false);
        flyingpathnavigation.setCanFloat(false);
        flyingpathnavigation.setCanPassDoors(true);
        return flyingpathnavigation;
    }

    public void travel(Vec3 pTravelVector) {
        if (this.isEffectiveAi() || this.isControlledByLocalInstance()) {
            this.moveRelative(this.getSpeed(), pTravelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.5D));
        }
    }

    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        if (this.savedPerchPos != null) {
            pCompound.put("PerchPos", NbtUtils.writeBlockPos(this.savedPerchPos));
        }

        pCompound.putInt("TicksSincePerch", this.ticksUntilPerch);
    }

    public void readAdditionalSaveData(CompoundTag pCompound) {
        this.savedPerchPos = null;
        if (pCompound.contains("PerchPos")) {
            this.savedPerchPos = NbtUtils.readBlockPos(pCompound.getCompound("PerchPos"));
        }

        super.readAdditionalSaveData(pCompound);
        this.ticksUntilPerch = pCompound.getInt("TicksSincePerch");
    }


    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_IS_FLYING, false);
        this.entityData.define(DATA_IS_PERCHED, false);
    }

    public DamselflyPose getWingPose() {
        if (this.isFlying()) {
            return DamselflyPose.FLYING;
        } else if (this.isPerched()) {
            return DamselflyPose.PERCHED;
        } else {
            return DamselflyPose.STILL;
        }
    }
    
    public boolean isFlying() {
        return this.entityData.get(DATA_IS_FLYING);
    }
    public void setFlying(boolean flying) {
        this.entityData.set(DATA_IS_FLYING, flying);
    }

    public boolean isPerched() {
        return this.entityData.get(DATA_IS_PERCHED);
    }
    public void setPerched(boolean perched) {
        this.entityData.set(DATA_IS_PERCHED, perched);
    }

    public boolean causeFallDamage(float pFallDistance, float pMultiplier, DamageSource pSource) {
        return false;
    }
    protected void checkFallDamage(double pY, boolean pOnGround, BlockState pState, BlockPos pPos) {}

    public void resetTicksUntilPerch() {
        this.ticksUntilPerch = 100 + getRandom().nextInt(100);
    }

    boolean isTooFarAway(Vec3 pPos) {
        return !pPos.closerThan(this.position(), 32);
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.isPerched()) {
            --this.ticksUntilPerch;
        }
    }

    static class DamselflyPerchGoal extends Goal {
        private final Damselfly mob;
        private int perchTicks;
        private Vec3 perchPos;
        private final Predicate<BlockState> VALID_PERCH_BLOCKS = (blockState) -> {
            if (blockState.hasProperty(BlockStateProperties.WATERLOGGED) && blockState.getValue(BlockStateProperties.WATERLOGGED)) {
                return false;
            } else if (blockState.is(Blocks.TALL_GRASS)) {
                return blockState.getValue(DoublePlantBlock.HALF) == DoubleBlockHalf.UPPER;
            } else {
                return false;
            }
        };

        DamselflyPerchGoal(Damselfly pMob) {
            this.setFlags(EnumSet.of(Flag.MOVE));
            this.mob = pMob;
        }

        public boolean canUse() {
            if (this.mob.ticksUntilPerch > 0) {
                return false;
            } else {
                Optional<BlockPos> optional = this.findNearbyPerch();
                if (optional.isPresent()) {
                    this.mob.savedPerchPos = optional.get();
                    this.perchPos = Vec3.atBottomCenterOf(this.mob.savedPerchPos).add(0.0D, 1.0D, 0.0D);
                    this.perchTicks = 80 + this.mob.getRandom().nextInt(50);
                    return true;
                } else {
                    this.mob.resetTicksUntilPerch();
                    return false;
                }
            }
        }

        public boolean canContinueToUse() {
            return this.perchTicks > 0;
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void stop() {
            this.mob.setPerched(false);
            this.mob.setFlying(true);
            this.mob.resetTicksUntilPerch();
        }

        public void tick() {
            if (this.mob.savedPerchPos == null) {
                this.perchTicks = 0;
            }
            if (this.mob.position().distanceTo(this.perchPos) <= 0.1D) {
                this.mob.setFlying(false);
                this.mob.setPerched(true);
                --this.perchTicks;
            } else {
                if (this.mob.navigation.isDone()) {
                    if (this.mob.isTooFarAway(this.perchPos)) {
                        this.mob.savedPerchPos = null;
                    } else {
                        this.mob.setFlying(true);
                        this.mob.setPerched(false);
                        this.mob.navigation.moveTo(this.mob.navigation.createPath(new BlockPos(this.perchPos), 1), 1.0D);
                        this.setWantedPos();
                    }
                }
            }
        }

        private void setWantedPos() {
            this.mob.getMoveControl().setWantedPosition(this.perchPos.x, this.perchPos.y, this.perchPos.z, 0.4D);
        }

        private Optional<BlockPos> findNearbyPerch() {
            return this.findNearestBlock(this.VALID_PERCH_BLOCKS);
        }

        private Optional<BlockPos> findNearestBlock(Predicate<BlockState> pPredicate) {
            BlockPos blockpos = this.mob.blockPosition();
            BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();

            for (int i = 0; (double) i <= 5.0; i = i > 0 ? -i : 1 - i) {
                for (int j = 0; (double) j < 5.0; ++j) {
                    for (int k = 0; k <= j; k = k > 0 ? -k : 1 - k) {
                        for (int l = k < j && k > -j ? j : 0; l <= j; l = l > 0 ? -l : 1 - l) {
                            mutableBlockPos.setWithOffset(blockpos, k, i - 1, l);
                            if (blockpos.closerThan(mutableBlockPos, 5.0) &&
                                    pPredicate.test(this.mob.level.getBlockState(mutableBlockPos))) {
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

        DamselflyHoverGoal(Damselfly pMob) {
            this.setFlags(EnumSet.of(Flag.MOVE));
            this.mob = pMob;
        }

        public boolean canUse() {
            return this.mob.navigation.isDone();
        }

        public boolean canContinueToUse() {
            return this.mob.navigation.isDone() && this.hoverTime >= 0;
        }

        public void start() {
            this.mob.setFlying(true);
            this.hoverTime = 20 + this.mob.getRandom().nextInt(20);
        }

        public void tick() {
            --hoverTime;
        }
    }

    class DamselflyWanderGoal extends Goal {
        private final Damselfly mob;

        DamselflyWanderGoal(Damselfly pMob) {
            this.setFlags(EnumSet.of(Flag.MOVE));
            this.mob = pMob;
        }

        public boolean canUse() {
            return this.mob.navigation.isDone() && mob.random.nextInt(20) == 0;
        }

        public boolean canContinueToUse() {
            return this.mob.navigation.isInProgress();
        }

        public void start() {
            this.mob.setFlying(true);
            Vec3 vec3 = this.findPos();
            if (vec3 != null) {
                this.mob.navigation.moveTo(this.mob.navigation.createPath(new BlockPos(vec3), 1), 1.0D);
            }
        }

        @Nullable
        private Vec3 findPos() {
            Vec3 vec3 = getViewVector(0.0F);

            Vec3 vec32 = HoverRandomPos.getPos(this.mob, 8, 7, vec3.x, vec3.z, Mth.PI / 2F, 3, 1);
            return vec32 != null ? vec32 : AirAndWaterRandomPos.getPos(this.mob, 8, 4, -2, vec3.x, vec3.z, Mth.PI / 2F);
        }
    }
}
