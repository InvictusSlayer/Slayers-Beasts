package net.invictusslayer.slayersbeasts.common.init;

import dev.architectury.registry.client.level.entity.EntityModelLayerRegistry;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import dev.architectury.registry.level.entity.EntityAttributeRegistry;
import dev.architectury.registry.level.entity.SpawnPlacementsRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.client.model.*;
import net.invictusslayer.slayersbeasts.common.client.renderer.*;
import net.invictusslayer.slayersbeasts.common.entity.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;

public class SBEntities {
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(SlayersBeasts.MOD_ID, Registries.ENTITY_TYPE);

	public static final RegistrySupplier<EntityType<Mantis>> MANTIS = ENTITIES.register("mantis", () -> EntityType.Builder.of(Mantis::new, MobCategory.MONSTER).sized(1.6F, 1.4F).build("mantis"));

	public static final RegistrySupplier<EntityType<AntWorker>> ANT_WORKER = ENTITIES.register("ant_worker", () -> EntityType.Builder.of(AntWorker::new, MobCategory.AMBIENT).sized(0.7F, 0.4F).build("ant_worker"));
	public static final RegistrySupplier<EntityType<AntSoldier>> ANT_SOLDIER = ENTITIES.register("ant_soldier", () -> EntityType.Builder.of(AntSoldier::new, MobCategory.CREATURE).sized(1.8F, 0.9F).build("ant_soldier"));
	public static final RegistrySupplier<EntityType<AntQueen>> ANT_QUEEN = ENTITIES.register("ant_queen", () -> EntityType.Builder.of(AntQueen::new, MobCategory.CREATURE).sized(2.2F, 1.2F).build("ant_queen"));

	public static final RegistrySupplier<EntityType<WitherSpider>> WITHER_SPIDER = ENTITIES.register("wither_spider", () -> EntityType.Builder.of(WitherSpider::new, MobCategory.MONSTER).sized(1.8F, 0.7F).build("wither_spider"));
	public static final RegistrySupplier<EntityType<Tyrachnid>> TYRACHNID = ENTITIES.register("tyrachnid", () -> EntityType.Builder.of(Tyrachnid::new, MobCategory.MONSTER).sized(3.5F, 2F).build("tyrachnid"));

	public static final RegistrySupplier<EntityType<Damselfly>> DAMSELFLY = ENTITIES.register("damselfly", () -> EntityType.Builder.of(Damselfly::new, MobCategory.AMBIENT).sized(0.8F, 0.2F).build("damselfly"));

	public static final RegistrySupplier<EntityType<EntMedium>> ENT_MEDIUM = ENTITIES.register("ent_medium", () -> EntityType.Builder.of(EntMedium::new, MobCategory.MONSTER).sized(1.3F, 5.4F).build("ent_medium"));
	public static final RegistrySupplier<EntityType<Wudu>> WUDU = ENTITIES.register("wudu", () -> EntityType.Builder.of(Wudu::new, MobCategory.MONSTER).sized(1.0F, 1.0F).build("wudu"));

	public static final RegistrySupplier<EntityType<Sporetrap>> SPORETRAP = ENTITIES.register("sporetrap", () -> EntityType.Builder.of(Sporetrap::new, MobCategory.MONSTER).sized(0.8F, 1.8F).build("sporetrap"));

	public static final RegistrySupplier<EntityType<Irk>> IRK = ENTITIES.register("irk", () -> EntityType.Builder.of(Irk::new, MobCategory.MONSTER).sized(0.7F, 0.8F).build("irk"));

	public static void registerSpawns() {
		SpawnPlacementsRegistry.register(MANTIS, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Mantis::canSpawn);
		SpawnPlacementsRegistry.register(ANT_WORKER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, AntWorker::canSpawn);
		SpawnPlacementsRegistry.register(ANT_SOLDIER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, AntSoldier::canSpawn);
		SpawnPlacementsRegistry.register(ANT_QUEEN, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, AntQueen::canSpawn);
		SpawnPlacementsRegistry.register(WITHER_SPIDER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, WitherSpider::canSpawn);
		SpawnPlacementsRegistry.register(DAMSELFLY, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Damselfly::canSpawn);
		SpawnPlacementsRegistry.register(ENT_MEDIUM, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, EntMedium::canSpawn);
		SpawnPlacementsRegistry.register(SPORETRAP, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Sporetrap::canSpawn);
	}

	public static void registerAttributes() {
		EntityAttributeRegistry.register(MANTIS, Mantis::createAttributes);
		EntityAttributeRegistry.register(ANT_WORKER, AntWorker::createAttributes);
		EntityAttributeRegistry.register(ANT_SOLDIER, AntSoldier::createAttributes);
		EntityAttributeRegistry.register(ANT_QUEEN, AntQueen::createAttributes);
		EntityAttributeRegistry.register(WITHER_SPIDER, WitherSpider::createAttributes);
		EntityAttributeRegistry.register(TYRACHNID, Tyrachnid::createAttributes);
		EntityAttributeRegistry.register(DAMSELFLY, Damselfly::createAttributes);
		EntityAttributeRegistry.register(ENT_MEDIUM, EntMedium::createAttributes);
		EntityAttributeRegistry.register(WUDU, Wudu::createAttributes);
		EntityAttributeRegistry.register(SPORETRAP, Sporetrap::createAttributes);
		EntityAttributeRegistry.register(IRK, Irk::createAttributes);
	}

	public static void registerLayersAndRenderers() {
		EntityModelLayerRegistry.register(MantisModel.LAYER_LOCATION, MantisModel::createBodyLayer);
		EntityModelLayerRegistry.register(AntWorkerModel.LAYER_LOCATION, AntWorkerModel::createBodyLayer);
		EntityModelLayerRegistry.register(AntSoldierModel.LAYER_LOCATION, AntSoldierModel::createBodyLayer);
		EntityModelLayerRegistry.register(AntQueenModel.LAYER_LOCATION, AntQueenModel::createBodyLayer);
		EntityModelLayerRegistry.register(AntCargoModel.LAYER_LOCATION, AntCargoModel::createCargoLayer);
		EntityModelLayerRegistry.register(WitherSpiderModel.LAYER_LOCATION, WitherSpiderModel::createBodyLayer);
		EntityModelLayerRegistry.register(TyrachnidModel.LAYER_LOCATION, TyrachnidModel::createBodyLayer);
		EntityModelLayerRegistry.register(DamselflyModel.LAYER_LOCATION, DamselflyModel::createBodyLayer);
		EntityModelLayerRegistry.register(EntMediumModel.LAYER_LOCATION, EntMediumModel::createBodyLayer);
		EntityModelLayerRegistry.register(WuduModel.LAYER_LOCATION, WuduModel::createBodyLayer);
		EntityModelLayerRegistry.register(SporetrapModel.LAYER_LOCATION, SporetrapModel::createBodyLayer);
		EntityModelLayerRegistry.register(IrkModel.LAYER_LOCATION, IrkModel::createBodyLayer);

		EntityRendererRegistry.register(MANTIS, MantisRenderer::new);
		EntityRendererRegistry.register(ANT_WORKER, AntWorkerRenderer::new);
		EntityRendererRegistry.register(ANT_SOLDIER, AntSoldierRenderer::new);
		EntityRendererRegistry.register(ANT_QUEEN, AntQueenRenderer::new);
		EntityRendererRegistry.register(WITHER_SPIDER, WitherSpiderRenderer::new);
		EntityRendererRegistry.register(TYRACHNID, TyrachnidRenderer::new);
		EntityRendererRegistry.register(DAMSELFLY, DamselflyRenderer::new);
		EntityRendererRegistry.register(ENT_MEDIUM, EntMediumRenderer::new);
		EntityRendererRegistry.register(WUDU, WuduRenderer::new);
		EntityRendererRegistry.register(SPORETRAP, SporetrapRenderer::new);
		EntityRendererRegistry.register(IRK, IrkRenderer::new);
	}
}
