package net.invictusslayer.slayersbeasts.client.renderer;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.MantisEntityModel;
import net.invictusslayer.slayersbeasts.entity.MantisEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MantisEntityRenderer<Type extends MantisEntity> extends MobRenderer<Type, MantisEntityModel<Type>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID,
            "textures/entity/mantis_entity.png");

    public MantisEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new MantisEntityModel<>(context.bakeLayer(MantisEntityModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Type pEntity) {
        return TEXTURE;
    }
}
