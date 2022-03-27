package net.invictusslayer.slayersbeasts.events;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.init.ModEntities;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = SlayersBeasts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonForgeEvents {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void biomeLoading(BiomeLoadingEvent event) {

        if (Objects.equals(event.getName(), new ResourceLocation("minecraft:jungle"))) {
            event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings
                    .SpawnerData(ModEntities.MANTIS_ENTITY.get(), 6, 1, 3));
        }
        if (Objects.equals(event.getName(), new ResourceLocation("minecraft:sparse_jungle"))) {
            event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings
                    .SpawnerData(ModEntities.MANTIS_ENTITY.get(), 6, 1, 3));
        }
        if (Objects.equals(event.getName(), new ResourceLocation("minecraft:bamboo_jungle"))) {
            event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings
                    .SpawnerData(ModEntities.MANTIS_ENTITY.get(), 6, 1, 3));
        }
        if (Objects.equals(event.getName(), new ResourceLocation("minecraft:lush_caves"))) {
            event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings
                    .SpawnerData(ModEntities.MANTIS_ENTITY.get(), 6, 1, 3));
        }
    }
}
