package net.invictusslayer.slayersbeasts.common.data.loot;

import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.function.BiConsumer;

public class SBChestLoot implements LootTableSubProvider {
	public void generate(BiConsumer<ResourceLocation, LootTable.Builder> output) {
		output.accept(SBLootTables.CRYPT_COMMON, cryptCommon());
		output.accept(SBLootTables.CRYPT_RARE, cryptRare());
	}

	private static LootTable.Builder cryptCommon() {
		return LootTable.lootTable();
	}

	private static LootTable.Builder cryptRare() {
		return LootTable.lootTable();
	}
}
