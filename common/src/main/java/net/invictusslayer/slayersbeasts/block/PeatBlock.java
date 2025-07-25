package net.invictusslayer.slayersbeasts.block;

import com.mojang.serialization.MapCodec;
import net.invictusslayer.slayersbeasts.data.tag.SBTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PeatBlock extends FallingBlock {
	public static final MapCodec<PeatBlock> CODEC = simpleCodec(PeatBlock::new);

	public PeatBlock(Properties properties) {
		super(properties);
	}

	protected MapCodec<? extends FallingBlock> codec() {
		return CODEC;
	}

	public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
		if (!(entity instanceof LivingEntity) || entity.getBlockStateOn().is(this)) {
			entity.makeStuckInBlock(state, new Vec3(0.4D, 0.4D, 0.4D));
			if (level.isClientSide) {
				RandomSource random = level.getRandom();
				boolean flag = entity.xOld != entity.getX() || entity.zOld != entity.getZ();
				if (flag && random.nextInt(10) == 0) {
					level.addParticle(ParticleTypes.SQUID_INK, entity.getX(), pos.getY() + 1, entity.getZ(), Mth.randomBetween(random, -1.0F, 1.0F) / 12, 0.05D, Mth.randomBetween(random, -1.0F, 1.0F) / 12);
				}
			}
		}

		entity.setSharedFlagOnFire(false);
	}

	public boolean skipRendering(BlockState state, BlockState adjacentState, Direction direction) {
		return adjacentState.is(this) || super.skipRendering(state, adjacentState, direction);
	}

	public VoxelShape getOcclusionShape(BlockState state) {
		return Shapes.empty();
	}

	public VoxelShape getVisualShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		if (context instanceof EntityCollisionContext entitycollisioncontext) {
			Entity entity = entitycollisioncontext.getEntity();
			if (entity != null) {
				if (entity instanceof FallingBlockEntity) {
					return super.getCollisionShape(state, level, pos, context);
				}

				if (entity.fallDistance > 2.5F) {
					return Shapes.box(0.0D, 0.0D, 0.0D, 1.0D, 0.9D, 1.0D);
				}

				if (entity.getType().is(SBTags.EntityTypes.PEAT_WALKABLE_MOBS) && context.isAbove(Shapes.block(), pos, false) && !context.isDescending()) {
					return super.getCollisionShape(state, level, pos, context);
				}
			}
		}

		return Shapes.empty();
	}

	public boolean isPathfindable(BlockState state, PathComputationType type) {
		return true;
	}
}
