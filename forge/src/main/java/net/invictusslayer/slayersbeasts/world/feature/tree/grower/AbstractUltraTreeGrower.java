package net.invictusslayer.slayersbeasts.world.feature.tree.grower;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.level.SaplingGrowTreeEvent;
import net.minecraftforge.eventbus.api.Event;

public abstract class AbstractUltraTreeGrower extends AbstractMegaTreeGrower {
	public boolean growTree(ServerLevel level, ChunkGenerator chunkGen, BlockPos pos, BlockState state, RandomSource random) {
		for (int x = 0; x >= -2; --x) {
			for (int z = 0; z >= -2; --z) {
				if (isThreeByThreeSapling(state, level, pos, x, z)) {
					return placeUltra(level, chunkGen, pos, state, random, x, z);
				}
			}
		}

		return super.growTree(level, chunkGen, pos, state, random);
	}

	protected abstract ResourceKey<ConfiguredFeature<?, ?>> getConfiguredUltraFeature(RandomSource random);

	public boolean placeUltra(ServerLevel level, ChunkGenerator chunkGen, BlockPos pos, BlockState state, RandomSource random, int branchX, int branchY) {
		ResourceKey<ConfiguredFeature<?, ?>> feature = getConfiguredUltraFeature(random);
		if (feature == null) return false;

		Holder<ConfiguredFeature<?, ?>> holder = level.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE).getHolder(feature).orElse(null);
		SaplingGrowTreeEvent event = ForgeEventFactory.blockGrowFeature(level, random, pos, holder);
		if (event.getResult() == Event.Result.DENY) return false;

		holder = event.getFeature();
		if (holder == null) return false;

		ConfiguredFeature<?, ?> tree = holder.value();
		BlockState air = Blocks.AIR.defaultBlockState();
		level.setBlock(pos.offset(branchX, 0, branchY), air, 4);
		level.setBlock(pos.offset(branchX + 1, 0, branchY), air, 4);
		level.setBlock(pos.offset(branchX + 2, 0, branchY), air, 4);
		level.setBlock(pos.offset(branchX, 0, branchY + 1), air, 4);
		level.setBlock(pos.offset(branchX + 1, 0, branchY + 1), air, 4);
		level.setBlock(pos.offset(branchX + 2, 0, branchY + 1), air, 4);
		level.setBlock(pos.offset(branchX, 0, branchY + 2), air, 4);
		level.setBlock(pos.offset(branchX + 1, 0, branchY + 2), air, 4);
		level.setBlock(pos.offset(branchX + 2, 0, branchY + 2), air, 4);
		if (tree.place(level, chunkGen, random, pos.offset(branchX, 0, branchY))) return true;

		level.setBlock(pos.offset(branchX, 0, branchY), state, 4);
		level.setBlock(pos.offset(branchX + 1, 0, branchY), state, 4);
		level.setBlock(pos.offset(branchX + 2, 0, branchY), state, 4);
		level.setBlock(pos.offset(branchX, 0, branchY + 1), state, 4);
		level.setBlock(pos.offset(branchX + 1, 0, branchY + 1), state, 4);
		level.setBlock(pos.offset(branchX + 2, 0, branchY + 1), state, 4);
		level.setBlock(pos.offset(branchX, 0, branchY + 2), state, 4);
		level.setBlock(pos.offset(branchX + 1, 0, branchY + 2), state, 4);
		level.setBlock(pos.offset(branchX + 2, 0, branchY + 2), state, 4);
		return false;
	}

	public static boolean isThreeByThreeSapling(BlockState state, BlockGetter level, BlockPos pos, int x, int z) {
		Block block = state.getBlock();
		return level.getBlockState(pos.offset(x, 0, z)).is(block) &&
				level.getBlockState(pos.offset(x + 1, 0, z)).is(block) &&
				level.getBlockState(pos.offset(x + 2, 0, z)).is(block) &&
				level.getBlockState(pos.offset(x, 0, z + 1)).is(block) &&
				level.getBlockState(pos.offset(x + 1, 0, z + 1)).is(block) &&
				level.getBlockState(pos.offset(x + 2, 0, z + 1)).is(block) &&
				level.getBlockState(pos.offset(x, 0, z + 2)).is(block) &&
				level.getBlockState(pos.offset(x + 1, 0, z + 2)).is(block) &&
				level.getBlockState(pos.offset(x + 2, 0, z + 2)).is(block);
	}
}
