package net.invictusslayer.slayersbeasts.common.client.state;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.entity.AntWorker;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
public class AntWorkerRenderState extends LivingEntityRenderState {
	private static final ResourceLocation DEFAULT_TEXTURE = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/ant/wood_worker.png");
	public int cargo = 99;

	public ResourceLocation texture = DEFAULT_TEXTURE;
}
