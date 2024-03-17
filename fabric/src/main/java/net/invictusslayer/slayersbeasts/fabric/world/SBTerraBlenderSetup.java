package net.invictusslayer.slayersbeasts.fabric.world;

import net.invictusslayer.slayersbeasts.common.world.biome.region.SBNetherRegion;
import net.invictusslayer.slayersbeasts.common.world.biome.region.SBOverworldRegion;
import terrablender.api.Regions;
import terrablender.api.TerraBlenderApi;

public class SBTerraBlenderSetup implements TerraBlenderApi {
	public void onTerraBlenderInitialized() {
		Regions.register(new SBOverworldRegion(2));
		Regions.register(new SBNetherRegion(2));
//		Regions.register(new SBEndRegion(2));
	}
}
