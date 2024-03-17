package net.invictusslayer.slayersbeasts.common.world.biome;

import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class SBEndBiomes {
	public static Biome endSpikes(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers) {
		BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(features, carvers);
		return endBiome(biomeSettings);
	}

	private static Biome endBiome(BiomeGenerationSettings.Builder biomeSettings) {
		MobSpawnSettings.Builder mobSettings = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.endSpawns(mobSettings);
		return new Biome.BiomeBuilder().hasPrecipitation(false).temperature(0.5F).downfall(0.5F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(10518688).skyColor(0).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobSettings.build()).generationSettings(biomeSettings.build()).build();
	}
}
