package net.invictusslayer.slayersbeasts.entities;

import net.invictusslayer.slayersbeasts.init.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
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

import java.util.Random;

public class MantisEntity extends PathfinderMob {
    public MantisEntity(EntityType<MantisEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.23F)
                .add(Attributes.FOLLOW_RANGE, 16.0D)
                .add(Attributes.MAX_HEALTH, 15.0D)
                .add(Attributes.ATTACK_DAMAGE, 2.0D)
                .add(Attributes.ATTACK_SPEED, 2.0D)
                .add(Attributes.ATTACK_KNOCKBACK, 1.0D);
    }

    protected SoundEvent getAmbientSound() {return ModSounds.MANTIS_AMBIENT.get();}
    protected SoundEvent getDeathSound() {return ModSounds.MANTIS_DEATH.get();}
    protected SoundEvent getHurtSound(DamageSource damageSource) {return ModSounds.MANTIS_HURT.get();}

    public static boolean canSpawn(EntityType<MantisEntity> entity, LevelAccessor levelAccess,
                                   MobSpawnType spawnType, BlockPos pos, Random random) {
        return PathfinderMob.checkMobSpawnRules(entity, levelAccess, spawnType, pos, random)
                && levelAccess instanceof final Level level && level.getDifficulty() != Difficulty.PEACEFUL;
    }

    public MobType getMobType() {return MobType.ARTHROPOD;}
}
