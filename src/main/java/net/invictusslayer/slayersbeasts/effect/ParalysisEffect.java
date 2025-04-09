package net.invictusslayer.slayersbeasts.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class ParalysisEffect extends MobEffect {
	public ParalysisEffect(MobEffectCategory category, int color) {
		super(category, color);
	}

	public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
		if (!level.isClientSide()) {
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();

			entity.teleportTo(x, y, z);
			entity.setDeltaMovement(0, 0, 0);
		}

		return super.applyEffectTick(level, entity, amplifier);
	}
}