package net.invictusslayer.slayersbeasts.world.feature.foliageplacers;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFoliagePlacerType<P extends FoliagePlacer> {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACER_TYPES =
            DeferredRegister.create(ForgeRegistries.FOLIAGE_PLACER_TYPES, SlayersBeasts.MOD_ID);

    public static final RegistryObject<FoliagePlacerType<?>> CAJOLE_FOLIAGE_PLACER =
            FOLIAGE_PLACER_TYPES.register("cajole_foliage_placer", () -> new FoliagePlacerType<>(CajoleFoliagePlacer.CODEC));

    public static final RegistryObject<FoliagePlacerType<?>> EUCALYPTUS_FOLIAGE_PLACER =
            FOLIAGE_PLACER_TYPES.register("eucalyptus_foliage_placer", () -> new FoliagePlacerType<>(EucalyptusFoliagePlacer.CODEC));

    public static void register(IEventBus eventBus) {
        FOLIAGE_PLACER_TYPES.register(eventBus);
    }
}
