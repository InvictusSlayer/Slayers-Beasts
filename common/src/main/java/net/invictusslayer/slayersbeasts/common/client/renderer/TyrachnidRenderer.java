package net.invictusslayer.slayersbeasts.common.client.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.client.model.TyrachnidModel;
import net.invictusslayer.slayersbeasts.common.entity.Tyrachnid;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
public class TyrachnidRenderer<T extends Tyrachnid> extends MobRenderer<T, TyrachnidModel<T>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/tyrachnid.png");

	public TyrachnidRenderer(EntityRendererProvider.Context context) {
		super(context, new TyrachnidModel<>(context.bakeLayer(TyrachnidModel.LAYER_LOCATION)), 2F);
	}

	public ResourceLocation getTextureLocation(T entity) {
		return TEXTURE;
	}
}
