package net.invictusslayer.slayersbeasts.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.entity.SoldierAntEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class SoldierAntModel<Type extends SoldierAntEntity> extends EntityModel<Type> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SlayersBeasts.MOD_ID, "soldier_ant_model"), "main");
    private final ModelPart body;
    private final ModelPart leftFrontLeg;
    private final ModelPart leftMiddleLeg;
    private final ModelPart leftBackLeg;
    private final ModelPart rightFrontLeg;
    private final ModelPart rightMiddleLeg;
    private final ModelPart rightBackLeg;
    private final ModelPart leftAntenna;
    private final ModelPart rightAntenna;

    public SoldierAntModel(ModelPart root) {
        this.body = root.getChild("body");
        this.leftFrontLeg = root.getChild("leftFrontLeg");
        this.leftMiddleLeg = root.getChild("leftMiddleLeg");
        this.leftBackLeg = root.getChild("leftBackLeg");
        this.rightFrontLeg = root.getChild("rightFrontLeg");
        this.rightMiddleLeg = root.getChild("rightMiddleLeg");
        this.rightBackLeg = root.getChild("rightBackLeg");
        this.leftAntenna = root.getChild("leftAntenna");
        this.rightAntenna = root.getChild("rightAntenna");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 23.0F, 0.0F));

        PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(26, 28).addBox(-2.0F, 1.25F, 8.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 6).addBox(-3.0F, -0.5F, 7.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(14, 27).addBox(-2.5F, -0.75F, 0.0F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-4.0F, -1.25F, 1.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 6.0F, -0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.2588F, -1.9659F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -4.4635F, -11.4686F, 0.2618F, -0.2618F, 0.0F));

        PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 11).addBox(-1.0F, -1.2588F, -1.9659F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -4.4635F, -11.4686F, 0.2618F, 0.2618F, 0.0F));

        PartDefinition cube_r4 = body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 11).addBox(-3.0F, -1.0F, -7.0F, 6.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.5F, -5.0F, 0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r5 = body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 22).addBox(-1.0F, 0.0F, -5.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 6.0F, 0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r6 = body.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(18, 14).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.5F, -5.0F, -0.1745F, 0.0F, 0.0F));

        PartDefinition leftFrontLeg = partdefinition.addOrReplaceChild("leftFrontLeg", CubeListBuilder.create().texOffs(32, 16).addBox(0.0F, 0.0F, -0.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(26, 26).addBox(3.0F, -4.0F, -0.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 17.5F, -1.5F));

        PartDefinition cube_r7 = leftFrontLeg.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(32, 19).addBox(0.0F, -1.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.0F, -0.5F, 0.0F, 0.0F, -1.5708F));

        PartDefinition leftMiddleLeg = partdefinition.addOrReplaceChild("leftMiddleLeg", CubeListBuilder.create().texOffs(32, 13).addBox(0.0F, 0.0F, -0.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(9, 25).addBox(3.0F, -4.0F, -0.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 18.0F, 0.0F));

        PartDefinition cube_r8 = leftMiddleLeg.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(19, 34).addBox(0.0F, -1.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.0F, -0.5F, 0.0F, 0.0F, -1.5708F));

        PartDefinition leftBackLeg = partdefinition.addOrReplaceChild("leftBackLeg", CubeListBuilder.create().texOffs(25, 31).addBox(0.0F, 0.0F, -0.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 4).addBox(3.0F, -4.0F, -0.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 18.5F, 1.5F));

        PartDefinition cube_r9 = leftBackLeg.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(9, 22).addBox(0.0F, -1.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.0F, -0.5F, 0.0F, 0.0F, -1.5708F));

        PartDefinition rightFrontLeg = partdefinition.addOrReplaceChild("rightFrontLeg", CubeListBuilder.create().texOffs(10, 32).addBox(-4.0F, 0.0F, -0.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(19, 11).addBox(-11.0F, -4.0F, -0.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 17.5F, -1.5F));

        PartDefinition cube_r10 = rightFrontLeg.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(27, 34).addBox(-3.0F, -1.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, -0.5F, 0.0F, 0.0F, 1.5708F));

        PartDefinition rightMiddleLeg = partdefinition.addOrReplaceChild("rightMiddleLeg", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0F, 0.0F, -0.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 0).addBox(-11.0F, -4.0F, -0.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 18.0F, 0.0F));

        PartDefinition cube_r11 = rightMiddleLeg.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(34, 33).addBox(-3.0F, -1.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, -0.5F, 0.0F, 0.0F, 1.5708F));

        PartDefinition rightBackLeg = partdefinition.addOrReplaceChild("rightBackLeg", CubeListBuilder.create().texOffs(0, 29).addBox(-4.0F, 0.0F, -0.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 2).addBox(-11.0F, -4.0F, -0.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 18.5F, 1.5F));

        PartDefinition cube_r12 = rightBackLeg.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 35).addBox(-3.0F, -1.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, -0.5F, 0.0F, 0.0F, 1.5708F));

        PartDefinition leftAntenna = partdefinition.addOrReplaceChild("leftAntenna", CubeListBuilder.create(), PartPose.offset(0.0F, 15.25F, -8.0F));

        PartDefinition cube_r13 = leftAntenna.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(16, 35).addBox(0.0F, -4.75F, 0.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, 0.25F, -0.75F, 0.6981F, -0.0873F, 0.1745F));

        PartDefinition cube_r14 = leftAntenna.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(8, 35).addBox(-0.1148F, -5.3024F, -1.0981F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.25F, -3.75F, -2.75F, 1.3963F, -0.2618F, 0.1745F));

        PartDefinition rightAntenna = partdefinition.addOrReplaceChild("rightAntenna", CubeListBuilder.create(), PartPose.offset(0.0F, 15.75F, -8.0F));

        PartDefinition cube_r15 = rightAntenna.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(34, 35).addBox(-1.0F, -4.75F, 0.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -0.25F, -0.75F, 0.6981F, 0.0873F, -0.1745F));

        PartDefinition cube_r16 = rightAntenna.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(12, 35).addBox(-0.8852F, -5.3024F, -1.0981F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.25F, -4.25F, -2.75F, 1.3963F, 0.2618F, -0.1745F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(Type entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float f1 = Mth.sin(ageInTicks / 6F) / 24F;
        float f2 = Mth.cos(limbSwing * 2) * limbSwingAmount;
        double f3 = Math.pow(Mth.cos(limbSwing + Mth.PI * 0.25F), 6D) * limbSwingAmount;
        double f4 = Math.pow(Mth.sin(limbSwing + Mth.PI * 0.25F), 6D) * limbSwingAmount;
        leftAntenna.xRot = f1;
        rightAntenna.xRot = -f1;
        leftFrontLeg.xRot = Mth.PI * 0.2F;
        rightFrontLeg.xRot = Mth.PI * 0.2F;
        leftBackLeg.xRot = -Mth.PI * 0.2F;
        rightBackLeg.xRot = -Mth.PI * 0.2F;
        leftFrontLeg.yRot = Mth.PI * 0.2F;
        rightFrontLeg.yRot = -Mth.PI * 0.2F;
        leftMiddleLeg.yRot = 0F;
        rightMiddleLeg.yRot = 0F;
        leftBackLeg.yRot = -Mth.PI * 0.2F;
        rightBackLeg.yRot = Mth.PI * 0.2F;
        leftFrontLeg.zRot = Mth.PI * 0.4F;
        rightFrontLeg.zRot = -Mth.PI * 0.4F;
        leftMiddleLeg.zRot = Mth.PI * 0.28F;
        rightMiddleLeg.zRot = -Mth.PI * 0.28F;
        leftBackLeg.zRot = Mth.PI * 0.35F;
        rightBackLeg.zRot = -Mth.PI * 0.35F;
        leftFrontLeg.yRot += -f2;
        rightFrontLeg.yRot += -f2;
        leftMiddleLeg.yRot += f2;
        rightMiddleLeg.yRot += f2;
        leftBackLeg.yRot += -f2;
        rightBackLeg.yRot += -f2;
        leftFrontLeg.zRot += -f4;
        rightFrontLeg.zRot += f3;
        leftMiddleLeg.zRot += -f3;
        rightMiddleLeg.zRot += f4;
        leftBackLeg.zRot += -f4;
        rightBackLeg.zRot += f3;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leftFrontLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leftMiddleLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leftBackLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        rightFrontLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        rightMiddleLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        rightBackLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leftAntenna.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        rightAntenna.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
