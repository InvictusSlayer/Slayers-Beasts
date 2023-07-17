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

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(SBTags.EntityTypes.ANTHILL_INHABITANTS).add(SBEntities.WORKER_ANT.get(), SBEntities.SOLDIER_ANT.get(), SBEntities.QUEEN_ANT.get());
        this.tag(SBTags.EntityTypes.PEAT_WALKABLE_MOBS).add(SBEntities.WORKER_ANT.get(), EntityType.FROG);
    }
}
