package net.invictusslayer.slayersbeasts.world.feature.tree.foliage;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SBFoliagePlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS = DeferredRegister.create(ForgeRegistries.FOLIAGE_PLACER_TYPES, SlayersBeasts.MOD_ID);

    public static final RegistryObject<FoliagePlacerType<?>> POINTED_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("pointed_foliage_placer", () -> new FoliagePlacerType<>(PointedFoliagePlacer.CODEC));
    public static final RegistryObject<FoliagePlacerType<?>> STACKED_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("stacked_foliage_placer", () -> new FoliagePlacerType<>(StackedFoliagePlacer.CODEC));
    public static final RegistryObject<FoliagePlacerType<?>> CAJOLE_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("cajole_foliage_placer", () -> new FoliagePlacerType<>(CajoleFoliagePlacer.CODEC));
    public static final RegistryObject<FoliagePlacerType<?>> EUCALYPTUS_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("eucalyptus_foliage_placer", () -> new FoliagePlacerType<>(EucalyptusFoliagePlacer.CODEC));
    public static final RegistryObject<FoliagePlacerType<?>> REDWOOD_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("redwood_foliage_placer", () -> new FoliagePlacerType<>(RedwoodFoliagePlacer.CODEC));
    public static final RegistryObject<FoliagePlacerType<?>> WILLOW_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("willow_foliage_placer", () -> new FoliagePlacerType<>(WillowFoliagePlacer.CODEC));
}