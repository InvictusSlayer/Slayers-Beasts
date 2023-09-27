package net.invictusslayer.slayersbeasts.block;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.Block;

public class SBStrippableBlocks {
	public static void setup() {
		register(SBBlocks.ASPEN_LOG.get(), SBBlocks.STRIPPED_ASPEN_LOG.get());
		register(SBBlocks.ASPEN_WOOD.get(), SBBlocks.STRIPPED_ASPEN_WOOD.get());
		register(SBBlocks.CAJOLE_LOG.get(), SBBlocks.STRIPPED_CAJOLE_LOG.get());
		register(SBBlocks.CAJOLE_WOOD.get(), SBBlocks.STRIPPED_CAJOLE_WOOD.get());
		register(SBBlocks.DESERT_OAK_LOG.get(), SBBlocks.STRIPPED_DESERT_OAK_LOG.get());
		register(SBBlocks.DESERT_OAK_WOOD.get(), SBBlocks.STRIPPED_DESERT_OAK_WOOD.get());
		register(SBBlocks.EUCALYPTUS_LOG.get(), SBBlocks.STRIPPED_EUCALYPTUS_LOG.get());
		register(SBBlocks.EUCALYPTUS_WOOD.get(), SBBlocks.STRIPPED_EUCALYPTUS_WOOD.get());
		register(SBBlocks.KAPOK_LOG.get(), SBBlocks.STRIPPED_KAPOK_LOG.get());
		register(SBBlocks.KAPOK_WOOD.get(), SBBlocks.STRIPPED_KAPOK_WOOD.get());
		register(SBBlocks.REDWOOD_LOG.get(), SBBlocks.STRIPPED_REDWOOD_LOG.get());
		register(SBBlocks.REDWOOD_WOOD.get(), SBBlocks.STRIPPED_REDWOOD_WOOD.get());
		register(SBBlocks.WILLOW_LOG.get(), SBBlocks.STRIPPED_WILLOW_LOG.get());
		register(SBBlocks.WILLOW_WOOD.get(), SBBlocks.STRIPPED_WILLOW_WOOD.get());
	}
	
	private static void register(Block block, Block result) {
		AxeItem.STRIPPABLES.put(block, result);
	}
}
