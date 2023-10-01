package net.invictusslayer.slayersbeasts.world.biome;

import com.mojang.datafixers.util.Pair;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.ParameterUtils.*;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

public class SBOceanicRegion extends Region {
    private final Temperature[] TEMPERATURE = new Temperature[] {Temperature.ICY, Temperature.COOL, Temperature.NEUTRAL, Temperature.WARM, Temperature.HOT};
    private final Humidity[] HUMIDITY = new Humidity[] {Humidity.ARID, Humidity.DRY, Humidity.NEUTRAL, Humidity.WET, Humidity.HUMID};

    private final ResourceKey<Biome>[][] OCEANS = new ResourceKey[][] {
            {Biomes.FROZEN_OCEAN, SBBiomes.MURKY_OCEAN, SBBiomes.MURKY_OCEAN, SBBiomes.MURKY_OCEAN, Biomes.WARM_OCEAN},
            {Biomes.DEEP_FROZEN_OCEAN, SBBiomes.DEEP_MURKY_OCEAN, SBBiomes.DEEP_MURKY_OCEAN, SBBiomes.DEEP_MURKY_OCEAN, Biomes.WARM_OCEAN}
    };

    private final ResourceKey<Biome>[][] ISLANDS = new ResourceKey[][] {
            {Biomes.MUSHROOM_FIELDS, Biomes.MUSHROOM_FIELDS, Biomes.MUSHROOM_FIELDS, Biomes.MUSHROOM_FIELDS, Biomes.MUSHROOM_FIELDS},
            {Biomes.MUSHROOM_FIELDS, Biomes.MUSHROOM_FIELDS, Biomes.MUSHROOM_FIELDS, Biomes.MUSHROOM_FIELDS, Biomes.MUSHROOM_FIELDS},
            {Biomes.MUSHROOM_FIELDS, Biomes.MUSHROOM_FIELDS, Biomes.MUSHROOM_FIELDS, Biomes.MUSHROOM_FIELDS, Biomes.MUSHROOM_FIELDS},
            {Biomes.MUSHROOM_FIELDS, Biomes.MUSHROOM_FIELDS, Biomes.MUSHROOM_FIELDS, Biomes.MUSHROOM_FIELDS, Biomes.MUSHROOM_FIELDS},
            {Biomes.MUSHROOM_FIELDS, Biomes.MUSHROOM_FIELDS, Biomes.MUSHROOM_FIELDS, Biomes.MUSHROOM_FIELDS, Biomes.MUSHROOM_FIELDS}
    };

    public SBOceanicRegion(int weight) {
        super(new ResourceLocation(SlayersBeasts.MOD_ID, "oceanic"), RegionType.OVERWORLD, weight);
    }

    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();

        for (int t = 0; t < TEMPERATURE.length; t++) {
            biome(OCEANS[0][t], builder, TEMPERATURE[t], Humidity.FULL_RANGE, Continentalness.OCEAN);
            biome(OCEANS[1][t], builder, TEMPERATURE[t], Humidity.FULL_RANGE, Continentalness.DEEP_OCEAN);

            for (int h = 0 ; h < HUMIDITY.length; h++) {
                biome(ISLANDS[h][t], builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.MUSHROOM_FIELDS);
            }
        }

        builder.build().forEach(mapper);
    }

    private void biome(ResourceKey<Biome> biome, VanillaParameterOverlayBuilder builder, Temperature temperature, Humidity humidity, Continentalness continentalness) {
        new ParameterPointListBuilder().temperature(temperature).humidity(humidity).continentalness(continentalness).erosion(Erosion.FULL_RANGE).weirdness(Weirdness.FULL_RANGE).depth(Depth.FLOOR).build().forEach(point -> builder.add(point, biome));
        new ParameterPointListBuilder().temperature(temperature).humidity(humidity).continentalness(continentalness).erosion(Erosion.FULL_RANGE).weirdness(Weirdness.FULL_RANGE).depth(Depth.SURFACE).build().forEach(point -> builder.add(point, biome));
    }
}
