package net.invictusslayer.slayersbeasts.init;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.world.biome.SBBiomes;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;

import java.util.List;
import java.util.function.Supplier;

public class SBVillagerType {
	//? if neoforge
	/*public static final net.neoforged.neoforge.registries.DeferredRegister<VillagerType> VILLAGER_TYPES = net.neoforged.neoforge.registries.DeferredRegister.create(Registries.VILLAGER_TYPE, SlayersBeasts.MOD_ID);*/

	public static final Supplier<VillagerType> CAVE = register("cave", new VillagerType("cave"));
//	public static final Supplier<VillagerType> MUSHROOM = register("mushroom", new VillagerType("mushroom"));
//	public static final Supplier<VillagerType> REDWOOD = register("redwood", new VillagerType("redwood"));

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

	private static Supplier<VillagerType> register(String name, VillagerType type) {
		//? if fabric
		return () -> Registry.register(BuiltInRegistries.VILLAGER_TYPE, ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, name), type);
		//? if neoforge
		/*return VILLAGER_TYPES.register(name, () -> type);*/
	}

	public static void init() {
		SlayersBeasts.LOGGER.info("Initialised Villager Types");
	}
}
