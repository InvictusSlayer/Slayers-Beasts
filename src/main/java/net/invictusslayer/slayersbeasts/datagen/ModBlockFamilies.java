package net.invictusslayer.slayersbeasts.datagen;

import net.invictusslayer.slayersbeasts.block.ModBlocks;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ModBlockFamilies {
    private static final Map<Block, BlockFamily> MAP = new HashMap<>();
    public static final BlockFamily ASPEN_PLANKS = familyBuilder(ModBlocks.ASPEN_PLANKS.get()).button(ModBlocks.ASPEN_BUTTON.get()).fence(ModBlocks.ASPEN_FENCE.get()).fenceGate(ModBlocks.ASPEN_FENCE_GATE.get()).pressurePlate(ModBlocks.ASPEN_PRESSURE_PLATE.get()).slab(ModBlocks.ASPEN_SLAB.get()).stairs(ModBlocks.ASPEN_STAIRS.get()).door(ModBlocks.ASPEN_DOOR.get()).trapdoor(ModBlocks.ASPEN_TRAPDOOR.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();
    public static final BlockFamily CAJOLE_PLANKS = familyBuilder(ModBlocks.CAJOLE_PLANKS.get()).button(ModBlocks.CAJOLE_BUTTON.get()).fence(ModBlocks.CAJOLE_FENCE.get()).fenceGate(ModBlocks.CAJOLE_FENCE_GATE.get()).pressurePlate(ModBlocks.CAJOLE_PRESSURE_PLATE.get()).slab(ModBlocks.CAJOLE_SLAB.get()).stairs(ModBlocks.CAJOLE_STAIRS.get()).door(ModBlocks.CAJOLE_DOOR.get()).trapdoor(ModBlocks.CAJOLE_TRAPDOOR.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();
    public static final BlockFamily DESERT_OAK_PLANKS = familyBuilder(ModBlocks.DESERT_OAK_PLANKS.get()).button(ModBlocks.DESERT_OAK_BUTTON.get()).fence(ModBlocks.DESERT_OAK_FENCE.get()).fenceGate(ModBlocks.DESERT_OAK_FENCE_GATE.get()).pressurePlate(ModBlocks.DESERT_OAK_PRESSURE_PLATE.get()).slab(ModBlocks.DESERT_OAK_SLAB.get()).stairs(ModBlocks.DESERT_OAK_STAIRS.get()).door(ModBlocks.DESERT_OAK_DOOR.get()).trapdoor(ModBlocks.DESERT_OAK_TRAPDOOR.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();
    public static final BlockFamily EUCALYPTUS_PLANKS = familyBuilder(ModBlocks.EUCALYPTUS_PLANKS.get()).button(ModBlocks.EUCALYPTUS_BUTTON.get()).fence(ModBlocks.EUCALYPTUS_FENCE.get()).fenceGate(ModBlocks.EUCALYPTUS_FENCE_GATE.get()).pressurePlate(ModBlocks.EUCALYPTUS_PRESSURE_PLATE.get()).slab(ModBlocks.EUCALYPTUS_SLAB.get()).stairs(ModBlocks.EUCALYPTUS_STAIRS.get()).door(ModBlocks.EUCALYPTUS_DOOR.get()).trapdoor(ModBlocks.EUCALYPTUS_TRAPDOOR.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();
    public static final BlockFamily KAPOK_PLANKS = familyBuilder(ModBlocks.KAPOK_PLANKS.get()).button(ModBlocks.KAPOK_BUTTON.get()).fence(ModBlocks.KAPOK_FENCE.get()).fenceGate(ModBlocks.KAPOK_FENCE_GATE.get()).pressurePlate(ModBlocks.KAPOK_PRESSURE_PLATE.get()).slab(ModBlocks.KAPOK_SLAB.get()).stairs(ModBlocks.KAPOK_STAIRS.get()).door(ModBlocks.KAPOK_DOOR.get()).trapdoor(ModBlocks.KAPOK_TRAPDOOR.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();
    public static final BlockFamily REDWOOD_PLANKS = familyBuilder(ModBlocks.REDWOOD_PLANKS.get()).button(ModBlocks.REDWOOD_BUTTON.get()).fence(ModBlocks.REDWOOD_FENCE.get()).fenceGate(ModBlocks.REDWOOD_FENCE_GATE.get()).pressurePlate(ModBlocks.REDWOOD_PRESSURE_PLATE.get()).slab(ModBlocks.REDWOOD_SLAB.get()).stairs(ModBlocks.REDWOOD_STAIRS.get()).door(ModBlocks.REDWOOD_DOOR.get()).trapdoor(ModBlocks.REDWOOD_TRAPDOOR.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();
    public static final BlockFamily WILLOW_PLANKS = familyBuilder(ModBlocks.WILLOW_PLANKS.get()).button(ModBlocks.WILLOW_BUTTON.get()).fence(ModBlocks.WILLOW_FENCE.get()).fenceGate(ModBlocks.WILLOW_FENCE_GATE.get()).pressurePlate(ModBlocks.WILLOW_PRESSURE_PLATE.get()).slab(ModBlocks.WILLOW_SLAB.get()).stairs(ModBlocks.WILLOW_STAIRS.get()).door(ModBlocks.WILLOW_DOOR.get()).trapdoor(ModBlocks.WILLOW_TRAPDOOR.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();
    public static final BlockFamily BLACK_SANDSTONE = familyBuilder(ModBlocks.BLACK_SANDSTONE.get()).wall(ModBlocks.BLACK_SANDSTONE_WALL.get()).stairs(ModBlocks.BLACK_SANDSTONE_STAIRS.get()).slab(ModBlocks.BLACK_SANDSTONE_SLAB.get()).chiseled(ModBlocks.CHISELED_BLACK_SANDSTONE.get()).cut(ModBlocks.CUT_BLACK_SANDSTONE.get()).dontGenerateRecipe().dontGenerateModel().getFamily();
    public static final BlockFamily SMOOTH_BLACK_SANDSTONE = familyBuilder(ModBlocks.SMOOTH_BLACK_SANDSTONE.get()).slab(ModBlocks.SMOOTH_BLACK_SANDSTONE_SLAB.get()).stairs(ModBlocks.SMOOTH_BLACK_SANDSTONE_STAIRS.get()).dontGenerateModel().getFamily();
    public static final BlockFamily CUT_BLACK_SANDSTONE = familyBuilder(ModBlocks.CUT_BLACK_SANDSTONE.get()).slab(ModBlocks.CUT_BLACK_SANDSTONE_SLAB.get()).dontGenerateModel().getFamily();
    
    private static BlockFamily.Builder familyBuilder(Block pBaseBlock) {
        BlockFamily.Builder builder = new BlockFamily.Builder(pBaseBlock);
        BlockFamily blockfamily = MAP.put(pBaseBlock, builder.getFamily());
        if (blockfamily != null) {
            throw new IllegalStateException("Duplicate family definition for " + ForgeRegistries.BLOCKS.getKey(pBaseBlock));
        } else {
            return builder;
        }
    }

    public static Stream<BlockFamily> getAllFamilies() {
        return MAP.values().stream();
    }
}
