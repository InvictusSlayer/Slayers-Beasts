package net.invictusslayer.slayersbeasts.event;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.*;
import net.invictusslayer.slayersbeasts.client.renderer.*;
import net.invictusslayer.slayersbeasts.entity.SBEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SlayersBeasts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientEvents {
    private ClientEvents() {}

    @SubscribeEvent
    public static void clientSetup(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(MantisModel.LAYER_LOCATION, MantisModel::createBodyLayer);
        event.registerLayerDefinition(WorkerAntModel.LAYER_LOCATION, WorkerAntModel::createBodyLayer);
        event.registerLayerDefinition(SoldierAntModel.LAYER_LOCATION, SoldierAntModel::createBodyLayer);
        event.registerLayerDefinition(QueenAntModel.LAYER_LOCATION, QueenAntModel::createBodyLayer);
        event.registerLayerDefinition(AntCargoModel.LAYER_LOCATION, AntCargoModel::createCargoLayer);
        event.registerLayerDefinition(WitherSpiderModel.LAYER_LOCATION, WitherSpiderModel::createBodyLayer);
        event.registerLayerDefinition(TarantulaModel.LAYER_LOCATION, TarantulaModel::createBodyLayer);
        event.registerLayerDefinition(DamselflyModel.LAYER_LOCATION, DamselflyModel::createBodyLayer);
        event.registerLayerDefinition(EntOakModel.LAYER_LOCATION, EntOakModel::createBodyLayer);
        event.registerLayerDefinition(VenusFlytrapModel.LAYER_LOCATION, VenusFlytrapModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(SBEntities.MANTIS.get(), MantisRenderer::new);
        event.registerEntityRenderer(SBEntities.WORKER_ANT.get(), WorkerAntRenderer::new);
        event.registerEntityRenderer(SBEntities.SOLDIER_ANT.get(), SoldierAntRenderer::new);
        event.registerEntityRenderer(SBEntities.QUEEN_ANT.get(), QueenAntRenderer::new);
        event.registerEntityRenderer(SBEntities.WITHER_SPIDER.get(), WitherSpiderRenderer::new);
        event.registerEntityRenderer(SBEntities.TARANTULA.get(), TarantulaRenderer::new);
        event.registerEntityRenderer(SBEntities.DAMSELFLY.get(), DamselflyRenderer::new);
        event.registerEntityRenderer(SBEntities.ENT_OAK.get(), EntRenderer::new);
        event.registerEntityRenderer(SBEntities.VENUS_FLYTRAP.get(), VenusFlytrapRenderer::new);
    }
}
