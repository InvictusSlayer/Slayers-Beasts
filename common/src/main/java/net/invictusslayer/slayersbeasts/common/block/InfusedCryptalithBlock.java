package net.invictusslayer.slayersbeasts.common.block;

import com.google.common.base.Predicates;
import net.invictusslayer.slayersbeasts.common.init.SBBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.pattern.BlockPatternBuilder;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;

public class InfusedCryptalithBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty ACTIVE = BlockStateProperties.EYE;
	private static BlockPattern portalShape;

	public InfusedCryptalithBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(ACTIVE, false));
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, ACTIVE);
	}

	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(ACTIVE, false);
	}

	public static BlockPattern getOrCreatePortalShape() {
		if (portalShape == null) {
			portalShape = BlockPatternBuilder.start().aisle("?vv?", ">??<", ">??<", "?^^?")
					.where('?', BlockInWorld.hasState(BlockStatePredicate.ANY))
					.where('^', BlockInWorld.hasState(BlockStatePredicate.forBlock(SBBlocks.INFUSED_CRYPTALITH.get())
							.where(ACTIVE, Predicates.equalTo(true)).where(FACING, Predicates.equalTo(Direction.SOUTH))))
					.where('>', BlockInWorld.hasState(BlockStatePredicate.forBlock(SBBlocks.INFUSED_CRYPTALITH.get())
							.where(ACTIVE, Predicates.equalTo(true)).where(FACING, Predicates.equalTo(Direction.WEST))))
					.where('v', BlockInWorld.hasState(BlockStatePredicate.forBlock(SBBlocks.INFUSED_CRYPTALITH.get())
							.where(ACTIVE, Predicates.equalTo(true)).where(FACING, Predicates.equalTo(Direction.NORTH))))
					.where('<', BlockInWorld.hasState(BlockStatePredicate.forBlock(SBBlocks.INFUSED_CRYPTALITH.get())
							.where(ACTIVE, Predicates.equalTo(true)).where(FACING, Predicates.equalTo(Direction.EAST)))).build();
		}

		return portalShape;
	}

	@SuppressWarnings("deprecation")
	public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
		return false;
	}

	public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
		double d0 = pos.getX() + random.nextDouble();
		double d1 = pos.getY() + 0.8D;
		double d2 = pos.getZ() + random.nextDouble();
		level.addParticle(ParticleTypes.WHITE_ASH, d0, d1, d2, 0.0D, 0.0D, 0.0D);
	}
}
