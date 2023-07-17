package net.invictusslayer.slayersbeasts.effect;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SBEffects {
    public static DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, SlayersBeasts.MOD_ID);

    public static final RegistryObject<MobEffect> PARALYSIS = MOB_EFFECTS.register("paralysis",
            () -> new ParalysisEffect(MobEffectCategory.HARMFUL, 0xe4e924));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
