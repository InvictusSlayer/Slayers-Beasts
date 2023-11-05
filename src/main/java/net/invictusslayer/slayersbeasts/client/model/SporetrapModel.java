package net.invictusslayer.slayersbeasts.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.entity.Sporetrap;
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
public class SporetrapModel<T extends Sporetrap> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SlayersBeasts.MOD_ID, "sporetrap_model"), "main");
	private final ModelPart base;
	private final ModelPart innerLeaf1;
	private final ModelPart innerLeaf2;
	private final ModelPart innerLeaf3;
	private final ModelPart innerLeaf4;
	private final ModelPart stem;
	private final ModelPart mouthTop;
	private final ModelPart mouthBottom;

	public SporetrapModel(ModelPart root) {
		this.base = root.getChild("base");
		this.innerLeaf1 = root.getChild("innerLeaf1");
		this.innerLeaf2 = root.getChild("innerLeaf2");
		this.innerLeaf3 = root.getChild("innerLeaf3");
		this.innerLeaf4 = root.getChild("innerLeaf4");
		this.stem = root.getChild("stem");
		this.mouthTop = root.getChild("mouthTop");
		this.mouthBottom = root.getChild("mouthBottom");
	}

	public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		float f1 = Mth.cos(pLimbSwing * 1.4F) * 0.8F * pLimbSwingAmount;
		float f2 = Mth.cos(pLimbSwing * 1.4F + Mth.PI * 0.25F) * 0.8F * pLimbSwingAmount;
		float f3 = Mth.cos(pLimbSwing * 1.4F + Mth.PI * 0.5F) * 0.8F * pLimbSwingAmount;
		float f4 = Mth.cos(pLimbSwing * 1.4F + Mth.PI * 0.75F) * 0.8F * pLimbSwingAmount;
		float f5 = Mth.cos(pLimbSwing * 1.4F + Mth.PI) * 0.8F * pLimbSwingAmount;
		this.mouthTop.xRot = -2.8F;
		this.mouthBottom.xRot = 2.8F;
		this.mouthTop.xRot += f1;
		this.mouthBottom.xRot += f5;
		this.innerLeaf1.xRot = 1F;
		this.innerLeaf2.xRot = 1F;
		this.innerLeaf3.zRot = 1F;
		this.innerLeaf4.zRot = 1F;
//		this.innerLeaf1.xRot += f1;
//		this.innerLeaf2.xRot += f1;
//		this.innerLeaf3.zRot += f1;
//		this.innerLeaf4.zRot += f1;
	}

	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		base.render(poseStack, buffer, packedLight, packedOverlay);
		innerLeaf1.render(poseStack, buffer, packedLight, packedOverlay);
		innerLeaf2.render(poseStack, buffer, packedLight, packedOverlay);
		innerLeaf3.render(poseStack, buffer, packedLight, packedOverlay);
		innerLeaf4.render(poseStack, buffer, packedLight, packedOverlay);
		stem.render(poseStack, buffer, packedLight, packedOverlay);
		mouthTop.render(poseStack, buffer, packedLight, packedOverlay);
		mouthBottom.render(poseStack, buffer, packedLight, packedOverlay);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition base = partdefinition.addOrReplaceChild("base", CubeListBuilder.create().texOffs(19, 9).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(40, 26).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition innerLeaf1 = partdefinition.addOrReplaceChild("innerLeaf1", CubeListBuilder.create().texOffs(31, 48).addBox(-1.0F, -10.0F, 0.0F, 2.0F, 11.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 38).addBox(-3.5F, -10.0F, 0.75F, 7.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, -4.0F));

		PartDefinition cube_r1 = innerLeaf1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(39, 16).addBox(-3.0F, -10.0F, 0.75F, 6.0F, 10.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(45, 49).addBox(-0.5F, -7.0F, 0.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition innerLeaf2 = partdefinition.addOrReplaceChild("innerLeaf2", CubeListBuilder.create().texOffs(25, 48).addBox(-1.0F, -10.0F, 0.0F, 2.0F, 11.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(37, 0).addBox(-3.5F, -10.0F, 0.75F, 7.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 23.0F, 4.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r2 = innerLeaf2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(38, 38).addBox(-3.0F, -10.0F, 0.75F, 6.0F, 10.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(8, 49).addBox(-0.5F, -7.0F, 0.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition innerLeaf3 = partdefinition.addOrReplaceChild("innerLeaf3", CubeListBuilder.create().texOffs(19, 48).addBox(-1.0F, -10.0F, 0.0F, 2.0F, 11.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(26, 27).addBox(-3.5F, -10.0F, 0.75F, 7.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 23.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r3 = innerLeaf3.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(26, 38).addBox(-3.0F, -10.0F, 0.75F, 6.0F, 10.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(4, 49).addBox(-0.5F, -7.0F, 0.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition innerLeaf4 = partdefinition.addOrReplaceChild("innerLeaf4", CubeListBuilder.create().texOffs(13, 48).addBox(-1.0F, -10.0F, 0.0F, 2.0F, 11.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(12, 27).addBox(-3.5F, -10.0F, 0.75F, 7.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 23.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r4 = innerLeaf4.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(14, 38).addBox(-3.0F, -10.0F, 0.75F, 6.0F, 10.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(0, 49).addBox(-0.5F, -7.0F, 0.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition stem = partdefinition.addOrReplaceChild("stem", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 21.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r5 = stem.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -15.2373F, 0.7932F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.1541F, -6.6976F, -0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r6 = stem.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(37, 48).addBox(-1.0F, -9.2373F, 0.7932F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(24, 0).addBox(-1.5F, -3.2373F, 0.2932F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.198F, -4.1399F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r7 = stem.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 25).addBox(-1.5F, -9.0F, -1.5F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition mouthTop = partdefinition.addOrReplaceChild("mouthTop", CubeListBuilder.create().texOffs(0, 17).addBox(-3.0F, -1.0F, 1.0F, 6.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(9, 25).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(24, 6).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(33, 7).addBox(1.75F, 0.0F, 6.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 21).addBox(3.0F, -1.0F, 6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(3, 20).addBox(-4.0F, -1.0F, 6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(19, 19).addBox(-3.75F, 0.0F, 5.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(19, 17).addBox(2.75F, 0.0F, 5.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(19, 13).addBox(3.75F, 0.0F, 3.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(19, 11).addBox(-4.75F, 0.0F, 3.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(33, 0).addBox(0.25F, 0.0F, 6.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(3, 22).addBox(-1.25F, 0.0F, 6.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(19, 22).addBox(-2.75F, 0.0F, 6.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(48, 32).addBox(-5.0F, -1.0F, 2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(46, 44).addBox(3.0F, -1.0F, 2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(22, 22).addBox(-3.0F, -2.0F, 2.0F, 6.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.25F, -3.75F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition mouthBottom = partdefinition.addOrReplaceChild("mouthBottom", CubeListBuilder.create().texOffs(0, 9).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(19, 9).addBox(1.75F, -1.0F, 5.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 19).addBox(3.0F, 0.0F, 5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(3, 18).addBox(-4.0F, 0.0F, 5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 17).addBox(-3.75F, -1.0F, 4.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(3, 14).addBox(2.75F, -1.0F, 4.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 13).addBox(3.75F, -1.0F, 2.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(3, 12).addBox(-4.75F, -1.0F, 2.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 11).addBox(0.25F, -1.0F, 5.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(3, 10).addBox(-1.25F, -1.0F, 5.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 9).addBox(-2.75F, -1.0F, 5.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(43, 11).addBox(-5.0F, 0.0F, 1.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(40, 31).addBox(3.0F, 0.0F, 1.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(19, 17).addBox(-3.0F, 1.0F, 1.0F, 6.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.25F, -4.75F, -3.1416F, 0.0F, 3.1416F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}
}
