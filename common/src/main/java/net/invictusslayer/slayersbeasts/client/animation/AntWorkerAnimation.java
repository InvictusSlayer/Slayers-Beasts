package net.invictusslayer.slayersbeasts.client.animation;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class AntWorkerAnimation {
	public static final AnimationDefinition WALK = AnimationDefinition.Builder.withLength(3f).looping()
		.addAnimation("leg_left_front",
				new AnimationChannel(AnimationChannel.Targets.ROTATION,
						new Keyframe(0f, KeyframeAnimations.degreeVec(-5f, 10f, -20f),
								AnimationChannel.Interpolations.LINEAR),
						new Keyframe(0.75f, KeyframeAnimations.degreeVec(7.5f, 15f, 2.5f),
								AnimationChannel.Interpolations.LINEAR),
						new Keyframe(1.5f, KeyframeAnimations.degreeVec(5f, 5f, 2.5f),
								AnimationChannel.Interpolations.LINEAR),
						new Keyframe(2.25f, KeyframeAnimations.degreeVec(-5f, -10f, -2.5f),
								AnimationChannel.Interpolations.LINEAR),
						new Keyframe(3f, KeyframeAnimations.degreeVec(-5f, 10f, -20f),
								AnimationChannel.Interpolations.LINEAR)))
		.addAnimation("leg_left_mid",
				new AnimationChannel(AnimationChannel.Targets.ROTATION,
						new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
								AnimationChannel.Interpolations.LINEAR),
						new Keyframe(0.75f, KeyframeAnimations.degreeVec(-5f, -10f, 0f),
								AnimationChannel.Interpolations.LINEAR),
						new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, -20f),
								AnimationChannel.Interpolations.LINEAR),
						new Keyframe(2.25f, KeyframeAnimations.degreeVec(7.5f, 10f, 0f),
								AnimationChannel.Interpolations.LINEAR),
						new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
								AnimationChannel.Interpolations.LINEAR)))
		.addAnimation("leg_left_hind",
				new AnimationChannel(AnimationChannel.Targets.ROTATION,
						new Keyframe(0f, KeyframeAnimations.degreeVec(10f, 0f, -22.5f),
								AnimationChannel.Interpolations.LINEAR),
						new Keyframe(0.75f, KeyframeAnimations.degreeVec(10f, 10f, -2.5f),
								AnimationChannel.Interpolations.LINEAR),
						new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
								AnimationChannel.Interpolations.LINEAR),
						new Keyframe(2.25f, KeyframeAnimations.degreeVec(-10f, -12.5f, 5f),
								AnimationChannel.Interpolations.LINEAR),
						new Keyframe(3f, KeyframeAnimations.degreeVec(10f, 0f, -22.5f),
								AnimationChannel.Interpolations.LINEAR)))
		.addAnimation("leg_right_front",
				new AnimationChannel(AnimationChannel.Targets.ROTATION,
						new Keyframe(0f, KeyframeAnimations.degreeVec(5f, -5f, -2.5f),
								AnimationChannel.Interpolations.LINEAR),
						new Keyframe(0.75f, KeyframeAnimations.degreeVec(-5f, 10f, 2.5f),
								AnimationChannel.Interpolations.LINEAR),
						new Keyframe(1.5f, KeyframeAnimations.degreeVec(-5f, -10f, 20f),
								AnimationChannel.Interpolations.LINEAR),
						new Keyframe(2.25f, KeyframeAnimations.degreeVec(7.5f, -15f, -2.5f),
								AnimationChannel.Interpolations.LINEAR),
						new Keyframe(3f, KeyframeAnimations.degreeVec(5f, -5f, -2.5f),
								AnimationChannel.Interpolations.LINEAR)))
		.addAnimation("leg_right_mid",
				new AnimationChannel(AnimationChannel.Targets.ROTATION,
						new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 20f),
								AnimationChannel.Interpolations.LINEAR),
						new Keyframe(0.75f, KeyframeAnimations.degreeVec(7.5f, -10f, 0f),
								AnimationChannel.Interpolations.LINEAR),
						new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
								AnimationChannel.Interpolations.LINEAR),
						new Keyframe(2.25f, KeyframeAnimations.degreeVec(-5f, 10f, 0f),
								AnimationChannel.Interpolations.LINEAR),
						new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 20f),
								AnimationChannel.Interpolations.LINEAR)))
		.addAnimation("leg_right_hind",
				new AnimationChannel(AnimationChannel.Targets.ROTATION,
						new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
								AnimationChannel.Interpolations.LINEAR),
						new Keyframe(0.75f, KeyframeAnimations.degreeVec(-10f, 12.5f, -5f),
								AnimationChannel.Interpolations.LINEAR),
						new Keyframe(1.5f, KeyframeAnimations.degreeVec(10f, 0f, 22.5f),
								AnimationChannel.Interpolations.LINEAR),
						new Keyframe(2.25f, KeyframeAnimations.degreeVec(10f, -10f, 2.5f),
								AnimationChannel.Interpolations.LINEAR),
						new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
								AnimationChannel.Interpolations.LINEAR))).build();
}
