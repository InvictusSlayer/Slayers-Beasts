package net.invictusslayer.slayersbeasts.misc;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SlayersBeasts.MOD_ID);

//    public static final RegistryObject<SoundEvent> MANTIS_AMBIENT = registerSoundEvent("mantis_ambient");
//    public static final RegistryObject<SoundEvent> MANTIS_DEATH = registerSoundEvent("mantis_death");
//    public static final RegistryObject<SoundEvent> MANTIS_HURT = registerSoundEvent("mantis_hurt");
//
//    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
//        return SOUND_EVENTS.register(name, () -> new (new ResourceLocation(SlayersBeasts.MOD_ID, name)));
//    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
