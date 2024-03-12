package net.invictusslayer.slayersbeasts.common.mixin.common;

import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockEntityType.class)
public class BlockEntityTypeMixin {
	@Inject(method = "isValid", at = @At("HEAD"), cancellable = true)
	private void onIsValid(BlockState state, CallbackInfoReturnable<Boolean> cir) {
		if (this.equals(BlockEntityType.SIGN) && (state.getBlock() instanceof StandingSignBlock || state.getBlock() instanceof WallSignBlock)) cir.setReturnValue(true);
		if (this.equals(BlockEntityType.HANGING_SIGN) && (state.getBlock() instanceof CeilingHangingSignBlock || state.getBlock() instanceof WallHangingSignBlock)) cir.setReturnValue(true);
	}
}
