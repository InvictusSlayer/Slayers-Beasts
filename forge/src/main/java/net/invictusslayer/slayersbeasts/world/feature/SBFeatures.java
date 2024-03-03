package net.invictusslayer.slayersbeasts.world.feature;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.world.feature.icicle.IcicleClusterFeature;
import net.invictusslayer.slayersbeasts.world.feature.icicle.IcicleLargeFeature;
import net.invictusslayer.slayersbeasts.world.feature.icicle.IcicleSmallFeature;
import net.invictusslayer.slayersbeasts.world.feature.misc.AntMoundFeature;
import net.invictusslayer.slayersbeasts.world.feature.misc.CryptFoundationFeature;
import net.invictusslayer.slayersbeasts.world.feature.misc.PitFeature;
import net.invictusslayer.slayersbeasts.world.feature.misc.StyphiumPatchFeature;
import net.invictusslayer.slayersbeasts.world.feature.tree.mushroom.*;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public abstract class SBFeatures {
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, SlayersBeasts.MOD_ID);

	public static final RegistryObject<BigMushroomFeature> BIG_MUSHROOM = FEATURES.register("big_mushroom", () -> new BigMushroomFeature(BigMushroomFeature.Configuration.CODEC));
	public static final RegistryObject<HugeBlackMushroomFeature> HUGE_BLACK_MUSHROOM = FEATURES.register("huge_black_mushroom", () -> new HugeBlackMushroomFeature(HugeMushroomFeatureConfiguration.CODEC));
	public static final RegistryObject<HugeWhiteMushroomFeature> HUGE_WHITE_MUSHROOM = FEATURES.register("huge_white_mushroom", () -> new HugeWhiteMushroomFeature(HugeMushroomFeatureConfiguration.CODEC));
	public static final RegistryObject<MightyBlackMushroomFeature> MIGHTY_BLACK_MUSHROOM = FEATURES.register("mighty_black_mushroom", () -> new MightyBlackMushroomFeature(HugeMushroomFeatureConfiguration.CODEC));
	public static final RegistryObject<MightyBrownMushroomFeature> MIGHTY_BROWN_MUSHROOM = FEATURES.register("mighty_brown_mushroom", () -> new MightyBrownMushroomFeature(HugeMushroomFeatureConfiguration.CODEC));
	public static final RegistryObject<MightyRedMushroomFeature> MIGHTY_RED_MUSHROOM = FEATURES.register("mighty_red_mushroom", () -> new MightyRedMushroomFeature(HugeMushroomFeatureConfiguration.CODEC));
	public static final RegistryObject<MightyWhiteMushroomFeature> MIGHTY_WHITE_MUSHROOM = FEATURES.register("mighty_white_mushroom", () -> new MightyWhiteMushroomFeature(HugeMushroomFeatureConfiguration.CODEC));
	public static final RegistryObject<AntMoundFeature> ANT_MOUND = FEATURES.register("ant_mound", () -> new AntMoundFeature(AntMoundFeature.Configuration.CODEC));
	public static final RegistryObject<PitFeature> PIT = FEATURES.register("pit", () -> new PitFeature(PitFeature.Configuration.CODEC));
	public static final RegistryObject<IcicleClusterFeature> ICICLE_CLUSTER = FEATURES.register("icicle_cluster", () -> new IcicleClusterFeature(IcicleClusterFeature.Configuration.CODEC));
	public static final RegistryObject<IcicleLargeFeature> ICICLE_LARGE = FEATURES.register("icicle_large", () -> new IcicleLargeFeature(IcicleLargeFeature.Configuration.CODEC));
	public static final RegistryObject<IcicleSmallFeature> ICICLE_SMALL = FEATURES.register("icicle_small", () -> new IcicleSmallFeature(IcicleSmallFeature.Configuration.CODEC));
	public static final RegistryObject<StyphiumPatchFeature> STYPHIUM_PATCH = FEATURES.register("styphium_patch", () -> new StyphiumPatchFeature(StyphiumPatchFeature.Configuration.CODEC));
	public static final RegistryObject<CryptFoundationFeature> CRYPT_FOUNDATION = FEATURES.register("crypt_foundation", () -> new CryptFoundationFeature(NoneFeatureConfiguration.CODEC));
}
