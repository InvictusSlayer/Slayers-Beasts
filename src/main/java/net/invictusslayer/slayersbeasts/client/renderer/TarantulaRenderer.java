package net.invictusslayer.slayersbeasts.client.renderer;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.TarantulaModel;
import net.invictusslayer.slayersbeasts.entity.Tarantula;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TarantulaRenderer<Type extends Tarantula> extends MobRenderer<Type, TarantulaModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/tarantula.png");

    public TarantulaRenderer(EntityRendererProvider.Context context) {
        super(context, new TarantulaModel<>(context.bakeLayer(TarantulaModel.LAYER_LOCATION)), 2f);
    }

    public ResourceLocation getTextureLocation(Type pEntity) {
        return TEXTURE;
    }
}
