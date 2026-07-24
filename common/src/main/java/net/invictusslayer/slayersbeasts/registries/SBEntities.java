package net.invictusslayer.slayersbeasts.registries;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.world.entity.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.level.levelgen.Heightmap;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SBEntities {
	public static final Supplier<EntityType<Mantis>> MANTIS = register("mantis", EntityType.Builder.of(Mantis::new, MobCategory.MONSTER).sized(1.6F,1.4F));

	public static final Supplier<EntityType<AntWorker>> ANT_WORKER = register("ant_worker", EntityType.Builder.of(AntWorker::new, MobCategory.AMBIENT).sized(0.7F,0.4F));
	public static final Supplier<EntityType<AntSoldier>> ANT_SOLDIER = register("ant_soldier", EntityType.Builder.of(AntSoldier::new, MobCategory.CREATURE).sized(1.8F,0.9F));
	public static final Supplier<EntityType<AntQueen>> ANT_QUEEN = register("ant_queen", EntityType.Builder.of(AntQueen::new, MobCategory.CREATURE).sized(2.2F,1.2F));

	public static final Supplier<EntityType<WitherSpider>> WITHER_SPIDER = register("wither_spider", EntityType.Builder.of(WitherSpider::new, MobCategory.MONSTER).sized(1.8F,0.7F));
	public static final Supplier<EntityType<Tyrachnid>> TYRACHNID = register("tyrachnid", EntityType.Builder.of(Tyrachnid::new, MobCategory.MONSTER).sized(3.5F,2F));

	public static final Supplier<EntityType<Butterfly>> BUTTERFLY = register("butterfly", EntityType.Builder.of(Butterfly::new, MobCategory.AMBIENT).sized(0.5F,0.2F));
	public static final Supplier<EntityType<Damselfly>> DAMSELFLY = register("damselfly", EntityType.Builder.of(Damselfly::new, MobCategory.AMBIENT).sized(0.8F,0.2F));

	public static final Supplier<EntityType<EntMedium>> ENT_MEDIUM = register("ent_medium", EntityType.Builder.of(EntMedium::new, MobCategory.MONSTER).sized(1.3F,5.4F));
	public static final Supplier<EntityType<Wudu>> WUDU = register("wudu", EntityType.Builder.of(Wudu::new, MobCategory.MONSTER).sized(1.0F,1.0F));

	public static final Supplier<EntityType<Sporetrap>> SPORETRAP = register("sporetrap", EntityType.Builder.of(Sporetrap::new, MobCategory.MONSTER).sized(0.8F,1.8F));

	public static final Supplier<EntityType<Irk>> IRK = register("irk", EntityType.Builder.of(Irk::new, MobCategory.MONSTER).sized(0.7F,0.8F));

	public static <T extends Mob> void registerSpawns(Consumer<SpawnPlacement<T>> consumer) {
		consumer.accept((SpawnPlacement<T>) new SpawnPlacement<>(MANTIS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Mantis::canSpawn));
		consumer.accept((SpawnPlacement<T>) new SpawnPlacement<>(ANT_WORKER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.WORLD_SURFACE, AntWorker::canSpawn));
		consumer.accept((SpawnPlacement<T>) new SpawnPlacement<>(ANT_SOLDIER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.WORLD_SURFACE, AntSoldier::canSpawn));
		consumer.accept((SpawnPlacement<T>) new SpawnPlacement<>(ANT_QUEEN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.WORLD_SURFACE, AntQueen::canSpawn));
		consumer.accept((SpawnPlacement<T>) new SpawnPlacement<>(WITHER_SPIDER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.WORLD_SURFACE, WitherSpider::canSpawn));
		consumer.accept((SpawnPlacement<T>) new SpawnPlacement<>(BUTTERFLY.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Butterfly::canSpawn));
		consumer.accept((SpawnPlacement<T>) new SpawnPlacement<>(DAMSELFLY.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Damselfly::canSpawn));
		consumer.accept((SpawnPlacement<T>) new SpawnPlacement<>(ENT_MEDIUM.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.WORLD_SURFACE, EntMedium::canSpawn));
		consumer.accept((SpawnPlacement<T>) new SpawnPlacement<>(SPORETRAP.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Sporetrap::canSpawn));
	}

	public record SpawnPlacement<T extends Mob>(EntityType<T> entity, SpawnPlacementType placement, Heightmap.Types heightmap, SpawnPlacements.SpawnPredicate<T> predicate) {}

	public static void registerAttributes(BiConsumer<EntityType<? extends LivingEntity>, AttributeSupplier> consumer) {
		consumer.accept(MANTIS.get(), Mantis.createAttributes().build());
		consumer.accept(ANT_WORKER.get(), AntWorker.createAttributes().build());
		consumer.accept(ANT_SOLDIER.get(), AntSoldier.createAttributes().build());
		consumer.accept(ANT_QUEEN.get(), AntQueen.createAttributes().build());
		consumer.accept(WITHER_SPIDER.get(), WitherSpider.createAttributes().build());
		consumer.accept(TYRACHNID.get(), Tyrachnid.createAttributes().build());
		consumer.accept(BUTTERFLY.get(), Butterfly.createAttributes().build());
		consumer.accept(DAMSELFLY.get(), Damselfly.createAttributes().build());
		consumer.accept(ENT_MEDIUM.get(), EntMedium.createAttributes().build());
		consumer.accept(WUDU.get(), Wudu.createAttributes().build());
		consumer.accept(SPORETRAP.get(), Sporetrap.createAttributes().build());
		consumer.accept(IRK.get(), Irk.createAttributes().build());
	}

	public static <T extends Entity> Supplier<EntityType<T>> register(String name, EntityType.Builder<T> builder) {
		return SlayersBeasts.PLATFORM.register(BuiltInRegistries.ENTITY_TYPE, SlayersBeasts.MOD_ID, name, () -> builder.build(name));
	}

	public static void register() {
		SlayersBeasts.LOGGER.info("Registering SBEntities...");
	}
}
