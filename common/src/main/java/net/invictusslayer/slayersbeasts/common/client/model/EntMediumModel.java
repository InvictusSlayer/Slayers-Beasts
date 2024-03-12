package net.invictusslayer.slayersbeasts.common.client.model;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.client.animation.EntMediumAnimation;
import net.invictusslayer.slayersbeasts.common.entity.EntMedium;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class EntMediumModel<T extends EntMedium> extends HierarchicalModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SlayersBeasts.MOD_ID, "ent_medium_model"), "main");
	private final ModelPart root;
	private final ModelPart head;

	public EntMediumModel(ModelPart root) {
		this.root = root;
		this.head = root.getChild("body").getChild("head");
	}

	public ModelPart root() {
		return root;
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		root.getAllParts().forEach(ModelPart::resetPose);
		head.yRot = netHeadYaw * Mth.PI / 180F;
		animateWalk(EntMediumAnimation.WALK, limbSwing, limbSwingAmount, 8, 10);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(34, 33).addBox(-6.0F, -3.5F, -4.0F, 12.0F, 15.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(48, 10).addBox(-7.0F, -7.5F, -5.0F, 14.0F, 4.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-9.0F, -16.5F, -6.0F, 18.0F, 9.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(90, 55).addBox(6.0F, -17.5F, -5.0F, 6.0F, 4.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(90, 41).addBox(-12.0F, -17.5F, -5.0F, 6.0F, 4.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(47, 0).addBox(12.0F, -17.5F, -4.0F, 4.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(31, 20).addBox(-16.0F, -17.5F, -4.0F, 4.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -21.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 20).addBox(-5.0F, -10.5F, -5.0F, 10.0F, 10.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -16.0F, -1.0F));

		PartDefinition branch = head.addOrReplaceChild("branch", CubeListBuilder.create().texOffs(0, 0).addBox(2.0F, -8.5F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(24, 80).addBox(-1.0F, -13.5F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, 0.5236F, 0.0F, 0.3491F));

		PartDefinition branch2 = head.addOrReplaceChild("branch2", CubeListBuilder.create().texOffs(0, 0).addBox(2.0F, -8.5F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(24, 80).addBox(-1.0F, -13.5F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, -0.3873F, 0.0665F, 0.1615F));

		PartDefinition branch3 = head.addOrReplaceChild("branch3", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -8.5F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(24, 80).addBox(-4.0F, -13.5F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, 0.3054F, 0.0F, 0.1309F));

		PartDefinition branch4 = head.addOrReplaceChild("branch4", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -8.5F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(24, 80).addBox(-6.0F, -13.5F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, -0.48F, 0.0F, -0.3491F));

		PartDefinition branch5 = head.addOrReplaceChild("branch5", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -8.5F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(24, 80).addBox(-6.0F, -13.5F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, 0.1745F, 0.0F, -0.5672F));

		PartDefinition arm_left = body.addOrReplaceChild("arm_left", CubeListBuilder.create().texOffs(100, 19).addBox(2.0F, -2.5F, -3.0F, 4.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, -14.0F, 0.0F));

		PartDefinition arm_lower_left = arm_left.addOrReplaceChild("arm_lower_left", CubeListBuilder.create().texOffs(66, 24).addBox(-4.0F, 10.0F, -4.5F, 8.0F, 8.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(80, 100).addBox(2.0F, 18.0F, -3.5F, 2.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(87, 81).addBox(-3.0F, -2.0F, -3.5F, 6.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 9.5F, -0.5F));

		PartDefinition arm_right = body.addOrReplaceChild("arm_right", CubeListBuilder.create().texOffs(24, 96).addBox(-6.0F, -2.5F, -3.0F, 4.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, -14.0F, 0.0F));

		PartDefinition arm_lower_right = arm_right.addOrReplaceChild("arm_lower_right", CubeListBuilder.create().texOffs(94, 68).addBox(-4.0F, 18.0F, -3.5F, 2.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(86, 0).addBox(-3.0F, -2.0F, -3.5F, 6.0F, 12.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(65, 47).addBox(-4.0F, 10.0F, -4.5F, 8.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 9.5F, -0.5F));

		PartDefinition leg_left = body.addOrReplaceChild("leg_left", CubeListBuilder.create().texOffs(0, 88).addBox(-3.0F, -1.5F, -3.0F, 6.0F, 15.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 11.0F, 0.0F, -0.3927F, -0.3491F, 0.0F));

		PartDefinition leg_lower_left = leg_left.addOrReplaceChild("leg_lower_left", CubeListBuilder.create().texOffs(0, 46).addBox(-5.0F, 13.5F, -2.0F, 10.0F, 8.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(0, 66).addBox(-4.0F, -0.5F, -1.0F, 8.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 14.0F, -3.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition leg_right = body.addOrReplaceChild("leg_right", CubeListBuilder.create().texOffs(56, 88).addBox(-3.0F, -1.5F, -3.0F, 6.0F, 15.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 11.0F, 0.0F, -0.3927F, 0.3491F, 0.0F));

		PartDefinition leg_lower_right = leg_right.addOrReplaceChild("leg_lower_right", CubeListBuilder.create().texOffs(30, 56).addBox(-5.0F, 13.5F, -2.0F, 10.0F, 8.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(62, 66).addBox(-4.0F, -0.5F, -1.0F, 8.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 14.0F, -3.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition branch_left = body.addOrReplaceChild("branch_left", CubeListBuilder.create(), PartPose.offset(12.0F, -17.0F, -1.0F));

		PartDefinition cube_r1 = branch_left.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -8.5F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(24, 80).addBox(-3.0F, -14.5F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.2182F, 0.0F, 0.3927F));

		PartDefinition cube_r2 = branch_left.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(24, 80).addBox(-2.0F, -11.5F, -3.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.1415F, 0.1666F, -0.4681F));

		PartDefinition cube_r3 = branch_left.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(24, 80).addBox(-3.0F, -13.5F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, -8.5F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition branch_right = body.addOrReplaceChild("branch_right", CubeListBuilder.create(), PartPose.offset(-12.0F, -17.0F, -1.0F));

		PartDefinition cube_r4 = branch_right.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -8.5F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(24, 80).addBox(-3.0F, -12.5F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition cube_r5 = branch_right.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(24, 80).addBox(-1.0F, -11.5F, -3.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r6 = branch_right.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(24, 80).addBox(-3.0F, -13.5F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, -8.5F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
}
