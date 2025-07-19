package net.invictusslayer.slayersbeasts.neoforge;

import com.ibm.icu.impl.Pair;
import net.invictusslayer.slayersbeasts.neoforge.world.SBNeoForgeBiomeModifiers;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class SBPlatformImpl {
	@SafeVarargs
	public static void addFeatureBiomeModifier(String name, TagKey<Biome> biomes, GenerationStep.Decoration step, ResourceKey<PlacedFeature>... features) {
		SBNeoForgeBiomeModifiers.BIOME_MODIFIERS.put("add_" + name, Pair.of(biomes, Pair.of(List.of(features), step)));
	}
}
