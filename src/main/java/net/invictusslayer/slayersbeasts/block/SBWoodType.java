package net.invictusslayer.slayersbeasts.block;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.Set;
import java.util.stream.Stream;

public class SBWoodType {
	private static final Set<WoodType> WOOD_TYPES = new ObjectArraySet<>();
	public static final WoodType ASPEN = register("aspen", SBBlockSetType.ASPEN);
	public static final WoodType CAJOLE = register("cajole", SBBlockSetType.CAJOLE);
	public static final WoodType DESERT_OAK = register("desert_oak", SBBlockSetType.DESERT_OAK);
	public static final WoodType EUCALYPTUS = register("eucalyptus", SBBlockSetType.EUCALYPTUS);
	public static final WoodType KAPOK = register("kapok", SBBlockSetType.KAPOK);
	public static final WoodType REDWOOD = register("redwood", SBBlockSetType.REDWOOD);
	public static final WoodType WILLOW = register("willow", SBBlockSetType.WILLOW);

	public static WoodType register(String name, BlockSetType type) {
		WoodType woodType = new WoodType(SlayersBeasts.MOD_ID + ":" + name, type);
		WOOD_TYPES.add(woodType);
		return WoodType.register(woodType);
	}

	public static Stream<WoodType> values() {
		return WOOD_TYPES.stream();
	}
}
