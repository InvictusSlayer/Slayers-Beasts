package net.invictusslayer.slayersbeasts.world.gen;

import net.invictusslayer.slayersbeasts.world.feature.ModPlacedFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;
import java.util.Set;

public class ModOreGeneration {
    public static void generateOres(final BiomeLoadingEvent event) {
        ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, event.getName());
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);

        List<Holder<PlacedFeature>> base = event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

        if (types.contains(BiomeDictionary.Type.LUSH) || types.contains(BiomeDictionary.Type.JUNGLE)) {
            base.add(ModPlacedFeatures.LUSH_EXOSKELETON_ORE_PLACED);
        } else {
            base.add(ModPlacedFeatures.EXOSKELETON_ORE_PLACED);
        }
    }
}
