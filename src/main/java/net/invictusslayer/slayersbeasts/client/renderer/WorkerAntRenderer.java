package net.invictusslayer.slayersbeasts.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.WorkerAntModel;
import net.invictusslayer.slayersbeasts.client.renderer.layers.AntCargoLayer;
import net.invictusslayer.slayersbeasts.entity.WorkerAnt;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WorkerAntRenderer extends MobRenderer<WorkerAnt, WorkerAntModel<WorkerAnt>> {
    private static final ResourceLocation WOOD = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/ant/wood_worker.png");
    private static final ResourceLocation LEAFCUTTER = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/ant/leafcutter_worker.png");
    private static final ResourceLocation MEADOW = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/ant/meadow_worker.png");

    public WorkerAntRenderer(EntityRendererProvider.Context context) {
        super(context, new WorkerAntModel<>(context.bakeLayer(WorkerAntModel.LAYER_LOCATION)), 0.3f);
        this.addLayer(new AntCargoLayer(this, context.getModelSet()));
    }

    protected void scale(WorkerAnt entity, PoseStack poseStack, float partialTickTime) {
        float f = 1.2F;
        poseStack.scale(f, f, f);
    }

    public ResourceLocation getTextureLocation(WorkerAnt entity) {
        return switch (entity.getAntType()) {
            default -> WOOD;
            case 1 -> LEAFCUTTER;
            case 2 -> MEADOW;
        };
    }
}
