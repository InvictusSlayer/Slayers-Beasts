package net.invictusslayer.slayersbeasts.block;

import net.minecraft.data.BlockFamily;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;

public class SBFlammableBlocks {
	public static void setup() {
		register(SBBlocks.OOTHECA.get(), 20, 30);
		register(SBBlocks.TALL_DEAD_BUSH.get(), 100, 60);

		register(SBBlocks.ASPEN_LOG.get(), 5, 5);
		register(SBBlocks.STRIPPED_ASPEN_LOG.get(), 5, 5);
		register(SBBlocks.ASPEN_WOOD.get(), 5, 5);
		register(SBBlocks.STRIPPED_ASPEN_WOOD.get(), 5, 5);
		register(SBBlocks.ASPEN_LEAVES.get(), 60, 30);
		registerFamily(SBBlockFamilies.ASPEN_PLANKS);

		register(SBBlocks.CAJOLE_LOG.get(), 5, 5);
		register(SBBlocks.STRIPPED_CAJOLE_LOG.get(), 5, 5);
		register(SBBlocks.CAJOLE_WOOD.get(), 5, 5);
		register(SBBlocks.STRIPPED_CAJOLE_WOOD.get(), 5, 5);
		register(SBBlocks.CAJOLE_LEAVES.get(), 60, 30);
		registerFamily(SBBlockFamilies.CAJOLE_PLANKS);

		register(SBBlocks.DESERT_OAK_LOG.get(), 5, 5);
		register(SBBlocks.STRIPPED_DESERT_OAK_LOG.get(), 5, 5);
		register(SBBlocks.DESERT_OAK_WOOD.get(), 5, 5);
		register(SBBlocks.STRIPPED_DESERT_OAK_WOOD.get(), 5, 5);
		register(SBBlocks.DESERT_OAK_LEAVES.get(), 60, 30);
		registerFamily(SBBlockFamilies.DESERT_OAK_PLANKS);

		register(SBBlocks.EUCALYPTUS_LOG.get(), 5, 5);
		register(SBBlocks.STRIPPED_EUCALYPTUS_LOG.get(), 5, 5);
		register(SBBlocks.EUCALYPTUS_WOOD.get(), 5, 5);
		register(SBBlocks.STRIPPED_EUCALYPTUS_WOOD.get(), 5, 5);
		register(SBBlocks.EUCALYPTUS_LEAVES.get(), 60, 30);
		registerFamily(SBBlockFamilies.EUCALYPTUS_PLANKS);

		register(SBBlocks.KAPOK_LOG.get(), 5, 5);
		register(SBBlocks.STRIPPED_KAPOK_LOG.get(), 5, 5);
		register(SBBlocks.KAPOK_WOOD.get(), 5, 5);
		register(SBBlocks.STRIPPED_KAPOK_WOOD.get(), 5, 5);
		register(SBBlocks.KAPOK_LEAVES.get(), 60, 30);
		registerFamily(SBBlockFamilies.KAPOK_PLANKS);

		register(SBBlocks.REDWOOD_LOG.get(), 5, 5);
		register(SBBlocks.STRIPPED_REDWOOD_LOG.get(), 5, 5);
		register(SBBlocks.REDWOOD_WOOD.get(), 5, 5);
		register(SBBlocks.STRIPPED_REDWOOD_WOOD.get(), 5, 5);
		register(SBBlocks.REDWOOD_LEAVES.get(), 60, 30);
		registerFamily(SBBlockFamilies.REDWOOD_PLANKS);

		register(SBBlocks.WILLOW_LOG.get(), 5, 5);
		register(SBBlocks.STRIPPED_WILLOW_LOG.get(), 5, 5);
		register(SBBlocks.WILLOW_WOOD.get(), 5, 5);
		register(SBBlocks.STRIPPED_WILLOW_WOOD.get(), 5, 5);
		register(SBBlocks.WILLOW_LEAVES.get(), 60, 30);
		registerFamily(SBBlockFamilies.WILLOW_PLANKS);
		register(SBBlocks.WILLOW_BRANCH.get(), 60, 15);
		register(SBBlocks.WILLOW_BRANCH_PLANT.get(), 60, 15);
	}
	
	private static void registerFamily(BlockFamily family) {
		register(family.getBaseBlock(), 20, 5);
		register(family.get(BlockFamily.Variant.SLAB), 20, 5);
		register(family.get(BlockFamily.Variant.STAIRS), 20, 5);
		register(family.get(BlockFamily.Variant.FENCE), 20, 5);
		register(family.get(BlockFamily.Variant.FENCE_GATE), 20, 5);
	}
	
	private static void register(Block block, int flammability, int encouragement) {
		((FireBlock) Blocks.FIRE).setFlammable(block, encouragement, flammability);
	}
}
