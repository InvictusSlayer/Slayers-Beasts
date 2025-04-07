package net.invictusslayer.slayersbeasts.neoforge.data;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.data.SBRecipeProvider;
import net.invictusslayer.slayersbeasts.common.data.lang.EnUsLangProvider;
import net.invictusslayer.slayersbeasts.common.data.loot.SBBlockLoot;
import net.invictusslayer.slayersbeasts.common.data.loot.SBChestLoot;
import net.invictusslayer.slayersbeasts.common.data.loot.SBEntityLoot;
import net.invictusslayer.slayersbeasts.common.data.loot.SBLootTables;
import net.invictusslayer.slayersbeasts.common.item.SBJukeboxSongs;
import net.invictusslayer.slayersbeasts.common.world.SBNoises;
import net.invictusslayer.slayersbeasts.common.world.biome.SBBiomes;
import net.invictusslayer.slayersbeasts.common.world.dimension.SBDimensions;
import net.invictusslayer.slayersbeasts.common.world.feature.SBConfiguredFeatures;
import net.invictusslayer.slayersbeasts.common.world.feature.SBPlacedFeatures;
import net.invictusslayer.slayersbeasts.common.world.structure.SBProcessorLists;
import net.invictusslayer.slayersbeasts.common.world.structure.SBStructureSets;
import net.invictusslayer.slayersbeasts.common.world.structure.SBStructures;
import net.invictusslayer.slayersbeasts.common.world.structure.pools.SBPools;
import net.invictusslayer.slayersbeasts.neoforge.data.tag.*;
import net.invictusslayer.slayersbeasts.neoforge.world.SBBiomeModifiers;
import net.minecraft.core.Cloner;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Collections;
import java.util.List;

@EventBusSubscriber(modid = SlayersBeasts.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class SBDataGenerator {
	private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
			.add(Registries.CONFIGURED_FEATURE, SBConfiguredFeatures::bootstrap)
			.add(Registries.PLACED_FEATURE, SBPlacedFeatures::bootstrap)
			.add(Registries.BIOME, SBBiomes::bootstrap)
			.add(Registries.DIMENSION_TYPE, SBDimensions::bootstrap)
			.add(Registries.STRUCTURE, SBStructures::bootstrap)
			.add(Registries.STRUCTURE_SET, SBStructureSets::bootstrap)
			.add(Registries.TEMPLATE_POOL, SBPools::bootstrap)
			.add(Registries.PROCESSOR_LIST, SBProcessorLists::bootstrap)
			.add(Registries.NOISE, SBNoises::bootstrap)
			.add(Registries.JUKEBOX_SONG, SBJukeboxSongs::bootstrap)
			.add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, SBBiomeModifiers::bootstrap);

	@SubscribeEvent
	public static void gatherData(GatherDataEvent.Client event) {
		event.createProvider((output, provider) -> new DatapackBuiltinEntriesProvider(output, provider, BUILDER, Collections.singleton(SlayersBeasts.MOD_ID)));

		event.createBlockAndItemTags(SBBlockTagsProvider::new, SBItemTagsProvider::new);
		event.createProvider((output, provider) -> new SBBiomeTagsProvider(output, provider.thenApply(SBDataGenerator::patchRegistry)));
		event.createProvider(SBEntityTagsProvider::new);
		event.createProvider(SBPoiTagsProvider::new);

		event.createProvider(EnUsLangProvider::new);
		event.createProvider(SBRecipeProvider.Runner::new);
		event.createProvider(SBModelProvider::new);
		event.createProvider(SBSoundDefinitionsProvider::new);

		event.createProvider((output, provider) -> new LootTableProvider(output, SBLootTables.all(), List.of(
				new LootTableProvider.SubProviderEntry(SBBlockLoot::new, LootContextParamSets.BLOCK),
				new LootTableProvider.SubProviderEntry(SBEntityLoot::new, LootContextParamSets.ENTITY),
				new LootTableProvider.SubProviderEntry(SBChestLoot::new, LootContextParamSets.CHEST)
		), provider));
	}

	private static HolderLookup.Provider patchRegistry(HolderLookup.Provider provider) {
		Cloner.Factory factory = new Cloner.Factory();
		RegistryDataLoader.WORLDGEN_REGISTRIES.forEach(data -> data.runWithArguments(factory::addCodec));
		new RegistryDataLoader.RegistryData<>(NeoForgeRegistries.Keys.BIOME_MODIFIERS, BiomeModifier.DIRECT_CODEC).runWithArguments(factory::addCodec);
		return BUILDER.buildPatch(RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY), provider, factory).full();
	}
}
