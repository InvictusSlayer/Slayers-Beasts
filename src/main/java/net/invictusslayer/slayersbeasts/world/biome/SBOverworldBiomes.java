package net.invictusslayer.slayersbeasts.world.biome;

import net.invictusslayer.slayersbeasts.entity.SBEntities;
import net.invictusslayer.slayersbeasts.world.feature.SBPlacedFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import javax.annotation.Nullable;

public class SBOverworldBiomes {
    private static final int DEFAULT_WATER = 4159204;
    private static final int DEFAULT_WATER_FOG = 329011;
    private static final int DEFAULT_FOG = 12638463;
    private static final Biome.TemperatureModifier FROZEN = Biome.TemperatureModifier.FROZEN;
    private static final Biome.TemperatureModifier NONE = Biome.TemperatureModifier.NONE;
    private static final Music MUSIC_DESERT = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_DESERT);
    private static final Music MUSIC_FOREST = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FOREST);
    private static final Music MUSIC_FROZEN = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FROZEN_PEAKS);
    private static final Music MUSIC_OUTBACK = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_BADLANDS);
    private static final Music MUSIC_RAINFOREST = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JUNGLE);
    private static final Music MUSIC_REDWOOD = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_OLD_GROWTH_TAIGA);
    private static final Music MUSIC_SWAMP = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SWAMP);
    private static final Music MUSIC_VOLCANIC = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_BASALT_DELTAS);

    public static Biome aspenForest(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pWorldCarvers) {
        MobSpawnSettings.Builder mobSettings = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(mobSettings);

        BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pWorldCarvers);
        globalOverworldGeneration(biomeSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeSettings);
        biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_FOREST);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeSettings);
        addModUndergroundVariety(biomeSettings);
        addModMushrooms(biomeSettings);
        biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.TREES_ASPEN);
        return biome(true, 0.6F, 0.6F, mobSettings, biomeSettings, MUSIC_FOREST);
    }

    public static Biome desert(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pWorldCarvers) {
        MobSpawnSettings.Builder mobSettings = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(mobSettings);
        mobSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.HUSK, 80, 4, 4));

        BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pWorldCarvers);
        globalOverworldGeneration(biomeSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeSettings);
        biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_DEAD_BUSH);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeSettings);
        addModUndergroundVariety(biomeSettings);
        addModMushrooms(biomeSettings);
        return biome(false, 2F, 0F, mobSettings, biomeSettings, MUSIC_DESERT);
    }

    public static Biome eucalyptForest(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pWorldCarvers) {
        MobSpawnSettings.Builder mobSettings = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(mobSettings);

        BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pWorldCarvers);
        globalOverworldGeneration(biomeSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeSettings);
        biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_LARGE_FERN);
        biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_TAIGA_2);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeSettings);
        addModUndergroundVariety(biomeSettings);
        addModMushrooms(biomeSettings);
        biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.TREES_EUCALYPT);
        return biome(true, 2F, 0F, mobSettings, biomeSettings, MUSIC_FOREST);
    }

    public static Biome frozenThicket(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pWorldCarvers) {
        MobSpawnSettings.Builder mobSettings = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(mobSettings);

        BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pWorldCarvers);
        globalOverworldGeneration(biomeSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeSettings);
        addModUndergroundVariety(biomeSettings);
        addModMushrooms(biomeSettings);
        return biome(true, 0F, 0F, FROZEN, DEFAULT_WATER, DEFAULT_WATER_FOG, null, null, null, mobSettings, biomeSettings, MUSIC_FROZEN);
    }

    public static Biome inkyMoor(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pWorldCarvers) {
        MobSpawnSettings.Builder mobSettings = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(mobSettings);
        mobSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 1, 1, 1));
        mobSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FROG, 10, 2, 5));
        mobSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(SBEntities.DAMSELFLY.get(), 4, 1, 1));

        BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pWorldCarvers);
        globalOverworldGeneration(biomeSettings);
        BiomeDefaultFeatures.addMangroveSwampDisks(biomeSettings);
        biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_NORMAL);
        biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_DEAD_BUSH);
        biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_WATERLILY);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeSettings);
        biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_SUGAR_CANE_SWAMP);
        addModUndergroundVariety(biomeSettings);
        addModMushrooms(biomeSettings);
        biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.TREES_INKY);
        return biome(true, 0.9F, 0.8F, NONE, 2642743, 2192174, null, 6975545, BiomeSpecialEffects.GrassColorModifier.SWAMP, mobSettings, biomeSettings, MUSIC_SWAMP);
    }

    public static Biome outback(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pWorldCarvers) {
        MobSpawnSettings.Builder mobSettings = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(mobSettings);

        BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pWorldCarvers);
        globalOverworldGeneration(biomeSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeSettings);
        biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_NORMAL);
        biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_DEAD_BUSH);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeSettings);
        addModUndergroundVariety(biomeSettings);
        addModMushrooms(biomeSettings);
        biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.TREES_OUTBACK);
        return biome(false, 2F, 0F, mobSettings, biomeSettings, MUSIC_OUTBACK); // gc-9470285 fc-10387789
    }

    public static Biome petrifiedWoods(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pWorldCarvers) {
        MobSpawnSettings.Builder mobSettings = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(mobSettings);

        BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pWorldCarvers);
        globalOverworldGeneration(biomeSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeSettings);
        addModUndergroundVariety(biomeSettings);
        return biome(false, 0F, 0F, Biome.TemperatureModifier.FROZEN, DEFAULT_WATER, DEFAULT_WATER_FOG, null, null, null, mobSettings, biomeSettings, MUSIC_FROZEN);
    }

    public static Biome rainforest(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pWorldCarvers) {
        MobSpawnSettings.Builder mobSettings = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(mobSettings);
        mobSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(SBEntities.DAMSELFLY.get(), 4, 1, 1));

        BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pWorldCarvers);
        globalOverworldGeneration(biomeSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeSettings);
        biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_JUNGLE);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeSettings);
        addModUndergroundVariety(biomeSettings);
        addModMushrooms(biomeSettings);
        biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.TREES_RAINFOREST);
        return biome(true, 2F, 0F, mobSettings, biomeSettings, MUSIC_RAINFOREST);
    }

    public static Biome redwoodGrove(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pWorldCarvers, boolean pIsOldGrowth) {
        MobSpawnSettings.Builder mobSettings = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(mobSettings);

        BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pWorldCarvers);
        globalOverworldGeneration(biomeSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeSettings);
        biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_LARGE_FERN);
        biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_TAIGA);
        biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_DEAD_BUSH);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeSettings);
        addModUndergroundVariety(biomeSettings);
        addModMushrooms(biomeSettings);
        biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.WHITE_MUSHROOM_COMMON);
        biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, pIsOldGrowth ? SBPlacedFeatures.TREES_OLD_GROWTH_REDWOOD : SBPlacedFeatures.TREES_REDWOOD);
        return biome(true, 0.25F, 0.8F, mobSettings, biomeSettings, MUSIC_REDWOOD);
    }

    public static Biome volcanicPeaks(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pWorldCarvers) {
        MobSpawnSettings.Builder mobSettings = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(mobSettings);

        BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pWorldCarvers);
        BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeSettings);
        BiomeDefaultFeatures.addDefaultCrystalFormations(biomeSettings);
        BiomeDefaultFeatures.addDefaultMonsterRoom(biomeSettings);
        BiomeDefaultFeatures.addDefaultSprings(biomeSettings);
        BiomeDefaultFeatures.addSurfaceFreezing(biomeSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeSettings);
        addModMushrooms(biomeSettings);
        biomeSettings.addFeature(GenerationStep.Decoration.LAKES, SBPlacedFeatures.LAKE_LAVA_VOLCANIC);
        biomeSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, SBPlacedFeatures.ORE_OBSIDIAN);
        biomeSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, SBPlacedFeatures.ORE_BASALT_VOLCANIC);
        biomeSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, SBPlacedFeatures.ORE_GRANITE_VOLCANIC);
        biomeSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, SBPlacedFeatures.ORE_PEGMATITE_VOLCANIC);
        biomeSettings.addFeature(GenerationStep.Decoration.FLUID_SPRINGS, SBPlacedFeatures.SPRING_LAVA_VOLCANIC);
        return biome(true, 2F, 0F, NONE, DEFAULT_WATER, DEFAULT_WATER_FOG, 8230780, null, null, mobSettings, biomeSettings, MUSIC_VOLCANIC);
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

    private static void globalOverworldGeneration(BiomeGenerationSettings.Builder biomeSettings) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeSettings);
        BiomeDefaultFeatures.addDefaultCrystalFormations(biomeSettings);
        BiomeDefaultFeatures.addDefaultMonsterRoom(biomeSettings);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeSettings);
        BiomeDefaultFeatures.addDefaultSprings(biomeSettings);
        BiomeDefaultFeatures.addSurfaceFreezing(biomeSettings);
    }

    private static void addModUndergroundVariety(BiomeGenerationSettings.Builder biomeSettings) {
        biomeSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, SBPlacedFeatures.ORE_PEGMATITE_UPPER);
        biomeSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, SBPlacedFeatures.ORE_PEGMATITE_LOWER);
    }

    private static void addModMushrooms(BiomeGenerationSettings.Builder biomeSettings) {
        biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.WHITE_MUSHROOM_RARE);
    }

    private static int calculateSkyColor(float pTemperature) {
        float $$1 = pTemperature / 3.0F;
        $$1 = Mth.clamp($$1, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
    }
}
