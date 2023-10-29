package net.invictusslayer.slayersbeasts.datagen.tags;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.entity.SBEntities;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class SBEntityTagsProvider extends EntityTypeTagsProvider {
	public SBEntityTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(packOutput, lookupProvider, SlayersBeasts.MOD_ID, existingFileHelper);
	}

	protected void addTags(HolderLookup.Provider pProvider) {
		this.tag(SBTags.EntityTypes.ANTHILL_INHABITANTS).add(SBEntities.ANT_WORKER.get(), SBEntities.ANT_SOLDIER.get(), SBEntities.ANT_QUEEN.get());
		this.tag(SBTags.EntityTypes.PEAT_WALKABLE_MOBS).add(SBEntities.ANT_WORKER.get(), EntityType.FROG);
	}
}
