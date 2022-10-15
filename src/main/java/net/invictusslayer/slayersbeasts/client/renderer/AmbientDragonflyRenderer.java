package net.invictusslayer.slayersbeasts.client.renderer;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.AmbientDragonflyModel;
import net.invictusslayer.slayersbeasts.client.model.MantisModel;
import net.invictusslayer.slayersbeasts.entity.AmbientDragonflyEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class AmbientDragonflyRenderer<Type extends AmbientDragonflyEntity> extends MobRenderer<Type, AmbientDragonflyModel<Type>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID,
            "textures/entity/ambient_dragonfly_entity.png");

    public AmbientDragonflyRenderer(EntityRendererProvider.Context context) {
        super(context, new AmbientDragonflyModel<>(context.bakeLayer(AmbientDragonflyModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Type pEntity) {
        return TEXTURE;
    }
}
