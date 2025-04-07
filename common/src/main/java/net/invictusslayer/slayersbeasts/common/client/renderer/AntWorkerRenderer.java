package net.invictusslayer.slayersbeasts.common.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.client.model.AntWorkerModel;
import net.invictusslayer.slayersbeasts.common.client.renderer.layer.AntCargoLayer;
import net.invictusslayer.slayersbeasts.common.client.state.AntWorkerRenderState;
import net.invictusslayer.slayersbeasts.common.entity.AntWorker;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
public class AntWorkerRenderer extends MobRenderer<AntWorker, AntWorkerRenderState, AntWorkerModel> {
	private static final ResourceLocation WOOD = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/ant/wood_worker.png");
	private static final ResourceLocation LEAFCUTTER = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/ant/leafcutter_worker.png");
	private static final ResourceLocation MEADOW = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/ant/meadow_worker.png");

	public AntWorkerRenderer(EntityRendererProvider.Context context) {
		super(context, new AntWorkerModel(context.bakeLayer(AntWorkerModel.LAYER_LOCATION)), 0.3F);
		addLayer(new AntCargoLayer(this, context.getModelSet()));
	}

	protected void scale(AntWorkerRenderState state, PoseStack poseStack) {
		float f = 1.2F;
		poseStack.scale(f, f, f);
	}

	public ResourceLocation getTextureLocation(AntWorkerRenderState state) {
		return state.texture;
	}

	public AntWorkerRenderState createRenderState() {
		return new AntWorkerRenderState();
	}
}
