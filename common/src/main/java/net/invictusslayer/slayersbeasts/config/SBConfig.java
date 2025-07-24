package net.invictusslayer.slayersbeasts.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import net.invictusslayer.slayersbeasts.SlayersBeasts;

@Config(name = SlayersBeasts.MOD_ID)
public class SBConfig implements ConfigData {
	@ConfigEntry.Gui.CollapsibleObject
	public GenerationSettings worldgen = new GenerationSettings();

	public static class GenerationSettings {
		@ConfigEntry.Gui.PrefixText
		public boolean overworld_biomes = true;
		@ConfigEntry.Gui.PrefixText
		public int overworld_region_weight = 2;

		@ConfigEntry.Gui.PrefixText
		public boolean nether_biomes = true;
		@ConfigEntry.Gui.PrefixText
		public int nether_region_weight = 2;

		@ConfigEntry.Gui.PrefixText
		public boolean end_biomes = true;
		@ConfigEntry.Gui.PrefixText
		public int end_region_weight = 2;

//		@ConfigEntry.Gui.CollapsibleObject
//		public EnabledBiomes enabled_biomes = new EnabledBiomes();
	}

	public static class EnabledBiomes {
		@ConfigEntry.Gui.PrefixText
		public boolean ancient_grove = true;
		public boolean aspen_forest = true;
		public boolean bayou = true;
		public boolean black_dunes = true;
		public boolean brushland = true;
		public boolean rocky_brushland = true;
		public boolean wooded_brushland = true;
		public boolean chaparral = true;
		public boolean dead_sands = true;
		public boolean eucalypt_woodland = true;
		public boolean frozen_thicket = true;
		public boolean glaciate_swamp = true;
		public boolean inky_moor = true;
		public boolean murky_ocean = true;
		public boolean deep_murky_ocean = true;
		public boolean mushroom_forest = true;
		public boolean outback = true;
		public boolean petrified_woods = true;
		public boolean rainforest = true;
		public boolean redwood_grove = true;
		public boolean old_growth_redwood_grove = true;
		public boolean volcanic_peaks = true;

		@ConfigEntry.Gui.PrefixText
		public boolean dusty_caverns = true;
		public boolean fungal_depths = true;
		public boolean ice_caves = true;
		public boolean slime_caverns = true;

		@ConfigEntry.Gui.PrefixText
		public boolean toxic_jungle = true;

		@ConfigEntry.Gui.PrefixText
		public boolean end_spikes = true;
	}
}
