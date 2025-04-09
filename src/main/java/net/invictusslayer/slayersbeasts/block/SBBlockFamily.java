package net.invictusslayer.slayersbeasts.block;

import net.invictusslayer.slayersbeasts.init.SBBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class SBBlockFamily {
	private static final Map<Block, BlockFamily> FAMILIES = new HashMap<>();
	public static final BlockFamily BLACK_SANDSTONE = builder(SBBlocks.BLACK_SANDSTONE.get()).wall(SBBlocks.BLACK_SANDSTONE_WALL.get()).stairs(SBBlocks.BLACK_SANDSTONE_STAIRS.get()).slab(SBBlocks.BLACK_SANDSTONE_SLAB.get()).chiseled(SBBlocks.CHISELED_BLACK_SANDSTONE.get()).cut(SBBlocks.CUT_BLACK_SANDSTONE.get()).dontGenerateRecipe().dontGenerateModel().getFamily();
	public static final BlockFamily SMOOTH_BLACK_SANDSTONE = builder(SBBlocks.SMOOTH_BLACK_SANDSTONE.get()).slab(SBBlocks.SMOOTH_BLACK_SANDSTONE_SLAB.get()).stairs(SBBlocks.SMOOTH_BLACK_SANDSTONE_STAIRS.get()).dontGenerateModel().getFamily();
	public static final BlockFamily CUT_BLACK_SANDSTONE = builder(SBBlocks.CUT_BLACK_SANDSTONE.get()).slab(SBBlocks.CUT_BLACK_SANDSTONE_SLAB.get()).dontGenerateModel().getFamily();
	public static final BlockFamily PEGMATITE = builder(SBBlocks.PEGMATITE.get()).slab(SBBlocks.PEGMATITE_SLAB.get()).stairs(SBBlocks.PEGMATITE_STAIRS.get()).wall(SBBlocks.PEGMATITE_WALL.get()).polished(SBBlocks.POLISHED_PEGMATITE.get()).getFamily();
	public static final BlockFamily POLISHED_PEGMATITE = builder(SBBlocks.POLISHED_PEGMATITE.get()).slab(SBBlocks.POLISHED_PEGMATITE_SLAB.get()).stairs(SBBlocks.POLISHED_PEGMATITE_STAIRS.get()).getFamily();

	private static BlockFamily.Builder builder(Block block) {
		BlockFamily.Builder builder = new BlockFamily.Builder(block);
		BlockFamily family = FAMILIES.put(block, builder.getFamily());
		if (family != null) {
			throw new IllegalStateException("Duplicate family definition for " + BuiltInRegistries.BLOCK.getKey(block));
		} else {
			return builder;
		}
	}

	public static Stream<BlockFamily> getAllFamilies() {
		return FAMILIES.values().stream();
	}
}
