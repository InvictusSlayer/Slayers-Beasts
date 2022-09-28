package net.invictusslayer.slayersbeasts.init;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SlayersBeasts.MOD_ID);

    public static final RegistryObject<EntityType<MantisEntity>> MANTIS_ENTITY = ENTITY_TYPES.register("mantis_entity",
            () -> EntityType.Builder.of(MantisEntity::new, MobCategory.MONSTER).sized(0.8f,1.2f)
                    .build(new ResourceLocation(SlayersBeasts.MOD_ID, "mantis_entity").toString()));

    public static final RegistryObject<EntityType<TinyAntEntity>> TINY_ANT_ENTITY = ENTITY_TYPES.register("wood_ant_entity",
            () -> EntityType.Builder.of(TinyAntEntity::new, MobCategory.AMBIENT).sized(0.5f,0.3f)
                    .build(new ResourceLocation(SlayersBeasts.MOD_ID, "wood_ant_entity").toString()));

    public static final RegistryObject<EntityType<VenusFlytrapEntity>> VENUS_FLYTRAP_ENTITY = ENTITY_TYPES.register("venus_flytrap_entity",
            () -> EntityType.Builder.of(VenusFlytrapEntity::new, MobCategory.MONSTER).sized(1.0f,1.8f)
                    .build(new ResourceLocation(SlayersBeasts.MOD_ID, "venus_flytrap_entity").toString()));

    public static final RegistryObject<EntityType<WitherSpiderEntity>> WITHER_SPIDER_ENTITY = ENTITY_TYPES.register("wither_spider_entity",
            () -> EntityType.Builder.of(WitherSpiderEntity::new, MobCategory.MONSTER).sized(1.6f,0.8f)
                    .build(new ResourceLocation(SlayersBeasts.MOD_ID, "wither_spider_entity").toString()));

    public static final RegistryObject<EntityType<ExampleEntity>> EXAMPLE_ENTITY = ENTITY_TYPES.register("example_entity",
            () -> EntityType.Builder.of(ExampleEntity::new, MobCategory.MONSTER).sized(0.6f,2.0f)
                    .build(new ResourceLocation(SlayersBeasts.MOD_ID, "example_entity").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
