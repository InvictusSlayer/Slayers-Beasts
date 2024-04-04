package net.invictusslayer.slayersbeasts.common.init;

import com.google.common.collect.ImmutableSet;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.village.poi.PoiType;

public class SBPois {
	public static final DeferredRegister<PoiType> POIS = DeferredRegister.create(SlayersBeasts.MOD_ID, Registries.POINT_OF_INTEREST_TYPE);

	public static final RegistrySupplier<PoiType> ANTHILL = POIS.register("anthill", () -> new PoiType(ImmutableSet.copyOf(SBBlocks.ANTHILL.get().getStateDefinition().getPossibleStates()), 0, 1));
}
