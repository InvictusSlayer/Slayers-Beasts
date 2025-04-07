package net.invictusslayer.slayersbeasts.common.item;

import net.invictusslayer.slayersbeasts.common.block.WoodFamily;
import net.minecraft.core.dispenser.BoatDispenseItemBehavior;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.AbstractBoat;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.DispenserBlock;

public class SBDispensableItems {
	public static void register() {
		registerWoodFamilies();
	}

	private static void registerWoodFamilies() {
		WoodFamily.getAllFamilies().forEach(family -> {
			if (family.getBoatLayer(false) != null) DispenserBlock.registerBehavior((ItemLike) family.get(WoodFamily.Variant.BOAT_ITEM).get(), new BoatDispenseItemBehavior((EntityType<Boat>) family.get(WoodFamily.Variant.BOAT).get()));
			if (family.getBoatLayer(true) != null) DispenserBlock.registerBehavior((ItemLike) family.get(WoodFamily.Variant.CHEST_BOAT_ITEM).get(), new BoatDispenseItemBehavior((EntityType<ChestBoat>) family.get(WoodFamily.Variant.CHEST_BOAT).get()));
		});
	}
}
