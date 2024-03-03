package net.invictusslayer.slayersbeasts.world.feature.tree.foliage;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class RedwoodFoliagePlacer extends FoliagePlacer {
	public static final Codec<RedwoodFoliagePlacer> CODEC = RecordCodecBuilder.create(instance -> foliagePlacerParts(instance).and(
			instance.group(IntProvider.codec(0, 15).fieldOf("mid_segments").forGetter(placer -> placer.midSegments),
					Codec.intRange(1, 3).fieldOf("trunk_width").forGetter(placer -> placer.trunkWidth)))
			.apply(instance, RedwoodFoliagePlacer::new));
	private final IntProvider midSegments;
	private final int trunkWidth;

	public RedwoodFoliagePlacer(IntProvider radius, IntProvider offset, IntProvider midStages, int trunkWidth) {
		super(radius, offset);
		this.midSegments = midStages;
		this.trunkWidth = trunkWidth;
	}

	protected FoliagePlacerType<?> type() {
		return SBFoliagePlacers.REDWOOD_FOLIAGE_PLACER.get();
	}

	protected void createFoliage(LevelSimulatedReader level, FoliageSetter blockSetter, RandomSource random, TreeConfiguration config, int maxFreeTreeHeight, FoliageAttachment attachment, int foliageHeight, int foliageRadius, int offset) {
		BlockPos pos = attachment.pos();

		if (trunkWidth == 1) createNormal(level, blockSetter, random, config, pos);
		if (trunkWidth == 2) createMega(level, blockSetter, random, config, pos);
		if (trunkWidth == 3) createUltra(level, blockSetter, random, config, pos);
	}

	private void createNormal(LevelSimulatedReader level, FoliageSetter blockSetter, RandomSource random, TreeConfiguration config, BlockPos pos) {
		int y = -4;

		placeLeavesRow(level, blockSetter, random, config, pos, 0, 1, false);
		placeLeavesRow(level, blockSetter, random, config, pos, 0, 0, false);
		placeLeavesRow(level, blockSetter, random, config, pos, 1, -1, false);
		placeLeavesRow(level, blockSetter, random, config, pos, 1, -2, false);

		for (int s = 1; s <= midSegments.sample(random); s++) {
			placeLeavesRow(level, blockSetter, random, config, pos, 1, y, false);
			placeLeavesRow(level, blockSetter, random, config, pos, 2, y - 1, false);
			y -= 3;
		}

		placeLeavesRow(level, blockSetter, random, config, pos, 1, y, false);
	}

	private void createMega(LevelSimulatedReader level, FoliageSetter blockSetter, RandomSource random, TreeConfiguration config, BlockPos pos) {
		int y = -6;

		placeLeavesRow(level, blockSetter, random, config, pos, 0, 1, true);
		placeLeavesRow(level, blockSetter, random, config, pos, 0, 0, true);
		placeLeavesRow(level, blockSetter, random, config, pos, 1, -1, true);
		placeLeavesRow(level, blockSetter, random, config, pos, 1, -2, true);
		placeLeavesRow(level, blockSetter, random, config, pos, 2, -3, true);
		placeLeavesRow(level, blockSetter, random, config, pos, 1, -4, true);

		for (int s = 1; s <= midSegments.sample(random); s++) {
			placeLeavesRow(level, blockSetter, random, config, pos, 2, y, true);
			placeLeavesRow(level, blockSetter, random, config, pos, 3, y - 1, true);
			placeLeavesRow(level, blockSetter, random, config, pos, 1, y - 2, true);
			y -= 4;
		}

		placeLeavesRow(level, blockSetter, random, config, pos, 1, y, true);
		placeLeavesRow(level, blockSetter, random, config, pos, 2, y - 1, true);
	}

	private void createUltra(LevelSimulatedReader level, FoliageSetter blockSetter, RandomSource random, TreeConfiguration config, BlockPos pos) {
		boolean variant = random.nextBoolean();
		int y = -10;

		placeLeavesRow(level, blockSetter, random, config, pos, 0, 2, false);
		placeLeavesRow(level, blockSetter, random, config, pos, 0, 1, false);
		placeLeavesRow(level, blockSetter, random, config, pos, 1, 0, false);
		placeLeavesRow(level, blockSetter, random, config, pos, 1, -1, false);
		placeLeavesRow(level, blockSetter, random, config, pos, 1, -2, false);
		placeLeavesRow(level, blockSetter, random, config, pos, 2, -3, false);
		placeLeavesRow(level, blockSetter, random, config, pos, 2, -4, false);
		placeLeavesRow(level, blockSetter, random, config, pos, variant ? 2 : 3, -5, false);
		placeLeavesRow(level, blockSetter, random, config, pos, variant ? 3 : 2, -6, false);
		placeLeavesRow(level, blockSetter, random, config, pos, variant ? 3 : 2, -7, false);
		placeLeavesRow(level, blockSetter, random, config, pos, variant ? 2 : 3, -8, false);

		for (int s = 1; s <= midSegments.sample(random); s++) {
			int i = random.nextInt(2);
			placeLeavesRow(level, blockSetter, random, config, pos, i + 1, y, false);
			placeLeavesRow(level, blockSetter, random, config, pos, i + 3, y - 1, false);
			placeLeavesRow(level, blockSetter, random, config, pos, i + 4, y - 2, false);
			placeLeavesRow(level, blockSetter, random, config, pos, i + 2 + random.nextInt(2), y - 3, false);
			y -= 5;
		}

		placeLeavesRow(level, blockSetter, random, config, pos, 3, y, false);
		placeLeavesRow(level, blockSetter, random, config, pos, 4, y - 1, false);
		placeLeavesRow(level, blockSetter, random, config, pos, 2, y - 2, false);

		placeLeavesRow(level, blockSetter, random, config, pos, 2, y - 4, false);
		placeLeavesRow(level, blockSetter, random, config, pos, 3, y - 5, false);
	}

	public int foliageHeight(RandomSource random, int height, TreeConfiguration config) {
		return 2;
	}

	protected boolean shouldSkipLocation(RandomSource random, int x, int y, int z, int range, boolean large) {
		return x * x + z * z > range * range;
	}
}
