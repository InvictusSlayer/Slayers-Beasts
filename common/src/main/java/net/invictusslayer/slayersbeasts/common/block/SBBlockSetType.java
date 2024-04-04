package net.invictusslayer.slayersbeasts.common.block;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
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
		return new BlockSetType(SlayersBeasts.MOD_ID + ":" + name);
	}
}
