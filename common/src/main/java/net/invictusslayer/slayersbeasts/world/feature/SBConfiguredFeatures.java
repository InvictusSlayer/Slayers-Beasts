package net.invictusslayer.slayersbeasts.world.feature;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.init.SBBlocks;
import net.invictusslayer.slayersbeasts.init.SBFeatures;
import net.invictusslayer.slayersbeasts.world.feature.icicle.IcicleClusterFeature;
import net.invictusslayer.slayersbeasts.world.feature.icicle.IcicleLargeFeature;
import net.invictusslayer.slayersbeasts.world.feature.icicle.IcicleSmallFeature;
import net.invictusslayer.slayersbeasts.world.feature.misc.AntMoundFeature;
import net.invictusslayer.slayersbeasts.world.feature.misc.PitFeature;
import net.invictusslayer.slayersbeasts.world.feature.misc.StyphiumPatchFeature;
import net.invictusslayer.slayersbeasts.world.feature.mushroom.BigMushroomFeature;
import net.invictusslayer.slayersbeasts.world.feature.mushroom.BranchingMushroomFeature;
import net.invictusslayer.slayersbeasts.world.feature.tree.decorator.ButtressRootDecorator;
import net.invictusslayer.slayersbeasts.world.feature.tree.decorator.HangingBranchDecorator;
import net.invictusslayer.slayersbeasts.world.feature.tree.foliage.*;
import net.invictusslayer.slayersbeasts.world.feature.tree.trunk.ColossalTrunkPlacer;
import net.invictusslayer.slayersbeasts.world.feature.tree.trunk.CrossTrunkPlacer;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ClampedNormalFloat;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaJungleFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.EnvironmentScanPlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RandomOffsetPlacement;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraft.world.level.material.Fluids;

import java.util.List;

public class SBConfiguredFeatures {
	// Tree
	public static final ResourceKey<ConfiguredFeature<?, ?>> ASPEN = createKey("aspen");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SUPER_ASPEN = createKey("super_aspen");
	public static final ResourceKey<ConfiguredFeature<?, ?>> BLOODWOOD = createKey("bloodwood");
	public static final ResourceKey<ConfiguredFeature<?, ?>> CAJOLE = createKey("cajole");
	public static final ResourceKey<ConfiguredFeature<?, ?>> CYPRESS = createKey("cypress");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DESERT_OAK = createKey("desert_oak");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SUPER_DESERT_OAK = createKey("super_desert_oak");
	public static final ResourceKey<ConfiguredFeature<?, ?>> EUCALYPTUS = createKey("eucalyptus");
	public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_KAPOK = createKey("giant_kapok");
	public static final ResourceKey<ConfiguredFeature<?, ?>> REDWOOD = createKey("redwood");
	public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_REDWOOD = createKey("giant_redwood");
	public static final ResourceKey<ConfiguredFeature<?, ?>> COLOSSAL_REDWOOD = createKey("colossal_redwood");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ALBINO_REDWOOD = createKey("albino_redwood");
	public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_ALBINO_REDWOOD = createKey("giant_albino_redwood");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PETRIFIED_TREE = createKey("petrified_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_WILLOW = createKey("giant_willow");
	public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_BLACK_MUSHROOM = createKey("big_black_mushroom");
	public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_BROWN_MUSHROOM = createKey("big_brown_mushroom");
	public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_RED_MUSHROOM = createKey("big_red_mushroom");
	public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_WHITE_MUSHROOM = createKey("big_white_mushroom");
	public static final ResourceKey<ConfiguredFeature<?, ?>> BRANCHING_BLACK_MUSHROOM = createKey("branching_black_mushroom");
	public static final ResourceKey<ConfiguredFeature<?, ?>> BRANCHING_BROWN_MUSHROOM = createKey("branching_brown_mushroom");
	public static final ResourceKey<ConfiguredFeature<?, ?>> BRANCHING_RED_MUSHROOM = createKey("branching_red_mushroom");
	public static final ResourceKey<ConfiguredFeature<?, ?>> BRANCHING_WHITE_MUSHROOM = createKey("branching_white_mushroom");
	public static final ResourceKey<ConfiguredFeature<?, ?>> HUGE_BLACK_MUSHROOM = createKey("huge_black_mushroom");
	public static final ResourceKey<ConfiguredFeature<?, ?>> HUGE_WHITE_MUSHROOM = createKey("huge_white_mushroom");
	public static final ResourceKey<ConfiguredFeature<?, ?>> MIGHTY_BLACK_MUSHROOM = createKey("mighty_black_mushroom");
	public static final ResourceKey<ConfiguredFeature<?, ?>> MIGHTY_BROWN_MUSHROOM = createKey("mighty_brown_mushroom");
	public static final ResourceKey<ConfiguredFeature<?, ?>> MIGHTY_RED_MUSHROOM = createKey("mighty_red_mushroom");
	public static final ResourceKey<ConfiguredFeature<?, ?>> MIGHTY_WHITE_MUSHROOM = createKey("mighty_white_mushroom");

	// Vegetation
	public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_ASPEN = createKey("trees_aspen");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_BAYOU = createKey("trees_bayou");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_BRUSH = createKey("trees_brush");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_CHAPARRAL = createKey("trees_chaparral");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_EUCALYPT = createKey("trees_eucalypt");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_INKY = createKey("trees_inky");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_MUSHROOM = createKey("trees_mushroom");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_OUTBACK = createKey("trees_outback");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_RAINFOREST = createKey("trees_rainforest");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_REDWOOD = createKey("trees_redwood");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_OLD_GROWTH_REDWOOD = createKey("trees_old_growth_redwood");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_RIVER = createKey("trees_river");
	public static final ResourceKey<ConfiguredFeature<?, ?>> MIGHTY_MUSHROOMS = createKey("mighty_mushrooms");
	public static final ResourceKey<ConfiguredFeature<?, ?>> HUGE_MUSHROOMS = createKey("huge_mushrooms");
	public static final ResourceKey<ConfiguredFeature<?, ?>> BRANCHING_MUSHROOMS = createKey("branching_mushrooms");
	public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_MUSHROOMS = createKey("big_mushrooms");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_MUSHROOMS = createKey("tall_mushrooms");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_ALGAE = createKey("patch_algae");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_TALL_DEAD_BUSH = createKey("patch_tall_dead_bush");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_BLACK_MUSHROOM = createKey("patch_black_mushroom");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_WHITE_MUSHROOM = createKey("patch_white_mushroom");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_TALL_BLACK_MUSHROOM = createKey("patch_tall_black_mushroom");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_TALL_BROWN_MUSHROOM = createKey("patch_tall_brown_mushroom");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_TALL_RED_MUSHROOM = createKey("patch_tall_red_mushroom");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_TALL_WHITE_MUSHROOM = createKey("patch_tall_white_mushroom");

	// Cave
	public static final ResourceKey<ConfiguredFeature<?, ?>> ICICLE_CLUSTER = createKey("icicle_cluster");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ICICLE_LARGE = createKey("icicle_large");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ICICLE_SMALL = createKey("icicle_small");
	public static final ResourceKey<ConfiguredFeature<?, ?>> VEGETATION_STYPHIUM = createKey("styphium_vegetation");
	public static final ResourceKey<ConfiguredFeature<?, ?>> STYPHIUM_PATCH = createKey("styphium_patch");
	public static final ResourceKey<ConfiguredFeature<?, ?>> STYPHIUM_PATCH_BONEMEAL = createKey("styphium_patch_bonemeal");

	// Ore
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_EXOSKELETON = createKey("ore_exoskeleton");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_OBSIDIAN = createKey("ore_obsidian");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_BASALT = createKey("ore_basalt");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_PEGMATITE = createKey("ore_pegmatite");

	// Miscellaneous
	public static final ResourceKey<ConfiguredFeature<?, ?>> ANT_MOUND_MUD = createKey("ant_mound_mud");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ANT_MOUND_RUDOSOL = createKey("ant_mound_rudosol");
	public static final ResourceKey<ConfiguredFeature<?, ?>> MUD_PIT_SHALLOW = createKey("mud_pit_shallow");
	public static final ResourceKey<ConfiguredFeature<?, ?>> MUD_PIT_NORMAL = createKey("mud_pit_normal");
	public static final ResourceKey<ConfiguredFeature<?, ?>> MUD_PIT_DEEP = createKey("mud_pit_deep");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LAKE_LAVA_VOLCANIC = createKey("lake_lava_volcanic");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SPRING_LAVA_VOLCANIC = createKey("spring_lava_volcanic");

	@SuppressWarnings("deprecation")
	public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
		HolderGetter<ConfiguredFeature<?, ?>> configured = context.lookup(Registries.CONFIGURED_FEATURE);
		HolderGetter<PlacedFeature> placed = context.lookup(Registries.PLACED_FEATURE);

		register(context, ASPEN, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(SBBlocks.ASPEN_LOG.get()), new StraightTrunkPlacer(7, 3, 2),
				BlockStateProvider.simple(SBBlocks.ASPEN_LEAVES.get()), new PointedFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), false), new TwoLayersFeatureSize(1, 0, 2)).build());
		register(context, SUPER_ASPEN, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(SBBlocks.ASPEN_LOG.get()), new StraightTrunkPlacer(10, 5, 3),
				BlockStateProvider.simple(SBBlocks.ASPEN_LEAVES.get()), new PointedFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), true), new TwoLayersFeatureSize(1, 0, 2)).build());
		register(context, BLOODWOOD, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(SBBlocks.BLOODWOOD_LOG.get()), new StraightTrunkPlacer(7, 3, 2),
				BlockStateProvider.simple(SBBlocks.BLOODWOOD_LEAVES.get()), new PointedFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), false), new TwoLayersFeatureSize(1, 0, 2)).build());
		register(context, CAJOLE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(SBBlocks.CAJOLE_LOG.get()), new CrossTrunkPlacer(7, 6, 3),
				BlockStateProvider.simple(SBBlocks.CAJOLE_LEAVES.get()), new CajoleFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2))
				.decorators(List.of(TrunkVineDecorator.INSTANCE, new LeaveVineDecorator(0.25F))).ignoreVines().build());
		register(context, CYPRESS, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(SBBlocks.CYPRESS_LOG.get()), new StraightTrunkPlacer(7, 3, 2),
				BlockStateProvider.simple(SBBlocks.CYPRESS_LEAVES.get()), new SpruceFoliagePlacer(UniformInt.of(2, 3), UniformInt.of(0, 2), UniformInt.of(1, 2)), new TwoLayersFeatureSize(1, 0, 2)).build());
		register(context, DESERT_OAK, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(SBBlocks.DESERT_OAK_LOG.get()), new StraightTrunkPlacer(7, 1, 1),
				BlockStateProvider.simple(SBBlocks.DESERT_OAK_LEAVES.get()), new PointedFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), false), new TwoLayersFeatureSize(1, 0, 2)).build());
		register(context, SUPER_DESERT_OAK, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(SBBlocks.DESERT_OAK_LOG.get()), new StraightTrunkPlacer(10, 4, 3),
				BlockStateProvider.simple(SBBlocks.DESERT_OAK_LEAVES.get()), new PointedFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), true), new TwoLayersFeatureSize(1, 0, 2)).build());
		register(context, EUCALYPTUS, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(SBBlocks.EUCALYPTUS_LOG.get()), new CrossTrunkPlacer(14, 8, 2),
				BlockStateProvider.simple(SBBlocks.EUCALYPTUS_LEAVES.get()), new EucalyptusFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2)).build());
		register(context, GIANT_KAPOK, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(SBBlocks.KAPOK_LOG.get()), new GiantTrunkPlacer(20, 8, 2),
				BlockStateProvider.simple(SBBlocks.KAPOK_LEAVES.get()), new MegaJungleFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 2), new TwoLayersFeatureSize(1, 0, 2))
				.decorators(List.of(new ButtressRootDecorator(BlockStateProvider.simple(SBBlocks.KAPOK_WOOD.get().defaultBlockState()), BlockStateProvider.simple(Blocks.DIRT.defaultBlockState())))).build());
		register(context, REDWOOD, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(SBBlocks.REDWOOD_LOG.get()), new StraightTrunkPlacer(18, 5, 5),
				BlockStateProvider.simple(SBBlocks.REDWOOD_LEAVES.get()), new RedwoodFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(2, 3), 1), new TwoLayersFeatureSize(1, 0, 2)).build());
		register(context, GIANT_REDWOOD, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(SBBlocks.REDWOOD_LOG.get()), new GiantTrunkPlacer(28, 8, 2),
				BlockStateProvider.simple(SBBlocks.REDWOOD_LEAVES.get()), new RedwoodFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(3, 7), 2), new TwoLayersFeatureSize(1, 0, 2)).build());
		register(context, COLOSSAL_REDWOOD, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(SBBlocks.REDWOOD_LOG.get()), new ColossalTrunkPlacer(50, 12, 12),
				BlockStateProvider.simple(SBBlocks.REDWOOD_LEAVES.get()), new RedwoodFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(5, 8), 3), new TwoLayersFeatureSize(1, 0, 2)).build());
		register(context, ALBINO_REDWOOD, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(SBBlocks.REDWOOD_LOG.get()), new StraightTrunkPlacer(18, 5, 5),
				BlockStateProvider.simple(SBBlocks.ALBINO_REDWOOD_LEAVES.get()), new RedwoodFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(2, 3), 1), new TwoLayersFeatureSize(1, 0, 2)).build());
		register(context, GIANT_ALBINO_REDWOOD, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(SBBlocks.REDWOOD_LOG.get()), new GiantTrunkPlacer(28, 8, 2),
				BlockStateProvider.simple(SBBlocks.ALBINO_REDWOOD_LEAVES.get()), new RedwoodFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(3, 7), 2), new TwoLayersFeatureSize(1, 0, 2)).build());
		register(context, PETRIFIED_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(Blocks.STONE), new StraightTrunkPlacer(5, 2, 2),
				BlockStateProvider.simple(Blocks.TUFF), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 2)).build());
		register(context, GIANT_WILLOW, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(SBBlocks.WILLOW_LOG.get()), new GiantTrunkPlacer(8, 3, 2),
				BlockStateProvider.simple(SBBlocks.WILLOW_LEAVES.get()), new WillowFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2))
				.decorators(List.of(new HangingBranchDecorator(0.25F, BlockStateProvider.simple(SBBlocks.WILLOW_BRANCH.get()), BlockStateProvider.simple(SBBlocks.WILLOW_BRANCH_PLANT.get())), new ButtressRootDecorator(BlockStateProvider.simple(SBBlocks.WILLOW_WOOD.get()), BlockStateProvider.simple(Blocks.DIRT)))).build());
		register(context, BIG_BLACK_MUSHROOM, SBFeatures.BIG_MUSHROOM.get(), new BigMushroomFeature.Configuration(UniformInt.of(3, 6), BlockStateProvider.simple(SBBlocks.BLACK_MUSHROOM_BLOCK.get()), BlockStateProvider.simple(Blocks.MUSHROOM_STEM)));
		register(context, BIG_BROWN_MUSHROOM, SBFeatures.BIG_MUSHROOM.get(), new BigMushroomFeature.Configuration(UniformInt.of(3, 6), BlockStateProvider.simple(Blocks.BROWN_MUSHROOM_BLOCK), BlockStateProvider.simple(Blocks.MUSHROOM_STEM)));
		register(context, BIG_RED_MUSHROOM, SBFeatures.BIG_MUSHROOM.get(), new BigMushroomFeature.Configuration(UniformInt.of(3, 6), BlockStateProvider.simple(Blocks.RED_MUSHROOM_BLOCK), BlockStateProvider.simple(Blocks.MUSHROOM_STEM)));
		register(context, BIG_WHITE_MUSHROOM, SBFeatures.BIG_MUSHROOM.get(), new BigMushroomFeature.Configuration(UniformInt.of(3, 6), BlockStateProvider.simple(SBBlocks.WHITE_MUSHROOM_BLOCK.get()), BlockStateProvider.simple(Blocks.MUSHROOM_STEM)));
		register(context, BRANCHING_BLACK_MUSHROOM, SBFeatures.BRANCHING_MUSHROOM.get(), new BranchingMushroomFeature.Configuration(UniformInt.of(7, 10), BlockStateProvider.simple(SBBlocks.BLACK_MUSHROOM_BLOCK.get()), BlockStateProvider.simple(Blocks.MUSHROOM_STEM)));
		register(context, BRANCHING_BROWN_MUSHROOM, SBFeatures.BRANCHING_MUSHROOM.get(), new BranchingMushroomFeature.Configuration(UniformInt.of(7, 10), BlockStateProvider.simple(Blocks.BROWN_MUSHROOM_BLOCK), BlockStateProvider.simple(Blocks.MUSHROOM_STEM)));
		register(context, BRANCHING_RED_MUSHROOM, SBFeatures.BRANCHING_MUSHROOM.get(), new BranchingMushroomFeature.Configuration(UniformInt.of(7, 10), BlockStateProvider.simple(Blocks.RED_MUSHROOM_BLOCK), BlockStateProvider.simple(Blocks.MUSHROOM_STEM)));
		register(context, BRANCHING_WHITE_MUSHROOM, SBFeatures.BRANCHING_MUSHROOM.get(), new BranchingMushroomFeature.Configuration(UniformInt.of(7, 10), BlockStateProvider.simple(SBBlocks.WHITE_MUSHROOM_BLOCK.get()), BlockStateProvider.simple(Blocks.MUSHROOM_STEM)));
		register(context, HUGE_BLACK_MUSHROOM, SBFeatures.HUGE_BLACK_MUSHROOM.get(), new HugeMushroomFeatureConfiguration(BlockStateProvider.simple(SBBlocks.BLACK_MUSHROOM_BLOCK.get()), BlockStateProvider.simple(Blocks.MUSHROOM_STEM), 2));
		register(context, HUGE_WHITE_MUSHROOM, SBFeatures.HUGE_WHITE_MUSHROOM.get(), new HugeMushroomFeatureConfiguration(BlockStateProvider.simple(SBBlocks.WHITE_MUSHROOM_BLOCK.get()), BlockStateProvider.simple(Blocks.MUSHROOM_STEM), 2));
		register(context, MIGHTY_BLACK_MUSHROOM, SBFeatures.MIGHTY_BLACK_MUSHROOM.get(), new HugeMushroomFeatureConfiguration(BlockStateProvider.simple(SBBlocks.BLACK_MUSHROOM_BLOCK.get()), BlockStateProvider.simple(Blocks.MUSHROOM_STEM), 4));
		register(context, MIGHTY_BROWN_MUSHROOM, SBFeatures.MIGHTY_BROWN_MUSHROOM.get(), new HugeMushroomFeatureConfiguration(BlockStateProvider.simple(Blocks.BROWN_MUSHROOM_BLOCK), BlockStateProvider.simple(Blocks.MUSHROOM_STEM), 3));
		register(context, MIGHTY_RED_MUSHROOM, SBFeatures.MIGHTY_RED_MUSHROOM.get(), new HugeMushroomFeatureConfiguration(BlockStateProvider.simple(Blocks.RED_MUSHROOM_BLOCK), BlockStateProvider.simple(Blocks.MUSHROOM_STEM), 3));
		register(context, MIGHTY_WHITE_MUSHROOM, SBFeatures.MIGHTY_WHITE_MUSHROOM.get(), new HugeMushroomFeatureConfiguration(BlockStateProvider.simple(SBBlocks.WHITE_MUSHROOM_BLOCK.get()), BlockStateProvider.simple(Blocks.MUSHROOM_STEM), 3));

		register(context, TREES_ASPEN, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placed.getOrThrow(SBPlacedFeatures.SUPER_ASPEN), 0.2F)), placed.getOrThrow(SBPlacedFeatures.ASPEN)));
		register(context, TREES_BAYOU, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placed.getOrThrow(SBPlacedFeatures.GIANT_WILLOW), 0.1F), new WeightedPlacedFeature(placed.getOrThrow(TreePlacements.MANGROVE_CHECKED), 0.3F)), placed.getOrThrow(SBPlacedFeatures.CYPRESS)));
		register(context, TREES_BRUSH, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placed.getOrThrow(SBPlacedFeatures.DESERT_OAK), 0.5F)), placed.getOrThrow(TreePlacements.ACACIA_CHECKED)));
		register(context, TREES_CHAPARRAL, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placed.getOrThrow(SBPlacedFeatures.DESERT_OAK), 0.5F)), placed.getOrThrow(TreePlacements.OAK_CHECKED)));
		register(context, TREES_EUCALYPT, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placed.getOrThrow(SBPlacedFeatures.BLOODWOOD), 0.3F)), placed.getOrThrow(SBPlacedFeatures.EUCALYPTUS)));
		register(context, TREES_INKY, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configured.getOrThrow(BRANCHING_BLACK_MUSHROOM)), 0.5F)), placed.getOrThrow(SBPlacedFeatures.CYPRESS)));
		register(context, TREES_MUSHROOM, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configured.getOrThrow(MIGHTY_MUSHROOMS)), 0.6F)), PlacementUtils.inlinePlaced(configured.getOrThrow(BRANCHING_MUSHROOMS))));
		register(context, TREES_OUTBACK, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placed.getOrThrow(SBPlacedFeatures.EUCALYPTUS), 0.2F), new WeightedPlacedFeature(placed.getOrThrow(SBPlacedFeatures.SUPER_DESERT_OAK), 0.3F)), placed.getOrThrow(SBPlacedFeatures.DESERT_OAK)));
		register(context, TREES_RAINFOREST, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placed.getOrThrow(SBPlacedFeatures.GIANT_KAPOK), 0.2F)), placed.getOrThrow(SBPlacedFeatures.CYPRESS)));
		register(context, TREES_REDWOOD, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placed.getOrThrow(SBPlacedFeatures.GIANT_REDWOOD), 0.2F), new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configured.getOrThrow(HUGE_WHITE_MUSHROOM)), 0.03F), new WeightedPlacedFeature(placed.getOrThrow(SBPlacedFeatures.ALBINO_REDWOOD), 0.001F)), placed.getOrThrow(SBPlacedFeatures.REDWOOD)));
		register(context, TREES_OLD_GROWTH_REDWOOD, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placed.getOrThrow(SBPlacedFeatures.GIANT_REDWOOD), 0.3F), new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configured.getOrThrow(HUGE_WHITE_MUSHROOM)), 0.05F), new WeightedPlacedFeature(placed.getOrThrow(SBPlacedFeatures.GIANT_ALBINO_REDWOOD), 0.001F)), placed.getOrThrow(SBPlacedFeatures.COLOSSAL_REDWOOD)));
		register(context, TREES_RIVER, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placed.getOrThrow(SBPlacedFeatures.GIANT_WILLOW), 0.5F)), placed.getOrThrow(SBPlacedFeatures.GIANT_WILLOW)));
		register(context, MIGHTY_MUSHROOMS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configured.getOrThrow(MIGHTY_BLACK_MUSHROOM)), 0.25F), new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configured.getOrThrow(MIGHTY_BROWN_MUSHROOM)), 0.25F), new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configured.getOrThrow(MIGHTY_RED_MUSHROOM)), 0.25F)), PlacementUtils.inlinePlaced(configured.getOrThrow(MIGHTY_WHITE_MUSHROOM))));
		register(context, HUGE_MUSHROOMS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configured.getOrThrow(HUGE_BLACK_MUSHROOM)), 0.25F), new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configured.getOrThrow(TreeFeatures.HUGE_BROWN_MUSHROOM)), 0.25F), new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configured.getOrThrow(TreeFeatures.HUGE_RED_MUSHROOM)), 0.25F)), PlacementUtils.inlinePlaced(configured.getOrThrow(HUGE_WHITE_MUSHROOM))));
		register(context, BRANCHING_MUSHROOMS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configured.getOrThrow(BRANCHING_BLACK_MUSHROOM)), 0.25F), new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configured.getOrThrow(BRANCHING_BROWN_MUSHROOM)), 0.25F), new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configured.getOrThrow(BRANCHING_RED_MUSHROOM)), 0.25F)), PlacementUtils.inlinePlaced(configured.getOrThrow(BRANCHING_WHITE_MUSHROOM))));
		register(context, BIG_MUSHROOMS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configured.getOrThrow(BIG_BLACK_MUSHROOM)), 0.25F), new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configured.getOrThrow(BIG_BROWN_MUSHROOM)), 0.25F), new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configured.getOrThrow(BIG_RED_MUSHROOM)), 0.25F)), PlacementUtils.inlinePlaced(configured.getOrThrow(BIG_WHITE_MUSHROOM))));
		register(context, TALL_MUSHROOMS, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(SBBlocks.TALL_BLACK_MUSHROOM.get().defaultBlockState(), 1).add(SBBlocks.TALL_BROWN_MUSHROOM.get().defaultBlockState(), 1).add(SBBlocks.TALL_RED_MUSHROOM.get().defaultBlockState(), 1).add(SBBlocks.TALL_WHITE_MUSHROOM.get().defaultBlockState(), 1).build())));
		register(context, VEGETATION_STYPHIUM, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configured.getOrThrow(HUGE_MUSHROOMS)), 0.08F), new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configured.getOrThrow(BIG_MUSHROOMS)), 0.22F)), PlacementUtils.inlinePlaced(configured.getOrThrow(TALL_MUSHROOMS))));
		register(context, PATCH_ALGAE, Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(SBBlocks.ALGAE.get())))));
		register(context, PATCH_TALL_DEAD_BUSH, Feature.RANDOM_PATCH, FeatureUtils.simpleRandomPatchConfiguration(4, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(SBBlocks.TALL_DEAD_BUSH.get())))));
		register(context, PATCH_TALL_BLACK_MUSHROOM, Feature.RANDOM_PATCH, FeatureUtils.simpleRandomPatchConfiguration(4, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(SBBlocks.TALL_BLACK_MUSHROOM.get())))));
		register(context, PATCH_TALL_BROWN_MUSHROOM, Feature.RANDOM_PATCH, FeatureUtils.simpleRandomPatchConfiguration(4, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(SBBlocks.TALL_BROWN_MUSHROOM.get())))));
		register(context, PATCH_TALL_RED_MUSHROOM, Feature.RANDOM_PATCH, FeatureUtils.simpleRandomPatchConfiguration(4, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(SBBlocks.TALL_RED_MUSHROOM.get())))));
		register(context, PATCH_TALL_WHITE_MUSHROOM, Feature.RANDOM_PATCH, FeatureUtils.simpleRandomPatchConfiguration(4, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(SBBlocks.TALL_WHITE_MUSHROOM.get())))));
		register(context, PATCH_BLACK_MUSHROOM, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(SBBlocks.BLACK_MUSHROOM.get()))));
		register(context, PATCH_WHITE_MUSHROOM, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(SBBlocks.WHITE_MUSHROOM.get()))));

		register(context, ICICLE_CLUSTER, SBFeatures.ICICLE_CLUSTER.get(), new IcicleClusterFeature.Configuration(12, UniformInt.of(3, 6), UniformInt.of(2, 8), 1, 3, UniformInt.of(2, 4), UniformFloat.of(0.3F, 0.7F), ClampedNormalFloat.of(0.1F, 0.3F, 0.1F, 0.9F), 0.1F, 3, 8));
		register(context, ICICLE_LARGE, SBFeatures.ICICLE_LARGE.get(), new IcicleLargeFeature.Configuration(30, UniformInt.of(3, 19), UniformFloat.of(0.4F, 2.0F), 0.33F, UniformFloat.of(0.3F, 0.9F), UniformFloat.of(0.4F, 1.0F), UniformFloat.of(0.0F, 0.3F), 4, 0.6F));
		register(context, ICICLE_SMALL, Feature.SIMPLE_RANDOM_SELECTOR, new SimpleRandomFeatureConfiguration(HolderSet.direct(
				PlacementUtils.inlinePlaced(SBFeatures.ICICLE_SMALL.get(), new IcicleSmallFeature.Configuration(0.2F, 0.7F, 0.5F, 0.5F), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1))),
				PlacementUtils.inlinePlaced(SBFeatures.ICICLE_SMALL.get(), new IcicleSmallFeature.Configuration(0.2F, 0.7F, 0.5F, 0.5F), EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(-1))))));
		register(context, STYPHIUM_PATCH, SBFeatures.STYPHIUM_PATCH.get(), new StyphiumPatchFeature.Configuration(PlacementUtils.inlinePlaced(configured.getOrThrow(VEGETATION_STYPHIUM)), 0.08F, 6, UniformInt.of(4, 7), 0.3F, true));
		register(context, STYPHIUM_PATCH_BONEMEAL, SBFeatures.STYPHIUM_PATCH.get(), new StyphiumPatchFeature.Configuration(PlacementUtils.inlinePlaced(configured.getOrThrow(TALL_MUSHROOMS)), 0.04F, 4, UniformInt.of(1, 2), 0.75F, false));

		register(context, ORE_EXOSKELETON, Feature.ORE, new OreConfiguration(List.of(
				OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), SBBlocks.EXOSKELETON_ORE.get().defaultBlockState()),
				OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), SBBlocks.DEEPSLATE_EXOSKELETON_ORE.get().defaultBlockState())), 3));
		register(context, ORE_OBSIDIAN, Feature.ORE, new OreConfiguration(new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD), Blocks.OBSIDIAN.defaultBlockState(), 33));
		register(context, ORE_BASALT, Feature.ORE, new OreConfiguration(new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD), Blocks.BASALT.defaultBlockState(), 64));
		register(context, ORE_PEGMATITE, Feature.ORE, new OreConfiguration(new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD), SBBlocks.PEGMATITE.get().defaultBlockState(), 64));

		register(context, ANT_MOUND_MUD, SBFeatures.ANT_MOUND.get(), new AntMoundFeature.Configuration(BlockStateProvider.simple(Blocks.PACKED_MUD), BlockStateProvider.simple(SBBlocks.ANTHILL.get()), UniformInt.of(3, 7), UniformInt.of(2, 5)));
		register(context, ANT_MOUND_RUDOSOL, SBFeatures.ANT_MOUND.get(), new AntMoundFeature.Configuration(BlockStateProvider.simple(SBBlocks.RUDOSOL.get()), BlockStateProvider.simple(SBBlocks.ANTHILL.get()), UniformInt.of(3, 7), UniformInt.of(2, 5)));
		register(context, MUD_PIT_SHALLOW, SBFeatures.PIT.get(), new PitFeature.Configuration(BlockStateProvider.simple(SBBlocks.CRACKED_MUD.get()), BlockStateProvider.simple(Blocks.PACKED_MUD), 8, 6, 8));
		register(context, MUD_PIT_NORMAL, SBFeatures.PIT.get(), new PitFeature.Configuration(BlockStateProvider.simple(SBBlocks.CRACKED_MUD.get()), BlockStateProvider.simple(Blocks.PACKED_MUD), 8, 14, 8));
		register(context, MUD_PIT_DEEP, SBFeatures.PIT.get(), new PitFeature.Configuration(BlockStateProvider.simple(SBBlocks.CRACKED_MUD.get()), BlockStateProvider.simple(Blocks.PACKED_MUD), 12, 28, 12));
		register(context, LAKE_LAVA_VOLCANIC, Feature.LAKE, new LakeFeature.Configuration(BlockStateProvider.simple(Blocks.LAVA.defaultBlockState()), BlockStateProvider.simple(Blocks.MAGMA_BLOCK.defaultBlockState())));
		register(context, SPRING_LAVA_VOLCANIC, Feature.SPRING, new SpringConfiguration(Fluids.LAVA.defaultFluidState(), true, 4, 1, HolderSet.direct(Block::builtInRegistryHolder, Blocks.BASALT, Blocks.MAGMA_BLOCK, Blocks.SMOOTH_BASALT, Blocks.BLACKSTONE, Blocks.OBSIDIAN)));
	}

	private static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, name));
	}

	private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
		context.register(key, new ConfiguredFeature<>(feature, config));
	}
}