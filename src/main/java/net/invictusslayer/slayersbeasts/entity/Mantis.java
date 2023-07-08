package net.invictusslayer.slayersbeasts.entity;

import net.invictusslayer.slayersbeasts.misc.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class Mantis extends PathfinderMob {
    private static final EntityDataAccessor<Boolean> DATA_IS_LEAPING = SynchedEntityData.defineId(Mantis.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> DATA_IS_FLUTTERING = SynchedEntityData.defineId(Mantis.class, EntityDataSerializers.BOOLEAN);

    public Mantis(EntityType<Mantis> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MantisLeapGoal(this, 0.4F));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(6, new FlutterWingsGoal(this));
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
//            if (pEntity instanceof LivingEntity && random.nextBoolean()) {
//                ((LivingEntity)pEntity).addEffect(new MobEffectInstance(ModEffects.PARALYSIS.get(), 30), this);
//            }
            return true;
        }
    }

    protected SoundEvent getAmbientSound() {return ModSounds.MANTIS_AMBIENT.get();}
    protected SoundEvent getDeathSound() {return ModSounds.MANTIS_DEATH.get();}
    protected SoundEvent getHurtSound(DamageSource damageSource) {return ModSounds.MANTIS_HURT.get();}

    public MobType getMobType() {
        return MobType.ARTHROPOD;
    }

    public static boolean canSpawn(EntityType<Mantis> entity, LevelAccessor levelAccess, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
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

    public MantisPose getMantisPose() {
        if (this.isLeaping()) {
            return MantisPose.LEAPING;
        } else if (this.isFluttering()) {
            return MantisPose.FLUTTERING;
        } else {
            return MantisPose.PASSIVE;
        }
    }

    @Override
    public Pose getPose() {
        return super.getPose();
    }

    static class FlutterWingsGoal extends Goal {
        private final Mantis mob;
        private int flutterTime;

        public FlutterWingsGoal(Mantis pMob) {
            super();
            this.mob = pMob;
        }

        @Override
        public boolean canUse() {
            return this.mob.onGround() && this.mob.getRandom().nextFloat() < 0.02F;
        }

        public boolean canContinueToUse() {
            return this.flutterTime >= 0;
        }

        public void start() {
            this.mob.setFluttering(true);
            this.flutterTime = 15 + this.mob.getRandom().nextInt(15);
        }

        public void stop() {
            this.mob.setFluttering(false);
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            --this.flutterTime;
        }

    }

    static class MantisLeapGoal extends LeapAtTargetGoal {
        private final Mantis mob;

        public MantisLeapGoal(Mantis pMob, float pYd) {
            super(pMob, pYd);
            this.mob = pMob;
        }

        public void start() {
            this.mob.setLeaping(true);
            super.start();
        }

        public void stop() {
            this.mob.setLeaping(false);
        }

    }

    public enum MantisPose {
        PASSIVE,
        AGGRESSIVE,
        LEAPING,
        FLUTTERING,
        FLYING
    }
}
