package net.invictusslayer.slayersbeasts.integration;

import net.invictusslayer.scabbard.api.ScabbardApi;
import net.invictusslayer.slayersbeasts.SBFabric;

public class SBScabbard implements ScabbardApi {
	@Override
	public void onScabbardInitialised() {
		SBFabric.fabricInit();
	}
}
