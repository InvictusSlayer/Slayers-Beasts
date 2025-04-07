package net.invictusslayer.slayersbeasts.common.client.animation;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

@Environment(EnvType.CLIENT)
public class TyrachnidAnimation {
	public static final AnimationDefinition WALK = AnimationDefinition.Builder.withLength(3f).looping()
			.addAnimation("leg_left_front",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(2.5f, 5f, -7.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(35f, 15f, 32.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(12.5f, 2.5f, 10f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(-2.5f, -17.5f, -7.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(2.5f, 5f, -7.5f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("l11",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 10f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 17.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, -2.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(0f, 0f, -10f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 10f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("l12",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -30f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, -40f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, -7.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(0f, 0f, 12.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, -30f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("l13",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 15f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, -12.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(0f, 0f, 17.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 15f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("l14",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 20f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, -5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, -2.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(0f, 0f, 7.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 20f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("leg_left_mid_front",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(-2.5f, -15f, 2.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(-7.5f, -22.5f, -5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(-5f, -5f, -12.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(5f, -2.5f, 10f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(-2.5f, -15f, 2.5f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("l21",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, -7.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 12.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(0f, 0f, 20f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 5f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("l22",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -12.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 10f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, -30f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(0f, 0f, -37.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, -12.5f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("l23",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 15f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 25f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(0f, 0f, -12.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 5f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("l24",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 2.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 17.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(0f, 0f, -5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 2.5f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("leg_left_mid_hind",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(-5f, -10f, -7.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(-2.5f, -2.5f, 2.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(-2.5f, -12.5f, 5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(-10f, -27.5f, 10f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(-5f, -10f, -7.5f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("l31",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, -12.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, -2.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(0f, 0f, 7.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("l32",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -20f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 7.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, -5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(0f, 0f, -17.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, -20f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("l33",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 15f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 17.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 2.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(0f, 0f, -7.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 15f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("l34",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 20f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 7.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(0f, 0f, -12.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 20f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("leg_left_hind",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(-7.5f, -12.5f, 12.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(-15f, -22.5f, 27.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(5f, -15f, -5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(2.5f, -2.5f, 2.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(-7.5f, -12.5f, 12.5f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("l41",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -2.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 12.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 2.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(0f, 0f, -20f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, -2.5f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("l42",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -7.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, -35f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, -22.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(0f, 0f, 20f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, -7.5f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("l43",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -2.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, -15f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 22.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(0f, 0f, 7.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, -2.5f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("l44",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 2.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, -7.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 20f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(0f, 0f, 7.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 2.5f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("leg_right_front",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(12.5f, -2.5f, -10f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(-2.5f, 17.5f, 7.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(2.5f, -5f, 7.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(35f, -15f, -32.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(12.5f, -2.5f, -10f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("r11",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 2.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 10f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, -10f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(0f, 0f, -17.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 2.5f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("r12",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 7.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, -12.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 30f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(0f, 0f, 40f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 7.5f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("r13",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, -17.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, -15f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(0f, 0f, 12.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, -5f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("r14",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 2.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, -7.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, -20f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(0f, 0f, 5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 2.5f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("leg_right_mid_front",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(-5f, 5f, 12.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(5f, 2.5f, -10f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(-2.5f, 15f, -2.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(-7.5f, 22.5f, 5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(-5f, 5f, 12.5f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("r21",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -12.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, -20f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, -5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(0f, 0f, 7.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, -12.5f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("r22",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 30f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 37.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 12.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(0f, 0f, -10f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 30f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("r23",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -25f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 12.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, -5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(0f, 0f, -15f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, -25f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("r24",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -17.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, -5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, -2.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(0f, 0f, -5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, -17.5f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("leg_right_mid_hind",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(-2.5f, 12.5f, -5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(-10f, 27.5f, -10f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(-5f, 10f, 7.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(-2.5f, 2.5f, -2.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(-2.5f, 12.5f, -5f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("r31",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 2.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, -7.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(0f, 0f, 12.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 2.5f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("r32",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 17.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 20f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(0f, 0f, -7.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 5f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("r33",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -2.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 7.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, -15f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(0f, 0f, -17.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, -2.5f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("r34",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 12.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, -20f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(0f, 0f, -7.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, -5f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("leg_right_hind",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(5f, 15f, 5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(2.5f, 2.5f, -2.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(-7.5f, 12.5f, -12.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(-15f, 22.5f, -27.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(5f, 15f, 5f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("r41",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -2.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 20f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 2.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(0f, 0f, -12.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, -2.5f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("r42",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 22.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, -20f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 7.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(0f, 0f, 35f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 22.5f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("r43",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -22.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, -7.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 2.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(0f, 0f, 15f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, -22.5f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("r44",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -20f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, -7.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, -2.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(0f, 0f, 7.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, -20f),
									AnimationChannel.Interpolations.LINEAR))).build();
}
