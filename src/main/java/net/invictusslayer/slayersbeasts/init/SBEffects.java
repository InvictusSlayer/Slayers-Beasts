package net.invictusslayer.slayersbeasts.init;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.effect.ParalysisEffect;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

import java.util.function.Supplier;

public class SBEffects {
	//? if neoforge
	/*public static final net.neoforged.neoforge.registries.DeferredRegister<MobEffect> EFFECTS = net.neoforged.neoforge.registries.DeferredRegister.create(Registries.MOB_EFFECT, SlayersBeasts.MOD_ID);*/

	public static final Supplier<MobEffect> PARALYSIS = register("paralysis", new ParalysisEffect(MobEffectCategory.HARMFUL, 0xe4e924));

	private static <T extends MobEffect> Supplier<T> register(String name, T effect) {
		//? if fabric
		return () -> Registry.register(BuiltInRegistries.MOB_EFFECT, ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, name), effect);
		//? if neoforge
		/*return EFFECTS.register(name, () -> effect);*/
	}

	public static void init() {
		SlayersBeasts.LOGGER.info("Initialised Effects");
	}
}
