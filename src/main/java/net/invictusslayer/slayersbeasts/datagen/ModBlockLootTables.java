package net.invictusslayer.slayersbeasts.datagen;

import net.invictusslayer.slayersbeasts.block.ModBlocks;
import net.invictusslayer.slayersbeasts.item.ModItems;
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

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        generateForBlockFamilies();

        dropSelf(ModBlocks.JADE_BLOCK.get());

        add(ModBlocks.EXOSKELETON_ORE.get(), block -> createExoskeletonOreDrops(ModBlocks.EXOSKELETON_ORE.get()));
        add(ModBlocks.DEEPSLATE_EXOSKELETON_ORE.get(), block -> createExoskeletonOreDrops(ModBlocks.DEEPSLATE_EXOSKELETON_ORE.get()));

        dropSelf(ModBlocks.ANT_SOIL.get());
        dropOther(ModBlocks.ANTHILL.get(), ModBlocks.ANT_SOIL.get());
        dropOther(ModBlocks.ANTHILL_HATCHERY.get(), ModBlocks.ANT_SOIL.get());

        add(ModBlocks.CRACKED_MUD.get(), block ->
                createSingleItemTableWithSilkTouch(Blocks.PACKED_MUD, ModItems.MUD_BALL.get(), ConstantValue.exactly(4)));
        dropSelf(ModBlocks.PEAT.get());
        dropSelf(ModBlocks.BLACK_SAND.get());

        dropSelf(ModBlocks.WHITE_MUSHROOM.get());
        add(ModBlocks.WHITE_MUSHROOM_BLOCK.get(), block ->
                createMushroomBlockDrop(ModBlocks.WHITE_MUSHROOM_BLOCK.get(), ModBlocks.WHITE_MUSHROOM.get()));

        dropSelf(ModBlocks.ASPEN_LOG.get());
        dropSelf(ModBlocks.STRIPPED_ASPEN_LOG.get());
        dropSelf(ModBlocks.ASPEN_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_ASPEN_WOOD.get());
        add(ModBlocks.ASPEN_LEAVES.get(), block ->
                createLeavesDrops(ModBlocks.ASPEN_LEAVES.get(), ModBlocks.ASPEN_SAPLING.get(), 0.05f));
        dropSelf(ModBlocks.ASPEN_SAPLING.get());
        
        dropSelf(ModBlocks.CAJOLE_LOG.get());
        dropSelf(ModBlocks.STRIPPED_CAJOLE_LOG.get());
        dropSelf(ModBlocks.CAJOLE_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_CAJOLE_WOOD.get());
        add(ModBlocks.CAJOLE_LEAVES.get(), block ->
                createLeavesDrops(ModBlocks.CAJOLE_LEAVES.get(), ModBlocks.CAJOLE_SAPLING.get(), 0.025f));
        dropSelf(ModBlocks.CAJOLE_SAPLING.get());

        dropSelf(ModBlocks.DESERT_OAK_LOG.get());
        dropSelf(ModBlocks.STRIPPED_DESERT_OAK_LOG.get());
        dropSelf(ModBlocks.DESERT_OAK_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_DESERT_OAK_WOOD.get());
        add(ModBlocks.DESERT_OAK_LEAVES.get(), (block) -> createLeavesDrops(
                ModBlocks.DESERT_OAK_LEAVES.get(), ModBlocks.DESERT_OAK_SAPLING.get(), 0.05f));
        dropSelf(ModBlocks.DESERT_OAK_SAPLING.get());
        
        dropSelf(ModBlocks.EUCALYPTUS_LOG.get());
        dropSelf(ModBlocks.STRIPPED_EUCALYPTUS_LOG.get());
        dropSelf(ModBlocks.EUCALYPTUS_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_EUCALYPTUS_WOOD.get());
        add(ModBlocks.EUCALYPTUS_LEAVES.get(), (block) -> createLeavesDrops(
                ModBlocks.EUCALYPTUS_LEAVES.get(), ModBlocks.EUCALYPTUS_SAPLING.get(), 0.05f));
        dropSelf(ModBlocks.EUCALYPTUS_SAPLING.get());

        dropSelf(ModBlocks.KAPOK_LOG.get());
        dropSelf(ModBlocks.STRIPPED_KAPOK_LOG.get());
        dropSelf(ModBlocks.KAPOK_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_KAPOK_WOOD.get());
        add(ModBlocks.KAPOK_LEAVES.get(), (block) -> createLeavesDrops(
                ModBlocks.KAPOK_LEAVES.get(), ModBlocks.KAPOK_SAPLING.get(), 0.05f));
        dropSelf(ModBlocks.KAPOK_SAPLING.get());
        
        dropSelf(ModBlocks.REDWOOD_LOG.get());
        dropSelf(ModBlocks.STRIPPED_REDWOOD_LOG.get());
        dropSelf(ModBlocks.REDWOOD_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_REDWOOD_WOOD.get());
        add(ModBlocks.REDWOOD_LEAVES.get(), (block) -> createLeavesDrops(
                ModBlocks.REDWOOD_LEAVES.get(), ModBlocks.REDWOOD_SAPLING.get(), 0.05f));
        dropSelf(ModBlocks.REDWOOD_SAPLING.get());
    }

    private void generateForBlockFamilies() {
        ModBlockFamilies.getAllFamilies().forEach(family -> {
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
                LootItem.lootTableItem(ModItems.CRYSTALLINE_CLAW.get())
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
