package net.invictusslayer.slayersbeasts.common.mixin.client;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.entity.SBFoxType;
import net.minecraft.client.renderer.entity.FoxRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Fox;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FoxRenderer.class)
public class FoxRendererMixin {
	@Inject(method = "getTextureLocation(Lnet/minecraft/world/entity/animal/Fox;)Lnet/minecraft/resources/ResourceLocation;", at = @At("HEAD"), cancellable = true)
	private void onGetTextureLocation(Fox entity, CallbackInfoReturnable<ResourceLocation> cir) {
		if (entity.getVariant() == SBFoxType.GREY) cir.setReturnValue(ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/fox/grey_fox" + (entity.isSleeping() ? "_sleep.png" : ".png")));
	}
}
