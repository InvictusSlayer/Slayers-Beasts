package net.invictusslayer.slayersbeasts.datagen.tags;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.SBBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class SBBlockTagsProvider extends BlockTagsProvider {
    public SBBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SlayersBeasts.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(SBTags.Blocks.SEPULCHRA_PORTAL_FRAME).add(SBBlocks.JADE_BLOCK.get());
        this.tag(SBTags.Blocks.ANTHILLS).add(SBBlocks.ANTHILL.get()).add(SBBlocks.ANTHILL_HATCHERY.get());
        this.tag(SBTags.Blocks.ANTHILL_REPLACEABLE).addTag(BlockTags.DIRT).addTag(BlockTags.BASE_STONE_OVERWORLD);
        this.tag(SBTags.Blocks.ICICLE_REPLACEABLE).add(Blocks.PACKED_ICE, Blocks.ICE, Blocks.BLUE_ICE).addTag(BlockTags.BASE_STONE_OVERWORLD);
        this.tag(SBTags.Blocks.ASPEN_LOGS).add(SBBlocks.ASPEN_LOG.get()).add(SBBlocks.STRIPPED_ASPEN_LOG.get()).add(SBBlocks.ASPEN_WOOD.get()).add(SBBlocks.STRIPPED_ASPEN_WOOD.get());
        this.tag(SBTags.Blocks.CAJOLE_LOGS).add(SBBlocks.CAJOLE_LOG.get()).add(SBBlocks.STRIPPED_CAJOLE_LOG.get()).add(SBBlocks.CAJOLE_WOOD.get()).add(SBBlocks.STRIPPED_CAJOLE_WOOD.get());
        this.tag(SBTags.Blocks.DESERT_OAK_LOGS).add(SBBlocks.DESERT_OAK_LOG.get()).add(SBBlocks.STRIPPED_DESERT_OAK_LOG.get()).add(SBBlocks.DESERT_OAK_WOOD.get()).add(SBBlocks.STRIPPED_DESERT_OAK_WOOD.get());
        this.tag(SBTags.Blocks.EUCALYPTUS_LOGS).add(SBBlocks.EUCALYPTUS_LOG.get()).add(SBBlocks.STRIPPED_EUCALYPTUS_LOG.get()).add(SBBlocks.EUCALYPTUS_WOOD.get()).add(SBBlocks.STRIPPED_EUCALYPTUS_WOOD.get());
        this.tag(SBTags.Blocks.KAPOK_LOGS).add(SBBlocks.KAPOK_LOG.get()).add(SBBlocks.STRIPPED_KAPOK_LOG.get()).add(SBBlocks.KAPOK_WOOD.get()).add(SBBlocks.STRIPPED_KAPOK_WOOD.get());
        this.tag(SBTags.Blocks.REDWOOD_LOGS).add(SBBlocks.REDWOOD_LOG.get()).add(SBBlocks.STRIPPED_REDWOOD_LOG.get()).add(SBBlocks.REDWOOD_WOOD.get()).add(SBBlocks.STRIPPED_REDWOOD_WOOD.get());
        this.tag(SBTags.Blocks.WILLOW_LOGS).add(SBBlocks.WILLOW_LOG.get()).add(SBBlocks.STRIPPED_WILLOW_LOG.get()).add(SBBlocks.WILLOW_WOOD.get()).add(SBBlocks.STRIPPED_WILLOW_WOOD.get());
        
        this.tag(BlockTags.SAND).add(SBBlocks.BLACK_SAND.get());
        this.tag(BlockTags.DIRT).add(SBBlocks.ANT_SOIL.get());
        this.tag(BlockTags.SAPLINGS).add(SBBlocks.ASPEN_SAPLING.get(), SBBlocks.CAJOLE_SAPLING.get(), SBBlocks.DESERT_OAK_SAPLING.get(), SBBlocks.EUCALYPTUS_SAPLING.get(), SBBlocks.KAPOK_SAPLING.get(), SBBlocks.REDWOOD_SAPLING.get(), SBBlocks.WILLOW_SAPLING.get());
        this.tag(BlockTags.LEAVES).add(SBBlocks.ASPEN_LEAVES.get(), SBBlocks.CAJOLE_LEAVES.get(), SBBlocks.DESERT_OAK_LEAVES.get(), SBBlocks.EUCALYPTUS_LEAVES.get(), SBBlocks.KAPOK_LEAVES.get(), SBBlocks.REDWOOD_LEAVES.get(), SBBlocks.WILLOW_LEAVES.get());
        this.tag(BlockTags.LOGS_THAT_BURN).addTag(SBTags.Blocks.ASPEN_LOGS).addTag(SBTags.Blocks.CAJOLE_LOGS).addTag(SBTags.Blocks.DESERT_OAK_LOGS).addTag(SBTags.Blocks.EUCALYPTUS_LOGS).addTag(SBTags.Blocks.KAPOK_LOGS).addTag(SBTags.Blocks.REDWOOD_LOGS).addTag(SBTags.Blocks.WILLOW_LOGS);
        this.tag(BlockTags.PLANKS).add(SBBlocks.ASPEN_PLANKS.get(), SBBlocks.CAJOLE_PLANKS.get(), SBBlocks.DESERT_OAK_PLANKS.get(), SBBlocks.EUCALYPTUS_PLANKS.get(), SBBlocks.KAPOK_PLANKS.get(), SBBlocks.REDWOOD_PLANKS.get(), SBBlocks.WILLOW_PLANKS.get());
        this.tag(BlockTags.WOODEN_SLABS).add(SBBlocks.DESERT_OAK_SLAB.get(), SBBlocks.CAJOLE_SLAB.get(), SBBlocks.DESERT_OAK_SLAB.get(), SBBlocks.EUCALYPTUS_SLAB.get(), SBBlocks.KAPOK_SLAB.get(), SBBlocks.REDWOOD_SLAB.get(), SBBlocks.WILLOW_SLAB.get());
        this.tag(BlockTags.WOODEN_STAIRS).add(SBBlocks.ASPEN_STAIRS.get(), SBBlocks.CAJOLE_STAIRS.get(), SBBlocks.DESERT_OAK_STAIRS.get(), SBBlocks.EUCALYPTUS_STAIRS.get(), SBBlocks.KAPOK_STAIRS.get(), SBBlocks.REDWOOD_STAIRS.get(), SBBlocks.WILLOW_STAIRS.get());
        this.tag(BlockTags.WOODEN_FENCES).add(SBBlocks.ASPEN_FENCE.get(), SBBlocks.CAJOLE_FENCE.get(), SBBlocks.DESERT_OAK_FENCE.get(), SBBlocks.EUCALYPTUS_FENCE.get(), SBBlocks.KAPOK_FENCE.get(), SBBlocks.REDWOOD_FENCE.get(), SBBlocks.WILLOW_FENCE.get());
        this.tag(BlockTags.WOODEN_BUTTONS).add(SBBlocks.ASPEN_BUTTON.get(), SBBlocks.CAJOLE_BUTTON.get(), SBBlocks.DESERT_OAK_BUTTON.get(), SBBlocks.EUCALYPTUS_BUTTON.get(), SBBlocks.KAPOK_BUTTON.get(), SBBlocks.REDWOOD_BUTTON.get(), SBBlocks.REDWOOD_BUTTON.get());
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(SBBlocks.ASPEN_PRESSURE_PLATE.get(), SBBlocks.CAJOLE_PRESSURE_PLATE.get(), SBBlocks.DESERT_OAK_PRESSURE_PLATE.get(), SBBlocks.EUCALYPTUS_PRESSURE_PLATE.get(), SBBlocks.KAPOK_PRESSURE_PLATE.get(), SBBlocks.REDWOOD_PRESSURE_PLATE.get(), SBBlocks.WILLOW_PRESSURE_PLATE.get());
        this.tag(BlockTags.WOODEN_DOORS).add(SBBlocks.ASPEN_DOOR.get(), SBBlocks.CAJOLE_DOOR.get(), SBBlocks.DESERT_OAK_DOOR.get(), SBBlocks.EUCALYPTUS_DOOR.get(), SBBlocks.KAPOK_DOOR.get(), SBBlocks.REDWOOD_DOOR.get(), SBBlocks.WILLOW_DOOR.get());
        this.tag(BlockTags.WOODEN_TRAPDOORS).add(SBBlocks.ASPEN_TRAPDOOR.get(), SBBlocks.CAJOLE_TRAPDOOR.get(), SBBlocks.DESERT_OAK_TRAPDOOR.get(), SBBlocks.EUCALYPTUS_TRAPDOOR.get(), SBBlocks.KAPOK_TRAPDOOR.get(), SBBlocks.REDWOOD_TRAPDOOR.get(), SBBlocks.WILLOW_TRAPDOOR.get());
        this.tag(BlockTags.FENCE_GATES).add(SBBlocks.ASPEN_FENCE_GATE.get(), SBBlocks.CAJOLE_FENCE_GATE.get(), SBBlocks.DESERT_OAK_FENCE_GATE.get(), SBBlocks.EUCALYPTUS_FENCE_GATE.get(), SBBlocks.KAPOK_FENCE_GATE.get(), SBBlocks.REDWOOD_FENCE_GATE.get(), SBBlocks.WILLOW_FENCE_GATE.get());
        this.tag(BlockTags.SLABS).add(SBBlocks.PEGMATITE_SLAB.get(), SBBlocks.POLISHED_PEGMATITE_SLAB.get(), SBBlocks.BLACK_SANDSTONE_SLAB.get(), SBBlocks.SMOOTH_BLACK_SANDSTONE_SLAB.get(), SBBlocks.CUT_BLACK_SANDSTONE_SLAB.get());
        this.tag(BlockTags.STAIRS).add(SBBlocks.PEGMATITE_STAIRS.get(), SBBlocks.POLISHED_PEGMATITE_STAIRS.get(), SBBlocks.BLACK_SANDSTONE_STAIRS.get(), SBBlocks.SMOOTH_BLACK_SANDSTONE_STAIRS.get());
        this.tag(BlockTags.WALLS).add(SBBlocks.BLACK_SANDSTONE_WALL.get(), SBBlocks.PEGMATITE_WALL.get());
        this.tag(BlockTags.MUSHROOM_GROW_BLOCK).add(SBBlocks.ANT_SOIL.get());
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(SBBlocks.WHITE_MUSHROOM_BLOCK.get(), SBBlocks.WHITE_MUSHROOM.get());
        this.tag(BlockTags.MINEABLE_WITH_HOE).add(SBBlocks.OOTHECA.get()).addTag(BlockTags.LEAVES);
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(SBBlocks.PEGMATITE.get(), SBBlocks.PEGMATITE_SLAB.get(), SBBlocks.PEGMATITE_STAIRS.get(), SBBlocks.PEGMATITE_WALL.get(), SBBlocks.POLISHED_PEGMATITE.get(), SBBlocks.POLISHED_PEGMATITE_SLAB.get(), SBBlocks.POLISHED_PEGMATITE_STAIRS.get(), SBBlocks.CRACKED_MUD.get(), SBBlocks.JADE_BLOCK.get(), SBBlocks.EXOSKELETON_ORE.get(), SBBlocks.DEEPSLATE_EXOSKELETON_ORE.get(), SBBlocks.BLACK_SANDSTONE.get(), SBBlocks.BLACK_SANDSTONE_SLAB.get(), SBBlocks.BLACK_SANDSTONE_STAIRS.get(), SBBlocks.BLACK_SANDSTONE_WALL.get(), SBBlocks.SMOOTH_BLACK_SANDSTONE.get(), SBBlocks.SMOOTH_BLACK_SANDSTONE_SLAB.get(), SBBlocks.SMOOTH_BLACK_SANDSTONE_STAIRS.get(), SBBlocks.CUT_BLACK_SANDSTONE.get(), SBBlocks.CUT_BLACK_SANDSTONE_SLAB.get(), SBBlocks.CHISELED_BLACK_SANDSTONE.get());
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL).add(SBBlocks.BLACK_SAND.get(), SBBlocks.ANT_SOIL.get()).addTag(SBTags.Blocks.ANTHILLS);
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(SBBlocks.EXOSKELETON_ORE.get(), SBBlocks.DEEPSLATE_EXOSKELETON_ORE.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(SBBlocks.JADE_BLOCK.get());
    }
}
