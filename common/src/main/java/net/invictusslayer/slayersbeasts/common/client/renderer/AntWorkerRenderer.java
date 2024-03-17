package net.invictusslayer.slayersbeasts.common.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.client.model.AntWorkerModel;
import net.invictusslayer.slayersbeasts.common.client.renderer.layer.AntCargoLayer;
import net.invictusslayer.slayersbeasts.common.entity.AntWorker;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

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
		return switch (entity.getVariant()) {
			case WOOD -> WOOD;
			case LEAFCUTTER -> LEAFCUTTER;
			case MEADOW -> MEADOW;
		};
	}
}
