package net.invictusslayer.slayersbeasts.common.item;

import net.invictusslayer.slayersbeasts.common.block.WoodFamily;
import net.minecraft.core.dispenser.BoatDispenseItemBehavior;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.DispenserBlock;

public class SBDispensableItems {
	public static void register() {
		registerWoodFamilies();
	}

	private static void registerWoodFamilies() {
		WoodFamily.getAllFamilies().forEach(family -> {
			Boat.Type type = family.getBoatType();
			if (type == null) return;
			DispenserBlock.registerBehavior((ItemLike) family.get(WoodFamily.Variant.BOAT).get(), new BoatDispenseItemBehavior(type));
			DispenserBlock.registerBehavior((ItemLike) family.get(WoodFamily.Variant.CHEST_BOAT).get(), new BoatDispenseItemBehavior(type, true));
		});
	}
}
