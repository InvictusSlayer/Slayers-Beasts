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
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class SBItemTagsProvider extends ItemTagsProvider {
    public SBItemTagsProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, TagsProvider<Block> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags.contentsGetter(), SlayersBeasts.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.copy(SBTags.Blocks.ASPEN_LOGS, SBTags.Items.ASPEN_LOGS);
        this.copy(SBTags.Blocks.CAJOLE_LOGS, SBTags.Items.CAJOLE_LOGS);
        this.copy(SBTags.Blocks.DESERT_OAK_LOGS, SBTags.Items.DESERT_OAK_LOGS);
        this.copy(SBTags.Blocks.EUCALYPTUS_LOGS, SBTags.Items.EUCALYPTUS_LOGS);
        this.copy(SBTags.Blocks.KAPOK_LOGS, SBTags.Items.KAPOK_LOGS);
        this.copy(SBTags.Blocks.REDWOOD_LOGS, SBTags.Items.REDWOOD_LOGS);
        this.copy(SBTags.Blocks.WILLOW_LOGS, SBTags.Items.WILLOW_LOGS);

        this.copy(BlockTags.PLANKS, ItemTags.PLANKS);
        this.copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);
        this.copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
        this.copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
        this.copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);
        this.copy(BlockTags.FENCE_GATES, ItemTags.FENCE_GATES);
        this.copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);
        this.copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);
        this.copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);
        this.copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);
        this.copy(BlockTags.SAND, ItemTags.SAND);
    }
}
