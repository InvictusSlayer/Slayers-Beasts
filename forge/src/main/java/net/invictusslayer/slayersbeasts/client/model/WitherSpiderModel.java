package net.invictusslayer.slayersbeasts.client.model;

import net.invictusslayer.slayersbeasts.client.animation.WitherSpiderAnimation;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.entity.WitherSpider;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WitherSpiderModel<T extends WitherSpider> extends HierarchicalModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SlayersBeasts.MOD_ID, "wither_spider_model"), "main");
	private final ModelPart root;
	private final ModelPart head;

	public WitherSpiderModel(ModelPart root) {
		this.root = root;
		this.head = root.getChild("body").getChild("head");
	}

	public ModelPart root() {
		return root;
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		root.getAllParts().forEach(ModelPart::resetPose);
		head.yRot = netHeadYaw * Mth.PI / 180F;
		head.xRot = headPitch * Mth.PI / 180F;
		animateWalk(WitherSpiderAnimation.WALK, limbSwing, limbSwingAmount, 20, 10);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(15, 15).addBox(-1.0F, -1.0F, 5.5F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(15, 4).addBox(0.0F, -2.0F, 6.5F, 0.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-1.0F, 0.0F, 14.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 18.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 12).addBox(-3.0F, -2.0F, -6.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -5.5F));

		PartDefinition leg_left_front = body.addOrReplaceChild("leg_left_front", CubeListBuilder.create().texOffs(8, 37).addBox(0.0F, 0.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(34, 36).addBox(1.0F, -4.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, -2.5F, 0.6109F, 0.5236F, 0.9599F));

		PartDefinition cube_r1 = leg_left_front.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(28, 18).addBox(0.0F, 0.0F, -0.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -9.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition cube_r2 = leg_left_front.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(31, 4).addBox(-7.0F, 0.0F, -0.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -9.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition leg_left_mid_front = body.addOrReplaceChild("leg_left_mid_front", CubeListBuilder.create().texOffs(36, 28).addBox(0.0F, 0.0F, -0.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(24, 35).addBox(1.0F, -4.0F, -0.75F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, -0.5F, 0.2618F, 0.1745F, 0.7854F));

		PartDefinition cube_r3 = leg_left_mid_front.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(28, 16).addBox(0.0F, 0.0F, -0.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -9.0F, -0.25F, 0.0F, 0.0F, 0.3491F));

		PartDefinition cube_r4 = leg_left_mid_front.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(31, 2).addBox(-7.0F, 0.0F, -0.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -9.0F, -0.25F, 0.0F, 0.0F, -0.7854F));

		PartDefinition leg_left_mid_hind = body.addOrReplaceChild("leg_left_mid_hind", CubeListBuilder.create().texOffs(14, 35).addBox(0.0F, 0.0F, -0.25F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 35).addBox(1.0F, -4.0F, -0.25F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.5F, -0.2618F, -0.1745F, 0.7854F));

		PartDefinition cube_r5 = leg_left_mid_hind.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(28, 14).addBox(0.0F, 0.0F, -0.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -9.0F, 0.25F, 0.0F, 0.0F, 0.3491F));

		PartDefinition cube_r6 = leg_left_mid_hind.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(31, 0).addBox(-7.0F, 0.0F, -0.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -9.0F, 0.25F, 0.0F, 0.0F, -0.7854F));

		PartDefinition leg_left_hind = body.addOrReplaceChild("leg_left_hind", CubeListBuilder.create().texOffs(34, 33).addBox(0.0F, 0.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(30, 33).addBox(1.0F, -4.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 2.5F, -0.6109F, -0.5236F, 0.9599F));

		PartDefinition cube_r7 = leg_left_hind.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 28).addBox(0.0F, 0.0F, -0.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -9.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition cube_r8 = leg_left_hind.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(16, 30).addBox(-7.0F, 0.0F, -0.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -9.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition leg_right_front = body.addOrReplaceChild("leg_right_front", CubeListBuilder.create().texOffs(24, 32).addBox(-2.0F, 0.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(20, 32).addBox(-2.0F, -4.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 0.0F, -2.5F, 0.6109F, -0.5236F, -0.9599F));

		PartDefinition cube_r9 = leg_right_front.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(20, 26).addBox(-9.0F, 0.0F, -0.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -9.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r10 = leg_right_front.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 30).addBox(0.0F, 0.0F, -0.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -9.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition leg_right_mid_front = body.addOrReplaceChild("leg_right_mid_front", CubeListBuilder.create().texOffs(14, 32).addBox(-2.0F, 0.0F, -0.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(10, 32).addBox(-2.0F, -4.0F, -0.75F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 0.0F, -0.5F, 0.2618F, -0.1745F, -0.7854F));

		PartDefinition cube_r11 = leg_right_mid_front.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(26, 10).addBox(-9.0F, 0.0F, -0.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -9.0F, -0.25F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r12 = leg_right_mid_front.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(28, 22).addBox(0.0F, 0.0F, -0.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -9.0F, -0.25F, 0.0F, 0.0F, 0.7854F));

		PartDefinition leg_right_mid_hind = body.addOrReplaceChild("leg_right_mid_hind", CubeListBuilder.create().texOffs(4, 32).addBox(-2.0F, 0.0F, -0.25F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 32).addBox(-2.0F, -4.0F, -0.25F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 0.0F, 0.5F, -0.2618F, 0.1745F, -0.7854F));

		PartDefinition cube_r13 = leg_right_mid_hind.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 26).addBox(-9.0F, 0.0F, -0.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -9.0F, 0.25F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r14 = leg_right_mid_hind.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(28, 20).addBox(0.0F, 0.0F, -0.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -9.0F, 0.25F, 0.0F, 0.0F, 0.7854F));

		PartDefinition leg_right_hind = body.addOrReplaceChild("leg_right_hind", CubeListBuilder.create().texOffs(18, 14).addBox(-2.0F, 0.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(-2.0F, -4.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 0.0F, 2.5F, -0.6109F, 0.5236F, -0.9599F));

		PartDefinition cube_r15 = leg_right_hind.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(18, 12).addBox(-9.0F, 0.0F, -0.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -9.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r16 = leg_right_hind.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(20, 28).addBox(0.0F, 0.0F, -0.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -9.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition thorax = body.addOrReplaceChild("thorax", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -6.0F, -5.5F, 2.0F, 1.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(15, 0).addBox(0.0F, -7.0F, -4.5F, 0.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(40, 32).addBox(-3.0F, -6.0F, -2.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(40, 34).addBox(-3.0F, -6.0F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(8, 40).addBox(-3.0F, -6.0F, 1.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(40, 26).addBox(1.0F, -6.0F, -2.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(39, 8).addBox(1.0F, -6.0F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(38, 12).addBox(1.0F, -6.0F, 1.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition rib1 = thorax.addOrReplaceChild("rib1", CubeListBuilder.create().texOffs(42, 36).addBox(-2.0F, -6.0F, -4.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(42, 28).addBox(-3.0F, -5.0F, -4.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rib2 = thorax.addOrReplaceChild("rib2", CubeListBuilder.create().texOffs(17, 42).addBox(-2.0F, -6.0F, -4.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(8, 42).addBox(-3.0F, -5.0F, -4.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 8.0F));

		PartDefinition rib3 = thorax.addOrReplaceChild("rib3", CubeListBuilder.create().texOffs(0, 42).addBox(-3.0F, -6.0F, -4.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(40, 41).addBox(-2.0F, -5.0F, -4.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 0.0F, 0.0F));

		PartDefinition rib4 = thorax.addOrReplaceChild("rib4", CubeListBuilder.create().texOffs(36, 41).addBox(-3.0F, -6.0F, -4.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(32, 41).addBox(-2.0F, -5.0F, -4.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 0.0F, 8.0F));

		PartDefinition ribs_left = body.addOrReplaceChild("ribs_left", CubeListBuilder.create().texOffs(14, 0).addBox(1.0F, -6.0F, 5.5F, 4.0F, 0.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(31, 31).addBox(1.0F, -7.0F, 6.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(31, 6).addBox(1.0F, -7.0F, 9.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 8).addBox(1.0F, -7.0F, 12.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(33, 8).addBox(1.0F, -6.0F, 14.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 40).addBox(4.0F, -6.0F, 6.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(38, 36).addBox(5.0F, -6.0F, 9.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(28, 38).addBox(4.0F, -6.0F, 12.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(7, 0).addBox(2.0F, -5.0F, 14.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition ribs_right = body.addOrReplaceChild("ribs_right", CubeListBuilder.create().texOffs(6, 0).addBox(2.0F, -6.0F, 5.5F, 4.0F, 0.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(0, 6).addBox(2.0F, -7.0F, 6.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(1.0F, -7.0F, 9.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 4).addBox(2.0F, -7.0F, 12.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(37, 24).addBox(4.0F, -6.0F, 14.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 38).addBox(2.0F, -6.0F, 6.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(19, 37).addBox(1.0F, -6.0F, 9.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 37).addBox(2.0F, -6.0F, 12.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(23, 40).addBox(4.0F, -5.0F, 14.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, 6.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}
}
