package net.invictusslayer.slayersbeasts.client.renderer;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.MantisModel;
import net.invictusslayer.slayersbeasts.entity.Mantis;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MantisRenderer<Type extends Mantis> extends MobRenderer<Type, MantisModel<Type>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID,
            "textures/entity/mantis.png");

    public MantisRenderer(EntityRendererProvider.Context context) {
        super(context, new MantisModel<>(context.bakeLayer(MantisModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Type pEntity) {
        return TEXTURE;
    }
}
