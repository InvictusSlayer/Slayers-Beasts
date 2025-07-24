package net.invictusslayer.slayersbeasts.client.renderer;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.TyrachnidModel;
import net.invictusslayer.slayersbeasts.entity.Tyrachnid;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.ResourceLocation;

public class TyrachnidRenderer extends MobRenderer<Tyrachnid, LivingEntityRenderState, TyrachnidModel> {
	private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/tyrachnid.png");

	public TyrachnidRenderer(EntityRendererProvider.Context context) {
		super(context, new TyrachnidModel(context.bakeLayer(TyrachnidModel.LAYER_LOCATION)), 2F);
	}

	public ResourceLocation getTextureLocation(LivingEntityRenderState state) {
		return TEXTURE;
	}

	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}
}
