package net.invictusslayer.slayersbeasts.fabric;

import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class SBExpectPlatformImpl {
	public static Path getConfigDirectory() {
		return FabricLoader.getInstance().getConfigDir();
	}
}
