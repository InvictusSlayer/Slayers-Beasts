package net.invictusslayer.slayersbeasts.world.feature.tree.foliageplacer;

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
            foliagePlacerParts(instance).and(Codec.intRange(1, 5).fieldOf("stacks").forGetter(placer -> placer.stacks))
                    .apply(instance, TallFoliagePlacer::new));
    private final int stacks;

    public TallFoliagePlacer(IntProvider pRadius, IntProvider pOffset, int pStacks) {
        super(pRadius, pOffset);
        this.stacks = pStacks;
    }

    protected FoliagePlacerType<?> type() {
        return SBFoliagePlacers.TALL_FOLIAGE_PLACER.get();
    }

    protected void createFoliage(LevelSimulatedReader pLevel, FoliageSetter pBlockSetter, RandomSource pRandom, TreeConfiguration pConfig, int pMaxFreeTreeHeight, FoliageAttachment pAttachment, int pFoliageHeight, int pFoliageRadius, int pOffset) {
        boolean flag = pAttachment.doubleTrunk();
        BlockPos blockPos = pAttachment.pos().above(pOffset);
        int r = pFoliageRadius + pAttachment.radiusOffset();
        int h = -this.stacks * 4;
        placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockPos, r - 2, h - 1, flag);
        placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockPos, r - 1, h, flag);

        for (int i = 0; i < this.stacks; i++) {
            int j = -4 * i;
            placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockPos, r, j - 3, flag);
            placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockPos, r, j - 2, flag);
            placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockPos, r, j - 1, flag);
            placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockPos, r - 1, j, flag);
        }

        placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockPos, r - 2, 1, flag);
    }

    public int foliageHeight(RandomSource pRandom, int pHeight, TreeConfiguration pConfig) {
        return 0;
    }

    protected boolean shouldSkipLocation(RandomSource pRandom, int pLocalX, int pLocalY, int pLocalZ, int pRange, boolean pLarge) {
        return pLocalX + pLocalZ > pRange || pLocalX > 2 || pLocalZ > 2;
    }
}
