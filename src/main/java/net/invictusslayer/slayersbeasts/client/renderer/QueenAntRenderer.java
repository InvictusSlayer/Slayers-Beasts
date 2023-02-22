package net.invictusslayer.slayersbeasts.client.renderer;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.QueenAntModel;
import net.invictusslayer.slayersbeasts.client.model.SoldierAntModel;
import net.invictusslayer.slayersbeasts.entity.QueenAntEntity;
import net.invictusslayer.slayersbeasts.entity.SoldierAntEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class QueenAntRenderer<Type extends QueenAntEntity> extends MobRenderer<Type, QueenAntModel<Type>> {

    private static final ResourceLocation WOOD_TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID,
            "textures/entity/wood_ant_queen.png");
    private static final ResourceLocation LEAFCUTTER_TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID,
            "textures/entity/leafcutter_ant_queen.png");
    private static final ResourceLocation MEADOW_TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID,
            "textures/entity/meadow_ant_queen.png");

    public QueenAntRenderer(EntityRendererProvider.Context context) {
        super(context, new QueenAntModel<>(context.bakeLayer(QueenAntModel.LAYER_LOCATION)), 0.3f);
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
