package net.invictusslayer.slayersbeasts.common.world.feature.tree.grower;

import net.invictusslayer.slayersbeasts.common.world.feature.SBConfiguredFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class WillowGrower extends AbstractMegaTreeGrower {
	protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean hasFlowers) {
		return null;
	}

	protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredMegaFeature(RandomSource random) {
		return SBConfiguredFeatures.GIANT_WILLOW;
	}
}
