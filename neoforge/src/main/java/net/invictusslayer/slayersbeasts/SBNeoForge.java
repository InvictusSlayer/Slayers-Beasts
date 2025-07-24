package net.invictusslayer.slayersbeasts;

import net.invictusslayer.scabbard.platform.NeoForgePlatformHandler;
import net.invictusslayer.slayersbeasts.init.SBEntities;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

@Mod(SlayersBeasts.MOD_ID)
public class SBNeoForge {
	public SBNeoForge(final IEventBus bus) {
		SlayersBeasts.init();
		NeoForgePlatformHandler.register(bus);

		bus.addListener((FMLCommonSetupEvent event) -> event.enqueueWork(() -> {
			SlayersBeasts.commonSetup();
			SlayersBeasts.registerRegions();
		}));
		bus.addListener((EntityAttributeCreationEvent event) -> SBEntities.registerAttributes(event::put));
		bus.addListener((RegisterSpawnPlacementsEvent event) -> SBEntities.registerSpawns(placement -> event.register(placement.entity(), placement.placement(), placement.heightmap(), placement.predicate(), RegisterSpawnPlacementsEvent.Operation.OR)));
	}
}
