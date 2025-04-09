package net.invictusslayer.slayersbeasts.init;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.world.feature.tree.foliage.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

import java.util.function.Supplier;

public class SBFoliagePlacers {
    //? if neoforge
    /*public static final net.neoforged.neoforge.registries.DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS = net.neoforged.neoforge.registries.DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, SlayersBeasts.MOD_ID);*/

    public static final Supplier<FoliagePlacerType<?>> POINTED_FOLIAGE_PLACER = register("pointed_foliage_placer", new FoliagePlacerType<>(PointedFoliagePlacer.CODEC));
    public static final Supplier<FoliagePlacerType<?>> STACKED_FOLIAGE_PLACER = register("stacked_foliage_placer", new FoliagePlacerType<>(StackedFoliagePlacer.CODEC));
    public static final Supplier<FoliagePlacerType<?>> CAJOLE_FOLIAGE_PLACER = register("cajole_foliage_placer", new FoliagePlacerType<>(CajoleFoliagePlacer.CODEC));
    public static final Supplier<FoliagePlacerType<?>> EUCALYPTUS_FOLIAGE_PLACER = register("eucalyptus_foliage_placer", new FoliagePlacerType<>(EucalyptusFoliagePlacer.CODEC));
    public static final Supplier<FoliagePlacerType<?>> REDWOOD_FOLIAGE_PLACER = register("redwood_foliage_placer", new FoliagePlacerType<>(RedwoodFoliagePlacer.CODEC));
    public static final Supplier<FoliagePlacerType<?>> WILLOW_FOLIAGE_PLACER = register("willow_foliage_placer", new FoliagePlacerType<>(WillowFoliagePlacer.CODEC));

    private static <T extends FoliagePlacerType<?>> Supplier<T> register(String name, T placer) {
        //? if fabric
        return () -> Registry.register(BuiltInRegistries.FOLIAGE_PLACER_TYPE, ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, name), placer);
        //? if neoforge
        /*return FOLIAGE_PLACERS.register(name, () -> placer);*/
    }

    public static void init() {
        SlayersBeasts.LOGGER.info("Initialised Foliage Placers");
    }
}