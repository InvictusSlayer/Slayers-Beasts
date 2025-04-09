package net.invictusslayer.slayersbeasts.client.state;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.ResourceLocation;
//$ client_env {
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)//$}
public class AntSoldierRenderState extends LivingEntityRenderState {
	private static final ResourceLocation DEFAULT_TEXTURE = ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "textures/entity/ant/wood_soldier.png");

	public ResourceLocation texture = DEFAULT_TEXTURE;
}
