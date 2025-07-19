package net.invictusslayer.slayersbeasts.common.init;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public class SBSounds {
	public static final Supplier<Holder.Reference<SoundEvent>> MUSIC_DISC_INKISH = registerHolder("music_disc.inkish");
	public static final Supplier<SoundEvent> MANTIS_AMBIENT = register("entity.mantis.ambient");
	public static final Supplier<SoundEvent> MANTIS_DEATH = register("entity.mantis.death");
	public static final Supplier<SoundEvent> MANTIS_HURT = register("entity.mantis.hurt");

	private static Supplier<Holder.Reference<SoundEvent>> registerHolder(String name) {
		return SlayersBeasts.PLATFORM.registerHolder(BuiltInRegistries.SOUND_EVENT, name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, name)));
	}

	private static Supplier<SoundEvent> register(String name) {
		return SlayersBeasts.PLATFORM.register(BuiltInRegistries.SOUND_EVENT, name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, name)));
	}

	public static void register() {
		SlayersBeasts.LOGGER.info("Registering SBMobEffects...");
	}
}
