package net.invictusslayer.slayersbeasts.common.client.model;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.client.animation.TyrachnidAnimation;
import net.invictusslayer.slayersbeasts.common.entity.Tyrachnid;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class TyrachnidModel<T extends Tyrachnid> extends HierarchicalModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "tyrachnid_model"), "main");
	private final ModelPart root;

	public TyrachnidModel(ModelPart root) {
		this.root = root;
	}

	public ModelPart root() {
		return root;
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		root.getAllParts().forEach(ModelPart::resetPose);
		animateWalk(TyrachnidAnimation.WALK, limbSwing, limbSwingAmount, 8, 10);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 56).addBox(-10.0F, -10.0F, -29.0F, 20.0F, 18.0F, 34.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-19.0F, -18.0F, 12.0F, 38.0F, 29.0F, 27.0F, new CubeDeformation(0.0F))
				.texOffs(101, 101).addBox(-14.0F, -16.0F, 5.0F, 28.0F, 25.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(74, 56).addBox(-14.0F, -13.0F, 39.0F, 28.0F, 22.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, 5.0F));

		PartDefinition fang_left = body.addOrReplaceChild("fang_left", CubeListBuilder.create().texOffs(30, 159).addBox(0.0F, -2.0F, -5.0F, 7.0F, 12.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 21).addBox(1.0F, 10.0F, -4.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(16, 0).addBox(2.0F, 11.75F, -1.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -29.0F));

		PartDefinition fang_right = body.addOrReplaceChild("fang_right", CubeListBuilder.create().texOffs(162, 36).addBox(-7.0F, -2.0F, -5.0F, 7.0F, 12.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(18, 56).addBox(-6.0F, 10.0F, -4.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(16, 2).addBox(-5.0F, 11.75F, -1.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -29.0F));

		PartDefinition leg_left_front = body.addOrReplaceChild("leg_left_front", CubeListBuilder.create().texOffs(159, 12).addBox(-3.0F, -5.0F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(151, 179).addBox(4.0F, -4.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 3.0F, -24.0F, 0.2182F, 0.6545F, 0.3491F));

		PartDefinition l11 = leg_left_front.addOrReplaceChild("l11", CubeListBuilder.create().texOffs(118, 133).addBox(-3.0F, -15.5F, -3.001F, 6.0F, 15.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(186, 36).addBox(-2.5F, -18.5F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0436F));

		PartDefinition l12 = l11.addOrReplaceChild("l12", CubeListBuilder.create().texOffs(103, 0).addBox(-0.5F, -1.0F, -3.0F, 13.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 77).addBox(13.5F, -1.0F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 187).addBox(12.5F, -0.5F, -2.5F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -18.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition l13 = l12.addOrReplaceChild("l13", CubeListBuilder.create().texOffs(164, 72).addBox(1.0F, -0.5F, -3.001F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(186, 63).addBox(0.0F, 0.0F, -2.5F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(22.5F, -0.5F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition l14 = l13.addOrReplaceChild("l14", CubeListBuilder.create().texOffs(164, 98).addBox(0.0F, -5.0F, -2.5F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 5.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition leg_left_mid_front = body.addOrReplaceChild("leg_left_mid_front", CubeListBuilder.create().texOffs(159, 0).addBox(-3.0F, -5.0F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(131, 179).addBox(4.0F, -4.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 3.0F, -16.0F, 0.1309F, 0.4363F, 0.3054F));

		PartDefinition l21 = leg_left_mid_front.addOrReplaceChild("l21", CubeListBuilder.create().texOffs(94, 133).addBox(-3.0F, -15.5F, -3.001F, 6.0F, 15.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(33, 186).addBox(-2.5F, -18.5F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0436F));

		PartDefinition l22 = l21.addOrReplaceChild("l22", CubeListBuilder.create().texOffs(130, 24).addBox(-0.5F, -1.0F, -3.0F, 13.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(156, 157).addBox(13.5F, -1.0F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(147, 189).addBox(12.5F, -0.5F, -2.5F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -18.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition l23 = l22.addOrReplaceChild("l23", CubeListBuilder.create().texOffs(168, 24).addBox(1.0F, -0.5F, -3.001F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(135, 189).addBox(0.0F, 0.0F, -2.5F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(22.5F, -0.5F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition l24 = l23.addOrReplaceChild("l24", CubeListBuilder.create().texOffs(47, 177).addBox(0.0F, -5.0F, -2.5F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 5.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition leg_left_mid_hind = body.addOrReplaceChild("leg_left_mid_hind", CubeListBuilder.create().texOffs(126, 157).addBox(-3.0F, -5.0F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(111, 179).addBox(4.0F, -4.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 3.0F, -8.0F, 0.0436F, 0.1309F, 0.2618F));

		PartDefinition l31 = leg_left_mid_hind.addOrReplaceChild("l31", CubeListBuilder.create().texOffs(24, 132).addBox(-3.0F, -15.5F, -3.001F, 6.0F, 15.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(15, 186).addBox(-2.5F, -18.5F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0436F));

		PartDefinition l32 = l31.addOrReplaceChild("l32", CubeListBuilder.create().texOffs(38, 120).addBox(-0.5F, -1.0F, -3.0F, 13.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(96, 154).addBox(13.5F, -1.0F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(189, 134).addBox(12.5F, -0.5F, -2.5F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -18.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition l33 = l32.addOrReplaceChild("l33", CubeListBuilder.create().texOffs(166, 139).addBox(1.0F, -0.5F, -3.001F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(123, 189).addBox(0.0F, 0.0F, -2.5F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(22.5F, -0.5F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition l34 = l33.addOrReplaceChild("l34", CubeListBuilder.create().texOffs(23, 176).addBox(0.0F, -5.0F, -2.5F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 5.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition leg_left_hind = body.addOrReplaceChild("leg_left_hind", CubeListBuilder.create().texOffs(66, 153).addBox(-3.0F, -5.0F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(91, 178).addBox(4.0F, -4.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 3.0F, 0.0F, -0.0873F, -0.3054F, 0.2618F));

		PartDefinition l41 = leg_left_hind.addOrReplaceChild("l41", CubeListBuilder.create().texOffs(0, 132).addBox(-3.0F, -15.5F, -3.001F, 6.0F, 15.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(184, 184).addBox(-2.5F, -18.5F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0436F));

		PartDefinition l42 = l41.addOrReplaceChild("l42", CubeListBuilder.create().texOffs(0, 120).addBox(-0.5F, -1.0F, -3.0F, 13.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 153).addBox(13.5F, -1.0F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(111, 189).addBox(12.5F, -0.5F, -2.5F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -18.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition l43 = l42.addOrReplaceChild("l43", CubeListBuilder.create().texOffs(166, 127).addBox(1.0F, -0.5F, -3.001F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(189, 46).addBox(0.0F, 0.0F, -2.5F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(22.5F, -0.5F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition l44 = l43.addOrReplaceChild("l44", CubeListBuilder.create().texOffs(171, 108).addBox(0.0F, -5.0F, -2.5F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 5.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition leg_right_front = body.addOrReplaceChild("leg_right_front", CubeListBuilder.create().texOffs(42, 147).addBox(-6.0F, -5.0F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(71, 178).addBox(-9.0F, -4.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 3.0F, -24.0F, 0.2182F, -0.6545F, -0.3491F));

		PartDefinition r11 = leg_right_front.addOrReplaceChild("r11", CubeListBuilder.create().texOffs(70, 129).addBox(-3.0F, -15.5F, -3.001F, 6.0F, 15.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(166, 184).addBox(-1.5F, -18.5F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, -2.0F, 0.0F, 0.0F, 0.0F, -0.0436F));

		PartDefinition r12 = r11.addOrReplaceChild("r12", CubeListBuilder.create().texOffs(108, 86).addBox(-12.5F, -1.0F, -3.0F, 13.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(146, 60).addBox(-22.5F, -1.0F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(188, 118).addBox(-13.5F, -0.5F, -2.5F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -18.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition r13 = r12.addOrReplaceChild("r13", CubeListBuilder.create().texOffs(99, 188).addBox(-1.0F, 0.0F, -2.5F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(82, 166).addBox(-9.0F, -0.5F, -3.001F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-22.5F, -0.5F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition r14 = r13.addOrReplaceChild("r14", CubeListBuilder.create().texOffs(170, 53).addBox(-7.0F, -5.0F, -2.5F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition leg_right_mid_front = body.addOrReplaceChild("leg_right_mid_front", CubeListBuilder.create().texOffs(142, 145).addBox(-6.0F, -5.0F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(177, 174).addBox(-9.0F, -4.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 3.0F, -16.0F, 0.1309F, -0.4363F, -0.3054F));

		PartDefinition r21 = leg_right_mid_front.addOrReplaceChild("r21", CubeListBuilder.create().texOffs(76, 108).addBox(-3.0F, -15.5F, -3.001F, 6.0F, 15.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(184, 7).addBox(-1.5F, -18.5F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, -2.0F, 0.0F, 0.0F, 0.0F, -0.0436F));

		PartDefinition r22 = r21.addOrReplaceChild("r22", CubeListBuilder.create().texOffs(38, 108).addBox(-12.5F, -1.0F, -3.0F, 13.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(142, 133).addBox(-22.5F, -1.0F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(87, 188).addBox(-13.5F, -0.5F, -2.5F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -18.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition r23 = r22.addOrReplaceChild("r23", CubeListBuilder.create().texOffs(75, 188).addBox(-1.0F, 0.0F, -2.5F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(54, 165).addBox(-9.0F, -0.5F, -3.001F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-22.5F, -0.5F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition r24 = r23.addOrReplaceChild("r24", CubeListBuilder.create().texOffs(158, 169).addBox(-7.0F, -5.0F, -2.5F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition leg_right_mid_hind = body.addOrReplaceChild("leg_right_mid_hind", CubeListBuilder.create().texOffs(140, 80).addBox(-6.0F, -5.0F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 177).addBox(-9.0F, -4.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 3.0F, -8.0F, 0.0436F, -0.1309F, -0.2618F));

		PartDefinition r31 = leg_right_mid_hind.addOrReplaceChild("r31", CubeListBuilder.create().texOffs(0, 56).addBox(-3.0F, -15.5F, -3.001F, 6.0F, 15.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(181, 164).addBox(-1.5F, -18.5F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, -2.0F, 0.0F, 0.0F, 0.0F, -0.0436F));

		PartDefinition r32 = r31.addOrReplaceChild("r32", CubeListBuilder.create().texOffs(0, 108).addBox(-12.5F, -1.0F, -3.0F, 13.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(138, 48).addBox(-22.5F, -1.0F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(187, 93).addBox(-13.5F, -0.5F, -2.5F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -18.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition r33 = r32.addOrReplaceChild("r33", CubeListBuilder.create().texOffs(0, 165).addBox(-9.0F, -0.5F, -3.001F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(187, 79).addBox(-1.0F, 0.0F, -2.5F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-22.5F, -0.5F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition r34 = r33.addOrReplaceChild("r34", CubeListBuilder.create().texOffs(134, 169).addBox(-7.0F, -5.0F, -2.5F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition leg_right_hind = body.addOrReplaceChild("leg_right_hind", CubeListBuilder.create().texOffs(135, 6).addBox(-6.0F, -5.0F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(48, 132).addBox(-9.0F, -4.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 3.0F, 0.0F, -0.0873F, 0.3054F, -0.2618F));

		PartDefinition r41 = leg_right_hind.addOrReplaceChild("r41", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -15.5F, -3.001F, 6.0F, 15.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(180, 151).addBox(-1.5F, -18.5F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, -2.0F, 0.0F, 0.0F, 0.0F, -0.0436F));

		PartDefinition r42 = r41.addOrReplaceChild("r42", CubeListBuilder.create().texOffs(103, 12).addBox(-12.5F, -1.0F, -3.0F, 13.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(130, 36).addBox(-22.5F, -1.0F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(63, 187).addBox(-13.5F, -0.5F, -2.5F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -18.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition r43 = r42.addOrReplaceChild("r43", CubeListBuilder.create().texOffs(51, 187).addBox(-1.25F, 0.25F, -2.5F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(164, 86).addBox(-9.25F, -0.25F, -3.001F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-22.25F, -0.75F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition r44 = r43.addOrReplaceChild("r44", CubeListBuilder.create().texOffs(110, 169).addBox(-7.0F, -5.0F, -2.5F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.25F, 5.25F, 0.0F, 0.0F, 0.0F, 0.3491F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}
}
