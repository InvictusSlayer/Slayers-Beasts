package net.invictusslayer.slayersbeasts.registries;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.world.level.gen.structure.structures.CryptPortalStructure;
import net.invictusslayer.slayersbeasts.world.level.gen.structure.structures.CryptStructure;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.structure.StructureType;

import java.util.function.Supplier;

public class SBStructureTypes {
	public static final Supplier<StructureType<CryptStructure>> CRYPT = register("crypt", () -> () -> CryptStructure.CODEC);
	public static final Supplier<StructureType<CryptPortalStructure>> CRYPT_PORTAL = register("crypt_portal", () -> () -> CryptPortalStructure.CODEC);

	private static <T extends StructureType<?>> Supplier<T> register(String name, Supplier<T> supplier) {
		return SlayersBeasts.PLATFORM.register(BuiltInRegistries.STRUCTURE_TYPE, SlayersBeasts.MOD_ID, name, supplier);
	}

	public static void register() {
		SlayersBeasts.LOGGER.info("Registering SBStructureTypes...");
	}
}
