package net.invictusslayer.slayersbeasts.init;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class SBModelLayers {
	public static final ModelLayerLocation ASPEN_BOAT = register("boat/aspen");
	public static final ModelLayerLocation ASPEN_CHEST_BOAT = register("chest_boat/aspen");
	public static final ModelLayerLocation DESERT_OAK_BOAT = register("boat/desert_oak");
	public static final ModelLayerLocation DESERT_OAK_CHEST_BOAT = register("chest_boat/desert_oak");
	public static final ModelLayerLocation EUCALYPTUS_BOAT = register("boat/eucalyptus");
	public static final ModelLayerLocation EUCALYPTUS_CHEST_BOAT = register("chest_boat/eucalyptus");
	public static final ModelLayerLocation KAPOK_BOAT = register("boat/kapok");
	public static final ModelLayerLocation KAPOK_CHEST_BOAT = register("chest_boat/kapok");
	public static final ModelLayerLocation REDWOOD_BOAT = register("boat/redwood");
	public static final ModelLayerLocation REDWOOD_CHEST_BOAT = register("chest_boat/redwood");
	public static final ModelLayerLocation WILLOW_BOAT = register("boat/willow");
	public static final ModelLayerLocation WILLOW_CHEST_BOAT = register("chest_boat/willow");

	private static ModelLayerLocation register(String path) {
		return new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, path), "main");
	}
}
