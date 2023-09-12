package net.invictusslayer.slayersbeasts.world.structure.pieces;

import net.invictusslayer.slayersbeasts.block.InfusedCryptalithBlock;
import net.invictusslayer.slayersbeasts.block.SBBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;

public class CryptPortalPieces {
	public static void addPieces(StructurePiecesBuilder builder, RandomSource random, int x, int y, int z) {
		builder.addPiece(PortalPiece.createPiece(random, x, y, z));
		builder.addPiece(BasePiece.createPiece(x - 1, y - 1, z + 1));
	}

	public static class PortalPiece extends StructurePiece {
		public PortalPiece(BoundingBox box, Direction direction) {
			super(SBStructurePieces.CRYPT_PORTAL.get(), 0, box);
			setOrientation(direction);
		}

		public PortalPiece(CompoundTag tag) {
			super(SBStructurePieces.CRYPT_PORTAL.get(), tag);
		}
		
		private static PortalPiece createPiece(RandomSource random, int x, int y, int z) {
			boolean hasTop = random.nextBoolean();
			BoundingBox box = BoundingBox.orientBox(x, y, z, 0, 1, 0, 3, hasTop ? 6 : 1, 3, Direction.NORTH);
			return new PortalPiece(box, Direction.NORTH);
		}

		protected void addAdditionalSaveData(StructurePieceSerializationContext context, CompoundTag tag) {
		}

		public void postProcess(WorldGenLevel level, StructureManager manager, ChunkGenerator chunkGen, RandomSource random, BoundingBox box, ChunkPos chunkPos, BlockPos pos) {
			BlockState cryptalith = SBBlocks.CRYPTALITH.get().defaultBlockState();
			BlockState air = Blocks.CAVE_AIR.defaultBlockState();
			BlockState north = SBBlocks.INFUSED_CRYPTALITH.get().defaultBlockState().setValue(InfusedCryptalithBlock.FACING, Direction.NORTH);
			BlockState east = SBBlocks.INFUSED_CRYPTALITH.get().defaultBlockState().setValue(InfusedCryptalithBlock.FACING, Direction.EAST);
			BlockState south = SBBlocks.INFUSED_CRYPTALITH.get().defaultBlockState().setValue(InfusedCryptalithBlock.FACING, Direction.SOUTH);
			BlockState west = SBBlocks.INFUSED_CRYPTALITH.get().defaultBlockState().setValue(InfusedCryptalithBlock.FACING, Direction.WEST);

			generateBox(level, box, 0, -1, 0, 3, boundingBox.getYSpan() - 1, 3, cryptalith, air, false);
			generateBox(level, box, 1, 0, 1, 2, 0, 2, air, air, false);
			generateBox(level, box, 0, 1, 1, 0, 3, 2, air, air, false);
			generateBox(level, box, 1, 1, 0, 2, 3, 0, air, air, false);
			generateBox(level, box, 3, 1, 1, 3, 3, 2, air, air, false);
			placeBlock(level, air, 0, 5, 0, box);
			placeBlock(level, air, 0, 5, 3, box);
			placeBlock(level, air, 3, 5, 3, box);
			placeBlock(level, air, 3, 5, 0, box);

			placeBlock(level, north, 1, 0, 0, box);
			placeBlock(level, north, 2, 0, 0, box);
			placeBlock(level, east, 0, 0, 2, box);
			placeBlock(level, east, 0, 0, 1, box);
			placeBlock(level, south, 2, 0, 3, box);
			placeBlock(level, south, 1, 0, 3, box);
			placeBlock(level, west, 3, 0, 1, box);
			placeBlock(level, west, 3, 0, 2, box);
		}
	}

	public static class BasePiece extends StructurePiece {
		public BasePiece(BoundingBox box, Direction direction) {
			super(SBStructurePieces.CRYPT_PORTAL_BASE.get(), 0, box);
			setOrientation(direction);
		}

		public BasePiece(CompoundTag tag) {
			super(SBStructurePieces.CRYPT_PORTAL_BASE.get(), tag);
		}

		private static BasePiece createPiece(int x, int y, int z) {
			BoundingBox box = BoundingBox.orientBox(x, y, z, 0, 1, 0, 5, 1, 5, Direction.NORTH);
			return new BasePiece(box, Direction.NORTH);
		}

		protected void addAdditionalSaveData(StructurePieceSerializationContext context, CompoundTag tag) {
		}

		public void postProcess(WorldGenLevel level, StructureManager manager, ChunkGenerator chunkGen, RandomSource random, BoundingBox box, ChunkPos chunkPos, BlockPos pos) {
			BlockState cryptalith = SBBlocks.CRYPTALITH.get().defaultBlockState();

			generateBox(level, box, 0, 0, 0, 5, 0, 5, cryptalith, cryptalith, false);
		}
	}
}
