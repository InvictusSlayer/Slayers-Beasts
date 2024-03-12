package net.invictusslayer.slayersbeasts.common.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.world.feature.tree.foliage.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class SBFoliagePlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS = DeferredRegister.create(SlayersBeasts.MOD_ID, Registries.FOLIAGE_PLACER_TYPE);

    public static final RegistrySupplier<FoliagePlacerType<?>> POINTED_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("pointed_foliage_placer", () -> new FoliagePlacerType<>(PointedFoliagePlacer.CODEC));
    public static final RegistrySupplier<FoliagePlacerType<?>> STACKED_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("stacked_foliage_placer", () -> new FoliagePlacerType<>(StackedFoliagePlacer.CODEC));
    public static final RegistrySupplier<FoliagePlacerType<?>> CAJOLE_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("cajole_foliage_placer", () -> new FoliagePlacerType<>(CajoleFoliagePlacer.CODEC));
    public static final RegistrySupplier<FoliagePlacerType<?>> EUCALYPTUS_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("eucalyptus_foliage_placer", () -> new FoliagePlacerType<>(EucalyptusFoliagePlacer.CODEC));
    public static final RegistrySupplier<FoliagePlacerType<?>> REDWOOD_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("redwood_foliage_placer", () -> new FoliagePlacerType<>(RedwoodFoliagePlacer.CODEC));
    public static final RegistrySupplier<FoliagePlacerType<?>> WILLOW_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("willow_foliage_placer", () -> new FoliagePlacerType<>(WillowFoliagePlacer.CODEC));
}