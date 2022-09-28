package net.invictusslayer.slayersbeasts.world.feature.tree;

import net.invictusslayer.slayersbeasts.world.feature.ModConfiguredFeatures;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class CajoleTreeGrower extends AbstractTreeGrower {
    @Override
    @Nullable
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pLargeHive) {
        return ModConfiguredFeatures.CAJOLE_TREE.getHolder().get();
    }
}
