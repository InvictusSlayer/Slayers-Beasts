package net.invictusslayer.slayersbeasts.common.block;

import com.google.common.collect.Maps;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.Block;

public class SBStrippableBlocks {
	public static void register() {
		registerWoodFamilies();
	}

	private static void registerWoodFamilies() {
		WoodFamily.getAllFamilies().forEach(family -> {
			register(family.get(WoodFamily.Variant.LOG), family.get(WoodFamily.Variant.STRIPPED_LOG));
			register(family.get(WoodFamily.Variant.WOOD), family.get(WoodFamily.Variant.STRIPPED_WOOD));
		});
	}
	
	private static void register(RegistrySupplier<?> block, RegistrySupplier<?> result) {
		AxeItem.STRIPPABLES = Maps.newHashMap(AxeItem.STRIPPABLES);
		AxeItem.STRIPPABLES.put((Block) block.get(), (Block) result.get());
	}
}
