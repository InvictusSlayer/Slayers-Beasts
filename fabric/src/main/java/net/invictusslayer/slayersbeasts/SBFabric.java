package net.invictusslayer.slayersbeasts;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.invictusslayer.slayersbeasts.init.SBEntities;
import net.minecraft.world.entity.SpawnPlacements;

public class SBFabric implements ModInitializer {
	private static boolean INITIALISED = false;

	public void onInitialize() {
		fabricInit();
	}

	public static void fabricInit() {
		if (INITIALISED) {
			SlayersBeasts.LOGGER.info("SBFabric has already been initialised, skipping...");
			return;
		}
		INITIALISED = true;

		SlayersBeasts.init();
		SlayersBeasts.commonSetup();
		SBEntities.registerAttributes(FabricDefaultAttributeRegistry::register);
		SBEntities.registerSpawns(placement -> SpawnPlacements.register(placement.entity(), placement.placement(), placement.heightmap(), placement.predicate()));
	}
}
