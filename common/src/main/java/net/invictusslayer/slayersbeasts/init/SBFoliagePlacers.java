package net.invictusslayer.slayersbeasts.init;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.world.feature.tree.foliage.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

import java.util.function.Supplier;

public class SBFoliagePlacers {
    public static final Supplier<FoliagePlacerType<?>> POINTED_FOLIAGE_PLACER = register("pointed_foliage_placer", () -> new FoliagePlacerType<>(PointedFoliagePlacer.CODEC));
    public static final Supplier<FoliagePlacerType<?>> STACKED_FOLIAGE_PLACER = register("stacked_foliage_placer", () -> new FoliagePlacerType<>(StackedFoliagePlacer.CODEC));
    public static final Supplier<FoliagePlacerType<?>> CAJOLE_FOLIAGE_PLACER = register("cajole_foliage_placer", () -> new FoliagePlacerType<>(CajoleFoliagePlacer.CODEC));
    public static final Supplier<FoliagePlacerType<?>> EUCALYPTUS_FOLIAGE_PLACER = register("eucalyptus_foliage_placer", () -> new FoliagePlacerType<>(EucalyptusFoliagePlacer.CODEC));
    public static final Supplier<FoliagePlacerType<?>> REDWOOD_FOLIAGE_PLACER = register("redwood_foliage_placer", () -> new FoliagePlacerType<>(RedwoodFoliagePlacer.CODEC));
    public static final Supplier<FoliagePlacerType<?>> WILLOW_FOLIAGE_PLACER = register("willow_foliage_placer", () -> new FoliagePlacerType<>(WillowFoliagePlacer.CODEC));

    private static <T extends FoliagePlacerType<?>> Supplier<T> register(String name, Supplier<T> supplier) {
        return SlayersBeasts.PLATFORM.register(BuiltInRegistries.FOLIAGE_PLACER_TYPE, SlayersBeasts.MOD_ID, name, supplier);
    }

    public static void register() {
        SlayersBeasts.LOGGER.info("Registering SBFoliagePlacers...");
    }
}