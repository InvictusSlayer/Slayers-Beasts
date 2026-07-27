package net.invictusslayer.slayersbeasts.client.model;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.animation.SnailAnimation;
import net.invictusslayer.slayersbeasts.world.entity.Snail;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class SnailModel<T extends Snail> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SlayersBeasts.MOD_ID, "snail_model"), "main");
    private final ModelPart root;

    public SnailModel(ModelPart root) {
        this.root = root;
    }

    @Override
    public ModelPart root() {
        return root;
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        root.getAllParts().forEach(ModelPart::resetPose);
//        animateWalk(SnailAnimation.CRAWL, limbSwing, limbSwingAmount, 10.0F, 100.0F);
        animate(entity.crawlAnimationState, SnailAnimation.CRAWL, ageInTicks);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition snail = partdefinition.addOrReplaceChild("snail", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition head = snail.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -3.0F));

        PartDefinition stalk_L = head.addOrReplaceChild("stalk_L", CubeListBuilder.create().texOffs(0, 7).addBox(0.0F, -4.0F, -3.0F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.75F, -2.0F, -1.0F));

        PartDefinition stalk_R = head.addOrReplaceChild("stalk_R", CubeListBuilder.create().texOffs(0, 7).addBox(0.0F, -4.0F, -3.0F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.75F, -2.0F, -1.0F));

        PartDefinition neck = head.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition tentacle_L = head.addOrReplaceChild("tentacle_L", CubeListBuilder.create().texOffs(13, -1).addBox(0.0F, -1.0F, -1.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.7F, 0.0F, -2.0F));

        PartDefinition tentacle_R = head.addOrReplaceChild("tentacle_R", CubeListBuilder.create().texOffs(13, -1).mirror().addBox(0.0F, -1.0F, -1.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.7F, 0.0F, -2.0F));

        PartDefinition body = snail.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));

        PartDefinition shell = snail.addOrReplaceChild("shell", CubeListBuilder.create().texOffs(0, 10).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }
}
