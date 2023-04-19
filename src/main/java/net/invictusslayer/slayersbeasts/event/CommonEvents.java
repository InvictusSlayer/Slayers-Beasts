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
    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SpawnPlacements.register(ModEntities.MANTIS_ENTITY.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, MantisEntity::canSpawn);
            SpawnPlacements.register(ModEntities.WORKER_ANT_ENTITY.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, WorkerAntEntity::canSpawn);
            SpawnPlacements.register(ModEntities.SOLDIER_ANT_ENTITY.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, SoldierAntEntity::canSpawn);
            SpawnPlacements.register(ModEntities.QUEEN_ANT_ENTITY.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, QueenAntEntity::canSpawn);
            SpawnPlacements.register(ModEntities.DAMSELFLY_ENTITY.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, DamselflyEntity::canSpawn);
            SpawnPlacements.register(ModEntities.VENUS_FLYTRAP_ENTITY.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, VenusFlytrapEntity::canSpawn);
        });
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.MANTIS_ENTITY.get(), MantisEntity.createAttributes().build());
        event.put(ModEntities.WORKER_ANT_ENTITY.get(), WorkerAntEntity.createAttributes().build());
        event.put(ModEntities.SOLDIER_ANT_ENTITY.get(), SoldierAntEntity.createAttributes().build());
        event.put(ModEntities.QUEEN_ANT_ENTITY.get(), QueenAntEntity.createAttributes().build());
        event.put(ModEntities.DAMSELFLY_ENTITY.get(), DamselflyEntity.createAttributes().build());
        event.put(ModEntities.VENUS_FLYTRAP_ENTITY.get(), VenusFlytrapEntity.createAttributes().build());
        event.put(ModEntities.WITHER_SPIDER_ENTITY.get(), WitherSpiderEntity.createAttributes().build());
        event.put(ModEntities.EXAMPLE_ENTITY.get(), ExampleEntity.createAttributes().build());
    }
}
