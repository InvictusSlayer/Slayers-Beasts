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

public class StackedFoliagePlacer extends FoliagePlacer {
    public static final Codec<StackedFoliagePlacer> CODEC = RecordCodecBuilder.create(instance -> foliagePlacerParts(instance).and(
            Codec.intRange(1, 5).fieldOf("stacks").forGetter(placer -> placer.stacks))
            .apply(instance, StackedFoliagePlacer::new));
    private final int stacks;

    public StackedFoliagePlacer(IntProvider radius, IntProvider offset, int stacks) {
        super(radius, offset);
        this.stacks = stacks;
    }

    protected FoliagePlacerType<?> type() {
        return SBFoliagePlacers.STACKED_FOLIAGE_PLACER.get();
    }

    protected void createFoliage(LevelSimulatedReader level, FoliageSetter blockSetter, RandomSource random, TreeConfiguration config, int maxFreeTreeHeight, FoliageAttachment attachment, int foliageHeight, int foliageRadius, int offset) {
        boolean flag = attachment.doubleTrunk();
        BlockPos blockPos = attachment.pos().above(offset);
        int r = foliageRadius + attachment.radiusOffset();
        int h = -stacks * 4;
        placeLeavesRow(level, blockSetter, random, config, blockPos, r - 2, h - 1, flag);
        placeLeavesRow(level, blockSetter, random, config, blockPos, r - 1, h, flag);

        for (int i = 0; i < stacks; i++) {
            int j = -4 * i;
            placeLeavesRow(level, blockSetter, random, config, blockPos, r, j - 3, flag);
            placeLeavesRow(level, blockSetter, random, config, blockPos, r, j - 2, flag);
            placeLeavesRow(level, blockSetter, random, config, blockPos, r, j - 1, flag);
            placeLeavesRow(level, blockSetter, random, config, blockPos, r - 1, j, flag);
        }

        placeLeavesRow(level, blockSetter, random, config, blockPos, r - 2, 1, flag);
    }

    public int foliageHeight(RandomSource random, int height, TreeConfiguration config) {
        return 0;
    }

    protected boolean shouldSkipLocation(RandomSource random, int x, int y, int z, int range, boolean large) {
        return x + z > range || x > 2 || z > 2;
    }
}
