package net.invictusslayer.slayersbeasts.common.world.biome;

import net.invictusslayer.slayersbeasts.common.init.SBEntities;
import net.invictusslayer.slayersbeasts.common.world.feature.SBPlacedFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
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
	private static final Music MUSIC_DRIPSTONE = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_DRIPSTONE_CAVES);
	private static final Music MUSIC_LUSH = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_LUSH_CAVES);

	public static Biome ancientGrove(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers) {
		MobSpawnSettings.Builder mobSettings = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.commonSpawns(mobSettings);
		mobSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(SBEntities.MANTIS.get(), 6, 1, 3));

		BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(features, carvers);
		globalOverworldGeneration(biomeSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeSettings);
		BiomeDefaultFeatures.addDefaultSoftDisks(biomeSettings);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_FOREST);
		BiomeDefaultFeatures.addDefaultMushrooms(biomeSettings);
		BiomeDefaultFeatures.addDefaultExtraVegetation(biomeSettings);

		addModUndergroundVariety(biomeSettings);
		addModMushrooms(biomeSettings);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.TREES_RAINFOREST);
		return biome(true, 0.6F, 0.6F, mobSettings, biomeSettings, MUSIC_RAINFOREST);
	}

	public static Biome aspenForest(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers) {
		MobSpawnSettings.Builder mobSettings = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.commonSpawns(mobSettings);

		BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(features, carvers);
		globalOverworldGeneration(biomeSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeSettings);
		BiomeDefaultFeatures.addDefaultSoftDisks(biomeSettings);
		BiomeDefaultFeatures.addDefaultFlowers(biomeSettings);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_FOREST);
		BiomeDefaultFeatures.addDefaultMushrooms(biomeSettings);
		BiomeDefaultFeatures.addDefaultExtraVegetation(biomeSettings);

		addModUndergroundVariety(biomeSettings);
		addModMushrooms(biomeSettings);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.TREES_ASPEN);
		return biome(true, 0.6F, 0.6F, mobSettings, biomeSettings, MUSIC_FOREST);
	}

	public static Biome bayou(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers) {
		MobSpawnSettings.Builder mobSettings = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.commonSpawns(mobSettings);
		mobSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 1, 1, 1));
		mobSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FROG, 10, 2, 5));
		mobSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(SBEntities.DAMSELFLY.get(), 4, 1, 1));

		BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(features, carvers);
		globalOverworldGeneration(biomeSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeSettings);
		BiomeDefaultFeatures.addMangroveSwampDisks(biomeSettings);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_NORMAL);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_DEAD_BUSH);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_WATERLILY);
		BiomeDefaultFeatures.addDefaultMushrooms(biomeSettings);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_SUGAR_CANE_SWAMP);

		addModUndergroundVariety(biomeSettings);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.PATCH_ALGAE_COMMON);
		addModMushrooms(biomeSettings);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.TREES_BAYOU);
		return biome(true, 0.9F, 0.8F, NONE, 2642743, 2192174, null, 6975545, BiomeSpecialEffects.GrassColorModifier.SWAMP, mobSettings, biomeSettings, MUSIC_SWAMP);
	}

	public static Biome brushland(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers, boolean wooded, boolean rocky) {
		MobSpawnSettings.Builder mobSettings = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.commonSpawns(mobSettings);

		BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(features, carvers);
		globalOverworldGeneration(biomeSettings);
		if (rocky) biomeSettings.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, MiscOverworldPlacements.FOREST_ROCK);
		BiomeDefaultFeatures.addDefaultOres(biomeSettings);
		BiomeDefaultFeatures.addDefaultSoftDisks(biomeSettings);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_TALL_GRASS);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_DEAD_BUSH_2);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_SAVANNA);
		BiomeDefaultFeatures.addDefaultMushrooms(biomeSettings);
		BiomeDefaultFeatures.addDefaultExtraVegetation(biomeSettings);

		addMudPits(biomeSettings);
		addModUndergroundVariety(biomeSettings);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.PATCH_TALL_DEAD_BUSH_BRUSH);
		addModMushrooms(biomeSettings);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, wooded ? SBPlacedFeatures.TREES_WOODED_BRUSH : SBPlacedFeatures.TREES_BRUSH);
		return biome(false, 2F, 0F, mobSettings, biomeSettings, MUSIC_OUTBACK);
	}

	public static Biome chaparral(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers) {
		MobSpawnSettings.Builder mobSettings = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.commonSpawns(mobSettings);
		mobSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3));
		mobSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));

		BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(features, carvers);
		globalOverworldGeneration(biomeSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeSettings);
		BiomeDefaultFeatures.addDefaultSoftDisks(biomeSettings);
		BiomeDefaultFeatures.addDefaultFlowers(biomeSettings);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_DEAD_BUSH);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_SAVANNA);
		BiomeDefaultFeatures.addDefaultMushrooms(biomeSettings);
		BiomeDefaultFeatures.addDefaultExtraVegetation(biomeSettings);

		addModUndergroundVariety(biomeSettings);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.PATCH_TALL_DEAD_BUSH);
		addModMushrooms(biomeSettings);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.TREES_CHAPARRAL);
		return biome(true, 0.8F, 0.4F, mobSettings, biomeSettings, MUSIC_OUTBACK);
	}

	public static Biome desert(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers) {
		MobSpawnSettings.Builder mobSettings = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.commonSpawns(mobSettings);
		mobSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.HUSK, 80, 4, 4));

		BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(features, carvers);
		globalOverworldGeneration(biomeSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeSettings);
		BiomeDefaultFeatures.addDefaultSoftDisks(biomeSettings);
		BiomeDefaultFeatures.addDefaultFlowers(biomeSettings);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_DEAD_BUSH);
		BiomeDefaultFeatures.addDefaultMushrooms(biomeSettings);

		addMudPits(biomeSettings);
		addModUndergroundVariety(biomeSettings);
		addModMushrooms(biomeSettings);
		return biome(false, 2F, 0F, mobSettings, biomeSettings, MUSIC_DESERT);
	}

	public static Biome eucalyptWoodland(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers) {
		MobSpawnSettings.Builder mobSettings = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.commonSpawns(mobSettings);

		BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(features, carvers);
		globalOverworldGeneration(biomeSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeSettings);
		BiomeDefaultFeatures.addDefaultSoftDisks(biomeSettings);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_LARGE_FERN);
		BiomeDefaultFeatures.addDefaultFlowers(biomeSettings);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_TAIGA_2);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.BROWN_MUSHROOM_OLD_GROWTH);
		BiomeDefaultFeatures.addDefaultMushrooms(biomeSettings);
		BiomeDefaultFeatures.addDefaultExtraVegetation(biomeSettings);

		addModUndergroundVariety(biomeSettings);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.PATCH_TALL_DEAD_BUSH);
		addModMushrooms(biomeSettings);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.TREES_EUCALYPT);
		return biome(true, 2F, 0F, mobSettings, biomeSettings, MUSIC_FOREST);
	}

	public static Biome frozenThicket(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers) {
		MobSpawnSettings.Builder mobSettings = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.commonSpawns(mobSettings);

		BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(features, carvers);
		globalOverworldGeneration(biomeSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeSettings);
		BiomeDefaultFeatures.addDefaultSoftDisks(biomeSettings);
		BiomeDefaultFeatures.addDefaultMushrooms(biomeSettings);
		BiomeDefaultFeatures.addDefaultExtraVegetation(biomeSettings);

		addModUndergroundVariety(biomeSettings);
		addModMushrooms(biomeSettings);
		return biome(true, 0F, 0.2F, FROZEN, DEFAULT_WATER, DEFAULT_WATER_FOG, null, null, null, mobSettings, biomeSettings, MUSIC_FROZEN);
	}

	public static Biome inkyMoor(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers) {
		MobSpawnSettings.Builder mobSettings = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.commonSpawns(mobSettings);
		mobSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 1, 1, 1));
		mobSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FROG, 10, 2, 5));
		mobSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(SBEntities.DAMSELFLY.get(), 4, 1, 1));

		BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(features, carvers);
		globalOverworldGeneration(biomeSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeSettings);
		BiomeDefaultFeatures.addMangroveSwampDisks(biomeSettings);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_NORMAL);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_DEAD_BUSH);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_WATERLILY);
		BiomeDefaultFeatures.addDefaultMushrooms(biomeSettings);
		BiomeDefaultFeatures.addDefaultExtraVegetation(biomeSettings);

		addModUndergroundVariety(biomeSettings);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.PATCH_ALGAE_NORMAL);
		addModMushrooms(biomeSettings);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.TREES_INKY);
		return biome(true, 0.9F, 0.8F, NONE, 2642743, 2192174, null, 6975545, BiomeSpecialEffects.GrassColorModifier.SWAMP, mobSettings, biomeSettings, MUSIC_SWAMP);
	}

	public static Biome murkyOcean(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers, boolean isDeep) {
		MobSpawnSettings.Builder mobSettings = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.oceanSpawns(mobSettings, 10, 4, 5);

		BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(features, carvers);
		globalOverworldGeneration(biomeSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeSettings);
		BiomeDefaultFeatures.addDefaultSoftDisks(biomeSettings);
		BiomeDefaultFeatures.addWaterTrees(biomeSettings);
		BiomeDefaultFeatures.addDefaultFlowers(biomeSettings);
		BiomeDefaultFeatures.addDefaultGrass(biomeSettings);
		BiomeDefaultFeatures.addDefaultMushrooms(biomeSettings);
		BiomeDefaultFeatures.addDefaultExtraVegetation(biomeSettings);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, isDeep ? AquaticPlacements.SEAGRASS_DEEP_WARM : AquaticPlacements.SEAGRASS_DEEP);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_NORMAL);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.KELP_COLD);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.KELP_WARM);

		addModUndergroundVariety(biomeSettings);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.PATCH_ALGAE_COMMON);
		addModMushrooms(biomeSettings);
		return biome(true, 0.9F, 0.8F, NONE, 2642743, 2192174, null, 6975545, BiomeSpecialEffects.GrassColorModifier.SWAMP, mobSettings, biomeSettings, MUSIC_SWAMP);
	}

	public static Biome mushroomForest(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers) {
		MobSpawnSettings.Builder mobSettings = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.mooshroomSpawns(mobSettings);

		BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(features, carvers);
		globalOverworldGeneration(biomeSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeSettings);
		BiomeDefaultFeatures.addDefaultSoftDisks(biomeSettings);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.TREES_MUSHROOM);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.BROWN_MUSHROOM_TAIGA);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.RED_MUSHROOM_TAIGA);
		BiomeDefaultFeatures.addDefaultExtraVegetation(biomeSettings);

		addModUndergroundVariety(biomeSettings);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.BLACK_MUSHROOM_COMMON);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.WHITE_MUSHROOM_COMMON);
		return biome(false, 2F, 0F, mobSettings, biomeSettings, null);
	}

	public static Biome outback(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers) {
		MobSpawnSettings.Builder mobSettings = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.commonSpawns(mobSettings);

		BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(features, carvers);
		globalOverworldGeneration(biomeSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeSettings);
		BiomeDefaultFeatures.addDefaultSoftDisks(biomeSettings);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_NORMAL);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_DEAD_BUSH);
		BiomeDefaultFeatures.addDefaultMushrooms(biomeSettings);
		BiomeDefaultFeatures.addDefaultExtraVegetation(biomeSettings);

		addMudPits(biomeSettings);
		addModUndergroundVariety(biomeSettings);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.PATCH_TALL_DEAD_BUSH);
		addModMushrooms(biomeSettings);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.TREES_OUTBACK);
		return biome(false, 2F, 0F, mobSettings, biomeSettings, MUSIC_OUTBACK); // grass-9470285 foliage-10387789
	}

	public static Biome petrifiedWoods(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers) {
		MobSpawnSettings.Builder mobSettings = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.commonSpawns(mobSettings);

		BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(features, carvers);
		globalOverworldGeneration(biomeSettings);
		BiomeDefaultFeatures.addDefaultSoftDisks(biomeSettings);
		BiomeDefaultFeatures.addDefaultExtraVegetation(biomeSettings);

		addModUndergroundVariety(biomeSettings);
		return biome(false, 0F, 0F, Biome.TemperatureModifier.FROZEN, DEFAULT_WATER, DEFAULT_WATER_FOG, null, null, null, mobSettings, biomeSettings, MUSIC_FROZEN);
	}

	public static Biome rainforest(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers) {
		MobSpawnSettings.Builder mobSettings = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.commonSpawns(mobSettings);
		mobSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(SBEntities.MANTIS.get(), 6, 1, 3));
		mobSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(SBEntities.DAMSELFLY.get(), 4, 1, 1));

		BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(features, carvers);
		globalOverworldGeneration(biomeSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeSettings);
		BiomeDefaultFeatures.addDefaultSoftDisks(biomeSettings);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_JUNGLE);
		BiomeDefaultFeatures.addDefaultMushrooms(biomeSettings);
		BiomeDefaultFeatures.addDefaultExtraVegetation(biomeSettings);

		addModUndergroundVariety(biomeSettings);
		addModMushrooms(biomeSettings);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.TREES_RAINFOREST);
		return biome(true, 2F, 0F, mobSettings, biomeSettings, MUSIC_RAINFOREST);
	}

	public static Biome redwoodGrove(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers, boolean oldGrowth) {
		MobSpawnSettings.Builder mobSettings = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.commonSpawns(mobSettings);
		mobSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));

		BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(features, carvers);
		globalOverworldGeneration(biomeSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeSettings);
		BiomeDefaultFeatures.addDefaultSoftDisks(biomeSettings);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_LARGE_FERN);
		BiomeDefaultFeatures.addDefaultFlowers(biomeSettings);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_TAIGA);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_DEAD_BUSH);
		BiomeDefaultFeatures.addDefaultMushrooms(biomeSettings);
		BiomeDefaultFeatures.addDefaultExtraVegetation(biomeSettings);

		addModUndergroundVariety(biomeSettings);
		addModMushrooms(biomeSettings);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, oldGrowth ? SBPlacedFeatures.TREES_OLD_GROWTH_REDWOOD : SBPlacedFeatures.TREES_REDWOOD);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.WHITE_MUSHROOM_COMMON);
		return biome(true, 0.25F, 0.8F, mobSettings, biomeSettings, MUSIC_REDWOOD);
	}

	public static Biome volcanicPeaks(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers) {
		MobSpawnSettings.Builder mobSettings = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.commonSpawns(mobSettings);

		BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(features, carvers);
		BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeSettings);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeSettings);
		BiomeDefaultFeatures.addDefaultMonsterRoom(biomeSettings);
		BiomeDefaultFeatures.addDefaultSprings(biomeSettings);
		BiomeDefaultFeatures.addSurfaceFreezing(biomeSettings);
		BiomeDefaultFeatures.addDefaultFlowers(biomeSettings);
		BiomeDefaultFeatures.addDefaultMushrooms(biomeSettings);
		BiomeDefaultFeatures.addDefaultExtraVegetation(biomeSettings);

		addModMushrooms(biomeSettings);
		biomeSettings.addFeature(GenerationStep.Decoration.LAKES, SBPlacedFeatures.LAKE_LAVA_VOLCANIC);
		biomeSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, SBPlacedFeatures.ORE_OBSIDIAN);
		biomeSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, SBPlacedFeatures.ORE_BASALT_VOLCANIC);
		biomeSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, SBPlacedFeatures.ORE_GRANITE_VOLCANIC);
		biomeSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, SBPlacedFeatures.ORE_PEGMATITE_VOLCANIC);
		biomeSettings.addFeature(GenerationStep.Decoration.FLUID_SPRINGS, SBPlacedFeatures.SPRING_LAVA_VOLCANIC);
		return biome(true, 2F, 0F, NONE, DEFAULT_WATER, DEFAULT_WATER_FOG, 8230780, null, null, mobSettings, biomeSettings, MUSIC_VOLCANIC);
	}

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
		BiomeDefaultFeatures.addDefaultExtraVegetation(biomeSettings);

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
		BiomeDefaultFeatures.addDefaultExtraVegetation(biomeSettings);

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
		biomeSettings.addCarver(Carvers.CAVE);
		biomeSettings.addCarver(Carvers.CAVE_EXTRA_UNDERGROUND);
		biomeSettings.addCarver(Carvers.CANYON);
		biomeSettings.addFeature(GenerationStep.Decoration.FLUID_SPRINGS, MiscOverworldPlacements.SPRING_WATER);
		BiomeDefaultFeatures.addSurfaceFreezing(biomeSettings);
		BiomeDefaultFeatures.addDefaultMushrooms(biomeSettings);
		BiomeDefaultFeatures.addDefaultExtraVegetation(biomeSettings);

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
		BiomeDefaultFeatures.addDefaultExtraVegetation(biomeSettings);

		addModUndergroundVariety(biomeSettings);
		addModMushrooms(biomeSettings);
		return biome(true, 0.8F, 0.4F, mobSettings, biomeSettings, MUSIC_LUSH);
	}

	public static Biome theCrypt(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers) {
		MobSpawnSettings.Builder mobSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(features, carvers);
		return biome(false, 0.5F, 0.5F, mobSettings, biomeSettings, null);
	}

	private static Biome biome(boolean precipitation, float temperature, float downfall, MobSpawnSettings.Builder mobSettings, BiomeGenerationSettings.Builder biomeSettings, Music music) {
		return biome(precipitation, temperature, downfall, NONE, DEFAULT_WATER, DEFAULT_WATER_FOG, null, null, null, mobSettings, biomeSettings, music);
	}

	private static Biome biome(boolean precipitation, float temperature, float downfall, Biome.TemperatureModifier temperatureModifier, int waterColor, int waterFogColor, Integer grassOverride, Integer foliageOverride, BiomeSpecialEffects.GrassColorModifier grassModifier, MobSpawnSettings.Builder mobSettings, BiomeGenerationSettings.Builder biomeSettings, Music music) {
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

	private static void addAntMounds(BiomeGenerationSettings.Builder biomeSettings) {
		biomeSettings.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, SBPlacedFeatures.ANT_MOUND_MUD);
		biomeSettings.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, SBPlacedFeatures.ANT_MOUND_RUDOSOL);
	}

	private static void addIcicles(BiomeGenerationSettings.Builder biomeSettings) {
		biomeSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, SBPlacedFeatures.ICICLE_CLUSTER);
		biomeSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, SBPlacedFeatures.ICICLE_LARGE);
		biomeSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, SBPlacedFeatures.ICICLE_SMALL);
	}

	private static void addMudPits(BiomeGenerationSettings.Builder biomeSettings) {
		biomeSettings.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, SBPlacedFeatures.MUD_PIT_SHALLOW);
		biomeSettings.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, SBPlacedFeatures.MUD_PIT_NORMAL);
		biomeSettings.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, SBPlacedFeatures.MUD_PIT_DEEP);
	}

	private static void addModUndergroundVariety(BiomeGenerationSettings.Builder biomeSettings) {
		biomeSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, SBPlacedFeatures.ORE_EXOSKELETON);
		biomeSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, SBPlacedFeatures.ORE_PEGMATITE_UPPER);
		biomeSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, SBPlacedFeatures.ORE_PEGMATITE_LOWER);
	}

	private static void addModMushrooms(BiomeGenerationSettings.Builder biomeSettings) {
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.BLACK_MUSHROOM_RARE);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.WHITE_MUSHROOM_RARE);
	}

	static int calculateSkyColor(float temperature) {
		float f = temperature / 3.0F;
		f = Mth.clamp(f, -1.0F, 1.0F);
		return Mth.hsvToRgb(0.62F - f * 0.05F, 0.5F + f * 0.1F, 1.0F);
	}
}
