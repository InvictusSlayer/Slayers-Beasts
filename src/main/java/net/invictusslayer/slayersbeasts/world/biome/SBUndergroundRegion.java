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

public class SBUndergroundRegion extends Region {
    public SBUndergroundRegion(int weight) {
        super(new ResourceLocation(SlayersBeasts.MOD_ID, "underground"), RegionType.OVERWORLD, weight);
    }

    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();

        new ParameterPointListBuilder()
                .temperature(Temperature.FULL_RANGE)
                .humidity(Humidity.ARID)
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.FULL_RANGE)
                .weirdness(Weirdness.FULL_RANGE)
                .depth(Depth.UNDERGROUND)
                .build().forEach(point -> builder.add(point, SBBiomes.DUSTY_CAVERNS));
        new ParameterPointListBuilder()
                .temperature(Temperature.FULL_RANGE)
                .humidity(Humidity.WET)
                .continentalness(Continentalness.FULL_RANGE)
                .erosion(Erosion.FULL_RANGE)
                .weirdness(Weirdness.FULL_RANGE)
                .depth(Depth.UNDERGROUND)
                .build().forEach(point -> builder.add(point, SBBiomes.FUNGAL_DEPTHS));
        new ParameterPointListBuilder()
                .temperature(Temperature.FROZEN)
                .humidity(Humidity.FULL_RANGE)
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.FULL_RANGE)
                .weirdness(Weirdness.FULL_RANGE)
                .depth(Depth.UNDERGROUND)
                .build().forEach(point -> builder.add(point, SBBiomes.ICE_CAVES));
        new ParameterPointListBuilder()
                .temperature(Temperature.NEUTRAL)
                .humidity(Humidity.NEUTRAL)
                .continentalness(Continentalness.FULL_RANGE)
                .erosion(Erosion.FULL_RANGE)
                .weirdness(Weirdness.FULL_RANGE)
                .depth(Depth.UNDERGROUND)
                .build().forEach(point -> builder.add(point, SBBiomes.SLIME_CAVERNS));

        builder.build().forEach(mapper);
    }
}
