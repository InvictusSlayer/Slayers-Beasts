package net.invictusslayer.slayersbeasts.common.block;

import dev.architectury.registry.registries.RegistrySupplier;
import net.invictusslayer.slayersbeasts.common.init.SBBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;

public class SBFlammableBlocks {
	public static void register() {
		registerWoodFamilies();

		register(SBBlocks.PEAT, 5, 5);
		register(SBBlocks.OOTHECA, 20, 30);
		register(SBBlocks.TALL_DEAD_BUSH, 100, 60);
		register(SBBlocks.ALBINO_REDWOOD_LEAVES, 60, 30);
		register(SBBlocks.WILLOW_BRANCH, 60, 15);
		register(SBBlocks.WILLOW_BRANCH_PLANT, 60, 15);
	}
	
	private static void registerWoodFamilies() {
		WoodFamily.getAllFamilies().filter(WoodFamily::isFlammable).forEach(family -> family.getVariants().forEach((variant, supplier) -> {
			switch (variant) {
				case LOG, WOOD, STRIPPED_LOG, STRIPPED_WOOD -> register(supplier, 5, 5);
				case LEAVES -> register(supplier, 60, 30);
				case PLANKS, STAIRS, SLAB, FENCE, FENCE_GATE -> register(supplier, 20, 5);
			}
		}));
	}
	
	private static void register(RegistrySupplier<?> block, int flammability, int encouragement) {
		((FireBlock) Blocks.FIRE).setFlammable((Block) block.get(), encouragement, flammability);
	}
}
