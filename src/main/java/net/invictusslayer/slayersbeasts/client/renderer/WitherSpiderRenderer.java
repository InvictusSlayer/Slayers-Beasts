package net.invictusslayer.slayersbeasts.client.renderer;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.WitherSpiderModel;
import net.invictusslayer.slayersbeasts.entity.WitherSpider;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WitherSpiderRenderer<Type extends WitherSpider> extends MobRenderer<Type, WitherSpiderModel<Type>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID,
            "textures/entity/wither_spider.png");

    public WitherSpiderRenderer(EntityRendererProvider.Context context) {
        super(context, new WitherSpiderModel<>(context.bakeLayer(WitherSpiderModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Type pEntity) {
        return TEXTURE;
    }
}
