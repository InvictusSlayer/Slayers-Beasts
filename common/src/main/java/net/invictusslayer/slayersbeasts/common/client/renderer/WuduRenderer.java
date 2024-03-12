package net.invictusslayer.slayersbeasts.common.client.renderer;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.client.model.WuduModel;
import net.invictusslayer.slayersbeasts.common.entity.Wudu;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WuduRenderer<T extends Wudu> extends MobRenderer<T, WuduModel<T>> {
	private static final ResourceLocation OAK = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/ent/wudu/oak.png");
	private static final ResourceLocation BIRCH = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/ent/wudu/birch.png");
	private static final ResourceLocation JUNGLE = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/ent/wudu/jungle.png");

	public WuduRenderer(EntityRendererProvider.Context context) {
		super(context, new WuduModel<>(context.bakeLayer(WuduModel.LAYER_LOCATION)), 0.5F);
	}

	public ResourceLocation getTextureLocation(T entity) {
		return switch (entity.getVariant()) {
			default -> OAK;
			case BIRCH -> BIRCH;
			case JUNGLE -> JUNGLE;
		};
	}
}
