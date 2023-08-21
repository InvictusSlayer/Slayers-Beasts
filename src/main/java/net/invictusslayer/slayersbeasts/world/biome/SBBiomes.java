package net.invictusslayer.slayersbeasts.world.biome;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class SBBiomes {
    //OVERWORLD
    public static final ResourceKey<Biome> ANCIENT_GROVE = registerKey("ancient_grove");
    public static final ResourceKey<Biome> ASPEN_FOREST = registerKey("aspen_forest");
    public static final ResourceKey<Biome> BLACK_DUNES = registerKey("black_dunes");
    public static final ResourceKey<Biome> BRUSHLAND = registerKey("brushland");
    public static final ResourceKey<Biome> ROCKY_BRUSHLAND = registerKey("rocky_brushland");
    public static final ResourceKey<Biome> WOODED_BRUSHLAND = registerKey("wooded_brushland");
    public static final ResourceKey<Biome> EUCALYPT_FOREST = registerKey("eucalypt_forest");
    public static final ResourceKey<Biome> FROZEN_THICKET = registerKey("frozen_thicket");
    public static final ResourceKey<Biome> INKY_MOOR = registerKey("inky_moor");
    public static final ResourceKey<Biome> OUTBACK = registerKey("outback");
    public static final ResourceKey<Biome> PETRIFIED_WOODS = registerKey("petrified_woods");
    public static final ResourceKey<Biome> RAINFOREST = registerKey("rainforest");
    public static final ResourceKey<Biome> REDWOOD_GROVE = registerKey("redwood_grove");
    public static final ResourceKey<Biome> OLD_GROWTH_REDWOOD_GROVE = registerKey("old_growth_redwood_grove");
    public static final ResourceKey<Biome> TAR_DESERT = registerKey("tar_desert");
    public static final ResourceKey<Biome> VOLCANIC_PEAKS = registerKey("volcanic_peaks");

    //UNDERGROUND
    public static final ResourceKey<Biome> FUNGAL_DEPTHS = registerKey("fungal_depths");
    public static final ResourceKey<Biome> ICE_CAVES = registerKey("ice_caves");
    public static final ResourceKey<Biome> SLIME_CAVERNS = registerKey("slime_caverns");

    //NETHER

    //END
    public static final ResourceKey<Biome> END_SPIKES = registerKey("end_spikes");

    //CRYPT
    public static final ResourceKey<Biome> THE_CRYPT = registerKey("the_crypt");

    public static void bootstrap(BootstapContext<Biome> context) {
        HolderGetter<PlacedFeature> placed = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredWorldCarver<?>> carver = context.lookup(Registries.CONFIGURED_CARVER);

        register(context, ASPEN_FOREST, SBOverworldBiomes.aspenForest(placed, carver));
        register(context, BLACK_DUNES, SBOverworldBiomes.desert(placed, carver));
        register(context, EUCALYPT_FOREST, SBOverworldBiomes.eucalyptForest(placed, carver));
        register(context, FROZEN_THICKET, SBOverworldBiomes.frozenThicket(placed, carver));
        register(context, INKY_MOOR, SBOverworldBiomes.inkyMoor(placed, carver));
        register(context, OUTBACK, SBOverworldBiomes.outback(placed, carver));
        register(context, PETRIFIED_WOODS, SBOverworldBiomes.petrifiedWoods(placed, carver));
        register(context, RAINFOREST, SBOverworldBiomes.rainforest(placed, carver));
        register(context, REDWOOD_GROVE, SBOverworldBiomes.redwoodGrove(placed, carver, false));
        register(context, OLD_GROWTH_REDWOOD_GROVE, SBOverworldBiomes.redwoodGrove(placed, carver, true));
        register(context, TAR_DESERT, SBOverworldBiomes.desert(placed, carver));
        register(context, VOLCANIC_PEAKS, SBOverworldBiomes.volcanicPeaks(placed, carver));

        register(context, THE_CRYPT, SBCryptBiomes.theCrypt(placed, carver));
    }

    private static ResourceKey<Biome> registerKey(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(SlayersBeasts.MOD_ID, name));
    }

    private static void register(BootstapContext<Biome> context, ResourceKey<Biome> key, Biome biome) {
        context.register(key, biome);
    }
}
