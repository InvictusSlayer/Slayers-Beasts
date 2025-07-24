package net.invictusslayer.slayersbeasts.client.state;

import net.invictusslayer.slayersbeasts.entity.AbstractAnt;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

public class AntRenderState extends LivingEntityRenderState {
	public AbstractAnt.Variant variant = AbstractAnt.Variant.WOOD;
}
