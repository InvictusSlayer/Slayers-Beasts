package net.invictusslayer.slayersbeasts.world.feature.trunkplacer;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class SBTrunkPlacers {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS = DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, SlayersBeasts.MOD_ID);

    public static final RegistryObject<TrunkPlacerType<?>> CROSS_TRUNK_PLACER = TRUNK_PLACERS.register("cross_trunk_placer", () -> new TrunkPlacerType<>(CrossTrunkPlacer.CODEC));
    public static final RegistryObject<TrunkPlacerType<?>> BUTTRESS_TRUNK_PLACER = TRUNK_PLACERS.register("buttress_trunk_placer", () -> new TrunkPlacerType<>(ButtressTrunkPlacer.CODEC));
    public static final RegistryObject<TrunkPlacerType<?>> COLOSSAL_TRUNK_PLACER = TRUNK_PLACERS.register("colossal_trunk_placer", () -> new TrunkPlacerType<>(ColossalTrunkPlacer.CODEC));

    public static void register(IEventBus eventBus) {
        TRUNK_PLACERS.register(eventBus);
    }
}
