package net.invictusslayer.slayersbeasts.world.feature.foliageplacer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
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
        int i = 0;

        for (int j = blockpos.getY() - pFoliageHeight + pOffset; j <= blockpos.getY() + pOffset; ++j) {
            int k = blockpos.getY() - j;
            int l = pFoliageRadius + pAttachment.radiusOffset() + Mth.floor((float) k / (float) pFoliageHeight * 3.5F);
            int i1;
            if (k > 0 && l == i && (j & 1) == 0) {
                i1 = l + 1;
            } else {
                i1 = l;
            }

            this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, new BlockPos(blockpos.getX(), j, blockpos.getZ()), i1, 0, pAttachment.doubleTrunk());
            i = l;
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
