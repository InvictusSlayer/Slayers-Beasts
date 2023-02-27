package net.invictusslayer.slayersbeasts.datagen;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, TagsProvider<Block> p_256467_, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, p_256467_, SlayersBeasts.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.copy(ModTags.Blocks.CAJOLE_LOGS, ModTags.Items.CAJOLE_LOGS);
        this.copy(ModTags.Blocks.EUCALYPTUS_LOGS, ModTags.Items.EUCALYPTUS_LOGS);
    }
}
