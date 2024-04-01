package net.invictusslayer.slayersbeasts;

import dev.architectury.injectables.annotations.ExpectPlatform;

import java.nio.file.Path;

public class SBPlatform {
	@ExpectPlatform
	public static Path getConfigDirectory() {
		throw new AssertionError();
	}
}
