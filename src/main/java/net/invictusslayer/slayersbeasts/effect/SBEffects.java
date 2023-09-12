package net.invictusslayer.slayersbeasts.effect;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SBEffects {
    public static DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, SlayersBeasts.MOD_ID);

    public static final RegistryObject<MobEffect> PARALYSIS = EFFECTS.register("paralysis", () -> new ParalysisEffect(MobEffectCategory.HARMFUL, 0xe4e924));
}
