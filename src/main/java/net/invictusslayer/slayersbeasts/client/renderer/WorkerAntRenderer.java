package net.invictusslayer.slayersbeasts.client.renderer;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.WorkerAntModel;
import net.invictusslayer.slayersbeasts.entity.WorkerAntEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WorkerAntRenderer<Type extends WorkerAntEntity> extends MobRenderer<Type, WorkerAntModel<Type>> {

    private static final ResourceLocation WOOD_TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID,
            "textures/entity/wood_ant_worker.png");
    private static final ResourceLocation LEAFCUTTER_TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID,
            "textures/entity/leafcutter_ant_worker.png");
    private static final ResourceLocation MEADOW_TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID,
            "textures/entity/meadow_ant_worker.png");

    public WorkerAntRenderer(EntityRendererProvider.Context context) {
        super(context, new WorkerAntModel<>(context.bakeLayer(WorkerAntModel.LAYER_LOCATION)), 0.3f);
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