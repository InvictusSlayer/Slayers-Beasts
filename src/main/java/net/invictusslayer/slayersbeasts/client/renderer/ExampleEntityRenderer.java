package net.invictusslayer.slayersbeasts.client.renderer;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.ExampleEntityModel;
import net.invictusslayer.slayersbeasts.entity.ExampleEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ExampleEntityRenderer<Type extends ExampleEntity> extends MobRenderer<Type, ExampleEntityModel<Type>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID,
            "textures/entity/example_entity.png");

    public ExampleEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new ExampleEntityModel<>(context.bakeLayer(ExampleEntityModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Type pEntity) {
        return TEXTURE;
    }
}
