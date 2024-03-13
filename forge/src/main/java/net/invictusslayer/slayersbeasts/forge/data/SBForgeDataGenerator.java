package net.invictusslayer.slayersbeasts.forge.data;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.data.lang.EnUsLanguageProvider;
import net.invictusslayer.slayersbeasts.common.data.loot.SBBlockLoot;
import net.invictusslayer.slayersbeasts.common.data.loot.SBChestLoot;
import net.invictusslayer.slayersbeasts.common.data.loot.SBEntityLoot;
import net.invictusslayer.slayersbeasts.common.data.loot.SBLootTables;
import net.invictusslayer.slayersbeasts.common.world.SBNoises;
import net.invictusslayer.slayersbeasts.common.world.biome.SBBiomes;
import net.invictusslayer.slayersbeasts.common.world.dimension.SBDimensions;
import net.invictusslayer.slayersbeasts.common.world.feature.SBConfiguredFeatures;
import net.invictusslayer.slayersbeasts.common.world.feature.SBPlacedFeatures;
import net.invictusslayer.slayersbeasts.common.world.structure.SBProcessorLists;
import net.invictusslayer.slayersbeasts.common.world.structure.SBStructureSets;
import net.invictusslayer.slayersbeasts.common.world.structure.SBStructures;
import net.invictusslayer.slayersbeasts.common.world.structure.pools.SBPools;
import net.invictusslayer.slayersbeasts.forge.data.tag.*;
import net.invictusslayer.slayersbeasts.forge.world.SBBiomeModifiers;
import net.minecraft.core.Cloner;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = SlayersBeasts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SBForgeDataGenerator {
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
			.add(ForgeRegistries.Keys.BIOME_MODIFIERS, SBBiomeModifiers::bootstrap);

	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator gen = event.getGenerator();
		PackOutput output = gen.getPackOutput();
		CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();
		ExistingFileHelper helper = event.getExistingFileHelper();
		boolean hasServer = event.includeServer();

		gen.addProvider(hasServer, new DatapackBuiltinEntriesProvider(output, provider, BUILDER, Set.of(SlayersBeasts.MOD_ID)));

		SBBlockTagsProvider blockTags = gen.addProvider(hasServer, new SBBlockTagsProvider(output, provider, helper));
		gen.addProvider(hasServer, new SBItemTagsProvider(output, provider, blockTags, helper));
		gen.addProvider(hasServer, new SBBiomeTagsProvider(output, provider.thenApply(SBForgeDataGenerator::patchRegistry), helper));
		gen.addProvider(hasServer, new SBEntityTagsProvider(output, provider, helper));
		gen.addProvider(hasServer, new SBPoiTagsProvider(output, provider, helper));

		gen.addProvider(hasServer, new EnUsLanguageProvider(output));
		gen.addProvider(hasServer, new SBRecipeProvider(output));
		gen.addProvider(hasServer, new SBBlockStateProvider(output, helper));
		gen.addProvider(hasServer, new SBItemModelProvider(output, helper));
		gen.addProvider(hasServer, new SBSoundDefinitionsProvider(output, helper));

		gen.addProvider(hasServer, new LootTableProvider(output, SBLootTables.all(), List.of(
				new LootTableProvider.SubProviderEntry(SBBlockLoot::new, LootContextParamSets.BLOCK),
				new LootTableProvider.SubProviderEntry(SBEntityLoot::new, LootContextParamSets.ENTITY),
				new LootTableProvider.SubProviderEntry(SBChestLoot::new, LootContextParamSets.CHEST)
		)));
	}

	private static HolderLookup.Provider patchRegistry(HolderLookup.Provider provider) {
		Cloner.Factory factory = new Cloner.Factory();
		RegistryDataLoader.WORLDGEN_REGISTRIES.forEach(data -> data.runWithArguments(factory::addCodec));
		factory.addCodec(ForgeRegistries.Keys.BIOME_MODIFIERS, BiomeModifier.DIRECT_CODEC);
		return BUILDER.buildPatch(RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY), provider, factory).full();
	}
}
