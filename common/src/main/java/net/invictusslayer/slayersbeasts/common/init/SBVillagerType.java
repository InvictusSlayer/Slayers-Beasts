package net.invictusslayer.slayersbeasts.common.init;

import dev.architectury.registry.registries.DeferredRegister;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.world.biome.SBBiomes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.level.biome.Biome;

import java.util.Arrays;

public class SBVillagerType {
	public static final DeferredRegister<VillagerType> VILLAGER_TYPES = DeferredRegister.create(SlayersBeasts.MOD_ID, Registries.VILLAGER_TYPE);

//	public static final RegistryObject<VillagerType> CAVE = VILLAGER_TYPES.register("cave", () -> new VillagerType("cave"));

	public static void biomeSetup() {
		addBiomes(VillagerType.DESERT, SBBiomes.BLACK_DUNES, SBBiomes.DEAD_SANDS, SBBiomes.OUTBACK);
		addBiomes(VillagerType.JUNGLE, SBBiomes.ANCIENT_GROVE, SBBiomes.EUCALYPT_WOODLAND, SBBiomes.RAINFOREST);
		addBiomes(VillagerType.SAVANNA, SBBiomes.BRUSHLAND, SBBiomes.ROCKY_BRUSHLAND, SBBiomes.WOODED_BRUSHLAND);
		addBiomes(VillagerType.SNOW, SBBiomes.FROZEN_THICKET, SBBiomes.PETRIFIED_WOODS);
		addBiomes(VillagerType.SWAMP, SBBiomes.INKY_MOOR);
		addBiomes(VillagerType.TAIGA, SBBiomes.REDWOOD_GROVE, SBBiomes.OLD_GROWTH_REDWOOD_GROVE);
	}

	@SafeVarargs
	private static void addBiomes(VillagerType type, ResourceKey<Biome>... biomes) {
		Arrays.stream(biomes).toList().forEach(biome -> VillagerType.BY_BIOME.put(biome, type));
	}
}
