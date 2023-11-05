package net.invictusslayer.slayersbeasts.block;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class SBBlockSetType {
	public static final BlockSetType ASPEN = woodType("aspen");
	public static final BlockSetType CAJOLE = woodType("cajole");
	public static final BlockSetType DESERT_OAK = woodType("desert_oak");
	public static final BlockSetType EUCALYPTUS = woodType("eucalyptus");
	public static final BlockSetType KAPOK = woodType("kapok");
	public static final BlockSetType REDWOOD = woodType("redwood");
	public static final BlockSetType WILLOW = woodType("willow");

	public static BlockSetType woodType(String name) {
		return new BlockSetType(name, true, SoundType.WOOD, SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN, SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON, SoundEvents.WOODEN_BUTTON_CLICK_OFF, SoundEvents.WOODEN_BUTTON_CLICK_ON);
	}
}
