package net.invictusslayer.slayersbeasts.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.block.WoodFamily;
import net.invictusslayer.slayersbeasts.common.client.model.*;
import net.invictusslayer.slayersbeasts.common.client.renderer.*;
import net.invictusslayer.slayersbeasts.common.init.SBBlocks;
import net.invictusslayer.slayersbeasts.common.init.SBEntities;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;

@Environment(EnvType.CLIENT)
public class SBFabricClient implements ClientModInitializer {
	public void onInitializeClient() {
		SlayersBeasts.clientSetup();

		renderWoodFamilies();
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(),
				SBBlocks.ALGAE.get(), SBBlocks.TALL_DEAD_BUSH.get(),
				SBBlocks.BLACK_MUSHROOM.get(), SBBlocks.POTTED_BLACK_MUSHROOM.get(),
				SBBlocks.WHITE_MUSHROOM.get(), SBBlocks.POTTED_WHITE_MUSHROOM.get(),
				SBBlocks.WILLOW_BRANCH.get(), SBBlocks.WILLOW_BRANCH_PLANT.get(),
				SBBlocks.ICICLE.get(), SBBlocks.OBSIDIAN_SPIKE.get());

		EntityModelLayerRegistry.registerModelLayer(MantisModel.LAYER_LOCATION, MantisModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(AntWorkerModel.LAYER_LOCATION, AntWorkerModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(AntSoldierModel.LAYER_LOCATION, AntSoldierModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(AntQueenModel.LAYER_LOCATION, AntQueenModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(AntCargoModel.LAYER_LOCATION, AntCargoModel::createCargoLayer);
		EntityModelLayerRegistry.registerModelLayer(WitherSpiderModel.LAYER_LOCATION, WitherSpiderModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(TyrachnidModel.LAYER_LOCATION, TyrachnidModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(DamselflyModel.LAYER_LOCATION, DamselflyModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(EntMediumModel.LAYER_LOCATION, EntMediumModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(WuduModel.LAYER_LOCATION, WuduModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(SporetrapModel.LAYER_LOCATION, SporetrapModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(IrkModel.LAYER_LOCATION, IrkModel::createBodyLayer);

		EntityRendererRegistry.register(SBEntities.MANTIS.get(), MantisRenderer::new);
		EntityRendererRegistry.register(SBEntities.ANT_WORKER.get(), AntWorkerRenderer::new);
		EntityRendererRegistry.register(SBEntities.ANT_SOLDIER.get(), AntSoldierRenderer::new);
		EntityRendererRegistry.register(SBEntities.ANT_QUEEN.get(), AntQueenRenderer::new);
		EntityRendererRegistry.register(SBEntities.WITHER_SPIDER.get(), WitherSpiderRenderer::new);
		EntityRendererRegistry.register(SBEntities.TYRACHNID.get(), TyrachnidRenderer::new);
		EntityRendererRegistry.register(SBEntities.DAMSELFLY.get(), DamselflyRenderer::new);
		EntityRendererRegistry.register(SBEntities.ENT_OAK.get(), EntMediumRenderer::new);
		EntityRendererRegistry.register(SBEntities.ENT_BIRCH.get(), EntMediumRenderer::new);
		EntityRendererRegistry.register(SBEntities.WUDU_OAK.get(), WuduRenderer::new);
		EntityRendererRegistry.register(SBEntities.SPORETRAP.get(), SporetrapRenderer::new);
		EntityRendererRegistry.register(SBEntities.IRK.get(), IrkRenderer::new);
	}

	private void renderWoodFamilies() {
		WoodFamily.getAllFamilies().forEach(family -> family.getVariants().forEach((variant, supplier) -> {
			if (variant.isCutout()) BlockRenderLayerMap.INSTANCE.putBlock((Block) supplier.get(), RenderType.cutout());
		}));
	}
}
