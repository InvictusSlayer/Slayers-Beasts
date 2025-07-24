package net.invictusslayer.slayersbeasts.data.tag;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PoiTypeTagsProvider;

import java.util.concurrent.CompletableFuture;

public class SBPoiTagsProvider extends PoiTypeTagsProvider {
	public SBPoiTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
		super(output, provider, SlayersBeasts.MOD_ID);
	}

	protected void addTags(HolderLookup.Provider pProvider) {
//		tag(SBTags.PoiTypes.ANT_HOME).add(SBPois.ANTHILL.getKey()); TODO
	}
}
