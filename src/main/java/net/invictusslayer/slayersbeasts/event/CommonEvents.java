package net.invictusslayer.slayersbeasts.event;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.entity.*;
import net.invictusslayer.slayersbeasts.entity.SBEntities;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = SlayersBeasts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonEvents {
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
