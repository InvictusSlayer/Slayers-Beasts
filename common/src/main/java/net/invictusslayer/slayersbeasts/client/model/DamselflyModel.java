package net.invictusslayer.slayersbeasts.client.model;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.animation.DamselflyAnimation;
import net.invictusslayer.slayersbeasts.world.entity.Damselfly;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class DamselflyModel<T extends Damselfly> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SlayersBeasts.MOD_ID, "damselfly_model"), "main");
    private final ModelPart root;

    public DamselflyModel(ModelPart root) {
        this.root = root;
    }

    @Override
    public ModelPart root() {
        return root;
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        root.getAllParts().forEach(ModelPart::resetPose);
        animate(entity.flyingAnimationState, DamselflyAnimation.FLYING, ageInTicks, 6.0F);
        animate(entity.perchAnimationState, DamselflyAnimation.IDLE, ageInTicks, 0.5F);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.5F, 19.5F, -2.8F));

        PartDefinition Tail = body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.0F, -0.2F, 1.0F, 1.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 0.5F, -1.0F));

        PartDefinition Torso = body.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(19, 1).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 1.5F, 0.0F, 0.2618F, 0.0F, 0.0F));

        PartDefinition Legs_R = Torso.addOrReplaceChild("Legs_R", CubeListBuilder.create().texOffs(11, 1).mirror().addBox(0.0F, 1.0F, 0.0F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(11, 1).mirror().addBox(0.0F, 1.0F, 1.25F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(2, -1).mirror().addBox(-0.025F, 0.0F, 0.5F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, -1.6341F, -2.3665F, -0.2618F, 0.0F, 0.0F));

        PartDefinition Legs_L = Torso.addOrReplaceChild("Legs_L", CubeListBuilder.create().texOffs(11, 1).addBox(0.0F, 1.0F, 0.0F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(11, 1).addBox(0.0F, 1.0F, 1.25F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(2, -1).addBox(0.025F, 0.0F, 0.5F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -1.6341F, -2.3665F, -0.2618F, 0.0F, 0.0F));

        PartDefinition Wings = Torso.addOrReplaceChild("Wings", CubeListBuilder.create(), PartPose.offset(-0.5F, -1.5F, -2.0F));

        PartDefinition UpperWing_L = Wings.addOrReplaceChild("UpperWing_L", CubeListBuilder.create(), PartPose.offset(1.5F, 0.0F, 2.0F));

        PartDefinition UpperWing_L_r1 = UpperWing_L.addOrReplaceChild("UpperWing_L_r1", CubeListBuilder.create().texOffs(-2, 18).addBox(2.0F, -0.5F, -1.0F, 11.0F, 0.0F, 3.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.5F, 0.0F, -2.0F, 0.0F, -1.5708F, 1.5708F));

        PartDefinition LowerWing_R = Wings.addOrReplaceChild("LowerWing_R", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.4F, 0.5F, 2.0F, 0.0F, 0.0F, 1.5708F));

        PartDefinition LowerWing_R_r1 = LowerWing_R.addOrReplaceChild("LowerWing_R_r1", CubeListBuilder.create().texOffs(-2, 18).addBox(0.0F, 0.0F, -1.0F, 11.0F, 0.0F, 3.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition LowerWing_L = Wings.addOrReplaceChild("LowerWing_L", CubeListBuilder.create(), PartPose.offsetAndRotation(1.4F, 0.5F, 2.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition LowerWing_L_r1 = LowerWing_L.addOrReplaceChild("LowerWing_L_r1", CubeListBuilder.create().texOffs(-2, 18).mirror().addBox(-13.0F, 0.4F, -1.0F, 11.0F, 0.0F, 3.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offsetAndRotation(-0.5F, -0.4F, -2.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition UpperWing_R = Wings.addOrReplaceChild("UpperWing_R", CubeListBuilder.create(), PartPose.offset(-0.5F, 0.0F, 2.0F));

        PartDefinition UpperWing_R_r1 = UpperWing_R.addOrReplaceChild("UpperWing_R_r1", CubeListBuilder.create().texOffs(-2, 18).mirror().addBox(-13.0F, -0.5F, -1.0F, 11.0F, 0.0F, 3.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offsetAndRotation(0.5F, 0.0F, -2.0F, 0.0F, 1.5708F, -1.5708F));

        PartDefinition Head = Torso.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(3, 8).addBox(-2.0F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -1.9754F, -2.7838F, -0.2618F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }
}
