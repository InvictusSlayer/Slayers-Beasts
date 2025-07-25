package net.invictusslayer.slayersbeasts.client.animation;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class EntMediumAnimation {
	public static final AnimationDefinition WALK = AnimationDefinition.Builder.withLength(4f).looping()
			.addAnimation("body",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0f, KeyframeAnimations.posVec(0f, -5f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1f, KeyframeAnimations.posVec(0f, -1f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2f, KeyframeAnimations.posVec(0f, -5f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.posVec(0f, -1f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.5f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(4f, KeyframeAnimations.posVec(0f, -5f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("body",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, -5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 5f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("arm_left",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(32.5f, 0f, -7.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2f, KeyframeAnimations.degreeVec(-15f, 0f, -7.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(4f, KeyframeAnimations.degreeVec(32.5f, 0f, -7.5f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("arm_lower_left",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(-5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2f, KeyframeAnimations.degreeVec(-25f, 0f, 15f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(4f, KeyframeAnimations.degreeVec(-5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("arm_right",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(-15f, 0f, 7.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2f, KeyframeAnimations.degreeVec(32.5f, 0f, 7.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(4f, KeyframeAnimations.degreeVec(-15f, 0f, 7.5f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("arm_lower_right",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(-25f, 0f, -15f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2f, KeyframeAnimations.degreeVec(-5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(4f, KeyframeAnimations.degreeVec(-25f, 0f, -15f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("leg_left",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(-30f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(10f, 7.5f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2f, KeyframeAnimations.degreeVec(22.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.5f, KeyframeAnimations.degreeVec(-45f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(4f, KeyframeAnimations.degreeVec(-30f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("leg_lower_left",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(30f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2f, KeyframeAnimations.degreeVec(25f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.5f, KeyframeAnimations.degreeVec(30f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(4f, KeyframeAnimations.degreeVec(30f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("leg_right",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(22.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(-45f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2f, KeyframeAnimations.degreeVec(-30f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.5f, KeyframeAnimations.degreeVec(10f, -7.5f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(4f, KeyframeAnimations.degreeVec(22.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("leg_lower_right",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(25f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(30f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2f, KeyframeAnimations.degreeVec(30f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.5f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(4f, KeyframeAnimations.degreeVec(25f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR))).build();
}
