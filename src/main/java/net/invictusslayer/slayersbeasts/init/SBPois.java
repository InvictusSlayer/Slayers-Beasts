package net.invictusslayer.slayersbeasts.init;

import com.google.common.collect.ImmutableSet;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.village.poi.PoiType;

import java.util.function.Supplier;

public class SBPois {
	//? if neoforge
	/*public static final net.neoforged.neoforge.registries.DeferredRegister<PoiType> POIS = net.neoforged.neoforge.registries.DeferredRegister.create(Registries.POINT_OF_INTEREST_TYPE, SlayersBeasts.MOD_ID);*/

	public static final Supplier<PoiType> ANTHILL = register("anthill", new PoiType(ImmutableSet.copyOf(SBBlocks.ANTHILL.get().getStateDefinition().getPossibleStates()), 0, 1));

	private static <T extends PoiType> Supplier<T> register(String name, T poi) {
		//? if fabric
		return () -> Registry.register(BuiltInRegistries.POINT_OF_INTEREST_TYPE, ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, name), poi);
		//? if neoforge
		/*return POIS.register(name, () -> poi);*/
	}

	public static void init() {
		SlayersBeasts.LOGGER.info("Initialised POIs");
	}
}
