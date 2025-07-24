package net.invictusslayer.slayersbeasts.world.biome.region;

import com.mojang.datafixers.util.Pair;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.world.biome.SBBiomes;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.ParameterUtils.*;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

public class SBEndRegion extends Region {
	public SBEndRegion(int weight) {
		super(new ResourceLocation(SlayersBeasts.MOD_ID, "end"), RegionType.NETHER, weight);
	}
// TODO: Add EnderBlender RegionType
	public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
		VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();

		new ParameterPointListBuilder()
				.temperature(Temperature.WARM)
				.humidity(Humidity.FULL_RANGE)
				.continentalness(Continentalness.FULL_RANGE)
				.erosion(Erosion.FULL_RANGE)
				.weirdness(Weirdness.FULL_RANGE)
				.depth(Depth.FULL_RANGE)
				.build().forEach(point -> builder.add(point, SBBiomes.END_SPIKES));

		builder.build().forEach(mapper);
	}
}
