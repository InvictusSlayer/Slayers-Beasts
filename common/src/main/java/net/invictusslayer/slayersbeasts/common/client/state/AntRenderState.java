package net.invictusslayer.slayersbeasts.common.client.state;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.invictusslayer.slayersbeasts.common.entity.AbstractAnt;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

@Environment(EnvType.CLIENT)
public class AntRenderState extends LivingEntityRenderState {
	public AbstractAnt.Variant variant = AbstractAnt.Variant.WOOD;
}
