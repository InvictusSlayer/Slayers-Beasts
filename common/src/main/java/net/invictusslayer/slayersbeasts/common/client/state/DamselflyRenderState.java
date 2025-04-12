package net.invictusslayer.slayersbeasts.common.client.state;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.invictusslayer.slayersbeasts.common.entity.Damselfly;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;

@Environment(EnvType.CLIENT)
public class DamselflyRenderState extends LivingEntityRenderState {
	public Damselfly.Variant variant = Damselfly.Variant.BLUE;
	public final AnimationState flyAnimationState = new AnimationState();
	public final AnimationState perchAnimationState = new AnimationState();
}
