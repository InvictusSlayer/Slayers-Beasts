package net.invictusslayer.slayersbeasts.block;

import net.invictusslayer.scabbard.world.level.block.FlammableBlocks;
import net.invictusslayer.slayersbeasts.init.SBBlocks;

public abstract class SBFlammableBlocks extends FlammableBlocks {
	public static void registerAll() {
		registerWoodFamilies(SBWoodFamily.getAllFamilies());

		register(SBBlocks.PEAT, 5, 5);
		register(SBBlocks.OOTHECA, 20, 30);
		register(SBBlocks.TALL_DEAD_BUSH, 100, 60);
		register(SBBlocks.ALBINO_REDWOOD_LEAVES, 60, 30);
		register(SBBlocks.WILLOW_BRANCH, 60, 15);
		register(SBBlocks.WILLOW_BRANCH_PLANT, 60, 15);
	}
}
