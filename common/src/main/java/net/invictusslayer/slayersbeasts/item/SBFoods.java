package net.invictusslayer.slayersbeasts.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class SBFoods {
	public static final FoodProperties INSECT_LEG = new FoodProperties.Builder().nutrition(3).saturationModifier(0.3F).build();
	public static final FoodProperties FRIED_INSECT_LEG = new FoodProperties.Builder().nutrition(7).saturationModifier(0.6F).build();
	public static final FoodProperties INSECT_EYE = new FoodProperties.Builder().nutrition(2).saturationModifier(0.8F).build();
}
