package net.invictusslayer.slayersbeasts.datagen.tags;

import com.google.common.collect.ImmutableSet;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.ModBlocks;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPois {
    public static final DeferredRegister<PoiType> POIS =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, SlayersBeasts.MOD_ID);

    public static final RegistryObject<PoiType> ANTHILL_POI = POIS.register("anthill_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.ANTHILL.get().getStateDefinition().getPossibleStates()), 0, 1));

    public static final RegistryObject<PoiType> SEPULCHRA_PORTAL = POIS.register("sepulchra_portal",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.SEPULCHRA_PORTAL.get().getStateDefinition().getPossibleStates()), 0, 1));

    public static void register(IEventBus eventBus) {
        POIS.register(eventBus);
    }
}