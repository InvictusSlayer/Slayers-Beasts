package net.invictusslayer.slayersbeasts.common.client.state;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;

@Environment(EnvType.CLIENT)
public class MantisRenderState extends LivingEntityRenderState {
	public boolean isScuttling = false;
	public final AnimationState flapAnimationState = new AnimationState();
	public final AnimationState strikeAnimationState = new AnimationState();
}
