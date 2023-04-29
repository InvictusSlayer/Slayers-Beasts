package net.invictusslayer.slayersbeasts.event;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.entity.*;
import net.invictusslayer.slayersbeasts.entity.ModEntities;
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
            SpawnPlacements.register(ModEntities.MANTIS.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Mantis::canSpawn);
            SpawnPlacements.register(ModEntities.WORKER_ANT.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, WorkerAnt::canSpawn);
            SpawnPlacements.register(ModEntities.SOLDIER_ANT.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, SoldierAnt::canSpawn);
            SpawnPlacements.register(ModEntities.QUEEN_ANT.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, QueenAnt::canSpawn);
            SpawnPlacements.register(ModEntities.DAMSELFLY.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Damselfly::canSpawn);
            SpawnPlacements.register(ModEntities.VENUS_FLYTRAP.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, VenusFlytrap::canSpawn);
        });
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.MANTIS.get(), Mantis.createAttributes().build());
        event.put(ModEntities.WORKER_ANT.get(), WorkerAnt.createAttributes().build());
        event.put(ModEntities.SOLDIER_ANT.get(), SoldierAnt.createAttributes().build());
        event.put(ModEntities.QUEEN_ANT.get(), QueenAnt.createAttributes().build());
        event.put(ModEntities.DAMSELFLY.get(), Damselfly.createAttributes().build());
        event.put(ModEntities.VENUS_FLYTRAP.get(), VenusFlytrap.createAttributes().build());
        event.put(ModEntities.WITHER_SPIDER.get(), WitherSpider.createAttributes().build());
    }
}
