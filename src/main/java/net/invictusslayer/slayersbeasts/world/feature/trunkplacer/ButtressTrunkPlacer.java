package net.invictusslayer.slayersbeasts.world.feature.trunkplacer;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class ButtressTrunkPlacer extends GiantTrunkPlacer {
    public static final Codec<ButtressTrunkPlacer> CODEC = RecordCodecBuilder.create(instance ->
            trunkPlacerParts(instance).apply(instance, ButtressTrunkPlacer::new));

    public ButtressTrunkPlacer(int pBaseHeight, int pHeightRandA, int pHeightRandB) {
        super(pBaseHeight, pHeightRandA, pHeightRandB);
    }

    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacers.BUTTRESS_TRUNK_PLACER.get();
    }

    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, RandomSource pRandom, int pFreeTreeHeight, BlockPos pPos, TreeConfiguration pConfig) {
        BlockPos blockpos = pPos.below();
        setDirtAt(pLevel, pBlockSetter, pRandom, blockpos, pConfig);
        setDirtAt(pLevel, pBlockSetter, pRandom, blockpos.east(), pConfig);
        setDirtAt(pLevel, pBlockSetter, pRandom, blockpos.south(), pConfig);
        setDirtAt(pLevel, pBlockSetter, pRandom, blockpos.south().east(), pConfig);
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();

        this.placeRoot(pLevel, pBlockSetter, pRandom, mutableBlockPos, pConfig, pPos, Direction.NORTH);
        this.placeRoot(pLevel, pBlockSetter, pRandom, mutableBlockPos, pConfig, pPos, Direction.SOUTH);
        this.placeRoot(pLevel, pBlockSetter, pRandom, mutableBlockPos, pConfig, pPos, Direction.WEST);
        this.placeRoot(pLevel, pBlockSetter, pRandom, mutableBlockPos, pConfig, pPos, Direction.EAST);

        for(int i = 0; i < pFreeTreeHeight; ++i) {
            this.placeLogIfFreeWithOffset(pLevel, pBlockSetter, pRandom, mutableBlockPos, pConfig, pPos, 0, i, 0);
            if (i < pFreeTreeHeight - 1) {
                this.placeLogIfFreeWithOffset(pLevel, pBlockSetter, pRandom, mutableBlockPos, pConfig, pPos, 1, i, 0);
                this.placeLogIfFreeWithOffset(pLevel, pBlockSetter, pRandom, mutableBlockPos, pConfig, pPos, 1, i, 1);
                this.placeLogIfFreeWithOffset(pLevel, pBlockSetter, pRandom, mutableBlockPos, pConfig, pPos, 0, i, 1);
            }
        }
        return ImmutableList.of(new FoliagePlacer.FoliageAttachment(pPos.above(pFreeTreeHeight), 0, true));
    }

    private void placeRoot(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, RandomSource pRandom, BlockPos.MutableBlockPos pMutablePos, TreeConfiguration pConfig, BlockPos pBasePos, Direction pDirection) {
        List<BlockPos> posList = new ArrayList<>();
        posList.add(new BlockPos(-1, 0, -1));
        posList.add(new BlockPos(-1, 1, -1));
        posList.add(new BlockPos(-2, 0, -2));

        int x = pRandom.nextBoolean() ? 0 : 1;
        for (int z = -1; z >= -5; z--) {
            int h;
            if (z == -1) {
                h = 4;
            } else if (z > -4) {
                h = z + 4;
                if (pRandom.nextBoolean()) {
                    posList.add(new BlockPos(pRandom.nextBoolean() ? x + 1 : x - 1, 0, z));
                }
            } else {
                h = 0;
            }

            for (int y = 0; y <= h; y++) {
                posList.add(new BlockPos(x, y, z));
            }

            x = pRandom.nextBoolean() ? x : pRandom.nextBoolean() ? x + 1 : x - 1;
        }

        if (pDirection == Direction.NORTH) {
            for (BlockPos pos : posList) {
                this.placeLogIfFree(pLevel, pBlockSetter, pRandom, pMutablePos.setWithOffset(pBasePos, pos), pConfig);
                setDirtAt(pLevel, pBlockSetter, pRandom, pMutablePos.setWithOffset(pBasePos, pos.getX(), -1, pos.getZ()), pConfig);
            }
        } else if (pDirection == Direction.SOUTH) {
            for (BlockPos pos : posList) {
                this.placeLogIfFree(pLevel, pBlockSetter, pRandom, pMutablePos.setWithOffset(pBasePos, -pos.getX() + 1, pos.getY(), -pos.getZ() + 1), pConfig);
                setDirtAt(pLevel, pBlockSetter, pRandom, pMutablePos.setWithOffset(pBasePos, -pos.getX() + 1, -1, -pos.getZ() + 1), pConfig);
            }
        } else if (pDirection == Direction.WEST) {
            for (BlockPos pos : posList) {
                this.placeLogIfFree(pLevel, pBlockSetter, pRandom, pMutablePos.setWithOffset(pBasePos, pos.getZ(), pos.getY(), -pos.getX() + 1), pConfig);
                setDirtAt(pLevel, pBlockSetter, pRandom, pMutablePos.setWithOffset(pBasePos, pos.getZ(), -1, -pos.getX() + 1), pConfig);
            }
        } else if (pDirection == Direction.EAST) {
            for (BlockPos pos : posList) {
                this.placeLogIfFree(pLevel, pBlockSetter, pRandom, pMutablePos.setWithOffset(pBasePos, -pos.getZ() + 1, pos.getY(), pos.getX()), pConfig);
                setDirtAt(pLevel, pBlockSetter, pRandom, pMutablePos.setWithOffset(pBasePos, -pos.getZ() + 1, -1, pos.getX()), pConfig);
            }
        }
    }

    private void placeLogIfFreeWithOffset(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, RandomSource pRandom, BlockPos.MutableBlockPos pPos, TreeConfiguration pConfig, BlockPos pOffsetPos, int pOffsetX, int pOffsetY, int pOffsetZ) {
        pPos.setWithOffset(pOffsetPos, pOffsetX, pOffsetY, pOffsetZ);
        this.placeLogIfFree(pLevel, pBlockSetter, pRandom, pPos, pConfig);
    }
}
