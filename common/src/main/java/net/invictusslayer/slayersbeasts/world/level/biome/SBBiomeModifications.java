package net.invictusslayer.slayersbeasts.world.level.biome;

import net.invictusslayer.scabbard.world.biome.BiomeModifierHandler;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.data.tags.SBTags;
import net.invictusslayer.slayersbeasts.registries.SBEntities;
import net.invictusslayer.slayersbeasts.world.level.gen.feature.SBPlacedFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class SBBiomeModifications {
	public static final BiomeModifierHandler HANDLER = new BiomeModifierHandler(SlayersBeasts.MOD_ID);

	public static void register() {
		addFeature("algae_common", SBTags.Biomes.PLACES_ALGAE_COMMON, GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.PATCH_ALGAE_COMMON);
		addFeature("algae_normal", SBTags.Biomes.PLACES_ALGAE_NORMAL, GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.PATCH_ALGAE_NORMAL);
		addFeature("default_mushrooms", BiomeTags.IS_OVERWORLD, GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.BLACK_MUSHROOM_RARE, SBPlacedFeatures.WHITE_MUSHROOM_RARE);
		addFeature("mud_pits", BiomeTags.IS_BADLANDS, GenerationStep.Decoration.LOCAL_MODIFICATIONS, SBPlacedFeatures.MUD_PIT_SHALLOW, SBPlacedFeatures.MUD_PIT_NORMAL, SBPlacedFeatures.MUD_PIT_DEEP);
		addFeature("ore_exoskeleton", BiomeTags.IS_OVERWORLD, GenerationStep.Decoration.UNDERGROUND_ORES, SBPlacedFeatures.ORE_EXOSKELETON);
		addFeature("ore_exoskeleton_lush", SBTags.Biomes.PLACES_EXOSKELETON_LUSH, GenerationStep.Decoration.UNDERGROUND_ORES, SBPlacedFeatures.ORE_EXOSKELETON_LUSH);
		addFeature("ore_pegmatite", BiomeTags.IS_OVERWORLD, GenerationStep.Decoration.UNDERGROUND_ORES, SBPlacedFeatures.ORE_PEGMATITE_UPPER, SBPlacedFeatures.ORE_PEGMATITE_LOWER);
		addFeature("trees_river", BiomeTags.IS_RIVER, GenerationStep.Decoration.VEGETAL_DECORATION, SBPlacedFeatures.TREES_RIVER);

		addSpawn("add_mantis", SBTags.Biomes.SPAWNS_MANTIS, SBEntities.MANTIS.get(), 6, 1, 2);
		addSpawn("add_wither_spider", SBTags.Biomes.SPAWNS_WITHER_SPIDER, SBEntities.WITHER_SPIDER.get(), 4, 1, 1);
		addSpawn("add_damselfly", SBTags.Biomes.SPAWNS_DAMSELFLY, SBEntities.DAMSELFLY.get(), 3, 1, 3);
		addSpawn("add_oak_ents", SBTags.Biomes.SPAWNS_OAK_ENTS, SBEntities.ENT_MEDIUM.get(), 4, 1, 1);
	}

	@SafeVarargs
	public static void addFeature(String name, TagKey<Biome> biomes, GenerationStep.Decoration step, ResourceKey<PlacedFeature>... features) {
		SlayersBeasts.PLATFORM.addFeatureBiomeModifier(HANDLER, name, biomes, step, List.of(features));
	}

	public static void addSpawn(String name, TagKey<Biome> biomes, EntityType<?> entity, int weight, int min, int max) {
		SlayersBeasts.PLATFORM.addSpawnBiomeModifier(HANDLER, name, biomes, List.of(new MobSpawnSettings.SpawnerData(entity, weight, min, max)));
	}
}
