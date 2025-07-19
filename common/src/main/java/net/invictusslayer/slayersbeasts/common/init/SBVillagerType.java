package net.invictusslayer.slayersbeasts.common.init;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.world.biome.SBBiomes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;

import java.util.List;
import java.util.function.Supplier;

public class SBVillagerType {
	public static final Supplier<VillagerType> CAVE = register("cave", () -> new VillagerType("cave"));
//	public static final Supplier<VillagerType> MUSHROOM = register("mushroom", () -> new VillagerType("mushroom"));
//	public static final Supplier<VillagerType> REDWOOD = register("redwood", () -> new VillagerType("redwood"));

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

	private static <T extends VillagerType> Supplier<T> register(String name, Supplier<T> supplier) {
		return SlayersBeasts.PLATFORM.register(BuiltInRegistries.VILLAGER_TYPE, name, supplier);
	}

	public static void register() {
		SlayersBeasts.LOGGER.info("Registering SBVillagerTypes...");
	}
}
