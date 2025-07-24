package net.invictusslayer.slayersbeasts.item;

import net.invictusslayer.scabbard.world.level.item.DispensableItems;
import net.invictusslayer.slayersbeasts.block.SBWoodFamily;

public abstract class SBDispensableItems extends DispensableItems {
	public static void registerAll() {
		registerWoodFamilies(SBWoodFamily.getAllFamilies());
	}
}
