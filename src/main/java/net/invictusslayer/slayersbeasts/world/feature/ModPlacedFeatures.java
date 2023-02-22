package net.invictusslayer.slayersbeasts.world.feature;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.init.ModBlocks;
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
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

import static net.invictusslayer.slayersbeasts.world.feature.ModOrePlacement.commonOrePlacement;
import static net.invictusslayer.slayersbeasts.world.feature.ModOrePlacement.rareOrePlacement;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> CAJOLE_CHECKED_KEY = createKey("cajole_checked");
    public static final ResourceKey<PlacedFeature> CAJOLE_PLACED_KEY = createKey("cajole_placed");

    public static final ResourceKey<PlacedFeature> EUCALYPTUS_CHECKED_KEY = createKey("eucalyptus_checked");
    public static final ResourceKey<PlacedFeature> EUCALYPTUS_PLACED_KEY = createKey("eucalyptus_placed");

    public static final ResourceKey<PlacedFeature> EXOSKELETON_ORE_PLACED_KEY = createKey("exoskeleton_ore_placed");
    public static final ResourceKey<PlacedFeature> LUSH_EXOSKELETON_ORE_PLACED_KEY = createKey("lush_exoskeleton_ore_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, CAJOLE_CHECKED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CAJOLE_KEY),
                List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.CAJOLE_SAPLING.get())));
        register(context, CAJOLE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CAJOLE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 1)));

        register(context, EUCALYPTUS_CHECKED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.EUCALYPTUS_KEY),
                List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.EUCALYPTUS_SAPLING.get())));
        register(context, EUCALYPTUS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.EUCALYPTUS_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 1)));

        register(context, EXOSKELETON_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_EXOSKELETON_ORE_KEY),
                rareOrePlacement(1, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
        register(context, LUSH_EXOSKELETON_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_EXOSKELETON_ORE_KEY),
                commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(64))));
    }

    public static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(SlayersBeasts.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                 Holder<ConfiguredFeature<?, ?>> config, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(config, List.copyOf(modifiers)));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                 Holder<ConfiguredFeature<?, ?>> config, PlacementModifier... modifiers) {
        register(context, key, config, List.of(modifiers));
    }
}
