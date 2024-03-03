package net.invictusslayer.slayersbeasts.block;

import net.invictusslayer.slayersbeasts.datagen.tag.SBTags;
import net.invictusslayer.slayersbeasts.entity.vehicle.SBBoatType;
import net.invictusslayer.slayersbeasts.item.SBItems;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class WoodFamily {
	private TagKey<Block> logBlocks = null;
	private TagKey<Item> logItems = null;
	private Boat.Type boatType = null;
	private final Map<Variant, RegistryObject<?>> variants = new HashMap<>();
	private boolean isFlammable = true;

	private static final List<WoodFamily> FAMILIES = new ArrayList<>();
	public static final WoodFamily ASPEN = builder().button(SBBlocks.ASPEN_BUTTON).boat(SBItems.ASPEN_BOAT, SBBoatType.ASPEN).chestBoat(SBItems.ASPEN_CHEST_BOAT).door(SBBlocks.ASPEN_DOOR).fence(SBBlocks.ASPEN_FENCE).fenceGate(SBBlocks.ASPEN_FENCE_GATE).hangingSign(SBBlocks.ASPEN_HANGING_SIGN).hangingSignItem(SBItems.ASPEN_HANGING_SIGN).leaves(SBBlocks.ASPEN_LEAVES).log(SBBlocks.ASPEN_LOG, SBTags.Blocks.ASPEN_LOGS, SBTags.Items.ASPEN_LOGS).planks(SBBlocks.ASPEN_PLANKS).pottedSapling(SBBlocks.POTTED_ASPEN_SAPLING).pressurePlate(SBBlocks.ASPEN_PRESSURE_PLATE).sapling(SBBlocks.ASPEN_SAPLING).sign(SBBlocks.ASPEN_SIGN).signItem(SBItems.ASPEN_SIGN).slab(SBBlocks.ASPEN_SLAB).stairs(SBBlocks.ASPEN_STAIRS).strippedLog(SBBlocks.STRIPPED_ASPEN_LOG).strippedWood(SBBlocks.STRIPPED_ASPEN_WOOD).trapdoor(SBBlocks.ASPEN_TRAPDOOR).wallHangingSign(SBBlocks.ASPEN_WALL_HANGING_SIGN).wallSign(SBBlocks.ASPEN_WALL_SIGN).wood(SBBlocks.ASPEN_WOOD).getFamily();
	public static final WoodFamily CAJOLE = builder().button(SBBlocks.CAJOLE_BUTTON).door(SBBlocks.CAJOLE_DOOR).fence(SBBlocks.CAJOLE_FENCE).fenceGate(SBBlocks.CAJOLE_FENCE_GATE).leaves(SBBlocks.CAJOLE_LEAVES).log(SBBlocks.CAJOLE_LOG, SBTags.Blocks.CAJOLE_LOGS, SBTags.Items.CAJOLE_LOGS).planks(SBBlocks.CAJOLE_PLANKS).pressurePlate(SBBlocks.CAJOLE_PRESSURE_PLATE).sapling(SBBlocks.CAJOLE_SAPLING).slab(SBBlocks.CAJOLE_SLAB).stairs(SBBlocks.CAJOLE_STAIRS).strippedLog(SBBlocks.STRIPPED_CAJOLE_LOG).strippedWood(SBBlocks.STRIPPED_CAJOLE_WOOD).trapdoor(SBBlocks.CAJOLE_TRAPDOOR).wood(SBBlocks.CAJOLE_WOOD).notFlammable().getFamily();
	public static final WoodFamily DESERT_OAK = builder().button(SBBlocks.DESERT_OAK_BUTTON).boat(SBItems.DESERT_OAK_BOAT, SBBoatType.DESERT_OAK).chestBoat(SBItems.DESERT_OAK_CHEST_BOAT).door(SBBlocks.DESERT_OAK_DOOR).fence(SBBlocks.DESERT_OAK_FENCE).fenceGate(SBBlocks.DESERT_OAK_FENCE_GATE).hangingSign(SBBlocks.DESERT_OAK_HANGING_SIGN).hangingSignItem(SBItems.DESERT_OAK_HANGING_SIGN).leaves(SBBlocks.DESERT_OAK_LEAVES).log(SBBlocks.DESERT_OAK_LOG, SBTags.Blocks.DESERT_OAK_LOGS, SBTags.Items.DESERT_OAK_LOGS).planks(SBBlocks.DESERT_OAK_PLANKS).pottedSapling(SBBlocks.POTTED_DESERT_OAK_SAPLING).pressurePlate(SBBlocks.DESERT_OAK_PRESSURE_PLATE).sapling(SBBlocks.DESERT_OAK_SAPLING).sign(SBBlocks.DESERT_OAK_SIGN).signItem(SBItems.DESERT_OAK_SIGN).slab(SBBlocks.DESERT_OAK_SLAB).stairs(SBBlocks.DESERT_OAK_STAIRS).strippedLog(SBBlocks.STRIPPED_DESERT_OAK_LOG).strippedWood(SBBlocks.STRIPPED_DESERT_OAK_WOOD).trapdoor(SBBlocks.DESERT_OAK_TRAPDOOR).wallHangingSign(SBBlocks.DESERT_OAK_WALL_HANGING_SIGN).wallSign(SBBlocks.DESERT_OAK_WALL_SIGN).wood(SBBlocks.DESERT_OAK_WOOD).getFamily();
	public static final WoodFamily EUCALYPTUS = builder().button(SBBlocks.EUCALYPTUS_BUTTON).boat(SBItems.EUCALYPTUS_BOAT, SBBoatType.EUCALYPTUS).chestBoat(SBItems.EUCALYPTUS_CHEST_BOAT).door(SBBlocks.EUCALYPTUS_DOOR).fence(SBBlocks.EUCALYPTUS_FENCE).fenceGate(SBBlocks.EUCALYPTUS_FENCE_GATE).hangingSign(SBBlocks.EUCALYPTUS_HANGING_SIGN).hangingSignItem(SBItems.EUCALYPTUS_HANGING_SIGN).leaves(SBBlocks.EUCALYPTUS_LEAVES).log(SBBlocks.EUCALYPTUS_LOG, SBTags.Blocks.EUCALYPTUS_LOGS, SBTags.Items.EUCALYPTUS_LOGS).planks(SBBlocks.EUCALYPTUS_PLANKS).pottedSapling(SBBlocks.POTTED_EUCALYPTUS_SAPLING).pressurePlate(SBBlocks.EUCALYPTUS_PRESSURE_PLATE).sapling(SBBlocks.EUCALYPTUS_SAPLING).sign(SBBlocks.EUCALYPTUS_SIGN).signItem(SBItems.EUCALYPTUS_SIGN).slab(SBBlocks.EUCALYPTUS_SLAB).stairs(SBBlocks.EUCALYPTUS_STAIRS).strippedLog(SBBlocks.STRIPPED_EUCALYPTUS_LOG).strippedWood(SBBlocks.STRIPPED_EUCALYPTUS_WOOD).trapdoor(SBBlocks.EUCALYPTUS_TRAPDOOR).wallHangingSign(SBBlocks.EUCALYPTUS_WALL_HANGING_SIGN).wallSign(SBBlocks.EUCALYPTUS_WALL_SIGN).wood(SBBlocks.EUCALYPTUS_WOOD).getFamily();
	public static final WoodFamily KAPOK = builder().button(SBBlocks.KAPOK_BUTTON).boat(SBItems.KAPOK_BOAT, SBBoatType.KAPOK).chestBoat(SBItems.KAPOK_CHEST_BOAT).door(SBBlocks.KAPOK_DOOR).fence(SBBlocks.KAPOK_FENCE).fenceGate(SBBlocks.KAPOK_FENCE_GATE).hangingSign(SBBlocks.KAPOK_HANGING_SIGN).hangingSignItem(SBItems.KAPOK_HANGING_SIGN).leaves(SBBlocks.KAPOK_LEAVES).log(SBBlocks.KAPOK_LOG, SBTags.Blocks.KAPOK_LOGS, SBTags.Items.KAPOK_LOGS).planks(SBBlocks.KAPOK_PLANKS).pottedSapling(SBBlocks.POTTED_KAPOK_SAPLING).pressurePlate(SBBlocks.KAPOK_PRESSURE_PLATE).sapling(SBBlocks.KAPOK_SAPLING).sign(SBBlocks.KAPOK_SIGN).signItem(SBItems.KAPOK_SIGN).slab(SBBlocks.KAPOK_SLAB).stairs(SBBlocks.KAPOK_STAIRS).strippedLog(SBBlocks.STRIPPED_KAPOK_LOG).strippedWood(SBBlocks.STRIPPED_KAPOK_WOOD).trapdoor(SBBlocks.KAPOK_TRAPDOOR).wallHangingSign(SBBlocks.KAPOK_WALL_HANGING_SIGN).wallSign(SBBlocks.KAPOK_WALL_SIGN).wood(SBBlocks.KAPOK_WOOD).getFamily();
	public static final WoodFamily REDWOOD = builder().button(SBBlocks.REDWOOD_BUTTON).boat(SBItems.REDWOOD_BOAT, SBBoatType.REDWOOD).chestBoat(SBItems.REDWOOD_CHEST_BOAT).door(SBBlocks.REDWOOD_DOOR).fence(SBBlocks.REDWOOD_FENCE).fenceGate(SBBlocks.REDWOOD_FENCE_GATE).hangingSign(SBBlocks.REDWOOD_HANGING_SIGN).hangingSignItem(SBItems.REDWOOD_HANGING_SIGN).leaves(SBBlocks.REDWOOD_LEAVES).log(SBBlocks.REDWOOD_LOG, SBTags.Blocks.REDWOOD_LOGS, SBTags.Items.REDWOOD_LOGS).planks(SBBlocks.REDWOOD_PLANKS).pottedSapling(SBBlocks.POTTED_REDWOOD_SAPLING).pressurePlate(SBBlocks.REDWOOD_PRESSURE_PLATE).sapling(SBBlocks.REDWOOD_SAPLING).sign(SBBlocks.REDWOOD_SIGN).signItem(SBItems.REDWOOD_SIGN).slab(SBBlocks.REDWOOD_SLAB).stairs(SBBlocks.REDWOOD_STAIRS).strippedLog(SBBlocks.STRIPPED_REDWOOD_LOG).strippedWood(SBBlocks.STRIPPED_REDWOOD_WOOD).trapdoor(SBBlocks.REDWOOD_TRAPDOOR).wallHangingSign(SBBlocks.REDWOOD_WALL_HANGING_SIGN).wallSign(SBBlocks.REDWOOD_WALL_SIGN).wood(SBBlocks.REDWOOD_WOOD).getFamily();
	public static final WoodFamily WILLOW = builder().button(SBBlocks.WILLOW_BUTTON).boat(SBItems.WILLOW_BOAT, SBBoatType.WILLOW).chestBoat(SBItems.WILLOW_CHEST_BOAT).door(SBBlocks.WILLOW_DOOR).fence(SBBlocks.WILLOW_FENCE).fenceGate(SBBlocks.WILLOW_FENCE_GATE).hangingSign(SBBlocks.WILLOW_HANGING_SIGN).hangingSignItem(SBItems.WILLOW_HANGING_SIGN).leaves(SBBlocks.WILLOW_LEAVES).log(SBBlocks.WILLOW_LOG, SBTags.Blocks.WILLOW_LOGS, SBTags.Items.WILLOW_LOGS).planks(SBBlocks.WILLOW_PLANKS).pottedSapling(SBBlocks.POTTED_WILLOW_SAPLING).pressurePlate(SBBlocks.WILLOW_PRESSURE_PLATE).sapling(SBBlocks.WILLOW_SAPLING).sign(SBBlocks.WILLOW_SIGN).signItem(SBItems.WILLOW_SIGN).slab(SBBlocks.WILLOW_SLAB).stairs(SBBlocks.WILLOW_STAIRS).strippedLog(SBBlocks.STRIPPED_WILLOW_LOG).strippedWood(SBBlocks.STRIPPED_WILLOW_WOOD).trapdoor(SBBlocks.WILLOW_TRAPDOOR).wallHangingSign(SBBlocks.WILLOW_WALL_HANGING_SIGN).wallSign(SBBlocks.WILLOW_WALL_SIGN).wood(SBBlocks.WILLOW_WOOD).getFamily();

	WoodFamily() {}

	public TagKey<Block> getLogBlocks() {
		return logBlocks;
	}

	public TagKey<Item> getLogItems() {
		return logItems;
	}

	public Boat.Type getBoatType() {
		return boatType;
	}

	public Map<Variant, RegistryObject<?>> getVariants() {
		return variants;
	}
	
	public RegistryObject<?> get(Variant variant) {
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

		public Builder button(RegistryObject<Block> button) {
			family.variants.put(Variant.BUTTON, button);
			return this;
		}
		
		public Builder boat(RegistryObject<Item> boat, Boat.Type type) {
			family.variants.put(Variant.BOAT, boat);
			family.boatType = type;
			return this;
		}

		public Builder chestBoat(RegistryObject<Item> boat) {
			family.variants.put(Variant.CHEST_BOAT, boat);
			return this;
		}

		public Builder door(RegistryObject<Block> door) {
			family.variants.put(Variant.DOOR, door);
			return this;
		}

		public Builder fence(RegistryObject<Block> fence) {
			family.variants.put(Variant.FENCE, fence);
			return this;
		}

		public Builder fenceGate(RegistryObject<Block> fenceGate) {
			family.variants.put(Variant.FENCE_GATE, fenceGate);
			return this;
		}

		public Builder hangingSign(RegistryObject<Block> hangingSign) {
			family.variants.put(Variant.HANGING_SIGN, hangingSign);
			return this;
		}

		public Builder hangingSignItem(RegistryObject<Item> hangingSign) {
			family.variants.put(Variant.HANGING_SIGN_ITEM, hangingSign);
			return this;
		}

		public Builder leaves(RegistryObject<Block> leaves) {
			family.variants.put(Variant.LEAVES, leaves);
			return this;
		}

		public Builder log(RegistryObject<Block> log, TagKey<Block> blockTag, TagKey<Item> itemTag) {
			family.variants.put(Variant.LOG, log);
			family.logBlocks = blockTag;
			family.logItems = itemTag;
			return this;
		}

		public Builder sapling(RegistryObject<Block> sapling) {
			family.variants.put(Variant.SAPLING, sapling);
			return this;
		}

		public Builder sign(RegistryObject<Block> sign) {
			family.variants.put(Variant.SIGN, sign);
			return this;
		}

		public Builder signItem(RegistryObject<Item> sign) {
			family.variants.put(Variant.SIGN_ITEM, sign);
			return this;
		}

		public Builder slab(RegistryObject<Block> slab) {
			family.variants.put(Variant.SLAB, slab);
			return this;
		}

		public Builder stairs(RegistryObject<Block> stairs) {
			family.variants.put(Variant.STAIRS, stairs);
			return this;
		}

		public Builder strippedLog(RegistryObject<Block> strippedLog) {
			family.variants.put(Variant.STRIPPED_LOG, strippedLog);
			return this;
		}

		public Builder strippedWood(RegistryObject<Block> strippedWood) {
			family.variants.put(Variant.STRIPPED_WOOD, strippedWood);
			return this;
		}

		public Builder planks(RegistryObject<Block> planks) {
			family.variants.put(Variant.PLANKS, planks);
			return this;
		}

		public Builder pottedSapling(RegistryObject<Block> pottedSapling) {
			family.variants.put(Variant.POTTED_SAPLING, pottedSapling);
			return this;
		}

		public Builder pressurePlate(RegistryObject<Block> pressurePlate) {
			family.variants.put(Variant.PRESSURE_PLATE, pressurePlate);
			return this;
		}

		public Builder trapdoor(RegistryObject<Block> trapdoor) {
			family.variants.put(Variant.TRAPDOOR, trapdoor);
			return this;
		}

		public Builder wallHangingSign(RegistryObject<Block> wallHangingSign) {
			family.variants.put(Variant.WALL_HANGING_SIGN, wallHangingSign);
			return this;
		}

		public Builder wallSign(RegistryObject<Block> wallSign) {
			family.variants.put(Variant.WALL_SIGN, wallSign);
			return this;
		}

		public Builder wood(RegistryObject<Block> wood) {
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
		BOAT("Boat"),
		CHEST_BOAT("Boat with Chest"),
		DOOR("Door"),
		FENCE("Fence"),
		FENCE_GATE("Fence Gate"),
		HANGING_SIGN("Hanging Sign"),
		HANGING_SIGN_ITEM(null),
		LEAVES("Leaves"),
		LOG("Log"),
		SAPLING("Sapling"),
		SIGN("Sign"),
		SIGN_ITEM(null),
		SLAB("Slab"),
		STAIRS("Stairs"),
		STRIPPED_LOG("Stripped Log"),
		STRIPPED_WOOD("Stripped Wood"),
		PLANKS("Planks"),
		POTTED_SAPLING(null),
		PRESSURE_PLATE("Pressure Plate"),
		TRAPDOOR("Trapdoor"),
		WALL_HANGING_SIGN(null),
		WALL_SIGN(null),
		WOOD("Wood");

		private final String name;
		
		Variant(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}
}
