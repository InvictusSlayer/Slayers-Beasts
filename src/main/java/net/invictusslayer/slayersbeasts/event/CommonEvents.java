package net.invictusslayer.slayersbeasts.event;

import com.google.common.collect.ImmutableMap;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.entity.*;
import net.invictusslayer.slayersbeasts.entity.npc.SBVillagerType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = SlayersBeasts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonEvents {
//    @SubscribeEvent
//    public static void addCustomTrades(VillagerTradesEvent event) {
//        if (event.getType() == VillagerProfession.FISHERMAN) {
//            VillagerTrades.TRADES.get(VillagerProfession.FISHERMAN).replace(5,
//                    new VillagerTrades.ItemListing[]{new  VillagerTrades.EmeraldForItems(Items.PUFFERFISH, 4, 12, 30),
//                    new VillagerTrades.EmeraldsForVillagerTypeItem(1, 12, 30, ImmutableMap.<VillagerType, Item>builder()
//                            .put(VillagerType.PLAINS, Items.OAK_BOAT).put(VillagerType.TAIGA, Items.SPRUCE_BOAT)
//                            .put(VillagerType.SNOW, Items.SPRUCE_BOAT).put(VillagerType.DESERT, Items.JUNGLE_BOAT)
//                            .put(VillagerType.JUNGLE, Items.JUNGLE_BOAT).put(VillagerType.SAVANNA, Items.ACACIA_BOAT)
//                            .put(VillagerType.SWAMP, Items.DARK_OAK_BOAT).put(SBVillagerType.CAVE.get(), Items.DARK_OAK_BOAT).build())});
//        }
//    }

    @SuppressWarnings("deprecation")
    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SpawnPlacements.register(SBEntities.MANTIS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Mantis::canSpawn);
            SpawnPlacements.register(SBEntities.WORKER_ANT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, WorkerAnt::canSpawn);
            SpawnPlacements.register(SBEntities.SOLDIER_ANT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, SoldierAnt::canSpawn);
            SpawnPlacements.register(SBEntities.QUEEN_ANT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, QueenAnt::canSpawn);
            SpawnPlacements.register(SBEntities.DAMSELFLY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Damselfly::canSpawn);
            SpawnPlacements.register(SBEntities.VENUS_FLYTRAP.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, VenusFlytrap::canSpawn);
        });
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(SBEntities.MANTIS.get(), Mantis.createAttributes().build());
        event.put(SBEntities.WORKER_ANT.get(), WorkerAnt.createAttributes().build());
        event.put(SBEntities.SOLDIER_ANT.get(), SoldierAnt.createAttributes().build());
        event.put(SBEntities.QUEEN_ANT.get(), QueenAnt.createAttributes().build());
        event.put(SBEntities.WITHER_SPIDER.get(), WitherSpider.createAttributes().build());
        event.put(SBEntities.TARANTULA.get(), Tarantula.createAttributes().build());
        event.put(SBEntities.DAMSELFLY.get(), Damselfly.createAttributes().build());
        event.put(SBEntities.VENUS_FLYTRAP.get(), VenusFlytrap.createAttributes().build());
    }
}
