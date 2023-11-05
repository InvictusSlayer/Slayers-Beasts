package net.invictusslayer.slayersbeasts.client.renderer;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.entity.SBBoat;
import net.invictusslayer.slayersbeasts.entity.SBChestBoat;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

@OnlyIn(Dist.CLIENT)
public class SBBoatRenderer extends BoatRenderer {
	private final Map<SBBoat.Type, Pair<ResourceLocation, ListModel<Boat>>> boatResources;
	private static final Set<ModelLayerLocation> BOAT_LAYERS = new ObjectArraySet<>();
	private static final Set<ModelLayerLocation> CHEST_BOAT_LAYERS = new ObjectArraySet<>();
	public static final ModelLayerLocation ASPEN = register("aspen", false);
	public static final ModelLayerLocation CHEST_ASPEN = register("aspen", true);
	public static final ModelLayerLocation DESERT_OAK = register("desert_oak", false);
	public static final ModelLayerLocation CHEST_DESERT_OAK = register("desert_oak", true);
	public static final ModelLayerLocation EUCALYPTUS = register("eucalyptus", false);
	public static final ModelLayerLocation CHEST_EUCALYPTUS = register("eucalyptus", true);
	public static final ModelLayerLocation KAPOK = register("kapok", false);
	public static final ModelLayerLocation CHEST_KAPOK = register("kapok", true);
	public static final ModelLayerLocation REDWOOD = register("redwood", false);
	public static final ModelLayerLocation CHEST_REDWOOD = register("redwood", true);
	public static final ModelLayerLocation WILLOW = register("willow", false);
	public static final ModelLayerLocation CHEST_WILLOW = register("willow", true);

	public SBBoatRenderer(EntityRendererProvider.Context context, boolean chestBoat) {
		super(context, chestBoat);
		boatResources = Stream.of(SBBoat.Type.values()).collect(ImmutableMap.toImmutableMap(type -> type, type ->
				Pair.of(new ResourceLocation(SlayersBeasts.MOD_ID, getTextureLocation(type, chestBoat)), createBoatModel(context, type, chestBoat))));
	}

	private static String getTextureLocation(SBBoat.Type type, boolean chestBoat) {
		return chestBoat ? "textures/entity/chest_boat/" + type.getName() + ".png" : "textures/entity/boat/" + type.getName() + ".png";
	}

	private ListModel<Boat> createBoatModel(EntityRendererProvider.Context context, SBBoat.Type type, boolean chestBoat) {
		ModelLayerLocation location = chestBoat ? createChestBoatModelName(type) : createBoatModelName(type);
		ModelPart part = context.bakeLayer(location);
		return chestBoat ? new ChestBoatModel(part) : new BoatModel(part);
	}

	private static ModelLayerLocation createBoatModelName(SBBoat.Type type) {
		return createLocation("boat/" + type.getName());
	}

	private static ModelLayerLocation createChestBoatModelName(SBBoat.Type type) {
		return createLocation("chest_boat/" + type.getName());
	}

	private static ModelLayerLocation createLocation(String texture) {
		return new ModelLayerLocation(new ResourceLocation(SlayersBeasts.MOD_ID, texture), "main");
	}

	public Pair<ResourceLocation, ListModel<Boat>> getModelWithLocation(Boat boat) {
		if (boat instanceof SBBoat boat1) return boatResources.get(boat1.getSBVariant());
		if (boat instanceof SBChestBoat boat1) return boatResources.get(boat1.getSBVariant());
		return null;
	}

	private static ModelLayerLocation register(String name, boolean chestBoat) {
		String chest = chestBoat ? "chest_" : "";
		ModelLayerLocation location = new ModelLayerLocation(new ResourceLocation(SlayersBeasts.MOD_ID, chest + "boat/" + name), "main");
		if (chestBoat) CHEST_BOAT_LAYERS.add(location);
		else BOAT_LAYERS.add(location);
		return location;
	}

	public static Stream<ModelLayerLocation> boatLayers() {
		return BOAT_LAYERS.stream();
	}
	public static Stream<ModelLayerLocation> chestBoatLayers() {
		return CHEST_BOAT_LAYERS.stream();
	}
}
