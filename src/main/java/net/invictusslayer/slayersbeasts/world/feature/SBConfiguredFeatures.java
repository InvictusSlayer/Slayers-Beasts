package net.invictusslayer.slayersbeasts.world.feature;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.SBBlocks;
import net.invictusslayer.slayersbeasts.block.WillowBranchBlock;
import net.invictusslayer.slayersbeasts.world.feature.foliageplacer.AspenFoliagePlacer;
import net.invictusslayer.slayersbeasts.world.feature.foliageplacer.CajoleFoliagePlacer;
import net.invictusslayer.slayersbeasts.world.feature.foliageplacer.EucalyptusFoliagePlacer;
import net.invictusslayer.slayersbeasts.world.feature.foliageplacer.UltraRedwoodFoliagePlacer;
import net.invictusslayer.slayersbeasts.world.feature.trunkplacer.ButtressTrunkPlacer;
import net.invictusslayer.slayersbeasts.world.feature.trunkplacer.ColossalTrunkPlacer;
import net.invictusslayer.slayersbeasts.world.feature.trunkplacer.CrossTrunkPlacer;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaJungleFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaPineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RandomizedIntStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AttachedToLeavesDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraft.world.level.material.Fluids;

import java.util.List;

public class SBConfiguredFeatures {
    //TREE
    public static final ResourceKey<ConfiguredFeature<?, ?>> ASPEN = registerKey("aspen");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CAJOLE = registerKey("cajole");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DESERT_OAK = registerKey("desert_oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EUCALYPTUS = registerKey("eucalyptus");
    public static final ResourceKey<ConfiguredFeature<?, ?>> KAPOK = registerKey("kapok");
    public static final ResourceKey<ConfiguredFeature<?, ?>> REDWOOD = registerKey("redwood");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_REDWOOD = registerKey("giant_redwood");
    public static final ResourceKey<ConfiguredFeature<?, ?>> COLOSSAL_REDWOOD = registerKey("colossal_redwood");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PETRIFIED_TREE = registerKey("petrified_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WILLOW = registerKey("willow");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HUGE_WHITE_MUSHROOM = registerKey("huge_white_mushroom");

    //VEGETATION
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_ASPEN = registerKey("trees_aspen");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_INKY = registerKey("trees_inky");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_RAINFOREST = registerKey("trees_rainforest");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_EUCALYPT = registerKey("trees_eucalypt");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_OUTBACK = registerKey("trees_outback");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_REDWOOD = registerKey("trees_redwood");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_OLD_GROWTH_REDWOOD = registerKey("trees_old_growth_redwood");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_WHITE_MUSHROOM = registerKey("patch_white_mushroom");

    //ORE
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_EXOSKELETON = registerKey("ore_exoskeleton");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_OBSIDIAN = registerKey("ore_obsidian");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_BASALT = registerKey("ore_basalt");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_PEGMATITE = registerKey("ore_pegmatite");

    //MISC
    public static final ResourceKey<ConfiguredFeature<?, ?>> LAKE_LAVA_VOLCANIC = registerKey("lake_lava_volcanic");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRING_LAVA_VOLCANIC = registerKey("spring_lava_volcanic");

    @SuppressWarnings("deprecation")
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configured = context.lookup(Registries.CONFIGURED_FEATURE);
        HolderGetter<PlacedFeature> placed = context.lookup(Registries.PLACED_FEATURE);

        register(context, ASPEN, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(SBBlocks.ASPEN_LOG.get()), new StraightTrunkPlacer(5, 3, 2),
                BlockStateProvider.simple(SBBlocks.ASPEN_LEAVES.get()), new AspenFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2)).build());
        register(context, CAJOLE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(SBBlocks.CAJOLE_LOG.get()), new CrossTrunkPlacer(7, 6, 3),
                BlockStateProvider.simple(SBBlocks.CAJOLE_LEAVES.get()), new CajoleFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2))
                .decorators(List.of(TrunkVineDecorator.INSTANCE, new LeaveVineDecorator(0.25F))).ignoreVines().build());
        register(context, DESERT_OAK, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(SBBlocks.DESERT_OAK_LOG.get()), new StraightTrunkPlacer(5, 2, 2),
                BlockStateProvider.simple(SBBlocks.DESERT_OAK_LEAVES.get()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 2)).build());
        register(context, EUCALYPTUS, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(SBBlocks.EUCALYPTUS_LOG.get()), new CrossTrunkPlacer(14, 8, 2),
                BlockStateProvider.simple(SBBlocks.EUCALYPTUS_LEAVES.get()), new EucalyptusFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2)).build());
        register(context, KAPOK, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(SBBlocks.KAPOK_LOG.get()), new ButtressTrunkPlacer(20, 8, 2),
                BlockStateProvider.simple(SBBlocks.KAPOK_LEAVES.get()), new MegaJungleFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 2), new TwoLayersFeatureSize(1, 0, 2)).build());
        register(context, REDWOOD, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(SBBlocks.REDWOOD_LOG.get()), new StraightTrunkPlacer(6, 5, 2),
                BlockStateProvider.simple(SBBlocks.REDWOOD_LEAVES.get()), new AspenFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2)).build());
        register(context, GIANT_REDWOOD, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(SBBlocks.REDWOOD_LOG.get()), new GiantTrunkPlacer(20, 8, 2),
                BlockStateProvider.simple(SBBlocks.REDWOOD_LEAVES.get()), new MegaPineFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(13, 17)), new TwoLayersFeatureSize(1, 0, 2)).build());
        register(context, COLOSSAL_REDWOOD, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(SBBlocks.REDWOOD_LOG.get()), new ColossalTrunkPlacer(32, 15, 15),
                BlockStateProvider.simple(SBBlocks.REDWOOD_LEAVES.get()), new UltraRedwoodFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), UniformInt.of(25, 35)), new TwoLayersFeatureSize(1, 0, 2)).build());
        register(context, PETRIFIED_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.STONE), new StraightTrunkPlacer(5, 2, 2),
                BlockStateProvider.simple(Blocks.TUFF), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 2)).build());
        register(context, WILLOW, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(SBBlocks.WILLOW_LOG.get()), new ButtressTrunkPlacer(10, 4, 4),
                BlockStateProvider.simple(SBBlocks.WILLOW_LEAVES.get()), new MegaJungleFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 2), new TwoLayersFeatureSize(1, 0, 2))
                .decorators(List.of(new AttachedToLeavesDecorator(0.5F, 0, 0, new RandomizedIntStateProvider(BlockStateProvider.simple(SBBlocks.WILLOW_BRANCH.get().defaultBlockState().getBlock()), WillowBranchBlock.AGE, UniformInt.of(0, 10)), 5, List.of(Direction.DOWN)))).build());
        register(context, HUGE_WHITE_MUSHROOM, SBFeatures.HUGE_WHITE_MUSHROOM.get(), new HugeMushroomFeatureConfiguration(
                BlockStateProvider.simple(SBBlocks.WHITE_MUSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.UP, Boolean.TRUE).setValue(HugeMushroomBlock.DOWN, Boolean.FALSE)),
                BlockStateProvider.simple(Blocks.MUSHROOM_STEM.defaultBlockState().setValue(HugeMushroomBlock.UP, Boolean.FALSE).setValue(HugeMushroomBlock.DOWN, Boolean.FALSE)), 3));

        register(context, TREES_ASPEN, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placed.getOrThrow(SBPlacedFeatures.ASPEN_CHECKED), 0.7F)), placed.getOrThrow(SBPlacedFeatures.ASPEN_CHECKED)));
        register(context, TREES_INKY, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placed.getOrThrow(SBPlacedFeatures.CAJOLE_CHECKED), 0.5F)), placed.getOrThrow(SBPlacedFeatures.CAJOLE_CHECKED)));
        register(context, TREES_RAINFOREST, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placed.getOrThrow(SBPlacedFeatures.KAPOK_CHECKED), 0.2F)), placed.getOrThrow(SBPlacedFeatures.CAJOLE_CHECKED)));
        register(context, TREES_EUCALYPT, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placed.getOrThrow(SBPlacedFeatures.EUCALYPTUS_CHECKED), 0.5F)), placed.getOrThrow(SBPlacedFeatures.EUCALYPTUS_CHECKED)));
        register(context, TREES_OUTBACK, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placed.getOrThrow(SBPlacedFeatures.DESERT_OAK_CHECKED), 0.5F)), placed.getOrThrow(SBPlacedFeatures.EUCALYPTUS_CHECKED)));
        register(context, TREES_REDWOOD, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placed.getOrThrow(SBPlacedFeatures.GIANT_REDWOOD_CHECKED), 0.2F), new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configured.getOrThrow(SBConfiguredFeatures.HUGE_WHITE_MUSHROOM)), 0.05F)), placed.getOrThrow(SBPlacedFeatures.REDWOOD_CHECKED)));
        register(context, TREES_OLD_GROWTH_REDWOOD, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placed.getOrThrow(SBPlacedFeatures.GIANT_REDWOOD_CHECKED), 0.3F), new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configured.getOrThrow(SBConfiguredFeatures.HUGE_WHITE_MUSHROOM)), 0.05F)), placed.getOrThrow(SBPlacedFeatures.COLOSSAL_REDWOOD_CHECKED)));
        register(context, PATCH_WHITE_MUSHROOM, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(SBBlocks.WHITE_MUSHROOM.get()))));

        register(context, ORE_EXOSKELETON, Feature.ORE, new OreConfiguration(List.of(
                OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), SBBlocks.EXOSKELETON_ORE.get().defaultBlockState()),
                OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), SBBlocks.DEEPSLATE_EXOSKELETON_ORE.get().defaultBlockState())), 3));
        register(context, ORE_OBSIDIAN, Feature.ORE, new OreConfiguration(new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD), Blocks.OBSIDIAN.defaultBlockState(), 33));
        register(context, ORE_BASALT, Feature.ORE, new OreConfiguration(new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD), Blocks.BASALT.defaultBlockState(), 64));
        register(context, ORE_PEGMATITE, Feature.ORE, new OreConfiguration(new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD), SBBlocks.PEGMATITE.get().defaultBlockState(), 64));

        register(context, LAKE_LAVA_VOLCANIC, Feature.LAKE, new LakeFeature.Configuration(BlockStateProvider.simple(Blocks.LAVA.defaultBlockState()), BlockStateProvider.simple(Blocks.MAGMA_BLOCK.defaultBlockState())));
        register(context, SPRING_LAVA_VOLCANIC, Feature.SPRING, new SpringConfiguration(Fluids.LAVA.defaultFluidState(), true, 4, 1, HolderSet.direct(Block::builtInRegistryHolder, Blocks.BASALT, Blocks.MAGMA_BLOCK, Blocks.SMOOTH_BASALT, Blocks.BLACKSTONE, Blocks.OBSIDIAN)));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(SlayersBeasts.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
        context.register(key, new ConfiguredFeature<>(feature, config));
    }
}