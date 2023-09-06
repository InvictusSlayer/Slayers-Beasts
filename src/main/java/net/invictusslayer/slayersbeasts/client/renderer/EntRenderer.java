package net.invictusslayer.slayersbeasts.client.renderer;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.EntOakModel;
import net.invictusslayer.slayersbeasts.entity.LargeEnt;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class EntRenderer<Type extends LargeEnt> extends MobRenderer<Type, EntOakModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/ent/oak.png");

    public EntRenderer(EntityRendererProvider.Context context) {
        super(context, new EntOakModel<>(context.bakeLayer(EntOakModel.LAYER_LOCATION)), 1.5f);
    }

    public ResourceLocation getTextureLocation(Type pEntity) {
        return TEXTURE;
    }
}
