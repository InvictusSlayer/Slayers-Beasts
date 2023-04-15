package net.invictusslayer.slayersbeasts.world.feature.trunkplacer;

import com.mojang.serialization.Codec;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTrunkPlacers<P extends TrunkPlacer> extends TrunkPlacerType<P> {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS = DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, SlayersBeasts.MOD_ID);

    public static final RegistryObject<TrunkPlacerType<CrossTrunkPlacer>> CROSS_TRUNK_PLACER =
            TRUNK_PLACERS.register("cross_trunk_placer", () -> new TrunkPlacerType<>(CrossTrunkPlacer.CODEC));

    public ModTrunkPlacers(Codec<P> pCodec) {
        super(pCodec);
    }

    public static void register(IEventBus eventBus) {
        TRUNK_PLACERS.register(eventBus);
    }
}
