package net.invictusslayer.slayersbeasts.init;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.entities.ExampleEntity;
import net.invictusslayer.slayersbeasts.entities.MantisEntity;
import net.invictusslayer.slayersbeasts.entities.WitherSpiderEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, SlayersBeasts.MOD_ID);

    public static final RegistryObject<EntityType<MantisEntity>> MANTIS_ENTITY = ENTITIES.register("mantis_entity",
            () -> EntityType.Builder.of(MantisEntity::new, MobCategory.MONSTER).sized(0.8f,1.2f)
                    .build(new ResourceLocation(SlayersBeasts.MOD_ID, "mantis_entity").toString()));

    public static final RegistryObject<EntityType<WitherSpiderEntity>> WITHER_SPIDER_ENTITY = ENTITIES.register("wither_spider_entity",
            () -> EntityType.Builder.of(WitherSpiderEntity::new, MobCategory.MONSTER).sized(1.6f,0.8f)
                    .build(new ResourceLocation(SlayersBeasts.MOD_ID, "wither_spider_entity").toString()));

    public static final RegistryObject<EntityType<ExampleEntity>> EXAMPLE_ENTITY = ENTITIES.register("example_entity",
            () -> EntityType.Builder.of(ExampleEntity::new, MobCategory.MONSTER).sized(0.6f,2.0f)
                    .build(new ResourceLocation(SlayersBeasts.MOD_ID, "example_entity").toString()));

    public static void register(IEventBus eventBus) {ENTITIES.register(eventBus);}
}
