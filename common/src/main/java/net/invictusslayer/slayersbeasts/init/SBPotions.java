package net.invictusslayer.slayersbeasts.init;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;

import java.util.function.Supplier;

public class SBPotions {
	public static final Supplier<Potion> PARALYSIS_POTION = register("paralysis_potion", () -> new Potion("paralysis", new MobEffectInstance(SBEffects.PARALYSIS.get(), 900, 0)));
	public static final Supplier<Potion> WITHER_POTION = register("wither_potion", () -> new Potion("wither", new MobEffectInstance(MobEffects.WITHER, 1800, 0)));

	private static <T extends Potion> Supplier<T> register(String name, Supplier<T> supplier) {
		return SlayersBeasts.PLATFORM.register(BuiltInRegistries.POTION, SlayersBeasts.MOD_ID, name, supplier);
	}

	public static void register() {
		SlayersBeasts.LOGGER.info("Registering SBPotions...");
	}
}
