package net.invictusslayer.slayersbeasts.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModTreePlacement {

    public static final Holder<PlacedFeature> CAJOLE_PLACED = PlacementUtils.register("cajole_placed",
            ModTreeFeatures.CAJOLE_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(1, 0.1f, 1)));

    public static final Holder<PlacedFeature> EUCALYPTUS_PLACED = PlacementUtils.register("eucalyptus_placed",
            ModTreeFeatures.EUCALYPTUS_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(1, 0.1f, 1)));
}
