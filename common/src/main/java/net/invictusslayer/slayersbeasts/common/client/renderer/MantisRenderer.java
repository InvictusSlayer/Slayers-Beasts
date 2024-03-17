package net.invictusslayer.slayersbeasts.common.client.renderer;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.client.model.MantisModel;
import net.invictusslayer.slayersbeasts.common.entity.Mantis;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MantisRenderer<T extends Mantis> extends MobRenderer<T, MantisModel<T>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/mantis.png");

	public MantisRenderer(EntityRendererProvider.Context context) {
		super(context, new MantisModel<>(context.bakeLayer(MantisModel.LAYER_LOCATION)), 1.2F);
	}

	public ResourceLocation getTextureLocation(T entity) {
		return TEXTURE;
	}
}
