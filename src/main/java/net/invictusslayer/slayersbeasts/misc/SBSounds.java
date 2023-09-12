package net.invictusslayer.slayersbeasts.misc;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class SBSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SlayersBeasts.MOD_ID);

    public static final RegistryObject<SoundEvent> MANTIS_AMBIENT = registerSoundEvent("mantis_ambient");
    public static final RegistryObject<SoundEvent> MANTIS_DEATH = registerSoundEvent("mantis_death");
    public static final RegistryObject<SoundEvent> MANTIS_HURT = registerSoundEvent("mantis_hurt");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SlayersBeasts.MOD_ID, name)));
    }
}
