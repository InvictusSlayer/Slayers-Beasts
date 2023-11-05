package net.invictusslayer.slayersbeasts.block;

import net.minecraft.data.BlockFamily;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class SBBlockFamily {
	private static final Map<Block, BlockFamily> FAMILIES = new HashMap<>();
	public static final BlockFamily ASPEN = builder(SBBlocks.ASPEN_PLANKS.get()).button(SBBlocks.ASPEN_BUTTON.get()).fence(SBBlocks.ASPEN_FENCE.get()).fenceGate(SBBlocks.ASPEN_FENCE_GATE.get()).pressurePlate(SBBlocks.ASPEN_PRESSURE_PLATE.get()).slab(SBBlocks.ASPEN_SLAB.get()).stairs(SBBlocks.ASPEN_STAIRS.get()).door(SBBlocks.ASPEN_DOOR.get()).trapdoor(SBBlocks.ASPEN_TRAPDOOR.get()).sign(SBBlocks.ASPEN_SIGN.get(), SBBlocks.ASPEN_WALL_SIGN.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();
	public static final BlockFamily CAJOLE = builder(SBBlocks.CAJOLE_PLANKS.get()).button(SBBlocks.CAJOLE_BUTTON.get()).fence(SBBlocks.CAJOLE_FENCE.get()).fenceGate(SBBlocks.CAJOLE_FENCE_GATE.get()).pressurePlate(SBBlocks.CAJOLE_PRESSURE_PLATE.get()).slab(SBBlocks.CAJOLE_SLAB.get()).stairs(SBBlocks.CAJOLE_STAIRS.get()).door(SBBlocks.CAJOLE_DOOR.get()).trapdoor(SBBlocks.CAJOLE_TRAPDOOR.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();
	public static final BlockFamily DESERT_OAK = builder(SBBlocks.DESERT_OAK_PLANKS.get()).button(SBBlocks.DESERT_OAK_BUTTON.get()).fence(SBBlocks.DESERT_OAK_FENCE.get()).fenceGate(SBBlocks.DESERT_OAK_FENCE_GATE.get()).pressurePlate(SBBlocks.DESERT_OAK_PRESSURE_PLATE.get()).slab(SBBlocks.DESERT_OAK_SLAB.get()).stairs(SBBlocks.DESERT_OAK_STAIRS.get()).door(SBBlocks.DESERT_OAK_DOOR.get()).trapdoor(SBBlocks.DESERT_OAK_TRAPDOOR.get()).sign(SBBlocks.DESERT_OAK_SIGN.get(), SBBlocks.DESERT_OAK_WALL_SIGN.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();
	public static final BlockFamily EUCALYPTUS = builder(SBBlocks.EUCALYPTUS_PLANKS.get()).button(SBBlocks.EUCALYPTUS_BUTTON.get()).fence(SBBlocks.EUCALYPTUS_FENCE.get()).fenceGate(SBBlocks.EUCALYPTUS_FENCE_GATE.get()).pressurePlate(SBBlocks.EUCALYPTUS_PRESSURE_PLATE.get()).slab(SBBlocks.EUCALYPTUS_SLAB.get()).stairs(SBBlocks.EUCALYPTUS_STAIRS.get()).door(SBBlocks.EUCALYPTUS_DOOR.get()).trapdoor(SBBlocks.EUCALYPTUS_TRAPDOOR.get()).sign(SBBlocks.EUCALYPTUS_SIGN.get(), SBBlocks.EUCALYPTUS_WALL_SIGN.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();
	public static final BlockFamily KAPOK = builder(SBBlocks.KAPOK_PLANKS.get()).button(SBBlocks.KAPOK_BUTTON.get()).fence(SBBlocks.KAPOK_FENCE.get()).fenceGate(SBBlocks.KAPOK_FENCE_GATE.get()).pressurePlate(SBBlocks.KAPOK_PRESSURE_PLATE.get()).slab(SBBlocks.KAPOK_SLAB.get()).stairs(SBBlocks.KAPOK_STAIRS.get()).door(SBBlocks.KAPOK_DOOR.get()).trapdoor(SBBlocks.KAPOK_TRAPDOOR.get()).sign(SBBlocks.KAPOK_SIGN.get(), SBBlocks.KAPOK_WALL_SIGN.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();
	public static final BlockFamily REDWOOD = builder(SBBlocks.REDWOOD_PLANKS.get()).button(SBBlocks.REDWOOD_BUTTON.get()).fence(SBBlocks.REDWOOD_FENCE.get()).fenceGate(SBBlocks.REDWOOD_FENCE_GATE.get()).pressurePlate(SBBlocks.REDWOOD_PRESSURE_PLATE.get()).slab(SBBlocks.REDWOOD_SLAB.get()).stairs(SBBlocks.REDWOOD_STAIRS.get()).door(SBBlocks.REDWOOD_DOOR.get()).trapdoor(SBBlocks.REDWOOD_TRAPDOOR.get()).recipeGroupPrefix("wooden").sign(SBBlocks.REDWOOD_SIGN.get(), SBBlocks.REDWOOD_WALL_SIGN.get()).recipeUnlockedBy("has_planks").getFamily();
	public static final BlockFamily WILLOW = builder(SBBlocks.WILLOW_PLANKS.get()).button(SBBlocks.WILLOW_BUTTON.get()).fence(SBBlocks.WILLOW_FENCE.get()).fenceGate(SBBlocks.WILLOW_FENCE_GATE.get()).pressurePlate(SBBlocks.WILLOW_PRESSURE_PLATE.get()).slab(SBBlocks.WILLOW_SLAB.get()).stairs(SBBlocks.WILLOW_STAIRS.get()).door(SBBlocks.WILLOW_DOOR.get()).trapdoor(SBBlocks.WILLOW_TRAPDOOR.get()).sign(SBBlocks.WILLOW_SIGN.get(), SBBlocks.WILLOW_WALL_SIGN.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();
	public static final BlockFamily BLACK_SANDSTONE = builder(SBBlocks.BLACK_SANDSTONE.get()).wall(SBBlocks.BLACK_SANDSTONE_WALL.get()).stairs(SBBlocks.BLACK_SANDSTONE_STAIRS.get()).slab(SBBlocks.BLACK_SANDSTONE_SLAB.get()).chiseled(SBBlocks.CHISELED_BLACK_SANDSTONE.get()).cut(SBBlocks.CUT_BLACK_SANDSTONE.get()).dontGenerateRecipe().dontGenerateModel().getFamily();
	public static final BlockFamily SMOOTH_BLACK_SANDSTONE = builder(SBBlocks.SMOOTH_BLACK_SANDSTONE.get()).slab(SBBlocks.SMOOTH_BLACK_SANDSTONE_SLAB.get()).stairs(SBBlocks.SMOOTH_BLACK_SANDSTONE_STAIRS.get()).dontGenerateModel().getFamily();
	public static final BlockFamily CUT_BLACK_SANDSTONE = builder(SBBlocks.CUT_BLACK_SANDSTONE.get()).slab(SBBlocks.CUT_BLACK_SANDSTONE_SLAB.get()).dontGenerateModel().getFamily();
	public static final BlockFamily PEGMATITE = builder(SBBlocks.PEGMATITE.get()).slab(SBBlocks.PEGMATITE_SLAB.get()).stairs(SBBlocks.PEGMATITE_STAIRS.get()).wall(SBBlocks.PEGMATITE_WALL.get()).polished(SBBlocks.POLISHED_PEGMATITE.get()).getFamily();
	public static final BlockFamily POLISHED_PEGMATITE = builder(SBBlocks.POLISHED_PEGMATITE.get()).slab(SBBlocks.POLISHED_PEGMATITE_SLAB.get()).stairs(SBBlocks.POLISHED_PEGMATITE_STAIRS.get()).getFamily();

	private static BlockFamily.Builder builder(Block block) {
		BlockFamily.Builder builder = new BlockFamily.Builder(block);
		BlockFamily family = FAMILIES.put(block, builder.getFamily());
		if (family != null) {
			throw new IllegalStateException("Duplicate family definition for " + ForgeRegistries.BLOCKS.getKey(block));
		} else {
			return builder;
		}
	}

	public static Stream<BlockFamily> getAllFamilies() {
		return FAMILIES.values().stream();
	}
}