package net.invictusslayer.slayersbeasts.client.model;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.animation.ButterflyAnimation;
import net.invictusslayer.slayersbeasts.client.state.ButterflyRenderState;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class ButterflyModel extends EntityModel<ButterflyRenderState> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "butterfly_model"), "main");

	public ButterflyModel(ModelPart root) {
		super(root);
	}

	@Override
	public void setupAnim(ButterflyRenderState state) {
		super.setupAnim(state);
		animate(state.idleAnimationState, ButterflyAnimation.IDLE_CLOSED, state.ageInTicks);
		animate(state.flyingAnimationState, ButterflyAnimation.FLYING, state.ageInTicks, 2.0F);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(6, 14).addBox(-1.0F, -1.0F, -3.025F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, -1.975F));

		PartDefinition Lower_R = body.addOrReplaceChild("Lower_R", CubeListBuilder.create().texOffs(-11, 11).mirror().addBox(-7.0F, 0.0F, 0.0F, 7.0F, 0.0F, 11.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offset(-1.0F, -0.5F, -1.025F));

		PartDefinition Upper_R = body.addOrReplaceChild("Upper_R", CubeListBuilder.create().texOffs(-10, 0).addBox(-13.0F, 0.0F, -2.0F, 13.0F, 0.0F, 10.0F, new CubeDeformation(0.01F)), PartPose.offset(-1.0F, -0.75F, -2.025F));

		PartDefinition Antennae = body.addOrReplaceChild("Antennae", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, -3.025F));

		PartDefinition Antenna_R = Antennae.addOrReplaceChild("Antenna_R", CubeListBuilder.create().texOffs(15, 4).addBox(0.0F, -2.0F, -7.0F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 0.0F, 0.0F));

		PartDefinition Antenna_L = Antennae.addOrReplaceChild("Antenna_L", CubeListBuilder.create().texOffs(15, 4).addBox(0.0F, -2.0F, -7.0F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 0.0F, 0.0F));

		PartDefinition Lower_L = body.addOrReplaceChild("Lower_L", CubeListBuilder.create().texOffs(-11, 11).addBox(0.0F, 0.0F, 0.0F, 7.0F, 0.0F, 11.0F, new CubeDeformation(0.01F)), PartPose.offset(1.0F, -0.5F, -1.025F));

		PartDefinition Upper_L = body.addOrReplaceChild("Upper_L", CubeListBuilder.create().texOffs(-10, 0).mirror().addBox(0.0F, 0.0F, -2.0F, 13.0F, 0.0F, 10.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offset(1.0F, -0.75F, -2.025F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}
}
