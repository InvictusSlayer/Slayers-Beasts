package net.invictusslayer.slayersbeasts.common.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.world.feature.tree.trunk.ColossalTrunkPlacer;
import net.invictusslayer.slayersbeasts.common.world.feature.tree.trunk.CrossTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

public class SBTrunkPlacers {
	public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS = DeferredRegister.create(SlayersBeasts.MOD_ID, Registries.TRUNK_PLACER_TYPE);

	public static final RegistrySupplier<TrunkPlacerType<?>> COLOSSAL_TRUNK_PLACER = TRUNK_PLACERS.register("colossal_trunk_placer", () -> new TrunkPlacerType<>(ColossalTrunkPlacer.CODEC));
	public static final RegistrySupplier<TrunkPlacerType<?>> CROSS_TRUNK_PLACER = TRUNK_PLACERS.register("cross_trunk_placer", () -> new TrunkPlacerType<>(CrossTrunkPlacer.CODEC));
}
