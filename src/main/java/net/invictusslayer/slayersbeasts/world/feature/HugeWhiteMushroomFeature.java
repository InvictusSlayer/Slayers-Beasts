package net.invictusslayer.slayersbeasts.world.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.AbstractHugeMushroomFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;

public class HugeWhiteMushroomFeature extends AbstractHugeMushroomFeature {
    public HugeWhiteMushroomFeature(Codec<HugeMushroomFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    protected void placeTrunk(LevelAccessor pLevel, RandomSource pRandom, BlockPos pPos, HugeMushroomFeatureConfiguration pConfig, int pMaxHeight, BlockPos.MutableBlockPos pMutablePos) {
        for(int i = 0; i < pMaxHeight - 4; ++i) {
            pMutablePos.set(pPos).move(Direction.UP, i);
            if (!pLevel.getBlockState(pMutablePos).isSolidRender(pLevel, pMutablePos)) {
                this.setBlock(pLevel, pMutablePos, pConfig.stemProvider.getState(pRandom, pPos));
            }
        }
    }

    @Override
    protected void makeCap(LevelAccessor pLevel, RandomSource pRandom, BlockPos pPos, int pTreeHeight, BlockPos.MutableBlockPos pMutablePos, HugeMushroomFeatureConfiguration pConfig) {
        int dir = pRandom.nextInt(4);
        for (int hgt = pTreeHeight - 6; hgt <= pTreeHeight; ++hgt) {
            int stage = pTreeHeight - hgt;
            int wdt = stage < 4 ? 1 : 3;

            for(int x = -wdt; x <= wdt; ++x) {
                for(int z = -wdt; z <= wdt; ++z) {
                    boolean flag = false;
                    int wdtx = Math.abs(x);
                    int wdtz = Math.abs(z);
                    int sum = wdtx + wdtz;
                    if (stage == 0) {
                        if (dir == 0) {
                            flag = x == 0 && z == 1;
                        } else if (dir == 1) {
                            flag = x == 1 && z == 0;
                        } else if (dir == 2) {
                            flag = x == 0 && z == -1;
                        } else {
                            flag = x == -1 && z == 0;
                        }
                    } else if (stage == 1) {
                        flag = sum == 0;
                    } else if (stage == 2) {
                        flag = sum < 2;
                    } else if (stage == 3) {
                        flag = wdtx < 2 && wdtz < 2;
                    } else if (stage == 4) {
                        flag = sum < 3;
                    } else if (stage == 5) {
                        flag = (wdtx == 2) != (wdtz == 2) && sum < 4;
                    } else if (stage == 6) {
                        flag = ((wdtx == 3) != (wdtz == 3) && sum < 5) || (sum == 4 && wdtx * wdtz == 4);
                    }

                    if (flag) {
                        pMutablePos.setWithOffset(pPos, x, hgt, z);
                        boolean flag1 = stage < 5;
                        boolean northFlag = flag1 || z < 0;
                        boolean southFlag = flag1 || z > 0;
                        boolean eastFlag = flag1 || x > 0;
                        boolean westFlag = flag1 || x < 0;

                        if (!pLevel.getBlockState(pMutablePos).isSolidRender(pLevel, pMutablePos)) {
                            BlockState blockstate = pConfig.capProvider.getState(pRandom, pPos);

                            if (blockstate.hasProperty(HugeMushroomBlock.WEST) && blockstate.hasProperty(HugeMushroomBlock.EAST) && blockstate.hasProperty(HugeMushroomBlock.NORTH) && blockstate.hasProperty(HugeMushroomBlock.SOUTH) && blockstate.hasProperty(HugeMushroomBlock.UP) && blockstate.hasProperty(HugeMushroomBlock.DOWN)) {
                                blockstate = blockstate.setValue(HugeMushroomBlock.UP, true).setValue(HugeMushroomBlock.DOWN, hgt == pTreeHeight).setValue(HugeMushroomBlock.WEST, westFlag).setValue(HugeMushroomBlock.EAST, eastFlag).setValue(HugeMushroomBlock.NORTH, northFlag).setValue(HugeMushroomBlock.SOUTH, southFlag);
                            }

                            this.setBlock(pLevel, pMutablePos, blockstate);
                        }
                    }
                }
            }
        }
    }

    @Override
    protected int getTreeHeight(RandomSource pRandom) {
        int i = pRandom.nextInt(4) + 8;
        if (pRandom.nextInt(12) == 0) {
            i += 7;
        }

        return i;
    }

    @Override
    protected int getTreeRadiusForHeight(int p_65094_, int treeHeight, int pFoliageRadius, int pY) {
        int i = 0;
        if (pY < treeHeight && pY >= treeHeight - 5) {
            i = pFoliageRadius;
        } else if (pY == treeHeight) {
            i = pFoliageRadius;
        }

        return i;
    }

    @Override
    public boolean place(FeaturePlaceContext<HugeMushroomFeatureConfiguration> pContext) {
        WorldGenLevel worldgenlevel = pContext.level();
        BlockPos blockpos = pContext.origin();
        RandomSource randomsource = pContext.random();
        HugeMushroomFeatureConfiguration hugemushroomfeatureconfiguration = pContext.config();
        int i = this.getTreeHeight(randomsource);
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
        if (!this.isValidPosition(worldgenlevel, blockpos, i, blockpos$mutableblockpos, hugemushroomfeatureconfiguration)) {
            return false;
        } else {
            this.makeCap(worldgenlevel, randomsource, blockpos, i, blockpos$mutableblockpos, hugemushroomfeatureconfiguration);
            this.placeTrunk(worldgenlevel, randomsource, blockpos, hugemushroomfeatureconfiguration, i, blockpos$mutableblockpos);
            return true;
        }
    }
}
