package net.invictusslayer.slayersbeasts.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.entity.EntOak;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EntOakModel<T extends EntOak> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SlayersBeasts.MOD_ID, "ent_oak_model"), "main");
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart leftLeg;
	private final ModelPart rightLeg;
	private final ModelPart leftArm;
	private final ModelPart rightArm;

	public EntOakModel(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.leftLeg = root.getChild("leftLeg");
		this.rightLeg = root.getChild("rightLeg");
		this.leftArm = root.getChild("leftArm");
		this.rightArm = root.getChild("rightArm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 20).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -37.0F, -1.0F));

		PartDefinition branchTop = head.addOrReplaceChild("branchTop", CubeListBuilder.create(), PartPose.offset(2.0F, -10.0F, 0.0F));

		PartDefinition cube_r1 = branchTop.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(24, 80).addBox(-7.0F, -12.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-2.0F, -8.0F, -2.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 0.0F, 1.0F, 0.2454F, 0.0885F, -0.383F));

		PartDefinition cube_r2 = branchTop.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(24, 80).addBox(-6.0F, -12.0F, -3.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-2.0F, -8.0F, 0.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 0.0F, 1.0F, -0.304F, -0.0227F, -0.3035F));

		PartDefinition cube_r3 = branchTop.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(24, 80).addBox(-5.0F, -12.0F, -6.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-2.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2602F, 0.019F, -0.1298F));

		PartDefinition cube_r4 = branchTop.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(24, 80).addBox(-3.0F, -12.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5405F, -1.2624F, 1.7083F));

		PartDefinition cube_r5 = branchTop.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(24, 80).addBox(-2.0F, -11.0F, -2.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, 0.0F, 0.3491F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(34, 33).addBox(-6.0F, -3.0F, -4.0F, 12.0F, 15.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(48, 10).addBox(-7.0F, -7.0F, -5.0F, 14.0F, 4.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-9.0F, -16.0F, -6.0F, 18.0F, 9.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(90, 55).addBox(6.0F, -17.0F, -5.0F, 6.0F, 4.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(90, 41).addBox(-12.0F, -17.0F, -5.0F, 6.0F, 4.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(47, 0).addBox(12.0F, -17.0F, -4.0F, 4.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(31, 20).addBox(-16.0F, -17.0F, -4.0F, 4.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -21.0F, 0.0F));

		PartDefinition cube_r6 = body.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(24, 80).addBox(-4.0F, -4.0F, -1.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, -15.0F, 0.0F, -0.0449F, 0.602F, -0.4704F));

		PartDefinition cube_r7 = body.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(24, 80).addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -15.0F, 0.0F, 0.0891F, 0.5364F, -0.7465F));

		PartDefinition cube_r8 = body.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(24, 80).addBox(-2.0F, -4.0F, -1.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -15.0F, 0.0F, 0.6264F, -0.2865F, -0.1074F));

		PartDefinition cube_r9 = body.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(24, 80).addBox(-6.0F, -4.0F, -1.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.0F, -15.0F, 0.0F, 0.1647F, 0.1703F, 0.5741F));

		PartDefinition branchLeft = body.addOrReplaceChild("branchLeft", CubeListBuilder.create(), PartPose.offset(12.0F, -17.0F, -1.0F));

		PartDefinition cube_r10 = branchLeft.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(24, 80).addBox(-4.0F, -11.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.6754F, -1.4329F, -1.8907F));

		PartDefinition cube_r11 = branchLeft.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(24, 80).addBox(-3.0F, -13.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.715F, -1.2624F, 1.7083F));

		PartDefinition cube_r12 = branchLeft.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(24, 80).addBox(-3.0F, -14.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2182F, 0.0F, 0.3491F));

		PartDefinition branchRight = body.addOrReplaceChild("branchRight", CubeListBuilder.create(), PartPose.offset(-13.0F, -17.0F, -1.0F));

		PartDefinition cube_r13 = branchRight.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(24, 80).addBox(-3.0F, -13.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.5337F, -1.4079F, 2.1449F));

		PartDefinition cube_r14 = branchRight.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(24, 80).addBox(-3.0F, -11.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.9176F, -0.2186F, -2.9714F));

		PartDefinition cube_r15 = branchRight.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(24, 80).addBox(-3.0F, -13.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0433F, 0.0057F, 0.2183F));

		PartDefinition leftLeg = partdefinition.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(0, 46).addBox(2.0F, 29.0F, -5.0F, 10.0F, 8.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(0, 66).addBox(3.0F, 15.0F, -4.0F, 8.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.0F, 0.0F));

		PartDefinition cube_r16 = leftLeg.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 88).addBox(-6.0F, -15.0F, -3.0F, 6.0F, 15.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, 15.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition rightLeg = partdefinition.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(30, 56).addBox(-12.0F, 29.0F, -5.0F, 10.0F, 8.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(62, 66).addBox(-11.0F, 15.0F, -4.0F, 8.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.0F, 0.0F));

		PartDefinition cube_r17 = rightLeg.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(56, 88).addBox(0.0F, -15.0F, -3.0F, 6.0F, 15.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, 15.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition leftArm = partdefinition.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(66, 24).addBox(0.0F, 21.0F, -5.0F, 8.0F, 8.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(80, 100).addBox(6.0F, 29.0F, -4.0F, 2.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(87, 81).addBox(1.0F, 9.0F, -4.0F, 6.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, -35.0F, 0.0F));

		PartDefinition cube_r18 = leftArm.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(100, 19).addBox(-4.0F, -11.0F, -3.0F, 4.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 9.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition rightArm = partdefinition.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(65, 47).addBox(-8.0F, 21.0F, -5.0F, 8.0F, 8.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(94, 68).addBox(-8.0F, 29.0F, -4.0F, 2.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(86, 0).addBox(-7.0F, 9.0F, -4.0F, 6.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, -35.0F, 0.0F));

		PartDefinition cube_r19 = rightArm.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(24, 96).addBox(0.0F, -11.0F, -3.0F, 4.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 9.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		head.yRot = netHeadYaw * Mth.PI / 180F;
		rightArm.xRot = -1.5F * Mth.triangleWave(limbSwing, 10) * limbSwingAmount;
		leftArm.xRot = 1.5F * Mth.triangleWave(limbSwing, 10) * limbSwingAmount;
		rightArm.zRot = 0.03F;
		leftArm.zRot = -0.03F;
		rightLeg.xRot = 1.5F * Mth.triangleWave(limbSwing, 10) * limbSwingAmount;
		leftLeg.xRot = -1.5F * Mth.triangleWave(limbSwing, 10) * limbSwingAmount;
		rightLeg.yRot = 0.0F;
		leftLeg.yRot = 0.0F;
	}

	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
