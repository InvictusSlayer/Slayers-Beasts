package net.invictusslayer.slayersbeasts.common.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

public class Irk extends PathfinderMob {
	public Irk(EntityType<? extends PathfinderMob> type, Level level) {
		super(type, level);
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes()
				.add(Attributes.MOVEMENT_SPEED, 0.2F)
				.add(Attributes.FOLLOW_RANGE, 20.0D)
				.add(Attributes.MAX_HEALTH, 8.0D)
				.add(Attributes.ATTACK_DAMAGE, 2.5D)
				.add(Attributes.ATTACK_SPEED, 1.0D)
				.add(Attributes.ATTACK_KNOCKBACK, 1.0D);
	}
}
