package net.invictusslayer.slayersbeasts.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.AntQueenModel;
import net.invictusslayer.slayersbeasts.client.state.AntQueenRenderState;
import net.invictusslayer.slayersbeasts.entity.AntQueen;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
//$ client_env {
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)//$}
public class AntQueenRenderer extends MobRenderer<AntQueen, AntQueenRenderState, AntQueenModel> {
	private static final ResourceLocation WOOD = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/ant/wood_queen.png");
	private static final ResourceLocation LEAFCUTTER = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/ant/leafcutter_queen.png");
	private static final ResourceLocation MEADOW = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/ant/meadow_queen.png");

	public AntQueenRenderer(EntityRendererProvider.Context context) {
		super(context, new AntQueenModel(context.bakeLayer(AntQueenModel.LAYER_LOCATION)), 0.3F);
	}

	protected void scale(AntQueenRenderState entity, PoseStack poseStack) {
		float f = 1.5F;
		poseStack.scale(f, f, f);
	}

	public ResourceLocation getTextureLocation(AntQueenRenderState state) {
		return state.texture;
	}

	public AntQueenRenderState createRenderState() {
		return new AntQueenRenderState();
	}
}
