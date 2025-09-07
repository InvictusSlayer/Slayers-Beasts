package net.invictusslayer.slayersbeasts.world.item;

import net.invictusslayer.scabbard.world.level.item.DispensableItems;
import net.invictusslayer.slayersbeasts.world.level.block.SBWoodFamily;

public abstract class SBDispensableItems extends DispensableItems {
	public static void register() {
		registerWoodFamilies(SBWoodFamily.getAllFamilies());
	}
}
