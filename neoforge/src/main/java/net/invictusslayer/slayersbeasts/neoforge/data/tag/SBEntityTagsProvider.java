package net.invictusslayer.slayersbeasts.neoforge.data.tag;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.data.tag.SBTags;
import net.invictusslayer.slayersbeasts.common.init.SBEntities;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.world.entity.EntityType;

import java.util.concurrent.CompletableFuture;

public class SBEntityTagsProvider extends EntityTypeTagsProvider {
	public SBEntityTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
		super(output, provider, SlayersBeasts.MOD_ID);
	}

	protected void addTags(HolderLookup.Provider pProvider) {
		this.tag(SBTags.EntityTypes.ANTHILL_INHABITANTS).add(SBEntities.ANT_WORKER.get(), SBEntities.ANT_SOLDIER.get(), SBEntities.ANT_QUEEN.get());
		this.tag(SBTags.EntityTypes.PEAT_WALKABLE_MOBS).add(SBEntities.ANT_WORKER.get(), EntityType.FROG);
	}
}
