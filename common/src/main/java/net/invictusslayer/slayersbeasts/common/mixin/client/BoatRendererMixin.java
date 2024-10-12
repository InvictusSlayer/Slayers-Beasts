package net.invictusslayer.slayersbeasts.common.mixin.client;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.entity.vehicle.SBBoatType;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BoatRenderer.class)
public abstract class BoatRendererMixin {
	@Inject(method = "getTextureLocation(Lnet/minecraft/world/entity/vehicle/Boat$Type;Z)Lnet/minecraft/resources/ResourceLocation;", at = @At("HEAD"), cancellable = true)
	private static void onGetTextureLocation(Boat.Type type, boolean chestBoat, CallbackInfoReturnable<ResourceLocation> cir) {
		for (Boat.Type boatType : SBBoatType.values()) if (boatType == type) cir.setReturnValue(ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/" + (chestBoat ? "chest_boat/" : "boat/") + type.getName() + ".png"));
	}
}
