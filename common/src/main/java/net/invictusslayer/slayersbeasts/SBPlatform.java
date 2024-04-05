package net.invictusslayer.slayersbeasts;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.nio.file.Path;

public class SBPlatform {
	@ExpectPlatform
	public static Path getConfigDirectory() {
		throw new AssertionError();
	}

	@SafeVarargs
	@ExpectPlatform
	public static void addFeatureBiomeModifier(String name, TagKey<Biome> biomes, GenerationStep.Decoration stage, ResourceKey<PlacedFeature>... features) {
		throw new AssertionError();
	}
}
