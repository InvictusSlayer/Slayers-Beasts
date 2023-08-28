package net.invictusslayer.slayersbeasts.world.feature.misc;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

import java.util.Optional;

public class IcicleSmallFeature extends Feature<IcicleSmallFeature.Configuration> {
	public IcicleSmallFeature(Codec<Configuration> pCodec) {
		super(pCodec);
	}

	public boolean place(FeaturePlaceContext<Configuration> context) {
		LevelAccessor level = context.level();
		BlockPos origin = context.origin();
		RandomSource random = context.random();
		Configuration config = context.config();
		Optional<Direction> optional = getTipDirection(level, origin, random);
		if (optional.isEmpty()) {
			return false;
		} else {
			BlockPos blockPos = origin.relative(optional.get().getOpposite());
			createPatchOfIcicleBlocks(level, random, blockPos, config);
			int i = random.nextFloat() < config.tallerIcicleChance && IcicleUtils.isEmptyOrWater(level.getBlockState(origin.relative(optional.get()))) ? 2 : 1;
			IcicleUtils.growIcicle(level, origin, optional.get(), i, false);
			return true;
		}
	}

	private static Optional<Direction> getTipDirection(LevelAccessor level, BlockPos pos, RandomSource random) {
		boolean isDown = IcicleUtils.isIcicleBase(level.getBlockState(pos.above()));
		boolean isUp = IcicleUtils.isIcicleBase(level.getBlockState(pos.below()));
		if (isDown && isUp) {
			return Optional.of(random.nextBoolean() ? Direction.DOWN : Direction.UP);
		} else if (isDown) {
			return Optional.of(Direction.DOWN);
		} else if (isUp) {
			return Optional.of(Direction.UP);
		} else {
			return Optional.empty();
		}
	}

	private static void createPatchOfIcicleBlocks(LevelAccessor level, RandomSource random, BlockPos pos, Configuration config) {
		IcicleUtils.placeIceIfPossible(level, pos);

		for (Direction direction : Direction.Plane.HORIZONTAL) {
			if (random.nextFloat() < config.radialSpreadChance) {
				BlockPos blockPos = pos.relative(direction);
				IcicleUtils.placeIceIfPossible(level, blockPos);
				if (random.nextFloat() < config.radialSpreadChance2) {
					BlockPos blockPos1 = blockPos.relative(Direction.getRandom(random));
					IcicleUtils.placeIceIfPossible(level, blockPos1);
					if (random.nextFloat() < config.radialSpreadChance3) {
						BlockPos blockPos2 = blockPos1.relative(Direction.getRandom(random));
						IcicleUtils.placeIceIfPossible(level, blockPos2);
					}
				}
			}
		}

	}

	public record Configuration(float tallerIcicleChance, float radialSpreadChance, float radialSpreadChance2, float radialSpreadChance3) implements FeatureConfiguration {
		public static final Codec<Configuration> CODEC = RecordCodecBuilder.create(instance ->
				instance.group(Codec.floatRange(0.0F, 1.0F).fieldOf("taller_icicle_chance").forGetter(Configuration::tallerIcicleChance),
								Codec.floatRange(0.0F, 1.0F).fieldOf("radial_spread_chance").forGetter(Configuration::radialSpreadChance),
								Codec.floatRange(0.0F, 1.0F).fieldOf("radial_spread_chance2").forGetter(Configuration::radialSpreadChance2),
								Codec.floatRange(0.0F, 1.0F).fieldOf("radial_spread_chance3").forGetter(Configuration::radialSpreadChance3))
						.apply(instance, Configuration::new));
	}
}
