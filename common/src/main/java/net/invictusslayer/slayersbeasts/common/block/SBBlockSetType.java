package net.invictusslayer.slayersbeasts.common.block;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class SBBlockSetType {
	public static final BlockSetType ASPEN = register("aspen");
	public static final BlockSetType BLOODWOOD = register("bloodwood");
	public static final BlockSetType CAJOLE = register("cajole");
	public static final BlockSetType DESERT_OAK = register("desert_oak");
	public static final BlockSetType EUCALYPTUS = register("eucalyptus");
	public static final BlockSetType KAPOK = register("kapok");
	public static final BlockSetType REDWOOD = register("redwood");
	public static final BlockSetType WILLOW = register("willow");
	
	private static BlockSetType register(String name) {
		return new BlockSetType(SlayersBeasts.MOD_ID + ":" + name);
	}
}
