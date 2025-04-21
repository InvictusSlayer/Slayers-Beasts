package net.invictusslayer.slayersbeasts.common.init;

import dev.architectury.registry.client.level.entity.EntityModelLayerRegistry;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import dev.architectury.registry.level.entity.EntityAttributeRegistry;
import dev.architectury.registry.level.entity.SpawnPlacementsRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.block.WoodFamily;
import net.invictusslayer.slayersbeasts.common.client.model.*;
import net.invictusslayer.slayersbeasts.common.client.renderer.*;
import net.invictusslayer.slayersbeasts.common.entity.*;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.levelgen.Heightmap;

public class SBEntities {
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(SlayersBeasts.MOD_ID, Registries.ENTITY_TYPE);

	public static final RegistrySupplier<EntityType<Mantis>> MANTIS = register("mantis", EntityType.Builder.of(Mantis::new, MobCategory.MONSTER).sized(1.6F,1.4F));

	public static final RegistrySupplier<EntityType<AntWorker>> ANT_WORKER = register("ant_worker", EntityType.Builder.of(AntWorker::new, MobCategory.AMBIENT).sized(0.7F,0.4F));
	public static final RegistrySupplier<EntityType<AntSoldier>> ANT_SOLDIER = register("ant_soldier", EntityType.Builder.of(AntSoldier::new, MobCategory.CREATURE).sized(1.8F,0.9F));
	public static final RegistrySupplier<EntityType<AntQueen>> ANT_QUEEN = register("ant_queen", EntityType.Builder.of(AntQueen::new, MobCategory.CREATURE).sized(2.2F,1.2F));

	public static final RegistrySupplier<EntityType<WitherSpider>> WITHER_SPIDER = register("wither_spider", EntityType.Builder.of(WitherSpider::new, MobCategory.MONSTER).sized(1.8F,0.7F));
	public static final RegistrySupplier<EntityType<Tyrachnid>> TYRACHNID = register("tyrachnid", EntityType.Builder.of(Tyrachnid::new, MobCategory.MONSTER).sized(3.5F,2F));

	public static final RegistrySupplier<EntityType<Damselfly>> DAMSELFLY = register("damselfly", EntityType.Builder.of(Damselfly::new, MobCategory.AMBIENT).sized(0.8F,0.2F));

	public static final RegistrySupplier<EntityType<EntMedium>> ENT_MEDIUM = register("ent_medium", EntityType.Builder.of(EntMedium::new, MobCategory.MONSTER).sized(1.3F,5.4F));
	public static final RegistrySupplier<EntityType<Wudu>> WUDU = register("wudu", EntityType.Builder.of(Wudu::new, MobCategory.MONSTER).sized(1.0F,1.0F));

	public static final RegistrySupplier<EntityType<Sporetrap>> SPORETRAP = register("sporetrap", EntityType.Builder.of(Sporetrap::new, MobCategory.MONSTER).sized(0.8F,1.8F));

	public static final RegistrySupplier<EntityType<Irk>> IRK = register("irk", EntityType.Builder.of(Irk::new, MobCategory.MONSTER).sized(0.7F,0.8F));

	public static final RegistrySupplier<EntityType<Boat>> ASPEN_BOAT = registerBoat("aspen_boat", SBItems.ASPEN_BOAT);
	public static final RegistrySupplier<EntityType<ChestBoat>> ASPEN_CHEST_BOAT = registerChestBoat("aspen_chest_boat", SBItems.ASPEN_CHEST_BOAT);
	public static final RegistrySupplier<EntityType<Boat>> BLOODWOOD_BOAT = registerBoat("bloodwood_boat", SBItems.BLOODWOOD_BOAT);
	public static final RegistrySupplier<EntityType<ChestBoat>> BLOODWOOD_CHEST_BOAT = registerChestBoat("bloodwood_chest_boat", SBItems.BLOODWOOD_CHEST_BOAT);
	public static final RegistrySupplier<EntityType<Boat>> DESERT_OAK_BOAT = registerBoat("desert_oak_boat", SBItems.DESERT_OAK_BOAT);
	public static final RegistrySupplier<EntityType<ChestBoat>> DESERT_OAK_CHEST_BOAT = registerChestBoat("desert_oak_chest_boat", SBItems.DESERT_OAK_CHEST_BOAT);
	public static final RegistrySupplier<EntityType<Boat>> EUCALYPTUS_BOAT = registerBoat("eucalyptus_boat", SBItems.EUCALYPTUS_BOAT);
	public static final RegistrySupplier<EntityType<ChestBoat>> EUCALYPTUS_CHEST_BOAT = registerChestBoat("eucalyptus_chest_boat", SBItems.EUCALYPTUS_CHEST_BOAT);
	public static final RegistrySupplier<EntityType<Boat>> KAPOK_BOAT = registerBoat("kapok_boat", SBItems.KAPOK_BOAT);
	public static final RegistrySupplier<EntityType<ChestBoat>> KAPOK_CHEST_BOAT = registerChestBoat("kapok_chest_boat", SBItems.KAPOK_CHEST_BOAT);
	public static final RegistrySupplier<EntityType<Boat>> REDWOOD_BOAT = registerBoat("redwood_boat", SBItems.REDWOOD_BOAT);
	public static final RegistrySupplier<EntityType<ChestBoat>> REDWOOD_CHEST_BOAT = registerChestBoat("redwood_chest_boat", SBItems.REDWOOD_CHEST_BOAT);
	public static final RegistrySupplier<EntityType<Boat>> WILLOW_BOAT = registerBoat("willow_boat", SBItems.WILLOW_BOAT);
	public static final RegistrySupplier<EntityType<ChestBoat>> WILLOW_CHEST_BOAT = registerChestBoat("willow_chest_boat", SBItems.WILLOW_CHEST_BOAT);

	public static void registerSpawns() {
		SpawnPlacementsRegistry.register(MANTIS, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Mantis::canSpawn);
		SpawnPlacementsRegistry.register(ANT_WORKER, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.WORLD_SURFACE, AntWorker::canSpawn);
		SpawnPlacementsRegistry.register(ANT_SOLDIER, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.WORLD_SURFACE, AntSoldier::canSpawn);
		SpawnPlacementsRegistry.register(ANT_QUEEN, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.WORLD_SURFACE, AntQueen::canSpawn);
		SpawnPlacementsRegistry.register(WITHER_SPIDER, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.WORLD_SURFACE, WitherSpider::canSpawn);
		SpawnPlacementsRegistry.register(DAMSELFLY, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Damselfly::canSpawn);
		SpawnPlacementsRegistry.register(ENT_MEDIUM, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.WORLD_SURFACE, EntMedium::canSpawn);
		SpawnPlacementsRegistry.register(SPORETRAP, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Sporetrap::canSpawn);
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

		WoodFamily.getAllFamilies().forEach(family -> {
			if (family.getBoatLayer(false) != null) {
				EntityModelLayerRegistry.register(family.getBoatLayer(false), BoatModel::createBoatModel);
				EntityRendererRegistry.register((RegistrySupplier<EntityType<Boat>>) family.get(WoodFamily.Variant.BOAT), context -> new BoatRenderer(context, family.getBoatLayer(false)));
			}
			if (family.getBoatLayer(true) != null) {
				EntityModelLayerRegistry.register(family.getBoatLayer(true), BoatModel::createChestBoatModel);
				EntityRendererRegistry.register((RegistrySupplier<EntityType<ChestBoat>>) family.get(WoodFamily.Variant.CHEST_BOAT), context -> new BoatRenderer(context, family.getBoatLayer(true)));
			}
		});
	}

	public static RegistrySupplier<EntityType<Boat>> registerBoat(String name, RegistrySupplier<Item> item) {
		return register(name, EntityType.Builder.of((EntityType.EntityFactory<Boat>) (type, level) -> new Boat(type, level, item), MobCategory.MISC).noLootTable().sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10));
	}

	public static RegistrySupplier<EntityType<ChestBoat>> registerChestBoat(String name, RegistrySupplier<Item> item) {
		return register(name, EntityType.Builder.of((EntityType.EntityFactory<ChestBoat>) (type, level) -> new ChestBoat(type, level, item), MobCategory.MISC).noLootTable().sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10));
	}

	public static <T extends Entity> RegistrySupplier<EntityType<T>> register(String name, EntityType.Builder<T> builder) {
		return ENTITIES.register(name, () -> builder.build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, name))));
	}
}
