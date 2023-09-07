package net.invictusslayer.slayersbeasts.client.renderer;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.EntOakModel;
import net.invictusslayer.slayersbeasts.entity.EntOak;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class EntOakRenderer<T extends EntOak> extends MobRenderer<T, EntOakModel<T>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/ent/oak.png");

    public EntOakRenderer(EntityRendererProvider.Context context) {
        super(context, new EntOakModel<>(context.bakeLayer(EntOakModel.LAYER_LOCATION)), 1.0f);
    }

    public ResourceLocation getTextureLocation(T pEntity) {
        return TEXTURE;
    }
}
