package net.invictusslayer.slayersbeasts.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.QueenAntModel;
import net.invictusslayer.slayersbeasts.entity.QueenAnt;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class QueenAntRenderer<Type extends QueenAnt> extends MobRenderer<Type, QueenAntModel<Type>> {

    private static final ResourceLocation WOOD_TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID,
            "textures/entity/ant/wood/queen.png");
    private static final ResourceLocation LEAFCUTTER_TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID,
            "textures/entity/ant/leafcutter/queen.png");
    private static final ResourceLocation MEADOW_TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID,
            "textures/entity/ant/meadow/queen.png");

    public QueenAntRenderer(EntityRendererProvider.Context context) {
        super(context, new QueenAntModel<>(context.bakeLayer(QueenAntModel.LAYER_LOCATION)), 0.3f);
    }

    @Override
    public void render(Type pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.scale(1.5f, 1.5f, 1.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Type pEntity) {
        return switch (pEntity.getAntType()) {
            case 0 -> WOOD_TEXTURE;
            case 1 -> LEAFCUTTER_TEXTURE;
            case 2 -> MEADOW_TEXTURE;
            default -> null;
        };
    }
}
