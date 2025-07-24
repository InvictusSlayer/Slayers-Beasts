package net.invictusslayer.slayersbeasts.client.renderer;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.MantisModel;
import net.invictusslayer.slayersbeasts.client.state.MantisRenderState;
import net.invictusslayer.slayersbeasts.entity.Mantis;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MantisRenderer extends MobRenderer<Mantis, MantisRenderState, MantisModel> {
	private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/mantis.png");

	public MantisRenderer(EntityRendererProvider.Context context) {
		super(context, new MantisModel(context.bakeLayer(MantisModel.LAYER_LOCATION)), 1.2F);
	}

	public ResourceLocation getTextureLocation(MantisRenderState state) {
		return TEXTURE;
	}

	public MantisRenderState createRenderState() {
		return new MantisRenderState();
	}

	public void extractRenderState(Mantis entity, MantisRenderState state, float f) {
		super.extractRenderState(entity, state, f);
		state.isScuttling = entity.isScuttling();
		state.flapAnimationState.copyFrom(entity.flapAnimationState);
		state.strikeAnimationState.copyFrom(entity.strikeAnimationState);
	}
}
