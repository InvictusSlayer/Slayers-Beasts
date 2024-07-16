package net.invictusslayer.slayersbeasts.neoforge.world;

import com.ibm.icu.impl.Pair;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SBBiomeModifiers {
	public static Map<String, Pair<TagKey<Biome>, Pair<List<ResourceKey<PlacedFeature>>, GenerationStep.Decoration>>> biomeModifiers = new HashMap<>();

	public static void bootstrap(BootstapContext<BiomeModifier> context) {
		HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
		HolderGetter<PlacedFeature> placed = context.lookup(Registries.PLACED_FEATURE);

		biomeModifiers.forEach((name, biomeFeatureStep) -> {
			List<Holder<PlacedFeature>> features = new ArrayList<>();
			biomeFeatureStep.second.first.forEach(feature -> features.add(placed.getOrThrow(feature)));
			HolderSet<PlacedFeature> feature = HolderSet.direct(features);
			context.register(ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(SlayersBeasts.MOD_ID, name)), new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(biomeFeatureStep.first), feature, biomeFeatureStep.second.second));
		});
	}
}
