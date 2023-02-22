package net.invictusslayer.slayersbeasts.world.feature.trunkplacer;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

import java.lang.reflect.InvocationTargetException;

public class ModTrunkPlacerType<P extends TrunkPlacer> extends TrunkPlacerType<P> {
    public static final ModTrunkPlacerType<CrossTrunkPlacer> CROSS_TRUNK_PLACER = register("cross_trunk_placer", CrossTrunkPlacer.CODEC);
    private final Codec<P> codec;

    private static <P extends TrunkPlacer> ModTrunkPlacerType<P> register(String pKey, Codec<P> pCodec) {
        return Registry.register(BuiltInRegistries.TRUNK_PLACER_TYPE, pKey, new ModTrunkPlacerType<>(pCodec));
    }

    public ModTrunkPlacerType(Codec<P> pCodec) {
        super(pCodec);
        this.codec = pCodec;
    }

    public static void registerPlacers() {
        try {
            ObfuscationReflectionHelper.findMethod(TrunkPlacerType.class, "registerPlacer", TrunkPlacerType.class)
                    .invoke(null, CROSS_TRUNK_PLACER);
        } catch (InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }

    public Codec<P> codec() {
        return this.codec;
    }
}
