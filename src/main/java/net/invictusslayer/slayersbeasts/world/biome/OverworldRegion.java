package net.invictusslayer.slayersbeasts.world.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

import static terrablender.api.ParameterUtils.*;

public class OverworldRegion extends Region {
    public OverworldRegion(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();

        new ParameterPointListBuilder()
                .temperature(Temperature.COOL)
                .humidity(Humidity.span(Humidity.NEUTRAL, Humidity.WET))
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.FULL_RANGE)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .weirdness(Weirdness.FULL_RANGE)
                .build().forEach(point -> builder.add(point, ModBiomes.ASPEN_FOREST));
        new ParameterPointListBuilder()
                .temperature(Temperature.HOT)
                .humidity(Humidity.span(Humidity.ARID, Humidity.DRY))
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.span(Erosion.EROSION_0, Erosion.EROSION_2))
                .depth(Depth.FLOOR, Depth.SURFACE)
                .weirdness(Weirdness.FULL_RANGE)
                .build().forEach(point -> builder.add(point, ModBiomes.BLACK_DUNES));
        new ParameterPointListBuilder()
                .temperature(Temperature.WARM)
                .humidity(Humidity.DRY)
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.FULL_RANGE)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .weirdness(Weirdness.FULL_RANGE)
                .build().forEach(point -> builder.add(point, ModBiomes.EUCALYPT_FOREST));
        new ParameterPointListBuilder()
                .temperature(Temperature.ICY)
                .humidity(Humidity.span(Humidity.ARID, Humidity.DRY))
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.FULL_RANGE)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .weirdness(Weirdness.FULL_RANGE)
                .build().forEach(point -> builder.add(point, ModBiomes.FROZEN_THICKET));
        new ParameterPointListBuilder()
                .temperature(Temperature.COOL)
                .humidity(Humidity.HUMID)
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.FULL_RANGE)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .weirdness(Weirdness.FULL_RANGE)
                .build().forEach(point -> builder.add(point, ModBiomes.INKY_MOOR));
        new ParameterPointListBuilder()
                .temperature(Temperature.HOT)
                .humidity(Humidity.span(Humidity.ARID, Humidity.DRY))
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.EROSION_5, Erosion.EROSION_6)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .weirdness(Weirdness.FULL_RANGE)
                .build().forEach(point -> builder.add(point, ModBiomes.OUTBACK));
        new ParameterPointListBuilder()
                .temperature(Temperature.COOL)
                .humidity(Humidity.ARID)
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.FULL_RANGE)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .weirdness(Weirdness.FULL_RANGE)
                .build().forEach(point -> builder.add(point, ModBiomes.PETRIFIED_WOODS));
        new ParameterPointListBuilder()
                .temperature(Temperature.span(Temperature.WARM, Temperature.HOT))
                .humidity(Humidity.HUMID)
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.FULL_RANGE)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .weirdness(Weirdness.FULL_RANGE)
                .build().forEach(point -> builder.add(point, ModBiomes.RAINFOREST));
        new ParameterPointListBuilder()
                .temperature(Temperature.WARM)
                .humidity(Humidity.span(Humidity.NEUTRAL, Humidity.WET))
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.span(Erosion.EROSION_0, Erosion.EROSION_2))
                .depth(Depth.FLOOR, Depth.SURFACE)
                .weirdness(Weirdness.FULL_RANGE)
                .build().forEach(point -> builder.add(point, ModBiomes.REDWOOD_GROVE));
        new ParameterPointListBuilder()
                .temperature(Temperature.WARM)
                .humidity(Humidity.span(Humidity.NEUTRAL, Humidity.WET))
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.span(Erosion.EROSION_3, Erosion.EROSION_6))
                .depth(Depth.FLOOR, Depth.SURFACE)
                .weirdness(Weirdness.FULL_RANGE)
                .build().forEach(point -> builder.add(point, ModBiomes.OLD_GROWTH_REDWOOD_GROVE));
        new ParameterPointListBuilder()
                .temperature(Temperature.HOT)
                .humidity(Humidity.span(Humidity.ARID, Humidity.DRY))
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.EROSION_3, Erosion.EROSION_4)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .weirdness(Weirdness.FULL_RANGE)
                .build().forEach(point -> builder.add(point, ModBiomes.TAR_DESERT));
        new ParameterPointListBuilder()
                .temperature(Temperature.span(Temperature.NEUTRAL, Temperature.HOT))
                .humidity(Humidity.span(Humidity.ARID, Humidity.DRY))
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.FULL_RANGE)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .weirdness(Weirdness.FULL_RANGE)
                .build().forEach(point -> builder.add(point, ModBiomes.VOLCANIC_PEAKS));

        builder.build().forEach(mapper);
    }
}
