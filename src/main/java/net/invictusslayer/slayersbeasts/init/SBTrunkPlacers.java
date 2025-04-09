package net.invictusslayer.slayersbeasts.init;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.world.feature.tree.trunk.ColossalTrunkPlacer;
import net.invictusslayer.slayersbeasts.world.feature.tree.trunk.CrossTrunkPlacer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.function.Supplier;

public class SBTrunkPlacers {
	//? if neoforge
	/*public static final net.neoforged.neoforge.registries.DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS = net.neoforged.neoforge.registries.DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, SlayersBeasts.MOD_ID);*/

	public static final Supplier<TrunkPlacerType<?>> COLOSSAL_TRUNK_PLACER = register("colossal_trunk_placer", new TrunkPlacerType<>(ColossalTrunkPlacer.CODEC));
	public static final Supplier<TrunkPlacerType<?>> CROSS_TRUNK_PLACER = register("cross_trunk_placer", new TrunkPlacerType<>(CrossTrunkPlacer.CODEC));

	private static <T extends TrunkPlacerType<?>> Supplier<T> register(String name, T placer) {
		//? if fabric
		return () -> Registry.register(BuiltInRegistries.TRUNK_PLACER_TYPE, ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, name), placer);
		//? if neoforge
		/*return TRUNK_PLACERS.register(name, () -> placer);*/
	}

	public static void init() {
		SlayersBeasts.LOGGER.info("Initialised Trunk Placers");
	}
}
