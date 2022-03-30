package net.invictusslayer.slayersbeasts.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModPlacedFeatures {
    public static final Holder<PlacedFeature> CAJOLE_PLACED = PlacementUtils.register("cajole_placed",
            ModConfiguredFeatures.CAJOLE_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(1, 0.1f, 1)));

    public static final Holder<PlacedFeature> EXOSKELETON_ORE_PLACED = PlacementUtils.register("exoskeleton_ore_placed",
            ModConfiguredFeatures.EXOSKELETON_ORE, ModOrePlacement.rareOrePlacement(1,
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));

    public static final Holder<PlacedFeature> LUSH_EXOSKELETON_ORE_PLACED = PlacementUtils.register("exoskeleton_ore_placed",
            ModConfiguredFeatures.EXOSKELETON_ORE, ModOrePlacement.commonOrePlacement(9,
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
}
