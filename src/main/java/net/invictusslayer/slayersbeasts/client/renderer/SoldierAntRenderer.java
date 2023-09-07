package net.invictusslayer.slayersbeasts.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.SoldierAntModel;
import net.invictusslayer.slayersbeasts.entity.SoldierAnt;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SoldierAntRenderer<Type extends SoldierAnt> extends MobRenderer<Type, SoldierAntModel<Type>> {
    private static final ResourceLocation WOOD = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/ant/wood_soldier.png");
    private static final ResourceLocation LEAFCUTTER = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/ant/leafcutter_soldier.png");
    private static final ResourceLocation MEADOW = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/ant/meadow_soldier.png");

    public SoldierAntRenderer(EntityRendererProvider.Context context) {
        super(context, new SoldierAntModel<>(context.bakeLayer(SoldierAntModel.LAYER_LOCATION)), 0.3f);
    }

    protected void scale(SoldierAnt entity, PoseStack poseStack, float partialTickTime) {
        float f = 1.5F;
        poseStack.scale(f, f, f);
    }

    public ResourceLocation getTextureLocation(Type pEntity) {
        return switch (pEntity.getAntType()) {
            default -> WOOD;
            case 1 -> LEAFCUTTER;
            case 2 -> MEADOW;
        };
    }
}
