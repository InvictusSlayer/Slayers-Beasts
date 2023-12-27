package net.invictusslayer.slayersbeasts.world.biome;

import net.invictusslayer.slayersbeasts.block.SBBlocks;
import net.invictusslayer.slayersbeasts.world.SBNoises;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

import static net.minecraft.world.level.levelgen.SurfaceRules.*;

public class SBSurfaceRuleData {
    public static RuleSource overworldRules() {
        return sequence(ifTrue(abovePreliminarySurface(), sequence( /* Overground */
                        ifTrue(ON_FLOOR, sequence(
                                ifTrue(SurfaceRules.isBiome(SBBiomes.BAYOU), ifBetweenY(60, 63,
                                        ifTrue(noiseCondition(Noises.SWAMP, 0), setBlock(Blocks.WATER)))),
                                ifTrue(isBiome(SBBiomes.INKY_MOOR), ifBetweenY(62, 63,
                                        ifTrue(noiseCondition(Noises.SWAMP, 0), setBlock(Blocks.WATER))))
                        )),
                        ifTrue(ON_FLOOR, ifTrue(waterBlockCheck(-1, 0), sequence(
                                ifTrue(isBiome(SBBiomes.BLACK_DUNES), sequence(
                                        ifTrue(ON_CEILING, setBlock(SBBlocks.BLACK_SANDSTONE.get())),
                                        setBlock(SBBlocks.BLACK_SAND.get()))),
                                ifTrue(isBiome(SBBiomes.DEAD_SANDS), sequence(
                                        ifTrue(ON_CEILING, setBlock(SBBlocks.BLACK_SANDSTONE.get())),
                                        ifTrue(noiseCondition(SBNoises.SAND, 0), setBlock(SBBlocks.BLACK_SAND.get())),
                                        setBlock(Blocks.RED_SAND))),
                                ifTrue(isBiome(SBBiomes.EUCALYPT_WOODLAND),
                                        ifTrue(noiseCondition(Noises.SURFACE, -0.5), setBlock(Blocks.PODZOL))),
                                ifTrue(isBiome(SBBiomes.INKY_MOOR), setBlock(Blocks.MUD)),
                                ifTrue(isBiome(SBBiomes.OUTBACK), sequence(
                                        ifTrue(ON_CEILING, setBlock(Blocks.SANDSTONE)),
                                        ifTrue(noiseCondition(Noises.SURFACE, 0.21), setBlock(Blocks.COARSE_DIRT)),
                                        ifTrue(noiseCondition(Noises.ICE, 0.1), setBlock(Blocks.RED_SAND)),
                                        ifTrue(noiseCondition(Noises.SWAMP, 0.1), setBlock(Blocks.SAND)),
                                        setBlock(Blocks.COARSE_DIRT))),
                                ifTrue(isBiome(SBBiomes.REDWOOD_GROVE, SBBiomes.OLD_GROWTH_REDWOOD_GROVE), sequence(
                                        ifTrue(noiseCondition(Noises.SURFACE, 0.21), setBlock(Blocks.COARSE_DIRT)),
                                        ifTrue(noiseCondition(Noises.SURFACE, -0.12), setBlock(Blocks.PODZOL)))),
                                ifTrue(isBiome(SBBiomes.VOLCANIC_PEAKS), sequence(
                                        ifTrue(noiseCondition(Noises.ICE, -0.015, 0.015), setBlock(Blocks.OBSIDIAN)),
                                        ifTrue(noiseCondition(Noises.ICE, -0.07, 0.07), setBlock(Blocks.MAGMA_BLOCK)),
                                        ifTrue(noiseCondition(Noises.SURFACE, 0), setBlock(Blocks.BASALT)),
                                        setBlock(Blocks.TUFF))),
                                ifTrue(isBiome(SBBiomes.FUNGAL_DEPTHS), setBlock(Blocks.MYCELIUM)),
                                ifTrue(isBiome(SBBiomes.SLIME_CAVERNS), setBlock(Blocks.STONE)),
                                ifTrue(waterBlockCheck(0, 0), setBlock(Blocks.GRASS_BLOCK)),
                                setBlock(Blocks.DIRT)
                        ))),
                        ifTrue(waterStartCheck(-6, -1), sequence(
                                ifTrue(UNDER_FLOOR, sequence(
                                        ifTrue(isBiome(SBBiomes.BLACK_DUNES), sequence(
                                                ifTrue(ON_CEILING, setBlock(SBBlocks.BLACK_SANDSTONE.get())),
                                                setBlock(SBBlocks.BLACK_SAND.get()))),
                                        ifTrue(isBiome(SBBiomes.DEAD_SANDS), sequence(
                                                ifTrue(ON_CEILING, setBlock(SBBlocks.BLACK_SANDSTONE.get())),
                                                ifTrue(noiseCondition(SBNoises.SAND, 0), setBlock(SBBlocks.BLACK_SAND.get())),
                                                setBlock(Blocks.RED_SAND))),
                                        ifTrue(isBiome(SBBiomes.INKY_MOOR), setBlock(Blocks.MUD)),
                                        ifTrue(isBiome(SBBiomes.OUTBACK), sequence(
                                                ifTrue(ON_CEILING, setBlock(Blocks.SANDSTONE)),
                                                ifTrue(noiseCondition(Noises.SURFACE, 0.21), setBlock(Blocks.COARSE_DIRT)),
                                                ifTrue(noiseCondition(Noises.ICE, 0.1), setBlock(Blocks.RED_SAND)),
                                                ifTrue(noiseCondition(Noises.SWAMP, 0.1), setBlock(Blocks.SAND)),
                                                setBlock(Blocks.COARSE_DIRT))),
                                        ifTrue(isBiome(SBBiomes.VOLCANIC_PEAKS), sequence(
                                                ifTrue(noiseCondition(Noises.SURFACE, 0), setBlock(Blocks.BASALT)),
                                                setBlock(Blocks.TUFF))),
                                        ifTrue(isBiome(SBBiomes.SLIME_CAVERNS), setBlock(Blocks.STONE)),
                                        setBlock(Blocks.DIRT)
                                )),
                                ifTrue(DEEP_UNDER_FLOOR, sequence(
                                        ifTrue(isBiome(SBBiomes.BLACK_DUNES, SBBiomes.DEAD_SANDS), setBlock(SBBlocks.BLACK_SANDSTONE.get()))
                                )),
                                ifTrue(VERY_DEEP_UNDER_FLOOR, sequence(
                                        ifTrue(isBiome(SBBiomes.VOLCANIC_PEAKS), setBlock(Blocks.GRANITE))
                                ))
                        ))
                )), /* Underground */
                ifTrue(ON_FLOOR, ifTrue(waterBlockCheck(-1, 0), sequence(
                        ifTrue(isBiome(SBBiomes.DUSTY_CAVERNS), setBlock(Blocks.SAND)),
                        ifTrue(isBiome(SBBiomes.ICE_CAVES), sequence(
                                ifTrue(noiseCondition(Noises.SWAMP, 0), setBlock(Blocks.ICE)),
                                setBlock(Blocks.PACKED_ICE)))
                ))),
                ifTrue(waterStartCheck(-6, -1), ifTrue(not(hole()), sequence(
                        ifTrue(UNDER_FLOOR, sequence(
                                ifTrue(isBiome(SBBiomes.VOLCANIC_PEAKS), sequence(
                                        ifTrue(noiseCondition(Noises.SURFACE, 0), setBlock(Blocks.BASALT)),
                                        setBlock(Blocks.TUFF))),
                                ifTrue(isBiome(SBBiomes.DUSTY_CAVERNS), setBlock(Blocks.SAND)),
                                ifTrue(isBiome(SBBiomes.ICE_CAVES),
                                        ifTrue(noiseCondition(SBNoises.CAVE_ICE, 0), setBlock(Blocks.ICE)))
                        )),
                        ifTrue(DEEP_UNDER_FLOOR, sequence(
                                ifTrue(isBiome(SBBiomes.ICE_CAVES),
                                        ifTrue(noiseCondition(SBNoises.CAVE_ICE, 0.1), setBlock(Blocks.PACKED_ICE)))
                        )),
                        ifTrue(VERY_DEEP_UNDER_FLOOR, sequence(
                                ifTrue(isBiome(SBBiomes.DUSTY_CAVERNS), setBlock(Blocks.SANDSTONE)),
                                ifTrue(isBiome(SBBiomes.VOLCANIC_PEAKS), setBlock(Blocks.GRANITE))
                        ))
                )))
        );
    }

    public static RuleSource netherRules() {
        return sequence(ifTrue(isBiome(SBBiomes.TOXIC_JUNGLE), setBlock(Blocks.NETHERRACK)));
    }

    public static RuleSource endRules() {
        return sequence(ifTrue(isBiome(SBBiomes.END_SPIKES), setBlock(Blocks.OBSIDIAN)));
    }

    private static RuleSource ifBetweenY(int bottom, int top, RuleSource rule) {
        return ifTrue(yBlockCheck(VerticalAnchor.absolute(bottom), 0),
                ifTrue(not(yBlockCheck(VerticalAnchor.absolute(top), 0)), rule));
    }

    private static RuleSource setBlock(Block pBlock) {
        return state(pBlock.defaultBlockState());
    }
}
