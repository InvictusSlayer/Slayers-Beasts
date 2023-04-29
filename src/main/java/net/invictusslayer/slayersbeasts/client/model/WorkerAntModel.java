package net.invictusslayer.slayersbeasts.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.entity.WorkerAnt;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class WorkerAntModel<Type extends WorkerAnt> extends EntityModel<Type> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SlayersBeasts.MOD_ID, "worker_ant_model"), "main");
    private final ModelPart body;
    private final ModelPart leftFrontLeg;
    private final ModelPart leftMiddleLeg;
    private final ModelPart leftBackLeg;
    private final ModelPart rightFrontLeg;
    private final ModelPart rightMiddleLeg;
    private final ModelPart rightBackLeg;

    public WorkerAntModel(ModelPart root) {
        this.body = root.getChild("body");
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

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(8, 9).addBox(-1.0F, -4.0F, -2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 7).addBox(-1.5F, -4.5F, -5.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-2.0F, -4.5F, 2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(16, 9).addBox(-1.0F, -3.75F, 6.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -2.75F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, -4.5F, -2.75F, 0.3381F, -0.0886F, 0.2467F));

        PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 17).addBox(-1.0F, -2.75F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -4.5F, -2.75F, 0.3381F, 0.0886F, -0.2467F));

        PartDefinition leftFrontLeg = partdefinition.addOrReplaceChild("leftFrontLeg", CubeListBuilder.create().texOffs(16, 4).addBox(-0.25F, 0.0F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 20.5F, -1.25F));

        PartDefinition leftMiddleLeg = partdefinition.addOrReplaceChild("leftMiddleLeg", CubeListBuilder.create().texOffs(12, 15).addBox(-0.25F, 0.0F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 20.5F, 0.0F));

        PartDefinition leftBackLeg = partdefinition.addOrReplaceChild("leftBackLeg", CubeListBuilder.create().texOffs(12, 0).addBox(-0.25F, 0.0F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 20.5F, 1.25F));

        PartDefinition rightFrontLeg = partdefinition.addOrReplaceChild("rightFrontLeg", CubeListBuilder.create().texOffs(0, 15).addBox(-4.75F, 0.0F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 20.5F, -1.25F));

        PartDefinition rightMiddleLeg = partdefinition.addOrReplaceChild("rightMiddleLeg", CubeListBuilder.create().texOffs(12, 2).addBox(-4.75F, 0.0F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 20.5F, 0.0F));

        PartDefinition rightBackLeg = partdefinition.addOrReplaceChild("rightBackLeg", CubeListBuilder.create().texOffs(9, 7).addBox(-4.75F, 0.0F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 20.5F, 1.25F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(Type pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        float f1 = Mth.cos(pLimbSwing * 2) * pLimbSwingAmount;
        double d1 = Math.pow(Mth.cos(pLimbSwing + Mth.PI * 0.25F), 6D) * pLimbSwingAmount;
        double d2 = Math.pow(Mth.sin(pLimbSwing + Mth.PI * 0.25F), 6D) * pLimbSwingAmount;
        float a1 = Mth.PI * 0.08F;
        float a2 = Mth.PI * 0.11F;
        float a3 = Mth.PI * 0.21F;
        float a4 = Mth.PI * 0.19F;
        leftFrontLeg.xRot = a1;
        rightFrontLeg.xRot = a1;
        leftMiddleLeg.xRot = 0;
        rightMiddleLeg.xRot = 0;
        leftBackLeg.xRot = -a1;
        rightBackLeg.xRot = -a1;
        leftFrontLeg.yRot = a2;
        rightFrontLeg.yRot = -a2;
        leftMiddleLeg.yRot = 0;
        rightMiddleLeg.yRot = 0;
        leftBackLeg.yRot = -a2;
        rightBackLeg.yRot = a2;
        leftFrontLeg.zRot = a3;
        rightFrontLeg.zRot = -a3;
        leftMiddleLeg.zRot = a4;
        rightMiddleLeg.zRot = -a4;
        leftBackLeg.zRot = a3;
        rightBackLeg.zRot = -a3;

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
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(poseStack, buffer, packedLight, packedOverlay);
        leftFrontLeg.render(poseStack, buffer, packedLight, packedOverlay);
        leftMiddleLeg.render(poseStack, buffer, packedLight, packedOverlay);
        leftBackLeg.render(poseStack, buffer, packedLight, packedOverlay);
        rightFrontLeg.render(poseStack, buffer, packedLight, packedOverlay);
        rightMiddleLeg.render(poseStack, buffer, packedLight, packedOverlay);
        rightBackLeg.render(poseStack, buffer, packedLight, packedOverlay);
    }
}
