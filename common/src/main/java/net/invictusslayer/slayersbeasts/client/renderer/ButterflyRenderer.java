package net.invictusslayer.slayersbeasts.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.ButterflyModel;
import net.invictusslayer.slayersbeasts.client.state.ButterflyRenderState;
import net.invictusslayer.slayersbeasts.world.entity.Butterfly;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ButterflyRenderer extends MobRenderer<Butterfly, ButterflyRenderState, ButterflyModel> {
	private static final ResourceLocation TORTOISESHELL = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/butterfly/tortoiseshell.png");

	public ButterflyRenderer(EntityRendererProvider.Context context) {
		super(context, new ButterflyModel(context.bakeLayer(ButterflyModel.LAYER_LOCATION)), 0.25F);
	}

	@Override
	protected void scale(ButterflyRenderState state, PoseStack poseStack) {
		float f = 0.8F;
		poseStack.scale(f, f, f);
	}

	@Override
	public ResourceLocation getTextureLocation(ButterflyRenderState state) {
		return TORTOISESHELL;
	}

	public ButterflyRenderState createRenderState() {
		return new ButterflyRenderState();
	}

	public void extractRenderState(Butterfly entity, ButterflyRenderState state, float f) {
		super.extractRenderState(entity, state, f);
		state.idleAnimationState.copyFrom(entity.idleAnimationState);
		state.flyingAnimationState.copyFrom(entity.flyingAnimationState);
	}
}
