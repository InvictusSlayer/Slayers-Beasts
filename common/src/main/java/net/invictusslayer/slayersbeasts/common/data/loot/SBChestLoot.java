package net.invictusslayer.slayersbeasts.common.data.loot;

import net.invictusslayer.slayersbeasts.common.init.SBBlocks;
import net.invictusslayer.slayersbeasts.common.init.SBItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantRandomlyFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemDamageFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public class SBChestLoot implements LootTableSubProvider {
	public void generate(HolderLookup.Provider provider, BiConsumer<ResourceKey<LootTable>, LootTable.Builder> output) {
		output.accept(SBLootTables.CRYPT_COMMON, cryptCommon());
		output.accept(SBLootTables.CRYPT_RARE, cryptRare());
		output.accept(SBLootTables.REDWOOD_LOGS, redwoodLogs());
		output.accept(SBLootTables.REDWOOD_TOOLS, redwoodTools());
	}

	private static LootTable.Builder cryptCommon() {
		return LootTable.lootTable();
	}

	private static LootTable.Builder cryptRare() {
		return LootTable.lootTable();
	}

	private static LootTable.Builder redwoodLogs() {
		return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(UniformGenerator.between(2F, 6F))
				.add(LootItem.lootTableItem(SBBlocks.REDWOOD_LOG.get()).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1F, 16F))))
				.add(LootItem.lootTableItem(SBBlocks.WHITE_MUSHROOM_BLOCK.get()).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1F, 10F))))
				.add(LootItem.lootTableItem(Blocks.MUSHROOM_STEM).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1F, 8F))))
				.add(LootItem.lootTableItem(SBBlocks.REDWOOD_PLANKS.get()).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1F, 24F))))
				.add(LootItem.lootTableItem(Items.STICK).setWeight(3)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1F, 10F)))
				.add(LootItem.lootTableItem(SBBlocks.REDWOOD_SAPLING.get()).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1F, 3F))))
				.add(LootItem.lootTableItem(SBBlocks.ALBINO_REDWOOD_SAPLING.get()).setWeight(1).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1F))))
				.add(LootItem.lootTableItem(SBBlocks.WHITE_MUSHROOM.get()).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1F, 5F))))
				.add(LootItem.lootTableItem(Items.STONE_AXE).setWeight(1))
				.add(LootItem.lootTableItem(Items.IRON_AXE).setWeight(1))
				.add(LootItem.lootTableItem(Items.IRON_AXE).setWeight(1).apply(EnchantRandomlyFunction.randomApplicableEnchantment()))
				.apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.5F, 0.9F)))
		);
	}

	private static LootTable.Builder redwoodTools() {
		return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(UniformGenerator.between(2F, 6F))
				.add(LootItem.lootTableItem(Items.COAL).setWeight(5)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1F, 6F)))
				.add(LootItem.lootTableItem(Items.BOOK).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1F, 3F))))
				.add(LootItem.lootTableItem(Items.STICK).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1F, 8F))))
				.add(LootItem.lootTableItem(Items.STRING).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1F, 8F))))
				.add(LootItem.lootTableItem(SBItems.REDWOOD_BOAT.get()).setWeight(5))
				.add(LootItem.lootTableItem(Items.STONE_AXE).setWeight(1))
				.add(LootItem.lootTableItem(Items.IRON_AXE).setWeight(1))
				.add(LootItem.lootTableItem(Items.IRON_AXE).setWeight(1).apply(EnchantRandomlyFunction.randomApplicableEnchantment()))
				.add(LootItem.lootTableItem(Items.IRON_SHOVEL).setWeight(1).apply(EnchantRandomlyFunction.randomApplicableEnchantment()))
				.add(LootItem.lootTableItem(Items.IRON_HOE).setWeight(1))
				.add(LootItem.lootTableItem(Items.BOW).setWeight(1))
				.add(LootItem.lootTableItem(Items.FISHING_ROD).setWeight(1).apply(EnchantRandomlyFunction.randomApplicableEnchantment()))
				.apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.8F, 1F)))
		);
	}
}
