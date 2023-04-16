package net.invictusslayer.slayersbeasts.datagen;

import net.invictusslayer.slayersbeasts.init.ModBlocks;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ModBlockFamilies {
    private static final Map<Block, BlockFamily> MAP = new HashMap<>();
    public static final BlockFamily CAJOLE_PLANKS = familyBuilder(ModBlocks.CAJOLE_PLANKS.get()).button(ModBlocks.CAJOLE_BUTTON.get()).fence(ModBlocks.CAJOLE_FENCE.get()).fenceGate(ModBlocks.CAJOLE_FENCE_GATE.get()).pressurePlate(ModBlocks.CAJOLE_PRESSURE_PLATE.get()).slab(ModBlocks.CAJOLE_SLAB.get()).stairs(ModBlocks.CAJOLE_STAIRS.get()).door(ModBlocks.CAJOLE_DOOR.get()).trapdoor(ModBlocks.CAJOLE_TRAPDOOR.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();
    public static final BlockFamily EUCALYPTUS_PLANKS = familyBuilder(ModBlocks.EUCALYPTUS_PLANKS.get()).button(ModBlocks.EUCALYPTUS_BUTTON.get()).fence(ModBlocks.EUCALYPTUS_FENCE.get()).fenceGate(ModBlocks.EUCALYPTUS_FENCE_GATE.get()).pressurePlate(ModBlocks.EUCALYPTUS_PRESSURE_PLATE.get()).slab(ModBlocks.EUCALYPTUS_SLAB.get()).stairs(ModBlocks.EUCALYPTUS_STAIRS.get()).door(ModBlocks.EUCALYPTUS_DOOR.get()).trapdoor(ModBlocks.EUCALYPTUS_TRAPDOOR.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();

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
