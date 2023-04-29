package net.invictusslayer.slayersbeasts.world.feature;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.ModBlocks;
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
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

import static net.invictusslayer.slayersbeasts.world.feature.ModOrePlacement.commonOrePlacement;
import static net.invictusslayer.slayersbeasts.world.feature.ModOrePlacement.rareOrePlacement;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> ASPEN_CHECKED = createKey("aspen_checked");
    public static final ResourceKey<PlacedFeature> ASPEN_PLACED = createKey("aspen_placed");
    public static final ResourceKey<PlacedFeature> CAJOLE_CHECKED = createKey("cajole_checked");
    public static final ResourceKey<PlacedFeature> CAJOLE_PLACED = createKey("cajole_placed");
    public static final ResourceKey<PlacedFeature> EUCALYPTUS_CHECKED = createKey("eucalyptus_checked");
    public static final ResourceKey<PlacedFeature> EUCALYPTUS_PLACED = createKey("eucalyptus_placed");
    public static final ResourceKey<PlacedFeature> REDWOOD_CHECKED = createKey("redwood_checked");
    public static final ResourceKey<PlacedFeature> REDWOOD_PLACED = createKey("redwood_placed");
    public static final ResourceKey<PlacedFeature> GIANT_REDWOOD_CHECKED = createKey("giant_redwood_checked");
    public static final ResourceKey<PlacedFeature> GIANT_REDWOOD_PLACED = createKey("giant_redwood_placed");

    public static final ResourceKey<PlacedFeature> HUGE_WHITE_MUSHROOM_CHECKED = createKey("huge_white_mushroom_checked");
    public static final ResourceKey<PlacedFeature> HUGE_WHITE_MUSHROOM_PLACED = createKey("huge_white_mushroom_placed");

    public static final ResourceKey<PlacedFeature> EXOSKELETON_ORE_PLACED = createKey("exoskeleton_ore_placed");
    public static final ResourceKey<PlacedFeature> LUSH_EXOSKELETON_ORE_PLACED = createKey("lush_exoskeleton_ore_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, ASPEN_CHECKED, configuredFeatures.getOrThrow(ModConfiguredFeatures.ASPEN), List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.ASPEN_SAPLING.get())));
        register(context, ASPEN_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.ASPEN), VegetationPlacements.treePlacement(PlacementUtils.countExtra(10, 0.1f, 1), ModBlocks.ASPEN_SAPLING.get()));
        register(context, CAJOLE_CHECKED, configuredFeatures.getOrThrow(ModConfiguredFeatures.CAJOLE), List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.CAJOLE_SAPLING.get())));
        register(context, CAJOLE_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.CAJOLE), VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 1), ModBlocks.CAJOLE_SAPLING.get()));
        register(context, EUCALYPTUS_CHECKED, configuredFeatures.getOrThrow(ModConfiguredFeatures.EUCALYPTUS), List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.EUCALYPTUS_SAPLING.get())));
        register(context, EUCALYPTUS_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.EUCALYPTUS), VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.1f, 1), ModBlocks.EUCALYPTUS_SAPLING.get()));
        register(context, REDWOOD_CHECKED, configuredFeatures.getOrThrow(ModConfiguredFeatures.REDWOOD), List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.REDWOOD_SAPLING.get())));
        register(context, REDWOOD_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.REDWOOD), VegetationPlacements.treePlacement(PlacementUtils.countExtra(10, 0.1f, 1), ModBlocks.REDWOOD_SAPLING.get()));
        register(context, GIANT_REDWOOD_CHECKED, configuredFeatures.getOrThrow(ModConfiguredFeatures.GIANT_REDWOOD), List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.REDWOOD_SAPLING.get())));
        register(context, GIANT_REDWOOD_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.GIANT_REDWOOD), VegetationPlacements.treePlacement(PlacementUtils.countExtra(10, 0.1f, 1), ModBlocks.REDWOOD_SAPLING.get()));

        register(context, HUGE_WHITE_MUSHROOM_CHECKED, configuredFeatures.getOrThrow(ModConfiguredFeatures.HUGE_WHITE_MUSHROOM), List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.WHITE_MUSHROOM.get())));
        register(context, HUGE_WHITE_MUSHROOM_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.HUGE_WHITE_MUSHROOM), List.of(InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        register(context, EXOSKELETON_ORE_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_EXOSKELETON_ORE_KEY),
                rareOrePlacement(1, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
        register(context, LUSH_EXOSKELETON_ORE_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_EXOSKELETON_ORE_KEY),
                commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(64))));
    }

    public static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(SlayersBeasts.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                 Holder<ConfiguredFeature<?, ?>> config, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(config, List.copyOf(modifiers)));
    }
}
