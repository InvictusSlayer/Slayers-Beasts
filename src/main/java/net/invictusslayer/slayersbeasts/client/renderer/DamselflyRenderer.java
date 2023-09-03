package net.invictusslayer.slayersbeasts.client.renderer;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.DamselflyModel;
import net.invictusslayer.slayersbeasts.entity.Damselfly;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DamselflyRenderer<Type extends Damselfly> extends MobRenderer<Type, DamselflyModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/damselfly.png");

    public DamselflyRenderer(EntityRendererProvider.Context context) {
        super(context, new DamselflyModel<>(context.bakeLayer(DamselflyModel.LAYER_LOCATION)), 0.5f);
    }

    public ResourceLocation getTextureLocation(Type pEntity) {
        return TEXTURE;
    }
}
