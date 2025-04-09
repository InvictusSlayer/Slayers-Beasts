package net.invictusslayer.slayersbeasts.client.state;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
//$ client_env {
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)//$}
public class MantisRenderState extends LivingEntityRenderState {
	public boolean isScuttling = false;
}
