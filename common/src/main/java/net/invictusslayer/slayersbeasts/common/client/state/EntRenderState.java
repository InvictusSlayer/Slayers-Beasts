package net.invictusslayer.slayersbeasts.common.client.state;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.invictusslayer.slayersbeasts.common.entity.AbstractEnt;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

@Environment(EnvType.CLIENT)
public class EntRenderState extends LivingEntityRenderState {
	public AbstractEnt.Variant variant = AbstractEnt.Variant.OAK;
}
