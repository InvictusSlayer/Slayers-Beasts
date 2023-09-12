package net.invictusslayer.slayersbeasts.world.structure.pieces;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.world.structure.pieces.CryptPortalPieces;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class SBStructurePieces {
	public static final DeferredRegister<StructurePieceType> STRUCTURE_PIECES = DeferredRegister.create(Registries.STRUCTURE_PIECE, SlayersBeasts.MOD_ID);

	public static final RegistryObject<StructurePieceType> CRYPT_PORTAL = STRUCTURE_PIECES.register("crypt_portal", () -> (context, tag) -> new CryptPortalPieces.PortalPiece(tag));
	public static final RegistryObject<StructurePieceType> CRYPT_PORTAL_BASE = STRUCTURE_PIECES.register("crypt_portal_base", () -> (context, tag) -> new CryptPortalPieces.BasePiece(tag));
}
