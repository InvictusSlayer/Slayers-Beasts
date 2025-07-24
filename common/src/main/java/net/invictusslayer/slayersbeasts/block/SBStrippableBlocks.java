package net.invictusslayer.slayersbeasts.block;

import net.invictusslayer.scabbard.world.level.WoodFamily;
import net.invictusslayer.scabbard.world.level.block.StrippableBlocks;

import java.util.stream.Stream;

public abstract class SBStrippableBlocks extends StrippableBlocks {
	public static void registerAll() {
		registerWoodFamilies(SBWoodFamily.getAllFamilies());
	}

	protected static void registerWoodFamilies(Stream<WoodFamily> families) {
		families.forEach((family) -> {
			register(family.get(WoodFamily.Variant.LOG), family.get(WoodFamily.Variant.STRIPPED_LOG));
			register(family.get(WoodFamily.Variant.WOOD), family.get(WoodFamily.Variant.STRIPPED_WOOD));
		});
	}
}
