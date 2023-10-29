package net.invictusslayer.slayersbeasts.world.feature;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.world.feature.misc.*;
import net.invictusslayer.slayersbeasts.world.feature.tree.BigMushroomFeature;
import net.invictusslayer.slayersbeasts.world.feature.tree.HugeBlackMushroomFeature;
import net.invictusslayer.slayersbeasts.world.feature.tree.HugeWhiteMushroomFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public abstract class SBFeatures {
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, SlayersBeasts.MOD_ID);

	public static final RegistryObject<HugeBlackMushroomFeature> HUGE_BLACK_MUSHROOM = FEATURES.register("huge_black_mushroom", () -> new HugeBlackMushroomFeature(HugeMushroomFeatureConfiguration.CODEC));
	public static final RegistryObject<HugeWhiteMushroomFeature> HUGE_WHITE_MUSHROOM = FEATURES.register("huge_white_mushroom", () -> new HugeWhiteMushroomFeature(HugeMushroomFeatureConfiguration.CODEC));
	public static final RegistryObject<BigMushroomFeature> BIG_MUSHROOM = FEATURES.register("big_mushroom", () -> new BigMushroomFeature(BigMushroomFeature.Configuration.CODEC));
	public static final RegistryObject<PitFeature> PIT = FEATURES.register("pit", () -> new PitFeature(PitFeature.Configuration.CODEC));
	public static final RegistryObject<IcicleClusterFeature> ICICLE_CLUSTER = FEATURES.register("icicle_cluster", () -> new IcicleClusterFeature(IcicleClusterFeature.Configuration.CODEC));
	public static final RegistryObject<IcicleLargeFeature> ICICLE_LARGE = FEATURES.register("icicle_large", () -> new IcicleLargeFeature(IcicleLargeFeature.Configuration.CODEC));
	public static final RegistryObject<IcicleSmallFeature> ICICLE_SMALL = FEATURES.register("icicle_small", () -> new IcicleSmallFeature(IcicleSmallFeature.Configuration.CODEC));
	public static final RegistryObject<StyphiumPatchFeature> STYPHIUM_PATCH = FEATURES.register("styphium_patch", () -> new StyphiumPatchFeature(StyphiumPatchFeature.Configuration.CODEC));
	public static final RegistryObject<CryptFoundationFeature> CRYPT_FOUNDATION = FEATURES.register("crypt_foundation", () -> new CryptFoundationFeature(NoneFeatureConfiguration.CODEC));
}
