package net.invictusslayer.slayersbeasts.client.state;

import net.invictusslayer.slayersbeasts.world.entity.Butterfly;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;

public class ButterflyRenderState extends LivingEntityRenderState {
	public final AnimationState idleAnimationState = new AnimationState();
	public final AnimationState flyingAnimationState = new AnimationState();
}
