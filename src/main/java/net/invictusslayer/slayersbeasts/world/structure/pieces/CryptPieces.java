package net.invictusslayer.slayersbeasts.world.structure.pieces;

import com.google.common.collect.Lists;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.util.SequencedPriorityIterator;
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
import net.minecraft.world.level.levelgen.structure.pools.alias.PoolAliasLookup;
import net.minecraft.world.level.levelgen.structure.templatesystem.LiquidSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.apache.commons.lang3.mutable.MutableObject;

import java.util.List;
import java.util.Optional;

public class CryptPieces {
	public static Optional<Structure.GenerationStub> addPieces(Structure.GenerationContext context, Holder<StructureTemplatePool> start, BlockPos pos, int maxDistanceFromCenter, PoolAliasLookup lookup, LiquidSettings liquidSettings) {
		RegistryAccess access = context.registryAccess();
		ChunkGenerator chunkGen = context.chunkGenerator();
		StructureTemplateManager manager = context.structureTemplateManager();
		LevelHeightAccessor heightAccessor = context.heightAccessor();
		WorldgenRandom random = context.random();
		Registry<StructureTemplatePool> registry = access.lookupOrThrow(Registries.TEMPLATE_POOL);
		StructureTemplatePool pool = start.value();
		StructurePoolElement element = pool.getRandomTemplate(random);

		Vec3i vec3i = pos.subtract(pos);
		BlockPos blockPos = pos.subtract(vec3i);
		PoolElementStructurePiece piece = new PoolElementStructurePiece(manager, element, blockPos, element.getGroundLevelDelta(), Rotation.NONE, element.getBoundingBox(manager, blockPos, Rotation.NONE), LiquidSettings.IGNORE_WATERLOGGING);
		BoundingBox box = piece.getBoundingBox();
		int x = (box.maxX() + box.minX()) / 2;
		int z = (box.maxZ() + box.minZ()) / 2;
		int y = vec3i.getY();

		return Optional.of(new Structure.GenerationStub(new BlockPos(x, y, z), builder -> {
			List<PoolElementStructurePiece> list = Lists.newArrayList();
			list.add(piece);
			AABB aabb = new AABB(x - maxDistanceFromCenter, y - maxDistanceFromCenter, z - maxDistanceFromCenter, x + maxDistanceFromCenter + 1, y + maxDistanceFromCenter + 1, z + maxDistanceFromCenter + 1);
			VoxelShape shape = Shapes.join(Shapes.create(aabb), Shapes.create(AABB.of(box)), BooleanOp.ONLY_FIRST);
			addPieces(context.randomState(), 7, false, chunkGen, manager, heightAccessor, random, registry, piece, list, shape, lookup, liquidSettings);
			list.forEach(builder::addPiece);
		}));

	}

	private static void addPieces(RandomState randomState, int maxDepth, boolean useExpansionHack, ChunkGenerator chunkGenerator, StructureTemplateManager structureTemplateManager, LevelHeightAccessor level, RandomSource random, Registry<StructureTemplatePool> pools, PoolElementStructurePiece startPiece, List<PoolElementStructurePiece> pieces, VoxelShape free, PoolAliasLookup aliasLookup, LiquidSettings liquidSettings) {
		Placer placer = new Placer(pools, maxDepth, chunkGenerator, structureTemplateManager, pieces, random);
		placer.tryPlacingChildren(startPiece, new MutableObject<>(free), 0, useExpansionHack, level, randomState, aliasLookup, liquidSettings);

		while (placer.placing.hasNext()) {
			PieceState pieceState = placer.placing.next();
			placer.tryPlacingChildren(pieceState.piece, pieceState.free, pieceState.depth, useExpansionHack, level, randomState, aliasLookup, liquidSettings);
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
		final SequencedPriorityIterator<CryptPieces.PieceState> placing = new SequencedPriorityIterator<>();

		Placer(Registry<StructureTemplatePool> pools, int maxDepth, ChunkGenerator chunkGen, StructureTemplateManager manager, List<? super PoolElementStructurePiece> pieces, RandomSource random) {
			this.pools = pools;
			this.maxDepth = maxDepth;
			this.chunkGen = chunkGen;
			this.manager = manager;
			this.pieces = pieces;
			this.random = random;
		}

		void tryPlacingChildren(PoolElementStructurePiece piece, MutableObject<VoxelShape> free, int depth, boolean useExpansionHack, LevelHeightAccessor level, RandomState random, PoolAliasLookup lookup, LiquidSettings liquidSettings) {
			StructurePoolElement element = piece.getElement();
			BlockPos pos = piece.getPosition();
			Rotation rotation = piece.getRotation();
			StructureTemplatePool.Projection projection = element.getProjection();
			boolean flag = projection == StructureTemplatePool.Projection.RIGID;
			MutableObject<VoxelShape> mutableObject = new MutableObject<>();
			BoundingBox box = piece.getBoundingBox();
			int y = box.minY();

			loop:
			for (StructureTemplate.JigsawBlockInfo jigsawBlockInfo : element.getShuffledJigsawBlocks(this.manager, pos, rotation, this.random)) {
				StructureTemplate.StructureBlockInfo info = jigsawBlockInfo.info();
				Direction direction = JigsawBlock.getFrontFacing(info.state());
				BlockPos blockPos = info.pos();
				BlockPos blockPos1 = blockPos.relative(direction);
				int j = blockPos.getY() - y;
				int k = Integer.MIN_VALUE;
				ResourceKey<StructureTemplatePool> resourceKey = readPoolName(jigsawBlockInfo, lookup);
				Optional<? extends Holder<StructureTemplatePool>> optional = this.pools.get(resourceKey);
				if (optional.isEmpty()) {
					SlayersBeasts.LOGGER.warn("Empty or non-existent pool: {}", resourceKey.location());
				} else {
					Holder<StructureTemplatePool> holder = optional.get();
					if (holder.value().size() == 0 && !holder.is(Pools.EMPTY)) {
						SlayersBeasts.LOGGER.warn("Empty or non-existent pool: {}", resourceKey.location());
					} else {
						Holder<StructureTemplatePool> holder2 = holder.value().getFallback();
						if (holder2.value().size() == 0 && !holder2.is(Pools.EMPTY)) {
							SlayersBeasts.LOGGER.warn("Empty or non-existent fallback pool: {}", holder2.unwrapKey().map(resourceKeyx -> resourceKeyx.location().toString()).orElse("<unregistered>"));
						} else {
							boolean bl2 = box.isInside(blockPos1);
							MutableObject<VoxelShape> mutableObject2;
							if (bl2) {
								mutableObject2 = mutableObject;
								if (mutableObject.getValue() == null) {
									mutableObject.setValue(Shapes.create(AABB.of(box)));
								}
							} else {
								mutableObject2 = free;
							}

							List<StructurePoolElement> list = Lists.newArrayList();
							if (depth != this.maxDepth) {
								list.addAll(holder.value().getShuffledTemplates(this.random));
							}

							list.addAll(holder2.value().getShuffledTemplates(this.random));
							int l = jigsawBlockInfo.placementPriority();

							for (StructurePoolElement poolElement : list) {
								if (poolElement == EmptyPoolElement.INSTANCE) {
									break;
								}

								for (Rotation rotation2 : Rotation.getShuffled(this.random)) {
									List<StructureTemplate.JigsawBlockInfo> list2 = poolElement.getShuffledJigsawBlocks(this.manager, BlockPos.ZERO, rotation2, this.random);
									BoundingBox boundingBox2 = poolElement.getBoundingBox(this.manager, BlockPos.ZERO, rotation2);
									int m;
									if (useExpansionHack && boundingBox2.getYSpan() <= 16) {
										m = list2.stream().mapToInt(jigsawBlockInfox -> {
											StructureTemplate.StructureBlockInfo structureBlockInfox = jigsawBlockInfox.info();
											if (!boundingBox2.isInside(structureBlockInfox.pos().relative(JigsawBlock.getFrontFacing(structureBlockInfox.state())))) {
												return 0;
											} else {
												ResourceKey<StructureTemplatePool> resourceKeyx = readPoolName(jigsawBlockInfox, lookup);
												Optional<? extends Holder<StructureTemplatePool>> optionalx = this.pools.get(resourceKeyx);
												Optional<Holder<StructureTemplatePool>> optional2 = optionalx.map(holderx -> holderx.value().getFallback());
												int ix = optionalx.map(holderx -> holderx.value().getMaxSize(this.manager)).orElse(0);
												int jx = optional2.map(holderx -> holderx.value().getMaxSize(this.manager)).orElse(0);
												return Math.max(ix, jx);
											}
										}).max().orElse(0);
									} else {
										m = 0;
									}

									for (StructureTemplate.JigsawBlockInfo jigsawBlockInfo2 : list2) {
										if (JigsawBlock.canAttach(jigsawBlockInfo, jigsawBlockInfo2)) {
											BlockPos blockPos4 = jigsawBlockInfo2.info().pos();
											BlockPos blockPos5 = blockPos1.subtract(blockPos4);
											BoundingBox boundingBox3 = poolElement.getBoundingBox(this.manager, blockPos5, rotation2);
											int n = boundingBox3.minY();
											StructureTemplatePool.Projection projection2 = poolElement.getProjection();
											boolean bl3 = projection2 == StructureTemplatePool.Projection.RIGID;
											int o = blockPos4.getY();
											int p = j - o + JigsawBlock.getFrontFacing(info.state()).getStepY();
											int q;
											if (flag && bl3) {
												q = y + p;
											} else {
												if (k == Integer.MIN_VALUE) {
													k = this.chunkGen.getFirstFreeHeight(blockPos.getX(), blockPos.getZ(), Heightmap.Types.WORLD_SURFACE_WG, level, random);
												}

												q = k - o;
											}

											int r = q - n;
											BoundingBox boundingBox4 = boundingBox3.moved(0, r, 0);
											BlockPos blockPos6 = blockPos5.offset(0, r, 0);
											if (m > 0) {
												int s = Math.max(m + 1, boundingBox4.maxY() - boundingBox4.minY());
												boundingBox4.encapsulate(new BlockPos(boundingBox4.minX(), boundingBox4.minY() + s, boundingBox4.minZ()));
											}

											if (!Shapes.joinIsNotEmpty(mutableObject2.getValue(), Shapes.create(AABB.of(boundingBox4).deflate(0.25)), BooleanOp.ONLY_SECOND)) {
												mutableObject2.setValue(Shapes.joinUnoptimized(mutableObject2.getValue(), Shapes.create(AABB.of(boundingBox4)), BooleanOp.ONLY_FIRST));
												int s = piece.getGroundLevelDelta();
												int t;
												if (bl3) {
													t = s - p;
												} else {
													t = poolElement.getGroundLevelDelta();
												}

												PoolElementStructurePiece poolElementStructurePiece = new PoolElementStructurePiece(
														this.manager, poolElement, blockPos6, t, rotation2, boundingBox4, liquidSettings
												);
												int u;
												if (flag) {
													u = y + j;
												} else if (bl3) {
													u = q + o;
												} else {
													if (k == Integer.MIN_VALUE) {
														k = this.chunkGen.getFirstFreeHeight(blockPos.getX(), blockPos.getZ(), Heightmap.Types.WORLD_SURFACE_WG, level, random);
													}

													u = k + p / 2;
												}

												piece.addJunction(new JigsawJunction(blockPos1.getX(), u - j + s, blockPos1.getZ(), p, projection2));
												poolElementStructurePiece.addJunction(new JigsawJunction(blockPos.getX(), u - o + t, blockPos.getZ(), -p, projection));
												this.pieces.add(poolElementStructurePiece);
												if (depth + 1 <= this.maxDepth) {
													PieceState pieceState = new PieceState(poolElementStructurePiece, mutableObject2, depth + 1);
													this.placing.add(pieceState, l);
												}
												continue loop;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		private static ResourceKey<StructureTemplatePool> readPoolName(StructureTemplate.JigsawBlockInfo info, PoolAliasLookup lookup) {
			return lookup.lookup(Pools.createKey(info.pool()));
		}
	}
}
