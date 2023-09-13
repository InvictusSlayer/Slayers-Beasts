package net.invictusslayer.slayersbeasts.datagen.loot;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class SBLootProvider {
    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(SBBlockLoot::new, LootContextParamSets.BLOCK),
                new LootTableProvider.SubProviderEntry(SBEntityLoot::new, LootContextParamSets.ENTITY),
                new LootTableProvider.SubProviderEntry(SBChestLoot::new, LootContextParamSets.CHEST)));
    }
}
