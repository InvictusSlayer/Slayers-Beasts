package net.invictusslayer.slayersbeasts.common.entity.vehicle;

import net.minecraft.world.entity.vehicle.Boat;

import java.util.List;

public class SBBoatType {
	public static Boat.Type ASPEN;
	public static Boat.Type DESERT_OAK;
	public static Boat.Type EUCALYPTUS;
	public static Boat.Type KAPOK;
	public static Boat.Type REDWOOD;
	public static Boat.Type WILLOW;

	public static List<Boat.Type> values() {
		return List.of(ASPEN, DESERT_OAK, EUCALYPTUS, KAPOK, REDWOOD, WILLOW);
	}
}
