package net.invictusslayer.slayersbeasts.event;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.SBFlammableBlocks;
import net.invictusslayer.slayersbeasts.block.SBStrippableBlocks;
import net.invictusslayer.slayersbeasts.entity.*;
import net.invictusslayer.slayersbeasts.world.biome.*;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

@Mod.EventBusSubscriber(modid = SlayersBeasts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SBCommonEvents {
    @SuppressWarnings("deprecation")
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SBFlammableBlocks.register();
            SBStrippableBlocks.register();

//            BrewingRecipeRegistry.addRecipe(new SBBrewingRecipe(Potions.SLOWNESS, SBItems.INSECT_EYE.get(), SBPotions.PARALYSIS_POTION.get()));
//            BrewingRecipeRegistry.addRecipe(new SBBrewingRecipe(Potions.POISON, SBItems.WITHERBONE.get(), SBPotions.WITHER_POTION.get()));

            Regions.register(new SBOverworldRegion(4));
            Regions.register(new SBUndergroundRegion(1));
            Regions.register(new SBOceanicRegion(4));
            Regions.register(new SBNetherRegion(1));

            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, SlayersBeasts.MOD_ID, SBSurfaceRuleData.overworldRules());
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.NETHER, SlayersBeasts.MOD_ID, SBSurfaceRuleData.netherRules());

            SpawnPlacements.register(SBEntities.MANTIS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Mantis::canSpawn);
            SpawnPlacements.register(SBEntities.WORKER_ANT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, WorkerAnt::canSpawn);
            SpawnPlacements.register(SBEntities.SOLDIER_ANT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, SoldierAnt::canSpawn);
            SpawnPlacements.register(SBEntities.QUEEN_ANT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, QueenAnt::canSpawn);
            SpawnPlacements.register(SBEntities.DAMSELFLY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Damselfly::canSpawn);
            SpawnPlacements.register(SBEntities.ENT_OAK.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, EntOak::canSpawn);
            SpawnPlacements.register(SBEntities.VENUS_FLYTRAP.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, VenusFlytrap::canSpawn);
        });
    }

//    @SubscribeEvent
//    public static void registerTrades(VillagerTradesEvent event) {
//        if (event.getType() == VillagerProfession.FISHERMAN) {
//            event.getTrades().remove(5).addAll(List.of(
//		            new VillagerTrades.EmeraldForItems(Items.PUFFERFISH, 4, 12, 30),
//		            new VillagerTrades.EmeraldsForVillagerTypeItem(1, 12, 30, ImmutableMap.<VillagerType, Item>builder()
//				            .put(VillagerType.PLAINS, Items.OAK_BOAT).put(VillagerType.TAIGA, Items.SPRUCE_BOAT)
//				            .put(VillagerType.SNOW, Items.SPRUCE_BOAT).put(VillagerType.DESERT, Items.JUNGLE_BOAT)
//				            .put(VillagerType.JUNGLE, Items.JUNGLE_BOAT).put(VillagerType.SAVANNA, Items.ACACIA_BOAT)
//				            .put(VillagerType.SWAMP, Items.DARK_OAK_BOAT).put(SBVillagerType.CAVE.get(), Items.DARK_OAK_BOAT).build())
//            ));
//        }
//    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(SBEntities.MANTIS.get(), Mantis.createAttributes().build());
        event.put(SBEntities.WORKER_ANT.get(), WorkerAnt.createAttributes().build());
        event.put(SBEntities.SOLDIER_ANT.get(), SoldierAnt.createAttributes().build());
        event.put(SBEntities.QUEEN_ANT.get(), QueenAnt.createAttributes().build());
        event.put(SBEntities.WITHER_SPIDER.get(), WitherSpider.createAttributes().build());
        event.put(SBEntities.TARANTULA.get(), Tarantula.createAttributes().build());
        event.put(SBEntities.DAMSELFLY.get(), Damselfly.createAttributes().build());
        event.put(SBEntities.ENT_OAK.get(), EntOak.createAttributes().build());
        event.put(SBEntities.VENUS_FLYTRAP.get(), VenusFlytrap.createAttributes().build());
    }
}
