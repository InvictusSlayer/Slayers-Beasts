package net.invictusslayer.slayersbeasts.forge.client;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.client.SBClient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@OnlyIn(Dist.CLIENT)
public class SBForgeClient {
	public static void init(final FMLJavaModLoadingContext context) {
		IEventBus bus = context.getModEventBus();
		bus.addListener((FMLClientSetupEvent event) -> event.enqueueWork(SlayersBeasts::clientSetup));
		bus.addListener((EntityRenderersEvent.RegisterLayerDefinitions event) -> SBClient.registerModelLayers(event::registerLayerDefinition));
		bus.addListener((EntityRenderersEvent.RegisterRenderers event) -> SBClient.registerRenderers(event::registerEntityRenderer));
	}
}
