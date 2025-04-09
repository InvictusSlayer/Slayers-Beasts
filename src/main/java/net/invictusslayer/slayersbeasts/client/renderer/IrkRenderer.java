package net.invictusslayer.slayersbeasts.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.IrkModel;
import net.invictusslayer.slayersbeasts.entity.Irk;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.ResourceLocation;
//$ client_env {
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)//$}
public class IrkRenderer extends MobRenderer<Irk, LivingEntityRenderState, IrkModel> {
	private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/irk.png");

	public IrkRenderer(EntityRendererProvider.Context context) {
		super(context, new IrkModel(context.bakeLayer(IrkModel.LAYER_LOCATION)), 0.2F);
	}

	protected void scale(LivingEntityRenderState state, PoseStack poseStack) {
		float f = 0.7F;
		poseStack.scale(f, f, f);
	}

	public ResourceLocation getTextureLocation(LivingEntityRenderState state) {
		return TEXTURE;
	}

	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}
}
