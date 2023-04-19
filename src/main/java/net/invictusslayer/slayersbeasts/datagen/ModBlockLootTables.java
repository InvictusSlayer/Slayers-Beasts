package net.invictusslayer.slayersbeasts.datagen;

import net.invictusslayer.slayersbeasts.block.ModBlocks;
import net.invictusslayer.slayersbeasts.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.JADE_BLOCK.get());

        add(ModBlocks.EXOSKELETON_ORE.get(), (block -> createExoskeletonOreDrops(ModBlocks.EXOSKELETON_ORE.get())));
        add(ModBlocks.DEEPSLATE_EXOSKELETON_ORE.get(), (block -> createExoskeletonOreDrops(ModBlocks.DEEPSLATE_EXOSKELETON_ORE.get())));

        dropSelf(ModBlocks.ANT_SOIL.get());
        dropOther(ModBlocks.ANTHILL.get(), ModBlocks.ANT_SOIL.get());
        dropOther(ModBlocks.ANTHILL_HATCHERY.get(), ModBlocks.ANT_SOIL.get());

        dropSelf(ModBlocks.BLACK_SAND.get());

        dropSelf(ModBlocks.WHITE_MUSHROOM.get());
        add(ModBlocks.WHITE_MUSHROOM_BLOCK.get(), (block -> createMushroomBlockDrop(
                ModBlocks.WHITE_MUSHROOM_BLOCK.get(), ModBlocks.WHITE_MUSHROOM.get())));

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

    protected LootTable.Builder createExoskeletonOreDrops(Block block) {
        return createSilkTouchDispatchTable(block, this.applyExplosionDecay(block,
                LootItem.lootTableItem(ModItems.CRYSTALLINE_CLAW.get())
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
