package net.invictusslayer.slayersbeasts.datagen;

import net.invictusslayer.slayersbeasts.block.SBBlocks;
import net.invictusslayer.slayersbeasts.item.SBItems;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class SBBlockLootTables extends BlockLootSubProvider {
    public SBBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        generateBlockFamilies();

        dropSelf(SBBlocks.JADE_BLOCK.get());

        add(SBBlocks.EXOSKELETON_ORE.get(), block -> createExoskeletonOreDrops(SBBlocks.EXOSKELETON_ORE.get()));
        add(SBBlocks.DEEPSLATE_EXOSKELETON_ORE.get(), block -> createExoskeletonOreDrops(SBBlocks.DEEPSLATE_EXOSKELETON_ORE.get()));

        dropSelf(SBBlocks.ANT_SOIL.get());
        dropOther(SBBlocks.ANTHILL.get(), SBBlocks.ANT_SOIL.get());
        dropOther(SBBlocks.ANTHILL_HATCHERY.get(), SBBlocks.ANT_SOIL.get());

        dropWhenSilkTouch(SBBlocks.ICICLE.get());
        add(SBBlocks.CRACKED_MUD.get(), block ->
                createSingleItemTableWithSilkTouch(Blocks.PACKED_MUD, SBItems.MUD_BALL.get(), ConstantValue.exactly(4)));
        dropSelf(SBBlocks.PEAT.get());
        dropSelf(SBBlocks.BLACK_SAND.get());

        dropSelf(SBBlocks.WHITE_MUSHROOM.get());
        add(SBBlocks.WHITE_MUSHROOM_BLOCK.get(), block ->
                createMushroomBlockDrop(SBBlocks.WHITE_MUSHROOM_BLOCK.get(), SBBlocks.WHITE_MUSHROOM.get()));

        dropSelf(SBBlocks.ASPEN_LOG.get());
        dropSelf(SBBlocks.STRIPPED_ASPEN_LOG.get());
        dropSelf(SBBlocks.ASPEN_WOOD.get());
        dropSelf(SBBlocks.STRIPPED_ASPEN_WOOD.get());
        add(SBBlocks.ASPEN_LEAVES.get(), block ->
                createLeavesDrops(SBBlocks.ASPEN_LEAVES.get(), SBBlocks.ASPEN_SAPLING.get(), 0.05f));
        dropSelf(SBBlocks.ASPEN_SAPLING.get());
        
        dropSelf(SBBlocks.CAJOLE_LOG.get());
        dropSelf(SBBlocks.STRIPPED_CAJOLE_LOG.get());
        dropSelf(SBBlocks.CAJOLE_WOOD.get());
        dropSelf(SBBlocks.STRIPPED_CAJOLE_WOOD.get());
        add(SBBlocks.CAJOLE_LEAVES.get(), block ->
                createLeavesDrops(SBBlocks.CAJOLE_LEAVES.get(), SBBlocks.CAJOLE_SAPLING.get(), 0.025f));
        dropSelf(SBBlocks.CAJOLE_SAPLING.get());

        dropSelf(SBBlocks.DESERT_OAK_LOG.get());
        dropSelf(SBBlocks.STRIPPED_DESERT_OAK_LOG.get());
        dropSelf(SBBlocks.DESERT_OAK_WOOD.get());
        dropSelf(SBBlocks.STRIPPED_DESERT_OAK_WOOD.get());
        add(SBBlocks.DESERT_OAK_LEAVES.get(), (block) -> createLeavesDrops(
                SBBlocks.DESERT_OAK_LEAVES.get(), SBBlocks.DESERT_OAK_SAPLING.get(), 0.05f));
        dropSelf(SBBlocks.DESERT_OAK_SAPLING.get());
        
        dropSelf(SBBlocks.EUCALYPTUS_LOG.get());
        dropSelf(SBBlocks.STRIPPED_EUCALYPTUS_LOG.get());
        dropSelf(SBBlocks.EUCALYPTUS_WOOD.get());
        dropSelf(SBBlocks.STRIPPED_EUCALYPTUS_WOOD.get());
        add(SBBlocks.EUCALYPTUS_LEAVES.get(), (block) -> createLeavesDrops(
                SBBlocks.EUCALYPTUS_LEAVES.get(), SBBlocks.EUCALYPTUS_SAPLING.get(), 0.05f));
        dropSelf(SBBlocks.EUCALYPTUS_SAPLING.get());

        dropSelf(SBBlocks.KAPOK_LOG.get());
        dropSelf(SBBlocks.STRIPPED_KAPOK_LOG.get());
        dropSelf(SBBlocks.KAPOK_WOOD.get());
        dropSelf(SBBlocks.STRIPPED_KAPOK_WOOD.get());
        add(SBBlocks.KAPOK_LEAVES.get(), (block) -> createLeavesDrops(
                SBBlocks.KAPOK_LEAVES.get(), SBBlocks.KAPOK_SAPLING.get(), 0.05f));
        dropSelf(SBBlocks.KAPOK_SAPLING.get());
        
        dropSelf(SBBlocks.REDWOOD_LOG.get());
        dropSelf(SBBlocks.STRIPPED_REDWOOD_LOG.get());
        dropSelf(SBBlocks.REDWOOD_WOOD.get());
        dropSelf(SBBlocks.STRIPPED_REDWOOD_WOOD.get());
        add(SBBlocks.REDWOOD_LEAVES.get(), (block) -> createLeavesDrops(
                SBBlocks.REDWOOD_LEAVES.get(), SBBlocks.REDWOOD_SAPLING.get(), 0.05f));
        dropSelf(SBBlocks.REDWOOD_SAPLING.get());

        dropSelf(SBBlocks.WILLOW_LOG.get());
        dropSelf(SBBlocks.STRIPPED_WILLOW_LOG.get());
        dropSelf(SBBlocks.WILLOW_WOOD.get());
        dropSelf(SBBlocks.STRIPPED_WILLOW_WOOD.get());
        add(SBBlocks.WILLOW_LEAVES.get(), (block) -> createLeavesDrops(
                SBBlocks.WILLOW_LEAVES.get(), SBBlocks.WILLOW_SAPLING.get(), 0.05f));
        dropSelf(SBBlocks.WILLOW_SAPLING.get());
        add(SBBlocks.WILLOW_BRANCH.get(), (block) -> createLeavesDrops(
                SBBlocks.WILLOW_LEAVES.get(), SBBlocks.WILLOW_SAPLING.get(), 0.05f));
        add(SBBlocks.WILLOW_BRANCH_PLANT.get(), (block) -> createLeavesDrops(
                SBBlocks.WILLOW_LEAVES.get(), SBBlocks.WILLOW_SAPLING.get(), 0.05f));
    }

    private void generateBlockFamilies() {
        SBBlockFamilies.getAllFamilies().forEach(family -> {
            dropSelf(family.getBaseBlock());
            family.getVariants().forEach(((variant, block) -> {
                if (variant.equals(BlockFamily.Variant.SLAB)) {
                    add(block, this::createSlabItemTable);
                } else if (variant.equals(BlockFamily.Variant.DOOR)) {
                    add(block, this::createDoorTable);
                } else {
                    dropSelf(block);
                }
            }));
        });
    }

    protected LootTable.Builder createExoskeletonOreDrops(Block block) {
        return createSilkTouchDispatchTable(block, this.applyExplosionDecay(block,
                LootItem.lootTableItem(SBItems.CRYSTALLINE_CLAW.get())
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return SBBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
