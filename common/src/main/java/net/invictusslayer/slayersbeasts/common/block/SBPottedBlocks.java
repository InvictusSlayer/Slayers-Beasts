package net.invictusslayer.slayersbeasts.common.block;

import dev.architectury.registry.registries.RegistrySupplier;
import net.invictusslayer.slayersbeasts.common.init.SBBlocks;

public class SBPottedBlocks {
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
	
	private static void register(RegistrySupplier<?> plant, RegistrySupplier<?> potted) {
//		((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(plant.getId(), () -> (Block) potted.get());
	}
}
