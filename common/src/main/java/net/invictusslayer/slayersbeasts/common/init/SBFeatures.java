package net.invictusslayer.slayersbeasts.common.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.world.feature.icicle.IcicleClusterFeature;
import net.invictusslayer.slayersbeasts.common.world.feature.icicle.IcicleLargeFeature;
import net.invictusslayer.slayersbeasts.common.world.feature.icicle.IcicleSmallFeature;
import net.invictusslayer.slayersbeasts.common.world.feature.misc.AntMoundFeature;
import net.invictusslayer.slayersbeasts.common.world.feature.misc.CryptFoundationFeature;
import net.invictusslayer.slayersbeasts.common.world.feature.misc.PitFeature;
import net.invictusslayer.slayersbeasts.common.world.feature.misc.StyphiumPatchFeature;
import net.invictusslayer.slayersbeasts.common.world.feature.mushroom.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class SBFeatures {
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(SlayersBeasts.MOD_ID, Registries.FEATURE);

	public static final RegistrySupplier<BigMushroomFeature> BIG_MUSHROOM = FEATURES.register("big_mushroom", () -> new BigMushroomFeature(BigMushroomFeature.Configuration.CODEC));
	public static final RegistrySupplier<BranchingMushroomFeature> BRANCHING_MUSHROOM = FEATURES.register("branching_mushroom", () -> new BranchingMushroomFeature(BranchingMushroomFeature.Configuration.CODEC));
	public static final RegistrySupplier<HugeBlackMushroomFeature> HUGE_BLACK_MUSHROOM = FEATURES.register("huge_black_mushroom", () -> new HugeBlackMushroomFeature(HugeMushroomFeatureConfiguration.CODEC));
	public static final RegistrySupplier<HugeWhiteMushroomFeature> HUGE_WHITE_MUSHROOM = FEATURES.register("huge_white_mushroom", () -> new HugeWhiteMushroomFeature(HugeMushroomFeatureConfiguration.CODEC));
	public static final RegistrySupplier<MightyBlackMushroomFeature> MIGHTY_BLACK_MUSHROOM = FEATURES.register("mighty_black_mushroom", () -> new MightyBlackMushroomFeature(HugeMushroomFeatureConfiguration.CODEC));
	public static final RegistrySupplier<MightyBrownMushroomFeature> MIGHTY_BROWN_MUSHROOM = FEATURES.register("mighty_brown_mushroom", () -> new MightyBrownMushroomFeature(HugeMushroomFeatureConfiguration.CODEC));
	public static final RegistrySupplier<MightyRedMushroomFeature> MIGHTY_RED_MUSHROOM = FEATURES.register("mighty_red_mushroom", () -> new MightyRedMushroomFeature(HugeMushroomFeatureConfiguration.CODEC));
	public static final RegistrySupplier<MightyWhiteMushroomFeature> MIGHTY_WHITE_MUSHROOM = FEATURES.register("mighty_white_mushroom", () -> new MightyWhiteMushroomFeature(HugeMushroomFeatureConfiguration.CODEC));
	public static final RegistrySupplier<AntMoundFeature> ANT_MOUND = FEATURES.register("ant_mound", () -> new AntMoundFeature(AntMoundFeature.Configuration.CODEC));
	public static final RegistrySupplier<PitFeature> PIT = FEATURES.register("pit", () -> new PitFeature(PitFeature.Configuration.CODEC));
	public static final RegistrySupplier<IcicleClusterFeature> ICICLE_CLUSTER = FEATURES.register("icicle_cluster", () -> new IcicleClusterFeature(IcicleClusterFeature.Configuration.CODEC));
	public static final RegistrySupplier<IcicleLargeFeature> ICICLE_LARGE = FEATURES.register("icicle_large", () -> new IcicleLargeFeature(IcicleLargeFeature.Configuration.CODEC));
	public static final RegistrySupplier<IcicleSmallFeature> ICICLE_SMALL = FEATURES.register("icicle_small", () -> new IcicleSmallFeature(IcicleSmallFeature.Configuration.CODEC));
	public static final RegistrySupplier<StyphiumPatchFeature> STYPHIUM_PATCH = FEATURES.register("styphium_patch", () -> new StyphiumPatchFeature(StyphiumPatchFeature.Configuration.CODEC));
	public static final RegistrySupplier<CryptFoundationFeature> CRYPT_FOUNDATION = FEATURES.register("crypt_foundation", () -> new CryptFoundationFeature(NoneFeatureConfiguration.CODEC));
}
