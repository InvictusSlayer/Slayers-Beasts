package net.invictusslayer.slayersbeasts.block;

import net.invictusslayer.slayersbeasts.world.dimension.SBDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
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
    public void entityInside(BlockState state, Level worldIn, BlockPos pos, Entity entity) {
        if (entity.canChangeDimensions()) {
            if (!entity.level().isClientSide && !pos.equals(entity.portalEntrancePos)) {
                entity.portalEntrancePos = pos.immutable();
            }

            MinecraftServer server = entity.level().getServer();
            ResourceKey<Level> destination = entity.level().dimension() == SBDimensions.CRYPT_KEY ? Level.OVERWORLD : SBDimensions.CRYPT_KEY;
            if (server != null) {
                ServerLevel destinationWorld = server.getLevel(destination);
                if (destinationWorld != null) {
                    entity.teleportTo(destinationWorld, 0, 0, 0, Set.of(), 0, 0);
                }
            }
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
