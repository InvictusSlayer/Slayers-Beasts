package net.invictusslayer.slayersbeasts.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.WorkerAntModel;
import net.invictusslayer.slayersbeasts.client.renderer.layers.AntCargoLayer;
import net.invictusslayer.slayersbeasts.entity.WorkerAnt;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WorkerAntRenderer extends MobRenderer<WorkerAnt, WorkerAntModel<WorkerAnt>> {

    private static final ResourceLocation WOOD_TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID,
            "textures/entity/ant/wood/worker.png");
    private static final ResourceLocation LEAFCUTTER_TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID,
            "textures/entity/ant/leafcutter/worker.png");
    private static final ResourceLocation MEADOW_TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID,
            "textures/entity/ant/meadow/worker.png");

    public WorkerAntRenderer(EntityRendererProvider.Context context) {
        super(context, new WorkerAntModel<>(context.bakeLayer(WorkerAntModel.LAYER_LOCATION)), 0.3f);
        this.addLayer(new AntCargoLayer(this, context.getModelSet()));
    }

    @Override
    public void render(WorkerAnt pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.scale(1.5f, 1.5f, 1.5f);
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
