package net.invictusslayer.slayersbeasts.client.state;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;

public class MantisRenderState extends LivingEntityRenderState {
	public boolean isScuttling = false;
	public final AnimationState flapAnimationState = new AnimationState();
	public final AnimationState strikeAnimationState = new AnimationState();
}
