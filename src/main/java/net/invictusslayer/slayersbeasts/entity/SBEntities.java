package net.invictusslayer.slayersbeasts.entity;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class SBEntities {
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SlayersBeasts.MOD_ID);

	public static final RegistryObject<EntityType<Mantis>> MANTIS = ENTITIES.register("mantis", () -> EntityType.Builder.of(Mantis::new, MobCategory.MONSTER).sized(1.9F,2F).build(new ResourceLocation(SlayersBeasts.MOD_ID, "mantis").toString()));

	public static final RegistryObject<EntityType<AntWorker>> ANT_WORKER = ENTITIES.register("ant_worker", () -> EntityType.Builder.of(AntWorker::new, MobCategory.AMBIENT).sized(0.7F,0.4F).build(new ResourceLocation(SlayersBeasts.MOD_ID, "ant_worker").toString()));
	public static final RegistryObject<EntityType<AntSoldier>> ANT_SOLDIER = ENTITIES.register("ant_soldier", () -> EntityType.Builder.of(AntSoldier::new, MobCategory.CREATURE).sized(1.8F,0.9F).build(new ResourceLocation(SlayersBeasts.MOD_ID, "ant_soldier").toString()));
	public static final RegistryObject<EntityType<AntQueen>> ANT_QUEEN = ENTITIES.register("ant_queen", () -> EntityType.Builder.of(AntQueen::new, MobCategory.CREATURE).sized(2.2F,1.2F).build(new ResourceLocation(SlayersBeasts.MOD_ID, "ant_queen").toString()));

	public static final RegistryObject<EntityType<WitherSpider>> WITHER_SPIDER = ENTITIES.register("wither_spider", () -> EntityType.Builder.of(WitherSpider::new, MobCategory.MONSTER).sized(1.8F,0.7F).build(new ResourceLocation(SlayersBeasts.MOD_ID, "wither_spider").toString()));

	public static final RegistryObject<EntityType<Tyrachnid>> TYRACHNID = ENTITIES.register("tyrachnid", () -> EntityType.Builder.of(Tyrachnid::new, MobCategory.MONSTER).sized(3.5F,2F).build(new ResourceLocation(SlayersBeasts.MOD_ID, "tyrachnid").toString()));

	public static final RegistryObject<EntityType<Damselfly>> DAMSELFLY = ENTITIES.register("damselfly", () -> EntityType.Builder.of(Damselfly::new, MobCategory.AMBIENT).sized(0.8F,0.2F).build(new ResourceLocation(SlayersBeasts.MOD_ID, "damselfly").toString()));

	public static final RegistryObject<EntityType<EntMedium>> ENT_OAK = ENTITIES.register("ent_oak", () -> EntityType.Builder.of(EntMedium::new, MobCategory.MONSTER).sized(1.3F,5.4F).build(new ResourceLocation(SlayersBeasts.MOD_ID, "ent_oak").toString()));
	public static final RegistryObject<EntityType<EntMedium>> ENT_BIRCH = ENTITIES.register("ent_birch", () -> EntityType.Builder.of(EntMedium::new, MobCategory.MONSTER).sized(1.3F,5.4F).build(new ResourceLocation(SlayersBeasts.MOD_ID, "ent_birch").toString()));

	public static final RegistryObject<EntityType<VenusFlytrap>> VENUS_FLYTRAP = ENTITIES.register("venus_flytrap", () -> EntityType.Builder.of(VenusFlytrap::new, MobCategory.MONSTER).sized(0.8F,1.8F).build(new ResourceLocation(SlayersBeasts.MOD_ID, "venus_flytrap").toString()));
}
