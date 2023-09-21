package net.invictusslayer.slayersbeasts.world.biome;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.datagen.tags.SBTags;
import net.invictusslayer.slayersbeasts.entity.SBEntities;
import net.invictusslayer.slayersbeasts.world.feature.SBPlacedFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers.AddFeaturesBiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers.AddSpawnsBiomeModifier;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public record SBBiomeModifiers() {
	//Features
	public static final ResourceKey<BiomeModifier> ADD_DEFAULT_MUSHROOMS = createKey("add_default_mushrooms");
	public static final ResourceKey<BiomeModifier> ADD_MUD_PITS = createKey("add_mud_pits");
	public static final ResourceKey<BiomeModifier> ADD_ORE_PEGMATITE = createKey("add_ore_pegmatite");
	public static final ResourceKey<BiomeModifier> ADD_ORE_EXOSKELETON = createKey("add_ore_exoskeleton");
	public static final ResourceKey<BiomeModifier> ADD_ORE_EXOSKELETON_LUSH = createKey("add_ore_exoskeleton_lush");

	//Spawns
	public static final ResourceKey<BiomeModifier> ADD_MANTIS = createKey("add_mantis");
	public static final ResourceKey<BiomeModifier> ADD_WITHER_SPIDER = createKey("add_wither_spider");
	public static final ResourceKey<BiomeModifier> ADD_DAMSELFlY = createKey("add_damselfly");
	public static final ResourceKey<BiomeModifier> ADD_ENT_OAK = createKey("add_ent_oak");

	public static void bootstrap(BootstapContext<BiomeModifier> context) {
		HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
		HolderGetter<PlacedFeature> placed = context.lookup(Registries.PLACED_FEATURE);

		register(context, ADD_DEFAULT_MUSHROOMS, new AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placed.getOrThrow(SBPlacedFeatures.BLACK_MUSHROOM_RARE), placed.getOrThrow(SBPlacedFeatures.WHITE_MUSHROOM_RARE)), GenerationStep.Decoration.VEGETAL_DECORATION));
		register(context, ADD_MUD_PITS, new AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_BADLANDS), HolderSet.direct(placed.getOrThrow(SBPlacedFeatures.MUD_PIT_SHALLOW), placed.getOrThrow(SBPlacedFeatures.MUD_PIT_NORMAL), placed.getOrThrow(SBPlacedFeatures.MUD_PIT_DEEP)), GenerationStep.Decoration.LOCAL_MODIFICATIONS));
		register(context, ADD_ORE_PEGMATITE, new AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placed.getOrThrow(SBPlacedFeatures.ORE_PEGMATITE_UPPER), placed.getOrThrow(SBPlacedFeatures.ORE_PEGMATITE_LOWER)), GenerationStep.Decoration.UNDERGROUND_ORES));
		register(context, ADD_ORE_EXOSKELETON, new AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placed.getOrThrow(SBPlacedFeatures.ORE_EXOSKELETON)), GenerationStep.Decoration.UNDERGROUND_ORES));
		register(context, ADD_ORE_EXOSKELETON_LUSH, new AddFeaturesBiomeModifier(HolderSet.direct(biomes.getOrThrow(Biomes.LUSH_CAVES)), HolderSet.direct(placed.getOrThrow(SBPlacedFeatures.ORE_EXOSKELETON_LUSH)), GenerationStep.Decoration.UNDERGROUND_ORES));

		register(context, ADD_MANTIS, new AddSpawnsBiomeModifier(biomes.getOrThrow(Tags.Biomes.IS_LUSH), List.of(new MobSpawnSettings.SpawnerData(SBEntities.MANTIS.get(), 6, 1, 3))));
		register(context, ADD_WITHER_SPIDER, new AddSpawnsBiomeModifier(HolderSet.direct(biomes.getOrThrow(Biomes.SOUL_SAND_VALLEY)), List.of(new MobSpawnSettings.SpawnerData(SBEntities.WITHER_SPIDER.get(), 4, 1, 2))));
		register(context, ADD_DAMSELFlY, new AddSpawnsBiomeModifier(biomes.getOrThrow(SBTags.Biomes.SPAWNS_DAMSELFLY), List.of(new MobSpawnSettings.SpawnerData(SBEntities.DAMSELFLY.get(), 3, 1, 1))));
		register(context, ADD_ENT_OAK, new AddSpawnsBiomeModifier(HolderSet.direct(biomes.getOrThrow(Biomes.FOREST), biomes.getOrThrow(Biomes.DARK_FOREST)), List.of(new MobSpawnSettings.SpawnerData(SBEntities.ENT_OAK.get(), 4, 1, 1))));
	}

	private static ResourceKey<BiomeModifier> createKey(String name) {
		return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(SlayersBeasts.MOD_ID, name));
	}

	private static void register(BootstapContext<BiomeModifier> context, ResourceKey<BiomeModifier> key, BiomeModifier modifier) {
		context.register(key, modifier);
	}
}
