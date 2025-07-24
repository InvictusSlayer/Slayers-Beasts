package net.invictusslayer.slayersbeasts.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Optional;

public class TallMushroomBlock extends DoublePlantBlock implements BonemealableBlock {
	private static final VoxelShape UPPER = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 14.0D, 14.0D);
	private static final VoxelShape LOWER = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
	private final ResourceKey<ConfiguredFeature<?, ?>> feature;

	public TallMushroomBlock(ResourceKey<ConfiguredFeature<?, ?>> feature, Properties properties) {
		super(properties);
		this.feature = feature;
	}

	public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
		return true;
	}

	public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
		return random.nextFloat() < 0.25F;
	}

	public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
		Optional<Holder.Reference<ConfiguredFeature<?, ?>>> optional = level.registryAccess().lookupOrThrow(Registries.CONFIGURED_FEATURE).get(feature);
		if (optional.isEmpty()) return;

		if (state.getValue(HALF).equals(DoubleBlockHalf.UPPER)) pos = pos.below();

		level.removeBlock(pos, false);
		level.removeBlock(pos.above(), false);
		if (optional.get().value().place(level, level.getChunkSource().getGenerator(), random, pos)) return;

		level.setBlock(pos, state.setValue(HALF, DoubleBlockHalf.LOWER), 3);
		level.setBlock(pos.above(), state.setValue(HALF, DoubleBlockHalf.UPPER), 3);
	}

	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return state.getValue(HALF) == DoubleBlockHalf.LOWER ? LOWER : UPPER;
	}

	protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
		return state.isSolidRender();
	}

	public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
		BlockPos blockPos = pos.below();
		BlockState blockState = level.getBlockState(blockPos);
		if (blockState.is(this) && state.getValue(HALF) == DoubleBlockHalf.UPPER && blockState.getValue(HALF) == DoubleBlockHalf.LOWER) return true;
		if (blockState.is(BlockTags.MUSHROOM_GROW_BLOCK)) return true;
		return level.getRawBrightness(pos, 0) < 13 && mayPlaceOn(blockState, level, blockPos);
	}
}
