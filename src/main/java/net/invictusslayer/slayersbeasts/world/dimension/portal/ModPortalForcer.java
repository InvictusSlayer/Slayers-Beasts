package net.invictusslayer.slayersbeasts.world.dimension.portal;

import net.invictusslayer.slayersbeasts.block.ModBlocks;
import net.invictusslayer.slayersbeasts.block.SepulchraPortalBlock;
import net.invictusslayer.slayersbeasts.util.ModPOIs;
import net.invictusslayer.slayersbeasts.world.dimension.ModDimensions;
import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.TicketType;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiRecord;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.portal.PortalInfo;
import net.minecraft.world.level.portal.PortalShape;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.ITeleporter;

import javax.annotation.Nullable;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Function;

public class ModPortalForcer implements ITeleporter {
    private final ServerLevel level;

    public ModPortalForcer(ServerLevel level) {
        this.level = level;
    }

    @Nullable
    @Override
    public PortalInfo getPortalInfo(Entity entity, ServerLevel destLevel, Function<ServerLevel, PortalInfo> defaultPortalInfo) {
        boolean isSepulchra = destLevel.dimension() == ModDimensions.SEPULCHRA_KEY;
        if (entity.level.dimension() != ModDimensions.SEPULCHRA_KEY && !isSepulchra) return null;
        else {
            WorldBorder worldBorder = destLevel.getWorldBorder();
            double scale = DimensionType.getTeleportationScale(entity.level.dimensionType(), destLevel.dimensionType());
            BlockPos blockPos = worldBorder.clampToBounds(entity.getX() * scale, entity.getY(), entity.getZ() * scale);
            return this.getPortal(entity, blockPos, worldBorder).map((result) -> {
                BlockState blockstate = entity.level.getBlockState(entity.portalEntrancePos);
                Direction.Axis axis;
                Vec3 vec3;
                if (blockstate.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)) {
                    axis = blockstate.getValue(BlockStateProperties.HORIZONTAL_AXIS);
                    BlockUtil.FoundRectangle rectangle = BlockUtil.getLargestRectangleAround(entity.portalEntrancePos, axis, 21, Direction.Axis.Y, 21, (pos) -> entity.level.getBlockState(pos) == blockstate);
                    vec3 = PortalShape.getRelativePosition(rectangle, axis, entity.position(), entity.getDimensions(entity.getPose()));
                } else {
                    axis = Direction.Axis.X;
                    vec3 = new Vec3(0.5D, 0.0D, 0.0D);
                }

                return PortalShape.createPortalInfo(destLevel, result, axis, vec3, entity, entity.getDeltaMovement(), entity.getYRot(), entity.getXRot());
            }).orElse(null);
        }
    }

    private Optional<BlockUtil.FoundRectangle> getPortal(Entity entity, BlockPos pos, WorldBorder worldBorder) {
        Optional<BlockUtil.FoundRectangle> portal = this.locatePortal(pos, worldBorder);
        if (entity instanceof ServerPlayer) {
            if (portal.isPresent()) {
                return portal;
            } else {
                Direction.Axis portalAxis = this.level.getBlockState(entity.portalEntrancePos).getOptionalValue(SepulchraPortalBlock.AXIS).orElse(Direction.Axis.X);
                return this.createPortal(pos, portalAxis);
            }
        } else {
            return this.locatePortal(pos, worldBorder);
        }
    }

    private Optional<BlockUtil.FoundRectangle> locatePortal(BlockPos pos, WorldBorder worldBorder) {
        PoiManager poiManager = this.level.getPoiManager();
        poiManager.ensureLoadedAndValid(this.level, pos, 128);
        System.out.println(ModPOIs.SEPULCHRA_PORTAL.getKey());
        Optional<PoiRecord> optional = poiManager
                .getInSquare((poi) -> poi.is(ModPOIs.SEPULCHRA_PORTAL.getKey()), pos, 128, PoiManager.Occupancy.ANY)
                .filter((poi) -> worldBorder.isWithinBounds(poi.getPos()))
                .sorted(Comparator.<PoiRecord>comparingDouble((poi) -> poi.getPos().distSqr(pos)).thenComparingInt((poi) -> poi.getPos().getY()))
                .filter((poi) -> this.level.getBlockState(poi.getPos()).hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
                .findFirst();
        return optional.map((poi) -> {
            BlockPos blockpos = poi.getPos();
            this.level.getChunkSource().addRegionTicket(TicketType.PORTAL, new ChunkPos(blockpos), 3, blockpos);
            BlockState blockstate = this.level.getBlockState(blockpos);
            return BlockUtil.getLargestRectangleAround(blockpos, blockstate.getValue(BlockStateProperties.HORIZONTAL_AXIS),
                    21, Direction.Axis.Y, 21, (posIn) -> this.level.getBlockState(posIn) == blockstate);
        });
    }

    public Optional<BlockUtil.FoundRectangle> createPortal(BlockPos pos, Direction.Axis axis) {
        Direction direction = Direction.get(Direction.AxisDirection.POSITIVE, axis);
        double d0 = -1.0D;
        BlockPos blockpos = null;
        double d1 = -1.0D;
        BlockPos blockpos1 = null;
        WorldBorder worldborder = this.level.getWorldBorder();
        int dimensionLogicalHeight = this.level.getHeight() - 1;
        BlockPos.MutableBlockPos mutablePos = pos.mutable();

        for(BlockPos.MutableBlockPos mutableBlockPos : BlockPos.spiralAround(pos, 16, Direction.EAST, Direction.SOUTH)) {
            int j = Math.min(dimensionLogicalHeight, this.level.getHeight(Heightmap.Types.MOTION_BLOCKING, mutableBlockPos.getX(), mutableBlockPos.getZ()));
            if (worldborder.isWithinBounds(mutableBlockPos) && worldborder.isWithinBounds(mutableBlockPos.move(direction, 1))) {
                mutableBlockPos.move(direction.getOpposite(), 1);

                for(int l = j; l >= 0; --l) {
                    mutableBlockPos.setY(l);
                    if (this.level.isEmptyBlock(mutableBlockPos)) {
                        int i1;
                        for(i1 = l; l > 0 && this.level.isEmptyBlock(mutableBlockPos.move(Direction.DOWN)); --l) {
                        }

                        if (l + 4 <= dimensionLogicalHeight) {
                            int j1 = i1 - l;
                            if (j1 <= 0 || j1 >= 3) {
                                mutableBlockPos.setY(l);
                                if (this.checkRegionForPlacement(mutableBlockPos, mutablePos, direction, 0)) {
                                    double d2 = pos.distSqr(mutableBlockPos);
                                    if (this.checkRegionForPlacement(mutableBlockPos, mutablePos, direction, -1) && this.checkRegionForPlacement(mutableBlockPos, mutablePos, direction, 1) && (d0 == -1.0D || d0 > d2)) {
                                        d0 = d2;
                                        blockpos = mutableBlockPos.immutable();
                                    }

                                    if (d0 == -1.0D && (d1 == -1.0D || d1 > d2)) {
                                        d1 = d2;
                                        blockpos1 = mutableBlockPos.immutable();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (d0 == -1.0D && d1 != -1.0D) {
            blockpos = blockpos1;
            d0 = d1;
        }

        if (d0 == -1.0D) {
            blockpos = (new BlockPos(pos.getX(), Mth.clamp(pos.getY(), 70, this.level.getHeight() - 10), pos.getZ())).immutable();
            Direction direction1 = direction.getClockWise();
            if (!worldborder.isWithinBounds(blockpos)) {
                return Optional.empty();
            }

            for(int l1 = -1; l1 < 2; ++l1) {
                for(int k2 = 0; k2 < 2; ++k2) {
                    for(int i3 = -1; i3 < 3; ++i3) {
                        BlockState blockState = i3 < 0 ? ModBlocks.JADE_BLOCK.get().defaultBlockState() : Blocks.AIR.defaultBlockState();
                        mutablePos.setWithOffset(blockpos, k2 * direction.getStepX() + l1 * direction1.getStepX(), i3, k2 * direction.getStepZ() + l1 * direction1.getStepZ());
                        this.level.setBlockAndUpdate(mutablePos, blockState);
                    }
                }
            }
        }

        for(int k1 = -1; k1 < 3; ++k1) {
            for(int i2 = -1; i2 < 4; ++i2) {
                if (k1 == -1 || k1 == 2 || i2 == -1 || i2 == 3) {
                    mutablePos.setWithOffset(blockpos, k1 * direction.getStepX(), i2, k1 * direction.getStepZ());
                    this.level.setBlock(mutablePos, ModBlocks.JADE_BLOCK.get().defaultBlockState(), 3);
                }
            }
        }

        BlockState portal = ModBlocks.SEPULCHRA_PORTAL.get().defaultBlockState().setValue(SepulchraPortalBlock.AXIS, axis);

        for(int j2 = 0; j2 < 2; ++j2) {
            for(int l2 = 0; l2 < 3; ++l2) {
                mutablePos.setWithOffset(blockpos, j2 * direction.getStepX(), l2, j2 * direction.getStepZ());
                this.level.setBlock(mutablePos, portal, 18);
            }
        }

        return Optional.of(new BlockUtil.FoundRectangle(blockpos.immutable(), 2, 3));
    }

    private boolean checkRegionForPlacement(BlockPos originalPos, BlockPos.MutableBlockPos offsetPos, Direction directionIn, int offsetScale) {
        Direction direction = directionIn.getClockWise();

        for(int i = -1; i < 3; ++i) {
            for(int j = -1; j < 4; ++j) {
                offsetPos.setWithOffset(originalPos, directionIn.getStepX() * i + direction.getStepX() * offsetScale, j, directionIn.getStepZ() * i + direction.getStepZ() * offsetScale);
                if (j < 0 && !this.level.getBlockState(offsetPos).getMaterial().isSolid()) {
                    return false;
                }

                if (j >= 0 && !this.level.isEmptyBlock(offsetPos)) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public boolean playTeleportSound(ServerPlayer player, ServerLevel sourceWorld, ServerLevel destWorld) {
        return false;
    }
}
