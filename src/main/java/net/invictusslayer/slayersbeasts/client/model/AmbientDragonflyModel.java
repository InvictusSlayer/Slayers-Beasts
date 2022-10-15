package net.invictusslayer.slayersbeasts.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.entity.AmbientDragonflyEntity;
import net.invictusslayer.slayersbeasts.entity.poses.DragonflyWingPose;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class AmbientDragonflyModel<Type extends AmbientDragonflyEntity> extends EntityModel<Type> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SlayersBeasts.MOD_ID, "ambient_dragonfly"), "main");
    private final ModelPart main;
    private final ModelPart leftFrontWing;
    private final ModelPart leftBackWing;
    private final ModelPart rightFrontWing;
    private final ModelPart rightBackWing;

    public AmbientDragonflyModel(ModelPart root) {
        this.main = root.getChild("main");
        this.leftFrontWing = root.getChild("leftFrontWing");
        this.leftBackWing = root.getChild("leftBackWing");
        this.rightFrontWing = root.getChild("rightFrontWing");
        this.rightBackWing = root.getChild("rightBackWing");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 15).addBox(-2.0F, 0.0F, -6.0F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(12, 17).addBox(-1.5F, -1.0F, -6.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 8).addBox(-1.5F, 0.0F, -8.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 4).addBox(-2.75F, -0.5F, -8.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-0.25F, -0.5F, -8.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.5F, -0.5F, 0.0F, 2.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 22.0F, 0.0F));

        PartDefinition leftFrontWing = partdefinition.addOrReplaceChild("leftFrontWing", CubeListBuilder.create().texOffs(14, 9).addBox(0.0F, 0.0F, -3.0F, 11.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 21.0F, -2.75F, 0.0F, 0.1745F, 0.0F));

        PartDefinition leftBackWing = partdefinition.addOrReplaceChild("leftBackWing", CubeListBuilder.create().texOffs(14, 6).addBox(0.0F, 0.0F, 0.0F, 11.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 21.5F, -3.25F, 0.0F, -0.1745F, 0.0F));

        PartDefinition rightFrontWing = partdefinition.addOrReplaceChild("rightFrontWing", CubeListBuilder.create().texOffs(14, 3).addBox(-11.0F, 0.0F, -3.0F, 11.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 21.0F, -2.75F, 0.0F, -0.1745F, 0.0F));

        PartDefinition rightBackWing = partdefinition.addOrReplaceChild("rightBackWing", CubeListBuilder.create().texOffs(14, 0).addBox(-11.0F, 0.0F, 0.0F, 11.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 21.5F, -3.25F, 0.0F, 0.1745F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(Type pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        float f1 = Mth.cos(pAgeInTicks * 3F) / 5F;
        float f2 = Mth.cos(pAgeInTicks / 3F) / 8F;
        leftFrontWing.zRot = 0F;
        rightFrontWing.zRot = 0F;
        leftBackWing.zRot = 0F;
        rightBackWing.zRot = 0F;
        DragonflyWingPose wingPose = pEntity.getWingPose();
        if (wingPose == DragonflyWingPose.FLYING) {
            leftFrontWing.zRot += f1;
            rightFrontWing.zRot += -f1;
            leftBackWing.zRot += -f1;
            rightBackWing.zRot += f1;
        } else if (wingPose == DragonflyWingPose.PERCHED) {
            leftFrontWing.zRot += f2;
            rightFrontWing.zRot += -f2;
            leftBackWing.zRot += -f2;
            rightBackWing.zRot += f2;
        }
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leftFrontWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leftBackWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        rightFrontWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        rightBackWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
