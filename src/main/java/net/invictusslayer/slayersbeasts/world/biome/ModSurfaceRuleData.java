package net.invictusslayer.slayersbeasts.world.biome;

import net.invictusslayer.slayersbeasts.block.ModBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.VerticalAnchor;

import static net.minecraft.world.level.levelgen.SurfaceRules.*;

public class ModSurfaceRuleData {
    public static RuleSource makeRules() {
        return sequence(
                ifTrue(ON_FLOOR, ifTrue(isBiome(ModBiomes.INKY_MOOR), ifBetweenY(60, 63,
                        ifTrue(noiseCondition(Noises.SWAMP, 0), setBlock(Blocks.WATER))))),
                ifTrue(ON_FLOOR, ifTrue(waterBlockCheck(-1, 0), sequence(
                        ifTrue(isBiome(ModBiomes.BLACK_DUNES), sequence(
                                ifTrue(ON_CEILING, setBlock(ModBlocks.BLACK_SANDSTONE.get())),
                                setBlock(ModBlocks.BLACK_SAND.get()))),
                        ifTrue(isBiome(ModBiomes.EUCALYPT_FOREST),
                                ifTrue(noiseCondition(Noises.SURFACE, -0.5), setBlock(Blocks.PODZOL))),
                        ifTrue(isBiome(ModBiomes.INKY_MOOR), setBlock(Blocks.MUD)),
                        ifTrue(isBiome(ModBiomes.OUTBACK), sequence(
                                ifTrue(ON_CEILING, setBlock(Blocks.SANDSTONE)),
                                ifTrue(noiseCondition(Noises.SURFACE, 0.21), setBlock(Blocks.COARSE_DIRT)),
                                ifTrue(noiseCondition(Noises.ICE, 0.1), setBlock(Blocks.GRAVEL)),
                                setBlock(Blocks.RED_SAND))),
                        ifTrue(isBiome(ModBiomes.REDWOOD_GROVE, ModBiomes.OLD_GROWTH_REDWOOD_GROVE), sequence(
                                ifTrue(noiseCondition(Noises.SURFACE, 0.21), setBlock(Blocks.COARSE_DIRT)),
                                ifTrue(noiseCondition(Noises.SURFACE, -0.12), setBlock(Blocks.PODZOL)),
                                setBlock(Blocks.MOSS_BLOCK))),
                        ifTrue(isBiome(ModBiomes.TAR_DESERT), sequence(
                                ifTrue(ON_CEILING, setBlock(ModBlocks.BLACK_SANDSTONE.get())),
                                ifTrue(noiseCondition(Noises.ICE, 0), setBlock(ModBlocks.BLACK_SAND.get())),
                                setBlock(Blocks.RED_SAND))),
                        ifTrue(isBiome(ModBiomes.VOLCANIC_PEAKS), sequence(
                                ifTrue(ON_CEILING, setBlock(Blocks.BASALT)),
                                ifTrue(noiseCondition(Noises.ICE, 0, 0.1), setBlock(Blocks.MAGMA_BLOCK)),
                                ifTrue(noiseCondition(Noises.SURFACE, 0), setBlock(Blocks.SMOOTH_BASALT)),
                                setBlock(Blocks.BLACKSTONE))),
                        ifTrue(waterBlockCheck(0, 0), setBlock(Blocks.GRASS_BLOCK)),
                        setBlock(Blocks.DIRT)
                ))),
                ifTrue(waterStartCheck(-6, -1), sequence(
                        ifTrue(UNDER_FLOOR, sequence(
                                ifTrue(isBiome(ModBiomes.BLACK_DUNES), sequence(
                                        ifTrue(ON_CEILING, setBlock(ModBlocks.BLACK_SANDSTONE.get())),
                                        setBlock(ModBlocks.BLACK_SAND.get()))),
                                ifTrue(isBiome(ModBiomes.INKY_MOOR), setBlock(Blocks.MUD)),
                                ifTrue(isBiome(ModBiomes.TAR_DESERT), sequence(
                                        ifTrue(ON_CEILING, setBlock(ModBlocks.BLACK_SANDSTONE.get())),
                                        ifTrue(noiseCondition(Noises.ICE, 0), setBlock(ModBlocks.BLACK_SAND.get())),
                                        setBlock(Blocks.RED_SAND))),
                                ifTrue(isBiome(ModBiomes.VOLCANIC_PEAKS), sequence(
                                        ifTrue(ON_CEILING, setBlock(Blocks.BASALT)),
                                        ifTrue(noiseCondition(Noises.SURFACE, 0), setBlock(Blocks.SMOOTH_BASALT)),
                                        setBlock(Blocks.BLACKSTONE))),
                                setBlock(Blocks.DIRT)
                        )),
                        ifTrue(DEEP_UNDER_FLOOR, sequence(
                                ifTrue(isBiome(ModBiomes.BLACK_DUNES, ModBiomes.TAR_DESERT), setBlock(ModBlocks.BLACK_SANDSTONE.get()))
                        )),
                        ifTrue(VERY_DEEP_UNDER_FLOOR, sequence(
                                ifTrue(isBiome(ModBiomes.VOLCANIC_PEAKS), setBlock(Blocks.BASALT))
                        ))
                ))
        );
    }

    private static RuleSource ifBetweenY(int bottom, int top, RuleSource run) {
        return ifTrue(yBlockCheck(VerticalAnchor.aboveBottom(bottom), 0),
                ifTrue(yBlockCheck(VerticalAnchor.belowTop(top), 0), run));
    }

    private static RuleSource setBlock(Block pBlock) {
        return state(pBlock.defaultBlockState());
    }
}
