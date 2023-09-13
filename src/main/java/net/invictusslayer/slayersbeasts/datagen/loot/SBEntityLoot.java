package net.invictusslayer.slayersbeasts.datagen.loot;

import it.unimi.dsi.fastutil.objects.ReferenceOpenHashSet;
import net.invictusslayer.slayersbeasts.entity.SBEntities;
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

import java.util.Set;
import java.util.stream.Stream;

public class SBEntityLoot extends EntityLootSubProvider {
	private final Set<EntityType<?>> KNOWN_ENTITIES = new ReferenceOpenHashSet<>();

	protected SBEntityLoot() {
		super(FeatureFlags.REGISTRY.allFlags());
	}

	public void generate() {
		add(SBEntities.MANTIS.get(), LootTable.lootTable());
		add(SBEntities.WORKER_ANT.get(), LootTable.lootTable());
		add(SBEntities.SOLDIER_ANT.get(), LootTable.lootTable());
		add(SBEntities.QUEEN_ANT.get(), LootTable.lootTable());
		add(SBEntities.WITHER_SPIDER.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.COAL).apply(SetItemCountFunction.setCount(UniformGenerator.between(-1.0F, 1.0F))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.BONE).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));
		add(SBEntities.TARANTULA.get(), LootTable.lootTable());
		add(SBEntities.DAMSELFLY.get(), LootTable.lootTable());
		add(SBEntities.ENT_OAK.get(), LootTable.lootTable());
		add(SBEntities.VENUS_FLYTRAP.get(), LootTable.lootTable());
	}

	protected void add(EntityType<?> entity, LootTable.Builder builder) {
		super.add(entity, builder);
		KNOWN_ENTITIES.add(entity);
	}

	protected Stream<EntityType<?>> getKnownEntityTypes() {
		return KNOWN_ENTITIES.stream();
	}
}
