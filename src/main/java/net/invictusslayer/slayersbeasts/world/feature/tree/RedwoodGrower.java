package net.invictusslayer.slayersbeasts.world.feature.tree;

import net.invictusslayer.slayersbeasts.world.feature.ModConfiguredFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class RedwoodGrower extends AbstractUltraTreeGrower {
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pHasFlowers) {
        return ModConfiguredFeatures.REDWOOD;
    }

    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredMegaFeature(RandomSource pRandom) {
        return ModConfiguredFeatures.GIANT_REDWOOD;
    }

    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredUltraFeature(RandomSource pRandom) {
        return ModConfiguredFeatures.COLOSSAL_REDWOOD;
    }
}
