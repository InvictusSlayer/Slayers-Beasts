package net.invictusslayer.slayersbeasts.world.dimension;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class SBDimensions {
    public static final ResourceKey<Level> SEPULCHRA_KEY = ResourceKey.create(Registries.DIMENSION,
            new ResourceLocation(SlayersBeasts.MOD_ID, "sepulchra"));
    public static final ResourceKey<DimensionType> SEPULCHRA_TYPE_KEY = ResourceKey.create(Registries.DIMENSION_TYPE,
            new ResourceLocation(SlayersBeasts.MOD_ID, "sepulchra"));

    public static void register() {
        System.out.println("Registering " + SlayersBeasts.MOD_ID + " Dimensions");
    }
}
