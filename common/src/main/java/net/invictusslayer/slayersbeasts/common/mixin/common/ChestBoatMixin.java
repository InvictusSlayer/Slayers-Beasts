package net.invictusslayer.slayersbeasts.common.mixin.common;

import net.invictusslayer.slayersbeasts.common.entity.vehicle.SBBoatType;
import net.invictusslayer.slayersbeasts.common.init.SBItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChestBoat.class)
public class ChestBoatMixin extends Boat {
	public ChestBoatMixin(EntityType<? extends Boat> type, Level level) {
		super(type, level);
	}

	@Inject(method = "getDropItem", at = @At("HEAD"), cancellable = true)
	private void onGetDropItem(CallbackInfoReturnable<Item> cir) {
		if (getVariant() == SBBoatType.ASPEN) cir.setReturnValue(SBItems.ASPEN_CHEST_BOAT.get());
		if (getVariant() == SBBoatType.DESERT_OAK) cir.setReturnValue(SBItems.DESERT_OAK_CHEST_BOAT.get());
		if (getVariant() == SBBoatType.EUCALYPTUS) cir.setReturnValue(SBItems.EUCALYPTUS_CHEST_BOAT.get());
		if (getVariant() == SBBoatType.KAPOK) cir.setReturnValue(SBItems.KAPOK_CHEST_BOAT.get());
		if (getVariant() == SBBoatType.REDWOOD) cir.setReturnValue(SBItems.REDWOOD_CHEST_BOAT.get());
		if (getVariant() == SBBoatType.WILLOW) cir.setReturnValue(SBItems.WILLOW_CHEST_BOAT.get());
	}
}
