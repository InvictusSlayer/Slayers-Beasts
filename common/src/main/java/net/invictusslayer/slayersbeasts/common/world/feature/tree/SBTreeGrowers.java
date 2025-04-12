package net.invictusslayer.slayersbeasts.common.world.feature.tree;

import net.invictusslayer.slayersbeasts.common.world.feature.SBConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class SBTreeGrowers {
	public static final TreeGrower ASPEN = new TreeGrower("aspen", 0.1F, Optional.empty(), Optional.empty(), Optional.of(SBConfiguredFeatures.ASPEN), Optional.of(SBConfiguredFeatures.SUPER_ASPEN), Optional.empty(), Optional.empty());
	public static final TreeGrower BLOODWOOD = new TreeGrower("bloodwood", 0.1F, Optional.empty(), Optional.empty(), Optional.of(SBConfiguredFeatures.BLOODWOOD), Optional.empty(), Optional.empty(), Optional.empty());
	public static final TreeGrower CAJOLE = new TreeGrower("cajole", Optional.empty(), Optional.of(SBConfiguredFeatures.CAJOLE), Optional.empty());
	public static final TreeGrower DESERT_OAK = new TreeGrower("desert_oak", 0.2F, Optional.empty(), Optional.empty(), Optional.of(SBConfiguredFeatures.DESERT_OAK), Optional.of(SBConfiguredFeatures.SUPER_DESERT_OAK), Optional.empty(), Optional.empty());
	public static final TreeGrower EUCALYPTUS = new TreeGrower("eucalyptus", Optional.empty(), Optional.of(SBConfiguredFeatures.EUCALYPTUS), Optional.empty());
	public static final TreeGrower KAPOK = new TreeGrower("kapok", Optional.of(SBConfiguredFeatures.GIANT_KAPOK), Optional.empty(), Optional.empty());
	public static final TreeGrower REDWOOD = new TreeGrower("redwood", Optional.of(SBConfiguredFeatures.GIANT_REDWOOD), Optional.of(SBConfiguredFeatures.REDWOOD), Optional.empty());
	public static final TreeGrower ALBINO_REDWOOD = new TreeGrower("albino_redwood", Optional.of(SBConfiguredFeatures.GIANT_ALBINO_REDWOOD), Optional.of(SBConfiguredFeatures.ALBINO_REDWOOD), Optional.empty());
	public static final TreeGrower WILLOW = new TreeGrower("willow", Optional.of(SBConfiguredFeatures.GIANT_WILLOW), Optional.empty(), Optional.empty());
}
