package net.invictusslayer.slayersbeasts.world.feature;

import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModOrePlacement {
    public static List<PlacementModifier> orePlacement(PlacementModifier placementModifier, PlacementModifier placementModifier1) {
        return List.of(placementModifier, InSquarePlacement.spread(), placementModifier1, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int veinsPerChunk, PlacementModifier placementModifier) {
        return orePlacement(CountPlacement.of(veinsPerChunk), placementModifier);
    }

    public static List<PlacementModifier> rareOrePlacement(int chunksPerVein, PlacementModifier placementModifier) {
        return orePlacement(RarityFilter.onAverageOnceEvery(chunksPerVein), placementModifier);
    }
}
