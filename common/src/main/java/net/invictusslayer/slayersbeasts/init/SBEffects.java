package net.invictusslayer.slayersbeasts.init;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.effect.ParalysisEffect;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

import java.util.function.Supplier;

public class SBEffects {
	public static final Supplier<Holder.Reference<MobEffect>> PARALYSIS = register("paralysis", () -> new ParalysisEffect(MobEffectCategory.HARMFUL, 0xe4e924));

	private static Supplier<Holder.Reference<MobEffect>> register(String name, Supplier<MobEffect> supplier) {
		return SlayersBeasts.PLATFORM.registerHolder(BuiltInRegistries.MOB_EFFECT, SlayersBeasts.MOD_ID, name, supplier);
	}

	public static void register() {
		SlayersBeasts.LOGGER.info("Registering SBMobEffects...");
	}
}
