package net.invictusslayer.slayersbeasts.fabric;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.nio.file.Path;

public class SBPlatformImpl {
	public static Path getConfigDirectory() {
		return FabricLoader.getInstance().getConfigDir();
	}

	@SafeVarargs
	public static void addFeatureBiomeModifier(String name, TagKey<Biome> biomes, GenerationStep.Decoration step, ResourceKey<PlacedFeature>... features) {
//		for (int i = 0; i < features.length; i++) {
//			int j = i;
//			BiomeModifications.create(new ResourceLocation(SlayersBeasts.MOD_ID, name + i)).add(ModificationPhase.ADDITIONS,
//					context -> context.hasTag(biomes), context -> context.getGenerationSettings().addFeature(step, List.of(features).get(j)));
//		}
	}
}
