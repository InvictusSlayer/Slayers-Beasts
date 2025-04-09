package net.invictusslayer.slayersbeasts.init;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.world.structure.pieces.CryptPortalPieces;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;

import java.util.function.Supplier;

public class SBStructurePieces {
	//? if neoforge
	/*public static final net.neoforged.neoforge.registries.DeferredRegister<StructurePieceType> STRUCTURE_PIECES = net.neoforged.neoforge.registries.DeferredRegister.create(Registries.STRUCTURE_PIECE, SlayersBeasts.MOD_ID);*/

	public static final Supplier<StructurePieceType> CRYPT_PORTAL = register("crypt_portal", (context, tag) -> new CryptPortalPieces.PortalPiece(tag));
	public static final Supplier<StructurePieceType> CRYPT_PORTAL_BASE = register("crypt_portal_base", (context, tag) -> new CryptPortalPieces.BasePiece(tag));

	private static <T extends StructurePieceType> Supplier<T> register(String name, T piece) {
		//? if fabric
		return () -> Registry.register(BuiltInRegistries.STRUCTURE_PIECE, ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, name), piece);
		//? if neoforge
		/*return STRUCTURE_PIECES.register(name, () -> piece);*/
	}

	public static void init() {
		SlayersBeasts.LOGGER.info("Initialised Structure Pieces");
	}
}
