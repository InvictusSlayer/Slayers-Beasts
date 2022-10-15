package net.invictusslayer.slayersbeasts.events;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.*;
import net.invictusslayer.slayersbeasts.client.renderer.*;
import net.invictusslayer.slayersbeasts.init.ModEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SlayersBeasts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientModEvents {
    private ClientModEvents() {}

    @SubscribeEvent
    public static void clientSetup(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(MantisModel.LAYER_LOCATION, MantisModel::createBodyLayer);
        event.registerLayerDefinition(TinyAntModel.LAYER_LOCATION, TinyAntModel::createBodyLayer);
        event.registerLayerDefinition(AmbientDragonflyModel.LAYER_LOCATION, AmbientDragonflyModel::createBodyLayer);
        event.registerLayerDefinition(VenusFlytrapModel.LAYER_LOCATION, VenusFlytrapModel::createBodyLayer);
        event.registerLayerDefinition(WitherSpiderModel.LAYER_LOCATION, WitherSpiderModel::createBodyLayer);
        event.registerLayerDefinition(ExampleModel.LAYER_LOCATION, ExampleModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.MANTIS_ENTITY.get(), MantisRenderer::new);
        event.registerEntityRenderer(ModEntities.TINY_ANT_ENTITY.get(), TinyAntRenderer::new);
        event.registerEntityRenderer(ModEntities.AMBIENT_DRAGONFLY_ENTITY.get(), AmbientDragonflyRenderer::new);
        event.registerEntityRenderer(ModEntities.VENUS_FLYTRAP_ENTITY.get(), VenusFlytrapRenderer::new);
        event.registerEntityRenderer(ModEntities.WITHER_SPIDER_ENTITY.get(), WitherSpiderRenderer::new);
        event.registerEntityRenderer(ModEntities.EXAMPLE_ENTITY.get(), ExampleRenderer::new);
    }
}
