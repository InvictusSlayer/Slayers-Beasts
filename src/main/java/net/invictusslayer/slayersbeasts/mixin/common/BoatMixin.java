package net.invictusslayer.slayersbeasts.mixin.common;

import net.invictusslayer.slayersbeasts.block.SBBlocks;
import net.invictusslayer.slayersbeasts.item.SBItems;
import net.invictusslayer.slayersbeasts.misc.SBBoatType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Boat.class)
public abstract class BoatMixin {
	@Shadow
	public abstract Boat.Type getVariant();

	@Inject(method = "getDropItem", at = @At("HEAD"), cancellable = true)
	private void onGetDropItem(CallbackInfoReturnable<Item> cir) {
		if (getVariant() == SBBoatType.ASPEN) cir.setReturnValue(SBItems.ASPEN_BOAT.get());
		if (getVariant() == SBBoatType.DESERT_OAK) cir.setReturnValue(SBItems.DESERT_OAK_BOAT.get());
		if (getVariant() == SBBoatType.EUCALYPTUS) cir.setReturnValue(SBItems.EUCALYPTUS_BOAT.get());
		if (getVariant() == SBBoatType.KAPOK) cir.setReturnValue(SBItems.KAPOK_BOAT.get());
		if (getVariant() == SBBoatType.REDWOOD) cir.setReturnValue(SBItems.REDWOOD_BOAT.get());
		if (getVariant() == SBBoatType.WILLOW) cir.setReturnValue(SBItems.WILLOW_BOAT.get());
	}

	@ModifyArg(method = "checkFallDamage", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/vehicle/Boat;spawnAtLocation(Lnet/minecraft/world/level/ItemLike;)Lnet/minecraft/world/entity/item/ItemEntity;", ordinal = 0))
	private ItemLike onCheckFallDamage(ItemLike planks) {
		if (getVariant() == SBBoatType.ASPEN) return SBBlocks.ASPEN_PLANKS.get();
		if (getVariant() == SBBoatType.DESERT_OAK) return SBBlocks.DESERT_OAK_PLANKS.get();
		if (getVariant() == SBBoatType.EUCALYPTUS) return SBBlocks.EUCALYPTUS_PLANKS.get();
		if (getVariant() == SBBoatType.KAPOK) return SBBlocks.KAPOK_PLANKS.get();
		if (getVariant() == SBBoatType.REDWOOD) return SBBlocks.REDWOOD_PLANKS.get();
		if (getVariant() == SBBoatType.WILLOW) return SBBlocks.WILLOW_PLANKS.get();
		return planks;
	}
}
