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
            foliagePlacerParts(instance).and(IntProvider.codec(0, 35).fieldOf("height")
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
        boolean large = pAttachment.doubleTrunk();
        int f = pFoliageRadius + pAttachment.radiusOffset();
        boolean flag = pRandom.nextBoolean();

        placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, 3,  -1 - pFoliageHeight, large);
        placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, 4, -2 - pFoliageHeight, large);
        placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, 2,  -4 - pFoliageHeight, large);
        placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, 3, -5 - pFoliageHeight, large);

        for (int j = blockpos.getY() - pFoliageHeight + pOffset; j <= blockpos.getY() + pOffset + 2; ++j) {
            int k = blockpos.getY() - j;
            int r = k < 0 ? 0 : k < 3 ? 1 : k < 9 ? 2 : 0;

            if (flag ? k == 6 || k == 7 : k == 5 || k == 8) {
                r = 3;
            }

            if (k % 5 == 0 && k > 9) {
                int l = k == 10 ? 0 : 1 + pRandom.nextInt(3);
                placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, f + l,-k, large);
                placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, f + l + 1, -k - 1, large);
                placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, f + l + 2, -k - 2, large);
                continue;
            }

            placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, r, -k, large);
        }
    }

    public int foliageHeight(RandomSource pRandom, int pHeight, TreeConfiguration pConfig) {
        return this.height.sample(pRandom);
    }

    protected boolean shouldSkipLocation(RandomSource pRandom, int pLocalX, int pLocalY, int pLocalZ, int pRange, boolean pLarge) {
        if (pLocalX + pLocalZ >= 9) {
            return true;
        } else {
            return pLocalX * pLocalX + pLocalZ * pLocalZ > pRange * pRange;
        }
    }
}
