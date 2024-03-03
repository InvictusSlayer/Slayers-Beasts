package net.invictusslayer.slayersbeasts.forge.mixin.common;

import net.invictusslayer.slayersbeasts.world.feature.tree.IExtendedTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.level.SaplingGrowTreeEvent;
import net.minecraftforge.eventbus.api.Event;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SuppressWarnings("AddedMixinMembersNamePattern")
@Mixin(TreeGrower.class)
public class TreeGrowerMixin implements IExtendedTreeGrower {
	@Shadow @Final
	private float secondaryChance;

	@Unique
	private ResourceKey<ConfiguredFeature<?, ?>> gigaTree = null;
	@Unique
	private ResourceKey<ConfiguredFeature<?, ?>> secondaryGigaTree = null;

	@Inject(method = "growTree", at = @At("HEAD"), cancellable = true)
	private void onGrowTree(ServerLevel level, ChunkGenerator chunkGen, BlockPos pos, BlockState state, RandomSource random, CallbackInfoReturnable<Boolean> cir) {
		ResourceKey<ConfiguredFeature<?, ?>> feature = getConfiguredGigaFeature(random);
		if (feature != null) {
			Holder<ConfiguredFeature<?, ?>> holder = level.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE).getHolder(feature).orElse(null);
			SaplingGrowTreeEvent event = ForgeEventFactory.blockGrowFeature(level, random, pos, holder);
			if (event.getResult() == Event.Result.DENY) cir.setReturnValue(false);
			holder = event.getFeature();
			if (holder != null) {
				for (int x = 0; x >= -2; --x) {
					for (int z = 0; z >= -2; --z) {
						if (isThreeByThreeSapling(state, level, pos, x, z)) {
							ConfiguredFeature<?, ?> tree = holder.value();
							BlockState air = Blocks.AIR.defaultBlockState();
							level.setBlock(pos.offset(x, 0, z), air, 4);
							level.setBlock(pos.offset(x + 1, 0, z), air, 4);
							level.setBlock(pos.offset(x + 2, 0, z), air, 4);
							level.setBlock(pos.offset(x, 0, z + 1), air, 4);
							level.setBlock(pos.offset(x + 1, 0, z + 1), air, 4);
							level.setBlock(pos.offset(x + 2, 0, z + 1), air, 4);
							level.setBlock(pos.offset(x, 0, z + 2), air, 4);
							level.setBlock(pos.offset(x + 1, 0, z + 2), air, 4);
							level.setBlock(pos.offset(x + 2, 0, z + 2), air, 4);
							if (tree.place(level, chunkGen, random, pos.offset(x, 0, z))) cir.setReturnValue(true);
							else {
								level.setBlock(pos.offset(x, 0, z), state, 4);
								level.setBlock(pos.offset(x + 1, 0, z), state, 4);
								level.setBlock(pos.offset(x + 2, 0, z), state, 4);
								level.setBlock(pos.offset(x, 0, z + 1), state, 4);
								level.setBlock(pos.offset(x + 1, 0, z + 1), state, 4);
								level.setBlock(pos.offset(x + 2, 0, z + 1), state, 4);
								level.setBlock(pos.offset(x, 0, z + 2), state, 4);
								level.setBlock(pos.offset(x + 1, 0, z + 2), state, 4);
								level.setBlock(pos.offset(x + 2, 0, z + 2), state, 4);
								cir.setReturnValue(false);
							}
						}
					}
				}
			}
		}
	}

	@Unique
	private ResourceKey<ConfiguredFeature<?, ?>> getConfiguredGigaFeature(RandomSource random) {
		return secondaryGigaTree != null && random.nextFloat() < secondaryChance ? secondaryGigaTree : gigaTree;
	}

	@Unique
	private boolean isThreeByThreeSapling(BlockState state, BlockGetter level, BlockPos pos, int x, int z) {
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

	@Override
	public void setGigaTree(ResourceKey<ConfiguredFeature<?, ?>> gigaTree) {
		this.gigaTree = gigaTree;
	}

	@Override
	public void setSecondaryGigaTree(ResourceKey<ConfiguredFeature<?, ?>> secondaryGigaTree) {
		this.secondaryGigaTree = secondaryGigaTree;
	}
}
