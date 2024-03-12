package net.invictusslayer.slayersbeasts.common.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class SBSounds {
	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(SlayersBeasts.MOD_ID, Registries.SOUND_EVENT);

	public static final RegistrySupplier<SoundEvent> MUSIC_DISC_INKISH = register("music_disc.inkish");
	public static final RegistrySupplier<SoundEvent> MANTIS_AMBIENT = register("entity.mantis.ambient");
	public static final RegistrySupplier<SoundEvent> MANTIS_DEATH = register("entity.mantis.death");
	public static final RegistrySupplier<SoundEvent> MANTIS_HURT = register("entity.mantis.hurt");

	private static RegistrySupplier<SoundEvent> register(String name) {
		return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SlayersBeasts.MOD_ID, name)));
	}
}
