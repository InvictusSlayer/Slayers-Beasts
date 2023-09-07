package net.invictusslayer.slayersbeasts.client.renderer;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.DamselflyModel;
import net.invictusslayer.slayersbeasts.entity.Damselfly;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DamselflyRenderer<T extends Damselfly> extends MobRenderer<T, DamselflyModel<T>> {
    private static final ResourceLocation BLUE = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/damselfly/blue.png");
    private static final ResourceLocation GREEN = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/damselfly/green.png");
    private static final ResourceLocation YELLOW = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/damselfly/yellow.png");

    public DamselflyRenderer(EntityRendererProvider.Context context) {
        super(context, new DamselflyModel<>(context.bakeLayer(DamselflyModel.LAYER_LOCATION)), 0.5f);
    }

    public ResourceLocation getTextureLocation(T pEntity) {
        return switch (pEntity.getDamselflyType()) {
            default -> BLUE;
            case 1 -> GREEN;
            case 2 -> YELLOW;
        };
    }
}
