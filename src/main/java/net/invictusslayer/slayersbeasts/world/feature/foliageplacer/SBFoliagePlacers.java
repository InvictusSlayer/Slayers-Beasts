package net.invictusslayer.slayersbeasts.world.feature.foliageplacer;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SBFoliagePlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS = DeferredRegister.create(ForgeRegistries.FOLIAGE_PLACER_TYPES, SlayersBeasts.MOD_ID);

    public static final RegistryObject<FoliagePlacerType<?>> CAJOLE_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("cajole_foliage_placer", () -> new FoliagePlacerType<>(CajoleFoliagePlacer.CODEC));
    public static final RegistryObject<FoliagePlacerType<?>> EUCALYPTUS_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("eucalyptus_foliage_placer", () -> new FoliagePlacerType<>(EucalyptusFoliagePlacer.CODEC));
    public static final RegistryObject<FoliagePlacerType<?>> ULTRA_REDWOOD_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("ultra_redwood_foliage_placer", () -> new FoliagePlacerType<>(UltraRedwoodFoliagePlacer.CODEC));
    public static final RegistryObject<FoliagePlacerType<?>> TALL_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("tall_foliage_placer", () -> new FoliagePlacerType<>(TallFoliagePlacer.CODEC));

    public static void register(IEventBus eventBus) {
        FOLIAGE_PLACERS.register(eventBus);
    }
}