package net.invictusslayer.slayersbeasts.client.renderer;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.DamselflyModel;
import net.invictusslayer.slayersbeasts.entity.DamselflyEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DamselflyRenderer<Type extends DamselflyEntity> extends MobRenderer<Type, DamselflyModel<Type>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID,
            "textures/entity/damselfly_entity.png");

    public DamselflyRenderer(EntityRendererProvider.Context context) {
        super(context, new DamselflyModel<>(context.bakeLayer(DamselflyModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Type pEntity) {
        return TEXTURE;
    }
}
