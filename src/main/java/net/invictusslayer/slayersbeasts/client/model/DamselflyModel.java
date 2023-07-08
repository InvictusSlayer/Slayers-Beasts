package net.invictusslayer.slayersbeasts.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.entity.Damselfly;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class DamselflyModel<Type extends Damselfly> extends EntityModel<Type> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SlayersBeasts.MOD_ID, "damselfly_model"), "main");
    private final ModelPart main;
    private final ModelPart leftFrontWing;
    private final ModelPart leftBackWing;
    private final ModelPart rightFrontWing;
    private final ModelPart rightBackWing;

    public DamselflyModel(ModelPart root) {
        this.main = root.getChild("main");
        this.leftFrontWing = root.getChild("leftFrontWing");
        this.leftBackWing = root.getChild("leftBackWing");
        this.rightFrontWing = root.getChild("rightFrontWing");
        this.rightBackWing = root.getChild("rightBackWing");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 15).addBox(-2.0F, 0.0F, -6.0F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(12, 17).addBox(-1.5F, -1.0F, -6.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 8).addBox(-1.5F, 0.0F, -8.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 4).addBox(-2.75F, -0.5F, -8.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-0.25F, -0.5F, -8.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.5F, -0.5F, 0.0F, 2.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 22.0F, 0.0F));

        PartDefinition leftFrontWing = partdefinition.addOrReplaceChild("leftFrontWing", CubeListBuilder.create().texOffs(14, 9).addBox(0.0F, 0.0F, -1.0F, 15.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(21, 17).addBox(7.0F, 0.0F, 2.0F, 7.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 21.0F, -4.75F, -0.1745F, -1.0908F, -1.6581F));

        PartDefinition rightFrontWing = partdefinition.addOrReplaceChild("rightFrontWing", CubeListBuilder.create().texOffs(14, 3).addBox(-15.0F, 0.0F, -1.0F, 15.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(16, 12).addBox(-14.0F, 0.0F, 2.0F, 7.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 21.0F, -4.75F, -0.1745F, 1.0908F, 1.6581F));

        PartDefinition leftBackWing = partdefinition.addOrReplaceChild("leftBackWing", CubeListBuilder.create().texOffs(14, 6).addBox(0.0F, 0.0F, -1.0F, 15.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(11, 16).addBox(7.0F, 0.0F, 2.0F, 7.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 21.5F, -2.25F, 2.9671F, -1.2217F, -1.5708F));

        PartDefinition rightBackWing = partdefinition.addOrReplaceChild("rightBackWing", CubeListBuilder.create().texOffs(14, 0).addBox(-15.0F, 0.0F, -1.0F, 15.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(11, 15).addBox(-14.0F, 0.0F, 2.0F, 7.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 21.5F, -2.25F, 3.1416F, 1.2217F, 1.6581F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(Type pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        float f1 = Mth.cos(pAgeInTicks * 3F) / 5F;
        Damselfly.DamselflyPose wingPose = pEntity.getWingPose();
        if (wingPose == Damselfly.DamselflyPose.FLYING) {
            leftFrontWing.xRot = 0;
            rightFrontWing.xRot = 0;
            leftBackWing.xRot = 0;
            rightBackWing.xRot = 0;
            leftFrontWing.yRot = Mth.PI / 18F;
            rightFrontWing.yRot = -Mth.PI / 18F;
            leftBackWing.yRot = -Mth.PI / 18F;
            rightBackWing.yRot = Mth.PI / 18F;
            leftFrontWing.zRot = 0;
            rightFrontWing.zRot = 0;
            leftBackWing.zRot = 0;
            rightBackWing.zRot = 0;
            leftFrontWing.zRot += f1;
            rightFrontWing.zRot += -f1;
            leftBackWing.zRot += -f1;
            rightBackWing.zRot += f1;
        } else if (wingPose == Damselfly.DamselflyPose.PERCHED) {
            leftFrontWing.xRot = -Mth.PI * 0.04F;
            rightFrontWing.xRot = -Mth.PI * 0.04F;
            leftBackWing.xRot = Mth.PI;
            rightBackWing.xRot = Mth.PI;
            leftFrontWing.yRot = -Mth.PI * 0.35F;
            rightFrontWing.yRot = Mth.PI * 0.35F;
            leftBackWing.yRot = -Mth.PI * 0.39F;
            rightBackWing.yRot = Mth.PI * 0.39F;
            leftFrontWing.zRot = -Mth.PI * 0.53F;
            rightFrontWing.zRot = Mth.PI * 0.53F;
            leftBackWing.zRot = -Mth.PI * 0.54F;
            rightBackWing.zRot = Mth.PI * 0.54F;
        }
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leftFrontWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leftBackWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        rightFrontWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        rightBackWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
