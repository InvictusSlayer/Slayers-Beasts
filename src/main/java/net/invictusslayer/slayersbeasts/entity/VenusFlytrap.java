package net.invictusslayer.slayersbeasts.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class VenusFlytrap extends PathfinderMob {
    public VenusFlytrap(EntityType<VenusFlytrap> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 16.0F));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                .add(Attributes.KNOCKBACK_RESISTANCE, 5.0D)
                .add(Attributes.FOLLOW_RANGE, 16.0D)
                .add(Attributes.MAX_HEALTH, 35.0D)
                .add(Attributes.ATTACK_DAMAGE, 8.0D)
                .add(Attributes.ATTACK_SPEED, 5.0D)
                .add(Attributes.ATTACK_KNOCKBACK, 0.0D);
    }

    public static boolean canSpawn(EntityType<VenusFlytrap> entity, LevelAccessor levelAccess, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return PathfinderMob.checkMobSpawnRules(entity, levelAccess, spawnType, pos, random)
                && levelAccess instanceof final Level level && level.getDifficulty() != Difficulty.PEACEFUL;
    }

    public MobType getMobType() {return MobType.UNDEFINED;}
}
