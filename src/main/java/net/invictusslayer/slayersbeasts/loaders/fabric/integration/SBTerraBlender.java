//? if fabric {
package net.invictusslayer.slayersbeasts.loaders.fabric.integration;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import terrablender.api.TerraBlenderApi;

public class SBTerraBlender implements TerraBlenderApi {
	public void onTerraBlenderInitialized() {
		SlayersBeasts.registerRegions();
	}
}
//?}