package net.invictusslayer.slayersbeasts.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.entity.Tarantula;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class TarantulaModel<Type extends Tarantula> extends EntityModel<Type> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SlayersBeasts.MOD_ID, "tarantula_model"), "main");
    private final ModelPart body;
    private final ModelPart leftFang;
    private final ModelPart rightFang;
    private final ModelPart leftFrontLeg;
    private final ModelPart leftMiddleLeg1;
    private final ModelPart leftMiddleLeg2;
    private final ModelPart leftBackLeg;
    private final ModelPart l11;
    private final ModelPart l12;
    private final ModelPart l13;
    private final ModelPart l14;
    private final ModelPart l21;
    private final ModelPart l22;
    private final ModelPart l23;
    private final ModelPart l24;
    private final ModelPart l31;
    private final ModelPart l32;
    private final ModelPart l33;
    private final ModelPart l34;
    private final ModelPart l41;
    private final ModelPart l42;
    private final ModelPart l43;
    private final ModelPart l44;
    private final ModelPart rightFrontLeg;
    private final ModelPart rightMiddleLeg1;
    private final ModelPart rightMiddleLeg2;
    private final ModelPart rightBackLeg;
    private final ModelPart r11;
    private final ModelPart r12;
    private final ModelPart r13;
    private final ModelPart r14;
    private final ModelPart r21;
    private final ModelPart r22;
    private final ModelPart r23;
    private final ModelPart r24;
    private final ModelPart r31;
    private final ModelPart r32;
    private final ModelPart r33;
    private final ModelPart r34;
    private final ModelPart r41;
    private final ModelPart r42;
    private final ModelPart r43;
    private final ModelPart r44;

    public TarantulaModel(ModelPart root) {
        this.body = root.getChild("body");
        this.rightFang = root.getChild("rightFang");
        this.leftFang = root.getChild("leftFang");
        this.leftFrontLeg = root.getChild("leftFrontLeg");
        this.l11 = leftFrontLeg.getChild("l11");
        this.l12 = l11.getChild("l12");
        this.l13 = l12.getChild("l13");
        this.l14 = l13.getChild("l14");
        this.leftMiddleLeg1 = root.getChild("leftMiddleLeg1");
        this.l21 = leftMiddleLeg1.getChild("l21");
        this.l22 = l21.getChild("l22");
        this.l23 = l22.getChild("l23");
        this.l24 = l23.getChild("l24");
        this.leftMiddleLeg2 = root.getChild("leftMiddleLeg2");
        this.l31 = leftMiddleLeg2.getChild("l31");
        this.l32 = l31.getChild("l32");
        this.l33 = l32.getChild("l33");
        this.l34 = l33.getChild("l34");
        this.leftBackLeg = root.getChild("leftBackLeg");
        this.l41 = leftBackLeg.getChild("l41");
        this.l42 = l41.getChild("l42");
        this.l43 = l42.getChild("l43");
        this.l44 = l43.getChild("l44");
        this.rightFrontLeg = root.getChild("rightFrontLeg");
        this.r11 = rightFrontLeg.getChild("r11");
        this.r12 = r11.getChild("r12");
        this.r13 = r12.getChild("r13");
        this.r14 = r13.getChild("r14");
        this.rightMiddleLeg1 = root.getChild("rightMiddleLeg1");
        this.r21 = rightMiddleLeg1.getChild("r21");
        this.r22 = r21.getChild("r22");
        this.r23 = r22.getChild("r23");
        this.r24 = r23.getChild("r24");
        this.rightMiddleLeg2 = root.getChild("rightMiddleLeg2");
        this.r31 = rightMiddleLeg2.getChild("r31");
        this.r32 = r31.getChild("r32");
        this.r33 = r32.getChild("r33");
        this.r34 = r33.getChild("r34");
        this.rightBackLeg = root.getChild("rightBackLeg");
        this.r41 = rightBackLeg.getChild("r41");
        this.r42 = r41.getChild("r42");
        this.r43 = r42.getChild("r43");
        this.r44 = r43.getChild("r44");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 56).addBox(-10.0F, -22.0F, -19.0F, 20.0F, 15.0F, 34.0F, new CubeDeformation(0.0F))
                .texOffs(103, 0).addBox(-8.0F, -24.0F, -16.0F, 16.0F, 2.0F, 22.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-19.0F, -33.0F, 22.0F, 38.0F, 29.0F, 27.0F, new CubeDeformation(0.0F))
                .texOffs(101, 98).addBox(-14.0F, -31.0F, 15.0F, 28.0F, 25.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(74, 56).addBox(-14.0F, -29.0F, 49.0F, 28.0F, 23.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 105).addBox(-8.0F, -18.0F, 57.0F, 16.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 26.0F, -17.0F));

        PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(146, 72).addBox(0.0F, -2.0F, 0.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -15.0F, 60.0F, 0.0F, 0.3491F, 0.0F));

        PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(52, 191).addBox(-3.0F, -4.0F, 0.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -13.0F, 60.0F, 0.0F, -0.3491F, 0.0F));

        PartDefinition leftFang = partdefinition.addOrReplaceChild("leftFang", CubeListBuilder.create().texOffs(80, 105).addBox(1.0F, -2.0F, -4.0F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(91, 154).addBox(0.0F, -1.0F, -5.0F, 7.0F, 11.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(18, 56).addBox(1.0F, 10.0F, -4.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(18, 0).addBox(2.0F, 10.75F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(3.0F, 10.75F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, -36.0F));

        PartDefinition rightFang = partdefinition.addOrReplaceChild("rightFang", CubeListBuilder.create().texOffs(0, 21).addBox(-6.0F, -2.0F, -4.0F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(115, 154).addBox(-7.0F, -1.0F, -5.0F, 7.0F, 11.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(144, 93).addBox(-6.0F, 10.0F, -4.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(18, 2).addBox(-5.0F, 10.75F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 2).addBox(-4.0F, 10.75F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, -36.0F));

        PartDefinition leftFrontLeg = partdefinition.addOrReplaceChild("leftFrontLeg", CubeListBuilder.create().texOffs(154, 30).addBox(-3.0F, -5.0F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(62, 182).addBox(4.0F, -4.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 14.0F, -31.0F));

        PartDefinition l11 = leftFrontLeg.addOrReplaceChild("l11", CubeListBuilder.create().texOffs(48, 126).addBox(-3.0F, -15.5F, -3.001F, 6.0F, 15.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(187, 79).addBox(-2.5F, -18.5F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(6.5F, -2.0F, 0.0F));

        PartDefinition l12 = l11.addOrReplaceChild("l12", CubeListBuilder.create().texOffs(0, 153).addBox(-0.5F, -1.0F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(171, 99).addBox(9.5F, -1.0F, -3.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(40, 191).addBox(8.5F, -0.5F, -2.5F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -18.0F, 0.0F));

        PartDefinition l13 = l12.addOrReplaceChild("l13", CubeListBuilder.create().texOffs(102, 170).addBox(1.0F, -0.5F, -3.001F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 191).addBox(0.0F, 0.0F, -2.5F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(17.5F, -0.5F, 0.0F));

        PartDefinition l14 = l13.addOrReplaceChild("l14", CubeListBuilder.create().texOffs(149, 178).addBox(0.0F, -5.0F, -2.5F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, 5.0F, 0.0F));

        PartDefinition leftMiddleLeg1 = partdefinition.addOrReplaceChild("leftMiddleLeg1", CubeListBuilder.create().texOffs(152, 148).addBox(-3.0F, -5.0F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(181, 143).addBox(4.0F, -4.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 14.0F, -23.0F));

        PartDefinition l21 = leftMiddleLeg1.addOrReplaceChild("l21", CubeListBuilder.create().texOffs(24, 126).addBox(-3.0F, -15.5F, -3.001F, 6.0F, 15.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(186, 66).addBox(-2.5F, -18.5F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(6.5F, -2.0F, 0.0F));

        PartDefinition l22 = l21.addOrReplaceChild("l22", CubeListBuilder.create().texOffs(24, 147).addBox(-0.5F, -1.0F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(74, 170).addBox(9.5F, -1.0F, -3.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(190, 116).addBox(8.5F, -0.5F, -2.5F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -18.0F, 0.0F));

        PartDefinition l23 = l22.addOrReplaceChild("l23", CubeListBuilder.create().texOffs(170, 54).addBox(1.0F, -0.5F, -3.001F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(190, 39).addBox(0.0F, 0.0F, -2.5F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(17.5F, -0.5F, 0.0F));

        PartDefinition l24 = l23.addOrReplaceChild("l24", CubeListBuilder.create().texOffs(177, 155).addBox(0.0F, -5.0F, -2.5F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, 5.0F, 0.0F));

        PartDefinition leftMiddleLeg2 = partdefinition.addOrReplaceChild("leftMiddleLeg2", CubeListBuilder.create().texOffs(146, 60).addBox(-3.0F, -5.0F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(42, 181).addBox(4.0F, -4.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 14.0F, -15.0F));

        PartDefinition l31 = leftMiddleLeg2.addOrReplaceChild("l31", CubeListBuilder.create().texOffs(80, 124).addBox(-3.0F, -15.5F, -3.001F, 6.0F, 15.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(15, 186).addBox(-2.5F, -18.5F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(6.5F, -2.0F, 0.0F));

        PartDefinition l32 = l31.addOrReplaceChild("l32", CubeListBuilder.create().texOffs(66, 145).addBox(-0.5F, -1.0F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(46, 169).addBox(9.5F, -1.0F, -3.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(188, 183).addBox(8.5F, -0.5F, -2.5F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -18.0F, 0.0F));

        PartDefinition l33 = l32.addOrReplaceChild("l33", CubeListBuilder.create().texOffs(0, 169).addBox(1.0F, -0.5F, -3.001F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(188, 173).addBox(0.0F, 0.0F, -2.5F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(17.5F, -0.5F, 0.0F));

        PartDefinition l34 = l33.addOrReplaceChild("l34", CubeListBuilder.create().texOffs(23, 176).addBox(0.0F, -5.0F, -2.5F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, 5.0F, 0.0F));

        PartDefinition leftBackLeg = partdefinition.addOrReplaceChild("leftBackLeg", CubeListBuilder.create().texOffs(128, 142).addBox(-3.0F, -5.0F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 181).addBox(4.0F, -4.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 14.0F, -7.0F));

        PartDefinition l41 = leftBackLeg.addOrReplaceChild("l41", CubeListBuilder.create().texOffs(0, 116).addBox(-3.0F, -15.5F, -3.001F, 6.0F, 15.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(184, 29).addBox(-2.5F, -18.5F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(6.5F, -2.0F, 0.0F));

        PartDefinition l42 = l41.addOrReplaceChild("l42", CubeListBuilder.create().texOffs(98, 142).addBox(-0.5F, -1.0F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(161, 166).addBox(9.5F, -1.0F, -3.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(173, 188).addBox(8.5F, -0.5F, -2.5F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -18.0F, 0.0F));

        PartDefinition l43 = l42.addOrReplaceChild("l43", CubeListBuilder.create().texOffs(165, 124).addBox(1.0F, -0.5F, -3.001F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(161, 188).addBox(0.0F, 0.0F, -2.5F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(17.5F, -0.5F, 0.0F));

        PartDefinition l44 = l43.addOrReplaceChild("l44", CubeListBuilder.create().texOffs(176, 19).addBox(0.0F, -5.0F, -2.5F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, 5.0F, 0.0F));

        PartDefinition rightFrontLeg = partdefinition.addOrReplaceChild("rightFrontLeg", CubeListBuilder.create().texOffs(0, 141).addBox(-3.0F, -5.0F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(180, 7).addBox(-7.0F, -4.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.0F, 14.0F, -31.0F));

        PartDefinition r11 = rightFrontLeg.addOrReplaceChild("r11", CubeListBuilder.create().texOffs(62, 105).addBox(-3.0F, -15.5F, -3.001F, 6.0F, 15.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(136, 183).addBox(-1.5F, -18.5F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, -2.0F, 0.0F));

        PartDefinition r12 = r11.addOrReplaceChild("r12", CubeListBuilder.create().texOffs(140, 81).addBox(-8.5F, -1.0F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(164, 87).addBox(-17.5F, -1.0F, -3.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(149, 188).addBox(-9.5F, -0.5F, -2.5F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -18.0F, 0.0F));

        PartDefinition r13 = r12.addOrReplaceChild("r13", CubeListBuilder.create().texOffs(188, 131).addBox(-1.0F, 0.0F, -2.5F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(164, 72).addBox(-9.0F, -0.5F, -3.001F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-17.5F, -0.5F, 0.0F));

        PartDefinition r14 = r13.addOrReplaceChild("r14", CubeListBuilder.create().texOffs(130, 172).addBox(-7.0F, -5.0F, -2.5F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.0F, 5.0F, 0.0F));

        PartDefinition rightMiddleLeg1 = partdefinition.addOrReplaceChild("rightMiddleLeg1", CubeListBuilder.create().texOffs(138, 48).addBox(-3.0F, -5.0F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(173, 178).addBox(-7.0F, -4.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.0F, 14.0F, -23.0F));

        PartDefinition r21 = rightMiddleLeg1.addOrReplaceChild("r21", CubeListBuilder.create().texOffs(38, 105).addBox(-3.0F, -15.5F, -3.001F, 6.0F, 15.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(118, 182).addBox(-1.5F, -18.5F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, -2.0F, 0.0F));

        PartDefinition r22 = r21.addOrReplaceChild("r22", CubeListBuilder.create().texOffs(134, 130).addBox(-8.5F, -1.0F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(24, 163).addBox(-17.5F, -1.0F, -3.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(33, 186).addBox(-9.5F, -0.5F, -2.5F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -18.0F, 0.0F));

        PartDefinition r23 = r22.addOrReplaceChild("r23", CubeListBuilder.create().texOffs(76, 157).addBox(-1.0F, 0.0F, -2.5F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(162, 42).addBox(-9.0F, -0.5F, -3.001F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-17.5F, -0.5F, 0.0F));

        PartDefinition r24 = r23.addOrReplaceChild("r24", CubeListBuilder.create().texOffs(171, 111).addBox(-7.0F, -5.0F, -2.5F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.0F, 5.0F, 0.0F));

        PartDefinition rightMiddleLeg2 = partdefinition.addOrReplaceChild("rightMiddleLeg2", CubeListBuilder.create().texOffs(104, 130).addBox(-3.0F, -5.0F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(103, 10).addBox(-7.0F, -4.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.0F, 14.0F, -15.0F));

        PartDefinition r31 = rightMiddleLeg2.addOrReplaceChild("r31", CubeListBuilder.create().texOffs(0, 56).addBox(-3.0F, -15.5F, -3.001F, 6.0F, 15.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(100, 182).addBox(-1.5F, -18.5F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, -2.0F, 0.0F));

        PartDefinition r32 = r31.addOrReplaceChild("r32", CubeListBuilder.create().texOffs(130, 36).addBox(-8.5F, -1.0F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(139, 160).addBox(-17.5F, -1.0F, -3.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(54, 147).addBox(-9.5F, -0.5F, -2.5F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -18.0F, 0.0F));

        PartDefinition r33 = r32.addOrReplaceChild("r33", CubeListBuilder.create().texOffs(158, 136).addBox(-9.0F, -0.5F, -3.001F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(132, 88).addBox(-1.0F, 0.0F, -2.5F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-17.5F, -0.5F, 0.0F));

        PartDefinition r34 = r33.addOrReplaceChild("r34", CubeListBuilder.create().texOffs(157, 12).addBox(-7.0F, -5.0F, -2.5F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.0F, 5.0F, 0.0F));

        PartDefinition rightBackLeg = partdefinition.addOrReplaceChild("rightBackLeg", CubeListBuilder.create().texOffs(130, 24).addBox(-3.0F, -5.0F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(103, 0).addBox(-7.0F, -4.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.0F, 14.0F, -7.0F));

        PartDefinition r41 = rightBackLeg.addOrReplaceChild("r41", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -15.5F, -3.001F, 6.0F, 15.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(82, 182).addBox(-1.5F, -18.5F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, -2.0F, 0.0F));

        PartDefinition r42 = r41.addOrReplaceChild("r42", CubeListBuilder.create().texOffs(0, 77).addBox(-9.5F, -1.0F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(48, 157).addBox(-18.5F, -1.0F, -3.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(24, 116).addBox(-10.5F, -0.5F, -2.5F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -18.0F, 0.0F));

        PartDefinition r43 = r42.addOrReplaceChild("r43", CubeListBuilder.create().texOffs(86, 110).addBox(-1.0F, 0.0F, -2.5F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(157, 0).addBox(-9.0F, -0.5F, -3.001F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-18.5F, -0.5F, 0.0F));

        PartDefinition r44 = r43.addOrReplaceChild("r44", CubeListBuilder.create().texOffs(108, 87).addBox(-7.0F, -5.0F, -2.5F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.0F, 5.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }

    @Override
    public void setupAnim(Type pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        float f1 = Mth.cos(pLimbSwing * 0.25F) * pLimbSwingAmount * 0.5F;
        double d1 = Math.pow(Mth.cos(pLimbSwing * 0.25F + Mth.PI * 0.25F), 6) * pLimbSwingAmount;
        double d2 = Math.pow(Mth.sin(pLimbSwing * 0.25F + Mth.PI * 0.25F), 6) * pLimbSwingAmount;
        float a1 = 0.61F;
        float a2 = 0.41F;
        float a3;
        float a4;
        float a5;
        float a6;
        Tarantula.TarantulaPose pose = pEntity.getTarantulaPose();
        if (pose == Tarantula.TarantulaPose.RESTING) {
            a3 = 0.26F;
            a4 = 0.7F;
            a5 = 0.65F;
            a6 = 0.17F;
        } else {
            a3 = 0.7F;
            a4 = 0.09F;
            a5 = 0.31F;
            a6 = 0.35F;
        }
        leftFang.yRot = -0.22F;
        rightFang.yRot = 0.22F;
        leftFrontLeg.yRot = a1;
        l11.zRot = a3;
        l12.zRot = a4;
        l13.zRot = a5;
        l14.zRot = -a6;
        leftMiddleLeg1.yRot = a2;
        l21.zRot = a3;
        l22.zRot = a4;
        l23.zRot = a5;
        l24.zRot = -a6;
        leftMiddleLeg2.yRot = -a2;
        l31.zRot = a3;
        l32.zRot = a4;
        l33.zRot = a5;
        l34.zRot = -a6;
        leftBackLeg.yRot = -a1;
        l41.zRot = a3;
        l42.zRot = a4;
        l43.zRot = a5;
        l44.zRot = -a6;
        rightFrontLeg.yRot = -a1;
        r11.zRot = -a3;
        r12.zRot = -a4;
        r13.zRot = -a5;
        r14.zRot = a6;
        rightMiddleLeg1.yRot = -a2;
        r21.zRot = -a3;
        r22.zRot = -a4;
        r23.zRot = -a5;
        r24.zRot = a6;
        rightMiddleLeg2.yRot = a2;
        r31.zRot = -a3;
        r32.zRot = -a4;
        r33.zRot = -a5;
        r34.zRot = a6;
        rightBackLeg.yRot = a1;
        r41.zRot = -a3;
        r42.zRot = -a4;
        r43.zRot = -a5;
        r44.zRot = a6;

        leftFrontLeg.yRot += -f1;
        leftMiddleLeg1.yRot += f1;
        leftMiddleLeg2.yRot += -f1;
        leftBackLeg.yRot += f1;
        rightFrontLeg.yRot += -f1;
        rightMiddleLeg1.yRot += f1;
        rightMiddleLeg2.yRot += -f1;
        rightBackLeg.yRot += f1;
        l11.zRot += -d2 * 0.25F;
        l12.zRot += -d2 * 0.5F;
        l21.zRot += -d1 * 0.25F;
        l22.zRot += -d1 * 0.5F;
        l31.zRot += -d2 * 0.25F;
        l32.zRot += -d2 * 0.5F;
        l41.zRot += -d1 * 0.25F;
        l42.zRot += -d1 * 0.5F;
        r11.zRot += d1 * 0.25F;
        r12.zRot += d1 * 0.5F;
        r21.zRot += d2 * 0.25F;
        r22.zRot += d2 * 0.5F;
        r31.zRot += d1 * 0.25F;
        r32.zRot += d1 * 0.5F;
        r41.zRot += d2 * 0.25F;
        r42.zRot += d2 * 0.5F;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        rightFang.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leftFang.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
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
