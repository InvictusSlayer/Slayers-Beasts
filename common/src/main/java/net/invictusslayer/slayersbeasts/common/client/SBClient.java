package net.invictusslayer.slayersbeasts.common.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.invictusslayer.slayersbeasts.common.block.WoodFamily;
import net.invictusslayer.slayersbeasts.common.client.model.*;
import net.invictusslayer.slayersbeasts.common.client.renderer.*;
import net.invictusslayer.slayersbeasts.common.init.SBEntities;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

@Environment(EnvType.CLIENT)
public class SBClient {
	public static void registerModelLayers(BiConsumer<ModelLayerLocation, Supplier<LayerDefinition>> consumer) {
		consumer.accept(MantisModel.LAYER_LOCATION, MantisModel::createBodyLayer);
		consumer.accept(AntWorkerModel.LAYER_LOCATION, AntWorkerModel::createBodyLayer);
		consumer.accept(AntSoldierModel.LAYER_LOCATION, AntSoldierModel::createBodyLayer);
		consumer.accept(AntQueenModel.LAYER_LOCATION, AntQueenModel::createBodyLayer);
		consumer.accept(AntCargoModel.LAYER_LOCATION, AntCargoModel::createCargoLayer);
		consumer.accept(WitherSpiderModel.LAYER_LOCATION, WitherSpiderModel::createBodyLayer);
		consumer.accept(TyrachnidModel.LAYER_LOCATION, TyrachnidModel::createBodyLayer);
		consumer.accept(DamselflyModel.LAYER_LOCATION, DamselflyModel::createBodyLayer);
		consumer.accept(EntMediumModel.LAYER_LOCATION, EntMediumModel::createBodyLayer);
		consumer.accept(WuduModel.LAYER_LOCATION, WuduModel::createBodyLayer);
		consumer.accept(SporetrapModel.LAYER_LOCATION, SporetrapModel::createBodyLayer);
		consumer.accept(IrkModel.LAYER_LOCATION, IrkModel::createBodyLayer);

		WoodFamily.getAllFamilies().forEach(family -> {
			if (family.getBoatLayer(false) != null) consumer.accept(family.getBoatLayer(false), BoatModel::createBoatModel);
			if (family.getBoatLayer(true) != null) consumer.accept(family.getBoatLayer(true), BoatModel::createChestBoatModel);
		});
	}

	public static void registerRenderers(BiConsumer<EntityType<? extends Entity>, EntityRendererProvider> consumer) {
		consumer.accept(SBEntities.MANTIS.get(), MantisRenderer::new);
		consumer.accept(SBEntities.ANT_WORKER.get(), AntWorkerRenderer::new);
		consumer.accept(SBEntities.ANT_SOLDIER.get(), AntSoldierRenderer::new);
		consumer.accept(SBEntities.ANT_QUEEN.get(), AntQueenRenderer::new);
		consumer.accept(SBEntities.WITHER_SPIDER.get(), WitherSpiderRenderer::new);
		consumer.accept(SBEntities.TYRACHNID.get(), TyrachnidRenderer::new);
		consumer.accept(SBEntities.DAMSELFLY.get(), DamselflyRenderer::new);
		consumer.accept(SBEntities.ENT_MEDIUM.get(), EntMediumRenderer::new);
		consumer.accept(SBEntities.WUDU.get(), WuduRenderer::new);
		consumer.accept(SBEntities.SPORETRAP.get(), SporetrapRenderer::new);
		consumer.accept(SBEntities.IRK.get(), IrkRenderer::new);

		WoodFamily.getAllFamilies().forEach(family -> {
			if (family.getBoatLayer(false) != null) consumer.accept((EntityType<Boat>) family.get(WoodFamily.Variant.BOAT).get(), context -> new BoatRenderer(context, family.getBoatLayer(false)));
			if (family.getBoatLayer(true) != null) consumer.accept((EntityType<ChestBoat>) family.get(WoodFamily.Variant.CHEST_BOAT).get(), context -> new BoatRenderer(context, family.getBoatLayer(true)));
		});
	}
}
