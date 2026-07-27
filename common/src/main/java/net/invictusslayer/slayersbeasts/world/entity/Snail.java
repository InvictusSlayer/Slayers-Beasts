package net.invictusslayer.slayersbeasts.world.entity;

import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.level.Level;

public class Snail extends PathfinderMob {
    public final AnimationState crawlAnimationState = new AnimationState();

    public Snail(EntityType<Snail> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(0, new FloatGoal(this));
        goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 1.0D));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 6.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.08D);
    }

    @Override
    public void tick() {
        super.tick();

        if (level().isClientSide()) setupAnimationStates();
    }

    private void setupAnimationStates() {
        crawlAnimationState.animateWhen(true, tickCount);
    }
}
