package net.invictusslayer.slayersbeasts.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class SBPottedPlants {
	public static void register() {
		register(SBBlocks.BLACK_MUSHROOM, SBBlocks.POTTED_BLACK_MUSHROOM);
		register(SBBlocks.WHITE_MUSHROOM, SBBlocks.POTTED_WHITE_MUSHROOM);

		register(SBBlocks.ASPEN_SAPLING, SBBlocks.POTTED_ASPEN_SAPLING);
		register(SBBlocks.DESERT_OAK_SAPLING, SBBlocks.POTTED_DESERT_OAK_SAPLING);
		register(SBBlocks.EUCALYPTUS_SAPLING, SBBlocks.POTTED_EUCALYPTUS_SAPLING);
		register(SBBlocks.KAPOK_SAPLING, SBBlocks.POTTED_KAPOK_SAPLING);
		register(SBBlocks.REDWOOD_SAPLING, SBBlocks.POTTED_REDWOOD_SAPLING);
		register(SBBlocks.WILLOW_SAPLING, SBBlocks.POTTED_WILLOW_SAPLING);
	}
	
	private static void register(RegistryObject<Block> plant, Supplier<? extends Block> potted) {
		((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(plant.getId(), potted);
	}
}
