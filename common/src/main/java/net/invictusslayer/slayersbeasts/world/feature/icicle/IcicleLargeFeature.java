package net.invictusslayer.slayersbeasts.world.feature.icicle;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.invictusslayer.slayersbeasts.data.tag.SBTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Column;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.phys.Vec3;

import java.util.Optional;

public class IcicleLargeFeature extends Feature<IcicleLargeFeature.Configuration> {
	public IcicleLargeFeature(Codec<Configuration> codec) {
		super(codec);
	}

	public boolean place(FeaturePlaceContext<Configuration> context) {
		WorldGenLevel level = context.level();
		BlockPos origin = context.origin();
		Configuration config = context.config();
		RandomSource random = context.random();

		if (!IcicleUtils.isEmptyOrWater(level, origin)) return false;

		Optional<Column> optional = Column.scan(level, origin, config.caveHeightSearchRange, IcicleUtils::isEmptyOrWater, IcicleUtils::isIcicleBaseOrLava);
		if (optional.isPresent() && optional.get() instanceof Column.Range range) {
			if (range.height() < 4) return false;

			int max = Mth.clamp((int) ((float) range.height() * config.maxRadiusHeightRatio), config.columnRadius.getMinValue(), config.columnRadius.getMaxValue());
			int radius = Mth.randomBetweenInclusive(random, config.columnRadius.getMinValue(), max);
			LargeIcicle topIcicle = makeIcicle(origin.atY(range.ceiling() - 1), false, random, radius, config.topBluntness, config.heightScale);
			LargeIcicle bottomIcicle = makeIcicle(origin.atY(range.floor() + 1), true, random, radius, config.bottomBluntness, config.heightScale);
			WindOffsetter offsetter;
			if (topIcicle.isSuitableForWind(config) && bottomIcicle.isSuitableForWind(config)) {
				offsetter = new WindOffsetter(origin.getY(), random, config.windSpeed);
			} else {
				offsetter = new WindOffsetter();
			}

			boolean flag = topIcicle.alignBaseAndShrinkRadius(level, offsetter);
			boolean flag1 = bottomIcicle.alignBaseAndShrinkRadius(level, offsetter);
			if (flag) {
				topIcicle.placeBlocks(level, random, offsetter);
			}

			if (flag1) {
				bottomIcicle.placeBlocks(level, random, offsetter);
			}

			return true;

		} else {
			return false;
		}
	}

	private static LargeIcicle makeIcicle(BlockPos origin, boolean pointingUp, RandomSource random, int radius, FloatProvider baseBluntness, FloatProvider baseScale) {
		return new LargeIcicle(origin, pointingUp, radius, baseBluntness.sample(random), baseScale.sample(random));
	}
	
	private static final class LargeIcicle {
		private BlockPos origin;
		private final boolean pointingUp;
		private int radius;
		private final double bluntness;
		private final double scale;

		LargeIcicle(BlockPos origin, boolean pointingUp, int radius, double bluntness, double scale) {
			this.origin = origin;
			this.pointingUp = pointingUp;
			this.radius = radius;
			this.bluntness = bluntness;
			this.scale = scale;
		}

		private boolean alignBaseAndShrinkRadius(WorldGenLevel level, WindOffsetter offsetter) {
			while (radius > 1) {
				BlockPos.MutableBlockPos mutableBlockPos = origin.mutable();
				int i = Math.min(10, getHeightAtRadius(0.0F));

				for (int j = 0; j < i; ++j) {
					if (level.getBlockState(mutableBlockPos).is(Blocks.LAVA)) {
						return false;
					}
					if (IcicleUtils.isBaseEmbeddedInStone(level, offsetter.offset(mutableBlockPos), radius)) {
						origin = mutableBlockPos;
						return true;
					}
					mutableBlockPos.move(pointingUp ? Direction.DOWN : Direction.UP);
				}

				radius /= 2;
			}
			return false;
		}

		private int getHeightAtRadius(float radius) {
			return (int) IcicleUtils.getIcicleHeight(radius, this.radius, scale, bluntness);
		}

		private void placeBlocks(WorldGenLevel level, RandomSource random, WindOffsetter offsetter) {
			for (int x = -radius; x <= radius; ++x) {
				for (int z = -radius; z <= radius; ++z) {
					float f = Mth.sqrt(x * x + z * z);
					if (f <= radius) {
						int k = getHeightAtRadius(f);
						if (k > 0) {
							if (random.nextDouble() < 0.2D) {
								k = (int) (k * Mth.randomBetween(random, 0.8F, 1.0F));
							}

							BlockPos.MutableBlockPos mutableBlockPos = origin.offset(x, 0, z).mutable();
							boolean flag = false;
							int l = pointingUp ? level.getHeight(Heightmap.Types.WORLD_SURFACE_WG, mutableBlockPos.getX(), mutableBlockPos.getZ()) : Integer.MAX_VALUE;

							for (int i1 = 0; i1 < k && mutableBlockPos.getY() < l; ++i1) {
								BlockPos blockPos = offsetter.offset(mutableBlockPos);
								if (IcicleUtils.isEmptyOrWaterOrLava(level, blockPos)) {
									flag = true;
									level.setBlock(blockPos, Blocks.PACKED_ICE.defaultBlockState(), 2);
								} else if (flag && level.getBlockState(blockPos).is(SBTags.Blocks.ICICLE_REPLACEABLE)) {
									break;
								}

								mutableBlockPos.move(pointingUp ? Direction.UP : Direction.DOWN);
							}
						}
					}
				}
			}
		}

		boolean isSuitableForWind(Configuration config) {
			return radius >= config.minWindRadius && bluntness >= (double) config.minWindBluntness;
		}
	}

	private static final class WindOffsetter {
		private final int originY;
		private final Vec3 windSpeed;

		private WindOffsetter(int originY, RandomSource random, FloatProvider magnitude) {
			this.originY = originY;
			float f = magnitude.sample(random);
			float f1 = Mth.randomBetween(random, 0.0F, Mth.PI);
			windSpeed = new Vec3(Mth.cos(f1) * f, 0.0D, Mth.sin(f1) * f);
		}

		private WindOffsetter() {
			originY = 0;
			windSpeed = null;
		}

		BlockPos offset(BlockPos pos) {
			if (windSpeed == null) {
				return pos;
			} else {
				int i = originY - pos.getY();
				Vec3 vec3 = windSpeed.scale(i);
				return pos.offset(Mth.floor(vec3.x), 0, Mth.floor(vec3.z));
			}
		}
	}

	public record Configuration(int caveHeightSearchRange, IntProvider columnRadius, FloatProvider heightScale, float maxRadiusHeightRatio, FloatProvider topBluntness, FloatProvider bottomBluntness, FloatProvider windSpeed, int minWindRadius, float minWindBluntness) implements FeatureConfiguration {
		public static final Codec<Configuration> CODEC = RecordCodecBuilder.create(instance -> instance.group(
				Codec.intRange(1, 512).fieldOf("cave_height_search_range").forGetter(Configuration::caveHeightSearchRange),
				IntProvider.codec(1, 60).fieldOf("column_radius").forGetter(Configuration::columnRadius),
				FloatProvider.codec(0.0F, 20.0F).fieldOf("height_scale").forGetter(Configuration::heightScale),
				Codec.floatRange(0.1F, 1.0F).fieldOf("max_radius_height_ratio").forGetter(Configuration::maxRadiusHeightRatio),
				FloatProvider.codec(0.1F, 10.0F).fieldOf("top_bluntness").forGetter(Configuration::topBluntness),
				FloatProvider.codec(0.1F, 10.0F).fieldOf("bottom_bluntness").forGetter(Configuration::bottomBluntness),
				FloatProvider.codec(0.0F, 2.0F).fieldOf("wind_speed").forGetter(Configuration::windSpeed),
				Codec.intRange(0, 100).fieldOf("min_wind_radius").forGetter(Configuration::minWindRadius),
				Codec.floatRange(0.0F, 5.0F).fieldOf("min_wind_bluntness").forGetter(Configuration::minWindBluntness)
		).apply(instance, Configuration::new));
	}
}
