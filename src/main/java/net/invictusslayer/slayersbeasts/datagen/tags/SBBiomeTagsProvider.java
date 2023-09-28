package net.invictusslayer.slayersbeasts.datagen.tags;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.world.biome.SBBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class SBBiomeTagsProvider extends BiomeTagsProvider {
	public SBBiomeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, ExistingFileHelper existingFileHelper) {
		super(output, provider, SlayersBeasts.MOD_ID, existingFileHelper);
	}

	protected void addTags(HolderLookup.Provider provider) {
		tag(SBTags.Biomes.IS_BRUSHLAND).add(SBBiomes.BRUSHLAND, SBBiomes.ROCKY_BRUSHLAND, SBBiomes.WOODED_BRUSHLAND);
		tag(SBTags.Biomes.HAS_CRYPT_PORTAL).add(SBBiomes.BLACK_DUNES, SBBiomes.DEAD_SANDS, SBBiomes.VOLCANIC_PEAKS);
		tag(SBTags.Biomes.SPAWNS_DAMSELFLY).add(Biomes.SPARSE_JUNGLE, Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS, Biomes.MEADOW, Biomes.SWAMP, Biomes.MANGROVE_SWAMP, Biomes.RIVER);
		tag(SBTags.Biomes.SPAWNS_MANTIS).add(Biomes.LUSH_CAVES, Biomes.MANGROVE_SWAMP, Biomes.SPARSE_JUNGLE, Biomes.JUNGLE, Biomes.BAMBOO_JUNGLE).add(SBBiomes.RAINFOREST, SBBiomes.ANCIENT_GROVE);

		tag(Tags.Biomes.IS_DESERT).add(SBBiomes.BLACK_DUNES, SBBiomes.DEAD_SANDS, SBBiomes.DUSTY_CAVERNS);
		tag(Tags.Biomes.IS_CAVE).add(SBBiomes.DUSTY_CAVERNS, SBBiomes.FUNGAL_DEPTHS, SBBiomes.ICE_CAVES, SBBiomes.SLIME_CAVERNS);
		tag(Tags.Biomes.IS_PEAK).add(SBBiomes.VOLCANIC_PEAKS);
		tag(Tags.Biomes.IS_SLOPE).add(SBBiomes.REDWOOD_GROVE, SBBiomes.BLACK_DUNES, SBBiomes.CHAPARRAL, SBBiomes.ASPEN_FOREST);
		tag(Tags.Biomes.IS_DEAD).add(SBBiomes.PETRIFIED_WOODS);
		tag(Tags.Biomes.IS_SPOOKY).add(SBBiomes.PETRIFIED_WOODS, SBBiomes.INKY_MOOR);
		tag(Tags.Biomes.IS_MUSHROOM).add(SBBiomes.FUNGAL_DEPTHS);
		tag(Tags.Biomes.IS_CONIFEROUS).add(SBBiomes.REDWOOD_GROVE, SBBiomes.OLD_GROWTH_REDWOOD_GROVE);
		tag(Tags.Biomes.IS_LUSH).add(SBBiomes.RAINFOREST, SBBiomes.BAYOU).add(Biomes.BAMBOO_JUNGLE, Biomes.JUNGLE, Biomes.MANGROVE_SWAMP);
		tag(Tags.Biomes.IS_HOT_OVERWORLD).add(SBBiomes.RAINFOREST, SBBiomes.BLACK_DUNES, SBBiomes.DEAD_SANDS, SBBiomes.DUSTY_CAVERNS, SBBiomes.OUTBACK, SBBiomes.EUCALYPT_WOODLAND, SBBiomes.VOLCANIC_PEAKS).addTag(SBTags.Biomes.IS_BRUSHLAND);
		tag(Tags.Biomes.IS_HOT_NETHER).add(SBBiomes.TOXIC_JUNGLE);
		tag(Tags.Biomes.IS_COLD_OVERWORLD).add(SBBiomes.FROZEN_THICKET, SBBiomes.PETRIFIED_WOODS, SBBiomes.ASPEN_FOREST, SBBiomes.ICE_CAVES);
		tag(Tags.Biomes.IS_SPARSE_OVERWORLD).add(SBBiomes.OUTBACK, SBBiomes.BRUSHLAND, SBBiomes.ROCKY_BRUSHLAND);
		tag(Tags.Biomes.IS_DENSE_OVERWORLD).add(SBBiomes.RAINFOREST, SBBiomes.ANCIENT_GROVE, SBBiomes.OLD_GROWTH_REDWOOD_GROVE, SBBiomes.BAYOU);
		tag(Tags.Biomes.IS_DENSE_NETHER).add(SBBiomes.TOXIC_JUNGLE);
		tag(Tags.Biomes.IS_WET_OVERWORLD).add(SBBiomes.INKY_MOOR, SBBiomes.RAINFOREST, SBBiomes.BAYOU);
		tag(Tags.Biomes.IS_DRY_OVERWORLD).add(SBBiomes.BLACK_DUNES, SBBiomes.DEAD_SANDS, SBBiomes.DUSTY_CAVERNS, SBBiomes.OUTBACK).addTag(SBTags.Biomes.IS_BRUSHLAND);

		tag(BiomeTags.IS_DEEP_OCEAN).add(SBBiomes.DEEP_MURKY_OCEAN);
		tag(BiomeTags.IS_OCEAN).add(SBBiomes.MURKY_OCEAN);
		tag(BiomeTags.IS_END).add(SBBiomes.END_SPIKES);
		tag(BiomeTags.HAS_RUINED_PORTAL_SWAMP).add(SBBiomes.INKY_MOOR).add(SBBiomes.BAYOU);
		tag(BiomeTags.HAS_RUINED_PORTAL_STANDARD).addTag(SBTags.Biomes.IS_BRUSHLAND);
		tag(BiomeTags.HAS_TRAIL_RUINS).add(SBBiomes.REDWOOD_GROVE, SBBiomes.OLD_GROWTH_REDWOOD_GROVE, SBBiomes.CHAPARRAL);
		tag(BiomeTags.HAS_END_CITY).add(SBBiomes.END_SPIKES);
		tag(BiomeTags.SNOW_GOLEM_MELTS).add(SBBiomes.BLACK_DUNES, SBBiomes.DEAD_SANDS, SBBiomes.OUTBACK).addTag(SBTags.Biomes.IS_BRUSHLAND);
		tag(BiomeTags.ALLOWS_SURFACE_SLIME_SPAWNS).add(SBBiomes.BAYOU, SBBiomes.SLIME_CAVERNS);
	}
}
