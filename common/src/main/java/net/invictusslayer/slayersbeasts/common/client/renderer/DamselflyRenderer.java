package net.invictusslayer.slayersbeasts.common.client.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.client.model.DamselflyModel;
import net.invictusslayer.slayersbeasts.common.client.state.DamselflyRenderState;
import net.invictusslayer.slayersbeasts.common.entity.Damselfly;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
public class DamselflyRenderer extends MobRenderer<Damselfly, DamselflyRenderState, DamselflyModel> {
	private static final ResourceLocation BLUE = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/damselfly/blue.png");
	private static final ResourceLocation GREEN = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/damselfly/green.png");
	private static final ResourceLocation YELLOW = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/damselfly/yellow.png");

	public DamselflyRenderer(EntityRendererProvider.Context context) {
		super(context, new DamselflyModel(context.bakeLayer(DamselflyModel.LAYER_LOCATION)), 0.5F);
	}

	public ResourceLocation getTextureLocation(DamselflyRenderState state) {
		return switch (state.variant) {
			case BLUE -> BLUE;
			case GREEN -> GREEN;
			case YELLOW -> YELLOW;
		};
	}

	public DamselflyRenderState createRenderState() {
		return new DamselflyRenderState();
	}

	public void extractRenderState(Damselfly entity, DamselflyRenderState state, float f) {
		super.extractRenderState(entity, state, f);
		state.variant = entity.getVariant();
		state.flyAnimationState.copyFrom(entity.flyAnimationState);
		state.perchAnimationState.copyFrom(entity.perchAnimationState);
	}
}
