package net.invictusslayer.slayersbeasts.common.mixin.common;

import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.VillagerType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(VillagerTrades.EmeraldsForVillagerTypeItem.class)
public class VillagerTypeTradeMixin {
	@Inject(method = "method_19201", at = @At("HEAD"), cancellable = true)
	private static void onInit(VillagerType type, CallbackInfo ci) {
		ci.cancel();
	}
}
