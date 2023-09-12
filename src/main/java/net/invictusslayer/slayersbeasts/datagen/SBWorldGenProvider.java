package net.invictusslayer.slayersbeasts.datagen;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.world.biome.SBBiomeModifiers;
import net.invictusslayer.slayersbeasts.world.biome.SBBiomes;
import net.invictusslayer.slayersbeasts.world.feature.SBConfiguredFeatures;
import net.invictusslayer.slayersbeasts.world.feature.SBPlacedFeatures;
import net.invictusslayer.slayersbeasts.world.structure.pools.SBPools;
import net.invictusslayer.slayersbeasts.world.structure.SBProcessorLists;
import net.invictusslayer.slayersbeasts.world.structure.SBStructureSets;
import net.invictusslayer.slayersbeasts.world.structure.SBStructures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

public class SBWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, SBConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, SBPlacedFeatures::bootstrap)
            .add(Registries.BIOME, SBBiomes::bootstrap)
            .add(Registries.STRUCTURE, SBStructures::bootstrap)
            .add(Registries.STRUCTURE_SET, SBStructureSets::bootstrap)
            .add(Registries.TEMPLATE_POOL, SBPools::bootstrap)
            .add(Registries.PROCESSOR_LIST, SBProcessorLists::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, SBBiomeModifiers::bootstrap);

    public SBWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Collections.singleton(SlayersBeasts.MOD_ID));
    }
}
