package net.invictusslayer.slayersbeasts.world.feature.trunkplacer;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

public class ModTrunkPlacerType<P extends TrunkPlacer> extends TrunkPlacerType<P> {
    public static final ModTrunkPlacerType<CrossTrunkPlacer> CROSS_TRUNK_PLACER = register("cross_trunk_placer", CrossTrunkPlacer.CODEC);
    private final Codec<P> codec;

    private static  <P extends TrunkPlacer> ModTrunkPlacerType<P> register(String pKey, Codec<P> pCodec) {
        return Registry.register(Registry.TRUNK_PLACER_TYPES, pKey, new ModTrunkPlacerType<>(pCodec));
    }

    public ModTrunkPlacerType(Codec<P> pCodec) {
        super(pCodec);
        this.codec = pCodec;
    }

    public Codec<P> codec() {
        return this.codec;
    }
}
