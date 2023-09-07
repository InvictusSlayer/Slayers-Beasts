package net.invictusslayer.slayersbeasts.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.QueenAntModel;
import net.invictusslayer.slayersbeasts.entity.QueenAnt;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class QueenAntRenderer<Type extends QueenAnt> extends MobRenderer<Type, QueenAntModel<Type>> {
    private static final ResourceLocation WOOD = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/ant/wood_queen.png");
    private static final ResourceLocation LEAFCUTTER = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/ant/leafcutter_queen.png");
    private static final ResourceLocation MEADOW = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/ant/meadow_queen.png");

    public QueenAntRenderer(EntityRendererProvider.Context context) {
        super(context, new QueenAntModel<>(context.bakeLayer(QueenAntModel.LAYER_LOCATION)), 0.3f);
    }

    protected void scale(QueenAnt entity, PoseStack poseStack, float partialTickTime) {
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
