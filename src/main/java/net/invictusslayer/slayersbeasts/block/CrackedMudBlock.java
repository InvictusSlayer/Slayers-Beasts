package net.invictusslayer.slayersbeasts.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Tilt;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class CrackedMudBlock extends Block {
    private static final EnumProperty<Tilt> TILT = BlockStateProperties.TILT;
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D);

    public CrackedMudBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(TILT, Tilt.NONE));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(TILT);
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @SuppressWarnings("deprecation")
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        Tilt tilt = pState.getValue(TILT);
        if (tilt == Tilt.UNSTABLE) {
            this.setTiltAndScheduleTick(pState, pLevel, pPos, Tilt.NONE, SoundEvents.BASALT_HIT);
        } else if (tilt == Tilt.PARTIAL) {
            this.setTiltAndScheduleTick(pState, pLevel, pPos, Tilt.UNSTABLE, SoundEvents.BASALT_HIT);
        } else if (tilt == Tilt.FULL) {
            this.setTiltAndScheduleTick(pState, pLevel, pPos, Tilt.PARTIAL, SoundEvents.BASALT_HIT);
        }
    }

    @SuppressWarnings("deprecation")
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if (!pLevel.isClientSide) {
            if (canEntityTilt(pLevel, pPos, pEntity)) {
                Tilt tilt = pState.getValue(TILT);
                if (tilt == Tilt.NONE) {
                    this.setTiltAndScheduleTick(pState, pLevel, pPos, Tilt.UNSTABLE, SoundEvents.BASALT_BREAK);
                } else if (tilt == Tilt.UNSTABLE) {
                    this.setTiltAndScheduleTick(pState, pLevel, pPos, Tilt.PARTIAL, SoundEvents.BASALT_BREAK);
                } else if (tilt == Tilt.PARTIAL) {
                    this.setTiltAndScheduleTick(pState, pLevel, pPos, Tilt.FULL, SoundEvents.BASALT_BREAK);
                } else if (tilt == Tilt.FULL) {
                    pLevel.removeBlock(pPos, false);
                    playTiltSound(pLevel, pPos, SoundEvents.BASALT_BREAK);
                }
            }
        }
    }

    @SuppressWarnings("deprecation")
    private static boolean canEntityTilt(Level pLevel, BlockPos pPos, Entity pEntity) {
        return pEntity.onGround() && pEntity.position().y > pPos.getY() + 0.6875D && !pLevel.getBlockState(pPos.below()).isSolid();
    }

    private void setTiltAndScheduleTick(BlockState pState, Level pLevel, BlockPos pPos, Tilt pTilt, @Nullable SoundEvent pSound) {
        setTilt(pState, pLevel, pPos, pTilt);
        if (pSound != null) {
            playTiltSound(pLevel, pPos, pSound);
        }

        pLevel.scheduleTick(pPos, this, 100);
    }

    private static void setTilt(BlockState pState, Level pLevel, BlockPos pPos, Tilt pTilt) {
        Tilt tilt = pState.getValue(TILT);
        pLevel.setBlock(pPos, pState.setValue(TILT, pTilt), 2);
        if (pTilt.causesVibration() && pTilt != tilt) {
            pLevel.gameEvent(null, GameEvent.BLOCK_CHANGE, pPos);
        }
    }

    private static void playTiltSound(Level pLevel, BlockPos pPos, SoundEvent pSound) {
        float f = Mth.randomBetween(pLevel.random, 0.8F, 1.2F);
        pLevel.playSound(null, pPos, pSound, SoundSource.BLOCKS, 1.0F, f);
    }
}
