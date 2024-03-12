package net.invictusslayer.slayersbeasts.common.mixin.client;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.entity.vehicle.SBBoatType;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Map;
import java.util.stream.Stream;

@SuppressWarnings("AddedMixinMembersNamePattern")
@Mixin(BoatRenderer.class)
public abstract class BoatRendererMixin {
	@Shadow @Final @Mutable
	private Map<Boat.Type, Pair<ResourceLocation, ListModel<Boat>>> boatResources;

	@Shadow
	private static String getTextureLocation(Boat.Type type, boolean chestBoat) {
		if (chestBoat) return "textures/entity/chest_boat/" + type.getName() + ".png";
		return "textures/entity/boat/" + type.getName() + ".png";
	}

	@Shadow 
	protected abstract ListModel<Boat> createBoatModel(EntityRendererProvider.Context context, Boat.Type type, boolean chestBoat);

	@Inject(method = "<init>", at = @At("TAIL"), locals = LocalCapture.CAPTURE_FAILHARD)
	private void onInit(EntityRendererProvider.Context context, boolean chestBoat, CallbackInfo ci) {
		boatResources = Stream.of(Boat.Type.values()).collect(ImmutableMap.toImmutableMap(type -> type, type -> Pair.of(getTexture(type, chestBoat), createBoatModel(context, type, chestBoat))));
	}

	@Unique
	private ResourceLocation getTexture(Boat.Type type, boolean chestBoat) {
		for (Boat.Type boatType : SBBoatType.values()) if (boatType == type) return new ResourceLocation(SlayersBeasts.MOD_ID, getTextureLocation(type, chestBoat));
		return new ResourceLocation(getTextureLocation(type, chestBoat));
	}
}
