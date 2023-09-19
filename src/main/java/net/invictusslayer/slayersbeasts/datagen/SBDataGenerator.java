package net.invictusslayer.slayersbeasts.datagen;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.datagen.loot.*;
import net.invictusslayer.slayersbeasts.datagen.tags.*;
import net.invictusslayer.slayersbeasts.world.biome.SBBiomeModifiers;
import net.invictusslayer.slayersbeasts.world.biome.SBBiomes;
import net.invictusslayer.slayersbeasts.world.dimension.SBDimensions;
import net.invictusslayer.slayersbeasts.world.feature.SBConfiguredFeatures;
import net.invictusslayer.slayersbeasts.world.feature.SBPlacedFeatures;
import net.invictusslayer.slayersbeasts.world.structure.SBProcessorLists;
import net.invictusslayer.slayersbeasts.world.structure.SBStructureSets;
import net.invictusslayer.slayersbeasts.world.structure.SBStructures;
import net.invictusslayer.slayersbeasts.world.structure.pools.SBPools;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = SlayersBeasts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
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
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, SBBiomeModifiers::bootstrap);

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        boolean hasServer = event.includeServer();

        generator.addProvider(hasServer, new DatapackBuiltinEntriesProvider(output, provider, BUILDER, Collections.singleton(SlayersBeasts.MOD_ID)));

        SBBlockTagsProvider blockTags = generator.addProvider(hasServer, new SBBlockTagsProvider(output, provider, existingFileHelper));
        generator.addProvider(hasServer, new SBItemTagsProvider(output, provider, blockTags, existingFileHelper));
        generator.addProvider(hasServer, new SBBiomeTagsProvider(output, provider.thenApply(SBDataGenerator::patchRegistry), existingFileHelper));
        generator.addProvider(hasServer, new SBEntityTagsProvider(output, provider, existingFileHelper));
        generator.addProvider(hasServer, new SBPoiTagsProvider(output, provider, existingFileHelper));

        generator.addProvider(hasServer, new SBRecipeProvider(output));
        generator.addProvider(hasServer, new SBBlockStateProvider(output, existingFileHelper));
        generator.addProvider(hasServer, new SBItemModelProvider(output, existingFileHelper));

        generator.addProvider(hasServer, new LootTableProvider(output, SBLootTables.all(), List.of(
                new LootTableProvider.SubProviderEntry(SBBlockLoot::new, LootContextParamSets.BLOCK),
                new LootTableProvider.SubProviderEntry(SBEntityLoot::new, LootContextParamSets.ENTITY),
                new LootTableProvider.SubProviderEntry(SBChestLoot::new, LootContextParamSets.CHEST)
        )));
    }

    private static HolderLookup.Provider patchRegistry(HolderLookup.Provider provider) {
        return BUILDER.buildPatch(RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY), provider);
    }
}
