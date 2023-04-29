package net.invictusslayer.slayersbeasts.client.renderer;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.WorkerAntModel;
import net.invictusslayer.slayersbeasts.client.renderer.layers.AntCargoLayer;
import net.invictusslayer.slayersbeasts.entity.WorkerAnt;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WorkerAntRenderer extends MobRenderer<WorkerAnt, WorkerAntModel<WorkerAnt>> {

    private static final ResourceLocation WOOD_TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID,
            "textures/entity/wood_ant_worker.png");
    private static final ResourceLocation LEAFCUTTER_TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID,
            "textures/entity/leafcutter_ant_worker.png");
    private static final ResourceLocation MEADOW_TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID,
            "textures/entity/meadow_ant_worker.png");

    public WorkerAntRenderer(EntityRendererProvider.Context context) {
        super(context, new WorkerAntModel<>(context.bakeLayer(WorkerAntModel.LAYER_LOCATION)), 0.3f);
        this.addLayer(new AntCargoLayer(this, context.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(WorkerAnt pEntity) {
        return switch (pEntity.getAntType()) {
            case 0 -> WOOD_TEXTURE;
            case 1 -> LEAFCUTTER_TEXTURE;
            case 2 -> MEADOW_TEXTURE;
            default -> null;
        };
    }
}
