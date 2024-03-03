package net.invictusslayer.slayersbeasts.forge.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class SBConfig {
	public static final ForgeConfigSpec COMMON_SPEC = new ForgeConfigSpec.Builder().configure(Common::new).getRight();

	public static class Common {
		public static ForgeConfigSpec.ConfigValue<Boolean> overworldBiomes;
		public static ForgeConfigSpec.ConfigValue<Integer> overworldRegionWeight;
		public static ForgeConfigSpec.ConfigValue<Boolean> netherBiomes;
		public static ForgeConfigSpec.ConfigValue<Integer> netherRegionWeight;
		public static ForgeConfigSpec.ConfigValue<Boolean> endBiomes;
		public static ForgeConfigSpec.ConfigValue<Integer> endRegionWeight;

		public Common(ForgeConfigSpec.Builder builder) {
			builder.push("generation_settings");
			overworldBiomes = builder.comment("Biomes in the Overworld are enabled.").define("overworld_biomes", true);
			overworldRegionWeight = builder.comment("The weighting of biome regions in the Overworld.").defineInRange("overworld_region_weight", 2, 0, Integer.MAX_VALUE);
			netherBiomes = builder.comment("Biomes in the Nether are enabled.").define("nether_biomes", true);
			netherRegionWeight = builder.comment("The weighting of biome regions in the Nether.").defineInRange("nether_region_weight", 2, 0, Integer.MAX_VALUE);
			endBiomes = builder.comment("Biomes in the End are enabled.").define("end_biomes", true);
			endRegionWeight = builder.comment("The weighting of biome regions in the End.").defineInRange("end_region_weight", 2, 0, Integer.MAX_VALUE);
			builder.pop();
		}
	}
}
