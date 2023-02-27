package net.invictusslayer.slayersbeasts.datagen;

import net.invictusslayer.slayersbeasts.init.ModBlocks;
import net.invictusslayer.slayersbeasts.init.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.JADE_BLOCK.get());

        add(ModBlocks.EXOSKELETON_ORE.get(), (block) -> createOreDrop(
                ModBlocks.EXOSKELETON_ORE.get(), ModItems.CRYSTALLINE_CLAW.get()));
        add(ModBlocks.DEEPSLATE_EXOSKELETON_ORE.get(), (block) -> createOreDrop(
                ModBlocks.DEEPSLATE_EXOSKELETON_ORE.get(), ModItems.CRYSTALLINE_CLAW.get()));

        dropSelf(ModBlocks.CAJOLE_LOG.get());
        dropSelf(ModBlocks.STRIPPED_CAJOLE_LOG.get());
        dropSelf(ModBlocks.CAJOLE_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_CAJOLE_WOOD.get());
        add(ModBlocks.CAJOLE_LEAVES.get(), (block) -> createLeavesDrops(
                ModBlocks.CAJOLE_LEAVES.get(), ModBlocks.CAJOLE_SAPLING.get(), 0.025f));
        dropSelf(ModBlocks.CAJOLE_SAPLING.get());
        dropSelf(ModBlocks.CAJOLE_PLANKS.get());
        add(ModBlocks.CAJOLE_SLAB.get(), (block) -> createSlabItemTable(ModBlocks.CAJOLE_SLAB.get()));
        dropSelf(ModBlocks.CAJOLE_STAIRS.get());
        dropSelf(ModBlocks.CAJOLE_FENCE.get());
        dropSelf(ModBlocks.CAJOLE_FENCE_GATE.get());
        dropSelf(ModBlocks.CAJOLE_BUTTON.get());
        dropSelf(ModBlocks.CAJOLE_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.CAJOLE_DOOR.get());
        dropSelf(ModBlocks.CAJOLE_TRAPDOOR.get());

        dropSelf(ModBlocks.EUCALYPTUS_LOG.get());
        dropSelf(ModBlocks.STRIPPED_EUCALYPTUS_LOG.get());
        dropSelf(ModBlocks.EUCALYPTUS_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_EUCALYPTUS_WOOD.get());
        add(ModBlocks.EUCALYPTUS_LEAVES.get(), (block) -> createLeavesDrops(
                ModBlocks.EUCALYPTUS_LEAVES.get(), ModBlocks.EUCALYPTUS_SAPLING.get(), 0.05f));
        dropSelf(ModBlocks.EUCALYPTUS_SAPLING.get());
        dropSelf(ModBlocks.EUCALYPTUS_PLANKS.get());
        add(ModBlocks.EUCALYPTUS_SLAB.get(), (block) -> createSlabItemTable(ModBlocks.EUCALYPTUS_SLAB.get()));
        dropSelf(ModBlocks.EUCALYPTUS_STAIRS.get());
        dropSelf(ModBlocks.EUCALYPTUS_FENCE.get());
        dropSelf(ModBlocks.EUCALYPTUS_FENCE_GATE.get());
        dropSelf(ModBlocks.EUCALYPTUS_BUTTON.get());
        dropSelf(ModBlocks.EUCALYPTUS_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.EUCALYPTUS_DOOR.get());
        dropSelf(ModBlocks.EUCALYPTUS_TRAPDOOR.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
