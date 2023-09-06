package net.invictusslayer.slayersbeasts.world.feature.tree.foliageplacer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class WillowFoliagePlacer extends FoliagePlacer {
    public static final Codec<WillowFoliagePlacer> CODEC = RecordCodecBuilder.create(instance ->
            foliagePlacerParts(instance).and(Codec.intRange(0, 16).fieldOf("height")
                    .forGetter(placer -> placer.height)).apply(instance, WillowFoliagePlacer::new));
    private final int height;

    public WillowFoliagePlacer(IntProvider pRadius, IntProvider pOffset, int pHeight) {
        super(pRadius, pOffset);
        this.height = pHeight;
    }

    protected FoliagePlacerType<?> type() {
        return SBFoliagePlacers.WILLOW_FOLIAGE_PLACER.get();
    }

    protected void createFoliage(LevelSimulatedReader pLevel, FoliageSetter pBlockSetter, RandomSource pRandom, TreeConfiguration pConfig, int pMaxFreeTreeHeight, FoliageAttachment pAttachment, int pFoliageHeight, int pFoliageRadius, int pOffset) {
        int i = pAttachment.doubleTrunk() ? pFoliageHeight : 1 + pRandom.nextInt(2);

        for(int j = pOffset; j >= pOffset - i; --j) {
            int k = pFoliageRadius + pAttachment.radiusOffset() + 1 - j;
            this.placeLeavesRowWithHangingLeavesBelow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos(), k, j, pAttachment.doubleTrunk(), 0.3F, 0.8F);
        }
    }

    public int foliageHeight(RandomSource pRandom, int pHeight, TreeConfiguration pConfig) {
        return this.height;
    }

    protected boolean shouldSkipLocation(RandomSource pRandom, int pLocalX, int pLocalY, int pLocalZ, int pRange, boolean pLarge) {
        return pLocalX * pLocalX + pLocalZ * pLocalZ > pRange * pRange;
    }
}
