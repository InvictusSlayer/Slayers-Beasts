package net.invictusslayer.slayersbeasts.block;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.invictusslayer.slayersbeasts.world.dimension.SBDimensions;
import net.invictusslayer.slayersbeasts.world.structure.SBStructures;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Set;

public class CryptPortalBlock extends Block {
    protected static final VoxelShape SHAPE = Block.box(0.0D, 6.0D, 0.0D, 16.0D, 12.0D, 16.0D);

    public CryptPortalBlock(Properties properties) {
        super(properties);
    }

    @SuppressWarnings("deprecation")
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @SuppressWarnings("deprecation")
    public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
        return ItemStack.EMPTY;
    }

    @SuppressWarnings("deprecation")
    public boolean canBeReplaced(BlockState pState, Fluid pFluid) {
        return false;
    }

    @SuppressWarnings("deprecation")
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (entity instanceof ServerPlayer player && player.canChangeDimensions()) {
            if (player.isOnPortalCooldown()) {
                player.setPortalCooldown();
            } else {
                BlockPos spawn = player.getRespawnPosition();
                if (spawn == null) spawn = level.getSharedSpawnPos();
                if (!player.level().isClientSide && !pos.equals(player.portalEntrancePos)) {
                    player.portalEntrancePos = pos.immutable();
                }

                MinecraftServer server = level.getServer();
                if (server == null) return;

                ResourceKey<Level> destination = player.level().dimension() == SBDimensions.CRYPT_KEY ? Level.OVERWORLD : SBDimensions.CRYPT_KEY;
                ServerLevel serverLevel = server.getLevel(destination);
                if (serverLevel == null) return;

                if (destination == SBDimensions.CRYPT_KEY) {
                    serverLevel.getChunkSource().clearCache();
                    ChunkGenerator chunkGen = serverLevel.getChunkSource().getGenerator();
                    Structure crypt = serverLevel.registryAccess().registryOrThrow(Registries.STRUCTURE).getHolder(SBStructures.CRYPT).orElseThrow().get();
                    StructureStart structureStart = crypt.generate(serverLevel.registryAccess(), chunkGen, chunkGen.getBiomeSource(), serverLevel.getChunkSource().randomState(), serverLevel.getStructureManager(), serverLevel.getRandom().nextInt(1000000000), new ChunkPos(0, 0), 0, serverLevel, biome -> true);
                    if (!structureStart.isValid()) return;

                    BoundingBox boundingBox = structureStart.getBoundingBox();
                    ChunkPos chunkPos = new ChunkPos(SectionPos.blockToSectionCoord(boundingBox.minX()), SectionPos.blockToSectionCoord(boundingBox.minZ()));
                    ChunkPos chunkPos1 = new ChunkPos(SectionPos.blockToSectionCoord(boundingBox.maxX()), SectionPos.blockToSectionCoord(boundingBox.maxZ()));
                    serverLevel.getChunkSource().getChunk(0, 0, true);
                    try {
                        checkLoaded(serverLevel, chunkPos, chunkPos1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    ChunkPos.rangeClosed(chunkPos, chunkPos1).forEach(chunk -> structureStart.placeInChunk(serverLevel, serverLevel.structureManager(), chunkGen, serverLevel.getRandom(), new BoundingBox(chunk.getMinBlockX(), serverLevel.getMinBuildHeight(), chunk.getMinBlockZ(), chunk.getMaxBlockX(), serverLevel.getMaxBuildHeight(), chunk.getMaxBlockZ()), chunkPos));
                    player.teleportTo(serverLevel, 0, 70, 0, Set.of(), player.getYRot(), player.getXRot());
                    server.saveAllChunks(false, false, true);
                } else {
                    player.teleportTo(serverLevel, spawn.getX(), spawn.getY(), spawn.getZ(), Set.of(), player.getYRot(), player.getXRot());

                    emptyCrypt(server.getLevel(SBDimensions.CRYPT_KEY));
//                    server.getLevel(SBDimensions.CRYPT_KEY).getChunkSource().clearCache();
//                    try {
//                        deleteCrypt(server);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
                }
                player.setPortalCooldown();
            }
        }
    }

    private void emptyCrypt(ServerLevel serverLevel) {
        ServerChunkCache chunkCache = serverLevel.getChunkSource();

        for (int i1 = -10; i1 <= 10; ++i1) {
            for (int j1 = -10; j1 <= 10; ++j1) {
                ChunkPos chunkPos = new ChunkPos(j1, i1);
                LevelChunk levelchunk = chunkCache.getChunk(j1, i1, false);
                if (levelchunk != null) {
                    for (BlockPos blockpos : BlockPos.betweenClosed(chunkPos.getMinBlockX(), serverLevel.getMinBuildHeight(), chunkPos.getMinBlockZ(), chunkPos.getMaxBlockX(), serverLevel.getMaxBuildHeight() - 1, chunkPos.getMaxBlockZ())) {
                        serverLevel.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 16);
                    }
                }
            }
        }
    }

//    private void deleteCrypt(MinecraftServer server) throws IOException { TODO: Fix Crypt reset system
//        LevelStorageSource.LevelStorageAccess access = server.storageSource;
//        Path path = access.getDimensionPath(SBDimensions.CRYPT_KEY);
//        LogUtils.getLogger().info("Deleting crypt...");
//
//        Files.walkFileTree(path, new SimpleFileVisitor<>() {
//            public FileVisitResult visitFile(Path path1, BasicFileAttributes attributes) throws IOException {
//                if (!path1.toFile().getName().equals("capabilities.dat") && !path1.toFile().getName().equals("raids.dat")) {
//                    LogUtils.getLogger().debug("Deleting {}", path1);
//                    Files.delete(path1);
//                }
//
//                return FileVisitResult.CONTINUE;
//            }
//        });
//    }

//    private void resetChunks(ServerLevel serverLevel, int pRange) {
//        ServerChunkCache chunkCache = serverLevel.getChunkSource();
//        chunkCache.chunkMap.debugReloadGenerator();
//        ChunkPos chunkPos = new ChunkPos(0, 0);
//        int i = -pRange;
//        int k = -pRange;
//
//        for (int i1 = i; i1 <= pRange; ++i1) {
//            for (int j1 = k; j1 <= pRange; ++j1) {
//                ChunkPos chunkPos1 = new ChunkPos(j1, i1);
//                LevelChunk chunk = chunkCache.getChunk(j1, i1, false);
//                if (chunk != null) {
//                    for (BlockPos blockpos : BlockPos.betweenClosed(chunkPos1.getMinBlockX(), serverLevel.getMinBuildHeight(), chunkPos1.getMinBlockZ(), chunkPos1.getMaxBlockX(), serverLevel.getMaxBuildHeight() - 1, chunkPos1.getMaxBlockZ())) {
//                        serverLevel.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 16);
//                    }
//                }
//            }
//        }
//
//        ProcessorMailbox<Runnable> mailbox = ProcessorMailbox.create(Util.backgroundExecutor(), "worldgen-resetchunks");
//
//        for(ChunkStatus status : ImmutableList.of(ChunkStatus.BIOMES, ChunkStatus.NOISE, ChunkStatus.SURFACE, ChunkStatus.CARVERS, ChunkStatus.FEATURES, ChunkStatus.INITIALIZE_LIGHT)) {
//            long k1 = System.currentTimeMillis();
//            CompletableFuture<Unit> completable = CompletableFuture.supplyAsync(() -> Unit.INSTANCE, mailbox::tell);
//
//            for (int i2 = chunkPos.z - pRange; i2 <= chunkPos.z + pRange; ++i2) {
//                for (int j2 = chunkPos.x - pRange; j2 <= chunkPos.x + pRange; ++j2) {
//                    ChunkPos chunkPos1 = new ChunkPos(j2, i2);
//                    LevelChunk chunk = chunkCache.getChunk(j2, i2, false);
//                    if (chunk != null) {
//                        List<ChunkAccess> list = Lists.newArrayList();
//                        int k2 = Math.max(1, status.getRange());
//
//                        for (int l2 = chunkPos1.z - k2; l2 <= chunkPos1.z + k2; ++l2) {
//                            for (int i3 = chunkPos1.x - k2; i3 <= chunkPos1.x + k2; ++i3) {
//                                ChunkAccess access = chunkCache.getChunk(i3, l2, status.getParent(), true);
//                                ChunkAccess access1;
//                                if (access instanceof ImposterProtoChunk) {
//                                    access1 = new ImposterProtoChunk(((ImposterProtoChunk) access).getWrapped(), true);
//                                } else if (access instanceof LevelChunk) {
//                                    access1 = new ImposterProtoChunk((LevelChunk) access, true);
//                                } else {
//                                    access1 = access;
//                                }
//
//                                list.add(access1);
//                            }
//                        }
//
//                        completable = completable.thenComposeAsync(unit -> status.generate(mailbox::tell, serverLevel,
//                                chunkCache.getGenerator(), serverLevel.getStructureManager(), chunkCache.getLightEngine(), access -> {
//                            throw new UnsupportedOperationException("Not creating full chunks here");
//                        }, list).thenApply(loadingFailureEither -> {
//                            if (status == ChunkStatus.NOISE) {
//                                loadingFailureEither.left().ifPresent(access -> Heightmap.primeHeightmaps(access, ChunkStatus.POST_FEATURES));
//                            }
//
//                            return Unit.INSTANCE;
//                        }), mailbox::tell);
//                    }
//                }
//            }
//
//            serverLevel.getServer().managedBlock(completable::isDone);
//            LogUtils.getLogger().debug(status + " took " + (System.currentTimeMillis() - k1) + " ms");
//        }
//
//        long l3 = System.currentTimeMillis();
//
//        for(int i4 = chunkPos.z - pRange; i4 <= chunkPos.z + pRange; ++i4) {
//            for(int l1 = chunkPos.x - pRange; l1 <= chunkPos.x + pRange; ++l1) {
//                ChunkPos chunkPos1 = new ChunkPos(l1, i4);
//                LevelChunk chunk = chunkCache.getChunk(l1, i4, false);
//                if (chunk != null) {
//                    for(BlockPos blockpos1 : BlockPos.betweenClosed(chunkPos1.getMinBlockX(), serverLevel.getMinBuildHeight(), chunkPos1.getMinBlockZ(), chunkPos1.getMaxBlockX(), serverLevel.getMaxBuildHeight() - 1, chunkPos1.getMaxBlockZ())) {
//                        chunkCache.blockChanged(blockpos1);
//                    }
//                }
//            }
//        }
//
//        LogUtils.getLogger().debug("blockChanged took " + (System.currentTimeMillis() - l3) + " ms");
//    }

    private static void checkLoaded(ServerLevel level, ChunkPos start, ChunkPos end) throws CommandSyntaxException {
        if (ChunkPos.rangeClosed(start, end).anyMatch(chunkPos -> !level.isLoaded(chunkPos.getWorldPosition()))) {
            throw BlockPosArgument.ERROR_NOT_LOADED.create();
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        double d0 = pos.getX() + random.nextDouble();
        double d1 = pos.getY() + 0.8D;
        double d2 = pos.getZ() + random.nextDouble();
        level.addParticle(ParticleTypes.WHITE_ASH, d0, d1, d2, 0.0D, 0.0D, 0.0D);
    }
}
