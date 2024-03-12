package net.invictusslayer.slayersbeasts.common.world.feature.misc;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class AntMoundFeature extends Feature<AntMoundFeature.Configuration> {
	public AntMoundFeature(Codec<Configuration> codec) {
		super(codec);
	}

	public boolean place(FeaturePlaceContext<Configuration> context) {
		WorldGenLevel level = context.level();
		BlockPos origin = context.origin();
		RandomSource random = context.random();
		Configuration config = context.config();

		BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
		BlockState mound = config.mound.getState(random, origin);
		BlockState anthill = config.anthill.getState(random, origin);
		int radius = config.radius.sample(random);
		int height = config.height.sample(random);
		int r2 = radius * radius;
		int h2 = height * height;

		for (int y = -height; y <= height; y++) {
			int y2 = y * y;
			for (int x = -radius; x <= radius; x++) {
				int x2 = x * x;
				for (int z = -radius; z <= radius; z++) {
					int z2 = z * z;
					if (x2 + z2 + (y2 * r2 / h2) > r2) continue;
					mutableBlockPos.setWithOffset(origin, x, y, z);

					if (level.getBlockState(mutableBlockPos).isAir()) {
						level.setBlock(mutableBlockPos, mound, 4);
					}
				}
			}
		}

		return false;
	}

	public record Configuration(BlockStateProvider mound, BlockStateProvider anthill, IntProvider radius, IntProvider height) implements FeatureConfiguration {
		public static final Codec<Configuration> CODEC = RecordCodecBuilder.create(instance -> instance.group(
				BlockStateProvider.CODEC.fieldOf("mound").forGetter(Configuration::mound),
				BlockStateProvider.CODEC.fieldOf("anthill").forGetter(Configuration::anthill),
				IntProvider.CODEC.fieldOf("radius").forGetter(Configuration::radius),
				IntProvider.CODEC.fieldOf("height").forGetter(Configuration::height)
		).apply(instance, Configuration::new));
	}
}
