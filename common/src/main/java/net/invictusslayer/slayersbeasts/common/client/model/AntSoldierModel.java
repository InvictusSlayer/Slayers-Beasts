package net.invictusslayer.slayersbeasts.common.client.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.client.animation.AntSoldierAnimation;
import net.invictusslayer.slayersbeasts.common.entity.AntSoldier;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
public class AntSoldierModel<T extends AntSoldier> extends HierarchicalModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SlayersBeasts.MOD_ID, "ant_soldier_model"), "main");
	private final ModelPart root;

	public AntSoldierModel(ModelPart root) {
		this.root = root;
	}

	public ModelPart root() {
		return root;
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		root.getAllParts().forEach(ModelPart::resetPose);
		animateWalk(AntSoldierAnimation.WALK, limbSwing, limbSwingAmount, 15, 10);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 23.0F, 0.0F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(26, 28).addBox(-2.0F, 1.25F, 8.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(28, 6).addBox(-3.0F, -0.5F, 7.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 27).addBox(-2.5F, -0.75F, 0.0F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-4.0F, -1.25F, 1.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 6.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.2588F, -1.9659F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -4.4635F, -11.4686F, 0.2618F, -0.2618F, 0.0F));

		PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 11).addBox(-1.0F, -1.2588F, -1.9659F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -4.4635F, -11.4686F, 0.2618F, 0.2618F, 0.0F));

		PartDefinition cube_r4 = body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 11).addBox(-3.0F, -1.0F, -7.0F, 6.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.5F, -5.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r5 = body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 22).addBox(-1.0F, 0.0F, -5.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 6.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r6 = body.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(18, 14).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.5F, -5.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition antenna_left = body.addOrReplaceChild("antenna_left", CubeListBuilder.create().texOffs(0, 29).addBox(0.0F, -7.25F, -7.0F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -7.75F, -8.0F, 0.2618F, -0.1745F, 0.1745F));

		PartDefinition antenna_right = body.addOrReplaceChild("antenna_right", CubeListBuilder.create().texOffs(16, 28).addBox(0.0F, -7.25F, -7.0F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -7.75F, -8.0F, 0.2618F, 0.1745F, -0.1745F));

		PartDefinition leg_left_front = body.addOrReplaceChild("leg_left_front", CubeListBuilder.create().texOffs(32, 16).addBox(0.0F, 0.0F, -0.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(26, 26).addBox(3.0F, -4.0F, -0.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -5.5F, -1.5F, 0.6283F, 0.6283F, 1.2566F));

		PartDefinition cube_r7 = leg_left_front.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(19, 34).addBox(0.0F, -1.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.0F, -0.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition leg_left_mid = body.addOrReplaceChild("leg_left_mid", CubeListBuilder.create().texOffs(32, 13).addBox(0.0F, 0.0F, -0.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(9, 25).addBox(3.0F, -4.0F, -0.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -5.0F, 0.0F, 0.0F, 0.0F, 0.8796F));

		PartDefinition cube_r8 = leg_left_mid.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(32, 19).addBox(0.0F, -1.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.0F, -0.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition leg_left_hind = body.addOrReplaceChild("leg_left_hind", CubeListBuilder.create().texOffs(25, 31).addBox(0.0F, 0.0F, -0.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(22, 4).addBox(3.0F, -4.0F, -0.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -4.5F, 1.5F, -0.6283F, -0.6283F, 1.0996F));

		PartDefinition cube_r9 = leg_left_hind.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(9, 22).addBox(0.0F, -1.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.0F, -0.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition leg_right_front = body.addOrReplaceChild("leg_right_front", CubeListBuilder.create().texOffs(10, 32).addBox(-4.0F, 0.0F, -0.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(19, 11).addBox(-11.0F, -4.0F, -0.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -5.5F, -1.5F, 0.6283F, -0.6283F, -1.2566F));

		PartDefinition cube_r10 = leg_right_front.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(27, 34).addBox(-3.0F, -1.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, -0.5F, 0.0F, 0.0F, 1.5708F));

		PartDefinition leg_right_mid = body.addOrReplaceChild("leg_right_mid", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0F, 0.0F, -0.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(22, 0).addBox(-11.0F, -4.0F, -0.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -5.0F, 0.0F, 0.0F, 0.0F, -0.8796F));

		PartDefinition cube_r11 = leg_right_mid.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(34, 33).addBox(-3.0F, -1.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, -0.5F, 0.0F, 0.0F, 1.5708F));

		PartDefinition leg_right_hind = body.addOrReplaceChild("leg_right_hind", CubeListBuilder.create().texOffs(0, 29).addBox(-4.0F, 0.0F, -0.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(22, 2).addBox(-11.0F, -4.0F, -0.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -4.5F, 1.5F, -0.6283F, 0.6283F, -1.0996F));

		PartDefinition cube_r12 = leg_right_hind.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 35).addBox(-3.0F, -1.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, -0.5F, 0.0F, 0.0F, 1.5708F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}
}
