package net.invictusslayer.slayersbeasts.world.feature;

import com.google.common.collect.ImmutableList;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.SBBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ClampedNormalInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.heightproviders.VeryBiasedToBottomHeight;
import net.minecraft.world.level.levelgen.placement.*;

import javax.annotation.Nullable;
import java.util.List;

public class SBPlacedFeatures {
    //Tree
    public static final ResourceKey<PlacedFeature> ASPEN_CHECKED = createKey("aspen_checked");
    public static final ResourceKey<PlacedFeature> CAJOLE_CHECKED = createKey("cajole_checked");
    public static final ResourceKey<PlacedFeature> DESERT_OAK_CHECKED = createKey("desert_oak_checked");
    public static final ResourceKey<PlacedFeature> EUCALYPTUS_CHECKED = createKey("eucalyptus_checked");
    public static final ResourceKey<PlacedFeature> GIANT_KAPOK_CHECKED = createKey("giant_kapok_checked");
    public static final ResourceKey<PlacedFeature> REDWOOD_CHECKED = createKey("redwood_checked");
    public static final ResourceKey<PlacedFeature> GIANT_REDWOOD_CHECKED = createKey("giant_redwood_checked");
    public static final ResourceKey<PlacedFeature> COLOSSAL_REDWOOD_CHECKED = createKey("colossal_redwood_checked");
    public static final ResourceKey<PlacedFeature> GIANT_WILLOW_CHECKED = createKey("giant_willow_checked");

    //Vegetation
    public static final ResourceKey<PlacedFeature> TREES_ASPEN = createKey("trees_aspen");
    public static final ResourceKey<PlacedFeature> TREES_BRUSH = createKey("trees_brush");
    public static final ResourceKey<PlacedFeature> TREES_WOODED_BRUSH = createKey("trees_wooded_brush");
    public static final ResourceKey<PlacedFeature> TREES_EUCALYPT = createKey("trees_eucalypt");
    public static final ResourceKey<PlacedFeature> TREES_INKY = createKey("trees_inky");
    public static final ResourceKey<PlacedFeature> TREES_OUTBACK = createKey("trees_outback");
    public static final ResourceKey<PlacedFeature> TREES_RAINFOREST = createKey("trees_rainforest");
    public static final ResourceKey<PlacedFeature> TREES_REDWOOD = createKey("trees_redwood");
    public static final ResourceKey<PlacedFeature> TREES_OLD_GROWTH_REDWOOD = createKey("trees_old_growth_redwood");
    public static final ResourceKey<PlacedFeature> PATCH_TALL_DEAD_BUSH = createKey("patch_tall_dead_bush");
    public static final ResourceKey<PlacedFeature> PATCH_TALL_DEAD_BUSH_BRUSH = createKey("patch_tall_dead_bush_brush");
    public static final ResourceKey<PlacedFeature> WHITE_MUSHROOM_COMMON = createKey("white_mushroom_common");
    public static final ResourceKey<PlacedFeature> WHITE_MUSHROOM_RARE = createKey("white_mushroom_rare");

    //Cave
    public static final ResourceKey<PlacedFeature> ICICLE_CLUSTER = createKey("icicle_cluster");
    public static final ResourceKey<PlacedFeature> LARGE_ICICLE = createKey("large_icicle");
    public static final ResourceKey<PlacedFeature> ICICLE = createKey("icicle");

    //Ore
    public static final ResourceKey<PlacedFeature> ORE_EXOSKELETON = createKey("ore_exoskeleton");
    public static final ResourceKey<PlacedFeature> ORE_EXOSKELETON_LUSH = createKey("ore_exoskeleton_lush");
    public static final ResourceKey<PlacedFeature> ORE_OBSIDIAN = createKey("ore_obsidian");
    public static final ResourceKey<PlacedFeature> ORE_PEGMATITE_UPPER = createKey("ore_pegmatite_upper");
    public static final ResourceKey<PlacedFeature> ORE_PEGMATITE_LOWER = createKey("ore_pegmatite_lower");
    public static final ResourceKey<PlacedFeature> ORE_BASALT_VOLCANIC = createKey("ore_basalt_volcanic");
    public static final ResourceKey<PlacedFeature> ORE_GRANITE_VOLCANIC = createKey("ore_granite_volcanic");
    public static final ResourceKey<PlacedFeature> ORE_PEGMATITE_VOLCANIC = createKey("ore_pegmatite_volcanic");

    //Miscellaneous
    public static final ResourceKey<PlacedFeature> MUD_PIT_SHALLOW = createKey("mud_pit_shallow");
    public static final ResourceKey<PlacedFeature> MUD_PIT_NORMAL = createKey("mud_pit_normal");
    public static final ResourceKey<PlacedFeature> MUD_PIT_DEEP = createKey("mud_pit_deep");
    public static final ResourceKey<PlacedFeature> LAKE_LAVA_VOLCANIC = createKey("lake_lava_volcanic");
    public static final ResourceKey<PlacedFeature> SPRING_LAVA_VOLCANIC = createKey("spring_lava_volcanic");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configured = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, ASPEN_CHECKED, configured.getOrThrow(SBConfiguredFeatures.ASPEN), PlacementUtils.filteredByBlockSurvival(SBBlocks.ASPEN_SAPLING.get()));
        register(context, CAJOLE_CHECKED, configured.getOrThrow(SBConfiguredFeatures.CAJOLE), PlacementUtils.filteredByBlockSurvival(SBBlocks.CAJOLE_SAPLING.get()));
        register(context, DESERT_OAK_CHECKED, configured.getOrThrow(SBConfiguredFeatures.DESERT_OAK), PlacementUtils.filteredByBlockSurvival(SBBlocks.DESERT_OAK_SAPLING.get()));
        register(context, EUCALYPTUS_CHECKED, configured.getOrThrow(SBConfiguredFeatures.EUCALYPTUS), PlacementUtils.filteredByBlockSurvival(SBBlocks.EUCALYPTUS_SAPLING.get()));
        register(context, GIANT_KAPOK_CHECKED, configured.getOrThrow(SBConfiguredFeatures.GIANT_KAPOK), PlacementUtils.filteredByBlockSurvival(SBBlocks.KAPOK_SAPLING.get()));
        register(context, REDWOOD_CHECKED, configured.getOrThrow(SBConfiguredFeatures.REDWOOD), PlacementUtils.filteredByBlockSurvival(SBBlocks.REDWOOD_SAPLING.get()));
        register(context, GIANT_REDWOOD_CHECKED, configured.getOrThrow(SBConfiguredFeatures.GIANT_REDWOOD), PlacementUtils.filteredByBlockSurvival(SBBlocks.REDWOOD_SAPLING.get()));
        register(context, COLOSSAL_REDWOOD_CHECKED, configured.getOrThrow(SBConfiguredFeatures.COLOSSAL_REDWOOD), PlacementUtils.filteredByBlockSurvival(SBBlocks.REDWOOD_SAPLING.get()));
        register(context, GIANT_WILLOW_CHECKED, configured.getOrThrow(SBConfiguredFeatures.GIANT_WILLOW), PlacementUtils.filteredByBlockSurvival(SBBlocks.WILLOW_SAPLING.get()));

        register(context, TREES_ASPEN, configured.getOrThrow(SBConfiguredFeatures.TREES_ASPEN), VegetationPlacements.treePlacement(PlacementUtils.countExtra(10, 0.2f, 3), SBBlocks.ASPEN_SAPLING.get()));
        register(context, TREES_BRUSH, configured.getOrThrow(SBConfiguredFeatures.TREES_BRUSH), VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 1)));
        register(context, TREES_WOODED_BRUSH, configured.getOrThrow(SBConfiguredFeatures.TREES_BRUSH), VegetationPlacements.treePlacement(PlacementUtils.countExtra(10, 0.2f, 3)));
        register(context, TREES_EUCALYPT, configured.getOrThrow(SBConfiguredFeatures.TREES_EUCALYPT), VegetationPlacements.treePlacement(PlacementUtils.countExtra(6, 0.1f, 1), SBBlocks.EUCALYPTUS_SAPLING.get()));
        register(context, TREES_INKY, configured.getOrThrow(SBConfiguredFeatures.TREES_INKY), VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 1)));
        register(context, TREES_OUTBACK, configured.getOrThrow(SBConfiguredFeatures.TREES_OUTBACK), VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 1)));
        register(context, TREES_RAINFOREST, configured.getOrThrow(SBConfiguredFeatures.TREES_RAINFOREST), VegetationPlacements.treePlacement(PlacementUtils.countExtra(10, 0.1f, 1)));
        register(context, TREES_REDWOOD, configured.getOrThrow(SBConfiguredFeatures.TREES_REDWOOD), VegetationPlacements.treePlacement(PlacementUtils.countExtra(10, 0.1f, 1), SBBlocks.REDWOOD_SAPLING.get()));
        register(context, TREES_OLD_GROWTH_REDWOOD, configured.getOrThrow(SBConfiguredFeatures.TREES_OLD_GROWTH_REDWOOD), VegetationPlacements.treePlacement(PlacementUtils.countExtra(10, 0.1f, 1), SBBlocks.REDWOOD_SAPLING.get()));
        register(context, PATCH_TALL_DEAD_BUSH, configured.getOrThrow(SBConfiguredFeatures.PATCH_TALL_DEAD_BUSH), RarityFilter.onAverageOnceEvery(5), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, PATCH_TALL_DEAD_BUSH_BRUSH, configured.getOrThrow(SBConfiguredFeatures.PATCH_TALL_DEAD_BUSH), VegetationPlacements.worldSurfaceSquaredWithCount(10));
        register(context, WHITE_MUSHROOM_COMMON, configured.getOrThrow(SBConfiguredFeatures.PATCH_WHITE_MUSHROOM), mushroomPlacement(4, CountPlacement.of(3)));
        register(context, WHITE_MUSHROOM_RARE, configured.getOrThrow(SBConfiguredFeatures.PATCH_WHITE_MUSHROOM), mushroomPlacement(256, null));

        register(context, ICICLE_CLUSTER, configured.getOrThrow(SBConfiguredFeatures.ICICLE_CLUSTER), CountPlacement.of(UniformInt.of(48, 96)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome());
        register(context, LARGE_ICICLE, configured.getOrThrow(SBConfiguredFeatures.LARGE_ICICLE), CountPlacement.of(UniformInt.of(10, 48)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome());
        register(context, ICICLE, configured.getOrThrow(SBConfiguredFeatures.ICICLE), CountPlacement.of(UniformInt.of(192, 256)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, CountPlacement.of(UniformInt.of(1, 5)), RandomOffsetPlacement.of(ClampedNormalInt.of(0.0F, 3.0F, -10, 10), ClampedNormalInt.of(0.0F, 0.6F, -2, 2)), BiomeFilter.biome());

        register(context, ORE_EXOSKELETON, configured.getOrThrow(SBConfiguredFeatures.ORE_EXOSKELETON), rareOrePlacement(1, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
        register(context, ORE_EXOSKELETON_LUSH, configured.getOrThrow(SBConfiguredFeatures.ORE_EXOSKELETON), commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(64))));
        register(context, ORE_OBSIDIAN, configured.getOrThrow(SBConfiguredFeatures.ORE_OBSIDIAN), commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(160))));
        register(context, ORE_PEGMATITE_UPPER, configured.getOrThrow(SBConfiguredFeatures.ORE_PEGMATITE), rareOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(128))));
        register(context, ORE_PEGMATITE_LOWER, configured.getOrThrow(SBConfiguredFeatures.ORE_PEGMATITE), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60))));
        register(context, ORE_BASALT_VOLCANIC, configured.getOrThrow(SBConfiguredFeatures.ORE_BASALT), commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(160))));
        register(context, ORE_GRANITE_VOLCANIC, configured.getOrThrow(OreFeatures.ORE_GRANITE), commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(160))));
        register(context, ORE_PEGMATITE_VOLCANIC, configured.getOrThrow(SBConfiguredFeatures.ORE_PEGMATITE), commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(160))));

        register(context, MUD_PIT_SHALLOW, configured.getOrThrow(SBConfiguredFeatures.MUD_PIT_SHALLOW), List.of(RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, MUD_PIT_NORMAL, configured.getOrThrow(SBConfiguredFeatures.MUD_PIT_NORMAL), List.of(RarityFilter.onAverageOnceEvery(6), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, MUD_PIT_DEEP, configured.getOrThrow(SBConfiguredFeatures.MUD_PIT_DEEP), List.of(RarityFilter.onAverageOnceEvery(9), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, LAKE_LAVA_VOLCANIC, configured.getOrThrow(SBConfiguredFeatures.LAKE_LAVA_VOLCANIC), List.of(RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, SPRING_LAVA_VOLCANIC, configured.getOrThrow(SBConfiguredFeatures.SPRING_LAVA_VOLCANIC), List.of(CountPlacement.of(20), InSquarePlacement.spread(), HeightRangePlacement.of(VeryBiasedToBottomHeight.of(VerticalAnchor.bottom(), VerticalAnchor.belowTop(8), 8)), BiomeFilter.biome()));
    }

    private static List<PlacementModifier> mushroomPlacement(int rarity, @Nullable PlacementModifier pPlacement) {
        ImmutableList.Builder<PlacementModifier> builder = ImmutableList.builder();
        if (pPlacement != null) {
            builder.add(pPlacement);
        }
        if (rarity != 0) {
            builder.add(RarityFilter.onAverageOnceEvery(rarity));
        }
        builder.add(InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        return builder.build();
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier rarity, PlacementModifier placementModifier) {
        return List.of(rarity, InSquarePlacement.spread(), placementModifier, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int veinsPerChunk, PlacementModifier placementModifier) {
        return orePlacement(CountPlacement.of(veinsPerChunk), placementModifier);
    }

    private static List<PlacementModifier> rareOrePlacement(int chunksPerVein, PlacementModifier placementModifier) {
        return orePlacement(RarityFilter.onAverageOnceEvery(chunksPerVein), placementModifier);
    }

    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(SlayersBeasts.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> config, PlacementModifier... modifiers) {
        register(context, key, config, List.of(modifiers));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> config, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(config, modifiers));
    }
}
