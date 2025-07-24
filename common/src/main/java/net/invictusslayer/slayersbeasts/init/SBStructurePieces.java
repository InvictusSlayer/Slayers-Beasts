package net.invictusslayer.slayersbeasts.init;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.world.structure.pieces.CryptPortalPieces;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;

import java.util.function.Supplier;

public class SBStructurePieces {
	public static final Supplier<StructurePieceType> CRYPT_PORTAL = register("crypt_portal", () -> (context, tag) -> new CryptPortalPieces.PortalPiece(tag));
	public static final Supplier<StructurePieceType> CRYPT_PORTAL_BASE = register("crypt_portal_base", () -> (context, tag) -> new CryptPortalPieces.BasePiece(tag));

	private static <T extends StructurePieceType> Supplier<T> register(String name, Supplier<T> supplier) {
		return SlayersBeasts.PLATFORM.register(BuiltInRegistries.STRUCTURE_PIECE, SlayersBeasts.MOD_ID, name, supplier);
	}

	public static void register() {
		SlayersBeasts.LOGGER.info("Registering SBStructurePieces...");
	}
}
