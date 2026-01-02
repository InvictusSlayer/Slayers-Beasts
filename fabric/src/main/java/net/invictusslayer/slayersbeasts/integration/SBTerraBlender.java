package net.invictusslayer.slayersbeasts.integration;

import net.invictusslayer.slayersbeasts.SBFabric;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import terrablender.api.TerraBlenderApi;

public class SBTerraBlender implements TerraBlenderApi {
	@Override
	public void onTerraBlenderInitialized() {
		SBFabric.fabricInit();
		SlayersBeasts.registerRegions();
	}
}
