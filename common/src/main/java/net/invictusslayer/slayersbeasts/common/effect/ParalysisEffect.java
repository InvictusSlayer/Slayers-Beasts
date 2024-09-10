package net.invictusslayer.slayersbeasts.common.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class ParalysisEffect extends MobEffect {
	public ParalysisEffect(MobEffectCategory category, int color) {
		super(category, color);
	}

	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		if (!entity.level().isClientSide()) {
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();

			entity.teleportTo(x, y, z);
			entity.setDeltaMovement(0, 0, 0);
		}

		return super.applyEffectTick(entity, amplifier);
	}
}