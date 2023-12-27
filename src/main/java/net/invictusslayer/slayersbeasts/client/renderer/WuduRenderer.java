package net.invictusslayer.slayersbeasts.client.renderer;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.WuduModel;
import net.invictusslayer.slayersbeasts.entity.SBEntities;
import net.invictusslayer.slayersbeasts.entity.Wudu;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WuduRenderer<T extends Wudu> extends MobRenderer<T, WuduModel<T>> {
	private static final ResourceLocation OAK = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/ent/wudu/oak.png");
	private static final ResourceLocation BIRCH = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/ent/wudu/birch.png");

	public WuduRenderer(EntityRendererProvider.Context context) {
		super(context, new WuduModel<>(context.bakeLayer(WuduModel.LAYER_LOCATION)), 0.5F);
	}

	public ResourceLocation getTextureLocation(T entity) {
		if (entity.getType() == SBEntities.WUDU_OAK.get()) return OAK;
		return BIRCH;
	}
}
