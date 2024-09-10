package net.invictusslayer.slayersbeasts.common.data.loot;

import com.google.common.collect.Sets;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.Collections;
import java.util.Set;

public class SBLootTables {
	private static final Set<ResourceKey<LootTable>> LOCATIONS = Sets.newHashSet();
	private static final Set<ResourceKey<LootTable>> IMMUTABLE_LOCATIONS = Collections.unmodifiableSet(LOCATIONS);

	public static final ResourceKey<LootTable> CRYPT_COMMON = register("chests/crypt_common");
	public static final ResourceKey<LootTable> CRYPT_RARE = register("chests/crypt_rare");
	public static final ResourceKey<LootTable> REDWOOD_LOGS = register("chests/redwood_logs");
	public static final ResourceKey<LootTable> REDWOOD_TOOLS = register("chests/redwood_tools");

	private static ResourceKey<LootTable> register(String path) {
		ResourceKey<LootTable> key = ResourceKey.create(Registries.LOOT_TABLE, new ResourceLocation(SlayersBeasts.MOD_ID, path));
		if (LOCATIONS.add(key)) return key;
		else throw new IllegalArgumentException(key + " is already a registered loot table");
	}

	public static Set<ResourceKey<LootTable>> all() {
		return IMMUTABLE_LOCATIONS;
	}
}
