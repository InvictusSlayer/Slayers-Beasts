package net.invictusslayer.slayersbeasts.entity;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;

public class Wudu extends AbstractEnt {
	private static final EntityDataAccessor<Boolean> DATA_HAS_LEFT_ARM = SynchedEntityData.defineId(Wudu.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> DATA_HAS_RIGHT_ARM = SynchedEntityData.defineId(Wudu.class, EntityDataSerializers.BOOLEAN);

	public Wudu(EntityType<Wudu> type, Level level) {
		super(type, level);
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes()
				.add(Attributes.MOVEMENT_SPEED, 0.12F)
				.add(Attributes.FOLLOW_RANGE, 30.0D)
				.add(Attributes.MAX_HEALTH, 50.0D)
				.add(Attributes.ATTACK_DAMAGE, 1.0D)
				.add(Attributes.ATTACK_SPEED, 0.5D)
				.add(Attributes.ATTACK_KNOCKBACK, 1.0D);
	}

	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(DATA_HAS_LEFT_ARM, false);
		builder.define(DATA_HAS_RIGHT_ARM, false);
	}

	protected void setupAnimationStates() {

	}

	static class WuduGrabGoal extends Goal {

		public boolean canUse() {
			return false;
		}
	}
}
