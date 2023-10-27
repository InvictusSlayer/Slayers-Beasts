package net.invictusslayer.slayersbeasts.world.feature.tree.grower;

import net.invictusslayer.slayersbeasts.world.feature.SBConfiguredFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class AspenGrower extends AbstractTreeGrower {
	protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean hasFlowers) {
		return random.nextFloat() < 0.8F ? SBConfiguredFeatures.ASPEN : SBConfiguredFeatures.SUPER_ASPEN;
	}
}
