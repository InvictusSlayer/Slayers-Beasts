package net.invictusslayer.slayersbeasts.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Fallable;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class IcicleBlock extends Block implements Fallable, SimpleWaterloggedBlock {
    public static final DirectionProperty TIP_DIRECTION = BlockStateProperties.VERTICAL_DIRECTION;
    public static final EnumProperty<DripstoneThickness> THICKNESS = BlockStateProperties.DRIPSTONE_THICKNESS;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private static final VoxelShape TIP_MERGE_SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 16.0D, 11.0D);
    private static final VoxelShape TIP_SHAPE_UP = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D);
    private static final VoxelShape TIP_SHAPE_DOWN = Block.box(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D);
    private static final VoxelShape FRUSTUM_SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);
    private static final VoxelShape MIDDLE_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D);
    private static final VoxelShape BASE_SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    private static final VoxelShape DRIP_THROUGH_SPACE = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 16.0D, 10.0D);

    public IcicleBlock(Properties pProperties) {
        super(pProperties);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(TIP_DIRECTION, THICKNESS, WATERLOGGED);
    }

    @SuppressWarnings("deprecation")
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        return isValidIciclePlacement(pLevel, pPos, pState.getValue(TIP_DIRECTION));
    }

    @SuppressWarnings("deprecation")
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pPos, BlockPos pNeighborPos) {
        if (pState.getValue(WATERLOGGED)) {
            pLevel.scheduleTick(pPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }

        if (pDirection != Direction.UP && pDirection != Direction.DOWN) {
            return pState;
        } else {
            Direction direction = pState.getValue(TIP_DIRECTION);
            if (direction == Direction.DOWN && pLevel.getBlockTicks().hasScheduledTick(pPos, this)) {
                return pState;
            } else if (pDirection == direction.getOpposite() && !this.canSurvive(pState, pLevel, pPos)) {
                if (direction == Direction.DOWN) {
                    pLevel.scheduleTick(pPos, this, 2);
                } else {
                    pLevel.scheduleTick(pPos, this, 1);
                }

                return pState;
            } else {
                boolean flag = pState.getValue(THICKNESS) == DripstoneThickness.TIP_MERGE;
                DripstoneThickness dripstonethickness = calculateIcicleThickness(pLevel, pPos, direction, flag);
                return pState.setValue(THICKNESS, dripstonethickness);
            }
        }
    }

    @SuppressWarnings("deprecation")
    public void onProjectileHit(Level pLevel, BlockState pState, BlockHitResult pHit, Projectile pProjectile) {
        BlockPos blockpos = pHit.getBlockPos();
        if (!pLevel.isClientSide && pProjectile.mayInteract(pLevel, blockpos) && pProjectile instanceof ThrownTrident && pProjectile.getDeltaMovement().length() > 0.6D) {
            pLevel.destroyBlock(blockpos, true);
        }
    }

    public void fallOn(Level pLevel, BlockState pState, BlockPos pPos, Entity pEntity, float pFallDistance) {
        if (pState.getValue(TIP_DIRECTION) == Direction.UP && pState.getValue(THICKNESS) == DripstoneThickness.TIP) {
            pEntity.causeFallDamage(pFallDistance + 2.0F, 2.0F, pLevel.damageSources().stalagmite());
        } else {
            super.fallOn(pLevel, pState, pPos, pEntity, pFallDistance);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if (canDrip(pState)) {
            float f = pRandom.nextFloat();
            if (f < 0.12F) {
                getFluidAboveStalactite(pLevel, pPos, pState).filter(
                        info -> f < 0.02F || info.fluid == Fluids.WATER).ifPresent(
                                info -> spawnDripParticle(pLevel, pPos, pState));
            }
        }
    }

    @SuppressWarnings("deprecation")
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (isStalagmite(pState) && !this.canSurvive(pState, pLevel, pPos)) {
            pLevel.destroyBlock(pPos, true);
        } else {
            spawnFallingStalactite(pState, pLevel, pPos);
        }

    }

    @SuppressWarnings("deprecation")
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pRandom.nextFloat() < 0.011377778F && isStalactiteStartPos(pState, pLevel, pPos)) {
            growStalactiteOrStalagmiteIfPossible(pState, pLevel, pPos, pRandom);
        }
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        LevelAccessor levelaccessor = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        Direction direction = pContext.getNearestLookingVerticalDirection().getOpposite();
        Direction direction1 = calculateTipDirection(levelaccessor, blockpos, direction);
        if (direction1 == null) {
            return null;
        } else {
            boolean flag = !pContext.isSecondaryUseActive();
            DripstoneThickness dripstonethickness = calculateIcicleThickness(levelaccessor, blockpos, direction1, flag);
            return dripstonethickness == null ? null : this.defaultBlockState().setValue(TIP_DIRECTION, direction1).setValue(THICKNESS, dripstonethickness).setValue(WATERLOGGED, levelaccessor.getFluidState(blockpos).getType() == Fluids.WATER);
        }
    }

    @SuppressWarnings("deprecation")
    public FluidState getFluidState(BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @SuppressWarnings("deprecation")
    public VoxelShape getOcclusionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return Shapes.empty();
    }

    @SuppressWarnings("deprecation")
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        DripstoneThickness dripstonethickness = pState.getValue(THICKNESS);
        VoxelShape voxelshape;
        if (dripstonethickness == DripstoneThickness.TIP_MERGE) {
            voxelshape = TIP_MERGE_SHAPE;
        } else if (dripstonethickness == DripstoneThickness.TIP) {
            if (pState.getValue(TIP_DIRECTION) == Direction.DOWN) {
                voxelshape = TIP_SHAPE_DOWN;
            } else {
                voxelshape = TIP_SHAPE_UP;
            }
        } else if (dripstonethickness == DripstoneThickness.FRUSTUM) {
            voxelshape = FRUSTUM_SHAPE;
        } else if (dripstonethickness == DripstoneThickness.MIDDLE) {
            voxelshape = MIDDLE_SHAPE;
        } else {
            voxelshape = BASE_SHAPE;
        }

        Vec3 vec3 = pState.getOffset(pLevel, pPos);
        return voxelshape.move(vec3.x, 0.0D, vec3.z);
    }

    @SuppressWarnings("deprecation")
    public boolean isCollisionShapeFullBlock(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return false;
    }

    public float getMaxHorizontalOffset() {
        return 0.125F;
    }

    public void onBrokenAfterFall(Level pLevel, BlockPos pPos, FallingBlockEntity pFallingBlock) {
        if (!pFallingBlock.isSilent()) {
            pLevel.levelEvent(1045, pPos, 0);
        }
    }

    public DamageSource getFallDamageSource(Entity pEntity) {
        return pEntity.damageSources().fallingStalactite(pEntity);
    }

    private static void spawnFallingStalactite(BlockState pState, ServerLevel pLevel, BlockPos pPos) {
        BlockPos.MutableBlockPos mutableBlockPos = pPos.mutable();

        for (BlockState blockState = pState; isStalactite(blockState); blockState = pLevel.getBlockState(mutableBlockPos)) {
            FallingBlockEntity fallingBlock = FallingBlockEntity.fall(pLevel, mutableBlockPos, blockState);
            fallingBlock.disableDrop();
            if (isTip(blockState, true)) {
                fallingBlock.setHurtsEntities(Math.max(1 + pPos.getY() - mutableBlockPos.getY(), 6), 40);
                break;
            }

            mutableBlockPos.move(Direction.DOWN);
        }
    }

    public static void growStalactiteOrStalagmiteIfPossible(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        BlockState blockState = pLevel.getBlockState(pPos.above(1));
        BlockState blockState1 = pLevel.getBlockState(pPos.above(2));
        if (canGrow(blockState, blockState1)) {
            BlockPos blockpos = findTip(pState, pLevel, pPos);
            if (blockpos != null) {
                BlockState blockState2 = pLevel.getBlockState(blockpos);
                if (canDrip(blockState2) && canTipGrow(blockState2, pLevel, blockpos)) {
                    if (pRandom.nextBoolean()) {
                        grow(pLevel, blockpos, Direction.DOWN);
                    } else {
                        growStalagmiteBelow(pLevel, blockpos);
                    }
                }
            }
        }
    }

    private static void growStalagmiteBelow(ServerLevel pLevel, BlockPos pPos) {
        BlockPos.MutableBlockPos blockpos$mutableblockpos = pPos.mutable();

        for(int i = 0; i < 10; ++i) {
            blockpos$mutableblockpos.move(Direction.DOWN);
            BlockState blockstate = pLevel.getBlockState(blockpos$mutableblockpos);
            if (!blockstate.getFluidState().isEmpty()) {
                return;
            }

            if (isUnmergedTipWithDirection(blockstate, Direction.UP) && canTipGrow(blockstate, pLevel, blockpos$mutableblockpos)) {
                grow(pLevel, blockpos$mutableblockpos, Direction.UP);
                return;
            }

            if (isValidIciclePlacement(pLevel, blockpos$mutableblockpos, Direction.UP) && !pLevel.isWaterAt(blockpos$mutableblockpos.below())) {
                grow(pLevel, blockpos$mutableblockpos.below(), Direction.UP);
                return;
            }

            if (!canDripThrough(pLevel, blockpos$mutableblockpos, blockstate)) {
                return;
            }
        }

    }

    private static void grow(ServerLevel pServer, BlockPos pPos, Direction pDirection) {
        BlockPos blockpos = pPos.relative(pDirection);
        BlockState blockstate = pServer.getBlockState(blockpos);
        if (isUnmergedTipWithDirection(blockstate, pDirection.getOpposite())) {
            createMergedTips(blockstate, pServer, blockpos);
        } else if (blockstate.isAir() || blockstate.is(Blocks.WATER)) {
            createIcicle(pServer, blockpos, pDirection, DripstoneThickness.TIP);
        }

    }

    private static void createIcicle(LevelAccessor pLevel, BlockPos pPos, Direction pDirection, DripstoneThickness pThickness) {
        BlockState blockstate = SBBlocks.ICICLE.get().defaultBlockState().setValue(TIP_DIRECTION, pDirection).setValue(THICKNESS, pThickness).setValue(WATERLOGGED, pLevel.getFluidState(pPos).getType() == Fluids.WATER);
        pLevel.setBlock(pPos, blockstate, 3);
    }

    private static void createMergedTips(BlockState pState, LevelAccessor pLevel, BlockPos pPos) {
        BlockPos blockPos;
        BlockPos blockPos1;
        if (pState.getValue(TIP_DIRECTION) == Direction.UP) {
            blockPos1 = pPos;
            blockPos = pPos.above();
        } else {
            blockPos = pPos;
            blockPos1 = pPos.below();
        }

        createIcicle(pLevel, blockPos, Direction.DOWN, DripstoneThickness.TIP_MERGE);
        createIcicle(pLevel, blockPos1, Direction.UP, DripstoneThickness.TIP_MERGE);
    }

    private static void spawnDripParticle(Level pLevel, BlockPos pPos, BlockState pState) {
        Vec3 vec3 = pState.getOffset(pLevel, pPos);
        double d1 = (double) pPos.getX() + 0.5D + vec3.x;
        double d2 = (double) ((float) (pPos.getY() + 1) - 0.6875F) - 0.0625D;
        double d3 = (double) pPos.getZ() + 0.5D + vec3.z;
        pLevel.addParticle(ParticleTypes.DRIPPING_DRIPSTONE_WATER, d1, d2, d3, 0.0D, 0.0D, 0.0D);
    }

    @Nullable
    private static BlockPos findTip(BlockState pState, LevelAccessor pLevel, BlockPos pPos) {
        if (isTip(pState, false)) {
            return pPos;
        } else {
            Direction direction = pState.getValue(TIP_DIRECTION);
            BiPredicate<BlockPos, BlockState> biPredicate = (pos, state) -> state.is(SBBlocks.ICICLE.get()) && state.getValue(TIP_DIRECTION) == direction;
            return findBlockVertical(pLevel, pPos, direction.getAxisDirection(), biPredicate, state -> isTip(state, false), 7).orElse(null);
        }
    }

    @Nullable
    private static Direction calculateTipDirection(LevelReader pLevel, BlockPos pPos, Direction pDir) {
        Direction direction;
        if (isValidIciclePlacement(pLevel, pPos, pDir)) {
            direction = pDir;
        } else {
            if (!isValidIciclePlacement(pLevel, pPos, pDir.getOpposite())) {
                return null;
            }
            direction = pDir.getOpposite();
        }

        return direction;
    }

    private static DripstoneThickness calculateIcicleThickness(LevelReader pLevel, BlockPos pPos, Direction pDir, boolean pIsTipMerge) {
        Direction direction = pDir.getOpposite();
        BlockState blockstate = pLevel.getBlockState(pPos.relative(pDir));
        if (isIcicleWithDirection(blockstate, direction)) {
            return !pIsTipMerge && blockstate.getValue(THICKNESS) != DripstoneThickness.TIP_MERGE ? DripstoneThickness.TIP : DripstoneThickness.TIP_MERGE;
        } else if (!isIcicleWithDirection(blockstate, pDir)) {
            return DripstoneThickness.TIP;
        } else {
            DripstoneThickness thickness = blockstate.getValue(THICKNESS);
            if (thickness != DripstoneThickness.TIP && thickness != DripstoneThickness.TIP_MERGE) {
                BlockState blockstate1 = pLevel.getBlockState(pPos.relative(direction));
                return !isIcicleWithDirection(blockstate1, pDir) ? DripstoneThickness.BASE : DripstoneThickness.MIDDLE;
            } else {
                return DripstoneThickness.FRUSTUM;
            }
        }
    }

    public static boolean canDrip(BlockState state) {
        return isStalactite(state) && state.getValue(THICKNESS) == DripstoneThickness.TIP && !state.getValue(WATERLOGGED);
    }

    private static boolean canTipGrow(BlockState pState, ServerLevel pLevel, BlockPos pPos) {
        Direction direction = pState.getValue(TIP_DIRECTION);
        BlockPos blockpos = pPos.relative(direction);
        BlockState blockstate = pLevel.getBlockState(blockpos);
        if (!blockstate.getFluidState().isEmpty()) {
            return false;
        } else {
            return blockstate.isAir() || isUnmergedTipWithDirection(blockstate, direction.getOpposite());
        }
    }

    private static Optional<BlockPos> findRootBlock(Level pLevel, BlockPos pPos, BlockState pState) {
        Direction direction = pState.getValue(TIP_DIRECTION);
        BiPredicate<BlockPos, BlockState> biPredicate = (pos, state) -> state.is(SBBlocks.ICICLE.get()) && state.getValue(TIP_DIRECTION) == direction;
        return findBlockVertical(pLevel, pPos, direction.getOpposite().getAxisDirection(), biPredicate, (state) -> !state.is(SBBlocks.ICICLE.get()), 11);
    }

    private static boolean isValidIciclePlacement(LevelReader pLevel, BlockPos pPos, Direction pDir) {
        BlockPos blockpos = pPos.relative(pDir.getOpposite());
        BlockState blockstate = pLevel.getBlockState(blockpos);
        return blockstate.isFaceSturdy(pLevel, blockpos, pDir) || isIcicleWithDirection(blockstate, pDir);
    }

    private static boolean isTip(BlockState pState, boolean pIsTipMerge) {
        if (!pState.is(SBBlocks.ICICLE.get())) {
            return false;
        } else {
            DripstoneThickness thickness = pState.getValue(THICKNESS);
            return thickness == DripstoneThickness.TIP || pIsTipMerge && thickness == DripstoneThickness.TIP_MERGE;
        }
    }

    private static boolean isUnmergedTipWithDirection(BlockState pState, Direction pDir) {
        return isTip(pState, false) && pState.getValue(TIP_DIRECTION) == pDir;
    }

    private static boolean isStalactite(BlockState pState) {
        return isIcicleWithDirection(pState, Direction.DOWN);
    }

    private static boolean isStalagmite(BlockState pState) {
        return isIcicleWithDirection(pState, Direction.UP);
    }

    private static boolean isStalactiteStartPos(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        return isStalactite(pState) && !pLevel.getBlockState(pPos.above()).is(SBBlocks.ICICLE.get());
    }

    @SuppressWarnings("deprecation")
    public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
        return false;
    }

    private static boolean isIcicleWithDirection(BlockState pState, Direction pDir) {
        return pState.is(SBBlocks.ICICLE.get()) && pState.getValue(TIP_DIRECTION) == pDir;
    }

    private static Optional<IcicleBlock.FluidInfo> getFluidAboveStalactite(Level pLevel, BlockPos pPos, BlockState pState) {
        return !isStalactite(pState) ? Optional.empty() : findRootBlock(pLevel, pPos, pState).map(pos -> {
            BlockPos blockpos = pos.above();
            BlockState blockstate = pLevel.getBlockState(blockpos);
            Fluid fluid = pLevel.getFluidState(blockpos).getType();

            return new IcicleBlock.FluidInfo(blockpos, fluid, blockstate);
        });
    }

    private static boolean canGrow(BlockState pIcicleState, BlockState pState) {
        return pIcicleState.is(SBBlocks.ICICLE.get()) && pState.is(Blocks.WATER) && pState.getFluidState().isSource();
    }

    private static Optional<BlockPos> findBlockVertical(LevelAccessor pLevel, BlockPos pPos, Direction.AxisDirection pAxis, BiPredicate<BlockPos, BlockState> pPositionalStatePredicate, Predicate<BlockState> pStatePredicate, int pMaxIterations) {
        Direction direction = Direction.get(pAxis, Direction.Axis.Y);
        BlockPos.MutableBlockPos blockpos$mutableblockpos = pPos.mutable();

        for(int i = 1; i < pMaxIterations; ++i) {
            blockpos$mutableblockpos.move(direction);
            BlockState blockstate = pLevel.getBlockState(blockpos$mutableblockpos);
            if (pStatePredicate.test(blockstate)) {
                return Optional.of(blockpos$mutableblockpos.immutable());
            }

            if (pLevel.isOutsideBuildHeight(blockpos$mutableblockpos.getY()) || !pPositionalStatePredicate.test(blockpos$mutableblockpos, blockstate)) {
                return Optional.empty();
            }
        }

        return Optional.empty();
    }

    private static boolean canDripThrough(BlockGetter pLevel, BlockPos pPos, BlockState pState) {
        if (pState.isAir()) {
            return true;
        } else if (pState.isSolidRender(pLevel, pPos)) {
            return false;
        } else if (!pState.getFluidState().isEmpty()) {
            return false;
        } else {
            return !Shapes.joinIsNotEmpty(DRIP_THROUGH_SPACE, pState.getCollisionShape(pLevel, pPos), BooleanOp.AND);
        }
    }

    record FluidInfo(BlockPos pos, Fluid fluid, BlockState sourceState) {}
}
