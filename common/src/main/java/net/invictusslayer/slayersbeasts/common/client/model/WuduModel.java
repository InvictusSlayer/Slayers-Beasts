package net.invictusslayer.slayersbeasts.common.client.model;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.client.animation.WuduAnimation;
import net.invictusslayer.slayersbeasts.common.entity.Wudu;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class WuduModel<T extends Wudu> extends HierarchicalModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SlayersBeasts.MOD_ID, "wudu_model"), "main");
	private final ModelPart root;

	public WuduModel(ModelPart root) {
		this.root = root;
	}

	public ModelPart root() {
		return root;
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		root.getAllParts().forEach(ModelPart::resetPose);
		animateWalk(WuduAnimation.CRAWL, limbSwing, limbSwingAmount, 5, 10);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -16.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition arm_left = body.addOrReplaceChild("arm_left", CubeListBuilder.create().texOffs(48, 8).addBox(-2.0F, -2.0F, -2.0F, 20.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -11.0F, -1.0F, 0.0F, -0.6981F, 0.5236F));

		PartDefinition forearm_left = arm_left.addOrReplaceChild("forearm_left", CubeListBuilder.create().texOffs(31, 38).addBox(-3.0F, -3.0F, -16.0F, 6.0F, 6.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(18.0F, 0.0F, 0.0F, 0.0F, 0.6981F, 0.0873F));

		PartDefinition hand_left = forearm_left.addOrReplaceChild("hand_left", CubeListBuilder.create().texOffs(62, 19).addBox(-4.0F, -1.0F, -13.0F, 8.0F, 8.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -16.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition fl_01 = hand_left.addOrReplaceChild("fl_01", CubeListBuilder.create().texOffs(29, 63).addBox(-5.0F, -1.5F, -1.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 4.0F, -10.0F, -0.3491F, -0.9599F, 0.0F));

		PartDefinition fl_02 = fl_01.addOrReplaceChild("fl_02", CubeListBuilder.create().texOffs(0, 36).addBox(-6.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition fl_03 = fl_02.addOrReplaceChild("fl_03", CubeListBuilder.create().texOffs(91, 19).addBox(-7.0F, -1.5F, -1.5F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3054F));

		PartDefinition fl_11 = hand_left.addOrReplaceChild("fl_11", CubeListBuilder.create().texOffs(90, 40).addBox(-1.5F, -1.5F, -6.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 2.0F, -13.0F, -0.0873F, 0.1745F, 0.0F));

		PartDefinition fl_12 = fl_11.addOrReplaceChild("fl_12", CubeListBuilder.create().texOffs(0, 89).addBox(-1.0F, -1.0F, -9.0F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition fl_13 = fl_12.addOrReplaceChild("fl_13", CubeListBuilder.create().texOffs(64, 88).addBox(-1.5F, -1.5F, -7.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -9.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition fl_21 = hand_left.addOrReplaceChild("fl_21", CubeListBuilder.create().texOffs(28, 85).addBox(-1.5F, -1.5F, -6.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -13.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition fl_22 = fl_21.addOrReplaceChild("fl_22", CubeListBuilder.create().texOffs(50, 85).addBox(-1.0F, -1.0F, -9.0F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition fl_23 = fl_22.addOrReplaceChild("fl_23", CubeListBuilder.create().texOffs(88, 8).addBox(-1.5F, -1.5F, -7.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -9.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition fl_31 = hand_left.addOrReplaceChild("fl_31", CubeListBuilder.create().texOffs(14, 81).addBox(-1.5F, -1.5F, -6.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 2.0F, -13.0F, -0.0873F, -0.1745F, 0.0F));

		PartDefinition fl_32 = fl_31.addOrReplaceChild("fl_32", CubeListBuilder.create().texOffs(78, 54).addBox(-1.0F, -1.0F, -9.0F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition fl_33 = fl_32.addOrReplaceChild("fl_33", CubeListBuilder.create().texOffs(84, 80).addBox(-1.5F, -1.5F, -7.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -9.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition arm_right = body.addOrReplaceChild("arm_right", CubeListBuilder.create().texOffs(48, 0).addBox(-18.0F, -2.0F, -2.0F, 20.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -11.0F, -1.0F, 0.0F, 0.6981F, -0.5236F));

		PartDefinition forearm_right = arm_right.addOrReplaceChild("forearm_right", CubeListBuilder.create().texOffs(0, 32).addBox(-3.0F, -3.0F, -16.0F, 6.0F, 6.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.0F, 0.0F, 0.0F, 0.0F, -0.6981F, -0.0873F));

		PartDefinition hand_right = forearm_right.addOrReplaceChild("hand_right", CubeListBuilder.create().texOffs(0, 57).addBox(-4.0F, -1.0F, -13.0F, 8.0F, 8.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -16.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition fr_01 = hand_right.addOrReplaceChild("fr_01", CubeListBuilder.create().texOffs(31, 32).addBox(-3.0F, -1.5F, -1.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 4.0F, -10.0F, -0.3491F, 0.9599F, 0.0F));

		PartDefinition fr_02 = fr_01.addOrReplaceChild("fr_02", CubeListBuilder.create().texOffs(0, 32).addBox(-1.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition fr_03 = fr_02.addOrReplaceChild("fr_03", CubeListBuilder.create(), PartPose.offset(5.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = fr_03.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(90, 65).addBox(0.0F, -1.5F, -1.5F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3054F));

		PartDefinition fr_11 = hand_right.addOrReplaceChild("fr_11", CubeListBuilder.create().texOffs(62, 40).addBox(-1.5F, -1.5F, -6.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 2.0F, -13.0F, -0.0873F, -0.1745F, 0.0F));

		PartDefinition fr_12 = fr_11.addOrReplaceChild("fr_12", CubeListBuilder.create().texOffs(42, 63).addBox(-1.0F, -1.0F, -9.0F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition fr_13 = fr_12.addOrReplaceChild("fr_13", CubeListBuilder.create().texOffs(64, 63).addBox(-1.5F, -1.5F, -7.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -9.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition fr_21 = hand_right.addOrReplaceChild("fr_21", CubeListBuilder.create().texOffs(34, 74).addBox(-1.5F, -1.5F, -6.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -13.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition fr_22 = fr_21.addOrReplaceChild("fr_22", CubeListBuilder.create().texOffs(56, 74).addBox(-1.0F, -1.0F, -9.0F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition fr_23 = fr_22.addOrReplaceChild("fr_23", CubeListBuilder.create().texOffs(76, 43).addBox(-1.5F, -1.5F, -7.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -9.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition fr_31 = hand_right.addOrReplaceChild("fr_31", CubeListBuilder.create().texOffs(70, 77).addBox(-1.5F, -1.5F, -6.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 2.0F, -13.0F, -0.0873F, 0.1745F, 0.0F));

		PartDefinition fr_32 = fr_31.addOrReplaceChild("fr_32", CubeListBuilder.create().texOffs(77, 65).addBox(-1.0F, -1.0F, -9.0F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition fr_33 = fr_32.addOrReplaceChild("fr_33", CubeListBuilder.create().texOffs(0, 78).addBox(-1.5F, -1.5F, -7.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -9.0F, 0.3491F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
}
