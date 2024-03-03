package net.invictusslayer.slayersbeasts.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.invictusslayer.slayersbeasts.client.model.AntQueenModel;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.entity.AntQueen;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class AntQueenRenderer<T extends AntQueen> extends MobRenderer<T, AntQueenModel<T>> {
	private static final ResourceLocation WOOD = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/ant/wood_queen.png");
	private static final ResourceLocation LEAFCUTTER = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/ant/leafcutter_queen.png");
	private static final ResourceLocation MEADOW = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/ant/meadow_queen.png");

	public AntQueenRenderer(EntityRendererProvider.Context context) {
		super(context, new AntQueenModel<>(context.bakeLayer(AntQueenModel.LAYER_LOCATION)), 0.3F);
	}

	protected void scale(T entity, PoseStack poseStack, float partialTickTime) {
		float f = 1.5F;
		poseStack.scale(f, f, f);
	}

	public ResourceLocation getTextureLocation(T entity) {
		return switch (entity.getAntType()) {
			default -> WOOD;
			case 1 -> LEAFCUTTER;
			case 2 -> MEADOW;
		};
	}
}
