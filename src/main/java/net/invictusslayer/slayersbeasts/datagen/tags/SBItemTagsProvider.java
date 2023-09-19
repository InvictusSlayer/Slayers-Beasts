package net.invictusslayer.slayersbeasts.datagen.tags;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class SBItemTagsProvider extends ItemTagsProvider {
    public SBItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, TagsProvider<Block> blockTags, ExistingFileHelper existingFileHelper) {
        super(output, provider, blockTags.contentsGetter(), SlayersBeasts.MOD_ID, existingFileHelper);
    }

    protected void addTags(HolderLookup.Provider pProvider) {
        copy(SBTags.Blocks.ASPEN_LOGS, SBTags.Items.ASPEN_LOGS);
        copy(SBTags.Blocks.CAJOLE_LOGS, SBTags.Items.CAJOLE_LOGS);
        copy(SBTags.Blocks.DESERT_OAK_LOGS, SBTags.Items.DESERT_OAK_LOGS);
        copy(SBTags.Blocks.EUCALYPTUS_LOGS, SBTags.Items.EUCALYPTUS_LOGS);
        copy(SBTags.Blocks.KAPOK_LOGS, SBTags.Items.KAPOK_LOGS);
        copy(SBTags.Blocks.REDWOOD_LOGS, SBTags.Items.REDWOOD_LOGS);
        copy(SBTags.Blocks.WILLOW_LOGS, SBTags.Items.WILLOW_LOGS);

        copy(BlockTags.PLANKS, ItemTags.PLANKS);
        copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);
        copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
        copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
        copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);
        copy(BlockTags.FENCE_GATES, ItemTags.FENCE_GATES);
        copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);
        copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);
        copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);
        copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);
        copy(BlockTags.SLABS, ItemTags.SLABS);
        copy(BlockTags.STAIRS, ItemTags.STAIRS);
        copy(BlockTags.WALLS, ItemTags.WALLS);
        copy(BlockTags.SAND, ItemTags.SAND);
        copy(BlockTags.SMELTS_TO_GLASS, ItemTags.SMELTS_TO_GLASS);
    }
}
