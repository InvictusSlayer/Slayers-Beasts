package net.invictusslayer.slayersbeasts.world.structure.structures;

import com.mojang.serialization.MapCodec;
import net.invictusslayer.slayersbeasts.init.SBStructureTypes;
import net.invictusslayer.slayersbeasts.world.structure.pieces.CryptPortalPieces;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;

import java.util.Optional;

public class CryptPortalStructure extends Structure {
	public static final MapCodec<CryptPortalStructure> CODEC = simpleCodec(CryptPortalStructure::new);

	public CryptPortalStructure(StructureSettings settings) {
		super(settings);
	}

	@SuppressWarnings("deprecation")
	public Optional<GenerationStub> findGenerationPoint(GenerationContext context) {
		BlockPos blockPos = getLowestYIn5by5BoxOffset7Blocks(context, Rotation.NONE);
		return blockPos.getY() < 62 ? Optional.empty() : Optional.of(new GenerationStub(blockPos, builder -> generatePieces(builder, context, blockPos)));
	}

	private void generatePieces(StructurePiecesBuilder builder, GenerationContext context, BlockPos blockPos) {
		CryptPortalPieces.addPieces(builder, context.random(), blockPos.getX(), blockPos.getY(), blockPos.getZ());
	}

	public StructureType<?> type() {
		return SBStructureTypes.CRYPT_PORTAL.get();
	}
}
