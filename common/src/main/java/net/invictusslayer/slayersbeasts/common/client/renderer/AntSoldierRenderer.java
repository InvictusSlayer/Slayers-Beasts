package net.invictusslayer.slayersbeasts.common.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.client.model.AntSoldierModel;
import net.invictusslayer.slayersbeasts.common.client.state.AntSoldierRenderState;
import net.invictusslayer.slayersbeasts.common.entity.AntSoldier;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
public class AntSoldierRenderer extends MobRenderer<AntSoldier, AntSoldierRenderState, AntSoldierModel> {
	private static final ResourceLocation WOOD = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/ant/wood_soldier.png");
	private static final ResourceLocation LEAFCUTTER = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/ant/leafcutter_soldier.png");
	private static final ResourceLocation MEADOW = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/ant/meadow_soldier.png");

	public AntSoldierRenderer(EntityRendererProvider.Context context) {
		super(context, new AntSoldierModel(context.bakeLayer(AntSoldierModel.LAYER_LOCATION)), 0.3F);
	}

	protected void scale(AntSoldierRenderState state, PoseStack poseStack) {
		float f = 1.5F;
		poseStack.scale(f, f, f);
	}

	public ResourceLocation getTextureLocation(AntSoldierRenderState state) {
		return switch (state.variant) {
			case WOOD -> WOOD;
			case LEAFCUTTER -> LEAFCUTTER;
			case MEADOW -> MEADOW;
		};
	}

	public AntSoldierRenderState createRenderState() {
		return new AntSoldierRenderState();
	}

	public void extractRenderState(AntSoldier entity, AntSoldierRenderState state, float f) {
		super.extractRenderState(entity, state, f);
		state.variant = entity.getVariant();
	}
}
