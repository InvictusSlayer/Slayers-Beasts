package net.invictusslayer.slayersbeasts.common.world.feature.tree.foliage;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.invictusslayer.slayersbeasts.common.init.SBFoliagePlacers;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class PointedFoliagePlacer extends FoliagePlacer {
	public static final Codec<PointedFoliagePlacer> CODEC = RecordCodecBuilder.create(instance -> foliagePlacerParts(instance).and(
			Codec.BOOL.fieldOf("tall").forGetter(placer -> placer.tall))
			.apply(instance, PointedFoliagePlacer::new));
	private final boolean tall;

	public PointedFoliagePlacer(IntProvider radius, IntProvider offset, boolean tall) {
		super(radius, offset);
		this.tall = tall;
	}

	protected FoliagePlacerType<?> type() {
		return SBFoliagePlacers.POINTED_FOLIAGE_PLACER.get();
	}

	protected void createFoliage(LevelSimulatedReader level, FoliageSetter blockSetter, RandomSource random, TreeConfiguration config, int maxFreeTreeHeight, FoliageAttachment attachment, int foliageHeight, int foliageRadius, int offset) {
		BlockPos pos = attachment.pos();

		if (tall) {
			placeLeavesRow(level, blockSetter, random, config, pos, 0, 3, false);
			placeLeavesRow(level, blockSetter, random, config, pos, 0, 2, false);
			placeLeavesRow(level, blockSetter, random, config, pos, 0, 1, false);
			placeLeavesRow(level, blockSetter, random, config, pos, 1, 0, false);
			placeLeavesRow(level, blockSetter, random, config, pos, 1, -1, false);
			placeLeavesRow(level, blockSetter, random, config, pos, 1, -2, false);
			placeLeavesRow(level, blockSetter, random, config, pos, 1, -3, false);
			placeLeavesRow(level, blockSetter, random, config, pos, 2, -4, false);
			placeLeavesRow(level, blockSetter, random, config, pos, 2, -5, false);
			placeLeavesRow(level, blockSetter, random, config, pos, 2, -6, false);
			placeLeavesRow(level, blockSetter, random, config, pos, 2, -7, false);
			placeLeavesRow(level, blockSetter, random, config, pos, 1, -8, false);
			placeLeavesRow(level, blockSetter, random, config, pos, 1, -9, false);
			placeLeavesRow(level, blockSetter, random, config, pos, 1, -10, false);
		} else {
			if (random.nextBoolean()) placeLeavesRow(level, blockSetter, random, config, pos, 0, 2, false);
			placeLeavesRow(level, blockSetter, random, config, pos, 0, 1, false);
			placeLeavesRow(level, blockSetter, random, config, pos, 1, 0, false);
			placeLeavesRow(level, blockSetter, random, config, pos, 1, -1, false);
			placeLeavesRow(level, blockSetter, random, config, pos, 2, -2, false);
			placeLeavesRow(level, blockSetter, random, config, pos, 2, -3, false);
			placeLeavesRow(level, blockSetter, random, config, pos, 2, -4, false);
			placeLeavesRow(level, blockSetter, random, config, pos, 1, -5, false);
		}
	}

	public int foliageHeight(RandomSource random, int height, TreeConfiguration config) {
		return tall ? 4 : 2;
	}

	protected boolean shouldSkipLocation(RandomSource random, int x, int y, int z, int range, boolean large) {
		if (tall && (y == -3 || y == -8)) return false;
		return x * x + z * z > range * range;
	}
}
