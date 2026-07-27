package net.invictusslayer.slayersbeasts.client.renderer;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.SnailModel;
import net.invictusslayer.slayersbeasts.world.entity.Snail;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SnailRenderer<T extends Snail> extends MobRenderer<T, SnailModel<T>> {
    private static final ResourceLocation BROWN = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/snail/brown.png");

    public SnailRenderer(EntityRendererProvider.Context context) {
        super(context, new SnailModel<>(context.bakeLayer(SnailModel.LAYER_LOCATION)), 0.2F);
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return BROWN;
    }
}
