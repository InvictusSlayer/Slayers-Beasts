package net.invictusslayer.slayersbeasts.world.feature;

import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.ModBlocks;
import net.invictusslayer.slayersbeasts.world.feature.foliageplacer.AspenFoliagePlacer;
import net.invictusslayer.slayersbeasts.world.feature.foliageplacer.CajoleFoliagePlacer;
import net.invictusslayer.slayersbeasts.world.feature.foliageplacer.EucalyptusFoliagePlacer;
import net.invictusslayer.slayersbeasts.world.feature.trunkplacer.CrossTrunkPlacer;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaPineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.PineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> ASPEN = registerKey("aspen");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ASPEN_SPAWN = registerKey("aspen_spawn");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CAJOLE = registerKey("cajole");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CAJOLE_SPAWN = registerKey("cajole_spawn");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EUCALYPTUS = registerKey("eucalyptus");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EUCALYPTUS_SPAWN = registerKey("eucalyptus_spawn");
    public static final ResourceKey<ConfiguredFeature<?, ?>> REDWOOD = registerKey("redwood");
    public static final ResourceKey<ConfiguredFeature<?, ?>> REDWOOD_SPAWN = registerKey("redwood_spawn");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_REDWOOD = registerKey("mega_redwood");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_REDWOOD_SPAWN = registerKey("mega_redwood_spawn");

    public static final ResourceKey<ConfiguredFeature<?, ?>> HUGE_WHITE_MUSHROOM = registerKey("huge_white_mushroom");

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_EXOSKELETON_ORE_KEY = registerKey("overworld_exoskeleton_ore");

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_EXOSKELETON_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.EXOSKELETON_ORE.get().defaultBlockState()),
            OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_EXOSKELETON_ORE.get().defaultBlockState())));

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        register(context, ASPEN, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.ASPEN_LOG.get()), new StraightTrunkPlacer(5, 3, 2),
                BlockStateProvider.simple(ModBlocks.ASPEN_LEAVES.get()), new AspenFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2)).build());
        register(context, CAJOLE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.CAJOLE_LOG.get()), new CrossTrunkPlacer(7, 6, 3),
                BlockStateProvider.simple(ModBlocks.CAJOLE_LEAVES.get()), new CajoleFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2)).decorators(ImmutableList.of(TrunkVineDecorator.INSTANCE, new LeaveVineDecorator(0.25F))).ignoreVines().build());
        register(context, EUCALYPTUS, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.EUCALYPTUS_LOG.get()), new CrossTrunkPlacer(14, 8, 2),
                BlockStateProvider.simple(ModBlocks.EUCALYPTUS_LEAVES.get()), new EucalyptusFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2)).build());
        register(context, REDWOOD, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.REDWOOD_LOG.get()), new StraightTrunkPlacer(6, 5, 2),
                BlockStateProvider.simple(ModBlocks.REDWOOD_LEAVES.get()), new AspenFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2)).build());
        register(context, GIANT_REDWOOD, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.REDWOOD_LOG.get()), new GiantTrunkPlacer(20, 8, 2),
                BlockStateProvider.simple(ModBlocks.REDWOOD_LEAVES.get()), new MegaPineFoliagePlacer(ConstantInt.of(1), ConstantInt.of(1), UniformInt.of(3, 7)), new TwoLayersFeatureSize(1, 0, 2)).build());
        
        register(context, ASPEN_SPAWN, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placedFeatures.getOrThrow(ModPlacedFeatures.ASPEN_CHECKED), 0.5F)), placedFeatures.getOrThrow(ModPlacedFeatures.ASPEN_CHECKED)));
        register(context, CAJOLE_SPAWN, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placedFeatures.getOrThrow(ModPlacedFeatures.CAJOLE_CHECKED), 0.5F)), placedFeatures.getOrThrow(ModPlacedFeatures.CAJOLE_CHECKED)));
        register(context, EUCALYPTUS_SPAWN, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placedFeatures.getOrThrow(ModPlacedFeatures.EUCALYPTUS_CHECKED), 0.5F)), placedFeatures.getOrThrow(ModPlacedFeatures.EUCALYPTUS_CHECKED)));
        register(context, REDWOOD_SPAWN, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placedFeatures.getOrThrow(ModPlacedFeatures.REDWOOD_CHECKED), 0.5F)), placedFeatures.getOrThrow(ModPlacedFeatures.REDWOOD_CHECKED)));
        register(context, GIANT_REDWOOD_SPAWN, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placedFeatures.getOrThrow(ModPlacedFeatures.GIANT_REDWOOD_CHECKED), 0.5F)), placedFeatures.getOrThrow(ModPlacedFeatures.GIANT_REDWOOD_CHECKED)));

        register(context, HUGE_WHITE_MUSHROOM, ModFeatures.HUGE_WHITE_MUSHROOM.get(), new HugeMushroomFeatureConfiguration(
                BlockStateProvider.simple(ModBlocks.WHITE_MUSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.UP, Boolean.TRUE).setValue(HugeMushroomBlock.DOWN, Boolean.FALSE)),
                BlockStateProvider.simple(Blocks.MUSHROOM_STEM.defaultBlockState().setValue(HugeMushroomBlock.UP, Boolean.FALSE).setValue(HugeMushroomBlock.DOWN, Boolean.FALSE)), 3));

        register(context, OVERWORLD_EXOSKELETON_ORE_KEY, Feature.ORE, new OreConfiguration(OVERWORLD_EXOSKELETON_ORES.get(), 3));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(SlayersBeasts.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
        context.register(key, new ConfiguredFeature<>(feature, config));
    }
}