package net.invictusslayer.slayersbeasts.event;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.*;
import net.invictusslayer.slayersbeasts.client.renderer.*;
import net.invictusslayer.slayersbeasts.entity.SBEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = SlayersBeasts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class SBClientEvents {
	public static void clientSetup(FMLClientSetupEvent event) {}

	@SubscribeEvent
	public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(MantisModel.LAYER_LOCATION, MantisModel::createBodyLayer);
		event.registerLayerDefinition(AntWorkerModel.LAYER_LOCATION, AntWorkerModel::createBodyLayer);
		event.registerLayerDefinition(AntSoldierModel.LAYER_LOCATION, AntSoldierModel::createBodyLayer);
		event.registerLayerDefinition(AntQueenModel.LAYER_LOCATION, AntQueenModel::createBodyLayer);
		event.registerLayerDefinition(AntCargoModel.LAYER_LOCATION, AntCargoModel::createCargoLayer);
		event.registerLayerDefinition(WitherSpiderModel.LAYER_LOCATION, WitherSpiderModel::createBodyLayer);
		event.registerLayerDefinition(TyrachnidModel.LAYER_LOCATION, TyrachnidModel::createBodyLayer);
		event.registerLayerDefinition(DamselflyModel.LAYER_LOCATION, DamselflyModel::createBodyLayer);
		event.registerLayerDefinition(EntMediumModel.LAYER_LOCATION, EntMediumModel::createBodyLayer);
		event.registerLayerDefinition(VenusFlytrapModel.LAYER_LOCATION, VenusFlytrapModel::createBodyLayer);
	}

	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(SBEntities.MANTIS.get(), MantisRenderer::new);
		event.registerEntityRenderer(SBEntities.ANT_WORKER.get(), AntWorkerRenderer::new);
		event.registerEntityRenderer(SBEntities.ANT_SOLDIER.get(), AntSoldierRenderer::new);
		event.registerEntityRenderer(SBEntities.ANT_QUEEN.get(), AntQueenRenderer::new);
		event.registerEntityRenderer(SBEntities.WITHER_SPIDER.get(), WitherSpiderRenderer::new);
		event.registerEntityRenderer(SBEntities.TYRACHNID.get(), TyrachnidRenderer::new);
		event.registerEntityRenderer(SBEntities.DAMSELFLY.get(), DamselflyRenderer::new);
		event.registerEntityRenderer(SBEntities.ENT_OAK.get(), EntMediumRenderer::new);
		event.registerEntityRenderer(SBEntities.ENT_BIRCH.get(), EntMediumRenderer::new);
		event.registerEntityRenderer(SBEntities.VENUS_FLYTRAP.get(), VenusFlytrapRenderer::new);
	}
}
