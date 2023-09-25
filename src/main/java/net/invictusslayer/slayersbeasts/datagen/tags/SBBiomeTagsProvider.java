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

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class SBBiomeTagsProvider extends BiomeTagsProvider {
	public SBBiomeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, @Nullable ExistingFileHelper existingFileHelper) {
		super(output, provider, SlayersBeasts.MOD_ID, existingFileHelper);
	}

	protected void addTags(HolderLookup.Provider pProvider) {
		tag(SBTags.Biomes.IS_BRUSHLAND).add(SBBiomes.BRUSHLAND, SBBiomes.ROCKY_BRUSHLAND, SBBiomes.WOODED_BRUSHLAND);
		tag(SBTags.Biomes.HAS_CRYPT_PORTAL).add(SBBiomes.BLACK_DUNES, SBBiomes.DEAD_SANDS, SBBiomes.VOLCANIC_PEAKS);
		tag(SBTags.Biomes.SPAWNS_DAMSELFLY).add(Biomes.SPARSE_JUNGLE, Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS, Biomes.MEADOW, Biomes.SWAMP, Biomes.MANGROVE_SWAMP, Biomes.RIVER);

		tag(Tags.Biomes.IS_DESERT).add(SBBiomes.BLACK_DUNES, SBBiomes.DEAD_SANDS);
		tag(Tags.Biomes.IS_CAVE).add(SBBiomes.FUNGAL_DEPTHS, SBBiomes.ICE_CAVES, SBBiomes.SLIME_CAVERNS);
		tag(Tags.Biomes.IS_PEAK).add(SBBiomes.VOLCANIC_PEAKS);
		tag(Tags.Biomes.IS_SLOPE).add(SBBiomes.REDWOOD_GROVE, SBBiomes.BLACK_DUNES, SBBiomes.CHAPARRAL, SBBiomes.ASPEN_FOREST);
		tag(Tags.Biomes.IS_SPOOKY).add(SBBiomes.PETRIFIED_WOODS, SBBiomes.INKY_MOOR);
		tag(Tags.Biomes.IS_MUSHROOM).add(SBBiomes.FUNGAL_DEPTHS);
		tag(Tags.Biomes.IS_CONIFEROUS).add(SBBiomes.REDWOOD_GROVE, SBBiomes.OLD_GROWTH_REDWOOD_GROVE);
		tag(Tags.Biomes.IS_LUSH).add(SBBiomes.RAINFOREST, SBBiomes.ANCIENT_GROVE).add(Biomes.BAMBOO_JUNGLE, Biomes.JUNGLE, Biomes.SPARSE_JUNGLE, Biomes.MANGROVE_SWAMP);
		tag(Tags.Biomes.IS_DENSE_OVERWORLD).add(SBBiomes.RAINFOREST, SBBiomes.ANCIENT_GROVE, SBBiomes.OLD_GROWTH_REDWOOD_GROVE);

		tag(BiomeTags.IS_END).add(SBBiomes.END_SPIKES);
		tag(BiomeTags.HAS_RUINED_PORTAL_SWAMP).add(SBBiomes.INKY_MOOR);
		tag(BiomeTags.HAS_RUINED_PORTAL_STANDARD).addTag(SBTags.Biomes.IS_BRUSHLAND);
		tag(BiomeTags.HAS_TRAIL_RUINS).add(SBBiomes.REDWOOD_GROVE, SBBiomes.OLD_GROWTH_REDWOOD_GROVE);
		tag(BiomeTags.HAS_END_CITY).add(SBBiomes.END_SPIKES);
		tag(BiomeTags.SNOW_GOLEM_MELTS).add(SBBiomes.BLACK_DUNES, SBBiomes.DEAD_SANDS).addTag(SBTags.Biomes.IS_BRUSHLAND);
		tag(BiomeTags.ALLOWS_SURFACE_SLIME_SPAWNS).add(SBBiomes.INKY_MOOR, SBBiomes.SLIME_CAVERNS);
	}
}
