package net.invictusslayer.slayersbeasts.util;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.ExampleEntityModel;
import net.invictusslayer.slayersbeasts.client.model.MantisEntityModel;
import net.invictusslayer.slayersbeasts.client.model.VenusFlytrapEntityModel;
import net.invictusslayer.slayersbeasts.client.model.WitherSpiderEntityModel;
import net.invictusslayer.slayersbeasts.client.renderer.ExampleEntityRenderer;
import net.invictusslayer.slayersbeasts.client.renderer.MantisEntityRenderer;
import net.invictusslayer.slayersbeasts.client.renderer.VenusFlytrapEntityRenderer;
import net.invictusslayer.slayersbeasts.client.renderer.WitherSpiderEntityRenderer;
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
        event.registerLayerDefinition(MantisEntityModel.LAYER_LOCATION, MantisEntityModel::createBodyLayer);
        event.registerLayerDefinition(VenusFlytrapEntityModel.LAYER_LOCATION, VenusFlytrapEntityModel::createBodyLayer);
        event.registerLayerDefinition(WitherSpiderEntityModel.LAYER_LOCATION, WitherSpiderEntityModel::createBodyLayer);
        event.registerLayerDefinition(ExampleEntityModel.LAYER_LOCATION, ExampleEntityModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.MANTIS_ENTITY.get(), MantisEntityRenderer::new);
        event.registerEntityRenderer(ModEntities.VENUS_FLYTRAP_ENTITY.get(), VenusFlytrapEntityRenderer::new);
        event.registerEntityRenderer(ModEntities.WITHER_SPIDER_ENTITY.get(), WitherSpiderEntityRenderer::new);
        event.registerEntityRenderer(ModEntities.EXAMPLE_ENTITY.get(), ExampleEntityRenderer::new);
    }
}
