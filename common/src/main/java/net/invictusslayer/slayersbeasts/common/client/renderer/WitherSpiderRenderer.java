package net.invictusslayer.slayersbeasts.common.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.client.model.WitherSpiderModel;
import net.invictusslayer.slayersbeasts.common.entity.WitherSpider;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WitherSpiderRenderer<T extends WitherSpider> extends MobRenderer<T, WitherSpiderModel<T>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/wither_spider.png");

	public WitherSpiderRenderer(EntityRendererProvider.Context context) {
		super(context, new WitherSpiderModel<>(context.bakeLayer(WitherSpiderModel.LAYER_LOCATION)), 0.6F);
	}

	protected void scale(WitherSpider entity, PoseStack poseStack, float partialTickTime) {
		float f = 1.2F;
		poseStack.scale(f, f, f);
	}

	public ResourceLocation getTextureLocation(T entity) {
		return TEXTURE;
	}
}
