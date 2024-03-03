package net.invictusslayer.slayersbeasts.client.renderer;

import net.invictusslayer.slayersbeasts.client.model.SporetrapModel;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.entity.Sporetrap;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SporetrapRenderer<T extends Sporetrap> extends MobRenderer<T, SporetrapModel<T>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/sporetrap.png");

	public SporetrapRenderer(EntityRendererProvider.Context context) {
		super(context, new SporetrapModel<>(context.bakeLayer(SporetrapModel.LAYER_LOCATION)), 0.5F);
	}

	public ResourceLocation getTextureLocation(T entity) {
		return TEXTURE;
	}
}
