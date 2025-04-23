package net.invictusslayer.slayersbeasts.common.data.loot;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.block.SBBlockFamily;
import net.invictusslayer.slayersbeasts.common.block.WoodFamily;
import net.invictusslayer.slayersbeasts.common.init.SBBlocks;
import net.invictusslayer.slayersbeasts.common.init.SBItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.function.BiConsumer;

public class SBBlockLoot extends BlockLootSubProvider {
	public SBBlockLoot() {
		super(Set.of(), FeatureFlags.REGISTRY.allFlags());
	}

	public void generate() {
		generateBlockFamilies();

		dropSelf(SBBlocks.CRYPTALITH.get());
		dropOther(SBBlocks.INFUSED_CRYPTALITH.get(), SBBlocks.DEPLETED_CRYPTALITH.get());
		dropSelf(SBBlocks.DEPLETED_CRYPTALITH.get());
		dropSelf(SBBlocks.JADE_BLOCK.get());

		add(SBBlocks.EXOSKELETON_ORE.get(), block -> createExoskeletonOreDrops(SBBlocks.EXOSKELETON_ORE.get()));
		add(SBBlocks.DEEPSLATE_EXOSKELETON_ORE.get(), block -> createExoskeletonOreDrops(SBBlocks.DEEPSLATE_EXOSKELETON_ORE.get()));

		add(SBBlocks.STYPHIUM.get(), block -> createSingleItemTableWithSilkTouch(block, Blocks.COBBLESTONE));
		add(SBBlocks.DEEPSLATE_STYPHIUM.get(), block -> createSingleItemTableWithSilkTouch(block, Blocks.COBBLED_DEEPSLATE));

		dropSelf(SBBlocks.RUDOSOL.get());
		dropSelf(SBBlocks.ARIDISOL.get());
		dropOther(SBBlocks.ANTHILL.get(), SBBlocks.ARIDISOL.get());
		dropOther(SBBlocks.ANTHILL_HATCHERY.get(), SBBlocks.ARIDISOL.get());

		dropWhenSilkTouch(SBBlocks.GLEAMING_ICE.get());
		dropWhenSilkTouch(SBBlocks.ICICLE.get());
		dropSelf(SBBlocks.OBSIDIAN_SPIKE.get());
		add(SBBlocks.TALL_DEAD_BUSH.get(), this::createTallDeadBushDrops);
		add(SBBlocks.CRACKED_MUD.get(), block -> createSingleItemTableWithSilkTouch(Blocks.PACKED_MUD, SBItems.MUD_BALL.get(), ConstantValue.exactly(4)));
		dropSelf(SBBlocks.PEAT.get());
		add(SBBlocks.ALGAE.get(), BlockLootSubProvider::createShearsOnlyDrop);

		dropSelf(SBBlocks.BLACK_SAND.get());

		add(SBBlocks.TALL_BROWN_MUSHROOM.get(), block -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
		add(SBBlocks.TALL_RED_MUSHROOM.get(), block -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
		add(SBBlocks.BLACK_MUSHROOM_BLOCK.get(), block -> createMushroomBlockDrop(SBBlocks.BLACK_MUSHROOM_BLOCK.get(), SBBlocks.BLACK_MUSHROOM.get()));
		dropSelf(SBBlocks.BLACK_MUSHROOM.get());
		dropPottedContents(SBBlocks.POTTED_BLACK_MUSHROOM.get());
		add(SBBlocks.TALL_BLACK_MUSHROOM.get(), block -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
		add(SBBlocks.WHITE_MUSHROOM_BLOCK.get(), block -> createMushroomBlockDrop(SBBlocks.WHITE_MUSHROOM_BLOCK.get(), SBBlocks.WHITE_MUSHROOM.get()));
		dropSelf(SBBlocks.WHITE_MUSHROOM.get());
		dropPottedContents(SBBlocks.POTTED_WHITE_MUSHROOM.get());
		add(SBBlocks.TALL_WHITE_MUSHROOM.get(), block -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
//		add(SBBlocks.THIN_MUSHROOM_STEM.get(), BlockLootSubProvider::createSilkTouchOnlyTable);

		generateWoodFamilies();
		add(SBBlocks.ALBINO_REDWOOD_LEAVES.get(), block -> createLeavesDrops(block, SBBlocks.ALBINO_REDWOOD_SAPLING.get(), 0.01F));
		dropSelf(SBBlocks.ALBINO_REDWOOD_SAPLING.get());
		dropPottedContents(SBBlocks.POTTED_ALBINO_REDWOOD_SAPLING.get());
		add(SBBlocks.WILLOW_BRANCH.get(), block -> createLeavesDrops(block, SBBlocks.WILLOW_SAPLING.get(), 0.03F));
		add(SBBlocks.WILLOW_BRANCH_PLANT.get(), block -> createLeavesDrops(block, SBBlocks.WILLOW_SAPLING.get(), 0.03F));
	}

	public void generate(HolderLookup.Provider provider, BiConsumer<ResourceKey<LootTable>, LootTable.Builder> biConsumer) {
		generate();
		HashSet<ResourceKey<LootTable>> set = new HashSet<>();
		for (Block block : BuiltInRegistries.BLOCK) {
			if (!block.getLootTable().location().getNamespace().equals(SlayersBeasts.MOD_ID)) continue;

			ResourceKey<LootTable> key;
			if (!block.isEnabled(enabledFeatures) || (key = block.getLootTable()) == BuiltInLootTables.EMPTY || !set.add(key)) continue;

			LootTable.Builder builder = map.remove(key);
			if (builder == null) throw new IllegalStateException(String.format(Locale.ROOT, "Missing loottable '%s' for '%s'", key, BuiltInRegistries.BLOCK.getKey(block)));

			biConsumer.accept(key, builder);
		}
		if (!map.isEmpty()) throw new IllegalStateException("Created block loot tables for non-blocks: " + map.keySet());
	}

	private void generateWoodFamilies() {
		WoodFamily.getAllFamilies().forEach(family -> family.getVariants().forEach((variant, supplier) -> {
			if (!(supplier.get() instanceof Block block)) return;
			switch (variant) {
				default -> dropSelf(block);
				case DOOR -> add(block, this::createDoorTable);
				case LEAVES -> add(block, createLeavesDrops(block, (Block) family.get(WoodFamily.Variant.SAPLING).get(), 0.05F));
				case POTTED_SAPLING -> dropPottedContents(block);
				case SLAB -> add(block, this::createSlabItemTable);
				case WALL_HANGING_SIGN -> dropOther(block, (Block) family.get(WoodFamily.Variant.HANGING_SIGN).get());
				case WALL_SIGN -> dropOther(block, (Block) family.get(WoodFamily.Variant.SIGN).get());
			}
		}));
	}

	private void generateBlockFamilies() {
		SBBlockFamily.getAllFamilies().forEach(family -> {
			dropSelf(family.getBaseBlock());
			family.getVariants().forEach((variant, block) -> {
				switch (variant) {
					default -> dropSelf(block);
					case SLAB -> add(block, this::createSlabItemTable);
					case DOOR -> add(block, this::createDoorTable);
					case WALL_SIGN -> dropOther(block, family.get(BlockFamily.Variant.SIGN));
				}
			});
		});
	}

	private LootTable.Builder createTallDeadBushDrops(Block block) {
		return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
				.add(LootItem.lootTableItem(block).when(HAS_SHEARS)
						.otherwise(applyExplosionDecay(block, LootItem.lootTableItem(Items.STICK)
								.when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
										.setProperties(StatePropertiesPredicate.Builder.properties()
												.hasProperty(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER)))
								.when(LootItemEntityPropertyCondition.entityPresent(LootContext.EntityTarget.THIS))
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F)))))));
	}

	private LootTable.Builder createExoskeletonOreDrops(Block block) {
		return createSilkTouchDispatchTable(block, applyExplosionDecay(block,
				LootItem.lootTableItem(SBItems.CRYSTALLINE_CLAW.get())
						.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
						.apply(ApplyBonusCount.addOreBonusCount(Enchantments.FORTUNE))));
	}
}
