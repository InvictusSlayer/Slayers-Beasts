package net.invictusslayer.slayersbeasts.common.client.model;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.client.animation.MantisAnimation;
import net.invictusslayer.slayersbeasts.common.entity.Mantis;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class MantisModel<T extends Mantis> extends HierarchicalModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SlayersBeasts.MOD_ID, "mantis_model"), "main");
	private final ModelPart root;
	private final ModelPart head;

	public MantisModel(ModelPart root) {
		this.root = root;
		this.head = root.getChild("body").getChild("head");
	}

	public ModelPart root() {
		return root;
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		root.getAllParts().forEach(ModelPart::resetPose);
		head.xRot += headPitch * Mth.PI / 180F;
		head.yRot = netHeadYaw * Mth.PI / 180F;
		if (entity.isScuttling()) {
			animateWalk(MantisAnimation.SCUTTLE, limbSwing, limbSwingAmount, 10, 10);
		} else {
			animateWalk(MantisAnimation.WALK, limbSwing, limbSwingAmount, 10, 10);
			animate(Mantis.strikeAnimationState, MantisAnimation.STRIKE, ageInTicks);
		}
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -1.0F, -17.0F, 5.0F, 3.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, -0.48F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -1.0F, -4.0F, 9.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(41, 47).addBox(-3.5F, 4.0F, -3.5F, 7.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(60, 22).addBox(-3.0F, 6.0F, -3.0F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(57, 31).addBox(-2.0F, -3.0F, -2.0F, 5.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 1.0F, -2.5F, -0.3927F, 0.8727F, 0.0F));

		PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(60, 5).addBox(-3.0F, -3.0F, -2.0F, 5.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 1.0F, -2.5F, -0.3927F, -0.8727F, 0.0F));

		PartDefinition cube_r3 = head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -9.5F, -12.0F, 0.0F, 9.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -0.5F, -2.0F, 0.0F, -0.1745F, 0.0F));

		PartDefinition cube_r4 = head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(38, 0).addBox(0.0F, -9.5F, -12.0F, 0.0F, 9.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -0.5F, -2.0F, 0.0F, 0.1745F, 0.0F));

		PartDefinition jaw_left = head.addOrReplaceChild("jaw_left", CubeListBuilder.create().texOffs(62, 0).addBox(0.0F, 0.0F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, -2.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition jaw_right = head.addOrReplaceChild("jaw_right", CubeListBuilder.create().texOffs(64, 13).addBox(-4.0F, 0.0F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, -2.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition abdomen = body.addOrReplaceChild("abdomen", CubeListBuilder.create().texOffs(0, 31).addBox(-5.0F, -4.0F, 0.0F, 10.0F, 5.0F, 21.0F, new CubeDeformation(0.0F))
				.texOffs(38, 0).addBox(-4.0F, -4.0F, 21.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 11.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition leg_left_front = body.addOrReplaceChild("leg_left_front", CubeListBuilder.create().texOffs(16, 61).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 2.0F, -9.0F, 0.3491F, -0.3491F, -0.3054F));

		PartDefinition l11 = leg_left_front.addOrReplaceChild("l11", CubeListBuilder.create().texOffs(50, 47).addBox(-0.999F, -1.0F, -11.0F, 2.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(0.0F, 3.0F, -8.5F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, -1.1781F, 0.0F, 0.0F));

		PartDefinition l12 = l11.addOrReplaceChild("l12", CubeListBuilder.create().texOffs(66, 47).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(32, 59).addBox(0.001F, 4.5F, 0.0F, 0.0F, 14.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(69, 39).addBox(-0.5F, 9.0F, -1.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -10.0F, 0.9163F, 0.0F, 0.0F));

		PartDefinition leg_left_mid = body.addOrReplaceChild("leg_left_mid", CubeListBuilder.create().texOffs(54, 63).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(16, 57).addBox(1.001F, 6.0F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(8, 57).addBox(8.001F, 8.0F, -1.0F, 2.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 2.0F, -2.0F, 0.3491F, 0.5236F, -0.1309F));

		PartDefinition leg_left_hind = body.addOrReplaceChild("leg_left_hind", CubeListBuilder.create().texOffs(46, 63).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(38, 22).addBox(1.001F, 6.0F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 57).addBox(8.001F, 8.0F, -1.0F, 2.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 2.0F, 2.0F, 0.6981F, -0.2182F, -0.6545F));

		PartDefinition leg_right_front = body.addOrReplaceChild("leg_right_front", CubeListBuilder.create().texOffs(38, 57).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 2.0F, -9.0F, 0.3491F, 0.3491F, 0.3054F));

		PartDefinition r11 = leg_right_front.addOrReplaceChild("r11", CubeListBuilder.create().texOffs(41, 31).addBox(-1.001F, -1.0F, -11.0F, 2.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, 3.0F, -8.5F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, -1.1781F, 0.0F, 0.0F));

		PartDefinition r12 = r11.addOrReplaceChild("r12", CubeListBuilder.create().texOffs(62, 63).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(16, 29).addBox(-0.001F, 4.5F, 0.0F, 0.0F, 14.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(49, 31).addBox(-0.5F, 9.0F, -1.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -10.0F, 0.9163F, 0.0F, 0.0F));

		PartDefinition leg_right_mid = body.addOrReplaceChild("leg_right_mid", CubeListBuilder.create().texOffs(24, 61).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(38, 8).addBox(-9.999F, 6.0F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(8, 31).addBox(-9.999F, 8.0F, -1.0F, 2.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 2.0F, -2.0F, 0.3491F, -0.5236F, 0.1309F));

		PartDefinition leg_right_hind = body.addOrReplaceChild("leg_right_hind", CubeListBuilder.create().texOffs(41, 31).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(-9.999F, 6.0F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 31).addBox(-9.999F, 8.0F, -1.0F, 2.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 2.0F, 2.0F, 0.6981F, 0.2182F, 0.6545F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
}
