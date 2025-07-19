package net.invictusslayer.slayersbeasts.forge;

import com.ibm.icu.impl.Pair;
import net.invictusslayer.slayersbeasts.forge.world.SBForgeBiomeModifiers;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class SBPlatformImpl {
	@SafeVarargs
	public static void addFeatureBiomeModifier(String name, TagKey<Biome> biomes, GenerationStep.Decoration step, ResourceKey<PlacedFeature>... features) {
		SBForgeBiomeModifiers.BIOME_MODIFIERS.put("add_" + name, Pair.of(biomes, Pair.of(List.of(features), step)));
	}
}
