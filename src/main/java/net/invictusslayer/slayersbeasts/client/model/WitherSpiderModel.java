package net.invictusslayer.slayersbeasts.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.entity.WitherSpider;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class WitherSpiderModel<Type extends WitherSpider> extends EntityModel<Type> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SlayersBeasts.MOD_ID, "wither_spider_entity"), "main");
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart leftFrontLeg;
    private final ModelPart leftMiddleLeg1;
    private final ModelPart leftMiddleLeg2;
    private final ModelPart leftBackLeg;
    private final ModelPart rightFrontLeg;
    private final ModelPart rightMiddleLeg1;
    private final ModelPart rightMiddleLeg2;
    private final ModelPart rightBackLeg;

    public WitherSpiderModel(ModelPart root) {
        this.head = root.getChild("head");
        this.body = root.getChild("body");
        this.leftFrontLeg = root.getChild("leftFrontLeg");
        this.leftMiddleLeg1 = root.getChild("leftMiddleLeg1");
        this.leftMiddleLeg2 = root.getChild("leftMiddleLeg2");
        this.leftBackLeg = root.getChild("leftBackLeg");
        this.rightFrontLeg = root.getChild("rightFrontLeg");
        this.rightMiddleLeg1 = root.getChild("rightMiddleLeg1");
        this.rightMiddleLeg2 = root.getChild("rightMiddleLeg2");
        this.rightBackLeg = root.getChild("rightBackLeg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 12).addBox(-3.0F, -2.0F, -6.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 18.0F, -5.5F));

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 18.0F, 0.0F));

        PartDefinition thorax = body.addOrReplaceChild("thorax", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -6.0F, -5.5F, 2.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

        PartDefinition ridge = thorax.addOrReplaceChild("ridge", CubeListBuilder.create().texOffs(18, 17).addBox(-1.0F, -7.0F, -3.5F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(4, 10).addBox(-1.0F, -7.0F, -0.5F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).addBox(-1.0F, -7.0F, 0.5F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 17).addBox(-1.0F, -7.0F, 3.5F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(15, 0).addBox(0.0F, -7.0F, -4.5F, 0.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition ribs = thorax.addOrReplaceChild("ribs", CubeListBuilder.create().texOffs(40, 32).addBox(-3.0F, -6.0F, -2.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(40, 34).addBox(-3.0F, -6.0F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 40).addBox(-3.0F, -6.0F, 1.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(40, 26).addBox(1.0F, -6.0F, -2.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(39, 8).addBox(1.0F, -6.0F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 12).addBox(1.0F, -6.0F, 1.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition rib1 = ribs.addOrReplaceChild("rib1", CubeListBuilder.create().texOffs(42, 36).addBox(-2.0F, -6.0F, -4.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(42, 28).addBox(-3.0F, -5.0F, -4.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition rib2 = ribs.addOrReplaceChild("rib2", CubeListBuilder.create().texOffs(17, 42).addBox(-2.0F, -6.0F, -4.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 42).addBox(-3.0F, -5.0F, -4.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 8.0F));

        PartDefinition rib3 = ribs.addOrReplaceChild("rib3", CubeListBuilder.create().texOffs(0, 42).addBox(-3.0F, -6.0F, -4.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(40, 41).addBox(-2.0F, -5.0F, -4.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 0.0F, 0.0F));

        PartDefinition rib4 = ribs.addOrReplaceChild("rib4", CubeListBuilder.create().texOffs(36, 41).addBox(-3.0F, -6.0F, -4.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(32, 41).addBox(-2.0F, -5.0F, -4.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 0.0F, 8.0F));

        PartDefinition abdomen = body.addOrReplaceChild("abdomen", CubeListBuilder.create().texOffs(15, 15).addBox(-1.0F, -7.0F, 5.5F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(15, 4).addBox(0.0F, -8.0F, 6.5F, 0.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.0F, -6.0F, 14.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

        PartDefinition leftRibs = abdomen.addOrReplaceChild("leftRibs", CubeListBuilder.create().texOffs(14, 0).addBox(1.0F, -6.0F, 5.5F, 4.0F, 0.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(31, 31).addBox(1.0F, -7.0F, 6.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(31, 6).addBox(1.0F, -7.0F, 9.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 8).addBox(1.0F, -7.0F, 12.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(33, 8).addBox(1.0F, -6.0F, 14.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 40).addBox(4.0F, -6.0F, 6.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 36).addBox(5.0F, -6.0F, 9.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 38).addBox(4.0F, -6.0F, 12.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(7, 0).addBox(2.0F, -5.0F, 14.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition rightRibs = abdomen.addOrReplaceChild("rightRibs", CubeListBuilder.create().texOffs(6, 0).addBox(2.0F, -6.0F, 5.5F, 4.0F, 0.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(0, 6).addBox(2.0F, -7.0F, 6.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 24).addBox(1.0F, -7.0F, 9.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 4).addBox(2.0F, -7.0F, 12.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(37, 24).addBox(4.0F, -6.0F, 14.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(14, 38).addBox(2.0F, -6.0F, 6.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(19, 37).addBox(1.0F, -6.0F, 9.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 37).addBox(2.0F, -6.0F, 12.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(23, 40).addBox(4.0F, -5.0F, 14.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, 0.0F, 0.0F));

        PartDefinition leftFrontLeg = partdefinition.addOrReplaceChild("leftFrontLeg", CubeListBuilder.create().texOffs(8, 37).addBox(0.0F, 0.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(34, 36).addBox(1.0F, -4.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 18.0F, -2.5F));

        PartDefinition cube_r1 = leftFrontLeg.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(28, 18).addBox(0.0F, 0.0F, -0.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -9.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

        PartDefinition cube_r2 = leftFrontLeg.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(31, 4).addBox(-7.0F, 0.0F, -0.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -9.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition leftMiddleLeg1 = partdefinition.addOrReplaceChild("leftMiddleLeg1", CubeListBuilder.create().texOffs(36, 28).addBox(0.0F, 0.0F, -0.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 35).addBox(1.0F, -4.0F, -0.75F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 18.0F, -0.5F));

        PartDefinition cube_r3 = leftMiddleLeg1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(28, 16).addBox(0.0F, 0.0F, -0.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -9.0F, -0.25F, 0.0F, 0.0F, 0.3491F));

        PartDefinition cube_r4 = leftMiddleLeg1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(31, 2).addBox(-7.0F, 0.0F, -0.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -9.0F, -0.25F, 0.0F, 0.0F, -0.7854F));

        PartDefinition leftMiddleLeg2 = partdefinition.addOrReplaceChild("leftMiddleLeg2", CubeListBuilder.create().texOffs(14, 35).addBox(0.0F, 0.0F, -0.25F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 35).addBox(1.0F, -4.0F, -0.25F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 18.0F, 0.5F));

        PartDefinition cube_r5 = leftMiddleLeg2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(28, 14).addBox(0.0F, 0.0F, -0.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -9.0F, 0.25F, 0.0F, 0.0F, 0.3491F));

        PartDefinition cube_r6 = leftMiddleLeg2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(31, 0).addBox(-7.0F, 0.0F, -0.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -9.0F, 0.25F, 0.0F, 0.0F, -0.7854F));

        PartDefinition leftBackLeg = partdefinition.addOrReplaceChild("leftBackLeg", CubeListBuilder.create().texOffs(34, 33).addBox(0.0F, 0.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(30, 33).addBox(1.0F, -4.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 18.0F, 2.5F));

        PartDefinition cube_r7 = leftBackLeg.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 28).addBox(0.0F, 0.0F, -0.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -9.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

        PartDefinition cube_r8 = leftBackLeg.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(16, 30).addBox(-7.0F, 0.0F, -0.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -9.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition rightFrontLeg = partdefinition.addOrReplaceChild("rightFrontLeg", CubeListBuilder.create().texOffs(24, 32).addBox(-2.0F, 0.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(20, 32).addBox(-2.0F, -4.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 18.0F, -2.5F));

        PartDefinition cube_r9 = rightFrontLeg.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(20, 26).addBox(-9.0F, 0.0F, -0.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -9.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

        PartDefinition cube_r10 = rightFrontLeg.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 30).addBox(0.0F, 0.0F, -0.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -9.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition rightMiddleLeg1 = partdefinition.addOrReplaceChild("rightMiddleLeg1", CubeListBuilder.create().texOffs(14, 32).addBox(-2.0F, 0.0F, -0.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(10, 32).addBox(-2.0F, -4.0F, -0.75F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 18.0F, -0.5F));

        PartDefinition cube_r11 = rightMiddleLeg1.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(26, 10).addBox(-9.0F, 0.0F, -0.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -9.0F, -0.25F, 0.0F, 0.0F, -0.3491F));

        PartDefinition cube_r12 = rightMiddleLeg1.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(28, 22).addBox(0.0F, 0.0F, -0.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -9.0F, -0.25F, 0.0F, 0.0F, 0.7854F));

        PartDefinition rightMiddleLeg2 = partdefinition.addOrReplaceChild("rightMiddleLeg2", CubeListBuilder.create().texOffs(4, 32).addBox(-2.0F, 0.0F, -0.25F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 32).addBox(-2.0F, -4.0F, -0.25F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 18.0F, 0.5F));

        PartDefinition cube_r13 = rightMiddleLeg2.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 26).addBox(-9.0F, 0.0F, -0.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -9.0F, 0.25F, 0.0F, 0.0F, -0.3491F));

        PartDefinition cube_r14 = rightMiddleLeg2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(28, 20).addBox(0.0F, 0.0F, -0.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -9.0F, 0.25F, 0.0F, 0.0F, 0.7854F));

        PartDefinition rightBackLeg = partdefinition.addOrReplaceChild("rightBackLeg", CubeListBuilder.create().texOffs(18, 14).addBox(-2.0F, 0.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 12).addBox(-2.0F, -4.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 18.0F, 2.5F));

        PartDefinition cube_r15 = rightBackLeg.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(18, 12).addBox(-9.0F, 0.0F, -0.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -9.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

        PartDefinition cube_r16 = rightBackLeg.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(20, 28).addBox(0.0F, 0.0F, -0.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -9.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(Type pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        float f1 = Mth.cos(pLimbSwing * 2) * pLimbSwingAmount;
        double d1 = Math.pow(Mth.cos(pLimbSwing + Mth.PI * 0.25F), 6) * pLimbSwingAmount;
        double d2 = Math.pow(Mth.sin(pLimbSwing + Mth.PI * 0.25F), 6) * pLimbSwingAmount;
        float a1 = Mth.PI * 0.19F;
        float a2 = Mth.PI * 0.17F;
        float a3 = Mth.PI * 0.31F;
        float a4 = Mth.PI * 0.08F;
        float a5 = Mth.PI * 0.06F;
        float a6 = Mth.PI * 0.25F;
        head.yRot = pNetHeadYaw * Mth.PI / 180F;
        head.xRot = pHeadPitch * Mth.PI / 180F;
        leftFrontLeg.xRot = a1;
        rightFrontLeg.xRot = a1;
        leftMiddleLeg1.xRot = a4;
        rightMiddleLeg1.xRot = a4;
        leftMiddleLeg2.xRot = -a4;
        rightMiddleLeg2.xRot = -a4;
        leftBackLeg.xRot = -a1;
        rightBackLeg.xRot = -a1;
        leftFrontLeg.yRot = a2;
        rightFrontLeg.yRot = -a2;
        leftMiddleLeg1.yRot = a5;
        rightMiddleLeg1.yRot = -a5;
        leftMiddleLeg2.yRot = -a5;
        rightMiddleLeg2.yRot = a5;
        leftBackLeg.yRot = -a2;
        rightBackLeg.yRot = a2;
        leftFrontLeg.zRot = a3;
        rightFrontLeg.zRot = -a3;
        leftMiddleLeg1.zRot = a6;
        rightMiddleLeg1.zRot = -a6;
        leftMiddleLeg2.zRot = a6;
        rightMiddleLeg2.zRot = -a6;
        leftBackLeg.zRot = a3;
        rightBackLeg.zRot = -a3;

        leftFrontLeg.yRot += -f1;
        rightFrontLeg.yRot += -f1;
        leftMiddleLeg1.yRot += f1;
        rightMiddleLeg1.yRot += f1;
        leftMiddleLeg2.yRot += -f1;
        rightMiddleLeg2.yRot += -f1;
        leftBackLeg.yRot += f1;
        rightBackLeg.yRot += f1;
        leftFrontLeg.zRot += -d2;
        rightFrontLeg.zRot += d1;
        leftMiddleLeg1.zRot += -d1;
        rightMiddleLeg1.zRot += d2;
        leftMiddleLeg2.zRot += -d2;
        rightMiddleLeg2.zRot += d1;
        leftBackLeg.zRot += -d1;
        rightBackLeg.zRot += d2;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leftFrontLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leftMiddleLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leftMiddleLeg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leftBackLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        rightFrontLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        rightMiddleLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        rightMiddleLeg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        rightBackLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
