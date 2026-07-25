package net.invictusslayer.slayersbeasts.data.tags;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.world.level.biome.SBBiomes;
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
		tag(Tags.Biomes.IS_DENSE_NETHER).add(SBBiomes.TOXIC_JUNGLE);
		tag(Tags.Biomes.IS_SANDY).add(SBBiomes.BLACK_DUNES, SBBiomes.DEAD_SANDS);
	}
}
