package net.invictusslayer.slayersbeasts.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.AntWorkerModel;
import net.invictusslayer.slayersbeasts.client.renderer.layer.AntCargoLayer;
import net.invictusslayer.slayersbeasts.entity.AntWorker;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class AntWorkerRenderer<T extends AntWorker> extends MobRenderer<T, AntWorkerModel<T>> {
	private static final ResourceLocation WOOD = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/ant/wood_worker.png");
	private static final ResourceLocation LEAFCUTTER = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/ant/leafcutter_worker.png");
	private static final ResourceLocation MEADOW = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/ant/meadow_worker.png");

	public AntWorkerRenderer(EntityRendererProvider.Context context) {
		super(context, new AntWorkerModel<>(context.bakeLayer(AntWorkerModel.LAYER_LOCATION)), 0.3F);
		this.addLayer(new AntCargoLayer<>(this, context.getModelSet()));
	}

	protected void scale(T entity, PoseStack poseStack, float partialTickTime) {
		float f = 1.2F;
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
