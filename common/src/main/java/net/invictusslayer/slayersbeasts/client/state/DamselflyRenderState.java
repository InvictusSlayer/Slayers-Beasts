package net.invictusslayer.slayersbeasts.client.state;

import net.invictusslayer.slayersbeasts.entity.Damselfly;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;

public class DamselflyRenderState extends LivingEntityRenderState {
	public Damselfly.Variant variant = Damselfly.Variant.BLUE;
	public final AnimationState flyAnimationState = new AnimationState();
	public final AnimationState perchAnimationState = new AnimationState();
}
