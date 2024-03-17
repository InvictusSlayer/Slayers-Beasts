package net.invictusslayer.slayersbeasts.common.world.feature.tree.foliage;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.invictusslayer.slayersbeasts.common.init.SBFoliagePlacers;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class WillowFoliagePlacer extends FoliagePlacer {
	public static final Codec<WillowFoliagePlacer> CODEC = RecordCodecBuilder.create(instance -> foliagePlacerParts(instance)
			.apply(instance, WillowFoliagePlacer::new));

	public WillowFoliagePlacer(IntProvider radius, IntProvider offset) {
		super(radius, offset);
	}

	protected FoliagePlacerType<?> type() {
		return SBFoliagePlacers.WILLOW_FOLIAGE_PLACER.get();
	}

	protected void createFoliage(LevelSimulatedReader level, FoliageSetter foliageSetter, RandomSource random, TreeConfiguration config, int maxFreeTreeHeight, FoliageAttachment attachment, int foliageHeight, int foliageRadius, int offset) {
		int i = attachment.doubleTrunk() ? foliageHeight : 1 + random.nextInt(2);

		for (int j = offset; j >= offset - i; --j) {
			int k = foliageRadius + attachment.radiusOffset() + 1 - j;
			placeLeavesRowWithHangingLeavesBelow(level, foliageSetter, random, config, attachment.pos(), k, j, attachment.doubleTrunk(), 0.3F, 0.8F);
		}
	}

	public int foliageHeight(RandomSource random, int height, TreeConfiguration config) {
		return 2;
	}

	protected boolean shouldSkipLocation(RandomSource random, int x, int y, int z, int range, boolean large) {
		return x * x + z * z > range * range;
	}
}
