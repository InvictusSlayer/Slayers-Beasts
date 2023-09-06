package net.invictusslayer.slayersbeasts.entity;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class SBEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SlayersBeasts.MOD_ID);

    public static final RegistryObject<EntityType<Mantis>> MANTIS = ENTITIES.register("mantis",
            () -> EntityType.Builder.of(Mantis::new, MobCategory.MONSTER).sized(0.8F,1.2F)
                    .build(new ResourceLocation(SlayersBeasts.MOD_ID, "mantis").toString()));

    public static final RegistryObject<EntityType<WorkerAnt>> WORKER_ANT = ENTITIES.register("worker_ant",
            () -> EntityType.Builder.of(WorkerAnt::new, MobCategory.AMBIENT).sized(0.7F,0.4F)
                    .build(new ResourceLocation(SlayersBeasts.MOD_ID, "worker_ant").toString()));
    public static final RegistryObject<EntityType<SoldierAnt>> SOLDIER_ANT = ENTITIES.register("soldier_ant",
            () -> EntityType.Builder.of(SoldierAnt::new, MobCategory.CREATURE).sized(1.8F,0.9F)
                    .build(new ResourceLocation(SlayersBeasts.MOD_ID, "soldier_ant").toString()));
    public static final RegistryObject<EntityType<QueenAnt>> QUEEN_ANT = ENTITIES.register("queen_ant",
            () -> EntityType.Builder.of(QueenAnt::new, MobCategory.CREATURE).sized(2.2F,1.2F)
                    .build(new ResourceLocation(SlayersBeasts.MOD_ID, "queen_ant").toString()));

    public static final RegistryObject<EntityType<WitherSpider>> WITHER_SPIDER = ENTITIES.register("wither_spider",
            () -> EntityType.Builder.of(WitherSpider::new, MobCategory.MONSTER).sized(1.6F,0.8F)
                    .build(new ResourceLocation(SlayersBeasts.MOD_ID, "wither_spider").toString()));

    public static final RegistryObject<EntityType<Tarantula>> TARANTULA = ENTITIES.register("tarantula",
            () -> EntityType.Builder.of(Tarantula::new, MobCategory.MONSTER).sized(4F,2.5F)
                    .build(new ResourceLocation(SlayersBeasts.MOD_ID, "tarantula").toString()));

    public static final RegistryObject<EntityType<Damselfly>> DAMSELFLY = ENTITIES.register("damselfly",
            () -> EntityType.Builder.of(Damselfly::new, MobCategory.AMBIENT).sized(0.8F,0.2F)
                    .build(new ResourceLocation(SlayersBeasts.MOD_ID, "damselfly").toString()));

    public static final RegistryObject<EntityType<LargeEnt>> ENT_OAK = ENTITIES.register("ent_oak",
            () -> EntityType.Builder.of(LargeEnt::new, MobCategory.MONSTER).sized(0.8F,0.2F)
                    .build(new ResourceLocation(SlayersBeasts.MOD_ID, "ent_oak").toString()));

    public static final RegistryObject<EntityType<VenusFlytrap>> VENUS_FLYTRAP = ENTITIES.register("venus_flytrap",
            () -> EntityType.Builder.of(VenusFlytrap::new, MobCategory.MONSTER).sized(1.0F,1.8F)
                    .build(new ResourceLocation(SlayersBeasts.MOD_ID, "venus_flytrap").toString()));

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}
