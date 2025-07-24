package net.invictusslayer.slayersbeasts.block;

import net.invictusslayer.slayersbeasts.init.SBBlocks;
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
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Fallable;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DripstoneThickness;
import net.minecraft.world.level.block.state.properties.EnumProperty;
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

import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class IcicleBlock extends Block implements Fallable, SimpleWaterloggedBlock {
	public static final EnumProperty<Direction> TIP_DIRECTION = BlockStateProperties.VERTICAL_DIRECTION;
	public static final EnumProperty<DripstoneThickness> THICKNESS = BlockStateProperties.DRIPSTONE_THICKNESS;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	private static final VoxelShape TIP_MERGE_SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 16.0D, 11.0D);
	private static final VoxelShape TIP_SHAPE_UP = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D);
	private static final VoxelShape TIP_SHAPE_DOWN = Block.box(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D);
	private static final VoxelShape FRUSTUM_SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);
	private static final VoxelShape MIDDLE_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D);
	private static final VoxelShape BASE_SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
	private static final VoxelShape DRIP_THROUGH_SPACE = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 16.0D, 10.0D);

	public IcicleBlock(Properties properties) {
		super(properties);
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(TIP_DIRECTION, THICKNESS, WATERLOGGED);
	}

	public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
		return isValidPlacement(level, pos, state.getValue(TIP_DIRECTION));
	}

	public BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess access, BlockPos currentPos, Direction facing, BlockPos facingPos, BlockState facingState, RandomSource random) {
		if (state.getValue(WATERLOGGED)) {
			access.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
		}

		if (facing != Direction.UP && facing != Direction.DOWN) return state;

		Direction tipDirection = state.getValue(TIP_DIRECTION);
		if (tipDirection == Direction.DOWN && access.getBlockTicks().hasScheduledTick(currentPos, this)) {
			return state;
		} else if (facing == tipDirection.getOpposite() && !canSurvive(state, level, currentPos)) {
			if (tipDirection == Direction.DOWN) {
				access.scheduleTick(currentPos, this, 2);
			} else {
				access.scheduleTick(currentPos, this, 1);
			}
			return state;
		}

		DripstoneThickness thickness = calculateThickness(level, currentPos, tipDirection, state.getValue(THICKNESS) == DripstoneThickness.TIP_MERGE);
		return state.setValue(THICKNESS, thickness);
	}

	public void onProjectileHit(Level level, BlockState state, BlockHitResult hit, Projectile projectile) {
		if (!(level instanceof ServerLevel serverLevel)) return;

		BlockPos pos = hit.getBlockPos();
		if (!level.isClientSide && projectile.mayInteract(serverLevel, pos) && projectile instanceof ThrownTrident && projectile.getDeltaMovement().length() > 0.6D) {
			level.destroyBlock(pos, true);
		}
	}

	public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
		if (state.getValue(TIP_DIRECTION) == Direction.UP && state.getValue(THICKNESS) == DripstoneThickness.TIP) {
			entity.causeFallDamage(fallDistance + 2.0F, 2.0F, level.damageSources().stalagmite());
		} else {
			super.fallOn(level, state, pos, entity, fallDistance);
		}
	}

	public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		if (isIcicleWithDirection(state, Direction.UP) && !canSurvive(state, level, pos)) {
			level.destroyBlock(pos, true);
		} else {
			spawnFallingStalactite(state, level, pos);
		}
	}

	public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		if (random.nextFloat() < 0.0114F && isStalactiteStartPos(state, level, pos)) {
			growStalactiteOrStalagmiteIfPossible(state, level, pos, random);
		}
	}

	public BlockState getStateForPlacement(BlockPlaceContext context) {
		LevelAccessor level = context.getLevel();
		BlockPos clickedPos = context.getClickedPos();
		Direction opposite = context.getNearestLookingVerticalDirection().getOpposite();
		Direction direction = calculateTipDirection(level, clickedPos, opposite);
		if (direction == null) return null;

		boolean flag = !context.isSecondaryUseActive();
		DripstoneThickness thickness = calculateThickness(level, clickedPos, direction, flag);
		return thickness == null ? null : this.defaultBlockState().setValue(TIP_DIRECTION, direction).setValue(THICKNESS, thickness).setValue(WATERLOGGED, level.getFluidState(clickedPos).getType() == Fluids.WATER);
	}

	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	protected VoxelShape getOcclusionShape(BlockState state) {
		return Shapes.empty();
	}

	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		DripstoneThickness thickness = state.getValue(THICKNESS);
		VoxelShape shape;
		if (thickness == DripstoneThickness.TIP_MERGE) {
			shape = TIP_MERGE_SHAPE;
		} else if (thickness == DripstoneThickness.TIP) {
			if (state.getValue(TIP_DIRECTION) == Direction.DOWN) {
				shape = TIP_SHAPE_DOWN;
			} else {
				shape = TIP_SHAPE_UP;
			}
		} else if (thickness == DripstoneThickness.FRUSTUM) {
			shape = FRUSTUM_SHAPE;
		} else if (thickness == DripstoneThickness.MIDDLE) {
			shape = MIDDLE_SHAPE;
		} else {
			shape = BASE_SHAPE;
		}

		Vec3 vec3 = state.getOffset(pos);
		return shape.move(vec3.x, 0.0D, vec3.z);
	}

	public boolean isCollisionShapeFullBlock(BlockState state, BlockGetter level, BlockPos pos) {
		return false;
	}

	public float getMaxHorizontalOffset() {
		return 0.125F;
	}

	public void onBrokenAfterFall(Level level, BlockPos pPos, FallingBlockEntity fallingBlock) {
		if (!fallingBlock.isSilent()) {
			level.levelEvent(1045, pPos, 0);
		}
	}

	public DamageSource getFallDamageSource(Entity entity) {
		return entity.damageSources().fallingStalactite(entity);
	}

	private static void spawnFallingStalactite(BlockState state, ServerLevel level, BlockPos pos) {
		BlockPos.MutableBlockPos mutableBlockPos = pos.mutable();

		for (BlockState blockState = state; isIcicleWithDirection(blockState, Direction.DOWN); blockState = level.getBlockState(mutableBlockPos)) {
			FallingBlockEntity fallingBlock = FallingBlockEntity.fall(level, mutableBlockPos, blockState);
			fallingBlock.disableDrop();
			if (isTip(blockState, true)) {
				fallingBlock.setHurtsEntities(Math.max(1 + pos.getY() - mutableBlockPos.getY(), 6), 40);
				break;
			}

			mutableBlockPos.move(Direction.DOWN);
		}
	}

	public static void growStalactiteOrStalagmiteIfPossible(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		BlockState aboveState = level.getBlockState(pos.above(1));
		BlockState fluidState = level.getBlockState(pos.above(2));
		if (canGrow(aboveState, fluidState)) {
			BlockPos blockPos = findTip(state, level, pos);
			if (blockPos != null) {
				BlockState tipState = level.getBlockState(blockPos);
				if (canDrip(tipState) && canTipGrow(tipState, level, blockPos)) {
					if (random.nextBoolean()) {
						grow(level, blockPos, Direction.DOWN);
					} else {
						growStalagmiteBelow(level, blockPos);
					}
				}
			}
		}
	}

	private static void growStalagmiteBelow(ServerLevel level, BlockPos pos) {
		BlockPos.MutableBlockPos mutableBlockPos = pos.mutable();

		for (int i = 0; i < 10; ++i) {
			mutableBlockPos.move(Direction.DOWN);
			BlockState state = level.getBlockState(mutableBlockPos);
			if (!state.getFluidState().isEmpty()) break;

			if (isUnmergedTipWithDirection(state, Direction.UP) && canTipGrow(state, level, mutableBlockPos)) {
				grow(level, mutableBlockPos, Direction.UP);
				break;
			}
			if (isValidPlacement(level, mutableBlockPos, Direction.UP) && !level.isWaterAt(mutableBlockPos.below())) {
				grow(level, mutableBlockPos.below(), Direction.UP);
				break;
			}
			if (!canDripThrough(level, mutableBlockPos, state)) {
				break;
			}
		}
	}

	private static void grow(ServerLevel level, BlockPos pos, Direction direction) {
		BlockPos blockPos = pos.relative(direction);
		BlockState state = level.getBlockState(blockPos);
		if (isUnmergedTipWithDirection(state, direction.getOpposite())) {
			createMergedTips(state, level, blockPos);
		} else if (state.isAir() || state.is(Blocks.WATER)) {
			createIcicle(level, blockPos, direction, DripstoneThickness.TIP);
		}
	}

	private static void createIcicle(LevelAccessor level, BlockPos pos, Direction direction, DripstoneThickness thickness) {
		BlockState state = SBBlocks.ICICLE.get().defaultBlockState().setValue(TIP_DIRECTION, direction).setValue(THICKNESS, thickness).setValue(WATERLOGGED, level.getFluidState(pos).getType() == Fluids.WATER);
		level.setBlock(pos, state, 3);
	}

	private static void createMergedTips(BlockState state, LevelAccessor level, BlockPos pos) {
		BlockPos top;
		BlockPos bottom;
		if (state.getValue(TIP_DIRECTION) == Direction.UP) {
			bottom = pos;
			top = pos.above();
		} else {
			top = pos;
			bottom = pos.below();
		}

		createIcicle(level, top, Direction.DOWN, DripstoneThickness.TIP_MERGE);
		createIcicle(level, bottom, Direction.UP, DripstoneThickness.TIP_MERGE);
	}

	private static BlockPos findTip(BlockState state, LevelAccessor level, BlockPos pos) {
		if (isTip(state, false)) return pos;
		Direction direction = state.getValue(TIP_DIRECTION);
		BiPredicate<BlockPos, BlockState> biPredicate = (blockPos, blockState) -> blockState.is(SBBlocks.ICICLE.get()) && blockState.getValue(TIP_DIRECTION) == direction;
		return findBlockVertical(level, pos, direction.getAxisDirection(), biPredicate, blockState -> isTip(blockState, false), 7).orElse(null);
	}

	private static Direction calculateTipDirection(LevelReader level, BlockPos pos, Direction direction) {
		if (isValidPlacement(level, pos, direction)) return direction;
		if (!isValidPlacement(level, pos, direction.getOpposite())) return null;
		return direction.getOpposite();
	}

	private static DripstoneThickness calculateThickness(LevelReader level, BlockPos pos, Direction direction, boolean isMerged) {
		Direction opposite = direction.getOpposite();
		BlockState blockState = level.getBlockState(pos.relative(direction));
		if (isIcicleWithDirection(blockState, opposite)) {
			return !isMerged && blockState.getValue(THICKNESS) != DripstoneThickness.TIP_MERGE ? DripstoneThickness.TIP : DripstoneThickness.TIP_MERGE;
		} else if (!isIcicleWithDirection(blockState, direction)) {
			return DripstoneThickness.TIP;
		} else {
			DripstoneThickness thickness = blockState.getValue(THICKNESS);
			if (thickness != DripstoneThickness.TIP && thickness != DripstoneThickness.TIP_MERGE) {
				BlockState state = level.getBlockState(pos.relative(opposite));
				return !isIcicleWithDirection(state, direction) ? DripstoneThickness.BASE : DripstoneThickness.MIDDLE;
			}
			return DripstoneThickness.FRUSTUM;
		}
	}

	public static boolean canDrip(BlockState state) {
		return isIcicleWithDirection(state, Direction.DOWN) && state.getValue(THICKNESS) == DripstoneThickness.TIP && !state.getValue(WATERLOGGED);
	}

	private static boolean canTipGrow(BlockState state, ServerLevel level, BlockPos pos) {
		Direction direction = state.getValue(TIP_DIRECTION);
		BlockPos blockPos = pos.relative(direction);
		BlockState blockState = level.getBlockState(blockPos);
		if (!blockState.getFluidState().isEmpty()) return false;

		return blockState.isAir() || isUnmergedTipWithDirection(blockState, direction.getOpposite());
	}

	private static Optional<BlockPos> findRootBlock(Level level, BlockPos pos, BlockState state) {
		Direction direction = state.getValue(TIP_DIRECTION);
		BiPredicate<BlockPos, BlockState> biPredicate = (blockPos, blockState) -> blockState.is(SBBlocks.ICICLE.get()) && blockState.getValue(TIP_DIRECTION) == direction;
		return findBlockVertical(level, pos, direction.getOpposite().getAxisDirection(), biPredicate, blockState -> !blockState.is(SBBlocks.ICICLE.get()), 11);
	}

	private static boolean isValidPlacement(LevelReader level, BlockPos pos, Direction direction) {
		BlockPos blockPos = pos.relative(direction.getOpposite());
		BlockState state = level.getBlockState(blockPos);
		return state.isFaceSturdy(level, blockPos, direction) || isIcicleWithDirection(state, direction);
	}

	private static boolean isTip(BlockState state, boolean isMerged) {
		if (!state.is(SBBlocks.ICICLE.get())) return false;
		DripstoneThickness thickness = state.getValue(THICKNESS);
		return thickness == DripstoneThickness.TIP || isMerged && thickness == DripstoneThickness.TIP_MERGE;
	}

	private static boolean isUnmergedTipWithDirection(BlockState state, Direction direction) {
		return isTip(state, false) && state.getValue(TIP_DIRECTION) == direction;
	}

	private static boolean isStalactiteStartPos(BlockState state, LevelReader level, BlockPos pos) {
		return isIcicleWithDirection(state, Direction.DOWN) && !level.getBlockState(pos.above()).is(SBBlocks.ICICLE.get());
	}

	public boolean isPathfindable(BlockState state, PathComputationType type) {
		return false;
	}

	private static boolean isIcicleWithDirection(BlockState state, Direction direction) {
		return state.is(SBBlocks.ICICLE.get()) && state.getValue(TIP_DIRECTION) == direction;
	}

	private static Optional<IcicleBlock.FluidInfo> getFluidAboveStalactite(Level level, BlockPos pos, BlockState state) {
		return !isIcicleWithDirection(state, Direction.DOWN) ? Optional.empty() : findRootBlock(level, pos, state).map(blockPos -> {
			BlockPos above = blockPos.above();
			BlockState blockState = level.getBlockState(above);
			Fluid fluid = level.getFluidState(above).getType();

			return new IcicleBlock.FluidInfo(above, fluid, blockState);
		});
	}

	private static boolean canGrow(BlockState icicleState, BlockState state) {
		return icicleState.is(SBBlocks.ICICLE.get()) && state.is(Blocks.WATER) && state.getFluidState().isSource();
	}

	private static Optional<BlockPos> findBlockVertical(LevelAccessor level, BlockPos pos, Direction.AxisDirection axis, BiPredicate<BlockPos, BlockState> biPredicate, Predicate<BlockState> predicate, int maxIterations) {
		Direction direction = Direction.get(axis, Direction.Axis.Y);
		BlockPos.MutableBlockPos mutableBlockPos = pos.mutable();

		for(int i = 1; i < maxIterations; ++i) {
			mutableBlockPos.move(direction);
			BlockState blockstate = level.getBlockState(mutableBlockPos);
			if (predicate.test(blockstate)) {
				return Optional.of(mutableBlockPos.immutable());
			}

			if (level.isOutsideBuildHeight(mutableBlockPos.getY()) || !biPredicate.test(mutableBlockPos, blockstate)) {
				return Optional.empty();
			}
		}
		return Optional.empty();
	}

	private static boolean canDripThrough(BlockGetter level, BlockPos pos, BlockState state) {
		if (state.isAir()) {
			return true;
		} else if (state.isSolidRender() || !state.getFluidState().isEmpty()) {
			return false;
		}
		return !Shapes.joinIsNotEmpty(DRIP_THROUGH_SPACE, state.getCollisionShape(level, pos), BooleanOp.AND);
	}

	public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
		if (canDrip(state)) {
			float f = random.nextFloat();
			if (f < 0.12F) {
				getFluidAboveStalactite(level, pos, state).filter(info -> f < 0.02F || info.fluid == Fluids.WATER).ifPresent(info -> spawnDripParticle(level, pos, state));
			}
		}
	}

	private static void spawnDripParticle(Level level, BlockPos pos, BlockState state) {
		Vec3 vec3 = state.getOffset(pos);
		double d1 = (double) pos.getX() + 0.5D + vec3.x;
		double d2 = (double) ((float) (pos.getY() + 1) - 0.6875F) - 0.0625D;
		double d3 = (double) pos.getZ() + 0.5D + vec3.z;
		level.addParticle(ParticleTypes.DRIPPING_DRIPSTONE_WATER, d1, d2, d3, 0.0D, 0.0D, 0.0D);
	}

	record FluidInfo(BlockPos pos, Fluid fluid, BlockState sourceState) {}
}
