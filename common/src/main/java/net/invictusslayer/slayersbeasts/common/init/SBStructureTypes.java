package net.invictusslayer.slayersbeasts.common.init;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.world.structure.structures.CryptPortalStructure;
import net.invictusslayer.slayersbeasts.common.world.structure.structures.CryptStructure;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.structure.StructureType;

import java.util.function.Supplier;

public class SBStructureTypes {
	public static final Supplier<StructureType<CryptStructure>> CRYPT = register("crypt", () -> () -> CryptStructure.CODEC);
	public static final Supplier<StructureType<CryptPortalStructure>> CRYPT_PORTAL = register("crypt_portal", () -> () -> CryptPortalStructure.CODEC);

	private static <T extends StructureType<?>> Supplier<T> register(String name, Supplier<T> supplier) {
		return SlayersBeasts.PLATFORM.register(BuiltInRegistries.STRUCTURE_TYPE, name, supplier);
	}

	public static void register() {
		SlayersBeasts.LOGGER.info("Registering SBStructureTypes...");
	}
}
