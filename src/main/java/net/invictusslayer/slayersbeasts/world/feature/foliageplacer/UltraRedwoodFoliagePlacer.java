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

public class UltraRedwoodFoliagePlacer extends FoliagePlacer {
    public static final Codec<UltraRedwoodFoliagePlacer> CODEC = RecordCodecBuilder.create(instance ->
            foliagePlacerParts(instance).and(IntProvider.codec(0, 30).fieldOf("height")
                    .forGetter(placer -> placer.height)).apply(instance, UltraRedwoodFoliagePlacer::new));
    private final IntProvider height;

    public UltraRedwoodFoliagePlacer(IntProvider pRadius, IntProvider pOffset, IntProvider pHeight) {
        super(pRadius, pOffset);
        this.height = pHeight;
    }

    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacers.ULTRA_REDWOOD_FOLIAGE_PLACER.get();
    }

    protected void createFoliage(LevelSimulatedReader pLevel, FoliageSetter pBlockSetter, RandomSource pRandom, TreeConfiguration pConfig, int pMaxFreeTreeHeight, FoliageAttachment pAttachment, int pFoliageHeight, int pFoliageRadius, int pOffset) {
        BlockPos blockpos = pAttachment.pos();
        boolean flag = pAttachment.doubleTrunk();
        int l = pFoliageRadius + pAttachment.radiusOffset();

        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, 0, 3, flag);
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, 1, 2, flag);
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, 2, 1, flag);
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, 3,  -1 - pFoliageHeight, flag);
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, 4, -2 - pFoliageHeight, flag);
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, 2,  -4 - pFoliageHeight, flag);
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, 3, -5 - pFoliageHeight, flag);

        for (int j = blockpos.getY() - pFoliageHeight + pOffset; j <= blockpos.getY() + pOffset; ++j) {
            int k = blockpos.getY() - j;
            int r;

            if (k % 4 == 0) {
                r = 0;
            } else if (k < 4) {
                r = k + 2;
            } else if (k % 4 == 1) {
                r = l + pRandom.nextInt(2);
            } else if (k % 4 == 2) {
                r = l + 1 + pRandom.nextInt(2);
            } else {
                r = l + 3 + pRandom.nextInt(2);
            }
            this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, r, -k, flag);
        }
    }

    public int foliageHeight(RandomSource pRandom, int pHeight, TreeConfiguration pConfig) {
        return this.height.sample(pRandom);
    }

    protected boolean shouldSkipLocation(RandomSource pRandom, int pLocalX, int pLocalY, int pLocalZ, int pRange, boolean pLarge) {
        if (pLocalX + pLocalZ >= 7) {
            return true;
        } else {
            return pLocalX * pLocalX + pLocalZ * pLocalZ > pRange * pRange;
        }
    }
}
