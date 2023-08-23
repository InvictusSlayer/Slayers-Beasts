package net.invictusslayer.slayersbeasts.world.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.ParameterUtils.*;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

public class SBOverworldRegion extends Region {
    public SBOverworldRegion(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    private final Climate.Parameter NORMAL_WEIRDNESS = Weirdness.span(Weirdness.MID_SLICE_NORMAL_ASCENDING, Weirdness.LOW_SLICE_NORMAL_DESCENDING);
    private final Climate.Parameter VARIANT_WEIRDNESS = Weirdness.span(Weirdness.LOW_SLICE_VARIANT_ASCENDING, Weirdness.MID_SLICE_VARIANT_DESCENDING);

    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();

        new ParameterPointListBuilder()
                .temperature(Temperature.COOL)
                .humidity(Humidity.span(Humidity.NEUTRAL, Humidity.WET))
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.FULL_RANGE)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .weirdness(NORMAL_WEIRDNESS, VARIANT_WEIRDNESS)
                .build().forEach(point -> builder.add(point, SBBiomes.ASPEN_FOREST));
        new ParameterPointListBuilder()
                .temperature(Temperature.HOT)
                .humidity(Humidity.span(Humidity.ARID, Humidity.DRY))
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.FULL_RANGE)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .weirdness(Weirdness.span(Weirdness.HIGH_SLICE_NORMAL_DESCENDING, Weirdness.LOW_SLICE_NORMAL_DESCENDING), VARIANT_WEIRDNESS)
                .build().forEach(point -> builder.add(point, SBBiomes.BLACK_DUNES));
        new ParameterPointListBuilder()
                .temperature(Temperature.WARM)
                .humidity(Humidity.span(Humidity.ARID, Humidity.DRY))
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.span(Erosion.EROSION_4, Erosion.EROSION_6))
                .depth(Depth.FLOOR, Depth.SURFACE)
                .weirdness(NORMAL_WEIRDNESS, VARIANT_WEIRDNESS)
                .build().forEach(point -> builder.add(point, SBBiomes.BRUSHLAND));
        new ParameterPointListBuilder()
                .temperature(Temperature.WARM)
                .humidity(Humidity.span(Humidity.ARID, Humidity.DRY))
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.FULL_RANGE)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .weirdness(Weirdness.span(Weirdness.HIGH_SLICE_NORMAL_DESCENDING, Weirdness.LOW_SLICE_NORMAL_DESCENDING), VARIANT_WEIRDNESS)
                .build().forEach(point -> builder.add(point, SBBiomes.ROCKY_BRUSHLAND));
        new ParameterPointListBuilder()
                .temperature(Temperature.WARM)
                .humidity(Humidity.span(Humidity.ARID, Humidity.DRY))
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.FULL_RANGE)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .weirdness(Weirdness.span(Weirdness.HIGH_SLICE_VARIANT_ASCENDING, Weirdness.HIGH_SLICE_VARIANT_DESCENDING))
                .build().forEach(point -> builder.add(point, SBBiomes.WOODED_BRUSHLAND));
        new ParameterPointListBuilder()
                .temperature(Temperature.HOT)
                .humidity(Humidity.span(Humidity.ARID, Humidity.DRY))
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.FULL_RANGE)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .weirdness(NORMAL_WEIRDNESS, VARIANT_WEIRDNESS)
                .build().forEach(point -> builder.add(point, SBBiomes.DEAD_SANDS));
        new ParameterPointListBuilder()
                .temperature(Temperature.WARM)
                .humidity(Humidity.DRY)
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.span(Erosion.EROSION_0, Erosion.EROSION_3))
                .depth(Depth.FLOOR, Depth.SURFACE)
                .weirdness(NORMAL_WEIRDNESS, VARIANT_WEIRDNESS)
                .build().forEach(point -> builder.add(point, SBBiomes.EUCALYPT_WOODLAND));
        new ParameterPointListBuilder()
                .temperature(Temperature.ICY)
                .humidity(Humidity.span(Humidity.ARID, Humidity.DRY))
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.FULL_RANGE)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .weirdness(NORMAL_WEIRDNESS, VARIANT_WEIRDNESS)
                .build().forEach(point -> builder.add(point, SBBiomes.FROZEN_THICKET));
        new ParameterPointListBuilder()
                .temperature(Temperature.COOL)
                .humidity(Humidity.HUMID)
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.FULL_RANGE)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .weirdness(NORMAL_WEIRDNESS, VARIANT_WEIRDNESS)
                .build().forEach(point -> builder.add(point, SBBiomes.INKY_MOOR));
        new ParameterPointListBuilder()
                .temperature(Temperature.HOT)
                .humidity(Humidity.span(Humidity.ARID, Humidity.DRY))
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.FULL_RANGE)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .weirdness(NORMAL_WEIRDNESS, VARIANT_WEIRDNESS)
                .build().forEach(point -> builder.add(point, SBBiomes.OUTBACK));
        new ParameterPointListBuilder()
                .temperature(Temperature.COOL)
                .humidity(Humidity.ARID)
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.FULL_RANGE)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .weirdness(NORMAL_WEIRDNESS, VARIANT_WEIRDNESS)
                .build().forEach(point -> builder.add(point, SBBiomes.PETRIFIED_WOODS));
        new ParameterPointListBuilder()
                .temperature(Temperature.span(Temperature.WARM, Temperature.HOT))
                .humidity(Humidity.HUMID)
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.FULL_RANGE)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .weirdness(NORMAL_WEIRDNESS, VARIANT_WEIRDNESS)
                .build().forEach(point -> builder.add(point, SBBiomes.RAINFOREST));
        new ParameterPointListBuilder()
                .temperature(Temperature.WARM)
                .humidity(Humidity.span(Humidity.NEUTRAL, Humidity.WET))
                .continentalness(Continentalness.MID_INLAND, Continentalness.NEAR_INLAND, Continentalness.COAST)
                .erosion(Erosion.FULL_RANGE)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .weirdness(NORMAL_WEIRDNESS, VARIANT_WEIRDNESS)
                .build().forEach(point -> builder.add(point, SBBiomes.REDWOOD_GROVE));
        new ParameterPointListBuilder()
                .temperature(Temperature.WARM)
                .humidity(Humidity.span(Humidity.NEUTRAL, Humidity.WET))
                .continentalness(Continentalness.MID_INLAND, Continentalness.NEAR_INLAND, Continentalness.COAST)
                .erosion(Erosion.FULL_RANGE)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .weirdness(NORMAL_WEIRDNESS, VARIANT_WEIRDNESS)
                .build().forEach(point -> builder.add(point, SBBiomes.OLD_GROWTH_REDWOOD_GROVE));
        new ParameterPointListBuilder()
                .temperature(Temperature.span(Temperature.NEUTRAL, Temperature.WARM))
                .humidity(Humidity.span(Humidity.ARID, Humidity.DRY))
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.FULL_RANGE)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .weirdness(Weirdness.span(Weirdness.HIGH_SLICE_NORMAL_ASCENDING, Weirdness.HIGH_SLICE_NORMAL_DESCENDING), Weirdness.span(Weirdness.HIGH_SLICE_VARIANT_ASCENDING, Weirdness.HIGH_SLICE_VARIANT_DESCENDING))
                .build().forEach(point -> builder.add(point, SBBiomes.VOLCANIC_PEAKS));

        builder.build().forEach(mapper);
    }
}
