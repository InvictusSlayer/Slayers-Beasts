package net.invictusslayer.slayersbeasts.world.feature;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.init.ModBlocks;
import net.invictusslayer.slayersbeasts.world.feature.foliageplacers.CajoleFoliagePlacer;
import net.invictusslayer.slayersbeasts.world.feature.foliageplacers.EucalyptusFoliagePlacer;
import net.invictusslayer.slayersbeasts.world.feature.tree.SpreadTrunkPlacer;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, SlayersBeasts.MOD_ID);

    public static final RegistryObject<ConfiguredFeature<?, ?>> CAJOLE_TREE =
            CONFIGURED_FEATURES.register("cajole", () -> new ConfiguredFeature<>(
                    Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(ModBlocks.CAJOLE_LOG.get()),
                    new SpreadTrunkPlacer(7, 6, 3),
                    BlockStateProvider.simple(ModBlocks.CAJOLE_LEAVES.get()),
                    new CajoleFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)),
                    new TwoLayersFeatureSize(1, 0, 2))
                    .decorators(ImmutableList.of(TrunkVineDecorator.INSTANCE,
                            new LeaveVineDecorator(0.25F))).ignoreVines().build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> EUCALYPTUS_TREE =
            CONFIGURED_FEATURES.register("eucalyptus", () -> new ConfiguredFeature<>(
                    Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(ModBlocks.EUCALYPTUS_LOG.get()),
                    new SpreadTrunkPlacer(15, 10, 2),
                    BlockStateProvider.simple(ModBlocks.EUCALYPTUS_LEAVES.get()),
                    new EucalyptusFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)),
                    new TwoLayersFeatureSize(1, 0, 2)).build()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> CAJOLE_SPAWN =
            CONFIGURED_FEATURES.register("cajole_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            ModPlacedFeatures.CAJOLE_CHECKED.getHolder().get(),
                            0.5F)), ModPlacedFeatures.CAJOLE_CHECKED.getHolder().get())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> EUCALYPTUS_SPAWN =
            CONFIGURED_FEATURES.register("eucalyptus_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            ModPlacedFeatures.EUCALYPTUS_CHECKED.getHolder().get(),
                            0.5F)), ModPlacedFeatures.EUCALYPTUS_CHECKED.getHolder().get())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_EXOSKELETON_ORES = Suppliers.memoize(() -> List.of(
                OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.EXOSKELETON_ORE.get().defaultBlockState()),
                OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_EXOSKELETON_ORE.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> EXOSKELETON_ORE = CONFIGURED_FEATURES.register("exoskeleton_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_EXOSKELETON_ORES.get(), 3)));

    public static void register(IEventBus bus) {
        CONFIGURED_FEATURES.register(bus);
    }
}