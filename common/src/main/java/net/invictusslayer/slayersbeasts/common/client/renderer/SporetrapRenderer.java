package net.invictusslayer.slayersbeasts.common.client.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.client.model.SporetrapModel;
import net.invictusslayer.slayersbeasts.common.entity.Sporetrap;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
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
