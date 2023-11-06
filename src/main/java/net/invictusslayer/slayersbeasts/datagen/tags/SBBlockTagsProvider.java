package net.invictusslayer.slayersbeasts.datagen.tags;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.SBBlocks;
import net.invictusslayer.slayersbeasts.block.WoodFamily;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class SBBlockTagsProvider extends BlockTagsProvider {
	public SBBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, SlayersBeasts.MOD_ID, existingFileHelper);
	}

	protected void addTags(HolderLookup.Provider provider) {
		generateWoodFamilies();

		tag(SBTags.Blocks.SEPULCHRA_PORTAL_FRAME).add(SBBlocks.JADE_BLOCK.get());
		tag(SBTags.Blocks.ANTHILLS).add(SBBlocks.ANTHILL.get(), SBBlocks.ANTHILL_HATCHERY.get());
		tag(SBTags.Blocks.ANTHILL_REPLACEABLE).addTag(BlockTags.DIRT).addTag(BlockTags.BASE_STONE_OVERWORLD);
		tag(SBTags.Blocks.ICICLE_REPLACEABLE).add(Blocks.PACKED_ICE, Blocks.ICE, Blocks.BLUE_ICE).addTag(BlockTags.BASE_STONE_OVERWORLD);
		tag(SBTags.Blocks.STYPHIUM_REPLACEABLE).addTag(BlockTags.BASE_STONE_OVERWORLD).addTag(BlockTags.DIRT);

		tag(BlockTags.SAND).add(SBBlocks.BLACK_SAND.get());
		tag(BlockTags.DIRT).add(SBBlocks.ARIDISOL.get());
		tag(BlockTags.SLABS).add(SBBlocks.PEGMATITE_SLAB.get(), SBBlocks.POLISHED_PEGMATITE_SLAB.get(), SBBlocks.BLACK_SANDSTONE_SLAB.get(), SBBlocks.SMOOTH_BLACK_SANDSTONE_SLAB.get(), SBBlocks.CUT_BLACK_SANDSTONE_SLAB.get());
		tag(BlockTags.STAIRS).add(SBBlocks.PEGMATITE_STAIRS.get(), SBBlocks.POLISHED_PEGMATITE_STAIRS.get(), SBBlocks.BLACK_SANDSTONE_STAIRS.get(), SBBlocks.SMOOTH_BLACK_SANDSTONE_STAIRS.get());
		tag(BlockTags.WALLS).add(SBBlocks.BLACK_SANDSTONE_WALL.get(), SBBlocks.PEGMATITE_WALL.get());
		tag(BlockTags.MUSHROOM_GROW_BLOCK).add(SBBlocks.ARIDISOL.get(), SBBlocks.STYPHIUM.get(), SBBlocks.DEEPSLATE_STYPHIUM.get());
		tag(BlockTags.SMELTS_TO_GLASS).add(SBBlocks.BLACK_SAND.get());
		tag(BlockTags.MINEABLE_WITH_AXE).add(SBBlocks.WHITE_MUSHROOM_BLOCK.get(), SBBlocks.WHITE_MUSHROOM.get(), SBBlocks.BLACK_MUSHROOM_BLOCK.get(), SBBlocks.BLACK_MUSHROOM.get());
		tag(BlockTags.MINEABLE_WITH_HOE).add(SBBlocks.PEAT.get(), SBBlocks.OOTHECA.get()).addTag(BlockTags.LEAVES);
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(SBBlocks.OBSIDIAN_SPIKE.get(), SBBlocks.ICICLE.get(), SBBlocks.CRYPTALITH.get(), SBBlocks.INFUSED_CRYPTALITH.get(), SBBlocks.DEPLETED_CRYPTALITH.get(), SBBlocks.STYPHIUM.get(), SBBlocks.DEEPSLATE_STYPHIUM.get(), SBBlocks.PEGMATITE.get(), SBBlocks.PEGMATITE_SLAB.get(), SBBlocks.PEGMATITE_STAIRS.get(), SBBlocks.PEGMATITE_WALL.get(), SBBlocks.POLISHED_PEGMATITE.get(), SBBlocks.POLISHED_PEGMATITE_SLAB.get(), SBBlocks.POLISHED_PEGMATITE_STAIRS.get(), SBBlocks.CRACKED_MUD.get(), SBBlocks.JADE_BLOCK.get(), SBBlocks.EXOSKELETON_ORE.get(), SBBlocks.DEEPSLATE_EXOSKELETON_ORE.get(), SBBlocks.BLACK_SANDSTONE.get(), SBBlocks.BLACK_SANDSTONE_SLAB.get(), SBBlocks.BLACK_SANDSTONE_STAIRS.get(), SBBlocks.BLACK_SANDSTONE_WALL.get(), SBBlocks.SMOOTH_BLACK_SANDSTONE.get(), SBBlocks.SMOOTH_BLACK_SANDSTONE_SLAB.get(), SBBlocks.SMOOTH_BLACK_SANDSTONE_STAIRS.get(), SBBlocks.CUT_BLACK_SANDSTONE.get(), SBBlocks.CUT_BLACK_SANDSTONE_SLAB.get(), SBBlocks.CHISELED_BLACK_SANDSTONE.get());
		tag(BlockTags.MINEABLE_WITH_SHOVEL).add(SBBlocks.BLACK_SAND.get(), SBBlocks.ARIDISOL.get()).addTag(SBTags.Blocks.ANTHILLS);
		tag(BlockTags.NEEDS_DIAMOND_TOOL).add(SBBlocks.EXOSKELETON_ORE.get(), SBBlocks.DEEPSLATE_EXOSKELETON_ORE.get(), SBBlocks.OBSIDIAN_SPIKE.get());
		tag(BlockTags.NEEDS_IRON_TOOL).add(SBBlocks.JADE_BLOCK.get());
	}

	private void generateWoodFamilies() {
		WoodFamily.getAllFamilies().forEach(family -> {
			if (family.isFlammable()) tag(BlockTags.LOGS_THAT_BURN).addTag(family.getLogs());

			family.getVariants().forEach((variant, object) -> {
				if (object.isPresent()) {
					if (object.get() instanceof Block block) {
						if (variant.equals(WoodFamily.Variant.BUTTON)) tag(BlockTags.WOODEN_BUTTONS).add(block);
						else if (variant.equals(WoodFamily.Variant.DOOR)) tag(BlockTags.WOODEN_DOORS).add(block);
						else if (variant.equals(WoodFamily.Variant.FENCE)) tag(BlockTags.WOODEN_FENCES).add(block);
						else if (variant.equals(WoodFamily.Variant.FENCE_GATE))
							tag(BlockTags.FENCE_GATES).add(block);
						else if (variant.equals(WoodFamily.Variant.HANGING_SIGN))
							tag(BlockTags.CEILING_HANGING_SIGNS).add(block);
						else if (variant.equals(WoodFamily.Variant.LEAVES)) tag(BlockTags.LEAVES).add(block);
						else if (variant.equals(WoodFamily.Variant.LOG)) tag(family.getLogs()).add(block);
						else if (variant.equals(WoodFamily.Variant.SAPLING)) tag(BlockTags.SAPLINGS).add(block);
						else if (variant.equals(WoodFamily.Variant.SIGN)) tag(BlockTags.STANDING_SIGNS).add(block);
						else if (variant.equals(WoodFamily.Variant.SLAB)) tag(BlockTags.WOODEN_SLABS).add(block);
						else if (variant.equals(WoodFamily.Variant.STAIRS)) tag(BlockTags.WOODEN_STAIRS).add(block);
						else if (variant.equals(WoodFamily.Variant.STRIPPED_LOG)) tag(family.getLogs()).add(block);
						else if (variant.equals(WoodFamily.Variant.STRIPPED_WOOD)) tag(family.getLogs()).add(block);
						else if (variant.equals(WoodFamily.Variant.PLANKS)) tag(BlockTags.PLANKS).add(block);
						else if (variant.equals(WoodFamily.Variant.PRESSURE_PLATE))
							tag(BlockTags.WOODEN_PRESSURE_PLATES).add(block);
						else if (variant.equals(WoodFamily.Variant.TRAPDOOR))
							tag(BlockTags.WOODEN_TRAPDOORS).add(block);
						else if (variant.equals(WoodFamily.Variant.WALL_HANGING_SIGN))
							tag(BlockTags.WALL_HANGING_SIGNS).add(block);
						else if (variant.equals(WoodFamily.Variant.WALL_SIGN)) tag(BlockTags.WALL_SIGNS).add(block);
						else if (variant.equals(WoodFamily.Variant.WOOD)) tag(family.getLogs()).add(block);
					}
				}
			});
		});
	}
}
