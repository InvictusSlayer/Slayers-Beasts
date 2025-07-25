package net.invictusslayer.slayersbeasts.mixin.client;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.entity.SBMushroomCowVariant;
import net.minecraft.client.renderer.entity.MushroomCowRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.MushroomCow;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(MushroomCowRenderer.class)
public class MushroomCowRendererMixin {
	@Shadow @Final @Mutable
	private static Map<MushroomCow.Variant, ResourceLocation> TEXTURES;

	@Inject(method = "<clinit>", at = @At("TAIL"))
	private static void onClinit(CallbackInfo ci) {
		TEXTURES.put(SBMushroomCowVariant.BLACK, ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/cow/black_mooshroom.png"));
		TEXTURES.put(SBMushroomCowVariant.WHITE, ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/cow/white_mooshroom.png"));
	}
}
