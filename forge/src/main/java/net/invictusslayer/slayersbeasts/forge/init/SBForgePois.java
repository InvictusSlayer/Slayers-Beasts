package net.invictusslayer.slayersbeasts.forge.init;

import com.google.common.collect.ImmutableSet;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SBForgePois {
	public static final DeferredRegister<PoiType> POIS = DeferredRegister.create(ForgeRegistries.POI_TYPES, SlayersBeasts.MOD_ID);

	public static final RegistryObject<PoiType> SEPULCHRA_PORTAL = POIS.register("sepulchra_portal", () -> new PoiType(ImmutableSet.copyOf(SBForgeBlocks.SEPULCHRA_PORTAL.get().getStateDefinition().getPossibleStates()), 0, 1));
}
