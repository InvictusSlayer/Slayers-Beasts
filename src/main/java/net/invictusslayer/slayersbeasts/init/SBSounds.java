package net.invictusslayer.slayersbeasts.init;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public class SBSounds {
	//? if neoforge
	/*public static final net.neoforged.neoforge.registries.DeferredRegister<SoundEvent> SOUNDS = net.neoforged.neoforge.registries.DeferredRegister.create(Registries.SOUND_EVENT, SlayersBeasts.MOD_ID);*/

	public static final Supplier<SoundEvent> MUSIC_DISC_INKISH = register("music_disc.inkish");
	public static final Supplier<SoundEvent> MANTIS_AMBIENT = register("entity.mantis.ambient");
	public static final Supplier<SoundEvent> MANTIS_DEATH = register("entity.mantis.death");
	public static final Supplier<SoundEvent> MANTIS_HURT = register("entity.mantis.hurt");

	private static Supplier<SoundEvent> register(String name) {
		//? if fabric
		return () -> Registry.register(BuiltInRegistries.SOUND_EVENT, ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, name), SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, name)));
		//? if neoforge
		/*return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, name)));*/
	}

	public static void init() {
		SlayersBeasts.LOGGER.info("Initialised Sounds");
	}
}
