package net.invictusslayer.slayersbeasts.world.feature.trunkplacer;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;

public class ColossalTrunkPlacer extends TrunkPlacer {
    public static final Codec<ColossalTrunkPlacer> CODEC = RecordCodecBuilder.create(instance ->
            trunkPlacerParts(instance).apply(instance, ColossalTrunkPlacer::new));

    public ColossalTrunkPlacer(int pBaseHeight, int pHeightRandA, int pHeightRandB) {
        super(pBaseHeight, pHeightRandA, pHeightRandB);
    }

    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacers.COLOSSAL_TRUNK_PLACER.get();
    }

    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, RandomSource pRandom, int pFreeTreeHeight, BlockPos pPos, TreeConfiguration pConfig) {
        BlockPos dirtPos = pPos.below();
        setDirtAt(pLevel, pBlockSetter, pRandom, dirtPos, pConfig);
        setDirtAt(pLevel, pBlockSetter, pRandom, dirtPos.east(), pConfig);
        setDirtAt(pLevel, pBlockSetter, pRandom, dirtPos.east().east(), pConfig);
        setDirtAt(pLevel, pBlockSetter, pRandom, dirtPos.south(), pConfig);
        setDirtAt(pLevel, pBlockSetter, pRandom, dirtPos.south().east(), pConfig);
        setDirtAt(pLevel, pBlockSetter, pRandom, dirtPos.south().east().east(), pConfig);
        setDirtAt(pLevel, pBlockSetter, pRandom, dirtPos.south().south(), pConfig);
        setDirtAt(pLevel, pBlockSetter, pRandom, dirtPos.south().south().east(), pConfig);
        setDirtAt(pLevel, pBlockSetter, pRandom, dirtPos.south().south().east().east(), pConfig);
        BlockPos.MutableBlockPos pMutableBlockPos = new BlockPos.MutableBlockPos();

        for(int i = 0; i < pFreeTreeHeight; ++i) {
            if (i < pFreeTreeHeight - 1) {
                this.placeLogIfFreeWithOffset(pLevel, pBlockSetter, pRandom, pMutableBlockPos, pConfig, pPos, 0, i, 0);
                this.placeLogIfFreeWithOffset(pLevel, pBlockSetter, pRandom, pMutableBlockPos, pConfig, pPos, 1, i, 0);
                this.placeLogIfFreeWithOffset(pLevel, pBlockSetter, pRandom, pMutableBlockPos, pConfig, pPos, 2, i, 0);
                this.placeLogIfFreeWithOffset(pLevel, pBlockSetter, pRandom, pMutableBlockPos, pConfig, pPos, 0, i, 1);
                this.placeLogIfFreeWithOffset(pLevel, pBlockSetter, pRandom, pMutableBlockPos, pConfig, pPos, 1, i, 1);
                this.placeLogIfFreeWithOffset(pLevel, pBlockSetter, pRandom, pMutableBlockPos, pConfig, pPos, 2, i, 1);
                this.placeLogIfFreeWithOffset(pLevel, pBlockSetter, pRandom, pMutableBlockPos, pConfig, pPos, 0, i, 2);
                this.placeLogIfFreeWithOffset(pLevel, pBlockSetter, pRandom, pMutableBlockPos, pConfig, pPos, 1, i, 2);
                this.placeLogIfFreeWithOffset(pLevel, pBlockSetter, pRandom, pMutableBlockPos, pConfig, pPos, 2, i, 2);
            }
        }

        return ImmutableList.of(new FoliagePlacer.FoliageAttachment(pPos.above(pFreeTreeHeight).south().east(), 0, false));
    }

    private void placeLogIfFreeWithOffset(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, RandomSource pRandom, BlockPos.MutableBlockPos pPos, TreeConfiguration pConfig, BlockPos pOffsetPos, int pOffsetX, int pOffsetY, int pOffsetZ) {
        pPos.setWithOffset(pOffsetPos, pOffsetX, pOffsetY, pOffsetZ);
        this.placeLogIfFree(pLevel, pBlockSetter, pRandom, pPos, pConfig);
    }
}
