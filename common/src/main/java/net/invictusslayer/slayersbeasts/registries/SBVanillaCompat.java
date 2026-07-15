package net.invictusslayer.slayersbeasts.registries;

import net.invictusslayer.scabbard.platform.IPlatformHandler;
import net.invictusslayer.slayersbeasts.world.level.block.SBWoodFamily;

public class SBVanillaCompat {
	public static void register(IPlatformHandler platform) {
		SBWoodFamily.getAllFamilies().forEach(family -> {
			family.registerFlammability(platform);
			family.registerStrippability(platform);
            family.registerDispensability();
		});

		platform.addFlammableBlock(SBBlocks.PEAT.get(), 5, 5);
		platform.addFlammableBlock(SBBlocks.OOTHECA.get(), 20, 30);
		platform.addFlammableBlock(SBBlocks.TALL_DEAD_BUSH.get(), 100, 60);
		platform.addFlammableBlock(SBBlocks.ALBINO_REDWOOD_LEAVES.get(), 60, 30);
		platform.addFlammableBlock(SBBlocks.WILLOW_BRANCH.get(), 60, 15);
		platform.addFlammableBlock(SBBlocks.WILLOW_BRANCH_PLANT.get(), 60, 15);
	}
}
