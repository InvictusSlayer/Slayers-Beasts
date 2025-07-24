package net.invictusslayer.slayersbeasts.block;

import net.invictusslayer.slayersbeasts.init.SBBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Fallable;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DripstoneThickness;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ObsidianSpikeBlock extends Block implements Fallable, SimpleWaterloggedBlock {
	public static final EnumProperty<Direction> TIP_DIRECTION = BlockStateProperties.VERTICAL_DIRECTION;
	public static final EnumProperty<DripstoneThickness> THICKNESS = BlockStateProperties.DRIPSTONE_THICKNESS;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	private static final VoxelShape TIP_MERGE_SHAPE = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 16.0D, 10.0D);
	private static final VoxelShape TIP_SHAPE_UP = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 8.0D, 10.0D);
	private static final VoxelShape TIP_SHAPE_DOWN = Block.box(6.0D, 8.0D, 6.0D, 10.0D, 16.0D, 10.0D);
	private static final VoxelShape FRUSTUM_SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);
	private static final VoxelShape MIDDLE_SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);
	private static final VoxelShape BASE_SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);

	public ObsidianSpikeBlock(Properties properties) {
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

	public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
		if (state.getValue(TIP_DIRECTION) == Direction.UP && state.getValue(THICKNESS) == DripstoneThickness.TIP) {
			entity.causeFallDamage(fallDistance + 2.0F, 2.0F, level.damageSources().stalagmite());
		} else {
			super.fallOn(level, state, pos, entity, fallDistance);
		}
	}

	public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		if (isSpikeWithDirection(state, Direction.UP) && !canSurvive(state, level, pos)) {
			level.destroyBlock(pos, true);
		} else {
			spawnFallingStalactite(state, level, pos);
		}
	}

	public BlockState getStateForPlacement(BlockPlaceContext context) {
		LevelAccessor level = context.getLevel();
		BlockPos pos = context.getClickedPos();
		Direction direction = context.getNearestLookingVerticalDirection().getOpposite();
		Direction tipDirection = calculateTipDirection(level, pos, direction);
		if (tipDirection == null) return null;

		DripstoneThickness thickness = calculateThickness(level, pos, tipDirection, !context.isSecondaryUseActive());
		return thickness == null ? null : defaultBlockState().setValue(TIP_DIRECTION, tipDirection).setValue(THICKNESS, thickness).setValue(WATERLOGGED, level.getFluidState(pos).getType() == Fluids.WATER);
	}

	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	protected VoxelShape getOcclusionShape(BlockState state) {
		return Shapes.empty();
	}

	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
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

	public void onBrokenAfterFall(Level level, BlockPos pos, FallingBlockEntity fallingBlock) {
		if (!fallingBlock.isSilent()) {
			level.levelEvent(1045, pos, 0);
		}
	}

	public DamageSource getFallDamageSource(Entity entity) {
		return entity.damageSources().fallingStalactite(entity);
	}

	private static void spawnFallingStalactite(BlockState state, ServerLevel level, BlockPos pos) {
		BlockPos.MutableBlockPos mutableBlockPos = pos.mutable();

		for (BlockState blockState = state; isSpikeWithDirection(blockState, Direction.DOWN); blockState = level.getBlockState(mutableBlockPos)) {
			FallingBlockEntity fallingBlock = FallingBlockEntity.fall(level, mutableBlockPos, blockState);
			fallingBlock.disableDrop();
			if (isTip(blockState, true)) {
				fallingBlock.setHurtsEntities(Math.max(1 + pos.getY() - mutableBlockPos.getY(), 6), 40);
				break;
			}

			mutableBlockPos.move(Direction.DOWN);
		}
	}

	private static Direction calculateTipDirection(LevelReader level, BlockPos pos, Direction direction) {
		if (isValidPlacement(level, pos, direction)) return direction;
		if (!isValidPlacement(level, pos, direction.getOpposite())) return null;
		return direction.getOpposite();
	}

	private static DripstoneThickness calculateThickness(LevelReader level, BlockPos pos, Direction direction, boolean isMerged) {
		Direction opposite = direction.getOpposite();
		BlockState state = level.getBlockState(pos.relative(direction));
		if (isSpikeWithDirection(state, opposite)) {
			return !isMerged && state.getValue(THICKNESS) != DripstoneThickness.TIP_MERGE ? DripstoneThickness.TIP : DripstoneThickness.TIP_MERGE;
		} else if (!isSpikeWithDirection(state, direction)) {
			return DripstoneThickness.TIP;
		} else {
			DripstoneThickness thickness = state.getValue(THICKNESS);
			if (thickness != DripstoneThickness.TIP && thickness != DripstoneThickness.TIP_MERGE) {
				BlockState blockState = level.getBlockState(pos.relative(opposite));
				return !isSpikeWithDirection(blockState, direction) ? DripstoneThickness.BASE : DripstoneThickness.MIDDLE;
			}
			return DripstoneThickness.FRUSTUM;
		}
	}

	private static boolean isValidPlacement(LevelReader level, BlockPos pos, Direction direction) {
		BlockPos blockPos = pos.relative(direction.getOpposite());
		BlockState state = level.getBlockState(blockPos);
		return state.isFaceSturdy(level, blockPos, direction) || isSpikeWithDirection(state, direction);
	}

	private static boolean isTip(BlockState state, boolean isMerged) {
		if (!state.is(SBBlocks.OBSIDIAN_SPIKE.get())) return false;

		DripstoneThickness thickness = state.getValue(THICKNESS);
		return thickness == DripstoneThickness.TIP || (isMerged && thickness == DripstoneThickness.TIP_MERGE);
	}

	public boolean isPathfindable(BlockState state, PathComputationType type) {
		return false;
	}

	private static boolean isSpikeWithDirection(BlockState state, Direction direction) {
		return state.is(SBBlocks.OBSIDIAN_SPIKE.get()) && state.getValue(TIP_DIRECTION) == direction;
	}
}
