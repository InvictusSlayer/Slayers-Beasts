package net.invictusslayer.slayersbeasts.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.RandomSource;
import net.minecraft.util.TimeUtil;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class AntSoldier extends AbstractAnt implements NeutralMob {
	private static final EntityDataAccessor<Integer> DATA_REMAINING_ANGER_TIME = SynchedEntityData.defineId(AntSoldier.class, EntityDataSerializers.INT);
	private UUID target;

	public AntSoldier(EntityType<AntSoldier> type, Level level) {
		super(type, level);
	}

	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(DATA_REMAINING_ANGER_TIME, 0);
	}

	protected void registerGoals() {
		super.registerGoals();
		goalSelector.addGoal(0, new MeleeAttackGoal(this, 1D, true));
		targetSelector.addGoal(0, new HurtByTargetGoal(this));
		targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, 10, false, false, this::isAngryAt));
		targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Mob.class, 10, false, true, this::isAngryAt));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes()
				.add(Attributes.MOVEMENT_SPEED, 0.22D)
				.add(Attributes.MAX_HEALTH, 15D)
				.add(Attributes.ATTACK_DAMAGE, 5D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 0.5D);
	}

	public static boolean canSpawn(EntityType<AntSoldier> entity, LevelAccessor level, EntitySpawnReason reason, BlockPos pos, RandomSource random) {
		return PathfinderMob.checkMobSpawnRules(entity, level, reason, pos, random);
	}

	public int getRemainingPersistentAngerTime() {
		return entityData.get(DATA_REMAINING_ANGER_TIME);
	}

	public void setRemainingPersistentAngerTime(int time) {
		entityData.set(DATA_REMAINING_ANGER_TIME, time);
	}

	public UUID getPersistentAngerTarget() {
		return target;
	}

	public void setPersistentAngerTarget(@Nullable UUID target) {
		this.target = target;
	}

	public void startPersistentAngerTimer() {
		setRemainingPersistentAngerTime(TimeUtil.rangeOfSeconds(30, 60).sample(random));
	}
}
