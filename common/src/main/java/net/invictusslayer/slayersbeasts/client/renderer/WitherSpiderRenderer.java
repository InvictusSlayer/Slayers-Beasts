package net.invictusslayer.slayersbeasts.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.WitherSpiderModel;
import net.invictusslayer.slayersbeasts.entity.WitherSpider;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.ResourceLocation;

public class WitherSpiderRenderer extends MobRenderer<WitherSpider, LivingEntityRenderState, WitherSpiderModel> {
	private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/wither_spider.png");

	public WitherSpiderRenderer(EntityRendererProvider.Context context) {
		super(context, new WitherSpiderModel(context.bakeLayer(WitherSpiderModel.LAYER_LOCATION)), 0.6F);
	}

	protected void scale(LivingEntityRenderState state, PoseStack poseStack) {
		float f = 1.2F;
		poseStack.scale(f, f, f);
	}

	public ResourceLocation getTextureLocation(LivingEntityRenderState state) {
		return TEXTURE;
	}

	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}
}
