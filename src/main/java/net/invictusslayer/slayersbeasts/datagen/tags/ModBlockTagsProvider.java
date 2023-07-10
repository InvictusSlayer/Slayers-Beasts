package net.invictusslayer.slayersbeasts.datagen.tags;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SlayersBeasts.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.ANTHILLS).add(ModBlocks.ANTHILL.get()).add(ModBlocks.ANTHILL_HATCHERY.get());
        this.tag(ModTags.Blocks.ANTHILL_REPLACEABLE).addTag(BlockTags.DIRT).addTag(BlockTags.BASE_STONE_OVERWORLD);
        this.tag(ModTags.Blocks.SEPULCHRA_PORTAL_FRAME).add(ModBlocks.JADE_BLOCK.get());
        this.tag(ModTags.Blocks.ASPEN_LOGS).add(ModBlocks.ASPEN_LOG.get()).add(ModBlocks.STRIPPED_ASPEN_LOG.get()).add(ModBlocks.ASPEN_WOOD.get()).add(ModBlocks.STRIPPED_ASPEN_WOOD.get());
        this.tag(ModTags.Blocks.CAJOLE_LOGS).add(ModBlocks.CAJOLE_LOG.get()).add(ModBlocks.STRIPPED_CAJOLE_LOG.get()).add(ModBlocks.CAJOLE_WOOD.get()).add(ModBlocks.STRIPPED_CAJOLE_WOOD.get());
        this.tag(ModTags.Blocks.DESERT_OAK_LOGS).add(ModBlocks.DESERT_OAK_LOG.get()).add(ModBlocks.STRIPPED_DESERT_OAK_LOG.get()).add(ModBlocks.DESERT_OAK_WOOD.get()).add(ModBlocks.STRIPPED_DESERT_OAK_WOOD.get());
        this.tag(ModTags.Blocks.EUCALYPTUS_LOGS).add(ModBlocks.EUCALYPTUS_LOG.get()).add(ModBlocks.STRIPPED_EUCALYPTUS_LOG.get()).add(ModBlocks.EUCALYPTUS_WOOD.get()).add(ModBlocks.STRIPPED_EUCALYPTUS_WOOD.get());
        this.tag(ModTags.Blocks.KAPOK_LOGS).add(ModBlocks.KAPOK_LOG.get()).add(ModBlocks.STRIPPED_KAPOK_LOG.get()).add(ModBlocks.KAPOK_WOOD.get()).add(ModBlocks.STRIPPED_KAPOK_WOOD.get());
        this.tag(ModTags.Blocks.REDWOOD_LOGS).add(ModBlocks.REDWOOD_LOG.get()).add(ModBlocks.STRIPPED_REDWOOD_LOG.get()).add(ModBlocks.REDWOOD_WOOD.get()).add(ModBlocks.STRIPPED_REDWOOD_WOOD.get());

        this.tag(BlockTags.SAND).add(ModBlocks.BLACK_SAND.get());
        this.tag(BlockTags.DIRT).add(ModBlocks.ANT_SOIL.get());
        this.tag(BlockTags.SAPLINGS).add(ModBlocks.ASPEN_SAPLING.get(), ModBlocks.CAJOLE_SAPLING.get(), ModBlocks.DESERT_OAK_SAPLING.get(), ModBlocks.EUCALYPTUS_SAPLING.get(), ModBlocks.KAPOK_SAPLING.get(), ModBlocks.REDWOOD_SAPLING.get());
        this.tag(BlockTags.LEAVES).add(ModBlocks.ASPEN_LEAVES.get(), ModBlocks.CAJOLE_LEAVES.get(), ModBlocks.DESERT_OAK_LEAVES.get(), ModBlocks.EUCALYPTUS_LEAVES.get(), ModBlocks.KAPOK_LEAVES.get(), ModBlocks.REDWOOD_LEAVES.get());
        this.tag(BlockTags.LOGS_THAT_BURN).addTag(ModTags.Blocks.ASPEN_LOGS).addTag(ModTags.Blocks.CAJOLE_LOGS).addTag(ModTags.Blocks.DESERT_OAK_LOGS).addTag(ModTags.Blocks.EUCALYPTUS_LOGS).addTag(ModTags.Blocks.KAPOK_LOGS).addTag(ModTags.Blocks.REDWOOD_LOGS);
        this.tag(BlockTags.PLANKS).add(ModBlocks.ASPEN_PLANKS.get(), ModBlocks.CAJOLE_PLANKS.get(), ModBlocks.DESERT_OAK_PLANKS.get(), ModBlocks.EUCALYPTUS_PLANKS.get(), ModBlocks.KAPOK_PLANKS.get(), ModBlocks.REDWOOD_PLANKS.get());
        this.tag(BlockTags.WOODEN_SLABS).add(ModBlocks.DESERT_OAK_SLAB.get(), ModBlocks.CAJOLE_SLAB.get(), ModBlocks.DESERT_OAK_SLAB.get(), ModBlocks.EUCALYPTUS_SLAB.get(), ModBlocks.KAPOK_SLAB.get(), ModBlocks.REDWOOD_SLAB.get());
        this.tag(BlockTags.WOODEN_STAIRS).add(ModBlocks.ASPEN_STAIRS.get(), ModBlocks.CAJOLE_STAIRS.get(), ModBlocks.DESERT_OAK_STAIRS.get(), ModBlocks.EUCALYPTUS_STAIRS.get(), ModBlocks.KAPOK_STAIRS.get(), ModBlocks.REDWOOD_STAIRS.get());
        this.tag(BlockTags.WOODEN_FENCES).add(ModBlocks.ASPEN_FENCE.get(), ModBlocks.CAJOLE_FENCE.get(), ModBlocks.DESERT_OAK_FENCE.get(), ModBlocks.EUCALYPTUS_FENCE.get(), ModBlocks.KAPOK_FENCE.get(), ModBlocks.REDWOOD_FENCE.get());
        this.tag(BlockTags.WOODEN_BUTTONS).add(ModBlocks.ASPEN_BUTTON.get(), ModBlocks.CAJOLE_BUTTON.get(), ModBlocks.DESERT_OAK_BUTTON.get(), ModBlocks.EUCALYPTUS_BUTTON.get(), ModBlocks.KAPOK_BUTTON.get(), ModBlocks.REDWOOD_BUTTON.get());
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.ASPEN_PRESSURE_PLATE.get(), ModBlocks.CAJOLE_PRESSURE_PLATE.get(), ModBlocks.DESERT_OAK_PRESSURE_PLATE.get(), ModBlocks.EUCALYPTUS_PRESSURE_PLATE.get(), ModBlocks.KAPOK_PRESSURE_PLATE.get(), ModBlocks.REDWOOD_PRESSURE_PLATE.get());
        this.tag(BlockTags.WOODEN_DOORS).add(ModBlocks.ASPEN_DOOR.get(), ModBlocks.CAJOLE_DOOR.get(), ModBlocks.DESERT_OAK_DOOR.get(), ModBlocks.EUCALYPTUS_DOOR.get(), ModBlocks.KAPOK_DOOR.get(), ModBlocks.REDWOOD_DOOR.get());
        this.tag(BlockTags.WOODEN_TRAPDOORS).add(ModBlocks.ASPEN_TRAPDOOR.get(), ModBlocks.CAJOLE_TRAPDOOR.get(), ModBlocks.DESERT_OAK_TRAPDOOR.get(), ModBlocks.EUCALYPTUS_TRAPDOOR.get(), ModBlocks.KAPOK_TRAPDOOR.get(), ModBlocks.REDWOOD_TRAPDOOR.get());
        this.tag(BlockTags.FENCE_GATES).add(ModBlocks.ASPEN_FENCE_GATE.get(), ModBlocks.CAJOLE_FENCE_GATE.get(), ModBlocks.DESERT_OAK_FENCE_GATE.get(), ModBlocks.EUCALYPTUS_FENCE_GATE.get(), ModBlocks.KAPOK_FENCE_GATE.get(), ModBlocks.REDWOOD_FENCE_GATE.get());
        this.tag(BlockTags.WALLS).add(ModBlocks.BLACK_SANDSTONE_WALL.get());
        this.tag(BlockTags.MUSHROOM_GROW_BLOCK).add(ModBlocks.ANT_SOIL.get());
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(ModBlocks.WHITE_MUSHROOM_BLOCK.get(), ModBlocks.WHITE_MUSHROOM.get());
        this.tag(BlockTags.MINEABLE_WITH_HOE).add(ModBlocks.OOTHECA.get()).addTag(BlockTags.LEAVES);
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.CRACKED_MUD.get(), ModBlocks.JADE_BLOCK.get(), ModBlocks.EXOSKELETON_ORE.get(), ModBlocks.DEEPSLATE_EXOSKELETON_ORE.get(), ModBlocks.BLACK_SANDSTONE.get(), ModBlocks.BLACK_SANDSTONE_SLAB.get(), ModBlocks.BLACK_SANDSTONE_STAIRS.get(), ModBlocks.BLACK_SANDSTONE_WALL.get(), ModBlocks.SMOOTH_BLACK_SANDSTONE.get(), ModBlocks.SMOOTH_BLACK_SANDSTONE_SLAB.get(), ModBlocks.SMOOTH_BLACK_SANDSTONE_STAIRS.get(), ModBlocks.CUT_BLACK_SANDSTONE.get(), ModBlocks.CUT_BLACK_SANDSTONE_SLAB.get(), ModBlocks.CHISELED_BLACK_SANDSTONE.get());
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL).add(ModBlocks.BLACK_SAND.get(), ModBlocks.ANT_SOIL.get()).addTag(ModTags.Blocks.ANTHILLS);
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.EXOSKELETON_ORE.get(), ModBlocks.DEEPSLATE_EXOSKELETON_ORE.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.JADE_BLOCK.get());
    }
}
