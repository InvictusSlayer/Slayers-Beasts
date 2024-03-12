package net.invictusslayer.slayersbeasts.common.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.world.structure.pieces.CryptPortalPieces;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;

public class SBStructurePieces {
	public static final DeferredRegister<StructurePieceType> STRUCTURE_PIECES = DeferredRegister.create(SlayersBeasts.MOD_ID, Registries.STRUCTURE_PIECE);

	public static final RegistrySupplier<StructurePieceType> CRYPT_PORTAL = STRUCTURE_PIECES.register("crypt_portal", () -> (context, tag) -> new CryptPortalPieces.PortalPiece(tag));
	public static final RegistrySupplier<StructurePieceType> CRYPT_PORTAL_BASE = STRUCTURE_PIECES.register("crypt_portal_base", () -> (context, tag) -> new CryptPortalPieces.BasePiece(tag));
}
