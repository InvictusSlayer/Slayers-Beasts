package net.invictusslayer.slayersbeasts.world.dimension;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;

import java.util.OptionalLong;

public class SBDimensions {
	public static final ResourceKey<Level> CRYPT = createDimensionKey("crypt");
	public static final ResourceKey<DimensionType> CRYPT_TYPE = createDimensionTypeKey("crypt");

	public static final ResourceKey<Level> SEPULCHRA = createDimensionKey("sepulchra");
	public static final ResourceKey<DimensionType> SEPULCHRA_TYPE = createDimensionTypeKey("sepulchra");

	public static void bootstrap(BootstrapContext<DimensionType> context) {
		register(context, CRYPT_TYPE, new DimensionType(OptionalLong.of(6000L), false, true, false, false, 1, false, false, 0, 128, 128, BlockTags.INFINIBURN_OVERWORLD, BuiltinDimensionTypes.END_EFFECTS, 0.0F, new DimensionType.MonsterSettings(true, false, UniformInt.of(0, 14), 14)));
		register(context, SEPULCHRA_TYPE, new DimensionType(OptionalLong.of(12000L), true, false, false, false, 1, true, true, -64, 384, 384, BlockTags.INFINIBURN_OVERWORLD, BuiltinDimensionTypes.OVERWORLD_EFFECTS, 0.0F, new DimensionType.MonsterSettings(false, true, UniformInt.of(0, 7), 7)));
	}

	private static ResourceKey<Level> createDimensionKey(String name) {
		return ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, name));
	}

	private static ResourceKey<DimensionType> createDimensionTypeKey(String name) {
		return ResourceKey.create(Registries.DIMENSION_TYPE, ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, name));
	}

	private static void register(BootstrapContext<DimensionType> context, ResourceKey<DimensionType> key, DimensionType type) {
		context.register(key, type);
	}
}
