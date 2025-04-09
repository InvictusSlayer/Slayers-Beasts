package net.invictusslayer.slayersbeasts.init;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;

import java.util.function.Supplier;

public class SBPotions {
	//? if neoforge
	/*public static final net.neoforged.neoforge.registries.DeferredRegister<Potion> POTIONS = net.neoforged.neoforge.registries.DeferredRegister.create(Registries.POTION, SlayersBeasts.MOD_ID);*/

//	public static final Supplier<Potion> PARALYSIS_POTION = register("paralysis_potion", new Potion("paralysis", new MobEffectInstance(SBEffects.PARALYSIS.get(), 900, 0)));
	public static final Supplier<Potion> WITHER_POTION = register("wither_potion", new Potion("wither", new MobEffectInstance(MobEffects.WITHER, 1800, 0)));

	private static <T extends Potion> Supplier<T> register(String name, T potion) {
		//? if fabric
		return () -> Registry.register(BuiltInRegistries.POTION, ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, name), potion);
		//? if neoforge
		/*return POTIONS.register(name, () -> potion);*/
	}

	public static void init() {
		SlayersBeasts.LOGGER.info("Initialised Potions");
	}
}
