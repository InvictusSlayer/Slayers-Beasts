package net.invictusslayer.slayersbeasts.client.model;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.animation.IrkAnimation;
import net.invictusslayer.slayersbeasts.entity.Irk;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class IrkModel<T extends Irk> extends HierarchicalModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SlayersBeasts.MOD_ID, "irk_model"), "main");
	private final ModelPart root;

	public IrkModel(ModelPart root) {
		this.root = root;
	}

	public ModelPart root() {
		return root;
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		root.getAllParts().forEach(ModelPart::resetPose);
		animateWalk(IrkAnimation.WALK, limbSwing, limbSwingAmount, 15, 10);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 0.0F, -1.0F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(0.0F, 0.5F, 2.0F, 0.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, -2.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition upper = body.addOrReplaceChild("upper", CubeListBuilder.create().texOffs(43, 6).addBox(2.0F, -5.5F, -3.5F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(40, 42).addBox(-4.0F, -5.5F, -3.5F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 11).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(24, 32).addBox(0.0F, -5.75F, 0.0F, 0.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition neck = upper.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(47, 39).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -2.75F, -0.8727F, 0.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(20, 8).addBox(-2.5F, -5.75F, -2.0F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(42, 0).addBox(-1.5F, -5.0F, 2.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(12, 0).addBox(-1.5F, -4.0F, -4.0F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition horn_left = head.addOrReplaceChild("horn_left", CubeListBuilder.create().texOffs(9, 29).addBox(-1.0F, -2.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(12, 0).addBox(-0.5F, -4.0F, -0.5F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(9, 0).addBox(-0.5F, -3.0F, 2.5F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -4.75F, 0.5F, 0.0F, 0.0F, 0.4363F));

		PartDefinition horn_right = head.addOrReplaceChild("horn_right", CubeListBuilder.create().texOffs(48, 26).addBox(0.0F, -2.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(12, 5).addBox(0.5F, -4.0F, -0.5F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(12, 3).addBox(0.5F, -3.0F, 2.5F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -4.75F, 0.5F, 0.0F, 0.0F, -0.4363F));

		PartDefinition arm_left = upper.addOrReplaceChild("arm_left", CubeListBuilder.create().texOffs(0, 37).addBox(0.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -4.0F, -2.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition l_11 = arm_left.addOrReplaceChild("l_11", CubeListBuilder.create().texOffs(34, 11).addBox(-0.999F, 0.0F, -1.75F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 21).addBox(-0.999F, 0.25F, -7.75F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 6.5F, -1.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition hand_left = l_11.addOrReplaceChild("hand_left", CubeListBuilder.create().texOffs(10, 33).addBox(-1.499F, -0.5F, -3.5F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(8, 45).addBox(1.501F, -0.5F, -7.5F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(44, 18).addBox(0.501F, -0.5F, -7.5F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 44).addBox(-0.499F, -0.5F, -7.5F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(28, 41).addBox(-1.499F, -0.5F, -7.5F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, -7.25F, 1.0472F, 0.0F, 0.0F));

		PartDefinition arm_right = upper.addOrReplaceChild("arm_right", CubeListBuilder.create().texOffs(35, 34).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -4.0F, -2.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition r_11 = arm_right.addOrReplaceChild("r_11", CubeListBuilder.create().texOffs(34, 2).addBox(-0.999F, 0.0F, -1.75F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(18, 15).addBox(-0.999F, 0.25F, -7.75F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 6.5F, -1.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition hand_right = r_11.addOrReplaceChild("hand_right", CubeListBuilder.create().texOffs(24, 0).addBox(-1.499F, -0.5F, -3.5F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(41, 14).addBox(1.501F, -0.5F, -7.5F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(8, 41).addBox(0.501F, -0.5F, -7.5F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(16, 35).addBox(-0.499F, -0.5F, -7.5F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(10, 17).addBox(-1.499F, -0.5F, -7.5F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, -7.25F, 1.0472F, 0.0F, 0.0F));

		PartDefinition leg_left = body.addOrReplaceChild("leg_left", CubeListBuilder.create().texOffs(32, 20).addBox(0.0F, -5.0F, -3.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(35, 48).addBox(0.5F, -4.5F, 0.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(43, 32).addBox(0.0F, -5.0F, -5.0F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 10.0F, 0.5F, 0.48F, 0.0F, 0.0F));

		PartDefinition l_21 = leg_left.addOrReplaceChild("l_21", CubeListBuilder.create().texOffs(48, 2).addBox(-0.501F, 0.0F, -7.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 29).addBox(-0.501F, 0.0F, -5.0F, 2.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -5.0F, -5.0F, 0.829F, 0.0F, 0.0F));

		PartDefinition hoof_left = l_21.addOrReplaceChild("hoof_left", CubeListBuilder.create().texOffs(40, 26).addBox(-1.0F, -2.0F, -4.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 2.0F, -7.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition leg_right = body.addOrReplaceChild("leg_right", CubeListBuilder.create().texOffs(16, 23).addBox(-3.0F, -5.0F, -3.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(49, 13).addBox(-2.5F, -4.5F, 0.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(18, 43).addBox(-3.0F, -5.0F, -5.0F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 10.0F, 0.5F, 0.48F, 0.0F, 0.0F));

		PartDefinition r_21 = leg_right.addOrReplaceChild("r_21", CubeListBuilder.create().texOffs(28, 16).addBox(-0.499F, 0.0F, -7.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(23, 28).addBox(-0.499F, 0.0F, -5.0F, 2.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -5.0F, -5.0F, 0.829F, 0.0F, 0.0F));

		PartDefinition hoof_right = r_21.addOrReplaceChild("hoof_right", CubeListBuilder.create().texOffs(8, 39).addBox(-1.0F, -2.0F, -4.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 2.0F, -7.0F, -0.5236F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}
}
