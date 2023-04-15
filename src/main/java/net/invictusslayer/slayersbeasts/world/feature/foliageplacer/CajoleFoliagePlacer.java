package net.invictusslayer.slayersbeasts.world.feature.foliageplacer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

import java.util.function.BiConsumer;

public class CajoleFoliagePlacer extends FoliagePlacer {
    public static final Codec<CajoleFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) ->
            foliagePlacerParts(instance).apply(instance, CajoleFoliagePlacer::new));

    public CajoleFoliagePlacer(IntProvider pRadius, IntProvider pOffset) {
        super(pRadius, pOffset);
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacers.CAJOLE_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, RandomSource pRandom, TreeConfiguration pConfig, int pMaxFreeTreeHeight, FoliageAttachment pAttachment, int pFoliageHeight, int pFoliageRadius, int pOffset) {
        boolean flag = pAttachment.doubleTrunk();
        BlockPos blockpos = pAttachment.pos().above(pOffset);
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, 0, -2, flag);
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, pFoliageRadius + pAttachment.radiusOffset() - 1, -1, flag);
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, pFoliageRadius - 1, 0, flag);
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, pFoliageRadius + pAttachment.radiusOffset() - 1, 0, flag);
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, 0, 1, flag);
    }

    @Override
    public int foliageHeight(RandomSource pRandom, int pHeight, TreeConfiguration pConfig) {
        return 0;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource pRandom, int pLocalX, int pLocalY, int pLocalZ, int pRange, boolean pLarge) {
        if (pLocalY == 0) {
            return (pLocalX > 1 || pLocalZ > 1) && pLocalX != 0 && pLocalZ != 0;
        } else {
            return pLocalX == pRange && pLocalZ == pRange && pRange > 0;
        }
    }
}
