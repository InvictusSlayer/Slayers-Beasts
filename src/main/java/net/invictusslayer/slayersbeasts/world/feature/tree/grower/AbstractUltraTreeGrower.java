package net.invictusslayer.slayersbeasts.world.feature.tree.grower;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import javax.annotation.Nullable;

public abstract class AbstractUltraTreeGrower extends AbstractMegaTreeGrower {
    public boolean growTree(ServerLevel pLevel, ChunkGenerator pGenerator, BlockPos pPos, BlockState pState, RandomSource pRandom) {
        for (int i = 0; i >= -2; --i) {
            for (int j = 0; j >= -2; --j) {
                if (isThreeByThreeSapling(pState, pLevel, pPos, i, j)) {
                    return this.placeUltra(pLevel, pGenerator, pPos, pState, pRandom, i, j);
                }
            }
        }

        return super.growTree(pLevel, pGenerator, pPos, pState, pRandom);
    }

    @Nullable
    protected abstract ResourceKey<ConfiguredFeature<?, ?>> getConfiguredUltraFeature(RandomSource pRandom);

    public boolean placeUltra(ServerLevel pLevel, ChunkGenerator pGenerator, BlockPos pPos, BlockState pState, RandomSource pRandom, int pBranchX, int pBranchY) {
        ResourceKey<ConfiguredFeature<?, ?>> feature = this.getConfiguredUltraFeature(pRandom);
        if (feature == null) {
            return false;
        } else {
            Holder<ConfiguredFeature<?, ?>> holder = pLevel.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE).getHolder(feature).orElse(null);
            var event = net.minecraftforge.event.ForgeEventFactory.blockGrowFeature(pLevel, pRandom, pPos, holder);
            holder = event.getFeature();
            if (event.getResult() == net.minecraftforge.eventbus.api.Event.Result.DENY) return false;
            if (holder == null) {
                return false;
            } else {
                ConfiguredFeature<?, ?> trunk = holder.value();
                BlockState blockstate = Blocks.AIR.defaultBlockState();
                pLevel.setBlock(pPos.offset(pBranchX, 0, pBranchY), blockstate, 4);
                pLevel.setBlock(pPos.offset(pBranchX + 1, 0, pBranchY), blockstate, 4);
                pLevel.setBlock(pPos.offset(pBranchX + 2, 0, pBranchY), blockstate, 4);
                pLevel.setBlock(pPos.offset(pBranchX, 0, pBranchY + 1), blockstate, 4);
                pLevel.setBlock(pPos.offset(pBranchX + 1, 0, pBranchY + 1), blockstate, 4);
                pLevel.setBlock(pPos.offset(pBranchX + 2, 0, pBranchY + 1), blockstate, 4);
                pLevel.setBlock(pPos.offset(pBranchX, 0, pBranchY + 2), blockstate, 4);
                pLevel.setBlock(pPos.offset(pBranchX + 1, 0, pBranchY + 2), blockstate, 4);
                pLevel.setBlock(pPos.offset(pBranchX + 2, 0, pBranchY + 2), blockstate, 4);
                if (trunk.place(pLevel, pGenerator, pRandom, pPos.offset(pBranchX, 0, pBranchY))) {
                    return true;
                } else {
                    pLevel.setBlock(pPos.offset(pBranchX, 0, pBranchY), pState, 4);
                    pLevel.setBlock(pPos.offset(pBranchX + 1, 0, pBranchY), pState, 4);
                    pLevel.setBlock(pPos.offset(pBranchX + 2, 0, pBranchY), pState, 4);
                    pLevel.setBlock(pPos.offset(pBranchX, 0, pBranchY + 1), pState, 4);
                    pLevel.setBlock(pPos.offset(pBranchX + 1, 0, pBranchY + 1), pState, 4);
                    pLevel.setBlock(pPos.offset(pBranchX + 2, 0, pBranchY + 1), pState, 4);
                    pLevel.setBlock(pPos.offset(pBranchX, 0, pBranchY + 2), pState, 4);
                    pLevel.setBlock(pPos.offset(pBranchX + 1, 0, pBranchY + 2), pState, 4);
                    pLevel.setBlock(pPos.offset(pBranchX + 2, 0, pBranchY + 2), pState, 4);
                    return false;
                }
            }
        }
    }

    public static boolean isThreeByThreeSapling(BlockState pBlockUnder, BlockGetter pLevel, BlockPos pPos, int pXOffset, int pZOffset) {
        Block block = pBlockUnder.getBlock();
        return pLevel.getBlockState(pPos.offset(pXOffset, 0, pZOffset)).is(block) &&
                pLevel.getBlockState(pPos.offset(pXOffset + 1, 0, pZOffset)).is(block) &&
                pLevel.getBlockState(pPos.offset(pXOffset + 2, 0, pZOffset)).is(block) &&
                pLevel.getBlockState(pPos.offset(pXOffset, 0, pZOffset + 1)).is(block) &&
                pLevel.getBlockState(pPos.offset(pXOffset + 1, 0, pZOffset + 1)).is(block) &&
                pLevel.getBlockState(pPos.offset(pXOffset + 2, 0, pZOffset + 1)).is(block) &&
                pLevel.getBlockState(pPos.offset(pXOffset, 0, pZOffset + 2)).is(block) &&
                pLevel.getBlockState(pPos.offset(pXOffset + 1, 0, pZOffset + 2)).is(block) &&
                pLevel.getBlockState(pPos.offset(pXOffset + 2, 0, pZOffset + 2)).is(block);
    }
}
