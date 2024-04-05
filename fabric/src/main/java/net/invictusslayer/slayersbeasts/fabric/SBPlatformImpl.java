package net.invictusslayer.slayersbeasts.fabric;

import dev.architectury.registry.level.biome.BiomeModifications;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.HolderGetter;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.nio.file.Path;
import java.util.List;

public class SBPlatformImpl {
	public static HolderGetter<PlacedFeature> placedFeatures;

	public static Path getConfigDirectory() {
		return FabricLoader.getInstance().getConfigDir();
	}

	@SafeVarargs
	public static void addFeatureBiomeModifier(String name, TagKey<Biome> biomes, GenerationStep.Decoration step, ResourceKey<PlacedFeature>... features) {
		BiomeModifications.addProperties(context -> context.hasTag(biomes), (context, mutable) -> List.of(features).forEach(feature -> mutable.getGenerationProperties().addFeature(step, placedFeatures.getOrThrow(feature))));
	}
}
