package net.invictusslayer.slayersbeasts.misc;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.effect.SBEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SBPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(ForgeRegistries.POTIONS, SlayersBeasts.MOD_ID);

    public static final RegistryObject<Potion> PARALYSIS_POTION = POTIONS.register("paralysis_potion",
            () -> new Potion(new MobEffectInstance(SBEffects.PARALYSIS.get(), 900, 0)));
    public static final RegistryObject<Potion> WITHER_POTION = POTIONS.register("wither_potion",
            () -> new Potion(new MobEffectInstance(MobEffects.WITHER, 1800, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
