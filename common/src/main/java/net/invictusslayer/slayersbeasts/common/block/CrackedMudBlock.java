package net.invictusslayer.slayersbeasts.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Tilt;
import net.minecraft.world.level.gameevent.GameEvent;

public class CrackedMudBlock extends Block {
	private static final EnumProperty<Tilt> TILT = BlockStateProperties.TILT;

	public CrackedMudBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(TILT, Tilt.NONE));
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(TILT);
	}

	@SuppressWarnings("deprecation")
	public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		Tilt tilt = state.getValue(TILT);
		if (tilt == Tilt.UNSTABLE) {
			this.setTiltAndScheduleTick(state, level, pos, Tilt.NONE, SoundEvents.PACKED_MUD_HIT);
		} else if (tilt == Tilt.PARTIAL) {
			this.setTiltAndScheduleTick(state, level, pos, Tilt.UNSTABLE, SoundEvents.PACKED_MUD_HIT);
		} else if (tilt == Tilt.FULL) {
			this.setTiltAndScheduleTick(state, level, pos, Tilt.PARTIAL, SoundEvents.PACKED_MUD_HIT);
		}
	}

	@SuppressWarnings("deprecation")
	public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
		if (!level.isClientSide) {
			if (!entity.isSteppingCarefully() && entity instanceof LivingEntity && !level.getBlockState(pos.below()).isSolid()) {
				Tilt tilt = state.getValue(TILT);
				if (tilt == Tilt.NONE) {
					this.setTiltAndScheduleTick(state, level, pos, Tilt.UNSTABLE, SoundEvents.PACKED_MUD_FALL);
				} else if (tilt == Tilt.UNSTABLE) {
					this.setTiltAndScheduleTick(state, level, pos, Tilt.PARTIAL, SoundEvents.PACKED_MUD_FALL);
				} else if (tilt == Tilt.PARTIAL) {
					this.setTiltAndScheduleTick(state, level, pos, Tilt.FULL, SoundEvents.PACKED_MUD_FALL);
				} else if (tilt == Tilt.FULL) {
					level.removeBlock(pos, false);
					playTiltSound(level, pos, SoundEvents.PACKED_MUD_BREAK);
				}
			}
		}

		super.stepOn(level, pos, state, entity);
	}

	@SuppressWarnings("deprecation")
	public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
		if (fallDistance > 4 && entity instanceof LivingEntity && !level.getBlockState(pos.below()).isSolid()) {
			level.removeBlock(pos, false);
			playTiltSound(level, pos, SoundEvents.PACKED_MUD_BREAK);
		}

		super.fallOn(level, state, pos, entity, fallDistance);
	}

	private void setTiltAndScheduleTick(BlockState state, Level level, BlockPos pos, Tilt tilt, SoundEvent sound) {
		setTilt(state, level, pos, tilt);
		if (sound != null) {
			playTiltSound(level, pos, sound);
		}

		level.scheduleTick(pos, this, 100);
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
