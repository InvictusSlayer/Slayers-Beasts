package net.invictusslayer.slayersbeasts.item;

import net.invictusslayer.slayersbeasts.misc.SBBoatType;
import net.minecraft.core.dispenser.BoatDispenseItemBehavior;
import net.minecraft.world.level.block.DispenserBlock;

public class SBDispenserItems {
	public static void register() {
		DispenserBlock.registerBehavior(SBItems.ASPEN_BOAT.get(), new BoatDispenseItemBehavior(SBBoatType.ASPEN));
		DispenserBlock.registerBehavior(SBItems.DESERT_OAK_BOAT.get(), new BoatDispenseItemBehavior(SBBoatType.DESERT_OAK));
		DispenserBlock.registerBehavior(SBItems.EUCALYPTUS_BOAT.get(), new BoatDispenseItemBehavior(SBBoatType.EUCALYPTUS));
		DispenserBlock.registerBehavior(SBItems.KAPOK_BOAT.get(), new BoatDispenseItemBehavior(SBBoatType.KAPOK));
		DispenserBlock.registerBehavior(SBItems.REDWOOD_BOAT.get(), new BoatDispenseItemBehavior(SBBoatType.REDWOOD));
		DispenserBlock.registerBehavior(SBItems.WILLOW_BOAT.get(), new BoatDispenseItemBehavior(SBBoatType.WILLOW));
		DispenserBlock.registerBehavior(SBItems.ASPEN_CHEST_BOAT.get(), new BoatDispenseItemBehavior(SBBoatType.ASPEN, true));
		DispenserBlock.registerBehavior(SBItems.DESERT_OAK_CHEST_BOAT.get(), new BoatDispenseItemBehavior(SBBoatType.DESERT_OAK, true));
		DispenserBlock.registerBehavior(SBItems.EUCALYPTUS_CHEST_BOAT.get(), new BoatDispenseItemBehavior(SBBoatType.EUCALYPTUS, true));
		DispenserBlock.registerBehavior(SBItems.KAPOK_CHEST_BOAT.get(), new BoatDispenseItemBehavior(SBBoatType.KAPOK, true));
		DispenserBlock.registerBehavior(SBItems.REDWOOD_CHEST_BOAT.get(), new BoatDispenseItemBehavior(SBBoatType.REDWOOD, true));
		DispenserBlock.registerBehavior(SBItems.WILLOW_CHEST_BOAT.get(), new BoatDispenseItemBehavior(SBBoatType.WILLOW, true));
	}
}
