package net.invictusslayer.slayersbeasts.misc;

import net.minecraftforge.common.ForgeConfigSpec;

public class SBConfig {
	public static final ForgeConfigSpec COMMON_SPEC = new ForgeConfigSpec.Builder().configure(Common::new).getRight();

	public static class Common {
		public static ForgeConfigSpec.ConfigValue<Boolean> overworldBiomes;
		public static ForgeConfigSpec.ConfigValue<Boolean> netherBiomes;
		public static ForgeConfigSpec.ConfigValue<Boolean> endBiomes;

		public Common(ForgeConfigSpec.Builder builder) {
			builder.push("generation_settings");
			overworldBiomes = builder.comment("Overworld biomes enabled").define("overworld_biomes", true);
			netherBiomes = builder.comment("Nether biomes enabled").define("nether_biomes", true);
			endBiomes = builder.comment("End biomes enabled").define("end_biomes", true);
			builder.pop();
		}
	}
}
