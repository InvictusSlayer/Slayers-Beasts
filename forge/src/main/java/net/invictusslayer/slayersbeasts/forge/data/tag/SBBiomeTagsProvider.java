package net.invictusslayer.slayersbeasts.forge.data.tag;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.data.tag.SBTags;
import net.invictusslayer.slayersbeasts.common.world.biome.SBBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class SBBiomeTagsProvider extends BiomeTagsProvider {
	public SBBiomeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, ExistingFileHelper helper) {
		super(output, provider, SlayersBeasts.MOD_ID, helper);
	}

	protected void addTags(HolderLookup.Provider provider) {
		tag(Tags.Biomes.IS_DESERT).add(SBBiomes.BLACK_DUNES, SBBiomes.DEAD_SANDS, SBBiomes.DUSTY_CAVERNS);
		tag(Tags.Biomes.IS_CAVE).add(SBBiomes.DUSTY_CAVERNS, SBBiomes.FUNGAL_DEPTHS, SBBiomes.ICE_CAVES, SBBiomes.SLIME_CAVERNS);
		tag(Tags.Biomes.IS_MOUNTAIN_PEAK).add(SBBiomes.VOLCANIC_PEAKS);
		tag(Tags.Biomes.IS_MOUNTAIN_SLOPE).add(SBBiomes.BLACK_DUNES, SBBiomes.CHAPARRAL, SBBiomes.ASPEN_FOREST);
		tag(Tags.Biomes.IS_DEAD).add(SBBiomes.PETRIFIED_WOODS, SBBiomes.DEAD_SANDS);
		tag(Tags.Biomes.IS_SPOOKY).add(SBBiomes.PETRIFIED_WOODS, SBBiomes.INKY_MOOR);
		tag(Tags.Biomes.IS_MUSHROOM).add(SBBiomes.FUNGAL_DEPTHS, SBBiomes.MUSHROOM_FOREST);
		tag(Tags.Biomes.IS_CONIFEROUS_TREE).add(SBBiomes.REDWOOD_GROVE, SBBiomes.OLD_GROWTH_REDWOOD_GROVE);
		tag(Tags.Biomes.IS_HOT_OVERWORLD).add(SBBiomes.RAINFOREST, SBBiomes.BLACK_DUNES, SBBiomes.DEAD_SANDS, SBBiomes.DUSTY_CAVERNS, SBBiomes.OUTBACK, SBBiomes.EUCALYPT_WOODLAND, SBBiomes.VOLCANIC_PEAKS).addTag(SBTags.Biomes.IS_BRUSHLAND);
		tag(Tags.Biomes.IS_HOT_NETHER).add(SBBiomes.TOXIC_JUNGLE);
		tag(Tags.Biomes.IS_COLD_OVERWORLD).add(SBBiomes.FROZEN_THICKET, SBBiomes.PETRIFIED_WOODS, SBBiomes.ASPEN_FOREST, SBBiomes.ICE_CAVES);
		tag(Tags.Biomes.IS_COLD_END).add(SBBiomes.END_SPIKES);
		tag(Tags.Biomes.IS_SPARSE_VEGETATION_OVERWORLD).add(SBBiomes.OUTBACK, SBBiomes.BRUSHLAND, SBBiomes.ROCKY_BRUSHLAND);
		tag(Tags.Biomes.IS_DENSE_VEGETATION_OVERWORLD).add(SBBiomes.RAINFOREST, SBBiomes.ANCIENT_GROVE, SBBiomes.OLD_GROWTH_REDWOOD_GROVE, SBBiomes.BAYOU);
		tag(Tags.Biomes.IS_DENSE_NETHER).add(SBBiomes.TOXIC_JUNGLE);
		tag(Tags.Biomes.IS_WET_OVERWORLD).add(SBBiomes.INKY_MOOR, SBBiomes.RAINFOREST, SBBiomes.BAYOU);
		tag(Tags.Biomes.IS_DRY_OVERWORLD).add(SBBiomes.BLACK_DUNES, SBBiomes.DEAD_SANDS, SBBiomes.DUSTY_CAVERNS, SBBiomes.OUTBACK).addTag(SBTags.Biomes.IS_BRUSHLAND);
		tag(Tags.Biomes.IS_DRY_END).add(SBBiomes.END_SPIKES);
	}
}
