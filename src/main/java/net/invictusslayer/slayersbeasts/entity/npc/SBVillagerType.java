package net.invictusslayer.slayersbeasts.entity.npc;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class SBVillagerType {
	public static final DeferredRegister<VillagerType> VILLAGER_TYPE = DeferredRegister.create(Registries.VILLAGER_TYPE, SlayersBeasts.MOD_ID);

	public static final RegistryObject<VillagerType> CAVE = VILLAGER_TYPE.register("cave", () -> new VillagerType("cave"));

	public static void register(IEventBus eventBus) {
		VILLAGER_TYPE.register(eventBus);
		addVillagerType(Biomes.DEEP_DARK, CAVE.get());
		addVillagerType(Biomes.DRIPSTONE_CAVES, CAVE.get());
		addVillagerType(Biomes.LUSH_CAVES, CAVE.get());
	}

	private static void addVillagerType(ResourceKey<Biome> key, VillagerType type) {
		VillagerType.BY_BIOME.put(key, type);
	}
}
