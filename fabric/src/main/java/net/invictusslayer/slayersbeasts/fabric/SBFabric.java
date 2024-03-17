package net.invictusslayer.slayersbeasts.fabric;

import net.fabricmc.api.ModInitializer;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;

public class SBFabric implements ModInitializer {
	public void onInitialize() {
		SlayersBeasts.init();
		SlayersBeasts.commonSetup();
	}
}
