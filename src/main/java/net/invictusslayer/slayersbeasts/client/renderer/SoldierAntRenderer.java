package net.invictusslayer.slayersbeasts.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.SoldierAntModel;
import net.invictusslayer.slayersbeasts.entity.SoldierAnt;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SoldierAntRenderer<Type extends SoldierAnt> extends MobRenderer<Type, SoldierAntModel<Type>> {

    private static final ResourceLocation WOOD_TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID,
            "textures/entity/ant/wood/soldier.png");
    private static final ResourceLocation LEAFCUTTER_TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID,
            "textures/entity/ant/leafcutter/soldier.png");
    private static final ResourceLocation MEADOW_TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID,
            "textures/entity/ant/meadow/soldier.png");

    public SoldierAntRenderer(EntityRendererProvider.Context context) {
        super(context, new SoldierAntModel<>(context.bakeLayer(SoldierAntModel.LAYER_LOCATION)), 0.3f);
    }

    @Override
    public void render(Type pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.scale(1.5f, 1.5f, 1.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Type pEntity) {
        return switch (pEntity.getAntType()) {
            case 1 -> LEAFCUTTER_TEXTURE;
            case 2 -> MEADOW_TEXTURE;
            default -> WOOD_TEXTURE;
        };
    }
}
