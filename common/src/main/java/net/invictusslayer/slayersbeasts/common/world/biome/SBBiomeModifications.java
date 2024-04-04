package net.invictusslayer.slayersbeasts.common.world.biome;

import dev.architectury.registry.level.biome.BiomeModifications;
import net.invictusslayer.slayersbeasts.common.data.tag.SBTags;
import net.invictusslayer.slayersbeasts.common.init.SBEntities;
import net.invictusslayer.slayersbeasts.common.world.feature.SBPlacedFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class SBBiomeModifications {
	public static HolderGetter<PlacedFeature> placedFeatures;

	public static void register() {
		addFeature(Biomes.MANGROVE_SWAMP, GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.PATCH_ALGAE_COMMON);
		addFeature(Biomes.SWAMP, GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.PATCH_ALGAE_NORMAL);
		addFeature(BiomeTags.IS_OVERWORLD, GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.BLACK_MUSHROOM_RARE, SBPlacedFeatures.WHITE_MUSHROOM_RARE);
		addFeature(BiomeTags.IS_BADLANDS, GenerationStep.Decoration.LOCAL_MODIFICATIONS, SBPlacedFeatures.MUD_PIT_SHALLOW, SBPlacedFeatures.MUD_PIT_NORMAL, SBPlacedFeatures.MUD_PIT_DEEP);
		addFeature(BiomeTags.IS_OVERWORLD, GenerationStep.Decoration.UNDERGROUND_ORES, SBPlacedFeatures.ORE_EXOSKELETON);
		addFeature(Biomes.LUSH_CAVES, GenerationStep.Decoration.UNDERGROUND_ORES, SBPlacedFeatures.ORE_EXOSKELETON_LUSH);
		addFeature(BiomeTags.IS_OVERWORLD, GenerationStep.Decoration.UNDERGROUND_ORES, SBPlacedFeatures.ORE_PEGMATITE_UPPER, SBPlacedFeatures.ORE_PEGMATITE_LOWER);
		addFeature(Biomes.RIVER, GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.TREES_RIVER);

		addSpawn(SBTags.Biomes.SPAWNS_MANTIS, SBEntities.MANTIS.get(), 6, 1, 2, MobCategory.MONSTER);
		addSpawn(Biomes.SOUL_SAND_VALLEY, SBEntities.WITHER_SPIDER.get(), 4, 1, 1, MobCategory.MONSTER);
		addSpawn(SBTags.Biomes.SPAWNS_DAMSELFLY, SBEntities.DAMSELFLY.get(), 3, 1, 3, MobCategory.AMBIENT);
		addSpawn(SBTags.Biomes.SPAWNS_ENT_OAK, SBEntities.ENT_MEDIUM.get(), 4, 1, 1, MobCategory.MONSTER);
	}

	@SafeVarargs
	public static void addFeature(ResourceKey<Biome> biome, GenerationStep.Decoration stage, ResourceKey<PlacedFeature>... features) {
		BiomeModifications.addProperties(context -> context.getKey().get().equals(biome.location()), (context, mutable) -> List.of(features).forEach(feature -> mutable.getGenerationProperties().addFeature(stage, placedFeatures.getOrThrow(feature))));
	}

	@SafeVarargs
	public static void addFeature(TagKey<Biome> biomes, GenerationStep.Decoration stage, ResourceKey<PlacedFeature>... features) {
		BiomeModifications.addProperties(context -> context.hasTag(biomes), (context, mutable) -> List.of(features).forEach(feature -> mutable.getGenerationProperties().addFeature(stage, placedFeatures.getOrThrow(feature))));
	}

	public static void addSpawn(ResourceKey<Biome> biome, EntityType<?> entity, int weight, int min, int max, MobCategory category) {
		BiomeModifications.addProperties(context -> context.getKey().get().equals(biome.location()), (context, mutable) -> mutable.getSpawnProperties().addSpawn(category, new MobSpawnSettings.SpawnerData(entity, weight, min, max)));
	}

	public static void addSpawn(TagKey<Biome> biomes, EntityType<?> entity, int weight, int min, int max, MobCategory category) {
		BiomeModifications.addProperties(context -> context.hasTag(biomes), (context, mutable) -> mutable.getSpawnProperties().addSpawn(category, new MobSpawnSettings.SpawnerData(entity, weight, min, max)));
	}
}
