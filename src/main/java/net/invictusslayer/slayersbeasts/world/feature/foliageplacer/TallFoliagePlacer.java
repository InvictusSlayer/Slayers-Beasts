package net.invictusslayer.slayersbeasts.world.feature.foliageplacer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class TallFoliagePlacer extends FoliagePlacer {
    public static final Codec<TallFoliagePlacer> CODEC = RecordCodecBuilder.create(instance ->
            foliagePlacerParts(instance).apply(instance, TallFoliagePlacer::new));

    public TallFoliagePlacer(IntProvider pRadius, IntProvider pOffset) {
        super(pRadius, pOffset);
    }

    protected FoliagePlacerType<?> type() {
        return SBFoliagePlacers.TALL_FOLIAGE_PLACER.get();
    }

    protected void createFoliage(LevelSimulatedReader pLevel, FoliageSetter pBlockSetter, RandomSource pRandom, TreeConfiguration pConfig, int pMaxFreeTreeHeight, FoliageAttachment pAttachment, int pFoliageHeight, int pFoliageRadius, int pOffset) {
        boolean flag = pAttachment.doubleTrunk();
        BlockPos blockPos = pAttachment.pos().above(pOffset);
        int r = pFoliageRadius + pAttachment.radiusOffset();
        placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockPos, r - 2, -13, flag);
        placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockPos, r - 1, -12, flag);
        placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockPos, r, -11, flag);
        placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockPos, r, -10, flag);
        placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockPos, r, -9, flag);
        placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockPos, r - 1, -8, flag);
        placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockPos, r, -7, flag);
        placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockPos, r, -6, flag);
        placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockPos, r, -5, flag);
        placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockPos, r - 1, -4, flag);
        placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockPos, r, -3, flag);
        placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockPos, r, -2, flag);
        placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockPos, r, -1, flag);
        placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockPos, r - 1, 0, flag);
        placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockPos, r - 2, 1, flag);
    }

    public int foliageHeight(RandomSource pRandom, int pHeight, TreeConfiguration pConfig) {
        return 0;
    }

    protected boolean shouldSkipLocation(RandomSource pRandom, int pLocalX, int pLocalY, int pLocalZ, int pRange, boolean pLarge) {
        if (pLocalX + pLocalZ > pRange || pLocalX > 2 || pLocalZ > 2) {
            return true;
        }
        if (pLocalX == 2 || pLocalZ == 2) {
            return pRandom.nextBoolean();
        }
        return false;
    }
}
