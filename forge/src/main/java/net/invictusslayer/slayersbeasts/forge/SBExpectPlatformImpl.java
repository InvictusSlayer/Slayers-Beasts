package net.invictusslayer.slayersbeasts.forge;

import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class SBExpectPlatformImpl {
	public static Path getConfigDirectory() {
		return FMLPaths.CONFIGDIR.get();
	}
}
