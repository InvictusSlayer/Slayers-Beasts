package net.invictusslayer.slayersbeasts.client.renderer;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.MantisModel;
import net.invictusslayer.slayersbeasts.entity.Mantis;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MantisRenderer<T extends Mantis> extends MobRenderer<T, MantisModel<T>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/mantis.png");

	public MantisRenderer(EntityRendererProvider.Context context) {
		super(context, new MantisModel<>(context.bakeLayer(MantisModel.LAYER_LOCATION)), 1.2F);
	}

	public ResourceLocation getTextureLocation(T entity) {
		return TEXTURE;
	}
}
