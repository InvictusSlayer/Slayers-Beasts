package net.invictusslayer.slayersbeasts.world.biome;

import net.invictusslayer.slayersbeasts.world.feature.SBPlacedFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
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

public class SBUndergroundBiomes {
    private static final int DEFAULT_WATER = 4159204;
    private static final int DEFAULT_WATER_FOG = 329011;
    private static final int DEFAULT_FOG = 12638463;
    private static final Biome.TemperatureModifier FROZEN = Biome.TemperatureModifier.FROZEN;
    private static final Biome.TemperatureModifier NONE = Biome.TemperatureModifier.NONE;
    private static final Music MUSIC_DRIPSTONE = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_DRIPSTONE_CAVES);
    private static final Music MUSIC_LUSH = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_LUSH_CAVES);

    public static Biome dustyCaverns(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder mobSettings = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(mobSettings);
        mobSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.HUSK, 80, 4, 4));

        BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        globalOverworldGeneration(biomeSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeSettings);
        biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_DEAD_BUSH);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeSettings);
        addModUndergroundVariety(biomeSettings);
        addModMushrooms(biomeSettings);
        return biome(false, 2F, 0F, mobSettings, biomeSettings, MUSIC_DRIPSTONE);
    }

    public static Biome fungalDepths(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder mobSettings = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(mobSettings);

        BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        globalOverworldGeneration(biomeSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeSettings);
        biomeSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, SBPlacedFeatures.ORE_EXOSKELETON_LUSH);
        biomeSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, SBPlacedFeatures.ORE_PEGMATITE_UPPER);
        biomeSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, SBPlacedFeatures.ORE_PEGMATITE_LOWER);
        biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.STYPHIUM_PATCH);
        return biome(true, 1.2F, 0.4F, mobSettings, biomeSettings, MUSIC_LUSH);
    }

    public static Biome iceCaves(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder mobSettings = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(mobSettings);

        BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        biomeSettings.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE);
        biomeSettings.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND);
        biomeSettings.addCarver(GenerationStep.Carving.AIR, Carvers.CANYON);
        biomeSettings.addFeature(GenerationStep.Decoration.FLUID_SPRINGS, MiscOverworldPlacements.SPRING_WATER);
        BiomeDefaultFeatures.addSurfaceFreezing(biomeSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeSettings);
        addModUndergroundVariety(biomeSettings);
        addIcicles(biomeSettings);
        addModMushrooms(biomeSettings);
        return biome(true, 0F, 0.2F, FROZEN, DEFAULT_WATER, DEFAULT_WATER_FOG, null, null, null, mobSettings, biomeSettings, MUSIC_DRIPSTONE);
    }

    public static Biome slimeCaverns(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder mobSettings = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(mobSettings);
        mobSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));

        BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        globalOverworldGeneration(biomeSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeSettings);
        addModUndergroundVariety(biomeSettings);
        addModMushrooms(biomeSettings);
        return biome(true, 0.8F, 0.4F, mobSettings, biomeSettings, MUSIC_LUSH);
    }

    public static Biome theCrypt(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers) {
        MobSpawnSettings.Builder mobSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(features, carvers);
        return biome(false, 0.5F, 0.5F, mobSettings, biomeSettings, null);
    }

    private static Biome biome(boolean precipitation, float temperature, float downfall, MobSpawnSettings.Builder mobSettings, BiomeGenerationSettings.Builder biomeSettings, @Nullable Music music) {
        return biome(precipitation, temperature, downfall, NONE, DEFAULT_WATER, DEFAULT_WATER_FOG, null, null, null, mobSettings, biomeSettings, music);
    }

    private static Biome biome(boolean precipitation, float temperature, float downfall, Biome.TemperatureModifier temperatureModifier, int waterColor, int waterFogColor, @Nullable Integer grassOverride, @Nullable Integer foliageOverride, @Nullable BiomeSpecialEffects.GrassColorModifier grassModifier, MobSpawnSettings.Builder mobSettings, BiomeGenerationSettings.Builder biomeSettings, @Nullable Music music) {
        BiomeSpecialEffects.Builder biomeEffects = new BiomeSpecialEffects.Builder().waterColor(waterColor).waterFogColor(waterFogColor).fogColor(DEFAULT_FOG).skyColor(calculateSkyColor(temperature)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(music);
        if (grassOverride != null) biomeEffects.grassColorOverride(grassOverride);
        if (foliageOverride != null) biomeEffects.foliageColorOverride(foliageOverride);
        if (grassModifier != null) biomeEffects.grassColorModifier(grassModifier);
        return new Biome.BiomeBuilder().hasPrecipitation(precipitation).temperature(temperature).downfall(downfall).temperatureAdjustment(temperatureModifier).specialEffects(biomeEffects.build()).mobSpawnSettings(mobSettings.build()).generationSettings(biomeSettings.build()).build();
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
        biomeSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, SBPlacedFeatures.ORE_EXOSKELETON);
        biomeSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, SBPlacedFeatures.ORE_PEGMATITE_UPPER);
        biomeSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, SBPlacedFeatures.ORE_PEGMATITE_LOWER);
    }

    private static void addIcicles(BiomeGenerationSettings.Builder biomeSettings) {
        biomeSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, SBPlacedFeatures.ICICLE_CLUSTER);
        biomeSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, SBPlacedFeatures.ICICLE_LARGE);
        biomeSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, SBPlacedFeatures.ICICLE_SMALL);
    }

    private static void addModMushrooms(BiomeGenerationSettings.Builder biomeSettings) {
        biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.BLACK_MUSHROOM_RARE);
        biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.WHITE_MUSHROOM_RARE);
    }

    static int calculateSkyColor(float pTemperature) {
        float f = pTemperature / 3.0F;
        f = Mth.clamp(f, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62F - f * 0.05F, 0.5F + f * 0.1F, 1.0F);
    }
}
