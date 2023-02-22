package net.invictusslayer.slayersbeasts.world.feature.trunkplacer;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.List;
import java.util.OptionalInt;
import java.util.function.BiConsumer;

public class CrossTrunkPlacer extends TrunkPlacer {
    public static final Codec<CrossTrunkPlacer> CODEC = RecordCodecBuilder.create((p_70161_) -> {
        return trunkPlacerParts(p_70161_).apply(p_70161_, CrossTrunkPlacer::new);
    });

    public CrossTrunkPlacer(int pBaseHeight, int pHeightRandA, int pHeightRandB) {
        super(pBaseHeight, pHeightRandA, pHeightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return TrunkPlacerType.FORKING_TRUNK_PLACER;
    }

    private static <P extends TrunkPlacer> TrunkPlacerType<P> register(String key, Codec<P> type) {
        return Registry.register(BuiltInRegistries.TRUNK_PLACER_TYPE, key, new TrunkPlacerType<>(type));
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, RandomSource pRandom, int pFreeTreeHeight, BlockPos pPos, TreeConfiguration pConfig) {
        setDirtAt(pLevel, pBlockSetter, pRandom, pPos.below(), pConfig);
        List<FoliagePlacer.FoliageAttachment> list = Lists.newArrayList();
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
        int i = pFreeTreeHeight - pRandom.nextInt(6) - 1;
        int j = 6 - pRandom.nextInt(6);
        int k = pPos.getX();
        int l = pPos.getZ();
        int m = pPos.getX();
        int n = pPos.getZ();
        int p = 6 - pRandom.nextInt(3);
        OptionalInt optionalInt = OptionalInt.empty();
        OptionalInt optionalInt1 = OptionalInt.empty();
        Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(pRandom);
        Direction direction1 = pRandom.nextInt(2) == 0 ? direction.getCounterClockWise() : direction.getClockWise();

        for(int i1 = 0; i1 < pFreeTreeHeight; ++i1) {
            int j1 = pPos.getY() + i1;
            int k1 = j1 - p;
            if (i1 >= i && j > 0) {
                k += direction.getStepX();
                l += direction.getStepZ();
                m -= direction.getStepX();
                n -= direction.getStepZ();
                --j;
            }

            if (placeLog(pLevel, pBlockSetter, pRandom, blockpos$mutableblockpos.set(k, j1, l), pConfig)) {
                optionalInt = OptionalInt.of(j1 + 1);
            }
            if (placeLog(pLevel, pBlockSetter, pRandom, blockpos$mutableblockpos.set(m, k1, n), pConfig)) {
                optionalInt1 = OptionalInt.of(k1 + 1);
            }
        }

        if (optionalInt.isPresent()) {
            list.add(new FoliagePlacer.FoliageAttachment(new BlockPos(k, optionalInt.getAsInt(), l), 1, false));
        }
        if (optionalInt1.isPresent()) {
            list.add(new FoliagePlacer.FoliageAttachment(new BlockPos(m, optionalInt1.getAsInt(), n), 1, false));
        }

        k = pPos.getX();
        l = pPos.getZ();
        m = pPos.getX();
        n = pPos.getZ();
        p = 6 - pRandom.nextInt(3);

        int j2 = i - pRandom.nextInt(2) - 1;
        int k2 = 1 + pRandom.nextInt(3);
        optionalInt = OptionalInt.empty();
        optionalInt1 = OptionalInt.empty();

        for(int l1 = j2; l1 < pFreeTreeHeight && k2 > 0; --k2) {
            if (l1 >= 1) {
                int i2 = pPos.getY() + l1;
                int l2 = i2 - p;
                k += direction1.getStepX();
                l += direction1.getStepZ();
                m -= direction1.getStepX();
                n -= direction1.getStepZ();
                if (placeLog(pLevel, pBlockSetter, pRandom, blockpos$mutableblockpos.set(k, i2, l), pConfig)) {
                    optionalInt = OptionalInt.of(i2 + 1);
                }
                if (placeLog(pLevel, pBlockSetter, pRandom, blockpos$mutableblockpos.set(m, l2, n), pConfig)) {
                    optionalInt1 = OptionalInt.of(l2 + 1);
                }
            }

            ++l1;
        }

        if (optionalInt.isPresent()) {
            list.add(new FoliagePlacer.FoliageAttachment(new BlockPos(k, optionalInt.getAsInt(), l), 0, false));
        }
        if (optionalInt1.isPresent()) {
            list.add(new FoliagePlacer.FoliageAttachment(new BlockPos(m, optionalInt1.getAsInt(), n), 0, false));
        }

        return list;
    }
}
