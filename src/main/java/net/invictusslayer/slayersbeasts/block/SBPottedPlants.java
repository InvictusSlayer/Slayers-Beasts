package net.invictusslayer.slayersbeasts.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.registries.RegistryObject;

public class SBPottedPlants {
	public static void register() {
		register(SBBlocks.BLACK_MUSHROOM, SBBlocks.POTTED_BLACK_MUSHROOM);
		register(SBBlocks.WHITE_MUSHROOM, SBBlocks.POTTED_WHITE_MUSHROOM);

		registerWoodFamily(WoodFamily.ASPEN);
		registerWoodFamily(WoodFamily.DESERT_OAK);
		registerWoodFamily(WoodFamily.EUCALYPTUS);
		registerWoodFamily(WoodFamily.KAPOK);
		registerWoodFamily(WoodFamily.REDWOOD);
		registerWoodFamily(WoodFamily.WILLOW);
	}

	private static void registerWoodFamily(WoodFamily family) {
		register(family.get(WoodFamily.Variant.SAPLING), family.get(WoodFamily.Variant.POTTED_SAPLING));
	}
	
	private static void register(RegistryObject<?> plant, RegistryObject<?> potted) {
		((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(plant.getId(), () -> (Block) potted.get());
	}
}
