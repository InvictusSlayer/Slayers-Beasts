package net.invictusslayer.slayersbeasts.common.data.loot;

import net.invictusslayer.slayersbeasts.common.init.SBEntities;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantedCountIncreaseFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class SBEntityLoot extends EntityLootSubProvider {
	private final Map<EntityType<?>, Map<ResourceKey<LootTable>, LootTable.Builder>> map = new HashMap<>();

	public SBEntityLoot(HolderLookup.Provider registries) {
		super(FeatureFlags.REGISTRY.allFlags(), registries);
	}

	public void generate() {
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

	public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> biConsumer) {
		generate();
		Set<ResourceKey<LootTable>> set = new HashSet<>();
		SBEntities.ENTITIES.forEach(reference -> {
			EntityType<?> entityType = reference.get();
//			if (canHaveLootTable(entityType)) {
//				Map<ResourceKey<LootTable>, LootTable.Builder> map = this.map.remove(entityType);
//				ResourceKey<LootTable> resourceKey = entityType.getDefaultLootTable().get();
//				if (resourceKey != BuiltInLootTables.EMPTY && (map == null || !map.containsKey(resourceKey)))
//					throw new IllegalStateException(String.format(Locale.ROOT, "Missing loottable '%s' for '%s'", resourceKey, reference.getKey().location()));

//				if (map != null) {
//					map.forEach((resourceKeyx, builder) -> {
//						if (!set.add(resourceKeyx)) {
//							throw new IllegalStateException(String.format(Locale.ROOT, "Duplicate loottable '%s' for '%s'", resourceKeyx, reference.getKey().location()));
//						} else {
//							biConsumer.accept(resourceKeyx, builder);
//						}
//					});
//				}
//			} else {
//				Map<ResourceKey<LootTable>, LootTable.Builder> mapx = this.map.remove(entityType);
//				if (mapx != null) {
//					throw new IllegalStateException(String.format(Locale.ROOT, "Weird loottables '%s' for '%s', not a LivingEntity so should not have loot",
//							mapx.keySet().stream().map(resourceKeyx -> resourceKeyx.location().toString()).collect(Collectors.joining(",")), reference.key().location())
//					);
//				}
//			}
		});
//		if (!map.isEmpty())
//			throw new IllegalStateException("Created loot tables for entities not supported by datapack: " + this.map.keySet());
	}
}
