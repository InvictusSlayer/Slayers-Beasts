package net.invictusslayer.slayersbeasts.forge.data.tag;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.data.tag.SBTags;
import net.invictusslayer.slayersbeasts.common.init.SBPois;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PoiTypeTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class SBPoiTagsProvider extends PoiTypeTagsProvider {
	public SBPoiTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, ExistingFileHelper helper) {
		super(output, provider, SlayersBeasts.MOD_ID, helper);
	}

	protected void addTags(HolderLookup.Provider pProvider) {
		tag(SBTags.PoiTypes.ANT_HOME).add(ResourceKey.create(SBPois.ANTHILL_POI.getRegistryKey(), SBPois.ANTHILL_POI.getId()));
	}
}
