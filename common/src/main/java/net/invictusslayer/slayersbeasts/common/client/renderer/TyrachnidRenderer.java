package net.invictusslayer.slayersbeasts.common.client.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.client.model.TyrachnidModel;
import net.invictusslayer.slayersbeasts.common.entity.Tyrachnid;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
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
