package net.invictusslayer.slayersbeasts.common.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;

public class SBPotions {
	public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(SlayersBeasts.MOD_ID, Registries.POTION);

	public static final RegistrySupplier<Potion> PARALYSIS_POTION = POTIONS.register("paralysis_potion", () -> new Potion("paralysis", new MobEffectInstance(SBEffects.PARALYSIS, 900, 0)));
	public static final RegistrySupplier<Potion> WITHER_POTION = POTIONS.register("wither_potion", () -> new Potion("wither", new MobEffectInstance(MobEffects.WITHER, 1800, 0)));
}
