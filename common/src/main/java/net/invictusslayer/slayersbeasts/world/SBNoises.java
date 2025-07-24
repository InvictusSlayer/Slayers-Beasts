package net.invictusslayer.slayersbeasts.world;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public class SBNoises {
	public static final ResourceKey<NormalNoise.NoiseParameters> CAVE_ICE = createKey("cave_ice");
	public static final ResourceKey<NormalNoise.NoiseParameters> SAND = createKey("sand");

	public static void bootstrap(BootstapContext<NormalNoise.NoiseParameters> context) {
		register(context, CAVE_ICE, -1, 1);
		register(context, SAND, -4, 10, 6, 7, 0);
	}

	private static ResourceKey<NormalNoise.NoiseParameters> createKey(String key) {
		return ResourceKey.create(Registries.NOISE, new ResourceLocation(SlayersBeasts.MOD_ID, key));
	}

	private static void register(BootstapContext<NormalNoise.NoiseParameters> context, ResourceKey<NormalNoise.NoiseParameters> key, int firstOctave, double amplitude, double... amplitudes) {
		context.register(key, new NormalNoise.NoiseParameters(firstOctave, amplitude, amplitudes));
	}
}
