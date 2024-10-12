package net.invictusslayer.slayersbeasts.common.client.model;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.client.animation.AntQueenAnimation;
import net.invictusslayer.slayersbeasts.common.entity.AntQueen;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class AntQueenModel<T extends AntQueen> extends HierarchicalModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "ant_queen_model"), "main");
	private final ModelPart root;

	public AntQueenModel(ModelPart root) {
		this.root = root;
	}

	public ModelPart root() {
		return root;
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		root.getAllParts().forEach(ModelPart::resetPose);
		animateWalk(AntQueenAnimation.WALK, limbSwing, limbSwingAmount, 15, 10);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(47, 44).addBox(-2.0F, -2.5F, -12.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-2.5F, -5.0F, -10.0F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 23).addBox(-3.5F, -7.5F, -9.0F, 7.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(32, 33).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 3.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(33, 0).addBox(-4.0F, -1.0F, 0.0F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-5.0F, -2.0F, 1.0F, 10.0F, 10.0F, 13.0F, new CubeDeformation(0.0F))
				.texOffs(32, 23).addBox(-4.0F, -0.5F, 14.0F, 8.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 3.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 40).addBox(-3.0F, 0.0F, -2.75F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(33, 44).addBox(-2.0F, 3.0F, -2.75F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, -10.0F, -0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r4 = head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 10).addBox(0.0F, 0.0F, -0.25F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 5.0F, -2.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition cube_r5 = head.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(6, 10).addBox(-1.0F, 0.0F, -0.25F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 5.0F, -2.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition cube_r6 = head.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(4, 23).addBox(-0.5448F, -4.6513F, -1.0582F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -4.0F, -4.0F, 1.7017F, 0.0F, -0.1309F));

		PartDefinition cube_r7 = head.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(27, 23).addBox(0.0F, -5.0F, -0.75F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.7854F, -0.4363F, 0.0F));

		PartDefinition cube_r8 = head.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 23).addBox(-0.4552F, -4.6513F, -1.0582F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -4.0F, -4.0F, 1.7017F, 0.0F, 0.1309F));

		PartDefinition cube_r9 = head.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(23, 23).addBox(-1.0F, -5.0F, -0.75F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.7854F, 0.4363F, 0.0F));

		PartDefinition leg_left_front = body.addOrReplaceChild("leg_left_front", CubeListBuilder.create().texOffs(48, 35).addBox(-0.5F, 0.0F, -0.5F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(49, 39).addBox(2.25F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(44, 33).addBox(2.25F, -4.0F, 0.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -6.0F, -8.0F, 0.6981F, 0.4363F, 1.0908F));

		PartDefinition leg_left_mid = body.addOrReplaceChild("leg_left_mid", CubeListBuilder.create().texOffs(46, 17).addBox(-0.5F, 0.0F, -0.5F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(36, 49).addBox(3.25F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(18, 44).addBox(3.25F, -4.0F, 0.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -5.75F, -5.0F, 0.0F, 0.0F, 0.829F));

		PartDefinition leg_left_hind = body.addOrReplaceChild("leg_left_hind", CubeListBuilder.create().texOffs(14, 46).addBox(-0.5F, 0.0F, -0.5F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(46, 48).addBox(3.25F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(33, 11).addBox(3.25F, -5.0F, 0.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -5.75F, -2.0F, -0.48F, -0.6109F, 1.0036F));

		PartDefinition leg_right_front = body.addOrReplaceChild("leg_right_front", CubeListBuilder.create().texOffs(0, 6).addBox(-3.5F, 0.0F, -0.5F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(32, 49).addBox(-3.25F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(32, 42).addBox(-10.25F, -4.0F, 0.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -6.0F, -8.0F, 0.6981F, -0.4363F, -1.0908F));

		PartDefinition leg_right_mid = body.addOrReplaceChild("leg_right_mid", CubeListBuilder.create().texOffs(46, 13).addBox(-4.5F, 0.0F, -0.5F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(32, 33).addBox(-4.25F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(15, 41).addBox(-11.25F, -4.0F, 0.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -5.75F, -5.0F, 0.0F, 0.0F, -0.829F));

		PartDefinition leg_right_hind = body.addOrReplaceChild("leg_right_hind", CubeListBuilder.create().texOffs(0, 46).addBox(-4.5F, 0.0F, -0.5F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(28, 46).addBox(-4.25F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(33, 9).addBox(-13.25F, -5.0F, 0.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -5.75F, -2.0F, -0.48F, 0.6109F, -1.0036F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}
}
