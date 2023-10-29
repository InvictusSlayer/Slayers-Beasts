package net.invictusslayer.slayersbeasts.datagen.loot;

import net.invictusslayer.slayersbeasts.block.SBBlockFamilies;
import net.invictusslayer.slayersbeasts.block.SBBlocks;
import net.invictusslayer.slayersbeasts.item.SBItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
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
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class SBBlockLoot extends BlockLootSubProvider {
	public SBBlockLoot() {
		super(Set.of(), FeatureFlags.REGISTRY.allFlags());
	}

	protected void generate() {
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

		dropSelf(SBBlocks.BLACK_MUSHROOM.get());
		add(SBBlocks.BLACK_MUSHROOM_BLOCK.get(), block -> createMushroomBlockDrop(SBBlocks.BLACK_MUSHROOM_BLOCK.get(), SBBlocks.BLACK_MUSHROOM.get()));
		dropSelf(SBBlocks.WHITE_MUSHROOM.get());
		add(SBBlocks.WHITE_MUSHROOM_BLOCK.get(), block -> createMushroomBlockDrop(SBBlocks.WHITE_MUSHROOM_BLOCK.get(), SBBlocks.WHITE_MUSHROOM.get()));
		add(SBBlocks.THIN_MUSHROOM_STEM.get(), BlockLootSubProvider::createSilkTouchOnlyTable);

		dropSelf(SBBlocks.ASPEN_LOG.get());
		dropSelf(SBBlocks.STRIPPED_ASPEN_LOG.get());
		dropSelf(SBBlocks.ASPEN_WOOD.get());
		dropSelf(SBBlocks.STRIPPED_ASPEN_WOOD.get());
		add(SBBlocks.ASPEN_LEAVES.get(), block -> createLeavesDrops(SBBlocks.ASPEN_LEAVES.get(), SBBlocks.ASPEN_SAPLING.get(), 0.05f));
		dropSelf(SBBlocks.ASPEN_SAPLING.get());

		dropSelf(SBBlocks.CAJOLE_LOG.get());
		dropSelf(SBBlocks.STRIPPED_CAJOLE_LOG.get());
		dropSelf(SBBlocks.CAJOLE_WOOD.get());
		dropSelf(SBBlocks.STRIPPED_CAJOLE_WOOD.get());
		add(SBBlocks.CAJOLE_LEAVES.get(), block -> createLeavesDrops(SBBlocks.CAJOLE_LEAVES.get(), SBBlocks.CAJOLE_SAPLING.get(), 0.025f));
		dropSelf(SBBlocks.CAJOLE_SAPLING.get());

		dropSelf(SBBlocks.DESERT_OAK_LOG.get());
		dropSelf(SBBlocks.STRIPPED_DESERT_OAK_LOG.get());
		dropSelf(SBBlocks.DESERT_OAK_WOOD.get());
		dropSelf(SBBlocks.STRIPPED_DESERT_OAK_WOOD.get());
		add(SBBlocks.DESERT_OAK_LEAVES.get(), block -> createLeavesDrops(SBBlocks.DESERT_OAK_LEAVES.get(), SBBlocks.DESERT_OAK_SAPLING.get(), 0.05f));
		dropSelf(SBBlocks.DESERT_OAK_SAPLING.get());

		dropSelf(SBBlocks.EUCALYPTUS_LOG.get());
		dropSelf(SBBlocks.STRIPPED_EUCALYPTUS_LOG.get());
		dropSelf(SBBlocks.EUCALYPTUS_WOOD.get());
		dropSelf(SBBlocks.STRIPPED_EUCALYPTUS_WOOD.get());
		add(SBBlocks.EUCALYPTUS_LEAVES.get(), block -> createLeavesDrops(SBBlocks.EUCALYPTUS_LEAVES.get(), SBBlocks.EUCALYPTUS_SAPLING.get(), 0.05f));
		dropSelf(SBBlocks.EUCALYPTUS_SAPLING.get());

		dropSelf(SBBlocks.KAPOK_LOG.get());
		dropSelf(SBBlocks.STRIPPED_KAPOK_LOG.get());
		dropSelf(SBBlocks.KAPOK_WOOD.get());
		dropSelf(SBBlocks.STRIPPED_KAPOK_WOOD.get());
		add(SBBlocks.KAPOK_LEAVES.get(), block -> createLeavesDrops(SBBlocks.KAPOK_LEAVES.get(), SBBlocks.KAPOK_SAPLING.get(), 0.05f));
		dropSelf(SBBlocks.KAPOK_SAPLING.get());

		dropSelf(SBBlocks.REDWOOD_LOG.get());
		dropSelf(SBBlocks.STRIPPED_REDWOOD_LOG.get());
		dropSelf(SBBlocks.REDWOOD_WOOD.get());
		dropSelf(SBBlocks.STRIPPED_REDWOOD_WOOD.get());
		add(SBBlocks.REDWOOD_LEAVES.get(), block -> createLeavesDrops(SBBlocks.REDWOOD_LEAVES.get(), SBBlocks.REDWOOD_SAPLING.get(), 0.05f));
		dropSelf(SBBlocks.REDWOOD_SAPLING.get());

		dropSelf(SBBlocks.WILLOW_LOG.get());
		dropSelf(SBBlocks.STRIPPED_WILLOW_LOG.get());
		dropSelf(SBBlocks.WILLOW_WOOD.get());
		dropSelf(SBBlocks.STRIPPED_WILLOW_WOOD.get());
		add(SBBlocks.WILLOW_LEAVES.get(), block -> createLeavesDrops(SBBlocks.WILLOW_LEAVES.get(), SBBlocks.WILLOW_SAPLING.get(), 0.05f));
		dropSelf(SBBlocks.WILLOW_SAPLING.get());
		add(SBBlocks.WILLOW_BRANCH.get(), block -> createLeavesDrops(SBBlocks.WILLOW_LEAVES.get(), SBBlocks.WILLOW_SAPLING.get(), 0.05f));
		add(SBBlocks.WILLOW_BRANCH_PLANT.get(), block -> createLeavesDrops(SBBlocks.WILLOW_LEAVES.get(), SBBlocks.WILLOW_SAPLING.get(), 0.05f));
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

	private LootTable.Builder createTallDeadBushDrops(Block block) {
		return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
				.add(LootItem.lootTableItem(block).when(HAS_SHEARS)
						.otherwise(applyExplosionDecay(block, LootItem.lootTableItem(Items.STICK)
								.when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
										.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER))
										.and(LootItemEntityPropertyCondition.entityPresent(LootContext.EntityTarget.THIS)))
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F)))))));
	}

	private LootTable.Builder createExoskeletonOreDrops(Block block) {
		return createSilkTouchDispatchTable(block, applyExplosionDecay(block,
				LootItem.lootTableItem(SBItems.CRYSTALLINE_CLAW.get())
						.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
						.apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
	}

	protected Iterable<Block> getKnownBlocks() {
		return SBBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
	}
}
