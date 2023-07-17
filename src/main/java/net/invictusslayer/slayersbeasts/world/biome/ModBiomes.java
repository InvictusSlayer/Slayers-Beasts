package net.invictusslayer.slayersbeasts.world.biome;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class ModBiomes {
    public static final ResourceKey<Biome> ASPEN_FOREST = register("aspen_forest");
    public static final ResourceKey<Biome> BLACK_DUNES = register("black_dunes");
    public static final ResourceKey<Biome> EUCALYPT_FOREST = register("eucalypt_forest");
    public static final ResourceKey<Biome> FROZEN_THICKET = register("frozen_thicket");
    public static final ResourceKey<Biome> INKY_MOOR = register("inky_moor");
    public static final ResourceKey<Biome> OUTBACK = register("outback");
    public static final ResourceKey<Biome> PETRIFIED_WOODS = register("petrified_woods");
    public static final ResourceKey<Biome> RAINFOREST = register("rainforest");
    public static final ResourceKey<Biome> REDWOOD_GROVE = register("redwood_grove");
    public static final ResourceKey<Biome> OLD_GROWTH_REDWOOD_GROVE = register("old_growth_redwood_grove");
    public static final ResourceKey<Biome> TAR_DESERT = register("tar_desert");
    public static final ResourceKey<Biome> VOLCANIC_PEAKS = register("volcanic_peaks");

    private static ResourceKey<Biome> register(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(SlayersBeasts.MOD_ID, name));
    }

    public static void registerBiomes() {
        System.out.println("Registering biomes for " + SlayersBeasts.MOD_ID);
    }
}
