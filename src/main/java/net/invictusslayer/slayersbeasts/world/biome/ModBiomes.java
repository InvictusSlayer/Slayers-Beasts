package net.invictusslayer.slayersbeasts.world.biome;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class ModBiomes {
    public static final ResourceKey<Biome> VOLCANIC_PEAKS = ResourceKey.create(Registries.BIOME, new ResourceLocation(SlayersBeasts.MOD_ID, "volcanic_peaks"));
    public static final ResourceKey<Biome> BLACK_DUNES = ResourceKey.create(Registries.BIOME, new ResourceLocation(SlayersBeasts.MOD_ID, "black_dunes"));
    public static final ResourceKey<Biome> TAR_DESERT = ResourceKey.create(Registries.BIOME, new ResourceLocation(SlayersBeasts.MOD_ID, "tar_desert"));
    public static final ResourceKey<Biome> OUTBACK = ResourceKey.create(Registries.BIOME, new ResourceLocation(SlayersBeasts.MOD_ID, "outback"));
    public static final ResourceKey<Biome> EUCALYPT_FOREST = ResourceKey.create(Registries.BIOME, new ResourceLocation(SlayersBeasts.MOD_ID, "eucalypt_forest"));
    public static final ResourceKey<Biome> RAINFOREST = ResourceKey.create(Registries.BIOME, new ResourceLocation(SlayersBeasts.MOD_ID, "rainforest"));
    public static final ResourceKey<Biome> ASPEN_FOREST = ResourceKey.create(Registries.BIOME, new ResourceLocation(SlayersBeasts.MOD_ID, "aspen_forest"));
    public static final ResourceKey<Biome> REDWOOD_GROVE = ResourceKey.create(Registries.BIOME, new ResourceLocation(SlayersBeasts.MOD_ID, "redwood_grove"));
    public static final ResourceKey<Biome> OLD_GROWTH_REDWOOD_GROVE = ResourceKey.create(Registries.BIOME, new ResourceLocation(SlayersBeasts.MOD_ID, "old_growth_redwood_grove"));
    public static final ResourceKey<Biome> INKY_MOOR = ResourceKey.create(Registries.BIOME, new ResourceLocation(SlayersBeasts.MOD_ID, "inky_moor"));
    public static final ResourceKey<Biome> PETRIFIED_WOODS = ResourceKey.create(Registries.BIOME, new ResourceLocation(SlayersBeasts.MOD_ID, "petrified_woods"));
    public static final ResourceKey<Biome> FROZEN_THICKET = ResourceKey.create(Registries.BIOME, new ResourceLocation(SlayersBeasts.MOD_ID, "frozen_thicket"));

    public static void register() {
        System.out.println("Registering " + SlayersBeasts.MOD_ID + " Biomes");
    }
}
