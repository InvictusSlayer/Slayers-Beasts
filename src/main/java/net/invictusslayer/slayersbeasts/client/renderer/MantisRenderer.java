package net.invictusslayer.slayersbeasts.client.renderer;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.MantisModel;
import net.invictusslayer.slayersbeasts.client.state.MantisRenderState;
import net.invictusslayer.slayersbeasts.entity.Mantis;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
//$ client_env {
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)//$}
public class MantisRenderer extends MobRenderer<Mantis, MantisRenderState, MantisModel> {
	private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/mantis.png");

	public MantisRenderer(EntityRendererProvider.Context context) {
		super(context, new MantisModel(context.bakeLayer(MantisModel.LAYER_LOCATION)), 1.2F);
	}

	public ResourceLocation getTextureLocation(MantisRenderState state) {
		return TEXTURE;
	}

	public MantisRenderState createRenderState() {
		return new MantisRenderState();
	}
}
