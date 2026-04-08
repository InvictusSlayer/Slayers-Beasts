package net.invictusslayer.slayersbeasts.client.model;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.animation.ButterflyAnimation;
import net.invictusslayer.slayersbeasts.world.entity.Butterfly;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class ButterflyModel<T extends Butterfly> extends HierarchicalModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SlayersBeasts.MOD_ID, "butterfly_model"), "main");
	private final ModelPart root;

	public ButterflyModel(ModelPart root) {
		this.root = root;
	}

	public ModelPart root() {
		return root;
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		root.getAllParts().forEach(ModelPart::resetPose);
		animate(entity.idleAnimationState, ButterflyAnimation.IDLE, ageInTicks);
		animate(entity.flyingAnimationState, ButterflyAnimation.FLYING, ageInTicks, 2.0F);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 21).addBox(-1.0F, -1.0F, -3.025F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, -1.975F));

		PartDefinition Lower_R = body.addOrReplaceChild("Lower_R", CubeListBuilder.create().texOffs(-11, 10).mirror().addBox(-7.0F, 0.0F, 0.0F, 7.0F, 0.0F, 11.0F, new CubeDeformation(0.001F)).mirror(false), PartPose.offset(-1.0F, -0.5F, -1.025F));

		PartDefinition Upper_R = body.addOrReplaceChild("Upper_R", CubeListBuilder.create().texOffs(-10, 0).addBox(-13.0F, 0.0F, -2.0F, 13.0F, 0.0F, 10.0F, new CubeDeformation(0.001F)), PartPose.offset(-1.0F, -0.75F, -2.025F));

		PartDefinition Antennae = body.addOrReplaceChild("Antennae", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, -3.025F));

		PartDefinition Antenna_R = Antennae.addOrReplaceChild("Antenna_R", CubeListBuilder.create().texOffs(14, 3).addBox(0.0F, -2.0F, -7.0F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 0.0F, 0.0F));

		PartDefinition Antenna_L = Antennae.addOrReplaceChild("Antenna_L", CubeListBuilder.create().texOffs(14, 3).addBox(0.0F, -2.0F, -7.0F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 0.0F, 0.0F));

		PartDefinition Lower_L = body.addOrReplaceChild("Lower_L", CubeListBuilder.create().texOffs(-11, 10).addBox(0.0F, 0.0F, 0.0F, 7.0F, 0.0F, 11.0F, new CubeDeformation(0.001F)), PartPose.offset(1.0F, -0.5F, -1.025F));

		PartDefinition Upper_L = body.addOrReplaceChild("Upper_L", CubeListBuilder.create().texOffs(-10, 0).mirror().addBox(0.0F, 0.0F, -2.0F, 13.0F, 0.0F, 10.0F, new CubeDeformation(0.001F)).mirror(false), PartPose.offset(1.0F, -0.75F, -2.025F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}
}
