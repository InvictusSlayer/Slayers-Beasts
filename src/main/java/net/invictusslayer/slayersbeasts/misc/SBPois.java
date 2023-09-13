package net.invictusslayer.slayersbeasts.misc;

import com.google.common.collect.ImmutableSet;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.SBBlocks;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SBPois {
    public static final DeferredRegister<PoiType> POIS = DeferredRegister.create(ForgeRegistries.POI_TYPES, SlayersBeasts.MOD_ID);

    public static final RegistryObject<PoiType> ANTHILL_POI = POIS.register("anthill_poi", () -> new PoiType(ImmutableSet.copyOf(SBBlocks.ANTHILL.get().getStateDefinition().getPossibleStates()), 0, 1));
    public static final RegistryObject<PoiType> SEPULCHRA_PORTAL = POIS.register("sepulchra_portal", () -> new PoiType(ImmutableSet.copyOf(SBBlocks.SEPULCHRA_PORTAL.get().getStateDefinition().getPossibleStates()), 0, 1));
}
