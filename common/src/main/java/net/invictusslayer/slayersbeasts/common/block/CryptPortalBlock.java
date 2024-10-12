package net.invictusslayer.slayersbeasts.common.block;

import net.invictusslayer.slayersbeasts.common.init.SBBlocks;
import net.invictusslayer.slayersbeasts.common.init.SBFeatures;
import net.invictusslayer.slayersbeasts.common.world.dimension.SBDimensions;
import net.invictusslayer.slayersbeasts.common.world.structure.SBStructures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.SectionPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class CryptPortalBlock extends Block {
	private static final VoxelShape SHAPE = Block.box(0.0D, 6.0D, 0.0D, 16.0D, 12.0D, 16.0D);

	public CryptPortalBlock(Properties properties) {
		super(properties);
	}

	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
		List<BlockPos> posList = List.of(currentPos.north(), currentPos.east(), currentPos.south(), currentPos.west());
		for (BlockPos pos : posList) {
			Block block = level.getBlockState(pos).getBlock();
			if (block != this && block != SBBlocks.INFUSED_CRYPTALITH.get() && block != SBBlocks.DEPLETED_CRYPTALITH.get()) {
				return Blocks.AIR.defaultBlockState();
			}
		}

		return super.updateShape(state, facing, facingState, level, currentPos, facingPos);
	}

	public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state) {
		return ItemStack.EMPTY;
	}

	public boolean canBeReplaced(BlockState state, Fluid fluid) {
		return false;
	}

	public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
		if (entity instanceof ServerPlayer player) {
			MinecraftServer server = level.getServer();
			if (server == null) return;

			ResourceKey<Level> destination = player.level().dimension() == SBDimensions.CRYPT ? Level.OVERWORLD : SBDimensions.CRYPT;
			ServerLevel serverLevel = server.getLevel(destination);
			if (serverLevel == null) return;
			if (!player.canChangeDimensions(level, serverLevel)) return;

			if (destination == SBDimensions.CRYPT) {
				if (serverLevel.players().isEmpty()) resetCrypt(serverLevel);
				player.teleportTo(serverLevel, 3.5, 61, 3, Set.of(), player.getYRot(), player.getXRot());
			} else {
				BlockPos spawn = player.getRespawnDimension() == destination ? player.getRespawnPosition() : level.getSharedSpawnPos();
				if (spawn == null) spawn = level.getSharedSpawnPos();
				player.teleportTo(serverLevel, spawn.getX(), spawn.getY(), spawn.getZ(), Set.of(), player.getYRot(), player.getXRot());
			}
		}
	}

	private void resetCrypt(ServerLevel level) {
		ChunkGenerator chunkGen = level.getChunkSource().getGenerator();
		if (!SBFeatures.CRYPT_FOUNDATION.get().place(new NoneFeatureConfiguration(), level, chunkGen, level.getRandom(), BlockPos.ZERO)) return;

		Structure crypt = level.registryAccess().registryOrThrow(Registries.STRUCTURE).getHolder(SBStructures.CRYPT).orElseThrow().value();
		StructureStart start = crypt.generate(level.registryAccess(), chunkGen, chunkGen.getBiomeSource(), level.getChunkSource().randomState(), level.getStructureManager(), level.getRandom().nextInt(1000000000), new ChunkPos(0, 0), 0, level, biome -> true);
		if (!start.isValid()) return;

		BoundingBox boundingBox = start.getBoundingBox();
		ChunkPos chunkMin = new ChunkPos(SectionPos.blockToSectionCoord(boundingBox.minX()), SectionPos.blockToSectionCoord(boundingBox.minZ()));
		ChunkPos chunkMax = new ChunkPos(SectionPos.blockToSectionCoord(boundingBox.maxX()), SectionPos.blockToSectionCoord(boundingBox.maxZ()));

		ChunkPos.rangeClosed(chunkMin, chunkMax).forEach(chunk -> start.placeInChunk(level, level.structureManager(), chunkGen, level.getRandom(), new BoundingBox(chunk.getMinBlockX(), level.getMinBuildHeight(), chunk.getMinBlockZ(), chunk.getMaxBlockX(), level.getMaxBuildHeight(), chunk.getMaxBlockZ()), chunkMin));

		Collection<Entity> entities = new ArrayList<>();
		level.getAllEntities().forEach(entity -> {
			if (entity instanceof ItemEntity) {
				entities.add(entity);
			}
		});
		for (Entity entity : entities) {
			entity.kill();
		}
	}

	public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
		double d0 = pos.getX() + random.nextDouble();
		double d1 = pos.getY() + 0.8D;
		double d2 = pos.getZ() + random.nextDouble();
		level.addParticle(ParticleTypes.WHITE_ASH, d0, d1, d2, 0.0D, 0.0D, 0.0D);
	}
}
