package net.invictusslayer.slayersbeasts.datagen.tags;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.ModBlocks;
import net.invictusslayer.slayersbeasts.util.ModTags;
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
        this.tag(ModTags.Blocks.CAJOLE_LOGS).add(ModBlocks.CAJOLE_LOG.get()).add(ModBlocks.STRIPPED_CAJOLE_LOG.get()).add(ModBlocks.CAJOLE_WOOD.get()).add(ModBlocks.STRIPPED_CAJOLE_WOOD.get());
        this.tag(ModTags.Blocks.EUCALYPTUS_LOGS).add(ModBlocks.EUCALYPTUS_LOG.get()).add(ModBlocks.STRIPPED_EUCALYPTUS_LOG.get()).add(ModBlocks.EUCALYPTUS_WOOD.get()).add(ModBlocks.STRIPPED_EUCALYPTUS_WOOD.get());
        this.tag(ModTags.Blocks.ASPEN_LOGS).add(ModBlocks.ASPEN_LOG.get()).add(ModBlocks.STRIPPED_ASPEN_LOG.get()).add(ModBlocks.ASPEN_WOOD.get()).add(ModBlocks.STRIPPED_ASPEN_WOOD.get());

        this.tag(BlockTags.SAND).add(ModBlocks.BLACK_SAND.get());
        this.tag(BlockTags.DIRT).add(ModBlocks.ANT_SOIL.get());
        this.tag(BlockTags.LEAVES).add(ModBlocks.CAJOLE_LEAVES.get(), ModBlocks.EUCALYPTUS_LEAVES.get(), ModBlocks.ASPEN_LEAVES.get());
        this.tag(BlockTags.LOGS_THAT_BURN).addTag(ModTags.Blocks.CAJOLE_LOGS).addTag(ModTags.Blocks.EUCALYPTUS_LOGS).addTag(ModTags.Blocks.ASPEN_LOGS);
        this.tag(BlockTags.PLANKS).add(ModBlocks.CAJOLE_PLANKS.get(), ModBlocks.EUCALYPTUS_PLANKS.get(), ModBlocks.ASPEN_PLANKS.get());
        this.tag(BlockTags.WOODEN_SLABS).add(ModBlocks.CAJOLE_SLAB.get(), ModBlocks.EUCALYPTUS_SLAB.get(), ModBlocks.ASPEN_SLAB.get());
        this.tag(BlockTags.WOODEN_STAIRS).add(ModBlocks.CAJOLE_STAIRS.get(), ModBlocks.EUCALYPTUS_STAIRS.get(), ModBlocks.ASPEN_STAIRS.get());
        this.tag(BlockTags.WOODEN_FENCES).add(ModBlocks.CAJOLE_FENCE.get(), ModBlocks.EUCALYPTUS_FENCE.get(), ModBlocks.ASPEN_FENCE.get());
        this.tag(BlockTags.WOODEN_BUTTONS).add(ModBlocks.CAJOLE_BUTTON.get(), ModBlocks.EUCALYPTUS_BUTTON.get(), ModBlocks.ASPEN_BUTTON.get());
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.CAJOLE_PRESSURE_PLATE.get(), ModBlocks.EUCALYPTUS_PRESSURE_PLATE.get(), ModBlocks.ASPEN_PRESSURE_PLATE.get());
        this.tag(BlockTags.WOODEN_DOORS).add(ModBlocks.CAJOLE_DOOR.get(), ModBlocks.EUCALYPTUS_DOOR.get(), ModBlocks.ASPEN_DOOR.get());
        this.tag(BlockTags.WOODEN_TRAPDOORS).add(ModBlocks.CAJOLE_TRAPDOOR.get(), ModBlocks.EUCALYPTUS_TRAPDOOR.get(), ModBlocks.ASPEN_TRAPDOOR.get());
        this.tag(BlockTags.FENCE_GATES).add(ModBlocks.CAJOLE_FENCE_GATE.get(), ModBlocks.EUCALYPTUS_FENCE_GATE.get(), ModBlocks.ASPEN_FENCE_GATE.get());
        this.tag(BlockTags.WALLS).add(ModBlocks.BLACK_SANDSTONE_WALL.get());
        this.tag(BlockTags.SAPLINGS).add(ModBlocks.CAJOLE_SAPLING.get(), ModBlocks.EUCALYPTUS_SAPLING.get(), ModBlocks.ASPEN_SAPLING.get());
        this.tag(BlockTags.MUSHROOM_GROW_BLOCK).add(ModBlocks.ANT_SOIL.get());
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(ModBlocks.WHITE_MUSHROOM_BLOCK.get(), ModBlocks.WHITE_MUSHROOM.get());
        this.tag(BlockTags.MINEABLE_WITH_HOE).add(ModBlocks.CAJOLE_LEAVES.get(), ModBlocks.EUCALYPTUS_LEAVES.get(), ModBlocks.ASPEN_LEAVES.get(), ModBlocks.OOTHECA.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.JADE_BLOCK.get(), ModBlocks.EXOSKELETON_ORE.get(), ModBlocks.DEEPSLATE_EXOSKELETON_ORE.get(), ModBlocks.BLACK_SANDSTONE.get(), ModBlocks.BLACK_SANDSTONE_SLAB.get(), ModBlocks.BLACK_SANDSTONE_STAIRS.get(), ModBlocks.BLACK_SANDSTONE_WALL.get(), ModBlocks.SMOOTH_BLACK_SANDSTONE.get(), ModBlocks.SMOOTH_BLACK_SANDSTONE_SLAB.get(), ModBlocks.SMOOTH_BLACK_SANDSTONE_STAIRS.get(), ModBlocks.CUT_BLACK_SANDSTONE.get(), ModBlocks.CUT_BLACK_SANDSTONE_SLAB.get(), ModBlocks.CHISELED_BLACK_SANDSTONE.get());
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL).add(ModBlocks.BLACK_SAND.get(), ModBlocks.ANT_SOIL.get()).addTag(ModTags.Blocks.ANTHILLS);
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.EXOSKELETON_ORE.get(), ModBlocks.DEEPSLATE_EXOSKELETON_ORE.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.JADE_BLOCK.get());
    }
}
