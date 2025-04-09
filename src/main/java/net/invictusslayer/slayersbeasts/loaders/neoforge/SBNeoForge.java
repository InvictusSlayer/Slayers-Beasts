//? if neoforge {
/*package net.invictusslayer.slayersbeasts.loaders.neoforge;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.init.*;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

@Mod(SlayersBeasts.MOD_ID)
public class SBNeoForge {
	public SBNeoForge(IEventBus bus) {
		SlayersBeasts.init();

		SBBlocks.BLOCKS.register(bus);
		SBItems.ITEMS.register(bus);
		SBEntities.ENTITIES.register(bus);
		SBCreativeModeTabs.CREATIVE_TABS.register(bus);
		SBBlockEntities.BLOCK_ENTITIES.register(bus);
		SBVillagerType.VILLAGER_TYPES.register(bus);
		SBEffects.EFFECTS.register(bus);
		SBPotions.POTIONS.register(bus);
		SBSounds.SOUNDS.register(bus);
		SBDataComponents.DATA_COMPONENTS.register(bus);
		SBPois.POIS.register(bus);
		SBFeatures.FEATURES.register(bus);
		SBTreeDecorators.TREE_DECORATORS.register(bus);
		SBFoliagePlacers.FOLIAGE_PLACERS.register(bus);
		SBTrunkPlacers.TRUNK_PLACERS.register(bus);
		SBStructurePieces.STRUCTURE_PIECES.register(bus);
		SBStructureTypes.STRUCTURE_TYPES.register(bus);

//		SBBiomeModifications.registerFeatures();
		SBEntities.registerAttributes();

		bus.addListener(this::commonSetup);
		bus.addListener(this::clientSetup);

		SBEntities.registerLayersAndRenderers();

		bus.register(this);
	}

	public void commonSetup(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			SlayersBeasts.commonSetup();
			SlayersBeasts.registerRegions();
//			BrewingRecipeRegistry.addRecipe(new SBBrewingRecipe(Potions.SLOWNESS, SBItems.INSECT_EYE.get(), SBPotions.PARALYSIS_POTION.get()));
//			BrewingRecipeRegistry.addRecipe(new SBBrewingRecipe(Potions.POISON, SBItems.WITHERBONE.get(), SBPotions.WITHER_POTION.get()));
		});
	}

	@OnlyIn(Dist.CLIENT)
	public void clientSetup(FMLClientSetupEvent event) {
		event.enqueueWork(SlayersBeasts::clientSetup);
	}

	@SubscribeEvent
	public void registerSpawnPlacements(RegisterSpawnPlacementsEvent event) {
		SBEntities.SPAWN_PLACEMENTS.forEach(entry -> event.register(entry.entity(), entry.spawnPlacement(), entry.heightmap(), entry.spawnPredicate(), RegisterSpawnPlacementsEvent.Operation.OR));
	}

	@SubscribeEvent
	public void registerDefaultAttributes(EntityAttributeCreationEvent event) {
		SBEntities.ATTRIBUTES.forEach((entity, builder) -> event.put(entity, builder.build()));
	}

	@SubscribeEvent
	public void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		SBEntities.MODEL_LAYERS.forEach(event::registerLayerDefinition);
	}

	@SubscribeEvent
	public void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		SBEntities.RENDERERS.forEach(event::registerEntityRenderer);
	}
}
*///?}