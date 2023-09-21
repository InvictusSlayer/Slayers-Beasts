package net.invictusslayer.slayersbeasts.world.biome;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class SBBiomes {
    //Overworld
    public static final ResourceKey<Biome> ANCIENT_GROVE = createKey("ancient_grove");
    public static final ResourceKey<Biome> ASPEN_FOREST = createKey("aspen_forest");
    public static final ResourceKey<Biome> BLACK_DUNES = createKey("black_dunes");
    public static final ResourceKey<Biome> BRUSHLAND = createKey("brushland");
    public static final ResourceKey<Biome> ROCKY_BRUSHLAND = createKey("rocky_brushland");
    public static final ResourceKey<Biome> WOODED_BRUSHLAND = createKey("wooded_brushland");
    public static final ResourceKey<Biome> CHAPARRAL = createKey("chaparral");
    public static final ResourceKey<Biome> DEAD_SANDS = createKey("dead_sands");
    public static final ResourceKey<Biome> EUCALYPT_WOODLAND = createKey("eucalypt_woodland");
    public static final ResourceKey<Biome> FROZEN_THICKET = createKey("frozen_thicket");
    public static final ResourceKey<Biome> INKY_MOOR = createKey("inky_moor");
    public static final ResourceKey<Biome> OUTBACK = createKey("outback");
    public static final ResourceKey<Biome> PETRIFIED_WOODS = createKey("petrified_woods");
    public static final ResourceKey<Biome> RAINFOREST = createKey("rainforest");
    public static final ResourceKey<Biome> REDWOOD_GROVE = createKey("redwood_grove");
    public static final ResourceKey<Biome> OLD_GROWTH_REDWOOD_GROVE = createKey("old_growth_redwood_grove");
    public static final ResourceKey<Biome> VOLCANIC_PEAKS = createKey("volcanic_peaks");

    //Underground
    public static final ResourceKey<Biome> DUSTY_CAVERNS = createKey("dusty_caverns");
    public static final ResourceKey<Biome> FUNGAL_DEPTHS = createKey("fungal_depths");
    public static final ResourceKey<Biome> ICE_CAVES = createKey("ice_caves");
    public static final ResourceKey<Biome> SLIME_CAVERNS = createKey("slime_caverns");

    //Nether
    public static final ResourceKey<Biome> TOXIC_JUNGLE = createKey("toxic_jungle");

    //End
    public static final ResourceKey<Biome> END_SPIKES = createKey("end_spikes");

    //Crypt
    public static final ResourceKey<Biome> THE_CRYPT = createKey("the_crypt");

    public static void bootstrap(BootstapContext<Biome> context) {
        HolderGetter<PlacedFeature> placed = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredWorldCarver<?>> carver = context.lookup(Registries.CONFIGURED_CARVER);

        register(context, ANCIENT_GROVE, SBOverworldBiomes.ancientGrove(placed, carver), VillagerType.JUNGLE);
        register(context, ASPEN_FOREST, SBOverworldBiomes.aspenForest(placed, carver));
        register(context, BLACK_DUNES, SBOverworldBiomes.desert(placed, carver), VillagerType.DESERT);
        register(context, BRUSHLAND, SBOverworldBiomes.brushland(placed, carver, false, false), VillagerType.SAVANNA);
        register(context, ROCKY_BRUSHLAND, SBOverworldBiomes.brushland(placed, carver, false, true), VillagerType.SAVANNA);
        register(context, WOODED_BRUSHLAND, SBOverworldBiomes.brushland(placed, carver, true, false), VillagerType.SAVANNA);
        register(context, CHAPARRAL, SBOverworldBiomes.chaparral(placed, carver));
        register(context, DEAD_SANDS, SBOverworldBiomes.desert(placed, carver), VillagerType.DESERT);
        register(context, EUCALYPT_WOODLAND, SBOverworldBiomes.eucalyptWoodland(placed, carver), VillagerType.SAVANNA);
        register(context, FROZEN_THICKET, SBOverworldBiomes.frozenThicket(placed, carver), VillagerType.SNOW);
        register(context, INKY_MOOR, SBOverworldBiomes.inkyMoor(placed, carver), VillagerType.SWAMP);
        register(context, OUTBACK, SBOverworldBiomes.outback(placed, carver), VillagerType.SAVANNA);
        register(context, PETRIFIED_WOODS, SBOverworldBiomes.petrifiedWoods(placed, carver), VillagerType.SNOW);
        register(context, RAINFOREST, SBOverworldBiomes.rainforest(placed, carver), VillagerType.JUNGLE);
        register(context, REDWOOD_GROVE, SBOverworldBiomes.redwoodGrove(placed, carver, false), VillagerType.TAIGA);
        register(context, OLD_GROWTH_REDWOOD_GROVE, SBOverworldBiomes.redwoodGrove(placed, carver, true), VillagerType.TAIGA);
        register(context, VOLCANIC_PEAKS, SBOverworldBiomes.volcanicPeaks(placed, carver));

        register(context, DUSTY_CAVERNS, SBOverworldBiomes.dustyCaverns(placed, carver));
        register(context, FUNGAL_DEPTHS, SBOverworldBiomes.fungalDepths(placed, carver));
        register(context, ICE_CAVES, SBOverworldBiomes.iceCaves(placed, carver));
        register(context, SLIME_CAVERNS, SBOverworldBiomes.slimeCaverns(placed, carver));

        register(context, TOXIC_JUNGLE, SBNetherBiomes.toxicJungle(placed, carver));

        register(context, THE_CRYPT, SBOverworldBiomes.theCrypt(placed, carver));
    }

    private static ResourceKey<Biome> createKey(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(SlayersBeasts.MOD_ID, name));
    }

    private static void register(BootstapContext<Biome> context, ResourceKey<Biome> key, Biome biome, VillagerType villagerType) {
        register(context, key, biome);
        VillagerType.BY_BIOME.put(key, villagerType);
    }

    private static void register(BootstapContext<Biome> context, ResourceKey<Biome> key, Biome biome) {
        context.register(key, biome);
    }
}
