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

public class SBOverworldRegion extends Region {
    private final Temperature[] TEMPERATURE = new Temperature[] {Temperature.ICY, Temperature.COOL, Temperature.NEUTRAL, Temperature.WARM, Temperature.HOT};
    private final Humidity[] HUMIDITY = new Humidity[] {Humidity.ARID, Humidity.DRY, Humidity.NEUTRAL, Humidity.WET, Humidity.HUMID};
    private final Continentalness[] INLANDNESS = new Continentalness[] {Continentalness.COAST, Continentalness.NEAR_INLAND, Continentalness.MID_INLAND, Continentalness.FAR_INLAND};
    private final Erosion[] EROSION = new Erosion[] {Erosion.EROSION_0, Erosion.EROSION_1, Erosion.EROSION_2, Erosion.EROSION_3, Erosion.EROSION_4, Erosion.EROSION_5, Erosion.EROSION_6};

    private final ResourceKey<Biome>[] RIVERS = new ResourceKey[] {Biomes.FROZEN_RIVER, Biomes.RIVER, Biomes.RIVER, Biomes.RIVER, Biomes.RIVER};
    private final ResourceKey<Biome>[] BEACHES = new ResourceKey[] {Biomes.SNOWY_BEACH, Biomes.BEACH, Biomes.BEACH, Biomes.BEACH, Biomes.DESERT};
    private final ResourceKey<Biome>[] SWAMPS = new ResourceKey[] {SBBiomes.GLACIATE_SWAMP, SBBiomes.INKY_MOOR, SBBiomes.INKY_MOOR, SBBiomes.BAYOU, SBBiomes.BAYOU};
    private final ResourceKey<Biome>[] SLOPES = new ResourceKey[] {Biomes.SNOWY_SLOPES, Biomes.SNOWY_SLOPES, Biomes.GROVE, Biomes.GROVE, Biomes.GROVE};

    private final ResourceKey<Biome>[][] MIDDLE_NORMAL = new ResourceKey[][] {
            {SBBiomes.FROZEN_THICKET, SBBiomes.ASPEN_FOREST, SBBiomes.CHAPARRAL, SBBiomes.CHAPARRAL, SBBiomes.DEAD_SANDS},
            {SBBiomes.FROZEN_THICKET, SBBiomes.ASPEN_FOREST, SBBiomes.CHAPARRAL, SBBiomes.CHAPARRAL, SBBiomes.DEAD_SANDS},
            {SBBiomes.FROZEN_THICKET, SBBiomes.ASPEN_FOREST, SBBiomes.OLD_GROWTH_REDWOOD_GROVE, SBBiomes.ANCIENT_GROVE, SBBiomes.DEAD_SANDS},
            {SBBiomes.FROZEN_THICKET, SBBiomes.ASPEN_FOREST, SBBiomes.REDWOOD_GROVE, SBBiomes.RAINFOREST, SBBiomes.DEAD_SANDS},
            {SBBiomes.FROZEN_THICKET, SBBiomes.ASPEN_FOREST, SBBiomes.REDWOOD_GROVE, SBBiomes.RAINFOREST, SBBiomes.DEAD_SANDS}
    };
    private final ResourceKey<Biome>[][] MIDDLE_VARIANT = new ResourceKey[][] {
            {SBBiomes.PETRIFIED_WOODS, SBBiomes.ASPEN_FOREST, SBBiomes.CHAPARRAL, SBBiomes.CHAPARRAL, SBBiomes.OUTBACK},
            {SBBiomes.FROZEN_THICKET, SBBiomes.ASPEN_FOREST, SBBiomes.CHAPARRAL, SBBiomes.CHAPARRAL, SBBiomes.OUTBACK},
            {SBBiomes.FROZEN_THICKET, SBBiomes.ASPEN_FOREST, SBBiomes.OLD_GROWTH_REDWOOD_GROVE, SBBiomes.ANCIENT_GROVE, SBBiomes.OUTBACK},
            {SBBiomes.FROZEN_THICKET, SBBiomes.ASPEN_FOREST, SBBiomes.REDWOOD_GROVE, SBBiomes.EUCALYPT_WOODLAND, SBBiomes.OUTBACK},
            {SBBiomes.FROZEN_THICKET, SBBiomes.ASPEN_FOREST, SBBiomes.REDWOOD_GROVE, SBBiomes.EUCALYPT_WOODLAND, SBBiomes.OUTBACK}
    };
    private ResourceKey<Biome> getMiddle(int h, int t, boolean variant) {
        return variant ? MIDDLE_VARIANT[h][t] : MIDDLE_NORMAL[h][t];
    }

    private final ResourceKey<Biome>[][] PLATEAU_NORMAL = new ResourceKey[][] {
            {SBBiomes.FROZEN_THICKET, SBBiomes.CHAPARRAL, SBBiomes.CHAPARRAL, SBBiomes.BLACK_DUNES, SBBiomes.BRUSHLAND},
            {SBBiomes.FROZEN_THICKET, SBBiomes.CHAPARRAL, SBBiomes.CHAPARRAL, SBBiomes.BLACK_DUNES, SBBiomes.BRUSHLAND},
            {SBBiomes.FROZEN_THICKET, SBBiomes.CHAPARRAL, SBBiomes.CHAPARRAL, SBBiomes.BLACK_DUNES, SBBiomes.BRUSHLAND},
            {SBBiomes.FROZEN_THICKET, SBBiomes.CHAPARRAL, SBBiomes.CHAPARRAL, SBBiomes.BLACK_DUNES, SBBiomes.WOODED_BRUSHLAND},
            {SBBiomes.FROZEN_THICKET, SBBiomes.ASPEN_FOREST, SBBiomes.EUCALYPT_WOODLAND, SBBiomes.BLACK_DUNES, SBBiomes.WOODED_BRUSHLAND}
    };
    private final ResourceKey<Biome>[][] PLATEAU_VARIANT = new ResourceKey[][] {
            {SBBiomes.PETRIFIED_WOODS, SBBiomes.ASPEN_FOREST, SBBiomes.OLD_GROWTH_REDWOOD_GROVE, SBBiomes.BLACK_DUNES, SBBiomes.ROCKY_BRUSHLAND},
            {SBBiomes.FROZEN_THICKET, SBBiomes.ASPEN_FOREST, SBBiomes.REDWOOD_GROVE, SBBiomes.BLACK_DUNES, SBBiomes.ROCKY_BRUSHLAND},
            {SBBiomes.FROZEN_THICKET, SBBiomes.ASPEN_FOREST, SBBiomes.REDWOOD_GROVE, SBBiomes.BLACK_DUNES, SBBiomes.BRUSHLAND},
            {SBBiomes.FROZEN_THICKET, SBBiomes.ASPEN_FOREST, SBBiomes.EUCALYPT_WOODLAND, SBBiomes.BLACK_DUNES, SBBiomes.WOODED_BRUSHLAND},
            {SBBiomes.FROZEN_THICKET, SBBiomes.ASPEN_FOREST, SBBiomes.EUCALYPT_WOODLAND, SBBiomes.BLACK_DUNES, SBBiomes.WOODED_BRUSHLAND}
    };
    private ResourceKey<Biome> getPlateau(int h, int t, boolean variant) {
        return variant ? PLATEAU_VARIANT[h][t] : PLATEAU_NORMAL[h][t];
    }

    private final ResourceKey<Biome>[][] SHATTERED_NORMAL = new ResourceKey[][] {
            {Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, SBBiomes.CHAPARRAL, SBBiomes.BLACK_DUNES},
            {Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, SBBiomes.CHAPARRAL, SBBiomes.BLACK_DUNES},
            {Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_HILLS, SBBiomes.CHAPARRAL, SBBiomes.BLACK_DUNES},
            {Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST, SBBiomes.RAINFOREST, SBBiomes.BLACK_DUNES},
            {Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST, SBBiomes.RAINFOREST, SBBiomes.BLACK_DUNES}
    };
    private final ResourceKey<Biome>[][] SHATTERED_VARIANT = new ResourceKey[][] {
            {Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, SBBiomes.CHAPARRAL, SBBiomes.BLACK_DUNES},
            {Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, SBBiomes.CHAPARRAL, SBBiomes.BLACK_DUNES},
            {Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_HILLS, SBBiomes.CHAPARRAL, SBBiomes.BLACK_DUNES},
            {Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST, SBBiomes.EUCALYPT_WOODLAND, SBBiomes.BLACK_DUNES},
            {Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST, SBBiomes.EUCALYPT_WOODLAND, SBBiomes.BLACK_DUNES}
    };
    private ResourceKey<Biome> getShattered(int h, int t, boolean variant) {
        return variant ? SHATTERED_VARIANT[h][t] : SHATTERED_NORMAL[h][t];
    }

    private final ResourceKey<Biome>[][] PEAKS_NORMAL = new ResourceKey[][] {
            {Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, SBBiomes.VOLCANIC_PEAKS, SBBiomes.VOLCANIC_PEAKS, SBBiomes.BRUSHLAND},
            {Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, SBBiomes.VOLCANIC_PEAKS, SBBiomes.VOLCANIC_PEAKS, SBBiomes.BRUSHLAND},
            {Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, SBBiomes.VOLCANIC_PEAKS, SBBiomes.VOLCANIC_PEAKS, SBBiomes.BRUSHLAND},
            {Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, SBBiomes.VOLCANIC_PEAKS, SBBiomes.VOLCANIC_PEAKS, SBBiomes.WOODED_BRUSHLAND},
            {Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, SBBiomes.VOLCANIC_PEAKS, SBBiomes.VOLCANIC_PEAKS, SBBiomes.WOODED_BRUSHLAND}
    };
    private final ResourceKey<Biome>[][] PEAKS_VARIANT = new ResourceKey[][] {
            {Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS, SBBiomes.VOLCANIC_PEAKS, SBBiomes.VOLCANIC_PEAKS, SBBiomes.ROCKY_BRUSHLAND},
            {Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS, SBBiomes.VOLCANIC_PEAKS, SBBiomes.VOLCANIC_PEAKS, SBBiomes.ROCKY_BRUSHLAND},
            {Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS, SBBiomes.VOLCANIC_PEAKS, SBBiomes.VOLCANIC_PEAKS, SBBiomes.BRUSHLAND},
            {Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS, SBBiomes.VOLCANIC_PEAKS, SBBiomes.VOLCANIC_PEAKS, SBBiomes.WOODED_BRUSHLAND},
            {Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS, SBBiomes.VOLCANIC_PEAKS, SBBiomes.VOLCANIC_PEAKS, SBBiomes.WOODED_BRUSHLAND}
    };
    private ResourceKey<Biome> getPeaks(int h, int t, boolean variant) {
        return variant ? PEAKS_VARIANT[h][t] : PEAKS_NORMAL[h][t];
    }

    private final ResourceKey<Biome>[][] MIDDLE_PLATEAU_NORMAL = new ResourceKey[][] {
            {MIDDLE_NORMAL[0][0], MIDDLE_NORMAL[0][1], MIDDLE_NORMAL[0][2], MIDDLE_NORMAL[0][3], PLATEAU_NORMAL[0][4]},
            {MIDDLE_NORMAL[1][0], MIDDLE_NORMAL[1][1], MIDDLE_NORMAL[1][2], MIDDLE_NORMAL[1][3], PLATEAU_NORMAL[1][4]},
            {MIDDLE_NORMAL[2][0], MIDDLE_NORMAL[2][1], MIDDLE_NORMAL[2][2], MIDDLE_NORMAL[2][3], PLATEAU_NORMAL[2][4]},
            {MIDDLE_NORMAL[3][0], MIDDLE_NORMAL[3][1], MIDDLE_NORMAL[3][2], MIDDLE_NORMAL[3][3], PLATEAU_NORMAL[3][4]},
            {MIDDLE_NORMAL[4][0], MIDDLE_NORMAL[4][1], MIDDLE_NORMAL[4][2], MIDDLE_NORMAL[4][3], PLATEAU_NORMAL[4][4]}
    };
    private final ResourceKey<Biome>[][] MIDDLE_PLATEAU_VARIANT = new ResourceKey[][] {
            {MIDDLE_VARIANT[0][0], MIDDLE_VARIANT[0][1], MIDDLE_VARIANT[0][2], MIDDLE_VARIANT[0][3], PLATEAU_VARIANT[0][4]},
            {MIDDLE_VARIANT[1][0], MIDDLE_VARIANT[1][1], MIDDLE_VARIANT[1][2], MIDDLE_VARIANT[1][3], PLATEAU_VARIANT[1][4]},
            {MIDDLE_VARIANT[2][0], MIDDLE_VARIANT[2][1], MIDDLE_VARIANT[2][2], MIDDLE_VARIANT[2][3], PLATEAU_VARIANT[2][4]},
            {MIDDLE_VARIANT[3][0], MIDDLE_VARIANT[3][1], MIDDLE_VARIANT[3][2], MIDDLE_VARIANT[3][3], PLATEAU_VARIANT[3][4]},
            {MIDDLE_VARIANT[4][0], MIDDLE_VARIANT[4][1], MIDDLE_VARIANT[4][2], MIDDLE_VARIANT[4][3], PLATEAU_VARIANT[4][4]}
    };
    private ResourceKey<Biome> getMiddlePlateau(int h, int t, boolean variant) {
        return variant ? MIDDLE_PLATEAU_VARIANT[h][t] : MIDDLE_PLATEAU_NORMAL[h][t];
    }

    private final ResourceKey<Biome> WINDSWEPT = Biomes.WINDSWEPT_SAVANNA;
    private final ResourceKey<Biome>[][] MIDDLE_WINDSWEPT = new ResourceKey[][] {
            {MIDDLE_VARIANT[0][0], MIDDLE_VARIANT[0][1], WINDSWEPT, WINDSWEPT, WINDSWEPT},
            {MIDDLE_VARIANT[1][0], MIDDLE_VARIANT[1][1], WINDSWEPT, WINDSWEPT, WINDSWEPT},
            {MIDDLE_VARIANT[2][0], MIDDLE_VARIANT[2][1], WINDSWEPT, WINDSWEPT, WINDSWEPT},
            {MIDDLE_VARIANT[3][0], MIDDLE_VARIANT[3][1], WINDSWEPT, WINDSWEPT, WINDSWEPT},
            {MIDDLE_VARIANT[4][0], MIDDLE_VARIANT[4][1], MIDDLE_VARIANT[4][2], MIDDLE_VARIANT[4][3], MIDDLE_VARIANT[4][4]}
    };
    private final ResourceKey<Biome>[][] SHATTERED_WINDSWEPT = new ResourceKey[][] {
            {SHATTERED_VARIANT[0][0], SHATTERED_VARIANT[0][1], WINDSWEPT, WINDSWEPT, WINDSWEPT},
            {SHATTERED_VARIANT[1][0], SHATTERED_VARIANT[1][1], WINDSWEPT, WINDSWEPT, WINDSWEPT},
            {SHATTERED_VARIANT[2][0], SHATTERED_VARIANT[2][1], WINDSWEPT, WINDSWEPT, WINDSWEPT},
            {SHATTERED_VARIANT[3][0], SHATTERED_VARIANT[3][1], WINDSWEPT, WINDSWEPT, WINDSWEPT},
            {SHATTERED_VARIANT[4][0], SHATTERED_VARIANT[4][1], SHATTERED_VARIANT[4][2], SHATTERED_VARIANT[4][3], SHATTERED_VARIANT[4][4]}
    };
    private ResourceKey<Biome> getWindswept(int h, int t, boolean variant) {
        return variant ? MIDDLE_WINDSWEPT[h][t] : MIDDLE_NORMAL[h][t];
    }

    public SBOverworldRegion(int weight) {
        super(new ResourceLocation(SlayersBeasts.MOD_ID, "overworld"), RegionType.OVERWORLD, weight);
    }

    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();

        addMidSlice(builder, Weirdness.MID_SLICE_NORMAL_ASCENDING, false);
        addHighSlice(builder, Weirdness.HIGH_SLICE_NORMAL_ASCENDING, false);
        addPeaks(builder, Weirdness.PEAK_NORMAL, false);
        addHighSlice(builder, Weirdness.HIGH_SLICE_NORMAL_DESCENDING, false);
        addMidSlice(builder, Weirdness.MID_SLICE_NORMAL_DESCENDING, false);
        addLowSlice(builder, Weirdness.LOW_SLICE_NORMAL_DESCENDING, false);
        addValleys(builder);
        addLowSlice(builder, Weirdness.LOW_SLICE_VARIANT_ASCENDING, true);
        addMidSlice(builder, Weirdness.MID_SLICE_VARIANT_ASCENDING, true);
        addHighSlice(builder, Weirdness.HIGH_SLICE_VARIANT_ASCENDING, true);
        addPeaks(builder, Weirdness.PEAK_VARIANT, true);
        addHighSlice(builder, Weirdness.HIGH_SLICE_VARIANT_DESCENDING, true);
        addMidSlice(builder, Weirdness.MID_SLICE_VARIANT_DESCENDING, true);

        builder.build().forEach(mapper);
    }

    private void addPeaks(VanillaParameterOverlayBuilder builder, Weirdness weirdness, boolean variant) {
        for (int h = 0; h < HUMIDITY.length; h++) {
            for (int t = 0; t < TEMPERATURE.length; t++) {
                /* Coast/Near-inland */
                for (int c = 0; c < 2; c++) {
                    biome(getPeaks(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], INLANDNESS[c], Erosion.EROSION_0, weirdness);
                    biome(t == 0 ? SLOPES[h] : getMiddlePlateau(h, t, variant), builder, Temperature.ICY, HUMIDITY[h], INLANDNESS[c], Erosion.EROSION_1, weirdness);
                    for (int e = 2; e < 5; e++) biome(getMiddle(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], INLANDNESS[c], EROSION[e], weirdness);
                    biome(variant ? SHATTERED_WINDSWEPT[h][t] : SHATTERED_NORMAL[h][t], builder, TEMPERATURE[t], HUMIDITY[h], INLANDNESS[c], Erosion.EROSION_5, weirdness);
                }
                for (Continentalness continentalness : INLANDNESS) biome(getMiddle(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], continentalness, Erosion.EROSION_6, weirdness);
                /* Mid/Far-inland */
                for (int c = 2; c < INLANDNESS.length; c++) {
                    biome(getPeaks(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], INLANDNESS[c], Erosion.EROSION_0, weirdness);
                    biome(getPeaks(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], INLANDNESS[c], Erosion.EROSION_1, weirdness);
                    biome(getMiddle(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], INLANDNESS[c], Erosion.EROSION_4, weirdness);
                    biome(getShattered(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], INLANDNESS[c], Erosion.EROSION_5, weirdness);
                }
                biome(getPlateau(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.MID_INLAND, Erosion.EROSION_2, weirdness);
                biome(getMiddlePlateau(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.MID_INLAND, Erosion.EROSION_3, weirdness);

                biome(getPlateau(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.FAR_INLAND, Erosion.EROSION_2, weirdness);
                biome(getPlateau(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.FAR_INLAND, Erosion.EROSION_3, weirdness);
            }
        }
    }

    private void addHighSlice(VanillaParameterOverlayBuilder builder, Weirdness weirdness, boolean variant) {
        for (int h = 0; h < HUMIDITY.length; h++) {
            for (int t = 0; t < TEMPERATURE.length; t++) {
                /* Coast */
                for (int e = 0; e < 5; e++) biome(getMiddle(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.COAST, EROSION[e], weirdness);
                biome(getWindswept(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.NEAR_INLAND, Erosion.EROSION_5, weirdness);
	            for (Continentalness continentalness : INLANDNESS) biome(getMiddle(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], continentalness, Erosion.EROSION_6, weirdness);
                /* Near-inland */
                biome(t < 3 ? SLOPES[h] : getPlateau(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.NEAR_INLAND, Erosion.EROSION_0, weirdness);
                biome(t == 0 ? SLOPES[h] : getMiddlePlateau(h, t, variant), builder, Temperature.ICY, HUMIDITY[h], Continentalness.NEAR_INLAND, Erosion.EROSION_1, weirdness);
                for (int e = 2; e < 5; e++) biome(getMiddle(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.NEAR_INLAND, EROSION[e], weirdness);
                biome(getWindswept(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.NEAR_INLAND, Erosion.EROSION_5, weirdness);
                /* Mid/Far-inland */
                for (int c = 2; c < INLANDNESS.length; c++) {
                    biome(getPeaks(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], INLANDNESS[c], Erosion.EROSION_0, weirdness);
                    biome(t < 3 ? SLOPES[h] : getPlateau(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], INLANDNESS[c], Erosion.EROSION_1, weirdness);
                    biome(getMiddle(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], INLANDNESS[c], Erosion.EROSION_4, weirdness);
                    biome(getShattered(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], INLANDNESS[c], Erosion.EROSION_5, weirdness);
                }
                biome(getPlateau(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.MID_INLAND, Erosion.EROSION_2, weirdness);
                biome(getMiddlePlateau(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.MID_INLAND, Erosion.EROSION_3, weirdness);

                biome(getPlateau(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.FAR_INLAND, Erosion.EROSION_2, weirdness);
                biome(getPlateau(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.FAR_INLAND, Erosion.EROSION_3, weirdness);
            }
        }
    }

    private void addMidSlice(VanillaParameterOverlayBuilder builder, Weirdness weirdness, boolean variant) {
        for (int h = 0; h < HUMIDITY.length; h++) {
            for (int t = 0; t < TEMPERATURE.length; t++) {
                /* Coast */
                for (int e = 0; e < 3; e++) biome(Biomes.STONY_SHORE, builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.COAST, EROSION[e], weirdness);
                biome(getMiddle(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.COAST, Erosion.EROSION_3, weirdness);
                if (variant) {
                    biome(MIDDLE_VARIANT[h][t], builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.COAST, Erosion.EROSION_4, weirdness);
                    biome(MIDDLE_WINDSWEPT[h][t], builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.COAST, Erosion.EROSION_5, weirdness);
                    biome(MIDDLE_VARIANT[h][t], builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.COAST, Erosion.EROSION_6, weirdness);
                } else {
                    for (int e = 4; e < EROSION.length; e++) biome(BEACHES[t], builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.COAST, EROSION[e], weirdness);
                }
                /* Near-inland */
                for (int c = 1; c < INLANDNESS.length; c++) {
                    biome(t < 3 ? SLOPES[h] : getPlateau(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], INLANDNESS[c], Erosion.EROSION_0, weirdness);
                    if (t == 0) biome(SLOPES[h], builder, Temperature.ICY, HUMIDITY[h], INLANDNESS[c], Erosion.EROSION_1, weirdness);
                }
                if (t > 0) {
                    biome(getMiddlePlateau(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.NEAR_INLAND, Erosion.EROSION_1, weirdness);
                    biome(getMiddlePlateau(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.MID_INLAND, Erosion.EROSION_1, weirdness);
                    biome(getPlateau(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.FAR_INLAND, Erosion.EROSION_1, weirdness);
                }
                for (int e = 2; e < 5; e++) biome(getMiddle(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.NEAR_INLAND, EROSION[e], weirdness);
                biome(getWindswept(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.NEAR_INLAND, Erosion.EROSION_5, weirdness);
                /* Swamp */
                for (int c = 1; c < INLANDNESS.length; c++) biome(SWAMPS[t], builder, TEMPERATURE[t], HUMIDITY[h], INLANDNESS[c], Erosion.EROSION_6, weirdness);
                /* Mid-inland */
                biome(getMiddlePlateau(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.MID_INLAND, Erosion.EROSION_2, weirdness);
                biome(getMiddlePlateau(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.MID_INLAND, Erosion.EROSION_3, weirdness);
                biome(getMiddle(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.MID_INLAND, Erosion.EROSION_4, weirdness);
                biome(getShattered(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.MID_INLAND, Erosion.EROSION_5, weirdness);
                /* Far-inland */
                biome(getPlateau(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.FAR_INLAND, Erosion.EROSION_2, weirdness);
                biome(getMiddlePlateau(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.MID_INLAND, Erosion.EROSION_3, weirdness);
                biome(getMiddle(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.FAR_INLAND, Erosion.EROSION_4, weirdness);
                biome(getShattered(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.FAR_INLAND, Erosion.EROSION_5, weirdness);
            }
        }
    }

    private void addLowSlice(VanillaParameterOverlayBuilder builder, Weirdness weirdness, boolean variant) {
        for (int h = 0; h < HUMIDITY.length; h++) {
            for (int t = 0; t < TEMPERATURE.length; t++) {
                /* Coast */
                for (int e = 0; e < 3; e++) biome(Biomes.STONY_SHORE, builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.COAST, EROSION[e], weirdness);
                for (int e = 3; e < 5; e++) biome(BEACHES[t], builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.COAST, EROSION[e], weirdness);
                biome(variant ? MIDDLE_WINDSWEPT[h][t] : BEACHES[t], builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.COAST, Erosion.EROSION_5, weirdness);
                biome(BEACHES[t], builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.COAST, Erosion.EROSION_6, weirdness);
                /* Near-inland */
                biome(getWindswept(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.NEAR_INLAND, Erosion.EROSION_5, weirdness);
                for (int e = 0; e < 2; e++) biome(getMiddlePlateau(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.NEAR_INLAND, EROSION[e], weirdness);
                for (int e = 2; e < 5; e++) biome(getMiddle(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.NEAR_INLAND, EROSION[e], weirdness);
                /* Swamp */
                for (int c = 1; c < INLANDNESS.length; c++) biome(SWAMPS[t], builder, TEMPERATURE[t], HUMIDITY[h], INLANDNESS[c], Erosion.EROSION_6, weirdness);
                /* Mid/Far-inland */
                for (int e = 0; e < 4; e++) {
                    biome(getMiddlePlateau(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.MID_INLAND, EROSION[e], weirdness);
                    biome(getMiddlePlateau(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.FAR_INLAND, EROSION[e], weirdness);
                }
                for (int e = 4; e < 6; e++) {
                    biome(getMiddle(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.MID_INLAND, EROSION[e], weirdness);
                    biome(getMiddle(h, t, variant), builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.FAR_INLAND, EROSION[e], weirdness);
                }
            }
        }
    }

    private void addValleys(VanillaParameterOverlayBuilder builder) {
        for (int h = 0; h < HUMIDITY.length; h++) {
            for (int t = 0; t < TEMPERATURE.length; t++) {
                /* Coast */
                for (Erosion erosion : EROSION) biome(RIVERS[t], builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.COAST, erosion, Weirdness.VALLEY);
                /* Near-inland */
                for (int e = 0; e < 6; e++) biome(RIVERS[t], builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.NEAR_INLAND, EROSION[e], Weirdness.VALLEY);
                /* Swamp */
                for (int c = 1; c < INLANDNESS.length; c++) biome(SWAMPS[t], builder, TEMPERATURE[t], HUMIDITY[h], INLANDNESS[c], Erosion.EROSION_6, Weirdness.VALLEY);
                /* Mid/Far-inland */
                for (int e = 2; e < 6; e++) {
                    biome(RIVERS[t], builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.MID_INLAND, EROSION[e], Weirdness.VALLEY);
                    biome(RIVERS[t], builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.FAR_INLAND, EROSION[e], Weirdness.VALLEY);
                }
                for (int e = 0; e < 2; e++) {
                    biome(MIDDLE_PLATEAU_NORMAL[h][t], builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.MID_INLAND, EROSION[e], Weirdness.VALLEY);
                    biome(MIDDLE_PLATEAU_NORMAL[h][t], builder, TEMPERATURE[t], HUMIDITY[h], Continentalness.FAR_INLAND, EROSION[e], Weirdness.VALLEY);
                }
            }
        }
    }

    private void biome(ResourceKey<Biome> biome, VanillaParameterOverlayBuilder builder, Temperature temperature, Humidity humidity, Continentalness continentalness, Erosion erosion, Weirdness weirdness) {
        new ParameterPointListBuilder().temperature(temperature).humidity(humidity).continentalness(continentalness).erosion(erosion).weirdness(weirdness).depth(Depth.FLOOR).build().forEach(point -> builder.add(point, biome));
        new ParameterPointListBuilder().temperature(temperature).humidity(humidity).continentalness(continentalness).erosion(erosion).weirdness(weirdness).depth(Depth.SURFACE).build().forEach(point -> builder.add(point, biome));
    }
}
