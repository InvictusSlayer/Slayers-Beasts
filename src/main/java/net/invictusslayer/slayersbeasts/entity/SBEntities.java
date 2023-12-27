package net.invictusslayer.slayersbeasts.entity;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class SBEntities {
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SlayersBeasts.MOD_ID);

	public static final RegistryObject<EntityType<Mantis>> MANTIS = ENTITIES.register("mantis", () -> EntityType.Builder.of(Mantis::new, MobCategory.MONSTER).sized(1.9F,2F).build("mantis"));

	public static final RegistryObject<EntityType<AntWorker>> ANT_WORKER = ENTITIES.register("ant_worker", () -> EntityType.Builder.of(AntWorker::new, MobCategory.AMBIENT).sized(0.7F,0.4F).build("ant_worker"));
	public static final RegistryObject<EntityType<AntSoldier>> ANT_SOLDIER = ENTITIES.register("ant_soldier", () -> EntityType.Builder.of(AntSoldier::new, MobCategory.CREATURE).sized(1.8F,0.9F).build("ant_soldier"));
	public static final RegistryObject<EntityType<AntQueen>> ANT_QUEEN = ENTITIES.register("ant_queen", () -> EntityType.Builder.of(AntQueen::new, MobCategory.CREATURE).sized(2.2F,1.2F).build("ant_queen"));

	public static final RegistryObject<EntityType<WitherSpider>> WITHER_SPIDER = ENTITIES.register("wither_spider", () -> EntityType.Builder.of(WitherSpider::new, MobCategory.MONSTER).sized(1.8F,0.7F).build("wither_spider"));
	public static final RegistryObject<EntityType<Tyrachnid>> TYRACHNID = ENTITIES.register("tyrachnid", () -> EntityType.Builder.of(Tyrachnid::new, MobCategory.MONSTER).sized(3.5F,2F).build("tyrachnid"));

	public static final RegistryObject<EntityType<Damselfly>> DAMSELFLY = ENTITIES.register("damselfly", () -> EntityType.Builder.of(Damselfly::new, MobCategory.AMBIENT).sized(0.8F,0.2F).build("damselfly"));

	public static final RegistryObject<EntityType<EntMedium>> ENT_OAK = ENTITIES.register("ent_oak", () -> EntityType.Builder.of(EntMedium::new, MobCategory.MONSTER).sized(1.3F,5.4F).build("ent_oak"));
	public static final RegistryObject<EntityType<EntMedium>> ENT_BIRCH = ENTITIES.register("ent_birch", () -> EntityType.Builder.of(EntMedium::new, MobCategory.MONSTER).sized(1.3F,5.4F).build("ent_birch"));
	public static final RegistryObject<EntityType<Wudu>> WUDU_OAK = ENTITIES.register("wudu_oak", () -> EntityType.Builder.of(Wudu::new, MobCategory.MONSTER).sized(1.0F,1.0F).build("wudu_oak"));

	public static final RegistryObject<EntityType<Sporetrap>> SPORETRAP = ENTITIES.register("sporetrap", () -> EntityType.Builder.of(Sporetrap::new, MobCategory.MONSTER).sized(0.8F,1.8F).build("sporetrap"));

	public static final RegistryObject<EntityType<Irk>> IRK = ENTITIES.register("irk", () -> EntityType.Builder.of(Irk::new, MobCategory.MONSTER).sized(0.7F,0.8F).build("irk"));
}
