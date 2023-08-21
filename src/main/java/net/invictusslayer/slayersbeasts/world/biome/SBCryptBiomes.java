package net.invictusslayer.slayersbeasts.world.biome;

import net.minecraft.core.HolderGetter;
import net.minecraft.sounds.Music;
import net.minecraft.util.Mth;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import javax.annotation.Nullable;

public class SBCryptBiomes {
	private static final int DEFAULT_WATER = 4159204;
	private static final int DEFAULT_WATER_FOG = 329011;
	private static final int DEFAULT_FOG = 12638463;
	private static final Biome.TemperatureModifier NONE = Biome.TemperatureModifier.NONE;

	public static Biome theCrypt(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pWorldCarvers) {
		BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pWorldCarvers);
		return biome(false, 0.5F, 0.5F, new MobSpawnSettings.Builder(), biomeSettings, null);
	}

	private static Biome biome(boolean pHasPrecipitation, float pTemperature, float pDownfall, MobSpawnSettings.Builder pMobSpawnSettings, BiomeGenerationSettings.Builder pGenerationSettings, @Nullable Music pBackgroundMusic) {
		return biome(pHasPrecipitation, pTemperature, pDownfall, NONE, DEFAULT_WATER, DEFAULT_WATER_FOG, null, null, null, pMobSpawnSettings, pGenerationSettings, pBackgroundMusic);
	}

	private static Biome biome(boolean pHasPrecipitation, float pTemperature, float pDownfall, Biome.TemperatureModifier pTemperatureModifier, int pWaterColor, int pWaterFogColor, @Nullable Integer pGrassColorOverride, @Nullable Integer pFoliageColorOverride, @Nullable BiomeSpecialEffects.GrassColorModifier pGrassColorModifier, MobSpawnSettings.Builder pMobSpawnSettings, BiomeGenerationSettings.Builder pGenerationSettings, @Nullable Music pBackgroundMusic) {
		BiomeSpecialEffects.Builder biomeEffects = new BiomeSpecialEffects.Builder().waterColor(pWaterColor).waterFogColor(pWaterFogColor).fogColor(DEFAULT_FOG).skyColor(calculateSkyColor(pTemperature)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(pBackgroundMusic);
		if (pGrassColorOverride != null) {
			biomeEffects.grassColorOverride(pGrassColorOverride);
		}
		if (pFoliageColorOverride != null) {
			biomeEffects.foliageColorOverride(pFoliageColorOverride);
		}
		if (pGrassColorModifier != null) {
			biomeEffects.grassColorModifier(pGrassColorModifier);
		}

		return new Biome.BiomeBuilder().hasPrecipitation(pHasPrecipitation).temperature(pTemperature).downfall(pDownfall).temperatureAdjustment(pTemperatureModifier).specialEffects(biomeEffects.build()).mobSpawnSettings(pMobSpawnSettings.build()).generationSettings(pGenerationSettings.build()).build();
	}

	private static int calculateSkyColor(float pTemperature) {
		float $$1 = pTemperature / 3.0F;
		$$1 = Mth.clamp($$1, -1.0F, 1.0F);
		return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
	}
}
