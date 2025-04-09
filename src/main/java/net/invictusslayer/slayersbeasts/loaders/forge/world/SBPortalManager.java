package net.invictusslayer.slayersbeasts.loaders.forge.world;

public class SBPortalManager {//implements ITeleporter {
//	private final ServerLevel level;
//
//	public SBPortalManager(ServerLevel level) {
//		this.level = level;
//	}
//
//	public PortalInfo getPortalInfo(Entity entity, ServerLevel destination, Function<ServerLevel, PortalInfo> portalInfo) {
//		if (entity.level().dimension() != SBDimensions.SEPULCHRA && destination.dimension() != SBDimensions.SEPULCHRA) return null;
//		WorldBorder worldBorder = destination.getWorldBorder();
//		double scale = DimensionType.getTeleportationScale(entity.level().dimensionType(), destination.dimensionType());
//		BlockPos blockPos = worldBorder.clampToBounds(entity.getX() * scale, entity.getY(), entity.getZ() * scale);
//		return this.getPortal(entity, blockPos, worldBorder).map(result -> {
//			BlockState state = entity.level().getBlockState(entity.portalEntrancePos);
//			Direction.Axis axis;
//			Vec3 vec3;
//			if (state.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)) {
//				axis = state.getValue(BlockStateProperties.HORIZONTAL_AXIS);
//				BlockUtil.FoundRectangle rectangle = BlockUtil.getLargestRectangleAround(entity.portalEntrancePos, axis, 21, Direction.Axis.Y, 21, pos -> entity.level().getBlockState(pos) == state);
//				vec3 = PortalShape.getRelativePosition(rectangle, axis, entity.position(), entity.getDimensions(entity.getPose()));
//			} else {
//				axis = Direction.Axis.X;
//				vec3 = new Vec3(0.5D, 0.0D, 0.0D);
//			}
//
//			return PortalShape.createPortalInfo(destination, result, axis, vec3, entity, entity.getDeltaMovement(), entity.getYRot(), entity.getXRot());
//		}).orElse(null);
//	}
//
//	private Optional<BlockUtil.FoundRectangle> getPortal(Entity entity, BlockPos pos, WorldBorder border) {
//		Optional<BlockUtil.FoundRectangle> portal = locatePortal(pos, border);
//		if (entity instanceof ServerPlayer) {
//			if (portal.isPresent()) return portal;
//
//			Direction.Axis portalAxis = level.getBlockState(entity.portalEntrancePos).getOptionalValue(SepulchraPortalBlock.AXIS).orElse(Direction.Axis.X);
//			return createPortal(pos, portalAxis);
//		}
//		return locatePortal(pos, border);
//	}
//
//	private Optional<BlockUtil.FoundRectangle> locatePortal(BlockPos pos, WorldBorder border) {
//		PoiManager poiManager = this.level.getPoiManager();
//		poiManager.ensureLoadedAndValid(this.level, pos, 128);
//		System.out.println(SBForgePois.SEPULCHRA_PORTAL.getKey());
//		Optional<PoiRecord> optional = poiManager.getInSquare(poi ->
//						poi.is(SBForgePois.SEPULCHRA_PORTAL.getKey()), pos, 128, PoiManager.Occupancy.ANY).filter(poi -> border.isWithinBounds(poi.getPos()))
//				.sorted(Comparator.<PoiRecord>comparingDouble(poi -> poi.getPos().distSqr(pos)).thenComparingInt(poi -> poi.getPos().getY()))
//				.filter(poi -> this.level.getBlockState(poi.getPos()).hasProperty(BlockStateProperties.HORIZONTAL_AXIS)).findFirst();
//		return optional.map(poi -> {
//			BlockPos blockpos = poi.getPos();
//			this.level.getChunkSource().addRegionTicket(TicketType.PORTAL, new ChunkPos(blockpos), 3, blockpos);
//			BlockState blockstate = this.level.getBlockState(blockpos);
//			return BlockUtil.getLargestRectangleAround(blockpos, blockstate.getValue(BlockStateProperties.HORIZONTAL_AXIS),
//					21, Direction.Axis.Y, 21, (posIn) -> this.level.getBlockState(posIn) == blockstate);
//		});
//	}
//
//	public Optional<BlockUtil.FoundRectangle> createPortal(BlockPos pos, Direction.Axis axis) {
//		Direction direction = Direction.get(Direction.AxisDirection.POSITIVE, axis);
//		double d0 = -1.0D;
//		BlockPos pos1 = null;
//		double d1 = -1.0D;
//		BlockPos pos2 = null;
//		WorldBorder border = this.level.getWorldBorder();
//		int dimensionLogicalHeight = this.level.getHeight() - 1;
//		BlockPos.MutableBlockPos mutablePos = pos.mutable();
//
//		for (BlockPos.MutableBlockPos mutableBlockPos : BlockPos.spiralAround(pos, 16, Direction.EAST, Direction.SOUTH)) {
//			int j = Math.min(dimensionLogicalHeight, this.level.getHeight(Heightmap.Types.MOTION_BLOCKING, mutableBlockPos.getX(), mutableBlockPos.getZ()));
//			if (border.isWithinBounds(mutableBlockPos) && border.isWithinBounds(mutableBlockPos.move(direction, 1))) {
//				mutableBlockPos.move(direction.getOpposite(), 1);
//
//				for (int l = j; l >= 0; --l) {
//					mutableBlockPos.setY(l);
//					if (this.level.isEmptyBlock(mutableBlockPos)) {
//						int i1;
//
//						for (i1 = l; l > 0 && level.isEmptyBlock(mutableBlockPos.move(Direction.DOWN)); --l) {}
//
//						if (l + 4 <= dimensionLogicalHeight) {
//							int j1 = i1 - l;
//							if (j1 <= 0 || j1 >= 3) {
//								mutableBlockPos.setY(l);
//								if (checkRegionForPlacement(mutableBlockPos, mutablePos, direction, 0)) {
//									double d2 = pos.distSqr(mutableBlockPos);
//									if (checkRegionForPlacement(mutableBlockPos, mutablePos, direction, -1) && this.checkRegionForPlacement(mutableBlockPos, mutablePos, direction, 1) && (d0 == -1.0D || d0 > d2)) {
//										d0 = d2;
//										pos1 = mutableBlockPos.immutable();
//									}
//
//									if (d0 == -1.0D && (d1 == -1.0D || d1 > d2)) {
//										d1 = d2;
//										pos2 = mutableBlockPos.immutable();
//									}
//								}
//							}
//						}
//					}
//				}
//			}
//		}
//
//		if (d0 == -1.0D && d1 != -1.0D) {
//			pos1 = pos2;
//			d0 = d1;
//		}
//
//		if (d0 == -1.0D) {
//			pos1 = new BlockPos(pos.getX(), Mth.clamp(pos.getY(), 70, this.level.getHeight() - 10), pos.getZ()).immutable();
//			Direction direction1 = direction.getClockWise();
//			if (!border.isWithinBounds(pos1)) {
//				return Optional.empty();
//			}
//
//			for (int l1 = -1; l1 < 2; ++l1) {
//				for (int k2 = 0; k2 < 2; ++k2) {
//					for (int i3 = -1; i3 < 3; ++i3) {
//						BlockState blockState = i3 < 0 ? SBBlocks.JADE_BLOCK.get().defaultBlockState() : Blocks.AIR.defaultBlockState();
//						mutablePos.setWithOffset(pos1, k2 * direction.getStepX() + l1 * direction1.getStepX(), i3, k2 * direction.getStepZ() + l1 * direction1.getStepZ());
//						this.level.setBlockAndUpdate(mutablePos, blockState);
//					}
//				}
//			}
//		}
//
//		for (int k1 = -1; k1 < 3; ++k1) {
//			for (int i2 = -1; i2 < 4; ++i2) {
//				if (k1 == -1 || k1 == 2 || i2 == -1 || i2 == 3) {
//					mutablePos.setWithOffset(pos1, k1 * direction.getStepX(), i2, k1 * direction.getStepZ());
//					level.setBlock(mutablePos, SBBlocks.JADE_BLOCK.get().defaultBlockState(), 3);
//				}
//			}
//		}
//
//		BlockState portal = SBForgeBlocks.SEPULCHRA_PORTAL.get().defaultBlockState().setValue(SepulchraPortalBlock.AXIS, axis);
//
//		for (int j2 = 0; j2 < 2; ++j2) {
//			for (int l2 = 0; l2 < 3; ++l2) {
//				mutablePos.setWithOffset(pos1, j2 * direction.getStepX(), l2, j2 * direction.getStepZ());
//				this.level.setBlock(mutablePos, portal, 18);
//			}
//		}
//
//		return Optional.of(new BlockUtil.FoundRectangle(pos1.immutable(), 2, 3));
//	}
//
//	@SuppressWarnings("deprecation")
//	private boolean checkRegionForPlacement(BlockPos originalPos, BlockPos.MutableBlockPos offsetPos, Direction directionIn, int offsetScale) {
//		Direction dir = directionIn.getClockWise();
//
//		for (int i = -1; i < 3; ++i) {
//			for (int j = -1; j < 4; ++j) {
//				offsetPos.setWithOffset(originalPos, directionIn.getStepX() * i + dir.getStepX() * offsetScale, j, directionIn.getStepZ() * i + dir.getStepZ() * offsetScale);
//				if (j < 0 && !level.getBlockState(offsetPos).isSolid()) return false;
//				if (j >= 0 && !level.isEmptyBlock(offsetPos)) return false;
//			}
//		}
//
//		return true;
//	}
//
//	public boolean playTeleportSound(ServerPlayer player, ServerLevel level, ServerLevel destination) {
//		return false;
//	}
}
