package net.invictusslayer.slayersbeasts.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.ButterflyModel;
import net.invictusslayer.slayersbeasts.world.entity.Butterfly;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ButterflyRenderer<T extends Butterfly> extends MobRenderer<T, ButterflyModel<T>> {
	private static final ResourceLocation TORTOISESHELL = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/butterfly/tortoiseshell.png");

	public ButterflyRenderer(EntityRendererProvider.Context context) {
		super(context, new ButterflyModel<>(context.bakeLayer(ButterflyModel.LAYER_LOCATION)), 0.25F);
	}

	@Override
	protected void scale(T livingEntity, PoseStack poseStack, float partialTickTime) {
		float f = 0.8F;
		poseStack.scale(f, f, f);
	}

	@Override
	public ResourceLocation getTextureLocation(T entity) {
		return TORTOISESHELL;
	}
}
