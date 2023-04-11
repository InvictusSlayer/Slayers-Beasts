package net.invictusslayer.slayersbeasts.world.feature.trunkplacer;

import com.mojang.serialization.Codec;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.Method;

public class ModTrunkPlacerTypes<P extends TrunkPlacer> extends TrunkPlacerType<P> {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER_TYPES = DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, SlayersBeasts.MOD_ID);

    public static final RegistryObject<TrunkPlacerType<CrossTrunkPlacer>> CROSS_TRUNK_PLACER =
            TRUNK_PLACER_TYPES.register("cross_trunk_placer", () -> new TrunkPlacerType<>(CrossTrunkPlacer.CODEC));

    public ModTrunkPlacerTypes(Codec<P> pCodec) {
        super(pCodec);
    }

    public static void registerTrunkPlacers() {
        try {
            Method method = ObfuscationReflectionHelper.findMethod(TrunkPlacerType.class, "register", String.class, Codec.class);
            method.setAccessible(true);
            method.invoke(null, "cross_trunk_placer", CrossTrunkPlacer.CODEC);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void register(IEventBus eventBus) {
        TRUNK_PLACER_TYPES.register(eventBus);
    }
}
