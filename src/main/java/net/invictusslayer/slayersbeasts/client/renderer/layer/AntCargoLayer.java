package net.invictusslayer.slayersbeasts.client.renderer.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.AntCargoModel;
import net.invictusslayer.slayersbeasts.client.model.AntWorkerModel;
import net.invictusslayer.slayersbeasts.client.state.AntWorkerRenderState;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
//$ client_env {
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)//$}
public class AntCargoLayer extends RenderLayer<AntWorkerRenderState, AntWorkerModel> {
	private static final ResourceLocation LEAF = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/ant/cargo/leaf.png");
	private static final ResourceLocation BARK = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/ant/cargo/bark.png");
	private final AntCargoModel model;

	public AntCargoLayer(RenderLayerParent<AntWorkerRenderState, AntWorkerModel> parent, EntityModelSet set) {
		super(parent);
		model = new AntCargoModel(set.bakeLayer(AntCargoModel.LAYER_LOCATION));
	}

	public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, AntWorkerRenderState state, float netHeadYaw, float headPitch) {
		if (state.cargo == 99) return;

        if (state.isInvisible && state.appearsGlowing) {
            model.setupAnim(state);
            VertexConsumer consumer = bufferSource.getBuffer(RenderType.outline(LEAF));
            model.renderToBuffer(poseStack, consumer, packedLight, LivingEntityRenderer.getOverlayCoords(state, 0.0F));
			return;
        }

        if (state.cargo == 1) {
            renderColoredCutoutModel(model, LEAF, poseStack, bufferSource, packedLight, state, -1);
        } else if (state.cargo == 2) {
            renderColoredCutoutModel(model, BARK, poseStack, bufferSource, packedLight, state, -1);
        }
	}
}
