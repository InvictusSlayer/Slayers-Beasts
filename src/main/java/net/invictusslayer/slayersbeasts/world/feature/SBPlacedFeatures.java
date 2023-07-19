package net.invictusslayer.slayersbeasts.world.feature;

import com.google.common.collect.ImmutableList;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.SBBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.heightproviders.VeryBiasedToBottomHeight;
import net.minecraft.world.level.levelgen.placement.*;

import javax.annotation.Nullable;
import java.util.List;

import static net.invictusslayer.slayersbeasts.world.feature.SBOrePlacement.commonOrePlacement;
import static net.invictusslayer.slayersbeasts.world.feature.SBOrePlacement.rareOrePlacement;

public class SBPlacedFeatures {
    //TREE
    public static final ResourceKey<PlacedFeature> ASPEN_CHECKED = createKey("aspen_checked");
    public static final ResourceKey<PlacedFeature> CAJOLE_CHECKED = createKey("cajole_checked");
    public static final ResourceKey<PlacedFeature> DESERT_OAK_CHECKED = createKey("desert_oak_checked");
    public static final ResourceKey<PlacedFeature> EUCALYPTUS_CHECKED = createKey("eucalyptus_checked");
    public static final ResourceKey<PlacedFeature> KAPOK_CHECKED = createKey("kapok_checked");
    public static final ResourceKey<PlacedFeature> REDWOOD_CHECKED = createKey("redwood_checked");
    public static final ResourceKey<PlacedFeature> GIANT_REDWOOD_CHECKED = createKey("giant_redwood_checked");
    public static final ResourceKey<PlacedFeature> COLOSSAL_REDWOOD_CHECKED = createKey("colossal_redwood_checked");

    //VEGETATION
    public static final ResourceKey<PlacedFeature> TREES_ASPEN = createKey("trees_aspen");
    public static final ResourceKey<PlacedFeature> TREES_INKY = createKey("trees_inky");
    public static final ResourceKey<PlacedFeature> TREES_RAINFOREST = createKey("trees_rainforest");
    public static final ResourceKey<PlacedFeature> TREES_EUCALYPT = createKey("trees_eucalypt");
    public static final ResourceKey<PlacedFeature> TREES_OUTBACK = createKey("trees_outback");
    public static final ResourceKey<PlacedFeature> TREES_REDWOOD = createKey("trees_redwood");
    public static final ResourceKey<PlacedFeature> TREES_OLD_GROWTH_REDWOOD = createKey("trees_old_growth_redwood");
    public static final ResourceKey<PlacedFeature> WHITE_MUSHROOM_COMMON = createKey("white_mushroom_common");
    public static final ResourceKey<PlacedFeature> WHITE_MUSHROOM_RARE = createKey("white_mushroom_rare");

    //ORE
    public static final ResourceKey<PlacedFeature> EXOSKELETON_ORE_PLACED = createKey("exoskeleton_ore_placed");
    public static final ResourceKey<PlacedFeature> LUSH_EXOSKELETON_ORE_PLACED = createKey("lush_exoskeleton_ore_placed");

    //MISC
    public static final ResourceKey<PlacedFeature> LAKE_LAVA_VOLCANIC = createKey("lake_lava_volcanic");
    public static final ResourceKey<PlacedFeature> SPRING_LAVA_VOLCANIC = createKey("spring_lava_volcanic");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configured = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, ASPEN_CHECKED, configured.getOrThrow(SBConfiguredFeatures.ASPEN), List.of(PlacementUtils.filteredByBlockSurvival(SBBlocks.ASPEN_SAPLING.get())));
        register(context, CAJOLE_CHECKED, configured.getOrThrow(SBConfiguredFeatures.CAJOLE), List.of(PlacementUtils.filteredByBlockSurvival(SBBlocks.CAJOLE_SAPLING.get())));
        register(context, DESERT_OAK_CHECKED, configured.getOrThrow(SBConfiguredFeatures.DESERT_OAK), List.of(PlacementUtils.filteredByBlockSurvival(SBBlocks.DESERT_OAK_SAPLING.get())));
        register(context, EUCALYPTUS_CHECKED, configured.getOrThrow(SBConfiguredFeatures.EUCALYPTUS), List.of(PlacementUtils.filteredByBlockSurvival(SBBlocks.EUCALYPTUS_SAPLING.get())));
        register(context, KAPOK_CHECKED, configured.getOrThrow(SBConfiguredFeatures.KAPOK), List.of(PlacementUtils.filteredByBlockSurvival(SBBlocks.KAPOK_SAPLING.get())));
        register(context, REDWOOD_CHECKED, configured.getOrThrow(SBConfiguredFeatures.REDWOOD), List.of(PlacementUtils.filteredByBlockSurvival(SBBlocks.REDWOOD_SAPLING.get())));
        register(context, GIANT_REDWOOD_CHECKED, configured.getOrThrow(SBConfiguredFeatures.GIANT_REDWOOD), List.of(PlacementUtils.filteredByBlockSurvival(SBBlocks.REDWOOD_SAPLING.get())));
        register(context, COLOSSAL_REDWOOD_CHECKED, configured.getOrThrow(SBConfiguredFeatures.COLOSSAL_REDWOOD), List.of(PlacementUtils.filteredByBlockSurvival(SBBlocks.REDWOOD_SAPLING.get())));

        register(context, TREES_ASPEN, configured.getOrThrow(SBConfiguredFeatures.TREES_ASPEN), VegetationPlacements.treePlacement(PlacementUtils.countExtra(10, 0.1f, 1), SBBlocks.ASPEN_SAPLING.get()));
        register(context, TREES_INKY, configured.getOrThrow(SBConfiguredFeatures.TREES_INKY), VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 1)));
        register(context, TREES_RAINFOREST, configured.getOrThrow(SBConfiguredFeatures.TREES_RAINFOREST), VegetationPlacements.treePlacement(PlacementUtils.countExtra(10, 0.1f, 1)));
        register(context, TREES_EUCALYPT, configured.getOrThrow(SBConfiguredFeatures.TREES_EUCALYPT), VegetationPlacements.treePlacement(PlacementUtils.countExtra(6, 0.1f, 1), SBBlocks.EUCALYPTUS_SAPLING.get()));
        register(context, TREES_OUTBACK, configured.getOrThrow(SBConfiguredFeatures.TREES_OUTBACK), VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.1f, 1)));
        register(context, TREES_REDWOOD, configured.getOrThrow(SBConfiguredFeatures.TREES_REDWOOD), VegetationPlacements.treePlacement(PlacementUtils.countExtra(10, 0.1f, 1), SBBlocks.REDWOOD_SAPLING.get()));
        register(context, TREES_OLD_GROWTH_REDWOOD, configured.getOrThrow(SBConfiguredFeatures.TREES_OLD_GROWTH_REDWOOD), VegetationPlacements.treePlacement(PlacementUtils.countExtra(10, 0.1f, 1)));
        register(context, WHITE_MUSHROOM_COMMON, configured.getOrThrow(SBConfiguredFeatures.PATCH_WHITE_MUSHROOM), mushroomPlacement(4, CountPlacement.of(3)));
        register(context, WHITE_MUSHROOM_RARE, configured.getOrThrow(SBConfiguredFeatures.PATCH_WHITE_MUSHROOM), mushroomPlacement(128, null));

        register(context, EXOSKELETON_ORE_PLACED, configured.getOrThrow(SBConfiguredFeatures.OVERWORLD_EXOSKELETON_ORE_KEY), rareOrePlacement(1, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
        register(context, LUSH_EXOSKELETON_ORE_PLACED, configured.getOrThrow(SBConfiguredFeatures.OVERWORLD_EXOSKELETON_ORE_KEY), commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(64))));

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

        builder.add(InSquarePlacement.spread());
        builder.add(PlacementUtils.HEIGHTMAP);
        builder.add(BiomeFilter.biome());
        return builder.build();
    }

    public static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(SlayersBeasts.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> config, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(config, List.copyOf(modifiers)));
    }
}