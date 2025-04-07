package net.invictusslayer.slayersbeasts.common.client.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.client.model.WuduModel;
import net.invictusslayer.slayersbeasts.common.entity.Wudu;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
public class WuduRenderer extends MobRenderer<Wudu, LivingEntityRenderState, WuduModel> {
	private static final ResourceLocation OAK = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/ent/wudu/oak.png");
	private static final ResourceLocation BIRCH = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/ent/wudu/birch.png");
	private static final ResourceLocation JUNGLE = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/ent/wudu/jungle.png");

	public WuduRenderer(EntityRendererProvider.Context context) {
		super(context, new WuduModel(context.bakeLayer(WuduModel.LAYER_LOCATION)), 0.5F);
	}

	public ResourceLocation getTextureLocation(LivingEntityRenderState state) {
		return OAK;
	}

	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}
}
