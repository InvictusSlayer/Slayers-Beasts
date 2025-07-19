package net.invictusslayer.slayersbeasts.forge.world;

import com.ibm.icu.impl.Pair;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SBForgeBiomeModifiers {
	public static Map<String, Pair<TagKey<Biome>, Pair<List<ResourceKey<PlacedFeature>>, GenerationStep.Decoration>>> BIOME_MODIFIERS = new HashMap<>();

	public static void bootstrap(BootstrapContext<BiomeModifier> context) {
		HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
		HolderGetter<PlacedFeature> placed = context.lookup(Registries.PLACED_FEATURE);

		BIOME_MODIFIERS.forEach((name, biomeFeatureStep) -> {
			List<Holder<PlacedFeature>> features = new ArrayList<>();
			biomeFeatureStep.second.first.forEach(feature -> features.add(placed.getOrThrow(feature)));
			HolderSet<PlacedFeature> feature = HolderSet.direct(features);
			context.register(ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, name)), new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(biomeFeatureStep.first), feature, biomeFeatureStep.second.second));
		});
	}
}
