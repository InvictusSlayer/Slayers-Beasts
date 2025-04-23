package net.invictusslayer.slayersbeasts.common.mixin.common;

import net.invictusslayer.slayersbeasts.common.entity.vehicle.SBBoatType;
import net.invictusslayer.slayersbeasts.common.init.SBItems;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Boat.class)
public abstract class BoatMixin {
	@Shadow
	public abstract Object getVariant();

	@Inject(method = "getDropItem", at = @At("HEAD"), cancellable = true)
	private void onGetDropItem(CallbackInfoReturnable<Item> cir) {
		if (getVariant() == SBBoatType.ASPEN) cir.setReturnValue(SBItems.ASPEN_BOAT.get());
		if (getVariant() == SBBoatType.BLOODWOOD) cir.setReturnValue(SBItems.BLOODWOOD_BOAT.get());
		if (getVariant() == SBBoatType.CYPRESS) cir.setReturnValue(SBItems.CYPRESS_BOAT.get());
		if (getVariant() == SBBoatType.DESERT_OAK) cir.setReturnValue(SBItems.DESERT_OAK_BOAT.get());
		if (getVariant() == SBBoatType.EUCALYPTUS) cir.setReturnValue(SBItems.EUCALYPTUS_BOAT.get());
		if (getVariant() == SBBoatType.KAPOK) cir.setReturnValue(SBItems.KAPOK_BOAT.get());
		if (getVariant() == SBBoatType.REDWOOD) cir.setReturnValue(SBItems.REDWOOD_BOAT.get());
		if (getVariant() == SBBoatType.WILLOW) cir.setReturnValue(SBItems.WILLOW_BOAT.get());
	}
}
