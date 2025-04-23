package net.invictusslayer.slayersbeasts.common.client.renderer.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.client.model.AntCargoModel;
import net.invictusslayer.slayersbeasts.common.client.model.AntWorkerModel;
import net.invictusslayer.slayersbeasts.common.entity.AntWorker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
public class AntCargoLayer<T extends AntWorker> extends RenderLayer<T, AntWorkerModel<T>> {
	private static final ResourceLocation LEAF = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/ant/cargo/leaf.png");
	private static final ResourceLocation BARK = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/ant/cargo/bark.png");
	private final AntCargoModel<T> model;

	public AntCargoLayer(RenderLayerParent<T, AntWorkerModel<T>> parent, EntityModelSet set) {
		super(parent);
		model = new AntCargoModel<>(set.bakeLayer(AntCargoModel.LAYER_LOCATION));
	}

	public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, T entity, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {
		if (entity.getCargoType() == 99) return;

        if (entity.isInvisible() && Minecraft.getInstance().shouldEntityAppearGlowing(entity)) {
            getParentModel().copyPropertiesTo(model);
            model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTick);
            model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            VertexConsumer consumer = bufferSource.getBuffer(RenderType.outline(LEAF));
            model.renderToBuffer(poseStack, consumer, packedLight, LivingEntityRenderer.getOverlayCoords(entity, 0.0F));
			return;
        }

        if (entity.getCargoType() == 1) {
            renderColoredCutoutModel(model, LEAF, poseStack, bufferSource, packedLight, entity, -1);
        } else if (entity.getCargoType() == 2) {
            renderColoredCutoutModel(model, BARK, poseStack, bufferSource, packedLight, entity, -1);
        }
	}
}
