package net.invictusslayer.slayersbeasts.common.init;

import com.google.common.collect.ImmutableSet;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.village.poi.PoiType;

import java.util.function.Supplier;

public class SBPois {
	public static final Supplier<PoiType> ANTHILL = register("anthill", () -> new PoiType(ImmutableSet.copyOf(SBBlocks.ANTHILL.get().getStateDefinition().getPossibleStates()), 0, 1));

	private static <T extends PoiType> Supplier<T> register(String name, Supplier<T> supplier) {
		return SlayersBeasts.PLATFORM.register(BuiltInRegistries.POINT_OF_INTEREST_TYPE, name, supplier);
	}

	public static void register() {
		SlayersBeasts.LOGGER.info("Registering SBPoiTypes...");
	}
}
