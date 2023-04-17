package net.invictusslayer.slayersbeasts.world.biome;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class ModBiomes {
    public static final ResourceKey<Biome> INKY_THICKET_KEY = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(SlayersBeasts.MOD_ID, "inky_thicket"));

    public static void register() {
        System.out.println("Registering " + SlayersBeasts.MOD_ID + " Biomes");
    }
}
