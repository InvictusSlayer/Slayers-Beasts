package net.invictusslayer.slayersbeasts.client.renderer.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.AntCargoModel;
import net.invictusslayer.slayersbeasts.client.model.WorkerAntModel;
import net.invictusslayer.slayersbeasts.entity.WorkerAnt;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

public class AntCargoLayer extends RenderLayer<WorkerAnt, WorkerAntModel<WorkerAnt>> {
    private static final ResourceLocation LEAF_TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/cargo_leaf.png");
    private static final ResourceLocation BARK_TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/cargo_bark.png");
    private final AntCargoModel<WorkerAnt> model;

    public AntCargoLayer(RenderLayerParent<WorkerAnt, WorkerAntModel<WorkerAnt>> pRenderer, EntityModelSet modelSet) {
        super(pRenderer);
        this.model = new AntCargoModel<>(modelSet.bakeLayer(AntCargoModel.LAYER_LOCATION));
    }

    @Override
    public void render(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, WorkerAnt pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTick, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        if (pLivingEntity.getCargoType() != 99) {
            if (pLivingEntity.isInvisible()) {
                Minecraft minecraft = Minecraft.getInstance();
                boolean flag = minecraft.shouldEntityAppearGlowing(pLivingEntity);
                if (flag) {
                    this.getParentModel().copyPropertiesTo(this.model);
                    this.model.prepareMobModel(pLivingEntity, pLimbSwing, pLimbSwingAmount, pPartialTick);
                    this.model.setupAnim(pLivingEntity, pLimbSwing, pLimbSwingAmount, pAgeInTicks, pNetHeadYaw, pHeadPitch);
                    VertexConsumer vertexconsumer = pBuffer.getBuffer(RenderType.outline(LEAF_TEXTURE));
                    this.model.renderToBuffer(pPoseStack, vertexconsumer, pPackedLight, LivingEntityRenderer.getOverlayCoords(pLivingEntity, 0.0F), 0.0F, 0.0F, 0.0F, 1.0F);
                }

            } else {
                if (pLivingEntity.getCargoType() == 1) {
                    renderColoredCutoutModel(this.model, LEAF_TEXTURE, pPoseStack, pBuffer, pPackedLight, pLivingEntity, 1.0F, 1.0F, 1.0F);
                } else if (pLivingEntity.getCargoType() == 2) {
                    renderColoredCutoutModel(this.model, BARK_TEXTURE, pPoseStack, pBuffer, pPackedLight, pLivingEntity, 1.0F, 1.0F, 1.0F);
                }
            }
        }
    }
}
