package net.invictusslayer.slayersbeasts.common.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.world.biome.SBBiomes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;

import java.util.List;

public class SBVillagerType {
	public static final DeferredRegister<VillagerType> VILLAGER_TYPES = DeferredRegister.create(SlayersBeasts.MOD_ID, Registries.VILLAGER_TYPE);

	public static final RegistrySupplier<VillagerType> CAVE = VILLAGER_TYPES.register("cave", () -> new VillagerType("cave"));
//	public static final RegistrySupplier<VillagerType> MUSHROOM = VILLAGER_TYPES.register("mushroom", () -> new VillagerType("mushroom"));
//	public static final RegistrySupplier<VillagerType> REDWOOD = VILLAGER_TYPES.register("redwood", () -> new VillagerType("redwood"));

	public static void setupBiomes() {
		addBiomes(VillagerType.DESERT, SBBiomes.BLACK_DUNES, SBBiomes.DEAD_SANDS, SBBiomes.OUTBACK);
		addBiomes(VillagerType.JUNGLE, SBBiomes.ANCIENT_GROVE, SBBiomes.EUCALYPT_WOODLAND, SBBiomes.RAINFOREST);
		addBiomes(VillagerType.SAVANNA, SBBiomes.BRUSHLAND, SBBiomes.ROCKY_BRUSHLAND, SBBiomes.WOODED_BRUSHLAND);
		addBiomes(VillagerType.SNOW, SBBiomes.FROZEN_THICKET, SBBiomes.GLACIATE_SWAMP, SBBiomes.PETRIFIED_WOODS);
		addBiomes(VillagerType.SWAMP, SBBiomes.BAYOU, SBBiomes.INKY_MOOR);
		addBiomes(VillagerType.TAIGA, SBBiomes.ASPEN_FOREST);
		addBiomes(CAVE.get(), Biomes.LUSH_CAVES, Biomes.DEEP_DARK, Biomes.DRIPSTONE_CAVES, SBBiomes.SLIME_CAVERNS, SBBiomes.DUSTY_CAVERNS, SBBiomes.ICE_CAVES, SBBiomes.FUNGAL_DEPTHS);
//		addBiomes(MUSHROOM.get(), Biomes.MUSHROOM_FIELDS, SBBiomes.MUSHROOM_FOREST);
//		addBiomes(REDWOOD.get(), SBBiomes.REDWOOD_GROVE, SBBiomes.OLD_GROWTH_REDWOOD_GROVE);
	}

	@SafeVarargs
	private static void addBiomes(VillagerType type, ResourceKey<Biome>... biomes) {
		List.of(biomes).forEach(biome -> VillagerType.BY_BIOME.put(biome, type));
	}
}
