package net.invictusslayer.slayersbeasts.world.feature.icicle;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.invictusslayer.slayersbeasts.data.tag.SBTags;
import net.invictusslayer.slayersbeasts.init.SBBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.ClampedNormalFloat;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Column;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

import java.util.Optional;
import java.util.OptionalInt;

public class IcicleClusterFeature extends Feature<IcicleClusterFeature.Configuration> {
	public IcicleClusterFeature(Codec<Configuration> codec) {
		super(codec);
	}

	public boolean place(FeaturePlaceContext<Configuration> context) {
		WorldGenLevel level = context.level();
		BlockPos origin = context.origin();
		Configuration config = context.config();
		RandomSource random = context.random();

		if (!IcicleUtils.isEmptyOrWater(level, origin)) return false;

		int height = config.height.sample(random);
		float lightChance = config.lightChance.sample(random);
		float density = config.density.sample(random);
		int xRadius = config.radius.sample(random);
		int zRadius = config.radius.sample(random);

		for (int x = -xRadius; x <= xRadius; ++x) {
			for (int z = -zRadius; z <= zRadius; ++z) {
				BlockPos blockPos = origin.offset(x, 0, z);
				double chance = getChanceOfIcicle(xRadius, zRadius, x, z, config);
				placeColumn(level, random, blockPos, x, z, lightChance, chance, height, density, config);
			}
		}
		return true;
	}

	private void placeColumn(WorldGenLevel level, RandomSource random, BlockPos pos, int x, int z, float lightChance, double chance, int height, float density, Configuration config) {
		Optional<Column> optional = Column.scan(level, pos, config.caveHeightSearchRange, IcicleUtils::isEmptyOrWater, IcicleUtils::isNeitherEmptyNorWater);
		if (optional.isPresent()) {
			OptionalInt ceiling = optional.get().getCeiling();
			OptionalInt floor = optional.get().getFloor();
			if (ceiling.isPresent() || floor.isPresent()) {
				Column column = optional.get();

				if (random.nextFloat() < lightChance && floor.isPresent() && canPlaceLight(level, pos.atY(floor.getAsInt()))) {
					level.setBlock(pos.atY(floor.getAsInt()), SBBlocks.GLEAMING_ICE.get().defaultBlockState(), 2);
				}

				OptionalInt columnFloor = column.getFloor();
				int j = 0;
				if (ceiling.isPresent() && random.nextDouble() < chance && notLava(level, pos.atY(ceiling.getAsInt()))) {
					int k = config.layerThickness.sample(random);
					replaceBlocksWithIce(level, pos.atY(ceiling.getAsInt()), k, Direction.UP);
					int l;
					if (columnFloor.isPresent()) {
						l = Math.min(height, ceiling.getAsInt() - columnFloor.getAsInt());
					} else {
						l = height;
					}

					j = getIcicleHeight(random, x, z, density, l, config);
				}

				int i3;
				if (columnFloor.isPresent() && random.nextDouble() < chance && notLava(level, pos.atY(columnFloor.getAsInt()))) {
					int i1 = config.layerThickness.sample(random);
					this.replaceBlocksWithIce(level, pos.atY(columnFloor.getAsInt()), i1, Direction.DOWN);
					if (ceiling.isPresent()) {
						i3 = Math.max(0, j + Mth.randomBetweenInclusive(random, -config.maxHeightDifference, config.maxHeightDifference));
					} else {
						i3 = getIcicleHeight(random, x, z, density, height, config);
					}
				} else {
					i3 = 0;
				}

				int j1;
				int j3;
				if (ceiling.isPresent() && columnFloor.isPresent() && ceiling.getAsInt() - j <= columnFloor.getAsInt() + i3) {
					int k1 = columnFloor.getAsInt();
					int l1 = ceiling.getAsInt();
					int i2 = Math.max(l1 - j, k1 + 1);
					int j2 = Math.min(k1 + i3, l1 - 1);
					int k2 = Mth.randomBetweenInclusive(random, i2, j2 + 1);
					int l2 = k2 - 1;
					j3 = l1 - k2;
					j1 = l2 - k1;
				} else {
					j3 = j;
					j1 = i3;
				}

				boolean flag3 = random.nextBoolean() && j3 > 0 && j1 > 0 && column.getHeight().isPresent() && j3 + j1 == column.getHeight().getAsInt();
				if (ceiling.isPresent()) {
					IcicleUtils.growIcicle(level, pos.atY(ceiling.getAsInt() - 1), Direction.DOWN, j3, flag3);
				}

				if (columnFloor.isPresent()) {
					IcicleUtils.growIcicle(level, pos.atY(columnFloor.getAsInt() + 1), Direction.UP, j1, flag3);
				}

			}
		}
	}

	private boolean notLava(LevelReader level, BlockPos pos) {
		return !level.getBlockState(pos).is(Blocks.LAVA);
	}

	private int getIcicleHeight(RandomSource random, int x, int z, float chance, int height, Configuration config) {
		if (random.nextFloat() > chance) return 0;

		int i = Math.abs(x) + Math.abs(z);
		float mean = (float) Mth.clampedMap(i, 0.0D, config.maxRadiusAffectingHeightBias, height / 2.0D, 0.0D);
		return (int) ClampedNormalFloat.sample(random, mean, config.heightDeviation, 0, (float) height);
	}

	private boolean canPlaceLight(WorldGenLevel level, BlockPos pos) {
		BlockState state = level.getBlockState(pos);
		if (state.is(Blocks.WATER) || state.is(Blocks.PACKED_ICE) || state.is(SBBlocks.ICICLE.get())) return false;
		if (level.getBlockState(pos.above()).getFluidState().is(FluidTags.WATER)) return false;

		for (Direction direction : Direction.Plane.HORIZONTAL) {
			if (!canBeAdjacentToWater(level, pos.relative(direction))) {
				return false;
			}
		}

		return canBeAdjacentToWater(level, pos.below());
	}

	private boolean canBeAdjacentToWater(LevelAccessor level, BlockPos pos) {
		BlockState state = level.getBlockState(pos);
		return state.is(SBTags.Blocks.ICICLE_REPLACEABLE) || state.getFluidState().is(FluidTags.WATER);
	}

	private void replaceBlocksWithIce(WorldGenLevel level, BlockPos pos, int thickness, Direction direction) {
		BlockPos.MutableBlockPos mutableBlockPos = pos.mutable();

		for(int i = 0; i < thickness; ++i) {
			if (!IcicleUtils.placeIceIfPossible(level, mutableBlockPos)) {
				return;
			}

			mutableBlockPos.move(direction);
		}
	}

	private double getChanceOfIcicle(int xRadius, int zRadius, int x, int z, Configuration config) {
		float i = Math.min(xRadius - Math.abs(x), zRadius - Math.abs(z));
		return Mth.clampedMap(i, 0.0F, (float) config.maxRadiusAffectingColumnChance, config.columnChanceAtMaxRadius, 1.0F);
	}

	public record Configuration(int caveHeightSearchRange, IntProvider height, IntProvider radius, int maxHeightDifference, int heightDeviation, IntProvider layerThickness, FloatProvider density, FloatProvider lightChance, float columnChanceAtMaxRadius, int maxRadiusAffectingColumnChance, int maxRadiusAffectingHeightBias) implements FeatureConfiguration {
		public static final Codec<Configuration> CODEC = RecordCodecBuilder.create(instance -> instance.group(
				Codec.intRange(1, 512).fieldOf("cave_height_search_range").forGetter(Configuration::caveHeightSearchRange),
				IntProvider.codec(1, 128).fieldOf("height").forGetter(Configuration::height),
				IntProvider.codec(1, 128).fieldOf("radius").forGetter(Configuration::radius),
				Codec.intRange(0, 64).fieldOf("max_height_difference").forGetter(Configuration::maxHeightDifference),
				Codec.intRange(1, 64).fieldOf("height_deviation").forGetter(Configuration::heightDeviation),
				IntProvider.codec(0, 128).fieldOf("layer_thickness").forGetter(Configuration::layerThickness),
				FloatProvider.codec(0.0F, 2.0F).fieldOf("density").forGetter(Configuration::density),
				FloatProvider.codec(0.0F, 2.0F).fieldOf("light_chance").forGetter(Configuration::lightChance),
				Codec.floatRange(0.0F, 1.0F).fieldOf("column_chance_at_max_radius").forGetter(Configuration::columnChanceAtMaxRadius),
				Codec.intRange(1, 64).fieldOf("max_radius_affecting_column_chance").forGetter(Configuration::maxRadiusAffectingColumnChance),
				Codec.intRange(1, 64).fieldOf("max_radius_affecting_height_bias").forGetter(Configuration::maxRadiusAffectingHeightBias)
		).apply(instance, Configuration::new));
	}
}
