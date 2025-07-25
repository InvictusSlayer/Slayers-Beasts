package net.invictusslayer.slayersbeasts.client.renderer;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.WuduModel;
import net.invictusslayer.slayersbeasts.client.state.EntRenderState;
import net.invictusslayer.slayersbeasts.entity.Wudu;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WuduRenderer extends MobRenderer<Wudu, EntRenderState, WuduModel> {
	private static final ResourceLocation OAK = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/ent/wudu/oak.png");
	private static final ResourceLocation BIRCH = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/ent/wudu/birch.png");
	private static final ResourceLocation JUNGLE = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/ent/wudu/jungle.png");

	public WuduRenderer(EntityRendererProvider.Context context) {
		super(context, new WuduModel(context.bakeLayer(WuduModel.LAYER_LOCATION)), 0.5F);
	}

	public ResourceLocation getTextureLocation(EntRenderState state) {
		return switch (state.variant) {
			case OAK -> OAK;
			case BIRCH -> BIRCH;
			case JUNGLE -> JUNGLE;
		};
	}

	public EntRenderState createRenderState() {
		return new EntRenderState();
	}

	public void extractRenderState(Wudu entity, EntRenderState state, float f) {
		super.extractRenderState(entity, state, f);
		state.variant = entity.getVariant();
	}
}
