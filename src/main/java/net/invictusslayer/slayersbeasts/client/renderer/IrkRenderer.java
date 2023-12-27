package net.invictusslayer.slayersbeasts.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.IrkModel;
import net.invictusslayer.slayersbeasts.entity.Irk;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class IrkRenderer<T extends Irk> extends MobRenderer<T, IrkModel<T>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/irk.png");

	public IrkRenderer(EntityRendererProvider.Context context) {
		super(context, new IrkModel<>(context.bakeLayer(IrkModel.LAYER_LOCATION)), 0.2F);
	}

	protected void scale(T entity, PoseStack poseStack, float partialTickTime) {
		float f = 0.7F;
		poseStack.scale(f, f, f);
	}

	public ResourceLocation getTextureLocation(T entity) {
		return TEXTURE;
	}
}
