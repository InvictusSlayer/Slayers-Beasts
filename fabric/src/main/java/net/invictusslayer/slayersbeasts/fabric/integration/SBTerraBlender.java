package net.invictusslayer.slayersbeasts.fabric.integration;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.fabric.SBFabric;
import terrablender.api.TerraBlenderApi;

public class SBTerraBlender implements TerraBlenderApi {
	public void onTerraBlenderInitialized() {
		SBFabric.fabricInit();
		SlayersBeasts.registerRegions();
	}
}
