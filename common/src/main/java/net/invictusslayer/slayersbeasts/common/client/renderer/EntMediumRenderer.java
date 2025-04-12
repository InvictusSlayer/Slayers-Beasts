package net.invictusslayer.slayersbeasts.common.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.client.model.EntMediumModel;
import net.invictusslayer.slayersbeasts.common.client.state.EntRenderState;
import net.invictusslayer.slayersbeasts.common.entity.EntMedium;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
public class EntMediumRenderer extends MobRenderer<EntMedium, EntRenderState, EntMediumModel> {
	private static final ResourceLocation OAK = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/ent/oak.png");
	private static final ResourceLocation BIRCH = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/ent/birch.png");
	private static final ResourceLocation JUNGLE = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/ent/jungle.png");

	public EntMediumRenderer(EntityRendererProvider.Context context) {
		super(context, new EntMediumModel(context.bakeLayer(EntMediumModel.LAYER_LOCATION)), 0.9F);
	}

	protected void scale(EntRenderState state, PoseStack poseStack) {
		float f = 1.2F;
		poseStack.scale(f, f, f);
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

	public void extractRenderState(EntMedium entity, EntRenderState state, float f) {
		super.extractRenderState(entity, state, f);
		state.variant = entity.getVariant();
	}
}
