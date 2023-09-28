package net.invictusslayer.slayersbeasts.world.biome;

import com.mojang.datafixers.util.Pair;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
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
    public SBOverworldRegion(int weight) {
        super(new ResourceLocation(SlayersBeasts.MOD_ID, "overworld"), RegionType.OVERWORLD, weight);
    }

    private final Climate.Parameter NORMAL_WEIRDNESS = Weirdness.span(Weirdness.MID_SLICE_NORMAL_ASCENDING, Weirdness.LOW_SLICE_NORMAL_DESCENDING);
    private final Climate.Parameter VARIANT_WEIRDNESS = Weirdness.span(Weirdness.LOW_SLICE_VARIANT_ASCENDING, Weirdness.MID_SLICE_VARIANT_DESCENDING);
    private final Climate.Parameter NORMAL_HILLS = Weirdness.span(Weirdness.MID_SLICE_NORMAL_ASCENDING, Weirdness.MID_SLICE_NORMAL_DESCENDING);
    private final Climate.Parameter VARIANT_HILLS = Weirdness.span(Weirdness.MID_SLICE_VARIANT_ASCENDING, Weirdness.MID_SLICE_VARIANT_DESCENDING);

    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();

        new ParameterPointListBuilder()
                .temperature(Temperature.WARM)
                .humidity(Humidity.HUMID)
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.FULL_RANGE)
                .weirdness(NORMAL_WEIRDNESS, VARIANT_WEIRDNESS)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .build().forEach(point -> builder.add(point, SBBiomes.ANCIENT_GROVE));
        new ParameterPointListBuilder()
                .temperature(Temperature.COOL)
                .humidity(Humidity.NEUTRAL, Humidity.WET)
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.FULL_RANGE)
                .weirdness(NORMAL_WEIRDNESS, VARIANT_WEIRDNESS)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .build().forEach(point -> builder.add(point, SBBiomes.ASPEN_FOREST));
        new ParameterPointListBuilder()
                .temperature(Temperature.HOT)
                .humidity(Humidity.WET)
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.FULL_RANGE)
                .weirdness(Weirdness.FULL_RANGE)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .build().forEach(point -> builder.add(point, SBBiomes.BAYOU));
        new ParameterPointListBuilder()
                .temperature(Temperature.HOT)
                .humidity(Humidity.ARID)
                .continentalness(Continentalness.MID_INLAND, Continentalness.FAR_INLAND)
                .erosion(Erosion.FULL_RANGE)
                .weirdness(NORMAL_HILLS, VARIANT_HILLS)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .build().forEach(point -> builder.add(point, SBBiomes.BLACK_DUNES));
        new ParameterPointListBuilder()
                .temperature(Temperature.HOT)
                .humidity(Humidity.DRY, Humidity.NEUTRAL)
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.EROSION_0, Erosion.EROSION_1, Erosion.EROSION_4)
                .weirdness(NORMAL_WEIRDNESS, VARIANT_WEIRDNESS)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .build().forEach(point -> builder.add(point, SBBiomes.BRUSHLAND));
        new ParameterPointListBuilder()
                .temperature(Temperature.HOT)
                .humidity(Humidity.DRY, Humidity.NEUTRAL)
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.EROSION_5, Erosion.EROSION_6)
                .weirdness(NORMAL_WEIRDNESS, VARIANT_WEIRDNESS)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .build().forEach(point -> builder.add(point, SBBiomes.ROCKY_BRUSHLAND));
        new ParameterPointListBuilder()
                .temperature(Temperature.HOT)
                .humidity(Humidity.DRY, Humidity.NEUTRAL)
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.EROSION_2, Erosion.EROSION_3)
                .weirdness(NORMAL_WEIRDNESS, VARIANT_WEIRDNESS)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .build().forEach(point -> builder.add(point, SBBiomes.WOODED_BRUSHLAND));
        new ParameterPointListBuilder()
                .temperature(Temperature.NEUTRAL)
                .humidity(Humidity.DRY)
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.FULL_RANGE)
                .weirdness(NORMAL_WEIRDNESS, VARIANT_WEIRDNESS)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .build().forEach(point -> builder.add(point, SBBiomes.CHAPARRAL));
        new ParameterPointListBuilder()
                .temperature(Temperature.HOT)
                .humidity(Humidity.ARID)
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.FULL_RANGE)
                .weirdness(NORMAL_WEIRDNESS, VARIANT_WEIRDNESS)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .build().forEach(point -> builder.add(point, SBBiomes.DEAD_SANDS));
        new ParameterPointListBuilder()
                .temperature(Temperature.WARM)
                .humidity(Humidity.NEUTRAL, Humidity.WET)
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.FULL_RANGE)
                .weirdness(NORMAL_WEIRDNESS, VARIANT_WEIRDNESS)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .build().forEach(point -> builder.add(point, SBBiomes.EUCALYPT_WOODLAND));
        new ParameterPointListBuilder()
                .temperature(Temperature.ICY)
                .humidity(Humidity.NEUTRAL, Humidity.WET)
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.FULL_RANGE)
                .weirdness(NORMAL_WEIRDNESS, VARIANT_WEIRDNESS)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .build().forEach(point -> builder.add(point, SBBiomes.FROZEN_THICKET));
        new ParameterPointListBuilder()
                .temperature(Temperature.span(Temperature.COOL, Temperature.NEUTRAL))
                .humidity(Humidity.HUMID)
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.FULL_RANGE)
                .weirdness(Weirdness.FULL_RANGE)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .build().forEach(point -> builder.add(point, SBBiomes.INKY_MOOR));
        new ParameterPointListBuilder()
                .temperature(Temperature.span(Temperature.COOL, Temperature.HOT))
                .humidity(Humidity.FULL_RANGE)
                .continentalness(Continentalness.OCEAN)
                .erosion(Erosion.FULL_RANGE)
                .weirdness(Weirdness.FULL_RANGE)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .build().forEach(point -> builder.add(point, SBBiomes.MURKY_OCEAN));
        new ParameterPointListBuilder()
                .temperature(Temperature.span(Temperature.COOL, Temperature.HOT))
                .humidity(Humidity.FULL_RANGE)
                .continentalness(Continentalness.DEEP_OCEAN)
                .erosion(Erosion.FULL_RANGE)
                .weirdness(Weirdness.FULL_RANGE)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .build().forEach(point -> builder.add(point, SBBiomes.DEEP_MURKY_OCEAN));
        new ParameterPointListBuilder()
                .temperature(Temperature.WARM)
                .humidity(Humidity.DRY, Humidity.ARID)
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.FULL_RANGE)
                .weirdness(NORMAL_WEIRDNESS, VARIANT_WEIRDNESS)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .build().forEach(point -> builder.add(point, SBBiomes.OUTBACK));
        new ParameterPointListBuilder()
                .temperature(Temperature.NEUTRAL)
                .humidity(Humidity.ARID)
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.FULL_RANGE)
                .weirdness(NORMAL_WEIRDNESS, VARIANT_WEIRDNESS)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .build().forEach(point -> builder.add(point, SBBiomes.PETRIFIED_WOODS));
        new ParameterPointListBuilder()
                .temperature(Temperature.HOT)
                .humidity(Humidity.HUMID)
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.FULL_RANGE)
                .weirdness(NORMAL_WEIRDNESS, VARIANT_WEIRDNESS)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .build().forEach(point -> builder.add(point, SBBiomes.RAINFOREST));
        new ParameterPointListBuilder()
                .temperature(Temperature.NEUTRAL)
                .humidity(Humidity.NEUTRAL, Humidity.WET)
                .continentalness(Continentalness.COAST, Continentalness.NEAR_INLAND)
                .erosion(Erosion.EROSION_0, Erosion.EROSION_1, Erosion.EROSION_4)
                .weirdness(NORMAL_WEIRDNESS, VARIANT_WEIRDNESS)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .build().forEach(point -> builder.add(point, SBBiomes.REDWOOD_GROVE));
        new ParameterPointListBuilder()
                .temperature(Temperature.NEUTRAL)
                .humidity(Humidity.NEUTRAL, Humidity.WET)
                .continentalness(Continentalness.COAST, Continentalness.NEAR_INLAND)
                .erosion(Erosion.EROSION_2, Erosion.EROSION_3)
                .weirdness(NORMAL_WEIRDNESS, VARIANT_WEIRDNESS)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .build().forEach(point -> builder.add(point, SBBiomes.OLD_GROWTH_REDWOOD_GROVE));
        new ParameterPointListBuilder()
                .temperature(Temperature.COOL)
                .humidity(Humidity.ARID, Humidity.DRY)
                .continentalness(Continentalness.MID_INLAND, Continentalness.FAR_INLAND)
                .erosion(Erosion.span(Erosion.EROSION_0, Erosion.EROSION_3))
                .weirdness(NORMAL_HILLS, VARIANT_HILLS)
                .depth(Depth.FLOOR, Depth.SURFACE)
                .build().forEach(point -> builder.add(point, SBBiomes.VOLCANIC_PEAKS));

        builder.build().forEach(mapper);
    }
}
