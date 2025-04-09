package net.invictusslayer.slayersbeasts.block;

import net.invictusslayer.slayersbeasts.init.SBBlocks;
import net.invictusslayer.slayersbeasts.init.SBFeatures;
import net.invictusslayer.slayersbeasts.world.dimension.SBDimensions;
import net.invictusslayer.slayersbeasts.world.structure.SBStructures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.SectionPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Relative;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Portal;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.portal.TeleportTransition;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class CryptPortalBlock extends Block implements Portal {
	private static final VoxelShape SHAPE = Block.box(0.0D, 6.0D, 0.0D, 16.0D, 12.0D, 16.0D);
	private static final BlockPos CRYPT_SPAWN_POINT = new BlockPos(3, 61, 3);

	public CryptPortalBlock(Properties properties) {
		super(properties);
	}

	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

	public BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess access, BlockPos currentPos, Direction facing, BlockPos facingPos, BlockState facingState, RandomSource random) {
		List<BlockPos> posList = List.of(currentPos.north(), currentPos.east(), currentPos.south(), currentPos.west());
		for (BlockPos pos : posList) {
			Block block = level.getBlockState(pos).getBlock();
			if (block != this && block != SBBlocks.INFUSED_CRYPTALITH.get() && block != SBBlocks.DEPLETED_CRYPTALITH.get()) {
				return Blocks.AIR.defaultBlockState();
			}
		}

		return super.updateShape(state, level, access, currentPos, facing, facingPos, facingState, random);
	}

	protected ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state, boolean flag) {
		return ItemStack.EMPTY;
	}

	public boolean canBeReplaced(BlockState state, Fluid fluid) {
		return false;
	}

	public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
		if (entity instanceof ServerPlayer player && player.canUsePortal(false)) player.setAsInsidePortal(this, pos);
	}

	private void resetCrypt(ServerLevel level) {
		ChunkGenerator chunkGen = level.getChunkSource().getGenerator();
		if (!SBFeatures.CRYPT_FOUNDATION.get().place(new NoneFeatureConfiguration(), level, chunkGen, level.getRandom(), BlockPos.ZERO)) return;

		Holder<Structure> crypt = level.registryAccess().lookupOrThrow(Registries.STRUCTURE).get(SBStructures.CRYPT).orElseThrow();
		StructureStart start = crypt.value().generate(crypt, SBDimensions.CRYPT, level.registryAccess(), chunkGen, chunkGen.getBiomeSource(), level.getChunkSource().randomState(), level.getStructureManager(), level.getRandom().nextInt(1000000000), new ChunkPos(0, 0), 0, level, biome -> true);
		if (!start.isValid()) return;

		BoundingBox boundingBox = start.getBoundingBox();
		ChunkPos chunkMin = new ChunkPos(SectionPos.blockToSectionCoord(boundingBox.minX()), SectionPos.blockToSectionCoord(boundingBox.minZ()));
		ChunkPos chunkMax = new ChunkPos(SectionPos.blockToSectionCoord(boundingBox.maxX()), SectionPos.blockToSectionCoord(boundingBox.maxZ()));

		ChunkPos.rangeClosed(chunkMin, chunkMax).forEach(chunk -> start.placeInChunk(level, level.structureManager(), chunkGen, level.getRandom(), new BoundingBox(chunk.getMinBlockX(), level.getMinY(), chunk.getMinBlockZ(), chunk.getMaxBlockX(), level.getMaxY(), chunk.getMaxBlockZ()), chunkMin));

		Collection<Entity> entities = new ArrayList<>();
		level.getAllEntities().forEach(entity -> {
			if (entity instanceof ItemEntity) {
				entities.add(entity);
			}
		});
		for (Entity entity : entities) {
			entity.kill(level);
		}
	}

	public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
		double d0 = pos.getX() + random.nextDouble();
		double d1 = pos.getY() + 0.8D;
		double d2 = pos.getZ() + random.nextDouble();
		level.addParticle(ParticleTypes.WHITE_ASH, d0, d1, d2, 0.0D, 0.0D, 0.0D);
	}

	public TeleportTransition getPortalDestination(ServerLevel level, Entity entity, BlockPos blockPos) {
		ResourceKey<Level> destination = entity.level().dimension() == SBDimensions.CRYPT ? Level.OVERWORLD : SBDimensions.CRYPT;
		ServerLevel serverLevel = level.getServer().getLevel(destination);
		if (serverLevel == null) return null;

		boolean flag = destination == SBDimensions.CRYPT;
		BlockPos pos = flag ? CRYPT_SPAWN_POINT : serverLevel.getSharedSpawnPos();
		Vec3 vec3 = pos.getBottomCenter();
		if (flag) {
			if (serverLevel.players().isEmpty()) resetCrypt(serverLevel);
			return new TeleportTransition(serverLevel, vec3, Vec3.ZERO, Direction.WEST.toYRot(), 0.0F, Relative.union(Relative.DELTA, Set.of(Relative.X_ROT)), TeleportTransition.PLAY_PORTAL_SOUND.then(TeleportTransition.PLACE_PORTAL_TICKET));
		}

		if (entity instanceof ServerPlayer serverPlayer) return serverPlayer.findRespawnPositionAndUseSpawnBlock(false, TeleportTransition.DO_NOTHING);
		return new TeleportTransition(serverLevel, vec3, Vec3.ZERO, 0.0F, 0.0F, Relative.union(Relative.DELTA, Relative.ROTATION), TeleportTransition.PLAY_PORTAL_SOUND.then(TeleportTransition.PLACE_PORTAL_TICKET));
	}
}
