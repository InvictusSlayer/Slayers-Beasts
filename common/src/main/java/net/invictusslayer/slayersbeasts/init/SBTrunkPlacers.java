package net.invictusslayer.slayersbeasts.init;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.world.feature.tree.trunk.ColossalTrunkPlacer;
import net.invictusslayer.slayersbeasts.world.feature.tree.trunk.CrossTrunkPlacer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.function.Supplier;

public class SBTrunkPlacers {
	public static final Supplier<TrunkPlacerType<?>> COLOSSAL_TRUNK_PLACER = register("colossal_trunk_placer", () -> new TrunkPlacerType<>(ColossalTrunkPlacer.CODEC));
	public static final Supplier<TrunkPlacerType<?>> CROSS_TRUNK_PLACER = register("cross_trunk_placer", () -> new TrunkPlacerType<>(CrossTrunkPlacer.CODEC));

	private static <T extends TrunkPlacerType<?>> Supplier<T> register(String name, Supplier<T> supplier) {
		return SlayersBeasts.PLATFORM.register(BuiltInRegistries.TRUNK_PLACER_TYPE, SlayersBeasts.MOD_ID, name, supplier);
	}

	public static void register() {
		SlayersBeasts.LOGGER.info("Registering SBTrunkPlacers...");
	}
}
