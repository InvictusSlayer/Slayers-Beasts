package net.invictusslayer.slayersbeasts.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.minecraftforge.registries.RegistryObject;

public class SBFlammableBlocks {
	public static void register() {
		registerWoodFamilies();

		register(SBBlocks.PEAT, 5, 5);
		register(SBBlocks.OOTHECA, 20, 30);
		register(SBBlocks.TALL_DEAD_BUSH, 100, 60);
		register(SBBlocks.WILLOW_BRANCH, 60, 15);
		register(SBBlocks.WILLOW_BRANCH_PLANT, 60, 15);
	}
	
	private static void registerWoodFamilies() {
		WoodFamily.getAllFamilies().filter(WoodFamily::isFlammable).forEach(family -> {
			register(family.get(WoodFamily.Variant.LOG), 5, 5);
			register(family.get(WoodFamily.Variant.WOOD), 5, 5);
			register(family.get(WoodFamily.Variant.STRIPPED_LOG), 5, 5);
			register(family.get(WoodFamily.Variant.STRIPPED_WOOD), 5, 5);
			register(family.get(WoodFamily.Variant.LEAVES), 60, 30);
			register(family.get(WoodFamily.Variant.PLANKS), 20, 5);
			register(family.get(WoodFamily.Variant.STAIRS), 20, 5);
			register(family.get(WoodFamily.Variant.SLAB), 20, 5);
			register(family.get(WoodFamily.Variant.FENCE), 20, 5);
			register(family.get(WoodFamily.Variant.FENCE_GATE), 20, 5);
		});
	}
	
	private static void register(RegistryObject<?> block, int flammability, int encouragement) {
		((FireBlock) Blocks.FIRE).setFlammable((Block) block.get(), encouragement, flammability);
	}
}
