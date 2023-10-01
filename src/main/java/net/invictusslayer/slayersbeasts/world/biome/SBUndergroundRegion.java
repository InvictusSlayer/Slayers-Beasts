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

        biome(SBBiomes.DUSTY_CAVERNS, builder, Temperature.FULL_RANGE, Humidity.ARID, Continentalness.INLAND);
        biome(SBBiomes.FUNGAL_DEPTHS, builder, Temperature.FULL_RANGE, Humidity.WET, Continentalness.FULL_RANGE);
        biome(SBBiomes.ICE_CAVES, builder, Temperature.ICY, Humidity.FULL_RANGE, Continentalness.INLAND);
        biome(SBBiomes.SLIME_CAVERNS, builder, Temperature.NEUTRAL, Humidity.NEUTRAL, Continentalness.FULL_RANGE);

        builder.build().forEach(mapper);
    }

    private void biome(ResourceKey<Biome> biome, VanillaParameterOverlayBuilder builder, Temperature temperature, Humidity humidity, Continentalness continentalness) {
        new ParameterPointListBuilder().temperature(temperature).humidity(humidity).continentalness(continentalness).erosion(Erosion.FULL_RANGE).weirdness(Weirdness.FULL_RANGE).depth(Depth.UNDERGROUND).build().forEach(point -> builder.add(point, biome));
    }
}
