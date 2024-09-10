package net.invictusslayer.slayersbeasts.common.world.feature.tree.foliage;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.invictusslayer.slayersbeasts.common.init.SBFoliagePlacers;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class EucalyptusFoliagePlacer extends FoliagePlacer {
	public static final MapCodec<EucalyptusFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(instance -> foliagePlacerParts(instance)
			.apply(instance, EucalyptusFoliagePlacer::new));

	public EucalyptusFoliagePlacer(IntProvider radius, IntProvider offset) {
		super(radius, offset);
	}

	protected FoliagePlacerType<?> type() {
		return SBFoliagePlacers.EUCALYPTUS_FOLIAGE_PLACER.get();
	}

	protected void createFoliage(LevelSimulatedReader level, FoliageSetter foliageSetter, RandomSource random, TreeConfiguration config, int maxFreeTreeHeight, FoliageAttachment attachment, int foliageHeight, int foliageRadius, int offset) {
		boolean flag = attachment.doubleTrunk();
		BlockPos pos = attachment.pos().above(offset);

		placeLeavesRow(level, foliageSetter, random, config, pos, foliageRadius + attachment.radiusOffset() - 1, -3, flag);
		placeLeavesRow(level, foliageSetter, random, config, pos, foliageRadius + attachment.radiusOffset(), -1, flag);
		placeLeavesRow(level, foliageSetter, random, config, pos, foliageRadius + attachment.radiusOffset() - 1, 0, flag);
	}

	public int foliageHeight(RandomSource random, int height, TreeConfiguration config) {
		return 0;
	}

	protected boolean shouldSkipLocation(RandomSource random, int x, int y, int z, int range, boolean large) {
		if (y == 0) return (x > 1 || z > 1) && x != 0 && z != 0;
		return x == range && z == range && range > 0;
	}
}
