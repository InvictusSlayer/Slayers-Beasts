package net.invictusslayer.slayersbeasts.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.entity.MantisEntity;
import net.invictusslayer.slayersbeasts.entity.poses.MantisWingPose;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class MantisModel<Type extends MantisEntity> extends EntityModel<Type> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SlayersBeasts.MOD_ID, "mantis_entity"), "main");
    private final ModelPart head;
    private final ModelPart thorax;
    private final ModelPart abdomen;
    private final ModelPart leftWing;
    private final ModelPart leftLowerWing;
    private final ModelPart rightWing;
    private final ModelPart rightLowerWing;
    private final ModelPart leftClaw;
    private final ModelPart rightClaw;
    private final ModelPart leftFrontLeg;
    private final ModelPart rightFrontLeg;
    private final ModelPart leftBackLeg;
    private final ModelPart rightBackLeg;
    private final ModelPart carapace;

    public MantisModel(ModelPart root) {
        this.head = root.getChild("head");
        this.thorax = root.getChild("thorax");
        this.abdomen = root.getChild("abdomen");
        this.leftWing = root.getChild("leftWing");
        this.leftLowerWing = root.getChild("leftLowerWing");
        this.rightWing = root.getChild("rightWing");
        this.rightLowerWing = root.getChild("rightLowerWing");
        this.leftClaw = root.getChild("leftClaw");
        this.rightClaw = root.getChild("rightClaw");
        this.leftFrontLeg = root.getChild("leftFrontLeg");
        this.rightFrontLeg = root.getChild("rightFrontLeg");
        this.leftBackLeg = root.getChild("leftBackLeg");
        this.rightBackLeg = root.getChild("rightBackLeg");
        this.carapace = root.getChild("carapace");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(12, 25).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 35).addBox(-1.5F, 0.75F, -1.75F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(26, 32).addBox(-1.5F, 0.75F, -1.25F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(14, 8).addBox(-1.0F, 2.75F, -1.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(0.5F, 3.5F, -1.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 1).addBox(-0.5F, 3.5F, -1.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.5F, -7.0801F, -0.2618F, 0.0F, 0.0F));

        PartDefinition rightEye_r1 = head.addOrReplaceChild("rightEye_r1", CubeListBuilder.create().texOffs(18, 20).addBox(-2.5466F, -0.4877F, -4.8732F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -0.3244F, 2.9111F, 0.0F, -0.5236F, 0.2618F));

        PartDefinition leftEye_r1 = head.addOrReplaceChild("leftEye_r1", CubeListBuilder.create().texOffs(8, 35).addBox(1.5466F, -0.4877F, -4.8732F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -0.3244F, 2.9111F, 0.0F, 0.5236F, -0.2618F));

        PartDefinition leftAntenna = head.addOrReplaceChild("leftAntenna", CubeListBuilder.create().texOffs(40, 19).addBox(0.4722F, -2.7633F, -4.6076F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.3244F, 3.1611F, 0.1309F, 0.0F, 0.2618F));

        PartDefinition leftAntenna2_r1 = leftAntenna.addOrReplaceChild("leftAntenna2_r1", CubeListBuilder.create().texOffs(17, 38).addBox(-0.0278F, -4.693F, -4.9416F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -4.0F, 0.5F, 0.6981F, 0.0F, 0.0F));

        PartDefinition rightAntenna = head.addOrReplaceChild("rightAntenna", CubeListBuilder.create().texOffs(8, 39).addBox(-1.4722F, -2.7633F, -4.8576F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.3244F, 3.4111F, 0.1309F, 0.0F, -0.2618F));

        PartDefinition rightAntenna2_r1 = rightAntenna.addOrReplaceChild("rightAntenna2_r1", CubeListBuilder.create().texOffs(13, 38).addBox(-0.9722F, -4.693F, -4.9416F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -4.0F, 0.25F, 0.6981F, 0.0F, 0.0F));

        PartDefinition thorax = partdefinition.addOrReplaceChild("thorax", CubeListBuilder.create(), PartPose.offset(0.0F, 14.0F, 0.0F));

        PartDefinition upperThorax = thorax.addOrReplaceChild("upperThorax", CubeListBuilder.create().texOffs(0, 12).addBox(-1.0F, 1.3064F, -10.7736F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 2.0F, -0.6981F, 0.0F, 0.0F));

        PartDefinition lowerThorax = thorax.addOrReplaceChild("lowerThorax", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.2523F, -3.6574F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.933F, 2.0179F, -0.3927F, 0.0F, 0.0F));

        PartDefinition abdomen = partdefinition.addOrReplaceChild("abdomen", CubeListBuilder.create().texOffs(0, 31).addBox(-1.5F, -0.25F, 0.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(26, 25).addBox(-2.0F, -0.5F, 1.0F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(12, 12).addBox(-1.5F, -0.25F, 12.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(8, 31).addBox(-1.0F, 0.0F, 15.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.25F, 6.75F));

        PartDefinition leftWing = partdefinition.addOrReplaceChild("leftWing", CubeListBuilder.create(), PartPose.offset(0.5F, 11.75F, -2.0F));

        PartDefinition wing3_r1 = leftWing.addOrReplaceChild("wing3_r1", CubeListBuilder.create().texOffs(11, 3).addBox(-0.5F, -0.25F, 22.0F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(15, 0).addBox(0.5F, -0.25F, 3.0F, 4.0F, 0.0F, 19.0F, new CubeDeformation(0.0F))
                .texOffs(0, 2).addBox(-0.5F, -0.25F, 1.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 25).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.25F, 0.75F, -0.0436F, 0.0873F, 0.7418F));

        PartDefinition leftLowerWing = partdefinition.addOrReplaceChild("leftLowerWing", CubeListBuilder.create(), PartPose.offset(0.5F, 11.75F, -2.0F));

        PartDefinition wing3_r2 = leftLowerWing.addOrReplaceChild("wing3_r2", CubeListBuilder.create().texOffs(11, 3).addBox(-0.5F, -0.25F, 22.0F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(15, 0).addBox(0.5F, -0.25F, 3.0F, 4.0F, 0.0F, 19.0F, new CubeDeformation(0.0F))
                .texOffs(0, 2).addBox(-0.5F, -0.25F, 1.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 25).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.25F, 0.75F, -0.0436F, 0.0873F, 0.7418F));

        PartDefinition rightWing = partdefinition.addOrReplaceChild("rightWing", CubeListBuilder.create(), PartPose.offset(-0.5F, 11.75F, -2.0F));

        PartDefinition wing3_r3 = rightWing.addOrReplaceChild("wing3_r3", CubeListBuilder.create().texOffs(11, 0).addBox(-3.5F, -0.25F, 22.0F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(7, 0).addBox(-4.5F, -0.25F, 3.0F, 4.0F, 0.0F, 19.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-3.5F, -0.25F, 1.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.25F, 0.75F, -0.0436F, -0.0873F, -0.7418F));

        PartDefinition rightLowerWing = partdefinition.addOrReplaceChild("rightLowerWing", CubeListBuilder.create(), PartPose.offset(-0.5F, 11.75F, -2.0F));

        PartDefinition wing3_r4 = rightLowerWing.addOrReplaceChild("wing3_r4", CubeListBuilder.create().texOffs(11, 0).addBox(-3.5F, -0.25F, 22.0F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(7, 0).addBox(-4.5F, -0.25F, 3.0F, 4.0F, 0.0F, 19.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-3.5F, -0.25F, 1.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.25F, 0.75F, -0.0436F, -0.0873F, -0.7418F));

        PartDefinition leftClaw = partdefinition.addOrReplaceChild("leftClaw", CubeListBuilder.create(), PartPose.offset(0.75F, 9.9F, -6.25F));

        PartDefinition lower_r1 = leftClaw.addOrReplaceChild("lower_r1", CubeListBuilder.create().texOffs(20, 31).addBox(-0.5F, 0.1034F, -7.8426F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.1952F, 0.1428F, 0.2182F, -0.1745F, 0.0F));

        PartDefinition middle2_r1 = leftClaw.addOrReplaceChild("middle2_r1", CubeListBuilder.create().texOffs(26, 25).addBox(-0.5F, 1.1503F, 2.994F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(34, 40).addBox(-0.5F, -1.8497F, 3.244F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.1952F, 0.1428F, -1.789F, -0.1745F, 0.0F));

        PartDefinition upper_r1 = leftClaw.addOrReplaceChild("upper_r1", CubeListBuilder.create().texOffs(0, 38).addBox(-0.5F, -0.2476F, -0.5475F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.1952F, 0.1428F, 0.1745F, -0.1745F, 0.0F));

        PartDefinition rightClaw = partdefinition.addOrReplaceChild("rightClaw", CubeListBuilder.create(), PartPose.offset(-0.75F, 9.9F, -6.25F));

        PartDefinition lower_r2 = rightClaw.addOrReplaceChild("lower_r2", CubeListBuilder.create().texOffs(16, 31).addBox(-0.5F, 0.1034F, -7.8426F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.1952F, 0.1428F, 0.2182F, 0.1745F, 0.0F));

        PartDefinition middle2_r2 = rightClaw.addOrReplaceChild("middle2_r2", CubeListBuilder.create().texOffs(0, 12).addBox(-0.5F, 1.1503F, 2.994F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(30, 40).addBox(-0.5F, -1.8497F, 3.244F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.1952F, 0.1428F, -1.789F, 0.1745F, 0.0F));

        PartDefinition upper_r2 = rightClaw.addOrReplaceChild("upper_r2", CubeListBuilder.create().texOffs(32, 25).addBox(-0.5F, -0.2476F, -0.5475F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.1952F, 0.1428F, 0.1745F, 0.1745F, 0.0F));

        PartDefinition leftFrontLeg = partdefinition.addOrReplaceChild("leftFrontLeg", CubeListBuilder.create().texOffs(26, 40).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.75F, 13.75F, -0.75F));

        PartDefinition lower_r3 = leftFrontLeg.addOrReplaceChild("lower_r3", CubeListBuilder.create().texOffs(12, 29).addBox(1.0793F, -3.5334F, -3.8122F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.25F, 4.5F, 3.3122F, 0.0F, 0.0F, 1.4835F));

        PartDefinition middle2_r3 = leftFrontLeg.addOrReplaceChild("middle2_r3", CubeListBuilder.create().texOffs(26, 21).addBox(2.9647F, -2.0948F, -3.8122F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, 0.0F, 3.3122F, 0.0F, 0.0F, 0.829F));

        PartDefinition middle1_r1 = leftFrontLeg.addOrReplaceChild("middle1_r1", CubeListBuilder.create().texOffs(14, 6).addBox(2.4368F, 2.6219F, -3.8122F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 2.25F, 3.3122F, 0.0F, 0.0F, -0.6109F));

        PartDefinition rightFrontLeg = partdefinition.addOrReplaceChild("rightFrontLeg", CubeListBuilder.create(), PartPose.offset(-0.75F, 13.75F, -0.75F));

        PartDefinition lower_r4 = rightFrontLeg.addOrReplaceChild("lower_r4", CubeListBuilder.create().texOffs(0, 29).addBox(6.1505F, -9.8655F, 5.5622F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 0.0F, 6.0622F, 3.1416F, 0.0F, 1.6581F));

        PartDefinition middle2_r4 = rightFrontLeg.addOrReplaceChild("middle2_r4", CubeListBuilder.create().texOffs(26, 19).addBox(4.8226F, -4.1223F, 5.5622F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 0.0F, 6.0622F, -3.1416F, 0.0F, 2.3126F));

        PartDefinition middle1_r2 = rightFrontLeg.addOrReplaceChild("middle1_r2", CubeListBuilder.create().texOffs(0, 8).addBox(0.7367F, 4.1782F, 5.5622F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 0.0F, 6.0622F, 3.1416F, 0.0F, -2.5307F));

        PartDefinition upper_r3 = rightFrontLeg.addOrReplaceChild("upper_r3", CubeListBuilder.create().texOffs(4, 38).addBox(3.0F, -1.0F, 5.5622F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 0.0F, 6.0622F, -3.1416F, 0.0F, 3.1416F));

        PartDefinition leftBackLeg = partdefinition.addOrReplaceChild("leftBackLeg", CubeListBuilder.create().texOffs(42, 0).addBox(-0.5F, -0.25F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, 14.0F, 0.75F, 0.0F, 0.0F, 0.0F));

        PartDefinition lower_r5 = leftBackLeg.addOrReplaceChild("lower_r5", CubeListBuilder.create().texOffs(0, 27).addBox(0.4692F, 3.44F, -3.8122F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.25F, 4.25F, 3.3122F, 0.0F, 0.0F, 1.4835F));

        PartDefinition middle2_r5 = leftBackLeg.addOrReplaceChild("middle2_r5", CubeListBuilder.create().texOffs(0, 25).addBox(-1.7644F, 3.0661F, -3.8122F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.25F, -0.25F, 3.3122F, 0.0F, 0.0F, 0.829F));

        PartDefinition middle1_r3 = leftBackLeg.addOrReplaceChild("middle1_r3", CubeListBuilder.create().texOffs(0, 6).addBox(-3.2972F, -1.3932F, -3.8122F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 2.0F, 3.3122F, 0.0F, 0.0F, -0.6109F));

        PartDefinition rightBackLeg = partdefinition.addOrReplaceChild("rightBackLeg", CubeListBuilder.create(), PartPose.offset(-0.75F, 14.0F, 0.75F));

        PartDefinition lower_r6 = rightBackLeg.addOrReplaceChild("lower_r6", CubeListBuilder.create().texOffs(12, 18).addBox(5.5404F, -2.8921F, 5.5622F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -0.25F, 6.0622F, 3.1416F, 0.0F, 1.6581F));

        PartDefinition middle2_r6 = rightBackLeg.addOrReplaceChild("middle2_r6", CubeListBuilder.create().texOffs(0, 22).addBox(0.0935F, 1.0386F, 5.5622F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -0.25F, 6.0622F, -3.1416F, 0.0F, 2.3126F));

        PartDefinition middle1_r4 = rightBackLeg.addOrReplaceChild("middle1_r4", CubeListBuilder.create().texOffs(0, 4).addBox(-4.9973F, 0.1632F, 5.5622F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -0.25F, 6.0622F, 3.1416F, 0.0F, -2.5307F));

        PartDefinition upper_r4 = rightBackLeg.addOrReplaceChild("upper_r4", CubeListBuilder.create().texOffs(38, 40).addBox(-4.0F, 0.0F, 5.5622F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -0.25F, 6.0622F, -3.1416F, 0.0F, 3.1416F));

        PartDefinition carapace = partdefinition.addOrReplaceChild("carapace", CubeListBuilder.create(), PartPose.offset(0.0F, 12.0F, -2.0F));

        PartDefinition cube_r1 = carapace.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(4, 27).addBox(-1.5F, 4.5F, 4.0F, 1.0F, 1.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(0, 30).addBox(-1.5F, 0.5F, 1.0F, 1.0F, 4.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.0436F, 0.7854F));

        PartDefinition cube_r2 = carapace.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(4, 28).addBox(0.5F, 4.5F, 4.0F, 1.0F, 1.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(0, 26).addBox(0.5F, 0.5F, 1.0F, 1.0F, 4.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, -0.0436F, -0.7854F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(Type pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        float f1 = Mth.cos(pLimbSwing * 2F) * pLimbSwingAmount / 2F;
        float f2 = Mth.cos(pLimbSwing * 2F + Mth.PI * 0.5F) * pLimbSwingAmount / 2F;
        float f3 = Mth.cos(pLimbSwing * 2F + Mth.PI) * pLimbSwingAmount / 2F;
        float f4 = Mth.cos(pLimbSwing * 2F + Mth.PI * 2F) * pLimbSwingAmount / 2F;
        float f5 = Mth.cos(pAgeInTicks / 6F) / 6F;
        float f6 = Mth.cos(pAgeInTicks / 6F + Mth.PI * 0.5F) / 6F;
        float f7 = Mth.cos(pAgeInTicks / 6F - Mth.PI * 0.5F) / 6F;
        float f8 = Mth.cos(pAgeInTicks) / 6F;
        this.head.xRot = pHeadPitch * Mth.PI / 180F;
        this.head.yRot = pNetHeadYaw * Mth.PI / 180F;
        this.abdomen.xRot = f5 / 4F;
        this.leftClaw.xRot = f6 / 4F;
        this.rightClaw.xRot = f7 / 4F;
        this.leftFrontLeg.yRot = 0.9F;
        this.rightFrontLeg.yRot = -0.9F;
        this.leftBackLeg.yRot = -0.9F;
        this.rightBackLeg.yRot = 0.9F;
        MantisWingPose wingPose = pEntity.getWingPose();
        if (wingPose == MantisWingPose.LEAPING) {
            this.leftWing.xRot = 0.7F;
            this.rightWing.xRot = 0.7F;
            this.leftLowerWing.xRot = 0.35F;
            this.rightLowerWing.xRot = 0.35F;
            this.leftWing.yRot = 1.2F;
            this.rightWing.yRot = -1.2F;
            this.leftLowerWing.yRot = 1F;
            this.rightLowerWing.yRot = -1F;
            this.leftWing.xRot += f1;
            this.rightWing.xRot += f1;
            this.leftLowerWing.xRot += f1;
            this.rightLowerWing.xRot += f1;
            this.leftWing.yRot += f1;
            this.rightWing.yRot += -f1;
            this.leftLowerWing.yRot += f1;
            this.rightLowerWing.yRot += -f1;
            this.leftLowerWing.zRot += -f1 * 0.5F;
            this.rightLowerWing.zRot += f1 * 0.5F;
        } else if (wingPose == MantisWingPose.FLUTTERING) {
            this.leftWing.xRot = 0.1F;
            this.rightWing.xRot = 0.1F;
            this.leftLowerWing.xRot = 0.05F;
            this.rightLowerWing.xRot = 0.05F;
            this.leftWing.yRot = 0.3F;
            this.rightWing.yRot = -0.3F;
            this.leftLowerWing.yRot = 0.25F;
            this.rightLowerWing.yRot = -0.25F;
            this.leftWing.xRot += f8;
            this.rightWing.xRot += f8;
            this.leftLowerWing.xRot += f8;
            this.rightLowerWing.xRot += f8;
            this.leftWing.yRot += f8;
            this.rightWing.yRot += -f8;
            this.leftLowerWing.yRot += f8;
            this.rightLowerWing.yRot += -f8;
        } else {
            this.leftWing.xRot = 0F;
            this.rightWing.xRot = 0F;
            this.leftLowerWing.xRot = 0F;
            this.rightLowerWing.xRot = 0F;
            this.leftWing.yRot = 0F;
            this.rightWing.yRot = 0F;
            this.leftLowerWing.yRot = 0F;
            this.rightLowerWing.yRot = 0F;
            this.leftLowerWing.zRot = 0F;
            this.rightLowerWing.zRot = 0F;
            this.leftFrontLeg.yRot += f1;
            this.rightFrontLeg.yRot += f3;
            this.leftBackLeg.yRot += -f4;
            this.rightBackLeg.yRot += -f2;
        }
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        head.render(poseStack, buffer, packedLight, packedOverlay);
        thorax.render(poseStack, buffer, packedLight, packedOverlay);
        abdomen.render(poseStack, buffer, packedLight, packedOverlay);
        leftWing.render(poseStack, buffer, packedLight, packedOverlay);
        leftLowerWing.render(poseStack, buffer, packedLight, packedOverlay);
        rightWing.render(poseStack, buffer, packedLight, packedOverlay);
        rightLowerWing.render(poseStack, buffer, packedLight, packedOverlay);
        leftClaw.render(poseStack, buffer, packedLight, packedOverlay);
        rightClaw.render(poseStack, buffer, packedLight, packedOverlay);
        leftFrontLeg.render(poseStack, buffer, packedLight, packedOverlay);
        rightFrontLeg.render(poseStack, buffer, packedLight, packedOverlay);
        leftBackLeg.render(poseStack, buffer, packedLight, packedOverlay);
        rightBackLeg.render(poseStack, buffer, packedLight, packedOverlay);
        carapace.render(poseStack, buffer, packedLight, packedOverlay);
    }
}
