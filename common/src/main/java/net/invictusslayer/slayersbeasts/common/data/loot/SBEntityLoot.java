package net.invictusslayer.slayersbeasts.common.data.loot;

import net.invictusslayer.slayersbeasts.common.init.SBEntities;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class SBEntityLoot extends EntityLootSubProvider {
	private final Set<EntityType<?>> ENTITIES = new HashSet<>();

	public SBEntityLoot() {
		super(FeatureFlags.REGISTRY.allFlags());
	}

	public void generate() {
		add(SBEntities.MANTIS.get(), LootTable.lootTable());
		add(SBEntities.ANT_WORKER.get(), LootTable.lootTable());
		add(SBEntities.ANT_SOLDIER.get(), LootTable.lootTable());
		add(SBEntities.ANT_QUEEN.get(), LootTable.lootTable());
		add(SBEntities.WITHER_SPIDER.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.COAL).apply(SetItemCountFunction.setCount(UniformGenerator.between(-1.0F, 1.0F))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.BONE).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));
		add(SBEntities.TYRACHNID.get(), LootTable.lootTable());
		add(SBEntities.DAMSELFLY.get(), LootTable.lootTable());
		add(SBEntities.ENT_MEDIUM.get(), LootTable.lootTable());
		add(SBEntities.WUDU.get(), LootTable.lootTable());
		add(SBEntities.SPORETRAP.get(), LootTable.lootTable());
	}

	protected void add(EntityType<?> entity, LootTable.Builder builder) {
		super.add(entity, builder);
		ENTITIES.add(entity);
	}

	protected Stream<EntityType<?>> getKnownEntityTypes() {
		return ENTITIES.stream();
	}
}
