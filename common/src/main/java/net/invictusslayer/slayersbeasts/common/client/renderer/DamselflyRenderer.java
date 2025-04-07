package net.invictusslayer.slayersbeasts.common.client.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.client.model.DamselflyModel;
import net.invictusslayer.slayersbeasts.common.entity.Damselfly;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
public class DamselflyRenderer extends MobRenderer<Damselfly, LivingEntityRenderState, DamselflyModel> {
	private static final ResourceLocation BLUE = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/damselfly/blue.png");
	private static final ResourceLocation GREEN = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/damselfly/green.png");
	private static final ResourceLocation YELLOW = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/damselfly/yellow.png");

	public DamselflyRenderer(EntityRendererProvider.Context context) {
		super(context, new DamselflyModel(context.bakeLayer(DamselflyModel.LAYER_LOCATION)), 0.5F);
	}

	public ResourceLocation getTextureLocation(LivingEntityRenderState state) {
		return BLUE;
	}

	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}
}
