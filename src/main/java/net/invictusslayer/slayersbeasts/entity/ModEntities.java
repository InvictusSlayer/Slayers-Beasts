package net.invictusslayer.slayersbeasts.entity;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SlayersBeasts.MOD_ID);

    public static final RegistryObject<EntityType<Mantis>> MANTIS = ENTITIES.register("mantis",
            () -> EntityType.Builder.of(Mantis::new, MobCategory.MONSTER).sized(0.8f,1.2f)
                    .build(new ResourceLocation(SlayersBeasts.MOD_ID, "mantis_entity").toString()));

    public static final RegistryObject<EntityType<WorkerAnt>> WORKER_ANT = ENTITIES.register("worker_ant",
            () -> EntityType.Builder.of(WorkerAnt::new, MobCategory.AMBIENT).sized(0.6f,0.3f)
                    .build(new ResourceLocation(SlayersBeasts.MOD_ID, "worker_ant_entity").toString()));
    public static final RegistryObject<EntityType<SoldierAnt>> SOLDIER_ANT = ENTITIES.register("soldier_ant",
            () -> EntityType.Builder.of(SoldierAnt::new, MobCategory.CREATURE).sized(1.2f,0.6f)
                    .build(new ResourceLocation(SlayersBeasts.MOD_ID, "soldier_ant_entity").toString()));
    public static final RegistryObject<EntityType<QueenAnt>> QUEEN_ANT = ENTITIES.register("queen_ant",
            () -> EntityType.Builder.of(QueenAnt::new, MobCategory.CREATURE).sized(1.5f,0.8f)
                    .build(new ResourceLocation(SlayersBeasts.MOD_ID, "queen_ant_entity").toString()));

    public static final RegistryObject<EntityType<WitherSpider>> WITHER_SPIDER = ENTITIES.register("wither_spider",
            () -> EntityType.Builder.of(WitherSpider::new, MobCategory.MONSTER).sized(1.6f,0.8f)
                    .build(new ResourceLocation(SlayersBeasts.MOD_ID, "wither_spider_entity").toString()));

    public static final RegistryObject<EntityType<Damselfly>> DAMSELFLY = ENTITIES.register("damselfly",
            () -> EntityType.Builder.of(Damselfly::new, MobCategory.AMBIENT).sized(0.7f,0.1f)
                    .build(new ResourceLocation(SlayersBeasts.MOD_ID, "damselfly_entity").toString()));

    public static final RegistryObject<EntityType<VenusFlytrap>> VENUS_FLYTRAP = ENTITIES.register("venus_flytrap",
            () -> EntityType.Builder.of(VenusFlytrap::new, MobCategory.MONSTER).sized(1.0f,1.8f)
                    .build(new ResourceLocation(SlayersBeasts.MOD_ID, "venus_flytrap_entity").toString()));

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}
