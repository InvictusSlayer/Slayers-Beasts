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

public class CajoleFoliagePlacer extends FoliagePlacer {
	public static final MapCodec<CajoleFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(instance -> foliagePlacerParts(instance)
			.apply(instance, CajoleFoliagePlacer::new));

	public CajoleFoliagePlacer(IntProvider radius, IntProvider offset) {
		super(radius, offset);
	}
	
	protected FoliagePlacerType<?> type() {
		return SBFoliagePlacers.CAJOLE_FOLIAGE_PLACER.get();
	}

	protected void createFoliage(LevelSimulatedReader level, FoliageSetter blockSetter, RandomSource random, TreeConfiguration config, int maxFreeTreeHeight, FoliageAttachment attachment, int foliageHeight, int foliageRadius, int offset) {
		boolean flag = attachment.doubleTrunk();
		BlockPos pos = attachment.pos().above(offset);

		placeLeavesRow(level, blockSetter, random, config, pos, 0, -2, flag);
		placeLeavesRow(level, blockSetter, random, config, pos, foliageRadius + attachment.radiusOffset() - 1, -1, flag);
		placeLeavesRow(level, blockSetter, random, config, pos, foliageRadius - 1, 0, flag);
		placeLeavesRow(level, blockSetter, random, config, pos, foliageRadius + attachment.radiusOffset() - 1, 0, flag);
		placeLeavesRow(level, blockSetter, random, config, pos, 0, 1, flag);
	}

	public int foliageHeight(RandomSource random, int height, TreeConfiguration config) {
		return 0;
	}

	protected boolean shouldSkipLocation(RandomSource random, int x, int y, int z, int range, boolean large) {
		if (y == 0) return (x > 1 || z > 1) && x != 0 && z != 0;
		return x == range && z == range && range > 0;
	}
}
