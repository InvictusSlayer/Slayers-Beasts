package net.invictusslayer.slayersbeasts.common.world.structure.pieces;

import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import com.mojang.logging.LogUtils;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.block.JigsawBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.PoolElementStructurePiece;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.pools.EmptyPoolElement;
import net.minecraft.world.level.levelgen.structure.pools.JigsawJunction;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.apache.commons.lang3.mutable.MutableObject;

import java.util.Deque;
import java.util.List;
import java.util.Optional;

public class CryptPieces {
	public static Optional<Structure.GenerationStub> addPieces(Structure.GenerationContext context, Holder<StructureTemplatePool> start, BlockPos pos, int maxDistanceFromCenter) {
		RegistryAccess access = context.registryAccess();
		ChunkGenerator chunkGen = context.chunkGenerator();
		StructureTemplateManager manager = context.structureTemplateManager();
		LevelHeightAccessor heightAccessor = context.heightAccessor();
		WorldgenRandom random = context.random();
		Registry<StructureTemplatePool> registry = access.registryOrThrow(Registries.TEMPLATE_POOL);
		StructureTemplatePool pool = start.value();
		StructurePoolElement element = pool.getRandomTemplate(random);

		Vec3i vec3i = pos.subtract(pos);
		BlockPos blockPos = pos.subtract(vec3i);
		PoolElementStructurePiece piece = new PoolElementStructurePiece(manager, element, blockPos, element.getGroundLevelDelta(), Rotation.NONE, element.getBoundingBox(manager, blockPos, Rotation.NONE));
		BoundingBox box = piece.getBoundingBox();
		int x = (box.maxX() + box.minX()) / 2;
		int z = (box.maxZ() + box.minZ()) / 2;
		int y = vec3i.getY();

		return Optional.of(new Structure.GenerationStub(new BlockPos(x, y, z), builder -> {
			List<PoolElementStructurePiece> list = Lists.newArrayList();
			list.add(piece);
			AABB aabb = new AABB(x - maxDistanceFromCenter, y - maxDistanceFromCenter, z - maxDistanceFromCenter, x + maxDistanceFromCenter + 1, y + maxDistanceFromCenter + 1, z + maxDistanceFromCenter + 1);
			VoxelShape shape = Shapes.join(Shapes.create(aabb), Shapes.create(AABB.of(box)), BooleanOp.ONLY_FIRST);
			addPieces(context.randomState(), chunkGen, manager, heightAccessor, random, registry, piece, list, shape);
			list.forEach(builder::addPiece);
		}));

	}

	private static void addPieces(RandomState pRandomState, ChunkGenerator pChunkGenerator, StructureTemplateManager pStructureTemplateManager, LevelHeightAccessor pLevel, RandomSource pRandom, Registry<StructureTemplatePool> pPools, PoolElementStructurePiece p_227219_, List<PoolElementStructurePiece> pPieces, VoxelShape p_227221_) {
		Placer placer = new Placer(pPools, 7, pChunkGenerator, pStructureTemplateManager, pPieces, pRandom);
		placer.placing.addLast(new PieceState(p_227219_, new MutableObject<>(p_227221_), 0));

		while (!placer.placing.isEmpty()) {
			PieceState pieceState = placer.placing.removeFirst();
			placer.tryPlacingChildren(pieceState.piece, pieceState.free, pieceState.depth, pLevel, pRandomState);
		}

	}

	record PieceState(PoolElementStructurePiece piece, MutableObject<VoxelShape> free, int depth) {}

	private static final class Placer {
		private final Registry<StructureTemplatePool> pools;
		private final int maxDepth;
		private final ChunkGenerator chunkGen;
		private final StructureTemplateManager manager;
		private final List<? super PoolElementStructurePiece> pieces;
		private final RandomSource random;
		final Deque<CryptPieces.PieceState> placing = Queues.newArrayDeque();

		Placer(Registry<StructureTemplatePool> pools, int maxDepth, ChunkGenerator chunkGen, StructureTemplateManager manager, List<? super PoolElementStructurePiece> pieces, RandomSource random) {
			this.pools = pools;
			this.maxDepth = maxDepth;
			this.chunkGen = chunkGen;
			this.manager = manager;
			this.pieces = pieces;
			this.random = random;
		}

		void tryPlacingChildren(PoolElementStructurePiece piece, MutableObject<VoxelShape> free, int depth, LevelHeightAccessor pLevel, RandomState pRandomState) {
			StructurePoolElement element = piece.getElement();
			BlockPos pos = piece.getPosition();
			Rotation rotation = piece.getRotation();
			StructureTemplatePool.Projection projection1 = element.getProjection();
			boolean flag = projection1 == StructureTemplatePool.Projection.RIGID;
			MutableObject<VoxelShape> mutableShape = new MutableObject<>();
			BoundingBox box = piece.getBoundingBox();
			int y = box.minY();

			loop:
			for (StructureTemplate.StructureBlockInfo info : element.getShuffledJigsawBlocks(this.manager, pos, rotation, this.random)) {
				Direction direction = JigsawBlock.getFrontFacing(info.state());
				BlockPos blockPos = info.pos();
				BlockPos blockPos1 = blockPos.relative(direction);
				int j = blockPos.getY() - y;
				int k = -1;
				ResourceKey<StructureTemplatePool> poolName = readPoolName(info);
				Optional<? extends Holder<StructureTemplatePool>> optional = this.pools.getHolder(poolName);
				if (optional.isEmpty()) {
					LogUtils.getLogger().warn("Empty or non-existent pool: {}", poolName.location());
				}

				Holder<StructureTemplatePool> holder = optional.get();
				if (holder.value().size() == 0 && !holder.is(Pools.EMPTY)) {
					LogUtils.getLogger().warn("Empty or non-existent pool: {}", poolName.location());
				}

				Holder<StructureTemplatePool> holder1 = holder.value().getFallback();
				if (holder1.value().size() == 0 && !holder1.is(Pools.EMPTY)) {
					LogUtils.getLogger().warn("Empty or non-existent fallback pool: {}", holder1.unwrapKey().map((p_255599_) -> p_255599_.location().toString()).orElse("<unregistered>"));
				}

				MutableObject<VoxelShape> mutableObject;
				if (box.isInside(blockPos1)) {
					mutableObject = mutableShape;
					if (mutableShape.getValue() == null) {
						mutableShape.setValue(Shapes.create(AABB.of(box)));
					}
				} else {
					mutableObject = free;
				}

				List<StructurePoolElement> list = Lists.newArrayList();
				if (depth != this.maxDepth) {
					list.addAll(holder.value().getShuffledTemplates(this.random));
				}

				list.addAll(holder1.value().getShuffledTemplates(this.random));

				for (StructurePoolElement poolElement : list) {
					if (poolElement == EmptyPoolElement.INSTANCE) {
						break;
					}

					for (Rotation rotation1 : Rotation.getShuffled(this.random)) {
						List<StructureTemplate.StructureBlockInfo> list1 = poolElement.getShuffledJigsawBlocks(this.manager, BlockPos.ZERO, rotation1, this.random);

						for (StructureTemplate.StructureBlockInfo info1 : list1) {
							if (JigsawBlock.canAttach(info, info1)) {
								BlockPos blockPos2 = info1.pos();
								BlockPos blockPos3 = blockPos1.subtract(blockPos2);
								BoundingBox boundingBox = poolElement.getBoundingBox(this.manager, blockPos3, rotation1);
								int i1 = boundingBox.minY();
								StructureTemplatePool.Projection projection = poolElement.getProjection();
								boolean flag2 = projection == StructureTemplatePool.Projection.RIGID;
								int j1 = blockPos2.getY();
								int k1 = j - j1 + JigsawBlock.getFrontFacing(info.state()).getStepY();
								int l1;
								if (flag && flag2) {
									l1 = y + k1;
								} else {
									if (k == -1) {
										k = this.chunkGen.getFirstFreeHeight(blockPos.getX(), blockPos.getZ(), Heightmap.Types.WORLD_SURFACE_WG, pLevel, pRandomState);
									}

									l1 = k - j1;
								}

								int i2 = l1 - i1;
								BoundingBox boundingBox1 = boundingBox.moved(0, i2, 0);
								BlockPos blockPos4 = blockPos3.offset(0, i2, 0);

								if (!Shapes.joinIsNotEmpty(mutableObject.getValue(), Shapes.create(AABB.of(boundingBox1).deflate(0.25D)), BooleanOp.ONLY_SECOND)) {
									mutableObject.setValue(Shapes.joinUnoptimized(mutableObject.getValue(), Shapes.create(AABB.of(boundingBox1)), BooleanOp.ONLY_FIRST));
									int i3 = piece.getGroundLevelDelta();
									int k2;
									if (flag2) {
										k2 = i3 - k1;
									} else {
										k2 = poolElement.getGroundLevelDelta();
									}

									PoolElementStructurePiece piece1 = new PoolElementStructurePiece(this.manager, poolElement, blockPos4, k2, rotation1, boundingBox1);
									int l2;
									if (flag) {
										l2 = y + j;
									} else if (flag2) {
										l2 = l1 + j1;
									} else {
										if (k == -1) {
											k = this.chunkGen.getFirstFreeHeight(blockPos.getX(), blockPos.getZ(), Heightmap.Types.WORLD_SURFACE_WG, pLevel, pRandomState);
										}

										l2 = k + k1 / 2;
									}

									piece.addJunction(new JigsawJunction(blockPos1.getX(), l2 - j + i3, blockPos1.getZ(), k1, projection));
									piece1.addJunction(new JigsawJunction(blockPos.getX(), l2 - j1 + k2, blockPos.getZ(), -k1, projection1));
									this.pieces.add(piece1);
									if (depth + 1 <= this.maxDepth) {
										this.placing.addLast(new PieceState(piece1, mutableObject, depth + 1));
									}
									continue loop;
								}
							}
						}
					}
				}
			}
		}

		private static ResourceKey<StructureTemplatePool> readPoolName(StructureTemplate.StructureBlockInfo info) {
			assert info.nbt() != null;
			return ResourceKey.create(Registries.TEMPLATE_POOL, new ResourceLocation(info.nbt().getString("pool")));
		}
	}
}
