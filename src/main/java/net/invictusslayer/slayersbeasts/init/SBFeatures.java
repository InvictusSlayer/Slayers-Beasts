package net.invictusslayer.slayersbeasts.init;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.world.feature.icicle.IcicleClusterFeature;
import net.invictusslayer.slayersbeasts.world.feature.icicle.IcicleLargeFeature;
import net.invictusslayer.slayersbeasts.world.feature.icicle.IcicleSmallFeature;
import net.invictusslayer.slayersbeasts.world.feature.misc.AntMoundFeature;
import net.invictusslayer.slayersbeasts.world.feature.misc.CryptFoundationFeature;
import net.invictusslayer.slayersbeasts.world.feature.misc.PitFeature;
import net.invictusslayer.slayersbeasts.world.feature.misc.StyphiumPatchFeature;
import net.invictusslayer.slayersbeasts.world.feature.mushroom.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.function.Supplier;

public class SBFeatures {
	//? if neoforge
	/*public static final net.neoforged.neoforge.registries.DeferredRegister<Feature<?>> FEATURES = net.neoforged.neoforge.registries.DeferredRegister.create(Registries.FEATURE, SlayersBeasts.MOD_ID);*/

	public static final Supplier<BigMushroomFeature> BIG_MUSHROOM = register("big_mushroom", new BigMushroomFeature(BigMushroomFeature.Configuration.CODEC));
	public static final Supplier<BranchingMushroomFeature> BRANCHING_MUSHROOM = register("branching_mushroom", new BranchingMushroomFeature(BranchingMushroomFeature.Configuration.CODEC));
	public static final Supplier<HugeBlackMushroomFeature> HUGE_BLACK_MUSHROOM = register("huge_black_mushroom", new HugeBlackMushroomFeature(HugeMushroomFeatureConfiguration.CODEC));
	public static final Supplier<HugeWhiteMushroomFeature> HUGE_WHITE_MUSHROOM = register("huge_white_mushroom", new HugeWhiteMushroomFeature(HugeMushroomFeatureConfiguration.CODEC));
	public static final Supplier<MightyBlackMushroomFeature> MIGHTY_BLACK_MUSHROOM = register("mighty_black_mushroom", new MightyBlackMushroomFeature(HugeMushroomFeatureConfiguration.CODEC));
	public static final Supplier<MightyBrownMushroomFeature> MIGHTY_BROWN_MUSHROOM = register("mighty_brown_mushroom", new MightyBrownMushroomFeature(HugeMushroomFeatureConfiguration.CODEC));
	public static final Supplier<MightyRedMushroomFeature> MIGHTY_RED_MUSHROOM = register("mighty_red_mushroom", new MightyRedMushroomFeature(HugeMushroomFeatureConfiguration.CODEC));
	public static final Supplier<MightyWhiteMushroomFeature> MIGHTY_WHITE_MUSHROOM = register("mighty_white_mushroom", new MightyWhiteMushroomFeature(HugeMushroomFeatureConfiguration.CODEC));
	public static final Supplier<AntMoundFeature> ANT_MOUND = register("ant_mound", new AntMoundFeature(AntMoundFeature.Configuration.CODEC));
	public static final Supplier<PitFeature> PIT = register("pit", new PitFeature(PitFeature.Configuration.CODEC));
	public static final Supplier<IcicleClusterFeature> ICICLE_CLUSTER = register("icicle_cluster", new IcicleClusterFeature(IcicleClusterFeature.Configuration.CODEC));
	public static final Supplier<IcicleLargeFeature> ICICLE_LARGE = register("icicle_large", new IcicleLargeFeature(IcicleLargeFeature.Configuration.CODEC));
	public static final Supplier<IcicleSmallFeature> ICICLE_SMALL = register("icicle_small", new IcicleSmallFeature(IcicleSmallFeature.Configuration.CODEC));
	public static final Supplier<StyphiumPatchFeature> STYPHIUM_PATCH = register("styphium_patch", new StyphiumPatchFeature(StyphiumPatchFeature.Configuration.CODEC));
	public static final Supplier<CryptFoundationFeature> CRYPT_FOUNDATION = register("crypt_foundation", new CryptFoundationFeature(NoneFeatureConfiguration.CODEC));

	private static <T extends Feature<?>> Supplier<T> register(String name, T feature) {
		//? if fabric
		return () -> Registry.register(BuiltInRegistries.FEATURE, ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, name), feature);
		//? if neoforge
		/*return FEATURES.register(name, () -> feature);*/
	}

	public static void init() {
		SlayersBeasts.LOGGER.info("Initialised Features");
	}
}
