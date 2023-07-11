package net.invictusslayer.slayersbeasts.block;

import net.invictusslayer.slayersbeasts.datagen.tags.ModTags;
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
    public PeatBlock(Properties pProperties) {
        super(pProperties);
    }

    @SuppressWarnings("deprecation")
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if (!(pEntity instanceof LivingEntity) || pEntity.getFeetBlockState().is(this)) {
            pEntity.makeStuckInBlock(pState, new Vec3(0.4D, 1.5D, 0.4D));
            if (pLevel.isClientSide) {
                RandomSource random = pLevel.getRandom();
                boolean flag = pEntity.xOld != pEntity.getX() || pEntity.zOld != pEntity.getZ();
                if (flag && random.nextInt(10) == 0) {
                    pLevel.addParticle(ParticleTypes.SQUID_INK, pEntity.getX(), pPos.getY() + 1, pEntity.getZ(), Mth.randomBetween(random, -1.0F, 1.0F) / 12, 0.05D, Mth.randomBetween(random, -1.0F, 1.0F) / 12);
                }
            }
        }

        pEntity.setSharedFlagOnFire(false);
    }

    @SuppressWarnings("deprecation")
    public boolean skipRendering(BlockState pState, BlockState pAdjacentState, Direction pDirection) {
        return pAdjacentState.is(this) || super.skipRendering(pState, pAdjacentState, pDirection);
    }

    @SuppressWarnings("deprecation")
    public VoxelShape getOcclusionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return Shapes.empty();
    }

    @SuppressWarnings("deprecation")
    public VoxelShape getVisualShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return Shapes.empty();
    }

    @SuppressWarnings("deprecation")
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        if (pContext instanceof EntityCollisionContext entitycollisioncontext) {
            Entity entity = entitycollisioncontext.getEntity();
            if (entity != null) {
                if (entity instanceof FallingBlockEntity) {
                    return super.getCollisionShape(pState, pLevel, pPos, pContext);
                }

                if (entity.fallDistance > 2.5F) {
                    return Shapes.box(0.0D, 0.0D, 0.0D, 1.0D, 0.9D, 1.0D);
                }

                if (entity.getType().is(ModTags.EntityTypes.PEAT_WALKABLE_MOBS) && pContext.isAbove(Shapes.block(), pPos, false) && !pContext.isDescending()) {
                    return super.getCollisionShape(pState, pLevel, pPos, pContext);
                }
            }
        }

        return Shapes.empty();
    }

    @SuppressWarnings("deprecation")
    public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
        return true;
    }
}
