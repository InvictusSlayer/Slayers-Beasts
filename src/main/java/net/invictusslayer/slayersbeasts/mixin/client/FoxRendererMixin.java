package net.invictusslayer.slayersbeasts.mixin.client;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.entity.SBFoxVariant;
import net.minecraft.client.renderer.entity.FoxRenderer;
import net.minecraft.client.renderer.entity.state.FoxRenderState;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FoxRenderer.class)
public class FoxRendererMixin {
	@Inject(method = "getTextureLocation(Lnet/minecraft/client/renderer/entity/state/FoxRenderState;)Lnet/minecraft/resources/ResourceLocation;", at = @At("HEAD"), cancellable = true)
	private void onGetTextureLocation(FoxRenderState state, CallbackInfoReturnable<ResourceLocation> cir) {
		if (state.variant == SBFoxVariant.GREY) cir.setReturnValue(ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/fox/grey_fox" + (state.isSleeping ? "_sleep.png" : ".png")));
	}
}
