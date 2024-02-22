package net.invictusslayer.slayersbeasts.datagen.tag;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.SBPois;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PoiTypeTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class SBPoiTagsProvider extends PoiTypeTagsProvider {
	public SBPoiTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, ExistingFileHelper helper) {
		super(output, provider, SlayersBeasts.MOD_ID, helper);
	}

	protected void addTags(HolderLookup.Provider pProvider) {
		tag(SBTags.PoiTypes.ANT_HOME).add(SBPois.ANTHILL_POI.getKey());
	}
}
