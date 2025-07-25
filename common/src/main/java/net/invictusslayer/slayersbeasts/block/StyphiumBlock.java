package net.invictusslayer.slayersbeasts.block;

import net.invictusslayer.slayersbeasts.init.SBBlocks;
import net.invictusslayer.slayersbeasts.world.feature.SBConfiguredFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LightEngine;

public class StyphiumBlock extends Block implements BonemealableBlock {
	public StyphiumBlock(Properties properties) {
		super(properties);
	}

	public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		if (!canBeStyphium(state, level, pos)) {
			boolean isDeepslate = state.is(SBBlocks.DEEPSLATE_STYPHIUM.get());
			level.setBlockAndUpdate(pos, isDeepslate ? Blocks.DEEPSLATE.defaultBlockState() : Blocks.STONE.defaultBlockState());
		}
	}

	private static boolean canBeStyphium(BlockState state, LevelReader level, BlockPos pos) {
		BlockPos above = pos.above();
		BlockState stateAbove = level.getBlockState(above);
		int i = LightEngine.getLightBlockInto(state, stateAbove, Direction.UP, stateAbove.getLightBlock());
		return i < 15;
	}

	public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
		return level.getBlockState(pos.above()).isAir();
	}

	public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
		return true;
	}

	public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
		level.registryAccess().get(Registries.CONFIGURED_FEATURE).flatMap(configured ->
				configured.value().get(SBConfiguredFeatures.STYPHIUM_PATCH_BONEMEAL)).ifPresent(holder ->
				holder.value().place(level, level.getChunkSource().getGenerator(), random, pos.above()));
	}

	public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
		if (random.nextInt(10) == 0) {
			level.addParticle(ParticleTypes.MYCELIUM, (double) pos.getX() + random.nextDouble(), (double) pos.getY() + 1.1D, (double)pos.getZ() + random.nextDouble(), 0.0D, 0.0D, 0.0D);
		}
	}
}
