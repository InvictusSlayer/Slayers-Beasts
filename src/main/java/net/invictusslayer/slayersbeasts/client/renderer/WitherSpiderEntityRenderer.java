package net.invictusslayer.slayersbeasts.client.renderer;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.MantisEntityModel;
import net.invictusslayer.slayersbeasts.client.model.WitherSpiderEntityModel;
import net.invictusslayer.slayersbeasts.entities.MantisEntity;
import net.invictusslayer.slayersbeasts.entities.WitherSpiderEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WitherSpiderEntityRenderer<Type extends WitherSpiderEntity> extends MobRenderer<Type, WitherSpiderEntityModel<Type>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID,
            "textures/entity/wither_spider_entity.png");

    public WitherSpiderEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new WitherSpiderEntityModel<>(context.bakeLayer(WitherSpiderEntityModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Type pEntity) {
        return TEXTURE;
    }
}
