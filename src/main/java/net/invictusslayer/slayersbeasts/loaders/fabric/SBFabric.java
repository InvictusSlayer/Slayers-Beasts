//? if fabric {
package net.invictusslayer.slayersbeasts.loaders.fabric;

import net.fabricmc.api.ModInitializer;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.init.SBEntities;

public class SBFabric implements ModInitializer {
	public void onInitialize() {
		SlayersBeasts.init();

//		SBBiomeModifications.registerFeatures();
		SBEntities.registerAttributes();

		SlayersBeasts.commonSetup();
	}
}
//?}