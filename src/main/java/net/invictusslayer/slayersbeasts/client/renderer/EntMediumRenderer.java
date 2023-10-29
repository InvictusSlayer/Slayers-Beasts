package net.invictusslayer.slayersbeasts.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.client.model.EntMediumModel;
import net.invictusslayer.slayersbeasts.entity.EntMedium;
import net.invictusslayer.slayersbeasts.entity.SBEntities;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EntMediumRenderer<T extends EntMedium> extends MobRenderer<T, EntMediumModel<T>> {
	private static final ResourceLocation OAK = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/ent/oak.png");
	private static final ResourceLocation BIRCH = new ResourceLocation(SlayersBeasts.MOD_ID, "textures/entity/ent/birch.png");

	public EntMediumRenderer(EntityRendererProvider.Context context) {
		super(context, new EntMediumModel<>(context.bakeLayer(EntMediumModel.LAYER_LOCATION)), 0.9F);
	}

	protected void scale(T entity, PoseStack poseStack, float partialTickTime) {
		float f = 1.2F;
		poseStack.scale(f, f, f);
	}

	public ResourceLocation getTextureLocation(T entity) {
		if (entity.getType() == SBEntities.ENT_BIRCH.get()) return BIRCH;
		return OAK;
	}
}