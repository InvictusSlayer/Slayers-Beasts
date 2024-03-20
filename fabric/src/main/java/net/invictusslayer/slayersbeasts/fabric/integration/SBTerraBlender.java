package net.invictusslayer.slayersbeasts.fabric.integration;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import terrablender.api.TerraBlenderApi;

public class SBTerraBlender implements TerraBlenderApi {
	public void onTerraBlenderInitialized() {
		SlayersBeasts.registerRegions();
	}
}
