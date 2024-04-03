package net.invictusslayer.slayersbeasts.forge.block;

import net.invictusslayer.slayersbeasts.common.data.tag.SBTags;
import net.invictusslayer.slayersbeasts.common.world.dimension.SBDimensions;
import net.invictusslayer.slayersbeasts.forge.init.SBForgeBlocks;
import net.invictusslayer.slayersbeasts.forge.world.SBPortalManager;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.Cancelable;

public class SepulchraPortalBlock extends Block {
	public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
	protected static final VoxelShape X_AXIS = Block.box(0, 0, 6, 16, 16, 10);
	protected static final VoxelShape Z_AXIS = Block.box(6, 0, 0, 10, 16, 16);

	public SepulchraPortalBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(AXIS, Direction.Axis.X));
	}

	@SuppressWarnings("deprecation")
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return state.getValue(AXIS) == Direction.Axis.Z ? Z_AXIS : X_AXIS;
	}

	public boolean trySpawnPortal(LevelAccessor level, BlockPos pos) {
		SepulchraPortalBlock.Size size = this.isPortal(level, pos);
		if (size != null && !onTrySpawnPortal(level, pos)) {
			size.placePortalBlocks();
			return true;
		} else {
			return false;
		}
	}

	public static boolean onTrySpawnPortal(LevelAccessor level, BlockPos pos) {
		return MinecraftForge.EVENT_BUS.post(new PortalSpawnEvent(level, pos, level.getBlockState(pos)));
	}

	@Cancelable
	public static class PortalSpawnEvent extends BlockEvent {
		public PortalSpawnEvent(LevelAccessor level, BlockPos pos, BlockState state) {
			super(level, pos, state);
		}
	}

	public SepulchraPortalBlock.Size isPortal(LevelAccessor level, BlockPos pos) {
		SepulchraPortalBlock.Size size = new Size(level, pos, Direction.Axis.X);
		if (size.isValid() && size.portalBlockCount == 0) {
			return size;
		} else {
			SepulchraPortalBlock.Size size1 = new Size(level, pos, Direction.Axis.Z);
			return size1.isValid() && size1.portalBlockCount == 0 ? size1 : null;
		}
	}

	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
		Direction.Axis axis = facing.getAxis();
		Direction.Axis axis1 = state.getValue(AXIS);
		boolean flag = axis1 != axis && axis.isHorizontal();
		return !flag && facingState.getBlock() != this && !new Size(level, currentPos, axis1).validatePortal() ? Blocks.AIR.defaultBlockState() : super.updateShape(state, facing, facingState, level, currentPos, facingPos);
	}

	@SuppressWarnings("deprecation")
	public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
		if (entity.canChangeDimensions()) {
			if (entity.isOnPortalCooldown()) {
				entity.setPortalCooldown();
			} else {
				if (!entity.level.isClientSide && !pos.equals(entity.portalEntrancePos)) {
					entity.portalEntrancePos = pos.immutable();
				}
				Level entityWorld = entity.level;
				MinecraftServer minecraftserver = entityWorld.getServer();
				ResourceKey<Level> destination = entity.level.dimension() == SBDimensions.SEPULCHRA ? Level.OVERWORLD : SBDimensions.SEPULCHRA;
				if (minecraftserver != null) {
					ServerLevel destinationWorld = minecraftserver.getLevel(destination);
					if (destinationWorld != null && minecraftserver.isNetherEnabled() && !entity.isPassenger()) {
						entity.level.getProfiler().push("sepulchra_portal");
						entity.setPortalCooldown();
						entity.changeDimension(destinationWorld, new SBPortalManager(destinationWorld));
						entity.level.getProfiler().pop();
					}
				}
			}
		}
	}

	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
		if (random.nextInt(100) == 0) {
			level.playLocalSound((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D,
					(double)pos.getZ() + 0.5D, SoundEvents.PORTAL_AMBIENT,
					SoundSource.BLOCKS, 0.5F, random.nextFloat() * 0.4F + 0.8F, false);
		}
	}

    @SuppressWarnings("deprecation")
	public BlockState rotate(BlockState state, Rotation rot) {
		return switch (rot) {
			case COUNTERCLOCKWISE_90, CLOCKWISE_90 -> switch (state.getValue(AXIS)) {
				case Z -> state.setValue(AXIS, Direction.Axis.X);
				case X -> state.setValue(AXIS, Direction.Axis.Z);
				default -> state;
			};
			default -> state;
		};
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(AXIS);
	}

	public static class Size {
		private final LevelAccessor level;
		private final Direction.Axis axis;
		private final Direction rightDir;
		private final Direction leftDir;
		private int portalBlockCount;
		private BlockPos bottomLeft;
		private int height;
		private int width;

		public Size(LevelAccessor level, BlockPos pos, Direction.Axis axis) {
			this.level = level;
			this.axis = axis;
			if (axis == Direction.Axis.X) {
				this.leftDir = Direction.EAST;
				this.rightDir = Direction.WEST;
			} else {
				this.leftDir = Direction.NORTH;
				this.rightDir = Direction.SOUTH;
			}

			for (BlockPos blockpos = pos; pos.getY() > blockpos.getY() - 21 && pos.getY() > 0 && this.canConnect(level.getBlockState(pos.below())); pos = pos.below()) {
			}

			int i = this.getDistanceUntilEdge(pos, this.leftDir) - 1;
			if (i >= 0) {
				this.bottomLeft = pos.relative(this.leftDir, i);
				this.width = this.getDistanceUntilEdge(this.bottomLeft, this.rightDir);
				if (this.width < 2 || this.width > 21) {
					this.bottomLeft = null;
					this.width = 0;
				}
			}

			if (this.bottomLeft != null) {
				this.height = this.calculatePortalHeight();
			}

		}

		protected int getDistanceUntilEdge(BlockPos pos, Direction directionIn) {
			int i;
			for (i = 0; i < 22; ++i) {
				BlockPos blockpos = pos.relative(directionIn, i);
				if (!this.canConnect(this.level.getBlockState(blockpos)) ||
						!(this.level.getBlockState(blockpos.below()).is(SBTags.Blocks.SEPULCHRA_PORTAL_FRAME))) {
					break;
				}
			}

			BlockPos framePos = pos.relative(directionIn, i);
			return this.level.getBlockState(framePos).is(SBTags.Blocks.SEPULCHRA_PORTAL_FRAME) ? i : 0;
		}

		protected int calculatePortalHeight() {
			loop:
			for (this.height = 0; this.height < 21; ++this.height) {
				for (int i = 0; i < this.width; ++i) {
					assert this.bottomLeft != null;
					BlockPos blockpos = this.bottomLeft.relative(this.rightDir, i).above(this.height);
					BlockState blockstate = this.level.getBlockState(blockpos);
					if (!this.canConnect(blockstate)) {
						break loop;
					}

					Block block = blockstate.getBlock();
					if (block == SBForgeBlocks.SEPULCHRA_PORTAL.get()) {
						++this.portalBlockCount;
					}

					if (i == 0) {
						BlockPos framePos = blockpos.relative(this.leftDir);
						if (!(this.level.getBlockState(framePos).is(SBTags.Blocks.SEPULCHRA_PORTAL_FRAME))) {
							break loop;
						}
					} else if (i == this.width - 1) {
						BlockPos framePos = blockpos.relative(this.rightDir);
						if (!(this.level.getBlockState(framePos).is(SBTags.Blocks.SEPULCHRA_PORTAL_FRAME))) {
							break loop;
						}
					}
				}
			}

			for (int j = 0; j < this.width; ++j) {
				BlockPos framePos = this.bottomLeft.relative(this.rightDir, j).above(this.height);
				if (!(this.level.getBlockState(framePos).is(SBTags.Blocks.SEPULCHRA_PORTAL_FRAME))) {
					this.height = 0;
					break;
				}
			}

			if (this.height <= 21 && this.height >= 3) {
				return this.height;
			} else {
				this.bottomLeft = null;
				this.width = 0;
				this.height = 0;
				return 0;
			}
		}

		protected boolean canConnect(BlockState pos) {
			Block block = pos.getBlock();
			return pos.isAir() || block == SBForgeBlocks.SEPULCHRA_PORTAL.get();
		}

		public boolean isValid() {
			return this.bottomLeft != null && this.width >= 2 && this.width <= 21 && this.height >= 3 && this.height <= 21;
		}

		public void placePortalBlocks() {
			for (int i = 0; i < this.width; ++i) {
				assert this.bottomLeft != null;
				BlockPos blockpos = this.bottomLeft.relative(this.rightDir, i);

				for (int j = 0; j < this.height; ++j) {
					this.level.setBlock(blockpos.above(j), SBForgeBlocks.SEPULCHRA_PORTAL.get().defaultBlockState().setValue(SepulchraPortalBlock.AXIS, this.axis), 18);
				}
			}

		}

		private boolean isPortalCountValidForSize() {
			return this.portalBlockCount >= this.width * this.height;
		}

		public boolean validatePortal() {
			return this.isValid() && this.isPortalCountValidForSize();
		}
	}
}
