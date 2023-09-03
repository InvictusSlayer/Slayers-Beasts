package net.invictusslayer.slayersbeasts.client.renderer;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.VenusFlytrapModel;
import net.invictusslayer.slayersbeasts.entity.VenusFlytrap;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class VenusFlytrapRenderer<Type extends VenusFlytrap> extends MobRenderer<Type, VenusFlytrapModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/venus_flytrap.png");

    public VenusFlytrapRenderer(EntityRendererProvider.Context context) {
        super(context, new VenusFlytrapModel<>(context.bakeLayer(VenusFlytrapModel.LAYER_LOCATION)), 0.5f);
    }

    public ResourceLocation getTextureLocation(Type pEntity) {
        return TEXTURE;
    }
}
