package net.invictusslayer.slayersbeasts.client.renderer.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.AntCargoModel;
import net.invictusslayer.slayersbeasts.client.model.AntWorkerModel;
import net.invictusslayer.slayersbeasts.entity.AntWorker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class AntCargoLayer<T extends AntWorker> extends RenderLayer<T, AntWorkerModel<T>> {
    private static final ResourceLocation LEAF = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/ant/cargo/leaf.png");
    private static final ResourceLocation BARK = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/ant/cargo/bark.png");
    private final AntCargoModel<T> model;

    public AntCargoLayer(RenderLayerParent<T, AntWorkerModel<T>> parent, EntityModelSet modelSet) {
        super(parent);
        this.model = new AntCargoModel<>(modelSet.bakeLayer(AntCargoModel.LAYER_LOCATION));
    }

    public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, T entity, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entity.getCargoType() != 99) {
            if (entity.isInvisible()) {
                Minecraft minecraft = Minecraft.getInstance();
                boolean flag = minecraft.shouldEntityAppearGlowing(entity);
                if (flag) {
                    this.getParentModel().copyPropertiesTo(this.model);
                    this.model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTick);
                    this.model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                    VertexConsumer vertexconsumer = bufferSource.getBuffer(RenderType.outline(LEAF));
                    this.model.renderToBuffer(poseStack, vertexconsumer, packedLight, LivingEntityRenderer.getOverlayCoords(entity, 0.0F), 0.0F, 0.0F, 0.0F, 1.0F);
                }
            } else {
                if (entity.getCargoType() == 1) {
                    renderColoredCutoutModel(this.model, LEAF, poseStack, bufferSource, packedLight, entity, 1.0F, 1.0F, 1.0F);
                } else if (entity.getCargoType() == 2) {
                    renderColoredCutoutModel(this.model, BARK, poseStack, bufferSource, packedLight, entity, 1.0F, 1.0F, 1.0F);
                }
            }
        }
    }
}
