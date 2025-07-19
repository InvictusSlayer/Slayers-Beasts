package net.invictusslayer.slayersbeasts.common.world.biome;

import net.invictusslayer.slayersbeasts.SBPlatform;
import net.invictusslayer.slayersbeasts.common.data.tag.SBTags;
import net.invictusslayer.slayersbeasts.common.init.SBEntities;
import net.invictusslayer.slayersbeasts.common.world.feature.SBPlacedFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;

public class SBBiomeModifications {
	public static void registerFeatures() {
		SBPlatform.addFeatureBiomeModifier("algae_common", SBTags.Biomes.PLACES_ALGAE_COMMON, GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.PATCH_ALGAE_COMMON);
		SBPlatform.addFeatureBiomeModifier("algae_normal", SBTags.Biomes.PLACES_ALGAE_NORMAL, GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.PATCH_ALGAE_NORMAL);
		SBPlatform.addFeatureBiomeModifier("default_mushrooms", BiomeTags.IS_OVERWORLD, GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.BLACK_MUSHROOM_RARE, SBPlacedFeatures.WHITE_MUSHROOM_RARE);
		SBPlatform.addFeatureBiomeModifier("mud_pits", BiomeTags.IS_BADLANDS, GenerationStep.Decoration.LOCAL_MODIFICATIONS, SBPlacedFeatures.MUD_PIT_SHALLOW, SBPlacedFeatures.MUD_PIT_NORMAL, SBPlacedFeatures.MUD_PIT_DEEP);
		SBPlatform.addFeatureBiomeModifier("ore_exoskeleton", BiomeTags.IS_OVERWORLD, GenerationStep.Decoration.UNDERGROUND_ORES, SBPlacedFeatures.ORE_EXOSKELETON);
		SBPlatform.addFeatureBiomeModifier("ore_exoskeleton_lush", SBTags.Biomes.PLACES_EXOSKELETON_LUSH, GenerationStep.Decoration.UNDERGROUND_ORES, SBPlacedFeatures.ORE_EXOSKELETON_LUSH);
		SBPlatform.addFeatureBiomeModifier("ore_pegmatite", BiomeTags.IS_OVERWORLD, GenerationStep.Decoration.UNDERGROUND_ORES, SBPlacedFeatures.ORE_PEGMATITE_UPPER, SBPlacedFeatures.ORE_PEGMATITE_LOWER);
		SBPlatform.addFeatureBiomeModifier("trees_river", BiomeTags.IS_RIVER, GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.TREES_RIVER);
	}

	public static void registerSpawns() {
		addSpawn(SBTags.Biomes.SPAWNS_MANTIS, SBEntities.MANTIS.get(), 6, 1, 2, MobCategory.MONSTER);
		addSpawn(Biomes.SOUL_SAND_VALLEY, SBEntities.WITHER_SPIDER.get(), 4, 1, 1, MobCategory.MONSTER);
		addSpawn(SBTags.Biomes.SPAWNS_DAMSELFLY, SBEntities.DAMSELFLY.get(), 3, 1, 3, MobCategory.AMBIENT);
		addSpawn(SBTags.Biomes.SPAWNS_OAK_ENTS, SBEntities.ENT_MEDIUM.get(), 4, 1, 1, MobCategory.MONSTER);
	}

	public static void addSpawn(ResourceKey<Biome> biome, EntityType<?> entity, int weight, int min, int max, MobCategory category) {
//		BiomeModifications.addProperties(context -> context.getKey().get().equals(biome.location()), (context, mutable) -> mutable.getSpawnProperties().addSpawn(category, new MobSpawnSettings.SpawnerData(entity, weight, min, max)));
	}

	public static void addSpawn(TagKey<Biome> biomes, EntityType<?> entity, int weight, int min, int max, MobCategory category) {
//		BiomeModifications.addProperties(context -> context.hasTag(biomes), (context, mutable) -> mutable.getSpawnProperties().addSpawn(category, new MobSpawnSettings.SpawnerData(entity, weight, min, max)));
	}
}
