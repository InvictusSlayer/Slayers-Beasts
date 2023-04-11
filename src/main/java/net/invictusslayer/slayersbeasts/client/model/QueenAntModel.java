package net.invictusslayer.slayersbeasts.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.entity.QueenAntEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class QueenAntModel<Type extends QueenAntEntity> extends EntityModel<Type> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SlayersBeasts.MOD_ID, "queen_ant_model"), "main");
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart leftFrontLeg;
    private final ModelPart leftMiddleLeg;
    private final ModelPart leftBackLeg;
    private final ModelPart rightFrontLeg;
    private final ModelPart rightMiddleLeg;
    private final ModelPart rightBackLeg;

    public QueenAntModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = root.getChild("head");
        this.leftFrontLeg = root.getChild("leftFrontLeg");
        this.leftMiddleLeg = root.getChild("leftMiddleLeg");
        this.leftBackLeg = root.getChild("leftBackLeg");
        this.rightFrontLeg = root.getChild("rightFrontLeg");
        this.rightMiddleLeg = root.getChild("rightMiddleLeg");
        this.rightBackLeg = root.getChild("rightBackLeg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(47, 44).addBox(-2.0F, -2.5F, -12.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-2.5F, -5.0F, -10.0F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 23).addBox(-3.5F, -7.5F, -9.0F, 7.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(32, 33).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 3.0F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(33, 0).addBox(-4.0F, -1.0F, 0.0F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-5.0F, -2.0F, 1.0F, 10.0F, 10.0F, 13.0F, new CubeDeformation(0.0F))
                .texOffs(32, 23).addBox(-4.0F, -0.5F, 14.0F, 8.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 3.0F, -0.1745F, 0.0F, 0.0F));

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 40).addBox(-3.0F, 0.0F, -2.75F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(33, 44).addBox(-2.0F, 3.0F, -2.75F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 16.0F, -10.0F, -0.7418F, 0.0F, 0.0F));

        PartDefinition cube_r4 = head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 10).addBox(0.0F, 0.0F, -0.25F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 5.0F, -2.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r5 = head.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(6, 10).addBox(-1.0F, 0.0F, -0.25F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 5.0F, -2.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r6 = head.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(23, 23).addBox(-0.5448F, -4.6513F, -1.0582F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -4.0F, -4.0F, 1.7017F, 0.0F, -0.1309F));

        PartDefinition cube_r7 = head.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(27, 23).addBox(0.0F, -5.0F, -0.75F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.7854F, -0.4363F, 0.0F));

        PartDefinition cube_r8 = head.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 23).addBox(-0.4552F, -4.6513F, -1.0582F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -4.0F, -4.0F, 1.7017F, 0.0F, 0.1309F));

        PartDefinition cube_r9 = head.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(4, 23).addBox(-1.0F, -5.0F, -0.75F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.7854F, 0.4363F, 0.0F));

        PartDefinition leftFrontLeg = partdefinition.addOrReplaceChild("leftFrontLeg", CubeListBuilder.create().texOffs(48, 35).addBox(-0.5F, 0.0F, -0.5F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(49, 39).addBox(2.25F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(44, 33).addBox(2.25F, -4.0F, 0.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 18.0F, -8.0F, 0.6981F, 0.4363F, 1.0908F));

        PartDefinition leftMiddleLeg = partdefinition.addOrReplaceChild("leftMiddleLeg", CubeListBuilder.create().texOffs(46, 17).addBox(-0.5F, 0.0F, -0.5F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(36, 49).addBox(3.25F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(18, 44).addBox(3.25F, -4.0F, 0.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 18.25F, -5.0F, 0.0F, 0.0F, 0.829F));

        PartDefinition leftBackLeg = partdefinition.addOrReplaceChild("leftBackLeg", CubeListBuilder.create().texOffs(14, 46).addBox(-0.5F, 0.0F, -0.5F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(46, 48).addBox(3.25F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(33, 11).addBox(3.25F, -5.0F, 0.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 18.25F, -2.0F, -0.48F, -0.6109F, 1.0036F));

        PartDefinition rightFrontLeg = partdefinition.addOrReplaceChild("rightFrontLeg", CubeListBuilder.create().texOffs(0, 6).addBox(-3.5F, 0.0F, -0.5F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(32, 49).addBox(-3.25F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(32, 42).addBox(-10.25F, -4.0F, 0.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 18.0F, -8.0F, 0.6981F, -0.4363F, -1.0908F));

        PartDefinition rightMiddleLeg = partdefinition.addOrReplaceChild("rightMiddleLeg", CubeListBuilder.create().texOffs(46, 13).addBox(-4.5F, 0.0F, -0.5F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(32, 33).addBox(-4.25F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(15, 41).addBox(-11.25F, -4.0F, 0.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 18.25F, -5.0F, 0.0F, 0.0F, -0.829F));

        PartDefinition rightBackLeg = partdefinition.addOrReplaceChild("rightBackLeg", CubeListBuilder.create().texOffs(0, 46).addBox(-4.5F, 0.0F, -0.5F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(28, 46).addBox(-4.25F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(33, 9).addBox(-13.25F, -5.0F, 0.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 18.25F, -2.0F, -0.48F, 0.6109F, -1.0036F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(Type entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float f1 = Mth.cos(limbSwing * 2) * limbSwingAmount;
        double d1 = Math.pow(Mth.cos(limbSwing + Mth.PI * 0.25F), 6D) * limbSwingAmount;
        double d2 = Math.pow(Mth.sin(limbSwing + Mth.PI * 0.25F), 6D) * limbSwingAmount;
        float a1 = Mth.PI * 0.22F;
        float a2 = Mth.PI * 0.14F;
        float a3 = Mth.PI * 0.35F;
        float a4 = Mth.PI * 0.26F;
        float a5 = Mth.PI * 0.15F;
        float a6 = Mth.PI * 0.19F;
        float a7 = Mth.PI * 0.32F;
        leftFrontLeg.xRot = a1;
        rightFrontLeg.xRot = a1;
        leftMiddleLeg.xRot = 0;
        rightMiddleLeg.xRot = 0;
        leftBackLeg.xRot = -a5;
        rightBackLeg.xRot = -a5;
        leftFrontLeg.yRot = a2;
        rightFrontLeg.yRot = -a2;
        leftMiddleLeg.yRot = 0;
        rightMiddleLeg.yRot = 0;
        leftBackLeg.yRot = -a6;
        rightBackLeg.yRot = a6;
        leftFrontLeg.zRot = a3;
        rightFrontLeg.zRot = -a3;
        leftMiddleLeg.zRot = a4;
        rightMiddleLeg.zRot = -a4;
        leftBackLeg.zRot = a7;
        rightBackLeg.zRot = -a7;

        leftFrontLeg.yRot += -f1;
        rightFrontLeg.yRot += -f1;
        leftMiddleLeg.yRot += f1;
        rightMiddleLeg.yRot += f1;
        leftBackLeg.yRot += -f1;
        rightBackLeg.yRot += -f1;
        leftFrontLeg.zRot += -d2;
        rightFrontLeg.zRot += d1;
        leftMiddleLeg.zRot += -d1;
        rightMiddleLeg.zRot += d2;
        leftBackLeg.zRot += -d2;
        rightBackLeg.zRot += d1;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leftFrontLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leftMiddleLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leftBackLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        rightFrontLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        rightMiddleLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        rightBackLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
