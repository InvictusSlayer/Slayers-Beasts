package net.invictusslayer.slayersbeasts.util;

import com.google.common.collect.ImmutableSet;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.init.ModBlocks;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPoiTypes {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, SlayersBeasts.MOD_ID);

    public static final RegistryObject<PoiType> ANTHILL_POI = POI_TYPES.register("anthill_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.ANTHILL.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockStates", PoiType.class)
                    .invoke(null, ANTHILL_POI);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
    }
}
