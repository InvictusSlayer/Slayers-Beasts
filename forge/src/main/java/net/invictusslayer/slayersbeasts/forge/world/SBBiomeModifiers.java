package net.invictusslayer.slayersbeasts.forge.world;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.data.tag.SBTags;
import net.invictusslayer.slayersbeasts.common.init.SBEntities;
import net.invictusslayer.slayersbeasts.common.world.feature.SBPlacedFeatures;
import net.minecraft.core.Holder;
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
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers.AddFeaturesBiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers.AddSpawnsBiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public record SBBiomeModifiers() {
	// Features
	public static final ResourceKey<BiomeModifier> ADD_ALGAE_COMMON = createKey("add_algae_common");
	public static final ResourceKey<BiomeModifier> ADD_ALGAE_NORMAL = createKey("add_algae_normal");
	public static final ResourceKey<BiomeModifier> ADD_DEFAULT_MUSHROOMS = createKey("add_default_mushrooms");
	public static final ResourceKey<BiomeModifier> ADD_MUD_PITS = createKey("add_mud_pits");
	public static final ResourceKey<BiomeModifier> ADD_ORE_EXOSKELETON = createKey("add_ore_exoskeleton");
	public static final ResourceKey<BiomeModifier> ADD_ORE_EXOSKELETON_LUSH = createKey("add_ore_exoskeleton_lush");
	public static final ResourceKey<BiomeModifier> ADD_ORE_PEGMATITE = createKey("add_ore_pegmatite");
	public static final ResourceKey<BiomeModifier> ADD_TREES_RIVER = createKey("add_trees_river");

	// Spawns
	public static final ResourceKey<BiomeModifier> ADD_MANTIS = createKey("add_mantis");
	public static final ResourceKey<BiomeModifier> ADD_WITHER_SPIDER = createKey("add_wither_spider");
	public static final ResourceKey<BiomeModifier> ADD_DAMSELFlY = createKey("add_damselfly");
	public static final ResourceKey<BiomeModifier> ADD_ENT_OAK = createKey("add_ent_oak");
	public static final ResourceKey<BiomeModifier> ADD_ENT_BIRCH = createKey("add_ent_birch");

	public static void bootstrap(BootstapContext<BiomeModifier> context) {
		HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
		HolderGetter<PlacedFeature> placed = context.lookup(Registries.PLACED_FEATURE);

		context.register(ADD_ALGAE_COMMON, new AddFeaturesBiomeModifier(HolderSet.direct(biomes.getOrThrow(Biomes.MANGROVE_SWAMP)), HolderSet.direct(placed.getOrThrow(SBPlacedFeatures.PATCH_ALGAE_COMMON)), GenerationStep.Decoration.VEGETAL_DECORATION));
		context.register(ADD_ALGAE_NORMAL, new AddFeaturesBiomeModifier(HolderSet.direct(biomes.getOrThrow(Biomes.SWAMP)), HolderSet.direct(placed.getOrThrow(SBPlacedFeatures.PATCH_ALGAE_NORMAL)), GenerationStep.Decoration.VEGETAL_DECORATION));
		context.register(ADD_DEFAULT_MUSHROOMS, new AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placed.getOrThrow(SBPlacedFeatures.BLACK_MUSHROOM_RARE), placed.getOrThrow(SBPlacedFeatures.WHITE_MUSHROOM_RARE)), GenerationStep.Decoration.VEGETAL_DECORATION));
		context.register(ADD_MUD_PITS, new AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_BADLANDS), HolderSet.direct(placed.getOrThrow(SBPlacedFeatures.MUD_PIT_SHALLOW), placed.getOrThrow(SBPlacedFeatures.MUD_PIT_NORMAL), placed.getOrThrow(SBPlacedFeatures.MUD_PIT_DEEP)), GenerationStep.Decoration.LOCAL_MODIFICATIONS));
		context.register(ADD_ORE_EXOSKELETON, new AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placed.getOrThrow(SBPlacedFeatures.ORE_EXOSKELETON)), GenerationStep.Decoration.UNDERGROUND_ORES));
		context.register(ADD_ORE_EXOSKELETON_LUSH, new AddFeaturesBiomeModifier(HolderSet.direct(biomes.getOrThrow(Biomes.LUSH_CAVES)), HolderSet.direct(placed.getOrThrow(SBPlacedFeatures.ORE_EXOSKELETON_LUSH)), GenerationStep.Decoration.UNDERGROUND_ORES));
		context.register(ADD_ORE_PEGMATITE, new AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placed.getOrThrow(SBPlacedFeatures.ORE_PEGMATITE_UPPER), placed.getOrThrow(SBPlacedFeatures.ORE_PEGMATITE_LOWER)), GenerationStep.Decoration.UNDERGROUND_ORES));
		context.register(ADD_TREES_RIVER, new AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_RIVER), HolderSet.direct(placed.getOrThrow(SBPlacedFeatures.TREES_RIVER)), GenerationStep.Decoration.VEGETAL_DECORATION));

		context.register(ADD_MANTIS, new AddSpawnsBiomeModifier(biomes.getOrThrow(SBTags.Biomes.SPAWNS_MANTIS), List.of(new MobSpawnSettings.SpawnerData(SBEntities.MANTIS.get(), 6, 1, 3))));
		context.register(ADD_WITHER_SPIDER, new AddSpawnsBiomeModifier(HolderSet.direct(biomes.getOrThrow(Biomes.SOUL_SAND_VALLEY)), List.of(new MobSpawnSettings.SpawnerData(SBEntities.WITHER_SPIDER.get(), 4, 1, 2))));
		context.register(ADD_DAMSELFlY, new AddSpawnsBiomeModifier(biomes.getOrThrow(SBTags.Biomes.SPAWNS_DAMSELFLY), List.of(new MobSpawnSettings.SpawnerData(SBEntities.DAMSELFLY.get(), 3, 1, 1))));
		context.register(ADD_ENT_OAK, new AddSpawnsBiomeModifier(biomes.getOrThrow(SBTags.Biomes.SPAWNS_ENT_OAK), List.of(new MobSpawnSettings.SpawnerData(SBEntities.ENT_OAK.get(), 4, 1, 1))));
		context.register(ADD_ENT_BIRCH, new AddSpawnsBiomeModifier(biomes.getOrThrow(SBTags.Biomes.SPAWNS_ENT_BIRCH), List.of(new MobSpawnSettings.SpawnerData(SBEntities.ENT_BIRCH.get(), 4, 1, 1))));
	}

	private static ResourceKey<BiomeModifier> createKey(String name) {
		return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(SlayersBeasts.MOD_ID, name));
	}

	public static final DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, SlayersBeasts.MOD_ID);

	static {
		BIOME_MODIFIERS.register("replace_feature", () -> ReplaceFeatureBiomeModifier.CODEC);
	}

	public record ReplaceFeatureBiomeModifier(HolderSet<Biome> biomes, Holder<PlacedFeature> feature, GenerationStep.Decoration stage) implements BiomeModifier {
		public static final Codec<ReplaceFeatureBiomeModifier> CODEC = RecordCodecBuilder.create(instance -> instance.group(
				Biome.LIST_CODEC.fieldOf("biomes").forGetter(ReplaceFeatureBiomeModifier::biomes),
				PlacedFeature.CODEC.fieldOf("feature").forGetter(ReplaceFeatureBiomeModifier::feature),
				GenerationStep.Decoration.CODEC.fieldOf("stage").forGetter(ReplaceFeatureBiomeModifier::stage)
		).apply(instance, ReplaceFeatureBiomeModifier::new));

		public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
			if (biomes.contains(biome)) {
				if (phase == Phase.BEFORE_EVERYTHING) builder.getGenerationSettings().getFeatures(stage).remove(feature);
				if (phase == Phase.ADD) builder.getGenerationSettings().addFeature(stage, feature);
			}
		}

		public Codec<? extends BiomeModifier> codec() {
			return CODEC;
		}
	}
}
