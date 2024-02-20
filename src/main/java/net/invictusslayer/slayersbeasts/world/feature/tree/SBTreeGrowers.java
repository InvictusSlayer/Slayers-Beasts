package net.invictusslayer.slayersbeasts.world.feature.tree;

import net.invictusslayer.slayersbeasts.world.feature.SBConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class SBTreeGrowers {
	public static TreeGrower ASPEN = new TreeGrower("aspen", 0.1F, Optional.empty(), Optional.empty(), Optional.of(SBConfiguredFeatures.ASPEN), Optional.of(SBConfiguredFeatures.SUPER_ASPEN), Optional.empty(), Optional.empty());
	public static TreeGrower CAJOLE = new TreeGrower("cajole", Optional.empty(), Optional.of(SBConfiguredFeatures.CAJOLE), Optional.empty());
	public static TreeGrower DESERT_OAK = new TreeGrower("desert_oak", 0.2F, Optional.empty(), Optional.empty(), Optional.of(SBConfiguredFeatures.DESERT_OAK), Optional.of(SBConfiguredFeatures.SUPER_DESERT_OAK), Optional.empty(), Optional.empty());
	public static TreeGrower EUCALYPTUS = new TreeGrower("eucalyptus", Optional.empty(), Optional.of(SBConfiguredFeatures.EUCALYPTUS), Optional.empty());
	public static TreeGrower KAPOK = new TreeGrower("kapok", Optional.of(SBConfiguredFeatures.GIANT_KAPOK), Optional.empty(), Optional.empty());
	public static TreeGrower REDWOOD = new TreeGrower("redwood", Optional.of(SBConfiguredFeatures.GIANT_REDWOOD), Optional.of(SBConfiguredFeatures.REDWOOD), Optional.empty());
	public static TreeGrower WILLOW = new TreeGrower("willow", Optional.of(SBConfiguredFeatures.GIANT_WILLOW), Optional.empty(), Optional.empty());
}