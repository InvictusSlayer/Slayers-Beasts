package net.invictusslayer.slayersbeasts.world.biome;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.data.worldgen.placement.NetherPlacements;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class SBNetherBiomes {
	public static Biome toxicJungle(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers) {
		MobSpawnSettings.Builder mobSettings = new MobSpawnSettings.Builder();

		BiomeGenerationSettings.Builder biomeSettings = new BiomeGenerationSettings.Builder(features, carvers);
		globalNetherGeneration(biomeSettings);
		BiomeDefaultFeatures.addNetherDefaultOres(biomeSettings);
		return biome(4694878, ParticleTypes.FALLING_SPORE_BLOSSOM, 0.025F, mobSettings, biomeSettings, SoundEvents.AMBIENT_WARPED_FOREST_LOOP, SoundEvents.AMBIENT_WARPED_FOREST_MOOD, SoundEvents.AMBIENT_WARPED_FOREST_ADDITIONS, SoundEvents.MUSIC_BIOME_WARPED_FOREST);
	}

	private static Biome biome(int fogColor, SimpleParticleType particle, float particleChance, MobSpawnSettings.Builder mobSettings, BiomeGenerationSettings.Builder biomeSettings, Holder<SoundEvent> loopSound, Holder<SoundEvent> moodSound, Holder<SoundEvent> additionsSound, Holder<SoundEvent> music) {
		BiomeSpecialEffects.Builder biomeEffects = new BiomeSpecialEffects.Builder().waterColor(4159204).waterFogColor(329011).fogColor(fogColor).skyColor(SBOverworldBiomes.calculateSkyColor(2.0F)).ambientParticle(new AmbientParticleSettings(particle, particleChance)).ambientLoopSound(loopSound).ambientMoodSound(new AmbientMoodSettings(moodSound, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(additionsSound, 0.0111D)).backgroundMusic(Musics.createGameMusic(music));
		return new Biome.BiomeBuilder().hasPrecipitation(false).temperature(2.0F).downfall(0.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).specialEffects(biomeEffects.build()).mobSpawnSettings(mobSettings.build()).generationSettings(biomeSettings.build()).build();
	}

	private static void globalNetherGeneration(BiomeGenerationSettings.Builder biomeSettings) {
		biomeSettings.addCarver(Carvers.NETHER_CAVE);
		biomeSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MiscOverworldPlacements.SPRING_LAVA);
		biomeSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.SPRING_OPEN);
		biomeSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.PATCH_FIRE);
		biomeSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.PATCH_SOUL_FIRE);
		biomeSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.GLOWSTONE_EXTRA);
		biomeSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.GLOWSTONE);
		biomeSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, OrePlacements.ORE_MAGMA);
		biomeSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.SPRING_CLOSED);
	}
}
