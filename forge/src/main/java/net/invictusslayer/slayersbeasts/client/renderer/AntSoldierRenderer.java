package net.invictusslayer.slayersbeasts.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.invictusslayer.slayersbeasts.client.model.AntSoldierModel;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.entity.AntSoldier;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class AntSoldierRenderer<T extends AntSoldier> extends MobRenderer<T, AntSoldierModel<T>> {
	private static final ResourceLocation WOOD = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/ant/wood_soldier.png");
	private static final ResourceLocation LEAFCUTTER = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/ant/leafcutter_soldier.png");
	private static final ResourceLocation MEADOW = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/ant/meadow_soldier.png");

	public AntSoldierRenderer(EntityRendererProvider.Context context) {
		super(context, new AntSoldierModel<>(context.bakeLayer(AntSoldierModel.LAYER_LOCATION)), 0.3F);
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
