package net.invictusslayer.slayersbeasts.sound;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class SBSounds {
	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SlayersBeasts.MOD_ID);

	public static final RegistryObject<SoundEvent> MUSIC_DISC_INKISH = register("music_disc.inkish");
	public static final RegistryObject<SoundEvent> MANTIS_AMBIENT = register("entity.mantis.ambient");
	public static final RegistryObject<SoundEvent> MANTIS_DEATH = register("entity.mantis.death");
	public static final RegistryObject<SoundEvent> MANTIS_HURT = register("entity.mantis.hurt");

	private static RegistryObject<SoundEvent> register(String name) {
		return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SlayersBeasts.MOD_ID, name)));
	}
}
