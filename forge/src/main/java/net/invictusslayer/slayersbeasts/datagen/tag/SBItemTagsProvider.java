package net.invictusslayer.slayersbeasts.datagen.tag;

import net.invictusslayer.slayersbeasts.block.WoodFamily;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.item.SBItems;
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
	public SBItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, TagsProvider<Block> blockTags, ExistingFileHelper helper) {
		super(output, provider, blockTags.contentsGetter(), SlayersBeasts.MOD_ID, helper);
	}

	protected void addTags(HolderLookup.Provider provider) {
		tag(SBTags.Items.JADE_GEMS).add(SBItems.JADE.get());

		tag(ItemTags.MUSIC_DISCS).add(SBItems.MUSIC_DISC_INKISH.get());

		WoodFamily.getAllFamilies().forEach(family -> copy(family.getLogBlocks(), family.getLogItems()));
		copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);

		copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);
		copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);
		copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);
		copy(BlockTags.FENCE_GATES, ItemTags.FENCE_GATES);
		copy(BlockTags.PLANKS, ItemTags.PLANKS);
		copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);
		copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);
		copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
		copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
		copy(BlockTags.SLABS, ItemTags.SLABS);
		copy(BlockTags.STAIRS, ItemTags.STAIRS);
		copy(BlockTags.WALLS, ItemTags.WALLS);
		copy(BlockTags.SAND, ItemTags.SAND);
		copy(BlockTags.SMELTS_TO_GLASS, ItemTags.SMELTS_TO_GLASS);
	}
}
