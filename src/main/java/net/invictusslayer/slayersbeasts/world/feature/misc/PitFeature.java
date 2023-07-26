package net.invictusslayer.slayersbeasts.world.feature.misc;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class PitFeature extends Feature<PitFeature.Configuration> {
    public PitFeature(Codec<Configuration> pCodec) {
        super(pCodec);
    }

    @SuppressWarnings("deprecation")
    public boolean place(FeaturePlaceContext<PitFeature.Configuration> pContext) {
        BlockPos origin = pContext.origin();
        WorldGenLevel level = pContext.level();
        RandomSource random = pContext.random();
        PitFeature.Configuration config = pContext.config();

        int x = config.x();
        int y = config.y();
        int z = config.z();
        int xMax = x < 7 ? 8 : 16;
        int yMax = y < 7 ? 8 : y < 15 ? 16 : 32;
        int zMax = z < 7 ? 8 : 16;

        if (origin.getY() <= level.getMinBuildHeight() + y) return false;
        origin = origin.below(y);
        if (!level.canSeeSky(origin.offset(xMax / 2, y, zMax / 2))) return false;

        boolean[] booleans = new boolean[xMax * yMax * zMax];

        for (int i = 0; i < y * 2; ++i) {
            double d0 = random.nextDouble() * 4D + 3D;
            double d1 = random.nextDouble() * 6D + 2D;
            double d2 = random.nextDouble() * 4D + 3D;
            double d3 = random.nextDouble() * (x - d0) + 1.0D + d0 / 2.0D;
            double d4 = random.nextDouble() * (y - d1) + 1.0D + d1 / 2.0D;
            double d5 = random.nextDouble() * (z - d2) + 1.0D + d2 / 2.0D;

            for (int x1 = 1; x1 < xMax - 1; ++x1) {
                for (int z1 = 1; z1 < zMax - 1; ++z1) {
                    for (int y1 = 1; y1 < y - 1; ++y1) {
                        double d6 = (x1 - d3) / (d0 / 2D);
                        double d7 = (y1 - d4) / (d1 / 2D);
                        double d8 = (z1 - d5) / (d2 / 2D);
                        double d9 = d6 * d6 + d7 * d7 + d8 * d8;
                        if (d9 < 1.0D) {
                            booleans[(x1 * zMax + z1) * yMax + y1] = true;
                        }
                    }
                }
            }
        }

        for (int x1 = 0; x1 < xMax; ++x1) {
            for (int z1 = 0; z1 < zMax; ++z1) {
                for (int y1 = 0; y1 < yMax; ++y1) {
                    int boolId = (x1 * zMax + z1) * yMax + y1;
                    boolean flag = !booleans[boolId]
                            && (x1 < xMax - 1 && booleans[boolId + zMax * yMax] || x1 > 0 && booleans[boolId - zMax * yMax]
                            || z1 < zMax - 1 && booleans[boolId + yMax] || z1 > 0 && booleans[boolId - yMax]
                            || y1 < yMax - 1 && booleans[boolId + 1] || y1 > 0 && booleans[boolId - 1]);
                    if (flag) {
                        BlockState state = level.getBlockState(origin.offset(x1, y1, z1));
                        if (state.liquid()) return false;
                        if (y1 < y && !state.isSolid() && level.getBlockState(origin.offset(x1, y1, z1)) != Blocks.CAVE_AIR.defaultBlockState()) {
                            return false;
                        }
                    }
                }
            }
        }

        for (int x1 = 0; x1 < xMax; ++x1) {
            for (int z1 = 0; z1 < zMax; ++z1) {
                for (int y1 = 0; y1 < yMax; ++y1) {
                    if (booleans[(x1 * zMax + z1) * yMax + y1]) {
                        BlockPos pos = origin.offset(x1, y1, z1);
                        if (!level.getBlockState(pos).is(BlockTags.FEATURES_CANNOT_REPLACE)) {
                            level.setBlock(pos, Blocks.CAVE_AIR.defaultBlockState(), 2);
                            markAboveForPostProcessing(level, pos);
                        }
                    }
                }
            }
        }

        BlockState wall = config.wall().getState(random, origin);
        BlockState ceiling = config.ceiling().getState(random, origin);
        if (wall.isAir()) return true;
        for (int x1 = 0; x1 < xMax; ++x1) {
            for (int z1 = 0; z1 < zMax; ++z1) {
                for (int y1 = 0; y1 < yMax; ++y1) {
                    int boolId = (x1 * zMax + z1) * yMax + y1;
                    boolean flag = !booleans[boolId]
                            && (x1 < xMax - 1 && booleans[boolId + zMax * yMax] || x1 > 0 && booleans[boolId - zMax * yMax]
                            || z1 < zMax - 1 && booleans[boolId + yMax] || z1 > 0 && booleans[boolId - yMax]
                            || y1 < yMax - 1 && booleans[boolId + 1] || y1 > 0 && booleans[boolId - 1]);
                    if (flag) {
                        BlockPos pos = origin.offset(x1, y1, z1);
                        BlockState state = level.getBlockState(pos);
                        if (!state.is(BlockTags.FEATURES_CANNOT_REPLACE)) {
                            if (y1 < y * 0.3 || random.nextInt(3) == 0) {
                                level.setBlock(pos, wall, 2);
                            } else if (y1 > y * 0.7) {
                                level.setBlock(pos, ceiling, 2);
                            } else if (random.nextInt(3) == 0) {
                                level.setBlock(pos, wall, 2);
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

    public record Configuration(BlockStateProvider ceiling, BlockStateProvider wall, int x, int y, int z) implements FeatureConfiguration {
        public static final Codec<Configuration> CODEC = RecordCodecBuilder.create(instance ->
                instance.group(BlockStateProvider.CODEC.fieldOf("ceiling_provider").forGetter(Configuration::ceiling),
                                BlockStateProvider.CODEC.fieldOf("wall_provider").forGetter(Configuration::wall),
                                Codec.intRange(1, 16).fieldOf("x").forGetter(Configuration::x),
                                Codec.intRange(1, 32).fieldOf("y").forGetter(Configuration::y),
                                Codec.intRange(1, 16).fieldOf("z").forGetter(Configuration::z))
                        .apply(instance, Configuration::new));
    }
}
