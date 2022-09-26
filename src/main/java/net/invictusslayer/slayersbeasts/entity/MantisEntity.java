package net.invictusslayer.slayersbeasts.entity;

import net.invictusslayer.slayersbeasts.init.ModEffects;
import net.invictusslayer.slayersbeasts.init.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
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
import net.minecraft.world.phys.Vec3;

import java.awt.*;
import java.util.Random;

public class MantisEntity extends PathfinderMob {
    public MantisEntity(EntityType<MantisEntity> entityType, Level level) {
        super(entityType, level);
    }
    private static final EntityDataAccessor<Boolean> DATA_IS_LEAPING = SynchedEntityData.defineId(MantisEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> DATA_IS_FLUTTERING = SynchedEntityData.defineId(MantisEntity.class, EntityDataSerializers.BOOLEAN);

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MantisLeapGoal(this, 0.4F, this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.25F)
                .add(Attributes.FOLLOW_RANGE, 16.0D)
                .add(Attributes.MAX_HEALTH, 15.0D)
                .add(Attributes.ATTACK_DAMAGE, 2.0D)
                .add(Attributes.ATTACK_SPEED, 2.0D)
                .add(Attributes.ATTACK_KNOCKBACK, 1.0D);
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        if (!super.doHurtTarget(pEntity)) {
            return false;
        } else {
            /*if (pEntity instanceof LivingEntity && random.nextBoolean()) {
                ((LivingEntity)pEntity).addEffect(new MobEffectInstance(ModEffects.PARALYSIS.get(), 30), this);
            }*/
            return true;
        }
    }

    protected SoundEvent getAmbientSound() {return ModSounds.MANTIS_AMBIENT.get();}
    protected SoundEvent getDeathSound() {return ModSounds.MANTIS_DEATH.get();}
    protected SoundEvent getHurtSound(DamageSource damageSource) {return ModSounds.MANTIS_HURT.get();}

    public MobType getMobType() {
        return MobType.ARTHROPOD;
    }

    public static boolean canSpawn(EntityType<MantisEntity> entity, LevelAccessor levelAccess, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return PathfinderMob.checkMobSpawnRules(entity, levelAccess, spawnType, pos, random)
                && levelAccess instanceof final Level level && level.getDifficulty() != Difficulty.PEACEFUL;
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_IS_LEAPING, false);
        this.entityData.define(DATA_IS_FLUTTERING, false);
    }

    public boolean isLeaping() {
        return this.entityData.get(DATA_IS_LEAPING);
    }
    public void setLeaping(Boolean leaping) {
        this.entityData.set(DATA_IS_LEAPING, leaping);
    }

    public boolean isFluttering() {
        return this.entityData.get(DATA_IS_FLUTTERING);
    }
    public void setFluttering(Boolean fluttering) {
        this.entityData.set(DATA_IS_FLUTTERING, fluttering);
    }

    public MantisWingPose getWingPose() {
        if (this.isLeaping()) {
            return MantisWingPose.LEAPING;
        } else if (this.isAggressive()) {
            return MantisWingPose.AGGRESSIVE;
        } else {
            return MantisWingPose.PASSIVE;
        }
    }

    static class MantisLeapGoal extends LeapAtTargetGoal {
        private final Mob mob;
        private LivingEntity target;
        private final float yd;
        private final MantisEntity mantis;

        public MantisLeapGoal(Mob pMob, float pYd, MantisEntity mantisEntity) {
            super(pMob, pYd);
            this.mob = pMob;
            this.yd = pYd;
            this.mantis = mantisEntity;
        }

        public boolean canUse() {
            if(this.mob.isOnGround() || this.mob.isInFluidType()) {
                this.mantis.setLeaping(false);
            }

            if (this.mob.isVehicle()) {
                return false;
            } else {
                this.target = this.mob.getTarget();
                if (this.target == null) {
                    return false;
                } else {
                    double d0 = this.mob.distanceToSqr(this.target);
                    if (!(d0 < 4.0D) && !(d0 > 16.0D)) {
                        if (!this.mob.isOnGround()) {
                            return false;
                        } else {
                            return this.mob.getRandom().nextInt(reducedTickDelay(5)) == 0;
                        }
                    } else {
                        return false;
                    }
                }
            }
        }

        public void start() {
            this.mantis.setLeaping(true);
            Vec3 vec3 = this.mob.getDeltaMovement();
            Vec3 vec31 = new Vec3(this.target.getX() - this.mob.getX(), 0.0D, this.target.getZ() - this.mob.getZ());
            if (vec31.lengthSqr() > 1.0E-7D) {
                vec31 = vec31.normalize().scale(0.4D).add(vec3.scale(0.2D));
            }
            this.mob.setDeltaMovement(vec31.x, (double)this.yd, vec31.z);
        }
    }
}
