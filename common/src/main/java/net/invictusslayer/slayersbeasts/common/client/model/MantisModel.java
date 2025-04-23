package net.invictusslayer.slayersbeasts.common.client.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
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

@Environment(EnvType.CLIENT)
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
		head.xRot += Mth.clamp(headPitch, -22.5F, 22.5F) * Mth.PI / 180F;
		head.yRot += Mth.clamp(netHeadYaw, -32.5F, 32.5F) * Mth.PI / 180F;
		animate(entity.flapAnimationState, MantisAnimation.FLAP, ageInTicks, 10);
		animate(entity.strikeAnimationState, MantisAnimation.STRIKE, ageInTicks, 8);
		if (entity.isScuttling()) {
			animateWalk(MantisAnimation.SCUTTLE, limbSwing, limbSwingAmount, 10, 10);
		} else {
			animateWalk(MantisAnimation.WALK, limbSwing, limbSwingAmount, 10, 10);
		}
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -1.0F, -17.0F, 5.0F, 3.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, -0.48F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(100, 94).addBox(-3.5F, -1.0F, -4.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(102, 84).addBox(-4.5F, -2.0F, -5.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(88, 104).addBox(1.5F, -2.0F, -5.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 107).addBox(-2.5F, 5.0F, -3.5F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(76, 72).addBox(-0.5F, -9.5F, -12.0F, 0.0F, 9.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -0.5F, -2.0F, 0.0F, -0.1745F, 0.0F));

		PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(76, 72).addBox(0.5F, -9.5F, -12.0F, 0.0F, 9.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -0.5F, -2.0F, 0.0F, 0.1745F, 0.0F));

		PartDefinition jaw_left = head.addOrReplaceChild("jaw_left", CubeListBuilder.create().texOffs(82, 31).addBox(0.0F, -1.0F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, -2.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition jaw_right = head.addOrReplaceChild("jaw_right", CubeListBuilder.create().texOffs(82, 26).addBox(-4.0F, -1.0F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, -2.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition abdomen = body.addOrReplaceChild("abdomen", CubeListBuilder.create().texOffs(0, 31).addBox(-5.0F, -4.0F, 0.0F, 10.0F, 5.0F, 21.0F, new CubeDeformation(0.0F))
				.texOffs(76, 94).addBox(-4.0F, -4.0F, 21.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 11.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition wing_left_upper = body.addOrReplaceChild("wing_left_upper", CubeListBuilder.create().texOffs(56, 102).addBox(-0.5F, -40.0F, -1.0F, 1.0F, 22.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(46, 102).addBox(-0.5F, -18.0F, -1.0F, 1.0F, 18.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 57).addBox(0.0F, -42.0F, -1.0F, 0.0F, 40.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 1.0F, -2.0F, -1.4399F, 0.3491F, -1.2217F));

		PartDefinition wing_left_lower = body.addOrReplaceChild("wing_left_lower", CubeListBuilder.create().texOffs(40, 102).addBox(-1.0F, -24.0F, -1.0F, 1.0F, 24.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(40, 57).addBox(-0.5F, -38.0F, -1.0F, 0.0F, 36.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 1.0F, 1.0F, -1.4399F, 0.3491F, -1.3526F));

		PartDefinition lw1 = wing_left_lower.addOrReplaceChild("lw1", CubeListBuilder.create().texOffs(66, 0).addBox(0.0F, -32.0F, 1.0F, 0.0F, 28.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0F, 0.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition lw2 = lw1.addOrReplaceChild("lw2", CubeListBuilder.create().texOffs(82, 0).addBox(0.0F, -24.0F, 2.0F, 0.0F, 16.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition leg_left_front = body.addOrReplaceChild("leg_left_front", CubeListBuilder.create().texOffs(102, 104).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 2.0F, -9.0F, 0.3491F, -0.3491F, -0.3054F));

		PartDefinition l11 = leg_left_front.addOrReplaceChild("l11", CubeListBuilder.create().texOffs(92, 52).addBox(-0.999F, -1.0F, -11.0F, 2.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(102, 0).addBox(0.0F, 3.0F, -8.5F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, -1.1781F, 0.0F, 0.0F));

		PartDefinition l12 = l11.addOrReplaceChild("l12", CubeListBuilder.create().texOffs(32, 107).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(70, 36).addBox(0.001F, 4.5F, 0.0F, 0.0F, 14.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(70, 109).addBox(-0.5F, 9.0F, -1.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -10.0F, 0.9163F, 0.0F, 0.0F));

		PartDefinition leg_left_mid = body.addOrReplaceChild("leg_left_mid", CubeListBuilder.create().texOffs(16, 107).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(92, 68).addBox(1.001F, 6.0F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(102, 16).addBox(-0.999F, 8.0F, 0.0F, 9.0F, 7.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(62, 36).addBox(8.001F, 8.0F, -1.0F, 2.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 2.0F, -2.0F, 0.3491F, 0.5236F, -0.1309F));

		PartDefinition leg_left_hind = body.addOrReplaceChild("leg_left_hind", CubeListBuilder.create().texOffs(24, 107).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(102, 12).addBox(1.001F, 6.0F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(102, 72).addBox(-0.999F, 8.0F, 0.0F, 9.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(62, 102).addBox(8.001F, 8.0F, -1.0F, 2.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 2.0F, 2.0F, 0.6981F, -0.2182F, -0.6545F));

		PartDefinition wing_right_upper = body.addOrReplaceChild("wing_right_upper", CubeListBuilder.create().texOffs(56, 102).addBox(-0.5F, -40.0F, -1.0F, 1.0F, 22.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(46, 102).addBox(-0.5F, -18.0F, -1.0F, 1.0F, 18.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(20, 57).addBox(0.0F, -42.0F, -1.0F, 0.0F, 40.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 1.0F, -2.0F, -1.4399F, -0.3491F, 1.2217F));

		PartDefinition wing_right_lower = body.addOrReplaceChild("wing_right_lower", CubeListBuilder.create().texOffs(40, 102).addBox(0.0F, -24.0F, -1.0F, 1.0F, 24.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(58, 57).addBox(0.5F, -38.0F, -1.0F, 0.0F, 36.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 1.0F, 1.0F, -1.4399F, -0.3491F, 1.3526F));

		PartDefinition rw1 = wing_right_lower.addOrReplaceChild("rw1", CubeListBuilder.create().texOffs(76, 36).addBox(-1.0F, -32.0F, 1.0F, 0.0F, 28.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.0F, 0.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition rw2 = rw1.addOrReplaceChild("rw2", CubeListBuilder.create().texOffs(92, 26).addBox(-1.0F, -24.0F, 2.0F, 0.0F, 16.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition leg_right_front = body.addOrReplaceChild("leg_right_front", CubeListBuilder.create().texOffs(102, 104).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 2.0F, -9.0F, 0.3491F, 0.3491F, 0.3054F));

		PartDefinition r11 = leg_right_front.addOrReplaceChild("r11", CubeListBuilder.create().texOffs(92, 52).addBox(-1.001F, -1.0F, -11.0F, 2.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(102, 0).addBox(0.0F, 3.0F, -8.5F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, -1.1781F, 0.0F, 0.0F));

		PartDefinition r12 = r11.addOrReplaceChild("r12", CubeListBuilder.create().texOffs(32, 107).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(70, 36).addBox(-0.001F, 4.5F, 0.0F, 0.0F, 14.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(70, 109).addBox(-0.5F, 9.0F, -1.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -10.0F, 0.9163F, 0.0F, 0.0F));

		PartDefinition leg_right_mid = body.addOrReplaceChild("leg_right_mid", CubeListBuilder.create().texOffs(16, 107).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(92, 68).addBox(-9.999F, 6.0F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(70, 102).addBox(-7.999F, 8.0F, 0.0F, 9.0F, 7.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(62, 36).addBox(-9.999F, 8.0F, -1.0F, 2.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 2.0F, -2.0F, 0.3491F, -0.5236F, 0.1309F));

		PartDefinition leg_right_hind = body.addOrReplaceChild("leg_right_hind", CubeListBuilder.create().texOffs(24, 107).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(102, 12).addBox(-9.999F, 6.0F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(102, 78).addBox(-7.999F, 8.0F, 0.0F, 9.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(62, 102).addBox(-9.999F, 8.0F, -1.0F, 2.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 2.0F, 2.0F, 0.6981F, 0.2182F, 0.6545F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
}
