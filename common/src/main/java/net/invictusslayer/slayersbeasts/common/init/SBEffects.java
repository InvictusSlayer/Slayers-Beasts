package net.invictusslayer.slayersbeasts.common.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.effect.ParalysisEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class SBEffects {
	public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(SlayersBeasts.MOD_ID, Registries.MOB_EFFECT);

	public static final RegistrySupplier<MobEffect> PARALYSIS = EFFECTS.register("paralysis", () -> new ParalysisEffect(MobEffectCategory.HARMFUL, 0xe4e924));
}
