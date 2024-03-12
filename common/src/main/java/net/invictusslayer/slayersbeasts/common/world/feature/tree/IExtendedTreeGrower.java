package net.invictusslayer.slayersbeasts.common.world.feature.tree;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public interface IExtendedTreeGrower {
	void setGigaTree(ResourceKey<ConfiguredFeature<?, ?>> gigaTree);
	void setSecondaryGigaTree(ResourceKey<ConfiguredFeature<?, ?>> secondaryGigaTree);
}
