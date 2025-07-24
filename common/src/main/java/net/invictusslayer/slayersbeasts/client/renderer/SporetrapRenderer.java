package net.invictusslayer.slayersbeasts.client.renderer;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.SporetrapModel;
import net.invictusslayer.slayersbeasts.entity.Sporetrap;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.ResourceLocation;

public class SporetrapRenderer extends MobRenderer<Sporetrap, LivingEntityRenderState, SporetrapModel> {
	private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/sporetrap.png");

	public SporetrapRenderer(EntityRendererProvider.Context context) {
		super(context, new SporetrapModel(context.bakeLayer(SporetrapModel.LAYER_LOCATION)), 0.5F);
	}

	public ResourceLocation getTextureLocation(LivingEntityRenderState state) {
		return TEXTURE;
	}

	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}
}
