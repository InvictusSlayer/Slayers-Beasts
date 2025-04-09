package net.invictusslayer.slayersbeasts.init;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.WoodFamily;
import net.invictusslayer.slayersbeasts.client.model.*;
import net.invictusslayer.slayersbeasts.client.renderer.*;
import net.invictusslayer.slayersbeasts.entity.*;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.vehicle.AbstractBoat;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.levelgen.Heightmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class SBEntities {
	//? if neoforge {
	/*public static final Map<ModelLayerLocation, Supplier<LayerDefinition>> MODEL_LAYERS = new HashMap<>();
	public static final Map<EntityType<? extends Entity>, EntityRendererProvider<Entity>> RENDERERS = new HashMap<>();
	public static final Map<EntityType<? extends LivingEntity>, AttributeSupplier.Builder> ATTRIBUTES = new HashMap<>();
	public static final List<SpawnPlacementEntry<Mob>> SPAWN_PLACEMENTS = new ArrayList<>();

	public record SpawnPlacementEntry<T extends Mob>(EntityType<T> entity, SpawnPlacementType spawnPlacement, Heightmap.Types heightmap, SpawnPlacements.SpawnPredicate<T> spawnPredicate) {}

	public static final net.neoforged.neoforge.registries.DeferredRegister<EntityType<?>> ENTITIES = net.neoforged.neoforge.registries.DeferredRegister.create(Registries.ENTITY_TYPE, SlayersBeasts.MOD_ID);
	*///?}

	public static final Supplier<EntityType<Mantis>> MANTIS = register("mantis", EntityType.Builder.of(Mantis::new, MobCategory.MONSTER).sized(1.9F,2F));

	public static final Supplier<EntityType<AntWorker>> ANT_WORKER = register("ant_worker", EntityType.Builder.of(AntWorker::new, MobCategory.AMBIENT).sized(0.7F,0.4F));
	public static final Supplier<EntityType<AntSoldier>> ANT_SOLDIER = register("ant_soldier", EntityType.Builder.of(AntSoldier::new, MobCategory.CREATURE).sized(1.8F,0.9F));
	public static final Supplier<EntityType<AntQueen>> ANT_QUEEN = register("ant_queen", EntityType.Builder.of(AntQueen::new, MobCategory.CREATURE).sized(2.2F,1.2F));

	public static final Supplier<EntityType<WitherSpider>> WITHER_SPIDER = register("wither_spider", EntityType.Builder.of(WitherSpider::new, MobCategory.MONSTER).sized(1.8F,0.7F));
	public static final Supplier<EntityType<Tyrachnid>> TYRACHNID = register("tyrachnid", EntityType.Builder.of(Tyrachnid::new, MobCategory.MONSTER).sized(3.5F,2F));

	public static final Supplier<EntityType<Damselfly>> DAMSELFLY = register("damselfly", EntityType.Builder.of(Damselfly::new, MobCategory.AMBIENT).sized(0.8F,0.2F));

	public static final Supplier<EntityType<EntMedium>> ENT_MEDIUM = register("ent_medium", EntityType.Builder.of(EntMedium::new, MobCategory.MONSTER).sized(1.3F,5.4F));
	public static final Supplier<EntityType<Wudu>> WUDU = register("wudu", EntityType.Builder.of(Wudu::new, MobCategory.MONSTER).sized(1.0F,1.0F));

	public static final Supplier<EntityType<Sporetrap>> SPORETRAP = register("sporetrap", EntityType.Builder.of(Sporetrap::new, MobCategory.MONSTER).sized(0.8F,1.8F));

	public static final Supplier<EntityType<Irk>> IRK = register("irk", EntityType.Builder.of(Irk::new, MobCategory.MONSTER).sized(0.7F,0.8F));

	public static final Supplier<EntityType<Boat>> ASPEN_BOAT = registerBoat("aspen_boat", SBItems.ASPEN_BOAT);
	public static final Supplier<EntityType<ChestBoat>> ASPEN_CHEST_BOAT = registerChestBoat("aspen_chest_boat", SBItems.ASPEN_CHEST_BOAT);
	public static final Supplier<EntityType<Boat>> DESERT_OAK_BOAT = registerBoat("desert_oak_boat", SBItems.DESERT_OAK_BOAT);
	public static final Supplier<EntityType<ChestBoat>> DESERT_OAK_CHEST_BOAT = registerChestBoat("desert_oak_chest_boat", SBItems.DESERT_OAK_CHEST_BOAT);
	public static final Supplier<EntityType<Boat>> EUCALYPTUS_BOAT = registerBoat("eucalyptus_boat", SBItems.EUCALYPTUS_BOAT);
	public static final Supplier<EntityType<ChestBoat>> EUCALYPTUS_CHEST_BOAT = registerChestBoat("eucalyptus_chest_boat", SBItems.EUCALYPTUS_CHEST_BOAT);
	public static final Supplier<EntityType<Boat>> KAPOK_BOAT = registerBoat("kapok_boat", SBItems.KAPOK_BOAT);
	public static final Supplier<EntityType<ChestBoat>> KAPOK_CHEST_BOAT = registerChestBoat("kapok_chest_boat", SBItems.KAPOK_CHEST_BOAT);
	public static final Supplier<EntityType<Boat>> REDWOOD_BOAT = registerBoat("redwood_boat", SBItems.REDWOOD_BOAT);
	public static final Supplier<EntityType<ChestBoat>> REDWOOD_CHEST_BOAT = registerChestBoat("redwood_chest_boat", SBItems.REDWOOD_CHEST_BOAT);
	public static final Supplier<EntityType<Boat>> WILLOW_BOAT = registerBoat("willow_boat", SBItems.WILLOW_BOAT);
	public static final Supplier<EntityType<ChestBoat>> WILLOW_CHEST_BOAT = registerChestBoat("willow_chest_boat", SBItems.WILLOW_CHEST_BOAT);

	public static void registerSpawns() {
		registerSpawn(MANTIS, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Mantis::canSpawn);
		registerSpawn(ANT_WORKER, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.WORLD_SURFACE, AntWorker::canSpawn);
		registerSpawn(ANT_SOLDIER, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.WORLD_SURFACE, AntSoldier::canSpawn);
		registerSpawn(ANT_QUEEN, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.WORLD_SURFACE, AntQueen::canSpawn);
		registerSpawn(DAMSELFLY, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Damselfly::canSpawn);
		registerSpawn(ENT_MEDIUM, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.WORLD_SURFACE, EntMedium::canSpawn);
		registerSpawn(SPORETRAP, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Sporetrap::canSpawn);

		SlayersBeasts.LOGGER.info("Registered Spawn Placements");
	}

	public static void registerAttributes() {
		registerAttribute(MANTIS, Mantis.createAttributes());
		registerAttribute(ANT_WORKER, AntWorker.createAttributes());
		registerAttribute(ANT_SOLDIER, AntSoldier.createAttributes());
		registerAttribute(ANT_QUEEN, AntQueen.createAttributes());
		registerAttribute(WITHER_SPIDER, WitherSpider.createAttributes());
		registerAttribute(TYRACHNID, Tyrachnid.createAttributes());
		registerAttribute(DAMSELFLY, Damselfly.createAttributes());
		registerAttribute(ENT_MEDIUM, EntMedium.createAttributes());
		registerAttribute(WUDU, Wudu.createAttributes());
		registerAttribute(SPORETRAP, Sporetrap.createAttributes());
		registerAttribute(IRK, Irk.createAttributes());

		SlayersBeasts.LOGGER.info("Registered Mob Attributes");
	}

	public static void registerLayersAndRenderers() {
		registerModelLayer(MantisModel.LAYER_LOCATION, MantisModel.createBodyLayer());
		registerModelLayer(AntWorkerModel.LAYER_LOCATION, AntWorkerModel.createBodyLayer());
		registerModelLayer(AntSoldierModel.LAYER_LOCATION, AntSoldierModel.createBodyLayer());
		registerModelLayer(AntQueenModel.LAYER_LOCATION, AntQueenModel.createBodyLayer());
		registerModelLayer(AntCargoModel.LAYER_LOCATION, AntCargoModel.createCargoLayer());
		registerModelLayer(WitherSpiderModel.LAYER_LOCATION, WitherSpiderModel.createBodyLayer());
		registerModelLayer(TyrachnidModel.LAYER_LOCATION, TyrachnidModel.createBodyLayer());
		registerModelLayer(DamselflyModel.LAYER_LOCATION, DamselflyModel.createBodyLayer());
		registerModelLayer(EntMediumModel.LAYER_LOCATION, EntMediumModel.createBodyLayer());
		registerModelLayer(WuduModel.LAYER_LOCATION, WuduModel.createBodyLayer());
		registerModelLayer(SporetrapModel.LAYER_LOCATION, SporetrapModel.createBodyLayer());
		registerModelLayer(IrkModel.LAYER_LOCATION, IrkModel.createBodyLayer());

		registerRenderer(MANTIS, MantisRenderer::new);
		registerRenderer(ANT_WORKER, AntWorkerRenderer::new);
		registerRenderer(ANT_SOLDIER, AntSoldierRenderer::new);
		registerRenderer(ANT_QUEEN, AntQueenRenderer::new);
		registerRenderer(WITHER_SPIDER, WitherSpiderRenderer::new);
		registerRenderer(TYRACHNID, TyrachnidRenderer::new);
		registerRenderer(DAMSELFLY, DamselflyRenderer::new);
		registerRenderer(ENT_MEDIUM, EntMediumRenderer::new);
		registerRenderer(WUDU, WuduRenderer::new);
		registerRenderer(SPORETRAP, SporetrapRenderer::new);
		registerRenderer(IRK, IrkRenderer::new);

		WoodFamily.getAllFamilies().forEach(family -> {
			if (family.getBoatLayer(false) != null) {
				registerModelLayer(family.getBoatLayer(false), BoatModel.createBoatModel());
				registerRenderer((Supplier<EntityType<AbstractBoat>>) family.get(WoodFamily.Variant.BOAT), context -> new BoatRenderer(context, family.getBoatLayer(false)));
			}
			if (family.getBoatLayer(true) != null) {
				registerModelLayer(family.getBoatLayer(true), BoatModel.createChestBoatModel());
				registerRenderer((Supplier<EntityType<AbstractBoat>>) family.get(WoodFamily.Variant.CHEST_BOAT), context -> new BoatRenderer(context, family.getBoatLayer(true)));
			}
		});

		SlayersBeasts.LOGGER.info("Registered Model Layers and Renderers");
	}

	private static <T extends Mob> void registerSpawn(Supplier<EntityType<T>> entity, SpawnPlacementType placement, Heightmap.Types heightmap, SpawnPlacements.SpawnPredicate<T> predicate) {
		//? if fabric
		SpawnPlacements.register(entity.get(), placement, heightmap, predicate);
		//? if neoforge
		/*SPAWN_PLACEMENTS.add((SpawnPlacementEntry<Mob>) new SpawnPlacementEntry<T>(entity.get(), placement, heightmap, predicate));*/
	}

	private static <T extends LivingEntity> void registerAttribute(Supplier<EntityType<T>> entity, AttributeSupplier.Builder attributes) {
		//? if fabric
		net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry.register(entity.get(), attributes);
		//? if neoforge
		/*ATTRIBUTES.put(entity.get(), attributes);*/
	}

	private static <T extends Entity> void registerModelLayer(ModelLayerLocation layer, LayerDefinition model) {
		//? if fabric
		net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry.registerModelLayer(layer, () -> model);
		//? if neoforge
		/*MODEL_LAYERS.put(layer, () -> model);*/
	}

	private static <T extends Entity> void registerRenderer(Supplier<EntityType<T>> entity, EntityRendererProvider<T> renderer) {
		//? if fabric
		net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry.register(entity.get(), renderer);
		//? if neoforge
		/*RENDERERS.put(entity.get(), (EntityRendererProvider<Entity>) renderer);*/
	}

	public static Supplier<EntityType<Boat>> registerBoat(String name, Supplier<Item> item) {
		return register(name, EntityType.Builder.of((EntityType.EntityFactory<Boat>) (type, level) -> new Boat(type, level, item), MobCategory.MISC).noLootTable().sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10));
	}

	public static Supplier<EntityType<ChestBoat>> registerChestBoat(String name, Supplier<Item> item) {
		return register(name, EntityType.Builder.of((EntityType.EntityFactory<ChestBoat>) (type, level) -> new ChestBoat(type, level, item), MobCategory.MISC).noLootTable().sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10));
	}

	public static <T extends Entity> Supplier<EntityType<T>> register(String name, EntityType.Builder<T> builder) {
		//? if fabric {
		EntityType<T> registered = Registry.register(BuiltInRegistries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, name), builder.build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, name))));
		return () -> registered;
		//?}
		//? if neoforge
		/*return ENTITIES.register(name, () -> builder.build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, name))));*/
	}

	public static void init() {
		SlayersBeasts.LOGGER.info("Initialised Entities");
	}
}
