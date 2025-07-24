package net.invictusslayer.slayersbeasts.mixin.common;

import net.invictusslayer.slayersbeasts.block.IExtendedMushroomBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.MushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@SuppressWarnings("AddedMixinMembersNamePattern")
@Mixin(MushroomBlock.class)
public class MushroomBlockMixin implements IExtendedMushroomBlock {
	@Unique
	private ResourceKey<ConfiguredFeature<?, ?>> mightyMushroom;

	@Inject(method = "growMushroom", at = @At("HEAD"), cancellable = true)
	private void onGrowMushroom(ServerLevel level, BlockPos pos, BlockState state, RandomSource random, CallbackInfoReturnable<Boolean> cir) {
		Optional<? extends Holder<ConfiguredFeature<?, ?>>> feature = level.registryAccess().lookupOrThrow(Registries.CONFIGURED_FEATURE).get(mightyMushroom);
		if (feature.isEmpty()) cir.setReturnValue(false);

		for (int x = 0; x >= -1; --x) {
			for (int z = 0; z >= -1; --z) {
				if (isTwoByTwoMushroom(state, level, pos, x, z)) {
					level.removeBlock(pos.offset(x, 0, z), false);
					level.removeBlock(pos.offset(x + 1, 0, z), false);
					level.removeBlock(pos.offset(x, 0, z + 1), false);
					level.removeBlock(pos.offset(x + 1, 0, z + 1), false);
					if (feature.get().value().place(level, level.getChunkSource().getGenerator(), random, pos.offset(x, 0, z))) cir.setReturnValue(true);
					else {
						level.setBlock(pos.offset(x, 0, z), state, 3);
						level.setBlock(pos.offset(x + 1, 0, z), state, 3);
						level.setBlock(pos.offset(x, 0, z + 1), state, 3);
						level.setBlock(pos.offset(x + 1, 0, z + 1), state, 3);
						cir.setReturnValue(false);
					}
				}
			}
		}
	}

	@Unique
	private boolean isTwoByTwoMushroom(BlockState state, BlockGetter level, BlockPos pos, int x, int z) {
		Block block = state.getBlock();
		return level.getBlockState(pos.offset(x, 0, z)).is(block) &&
				level.getBlockState(pos.offset(x + 1, 0, z)).is(block) &&
				level.getBlockState(pos.offset(x, 0, z + 1)).is(block) &&
				level.getBlockState(pos.offset(x + 1, 0, z + 1)).is(block);
	}

	@Override
	public void setMightyMushroom(ResourceKey<ConfiguredFeature<?, ?>> mightyMushroom) {
		this.mightyMushroom = mightyMushroom;
	}
}
