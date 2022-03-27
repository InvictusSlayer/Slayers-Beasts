package net.invictusslayer.slayersbeasts.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.entity.WitherSpiderEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class WitherSpiderEntityModel<Type extends WitherSpiderEntity> extends EntityModel<Type> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SlayersBeasts.MOD_ID, "wither_spider_entity"), "main");
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart leftFrontLeg;
    private final ModelPart rightFrontLeg;
    private final ModelPart leftMiddleFrontLeg;
    private final ModelPart rightMiddleFrontLeg;
    private final ModelPart leftMiddleBackLeg;
    private final ModelPart rightMiddleBackLeg;
    private final ModelPart leftBackLeg;
    private final ModelPart rightBackLeg;
    private final ModelPart extraLeg1;
    private final ModelPart extraLeg2;

    public WitherSpiderEntityModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = root.getChild("head");
        this.leftFrontLeg = root.getChild("leftFrontLeg");
        this.rightFrontLeg = root.getChild("rightFrontLeg");
        this.leftMiddleFrontLeg = root.getChild("leftMiddleFrontLeg");
        this.rightMiddleFrontLeg = root.getChild("rightMiddleFrontLeg");
        this.leftMiddleBackLeg = root.getChild("leftMiddleBackLeg");
        this.rightMiddleBackLeg = root.getChild("rightMiddleBackLeg");
        this.leftBackLeg = root.getChild("leftBackLeg");
        this.rightBackLeg = root.getChild("rightBackLeg");
        this.extraLeg1 = root.getChild("extraLeg1");
        this.extraLeg2 = root.getChild("extraLeg2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 18.0F, 0.0F));

        PartDefinition thorax = body.addOrReplaceChild("thorax", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -6.0F, -5.5F, 2.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

        PartDefinition ridge = thorax.addOrReplaceChild("ridge", CubeListBuilder.create().texOffs(23, 6).addBox(-1.0F, -7.0F, -3.5F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(4, 10).addBox(-1.0F, -7.0F, -0.5F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).addBox(-1.0F, -7.0F, 0.5F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(21, 20).addBox(-1.0F, -7.0F, 3.5F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(0.0F, -7.0F, -4.5F, 0.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition ribs = thorax.addOrReplaceChild("ribs", CubeListBuilder.create().texOffs(34, 45).addBox(-3.0F, -6.0F, -2.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(40, 45).addBox(-3.0F, -6.0F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(44, 41).addBox(-3.0F, -6.0F, 1.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 45).addBox(1.0F, -6.0F, -2.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(44, 37).addBox(1.0F, -6.0F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(44, 35).addBox(1.0F, -6.0F, 1.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition rib1 = ribs.addOrReplaceChild("rib1", CubeListBuilder.create().texOffs(48, 9).addBox(-2.0F, -6.0F, -4.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(48, 6).addBox(-3.0F, -5.0F, -4.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition rib2 = ribs.addOrReplaceChild("rib2", CubeListBuilder.create().texOffs(40, 47).addBox(-2.0F, -6.0F, -4.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 47).addBox(-3.0F, -5.0F, -4.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 8.0F));

        PartDefinition rib3 = ribs.addOrReplaceChild("rib3", CubeListBuilder.create().texOffs(32, 47).addBox(-3.0F, -6.0F, -4.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 47).addBox(-2.0F, -5.0F, -4.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 0.0F, 0.0F));

        PartDefinition rib4 = ribs.addOrReplaceChild("rib4", CubeListBuilder.create().texOffs(47, 3).addBox(-3.0F, -6.0F, -4.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(47, 0).addBox(-2.0F, -5.0F, -4.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 0.0F, 8.0F));

        PartDefinition abdomen = body.addOrReplaceChild("abdomen", CubeListBuilder.create().texOffs(8, 12).addBox(-1.0F, -7.0F, 5.5F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(0, 18).addBox(0.0F, -8.0F, 6.5F, 0.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.0F, -6.0F, 14.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

        PartDefinition leftRibs = abdomen.addOrReplaceChild("leftRibs", CubeListBuilder.create().texOffs(0, 12).addBox(1.0F, -6.0F, 5.5F, 4.0F, 0.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(44, 19).addBox(1.0F, -7.0F, 6.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 41).addBox(1.0F, -7.0F, 9.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(44, 17).addBox(1.0F, -7.0F, 12.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(44, 29).addBox(1.0F, -6.0F, 14.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 45).addBox(4.0F, -6.0F, 6.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(20, 45).addBox(5.0F, -6.0F, 9.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 45).addBox(4.0F, -6.0F, 12.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(7, 0).addBox(2.0F, -5.0F, 14.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition rightRibs = abdomen.addOrReplaceChild("rightRibs", CubeListBuilder.create().texOffs(6, 0).addBox(2.0F, -6.0F, 5.5F, 4.0F, 0.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(40, 43).addBox(2.0F, -7.0F, 6.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 41).addBox(1.0F, -7.0F, 9.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(30, 43).addBox(2.0F, -7.0F, 12.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(44, 31).addBox(4.0F, -6.0F, 14.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 45).addBox(2.0F, -6.0F, 6.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 45).addBox(1.0F, -6.0F, 9.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 45).addBox(2.0F, -6.0F, 12.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(45, 46).addBox(4.0F, -5.0F, 14.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, 0.0F, 0.0F));

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(21, 7).addBox(-2.0F, -1.0F, -5.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 18.0F, -5.5F));

        PartDefinition head2_r1 = head.addOrReplaceChild("head2_r1", CubeListBuilder.create().texOffs(32, 27).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 2.0F, -2.0F, 0.0873F, -1.3526F, 0.0F));

        PartDefinition head1_r1 = head.addOrReplaceChild("head1_r1", CubeListBuilder.create().texOffs(32, 33).addBox(-1.0F, -3.0F, -3.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 2.0F, -2.0F, -0.2618F, 1.309F, 0.0F));

        PartDefinition leftFrontLeg = partdefinition.addOrReplaceChild("leftFrontLeg", CubeListBuilder.create().texOffs(15, 9).addBox(0.0F, 0.0F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 27).addBox(3.0F, -13.0F, -0.5F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(21, 16).addBox(4.0F, -13.0F, -0.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(30, 20).addBox(14.0F, -12.0F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 18.0F, -2.0F));

        PartDefinition rightFrontLeg = partdefinition.addOrReplaceChild("rightFrontLeg", CubeListBuilder.create().texOffs(20, 43).addBox(-4.0F, 0.0F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 27).addBox(-4.0F, -13.0F, -0.5F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 25).addBox(-15.0F, -13.0F, -0.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(40, 22).addBox(-20.0F, -12.0F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 18.0F, -2.0F));

        PartDefinition leftMiddleFrontLeg = partdefinition.addOrReplaceChild("leftMiddleFrontLeg", CubeListBuilder.create().texOffs(24, 41).addBox(0.0F, 0.0F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 27).addBox(3.0F, -13.0F, -0.5F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(21, 18).addBox(4.0F, -13.0F, -0.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(34, 6).addBox(14.0F, -12.0F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 18.0F, -0.5F));

        PartDefinition rightMiddleFrontLeg = partdefinition.addOrReplaceChild("rightMiddleFrontLeg", CubeListBuilder.create().texOffs(10, 43).addBox(-4.0F, 0.0F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 27).addBox(-4.0F, -13.0F, -0.5F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 25).addBox(-15.0F, -13.0F, -0.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(32, 39).addBox(-20.0F, -12.0F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 18.0F, -0.5F));

        PartDefinition leftMiddleBackLeg = partdefinition.addOrReplaceChild("leftMiddleBackLeg", CubeListBuilder.create().texOffs(41, 27).addBox(0.0F, 0.0F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 27).addBox(3.0F, -13.0F, -0.5F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(23, 0).addBox(4.0F, -13.0F, -0.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(34, 8).addBox(14.0F, -12.0F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 18.0F, 0.5F));

        PartDefinition rightMiddleBackLeg = partdefinition.addOrReplaceChild("rightMiddleBackLeg", CubeListBuilder.create().texOffs(0, 43).addBox(-4.0F, 0.0F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(20, 27).addBox(-4.0F, -13.0F, -0.5F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(17, 23).addBox(-15.0F, -13.0F, -0.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(39, 14).addBox(-20.0F, -12.0F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 18.0F, 0.5F));

        PartDefinition leftBackLeg = partdefinition.addOrReplaceChild("leftBackLeg", CubeListBuilder.create().texOffs(41, 33).addBox(0.0F, 0.0F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 27).addBox(3.0F, -13.0F, -0.5F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(23, 2).addBox(4.0F, -13.0F, -0.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(34, 10).addBox(14.0F, -12.0F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 18.0F, 2.0F));

        PartDefinition rightBackLeg = partdefinition.addOrReplaceChild("rightBackLeg", CubeListBuilder.create().texOffs(34, 41).addBox(-4.0F, 0.0F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 27).addBox(-4.0F, -13.0F, -0.5F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(23, 4).addBox(-15.0F, -13.0F, -0.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(39, 12).addBox(-20.0F, -12.0F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 18.0F, 2.0F));

        PartDefinition extraLeg1 = partdefinition.addOrReplaceChild("extraLeg1", CubeListBuilder.create().texOffs(0, 45).addBox(-1.0F, -3.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(0.0F, -7.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 8).addBox(-3.0F, -8.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 6).addBox(-6.0F, -9.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 17.25F, 13.0F));

        PartDefinition extraLeg2 = partdefinition.addOrReplaceChild("extraLeg2", CubeListBuilder.create().texOffs(4, 14).addBox(0.0F, -3.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(3, 19).addBox(1.0F, -5.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 4).addBox(1.0F, -6.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 12).addBox(4.0F, -5.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 17.25F, 10.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(Type pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
        float f1 = ((float)Math.PI / 4F);
        float f2 = (-(float)Math.PI / 8F);
        float f3 = -(Mth.cos(pLimbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * pLimbSwingAmount;
        float f4 = -(Mth.cos(pLimbSwing * 0.6662F * 2.0F + (float)Math.PI) * 0.4F) * pLimbSwingAmount;
        float f5 = -(Mth.cos(pLimbSwing * 0.6662F * 2.0F + ((float)Math.PI / 2F)) * 0.4F) * pLimbSwingAmount;
        float f6 = -(Mth.cos(pLimbSwing * 0.6662F * 2.0F + ((float)Math.PI * 1.5F)) * 0.4F) * pLimbSwingAmount;
        float f7 = Math.abs(Mth.sin(pLimbSwing * 0.6662F + 0.0F) * 0.4F) * pLimbSwingAmount;
        float f8 = Math.abs(Mth.sin(pLimbSwing * 0.6662F + (float)Math.PI) * 0.4F) * pLimbSwingAmount;
        float f9 = Math.abs(Mth.sin(pLimbSwing * 0.6662F + ((float)Math.PI / 2F)) * 0.4F) * pLimbSwingAmount;
        float f10 = Math.abs(Mth.sin(pLimbSwing * 0.6662F + ((float)Math.PI * 1.5F)) * 0.4F) * pLimbSwingAmount;
        this.leftFrontLeg.yRot = f1;
        this.rightFrontLeg.yRot = -f1;
        this.leftMiddleFrontLeg.yRot = f2;
        this.rightMiddleFrontLeg.yRot = -f2;
        this.leftMiddleBackLeg.yRot = -f2;
        this.rightMiddleBackLeg.yRot = f2;
        this.leftBackLeg.yRot = -f1;
        this.rightBackLeg.yRot = f1;
        this.leftFrontLeg.zRot = f1;
        this.rightFrontLeg.zRot = -f1;
        this.leftMiddleFrontLeg.zRot = 0.58119464F;
        this.rightMiddleFrontLeg.zRot = -0.58119464F;
        this.leftMiddleBackLeg.zRot = 0.58119464F;
        this.rightMiddleBackLeg.zRot = -0.58119464F;
        this.leftBackLeg.zRot = f1;
        this.rightBackLeg.zRot = -f1;
        this.leftFrontLeg.yRot += -f6;
        this.rightFrontLeg.yRot += f6;
        this.leftMiddleFrontLeg.yRot += -f5;
        this.rightMiddleFrontLeg.yRot += f5;
        this.leftMiddleBackLeg.yRot += -f4;
        this.rightMiddleBackLeg.yRot += f4;
        this.leftBackLeg.yRot += -f3;
        this.rightBackLeg.yRot += f3;
        this.leftFrontLeg.zRot += -f10;
        this.rightFrontLeg.zRot += f10;
        this.leftMiddleFrontLeg.zRot += -f9;
        this.rightMiddleFrontLeg.zRot += f9;
        this.leftMiddleBackLeg.zRot += -f8;
        this.rightMiddleBackLeg.zRot += f8;
        this.leftBackLeg.zRot += -f7;
        this.rightBackLeg.zRot += f7;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(poseStack, buffer, packedLight, packedOverlay);
        head.render(poseStack, buffer, packedLight, packedOverlay);
        leftFrontLeg.render(poseStack, buffer, packedLight, packedOverlay);
        rightFrontLeg.render(poseStack, buffer, packedLight, packedOverlay);
        leftMiddleFrontLeg.render(poseStack, buffer, packedLight, packedOverlay);
        rightMiddleFrontLeg.render(poseStack, buffer, packedLight, packedOverlay);
        leftMiddleBackLeg.render(poseStack, buffer, packedLight, packedOverlay);
        rightMiddleBackLeg.render(poseStack, buffer, packedLight, packedOverlay);
        leftBackLeg.render(poseStack, buffer, packedLight, packedOverlay);
        rightBackLeg.render(poseStack, buffer, packedLight, packedOverlay);
        extraLeg1.render(poseStack, buffer, packedLight, packedOverlay);
        extraLeg2.render(poseStack, buffer, packedLight, packedOverlay);
    }
}
