package net.invictusslayer.slayersbeasts.common.data.loot;

import net.invictusslayer.slayersbeasts.common.init.SBEntities;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantedCountIncreaseFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public class SBEntityLoot extends EntityLootSubProvider {
	public SBEntityLoot(HolderLookup.Provider registries) {
		super(FeatureFlags.REGISTRY.allFlags(), registries);
	}

	public void generate() {}

	public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> biConsumer) {
		add(SBEntities.MANTIS.get(), LootTable.lootTable());
		add(SBEntities.ANT_WORKER.get(), LootTable.lootTable());
		add(SBEntities.ANT_SOLDIER.get(), LootTable.lootTable());
		add(SBEntities.ANT_QUEEN.get(), LootTable.lootTable());
		add(SBEntities.WITHER_SPIDER.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.COAL).apply(SetItemCountFunction.setCount(UniformGenerator.between(-1.0F, 1.0F))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(registries, UniformGenerator.between(0.0F, 1.0F))))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.BONE).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(registries, UniformGenerator.between(0.0F, 1.0F))))));
		add(SBEntities.TYRACHNID.get(), LootTable.lootTable());
		add(SBEntities.DAMSELFLY.get(), LootTable.lootTable());
		add(SBEntities.ENT_MEDIUM.get(), LootTable.lootTable());
		add(SBEntities.WUDU.get(), LootTable.lootTable());
		add(SBEntities.SPORETRAP.get(), LootTable.lootTable());
	}
}
