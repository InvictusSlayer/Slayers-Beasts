package net.invictusslayer.slayersbeasts.world.feature;

import com.google.common.collect.ImmutableList;
import net.invictusslayer.slayersbeasts.init.ModBlocks;
import net.invictusslayer.slayersbeasts.world.feature.tree.CajoleFoliagePlacer;
import net.invictusslayer.slayersbeasts.world.feature.tree.SpreadTrunkPlacer;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class ModConfiguredFeatures {
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> CAJOLE_TREE =
            FeatureUtils.register("cajole", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocks.CAJOLE_LOG.get()),
                    new SpreadTrunkPlacer(5, 6, 3),
                    BlockStateProvider.simple(ModBlocks.CAJOLE_LEAVES.get()),
                    new CajoleFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)),
                    new TwoLayersFeatureSize(1, 0, 2))
                    .decorators(ImmutableList.of(TrunkVineDecorator.INSTANCE, LeaveVineDecorator.INSTANCE)).ignoreVines().build());

    public static final Holder<PlacedFeature> CAJOLE_CHECKED = PlacementUtils.register("cajole_checked", CAJOLE_TREE,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.CAJOLE_SAPLING.get()));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> CAJOLE_SPAWN =
            FeatureUtils.register("cajole_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(CAJOLE_CHECKED,
                            0.5F)), CAJOLE_CHECKED));


}