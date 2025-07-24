package net.invictusslayer.slayersbeasts.block;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public interface IExtendedMushroomBlock {
	void setMightyMushroom(ResourceKey<ConfiguredFeature<?, ?>> mightyMushroom);
}
