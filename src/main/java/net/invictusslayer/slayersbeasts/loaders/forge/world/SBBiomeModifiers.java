package net.invictusslayer.slayersbeasts.loaders.forge.world;

public class SBBiomeModifiers {
//	public static Map<String, Pair<TagKey<Biome>, Pair<List<ResourceKey<PlacedFeature>>, GenerationStep.Decoration>>> biomeModifiers = new HashMap<>();
//
//	public static void bootstrap(BootstapContext<BiomeModifier> context) {
//		HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
//		HolderGetter<PlacedFeature> placed = context.lookup(Registries.PLACED_FEATURE);
//
//		biomeModifiers.forEach((name, biomeFeatureStep) -> {
//			List<Holder<PlacedFeature>> features = new ArrayList<>();
//			biomeFeatureStep.second.first.forEach(feature -> features.add(placed.getOrThrow(feature)));
//			HolderSet<PlacedFeature> feature = HolderSet.direct(features);
//			context.register(ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(SlayersBeasts.MOD_ID, name)), new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(biomeFeatureStep.first), feature, biomeFeatureStep.second.second));
//		});
//	}
}
