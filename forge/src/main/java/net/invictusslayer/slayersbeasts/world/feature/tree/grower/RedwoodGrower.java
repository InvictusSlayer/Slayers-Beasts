package net.invictusslayer.slayersbeasts.world.feature.tree.grower;

import net.invictusslayer.slayersbeasts.world.feature.SBConfiguredFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class RedwoodGrower extends AbstractUltraTreeGrower {
	protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean hasFlowers) {
		return SBConfiguredFeatures.REDWOOD;
	}

	protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredMegaFeature(RandomSource random) {
		return SBConfiguredFeatures.GIANT_REDWOOD;
	}

	protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredUltraFeature(RandomSource random) {
		return SBConfiguredFeatures.COLOSSAL_REDWOOD;
	}
}
