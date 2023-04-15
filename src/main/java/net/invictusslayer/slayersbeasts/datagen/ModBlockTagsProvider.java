package net.invictusslayer.slayersbeasts.datagen;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.init.ModBlocks;
import net.invictusslayer.slayersbeasts.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SlayersBeasts.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.ANTHILLS).add(ModBlocks.ANTHILL.get()).add(ModBlocks.ANTHILL_HATCHERY.get());
        this.tag(ModTags.Blocks.ANTHILL_REPLACEABLE).addTag(BlockTags.DIRT).addTag(BlockTags.BASE_STONE_OVERWORLD);
        this.tag(ModTags.Blocks.CAJOLE_LOGS).add(ModBlocks.CAJOLE_LOG.get()).add(ModBlocks.STRIPPED_CAJOLE_LOG.get()).add(ModBlocks.CAJOLE_WOOD.get()).add(ModBlocks.STRIPPED_CAJOLE_WOOD.get());
        this.tag(ModTags.Blocks.EUCALYPTUS_LOGS).add(ModBlocks.EUCALYPTUS_LOG.get()).add(ModBlocks.STRIPPED_EUCALYPTUS_LOG.get()).add(ModBlocks.EUCALYPTUS_WOOD.get()).add(ModBlocks.STRIPPED_EUCALYPTUS_WOOD.get());
    }
}
