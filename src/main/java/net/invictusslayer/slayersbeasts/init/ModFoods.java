package net.invictusslayer.slayersbeasts.init;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties INSECT_LEG = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3f).build();
    public static final FoodProperties FRIED_INSECT_LEG = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.6f).build();
    public static final FoodProperties INSECT_EYE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.8F).effect(new MobEffectInstance(MobEffects.POISON, 100, 0), 0.5F).build();
}
