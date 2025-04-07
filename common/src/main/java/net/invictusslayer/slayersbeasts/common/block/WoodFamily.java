package net.invictusslayer.slayersbeasts.common.block;

import dev.architectury.registry.registries.RegistrySupplier;
import net.invictusslayer.slayersbeasts.common.init.SBModelLayers;
import net.invictusslayer.slayersbeasts.common.data.tag.SBTags;
import net.invictusslayer.slayersbeasts.common.init.SBBlocks;
import net.invictusslayer.slayersbeasts.common.init.SBEntities;
import net.invictusslayer.slayersbeasts.common.init.SBItems;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class WoodFamily {
	private TagKey<Block> logBlocks = null;
	private TagKey<Item> logItems = null;
	private ModelLayerLocation boatLayer = null;
	private ModelLayerLocation chestBoatLayer = null;
	private final Map<Variant, RegistrySupplier<?>> variants = new HashMap<>();
	private boolean isFlammable = true;

	private static final List<WoodFamily> FAMILIES = new ArrayList<>();
	public static final WoodFamily ASPEN = builder().button(SBBlocks.ASPEN_BUTTON).boat(SBEntities.ASPEN_BOAT, SBItems.ASPEN_BOAT, SBModelLayers.ASPEN_BOAT).chestBoat(SBEntities.ASPEN_CHEST_BOAT, SBItems.ASPEN_CHEST_BOAT, SBModelLayers.ASPEN_CHEST_BOAT).door(SBBlocks.ASPEN_DOOR).fence(SBBlocks.ASPEN_FENCE).fenceGate(SBBlocks.ASPEN_FENCE_GATE).hangingSign(SBBlocks.ASPEN_HANGING_SIGN, SBBlocks.ASPEN_WALL_HANGING_SIGN, SBItems.ASPEN_HANGING_SIGN).leaves(SBBlocks.ASPEN_LEAVES).log(SBBlocks.ASPEN_LOG, SBTags.Blocks.ASPEN_LOGS, SBTags.Items.ASPEN_LOGS).planks(SBBlocks.ASPEN_PLANKS).pottedSapling(SBBlocks.POTTED_ASPEN_SAPLING).pressurePlate(SBBlocks.ASPEN_PRESSURE_PLATE).sapling(SBBlocks.ASPEN_SAPLING).sign(SBBlocks.ASPEN_SIGN, SBBlocks.ASPEN_WALL_SIGN, SBItems.ASPEN_SIGN).slab(SBBlocks.ASPEN_SLAB).stairs(SBBlocks.ASPEN_STAIRS).strippedLog(SBBlocks.STRIPPED_ASPEN_LOG).strippedWood(SBBlocks.STRIPPED_ASPEN_WOOD).trapdoor(SBBlocks.ASPEN_TRAPDOOR).wood(SBBlocks.ASPEN_WOOD).getFamily();
	public static final WoodFamily CAJOLE = builder().button(SBBlocks.CAJOLE_BUTTON).door(SBBlocks.CAJOLE_DOOR).fence(SBBlocks.CAJOLE_FENCE).fenceGate(SBBlocks.CAJOLE_FENCE_GATE).leaves(SBBlocks.CAJOLE_LEAVES).log(SBBlocks.CAJOLE_LOG, SBTags.Blocks.CAJOLE_LOGS, SBTags.Items.CAJOLE_LOGS).planks(SBBlocks.CAJOLE_PLANKS).pressurePlate(SBBlocks.CAJOLE_PRESSURE_PLATE).sapling(SBBlocks.CAJOLE_SAPLING).slab(SBBlocks.CAJOLE_SLAB).stairs(SBBlocks.CAJOLE_STAIRS).strippedLog(SBBlocks.STRIPPED_CAJOLE_LOG).strippedWood(SBBlocks.STRIPPED_CAJOLE_WOOD).trapdoor(SBBlocks.CAJOLE_TRAPDOOR).wood(SBBlocks.CAJOLE_WOOD).notFlammable().getFamily();
	public static final WoodFamily DESERT_OAK = builder().button(SBBlocks.DESERT_OAK_BUTTON).boat(SBEntities.DESERT_OAK_BOAT, SBItems.DESERT_OAK_BOAT, SBModelLayers.DESERT_OAK_BOAT).chestBoat(SBEntities.DESERT_OAK_CHEST_BOAT, SBItems.DESERT_OAK_CHEST_BOAT, SBModelLayers.DESERT_OAK_CHEST_BOAT).door(SBBlocks.DESERT_OAK_DOOR).fence(SBBlocks.DESERT_OAK_FENCE).fenceGate(SBBlocks.DESERT_OAK_FENCE_GATE).hangingSign(SBBlocks.DESERT_OAK_HANGING_SIGN, SBBlocks.DESERT_OAK_WALL_HANGING_SIGN, SBItems.DESERT_OAK_HANGING_SIGN).leaves(SBBlocks.DESERT_OAK_LEAVES).log(SBBlocks.DESERT_OAK_LOG, SBTags.Blocks.DESERT_OAK_LOGS, SBTags.Items.DESERT_OAK_LOGS).planks(SBBlocks.DESERT_OAK_PLANKS).pottedSapling(SBBlocks.POTTED_DESERT_OAK_SAPLING).pressurePlate(SBBlocks.DESERT_OAK_PRESSURE_PLATE).sapling(SBBlocks.DESERT_OAK_SAPLING).sign(SBBlocks.DESERT_OAK_SIGN, SBBlocks.DESERT_OAK_WALL_SIGN, SBItems.DESERT_OAK_SIGN).slab(SBBlocks.DESERT_OAK_SLAB).stairs(SBBlocks.DESERT_OAK_STAIRS).strippedLog(SBBlocks.STRIPPED_DESERT_OAK_LOG).strippedWood(SBBlocks.STRIPPED_DESERT_OAK_WOOD).trapdoor(SBBlocks.DESERT_OAK_TRAPDOOR).wood(SBBlocks.DESERT_OAK_WOOD).getFamily();
	public static final WoodFamily EUCALYPTUS = builder().button(SBBlocks.EUCALYPTUS_BUTTON).boat(SBEntities.EUCALYPTUS_BOAT, SBItems.EUCALYPTUS_BOAT, SBModelLayers.EUCALYPTUS_BOAT).chestBoat(SBEntities.EUCALYPTUS_CHEST_BOAT, SBItems.EUCALYPTUS_CHEST_BOAT, SBModelLayers.EUCALYPTUS_CHEST_BOAT).door(SBBlocks.EUCALYPTUS_DOOR).fence(SBBlocks.EUCALYPTUS_FENCE).fenceGate(SBBlocks.EUCALYPTUS_FENCE_GATE).hangingSign(SBBlocks.EUCALYPTUS_HANGING_SIGN, SBBlocks.EUCALYPTUS_WALL_HANGING_SIGN, SBItems.EUCALYPTUS_HANGING_SIGN).leaves(SBBlocks.EUCALYPTUS_LEAVES).log(SBBlocks.EUCALYPTUS_LOG, SBTags.Blocks.EUCALYPTUS_LOGS, SBTags.Items.EUCALYPTUS_LOGS).planks(SBBlocks.EUCALYPTUS_PLANKS).pottedSapling(SBBlocks.POTTED_EUCALYPTUS_SAPLING).pressurePlate(SBBlocks.EUCALYPTUS_PRESSURE_PLATE).sapling(SBBlocks.EUCALYPTUS_SAPLING).sign(SBBlocks.EUCALYPTUS_SIGN, SBBlocks.EUCALYPTUS_WALL_SIGN, SBItems.EUCALYPTUS_SIGN).slab(SBBlocks.EUCALYPTUS_SLAB).stairs(SBBlocks.EUCALYPTUS_STAIRS).strippedLog(SBBlocks.STRIPPED_EUCALYPTUS_LOG).strippedWood(SBBlocks.STRIPPED_EUCALYPTUS_WOOD).trapdoor(SBBlocks.EUCALYPTUS_TRAPDOOR).wood(SBBlocks.EUCALYPTUS_WOOD).getFamily();
	public static final WoodFamily KAPOK = builder().button(SBBlocks.KAPOK_BUTTON).boat(SBEntities.KAPOK_BOAT, SBItems.KAPOK_BOAT, SBModelLayers.KAPOK_BOAT).chestBoat(SBEntities.KAPOK_CHEST_BOAT, SBItems.KAPOK_CHEST_BOAT, SBModelLayers.KAPOK_CHEST_BOAT).door(SBBlocks.KAPOK_DOOR).fence(SBBlocks.KAPOK_FENCE).fenceGate(SBBlocks.KAPOK_FENCE_GATE).hangingSign(SBBlocks.KAPOK_HANGING_SIGN, SBBlocks.KAPOK_WALL_HANGING_SIGN, SBItems.KAPOK_HANGING_SIGN).leaves(SBBlocks.KAPOK_LEAVES).log(SBBlocks.KAPOK_LOG, SBTags.Blocks.KAPOK_LOGS, SBTags.Items.KAPOK_LOGS).planks(SBBlocks.KAPOK_PLANKS).pottedSapling(SBBlocks.POTTED_KAPOK_SAPLING).pressurePlate(SBBlocks.KAPOK_PRESSURE_PLATE).sapling(SBBlocks.KAPOK_SAPLING).sign(SBBlocks.KAPOK_SIGN, SBBlocks.KAPOK_WALL_SIGN, SBItems.KAPOK_SIGN).slab(SBBlocks.KAPOK_SLAB).stairs(SBBlocks.KAPOK_STAIRS).strippedLog(SBBlocks.STRIPPED_KAPOK_LOG).strippedWood(SBBlocks.STRIPPED_KAPOK_WOOD).trapdoor(SBBlocks.KAPOK_TRAPDOOR).wood(SBBlocks.KAPOK_WOOD).getFamily();
	public static final WoodFamily REDWOOD = builder().button(SBBlocks.REDWOOD_BUTTON).boat(SBEntities.REDWOOD_BOAT, SBItems.REDWOOD_BOAT, SBModelLayers.REDWOOD_BOAT).chestBoat(SBEntities.REDWOOD_CHEST_BOAT, SBItems.REDWOOD_CHEST_BOAT, SBModelLayers.REDWOOD_CHEST_BOAT).door(SBBlocks.REDWOOD_DOOR).fence(SBBlocks.REDWOOD_FENCE).fenceGate(SBBlocks.REDWOOD_FENCE_GATE).hangingSign(SBBlocks.REDWOOD_HANGING_SIGN, SBBlocks.REDWOOD_WALL_HANGING_SIGN, SBItems.REDWOOD_HANGING_SIGN).leaves(SBBlocks.REDWOOD_LEAVES).log(SBBlocks.REDWOOD_LOG, SBTags.Blocks.REDWOOD_LOGS, SBTags.Items.REDWOOD_LOGS).planks(SBBlocks.REDWOOD_PLANKS).pottedSapling(SBBlocks.POTTED_REDWOOD_SAPLING).pressurePlate(SBBlocks.REDWOOD_PRESSURE_PLATE).sapling(SBBlocks.REDWOOD_SAPLING).sign(SBBlocks.REDWOOD_SIGN, SBBlocks.REDWOOD_WALL_SIGN, SBItems.REDWOOD_SIGN).slab(SBBlocks.REDWOOD_SLAB).stairs(SBBlocks.REDWOOD_STAIRS).strippedLog(SBBlocks.STRIPPED_REDWOOD_LOG).strippedWood(SBBlocks.STRIPPED_REDWOOD_WOOD).trapdoor(SBBlocks.REDWOOD_TRAPDOOR).wood(SBBlocks.REDWOOD_WOOD).getFamily();
	public static final WoodFamily WILLOW = builder().button(SBBlocks.WILLOW_BUTTON).boat(SBEntities.WILLOW_BOAT, SBItems.WILLOW_BOAT, SBModelLayers.WILLOW_BOAT).chestBoat(SBEntities.WILLOW_CHEST_BOAT, SBItems.WILLOW_CHEST_BOAT, SBModelLayers.WILLOW_CHEST_BOAT).door(SBBlocks.WILLOW_DOOR).fence(SBBlocks.WILLOW_FENCE).fenceGate(SBBlocks.WILLOW_FENCE_GATE).hangingSign(SBBlocks.WILLOW_HANGING_SIGN, SBBlocks.WILLOW_WALL_HANGING_SIGN, SBItems.WILLOW_HANGING_SIGN).leaves(SBBlocks.WILLOW_LEAVES).log(SBBlocks.WILLOW_LOG, SBTags.Blocks.WILLOW_LOGS, SBTags.Items.WILLOW_LOGS).planks(SBBlocks.WILLOW_PLANKS).pottedSapling(SBBlocks.POTTED_WILLOW_SAPLING).pressurePlate(SBBlocks.WILLOW_PRESSURE_PLATE).sapling(SBBlocks.WILLOW_SAPLING).sign(SBBlocks.WILLOW_SIGN, SBBlocks.WILLOW_WALL_SIGN, SBItems.WILLOW_SIGN).slab(SBBlocks.WILLOW_SLAB).stairs(SBBlocks.WILLOW_STAIRS).strippedLog(SBBlocks.STRIPPED_WILLOW_LOG).strippedWood(SBBlocks.STRIPPED_WILLOW_WOOD).trapdoor(SBBlocks.WILLOW_TRAPDOOR).wood(SBBlocks.WILLOW_WOOD).getFamily();

	WoodFamily() {}

	public TagKey<Block> getLogBlocks() {
		return logBlocks;
	}

	public TagKey<Item> getLogItems() {
		return logItems;
	}

	public ModelLayerLocation getBoatLayer(boolean chestBoat) {
		return chestBoat ? chestBoatLayer : boatLayer;
	}

	public Map<Variant, RegistrySupplier<?>> getVariants() {
		return variants;
	}
	
	public RegistrySupplier<?> get(Variant variant) {
		return variants.get(variant);
	}

	public boolean isFlammable() {
		return isFlammable;
	}

	private static Builder builder() {
		Builder builder = new Builder();
		FAMILIES.add(builder.getFamily());
		return builder;
	}
	
	public static Stream<WoodFamily> getAllFamilies() {
		return FAMILIES.stream();
	}
	
	public static class Builder {
		private final WoodFamily family;
		
		public Builder() {
			family = new WoodFamily();
		}

		public WoodFamily getFamily() {
			return family;
		}

		public Builder button(RegistrySupplier<Block> button) {
			family.variants.put(Variant.BUTTON, button);
			return this;
		}

		public Builder boat(RegistrySupplier<EntityType<Boat>> boat, RegistrySupplier<Item> boatItem, ModelLayerLocation layer) {
			family.variants.put(Variant.BOAT, boat);
			family.variants.put(Variant.BOAT_ITEM, boatItem);
			family.boatLayer = layer;
			return this;
		}

		public Builder chestBoat(RegistrySupplier<EntityType<ChestBoat>> boat, RegistrySupplier<Item> boatItem, ModelLayerLocation layer) {
			family.variants.put(Variant.CHEST_BOAT, boat);
			family.variants.put(Variant.CHEST_BOAT_ITEM, boatItem);
			family.chestBoatLayer = layer;
			return this;
		}

		public Builder door(RegistrySupplier<Block> door) {
			family.variants.put(Variant.DOOR, door);
			return this;
		}

		public Builder fence(RegistrySupplier<Block> fence) {
			family.variants.put(Variant.FENCE, fence);
			return this;
		}

		public Builder fenceGate(RegistrySupplier<Block> fenceGate) {
			family.variants.put(Variant.FENCE_GATE, fenceGate);
			return this;
		}

		public Builder hangingSign(RegistrySupplier<Block> ceiling, RegistrySupplier<Block> wall, RegistrySupplier<Item> item) {
			family.variants.put(Variant.HANGING_SIGN, ceiling);
			family.variants.put(Variant.WALL_HANGING_SIGN, wall);
			family.variants.put(Variant.HANGING_SIGN_ITEM, item);
			return this;
		}

		public Builder leaves(RegistrySupplier<Block> leaves) {
			family.variants.put(Variant.LEAVES, leaves);
			return this;
		}

		public Builder log(RegistrySupplier<Block> log, TagKey<Block> blockTag, TagKey<Item> itemTag) {
			family.variants.put(Variant.LOG, log);
			family.logBlocks = blockTag;
			family.logItems = itemTag;
			return this;
		}

		public Builder sapling(RegistrySupplier<Block> sapling) {
			family.variants.put(Variant.SAPLING, sapling);
			return this;
		}

		public Builder sign(RegistrySupplier<Block> standing, RegistrySupplier<Block> wall, RegistrySupplier<Item> item) {
			family.variants.put(Variant.SIGN, standing);
			family.variants.put(Variant.WALL_SIGN, wall);
			family.variants.put(Variant.SIGN_ITEM, item);
			return this;
		}

		public Builder slab(RegistrySupplier<Block> slab) {
			family.variants.put(Variant.SLAB, slab);
			return this;
		}

		public Builder stairs(RegistrySupplier<Block> stairs) {
			family.variants.put(Variant.STAIRS, stairs);
			return this;
		}

		public Builder strippedLog(RegistrySupplier<Block> strippedLog) {
			family.variants.put(Variant.STRIPPED_LOG, strippedLog);
			return this;
		}

		public Builder strippedWood(RegistrySupplier<Block> strippedWood) {
			family.variants.put(Variant.STRIPPED_WOOD, strippedWood);
			return this;
		}

		public Builder planks(RegistrySupplier<Block> planks) {
			family.variants.put(Variant.PLANKS, planks);
			return this;
		}

		public Builder pottedSapling(RegistrySupplier<Block> pottedSapling) {
			family.variants.put(Variant.POTTED_SAPLING, pottedSapling);
			return this;
		}

		public Builder pressurePlate(RegistrySupplier<Block> pressurePlate) {
			family.variants.put(Variant.PRESSURE_PLATE, pressurePlate);
			return this;
		}

		public Builder trapdoor(RegistrySupplier<Block> trapdoor) {
			family.variants.put(Variant.TRAPDOOR, trapdoor);
			return this;
		}

		public Builder wood(RegistrySupplier<Block> wood) {
			family.variants.put(Variant.WOOD, wood);
			return this;
		}

		public Builder notFlammable() {
			family.isFlammable = false;
			return this;
		}
	}
	
	public enum Variant {
		BUTTON("Button"),
		BOAT(null),
		BOAT_ITEM("Boat"),
		CHEST_BOAT(null),
		CHEST_BOAT_ITEM("Boat with Chest"),
		DOOR("Door", true),
		FENCE("Fence"),
		FENCE_GATE("Fence Gate"),
		HANGING_SIGN("Hanging Sign"),
		HANGING_SIGN_ITEM(null),
		LEAVES("Leaves"),
		LOG("Log"),
		SAPLING("Sapling", true),
		SIGN("Sign"),
		SIGN_ITEM(null),
		SLAB("Slab"),
		STAIRS("Stairs"),
		STRIPPED_LOG("Stripped Log"),
		STRIPPED_WOOD("Stripped Wood"),
		PLANKS("Planks"),
		POTTED_SAPLING(null, true),
		PRESSURE_PLATE("Pressure Plate"),
		TRAPDOOR("Trapdoor", true),
		WALL_HANGING_SIGN(null),
		WALL_SIGN(null),
		WOOD("Wood");

		private final String name;
		private final boolean isCutout;

		Variant(String name) {
			this(name, false);
		}

		Variant(String name, boolean isCutout) {
			this.name = name;
			this.isCutout = isCutout;
		}

		public String getName() {
			return name;
		}

		public boolean isCutout() {
			return isCutout;
		}
	}
}
