package net.invictusslayer.slayersbeasts.client.renderer;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.VenusFlytrapEntityModel;
import net.invictusslayer.slayersbeasts.entity.VenusFlytrapEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class VenusFlytrapEntityRenderer<Type extends VenusFlytrapEntity> extends MobRenderer<Type, VenusFlytrapEntityModel<Type>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(SlayersBeasts.MOD_ID,
            "textures/entity/venus_flytrap_entity.png");

    public VenusFlytrapEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new VenusFlytrapEntityModel<>(context.bakeLayer(VenusFlytrapEntityModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Type pEntity) {
        return TEXTURE;
    }
}
