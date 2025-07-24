package net.invictusslayer.slayersbeasts.client;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.SBClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@Mod(value = SlayersBeasts.MOD_ID, dist = Dist.CLIENT)
public class SBNeoForgeClient {
	public SBNeoForgeClient(final IEventBus bus) {
		bus.addListener((FMLClientSetupEvent event) -> event.enqueueWork(SlayersBeasts::clientSetup));
		bus.addListener((EntityRenderersEvent.RegisterLayerDefinitions event) -> SBClient.registerModelLayers(event::registerLayerDefinition));
		bus.addListener((EntityRenderersEvent.RegisterRenderers event) -> SBClient.registerRenderers(event::registerEntityRenderer));
	}
}
