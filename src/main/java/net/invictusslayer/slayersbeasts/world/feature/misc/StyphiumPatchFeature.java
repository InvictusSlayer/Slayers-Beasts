package net.invictusslayer.slayersbeasts.world.feature.misc;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.invictusslayer.slayersbeasts.block.SBBlocks;
import net.invictusslayer.slayersbeasts.datagen.tags.SBTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class StyphiumPatchFeature extends Feature<StyphiumPatchFeature.Configuration> {
	public StyphiumPatchFeature(Codec<Configuration> pCodec) {
		super(pCodec);
	}

	public boolean place(FeaturePlaceContext<Configuration> context) {
		WorldGenLevel level = context.level();
		Configuration config = context.config();
		RandomSource random = context.random();
		BlockPos origin = context.origin();

		Predicate<BlockState> stateCheck = state -> state.is(SBTags.Blocks.STYPHIUM_REPLACEABLE);

		Set<BlockPos> set = placeGround(level, config, random, origin, stateCheck);
		placeVegetation(context, level, config, random, set);
		return !set.isEmpty();
	}

	private Set<BlockPos> placeGround(WorldGenLevel level, Configuration config, RandomSource random, BlockPos pos, Predicate<BlockState> stoneTest) {
		BlockPos.MutableBlockPos mutableBlockPos = pos.mutable();
		Set<BlockPos> set = new HashSet<>();
		int xRad = config.xzRadius.sample(random) + 1;
		int zRad = config.xzRadius.sample(random) + 1;

		for (int x = -xRad; x <= xRad; ++x) {
			boolean xEdge = x == -xRad || x == xRad;

			for (int z = -zRad; z <= zRad; ++z) {
				boolean zEdge = z == -zRad || z == zRad;

				if (!(xEdge && zEdge) && (!(xEdge || zEdge) || config.edgeColumnChance != 0.0F && random.nextFloat() < config.edgeColumnChance)) {
					mutableBlockPos.setWithOffset(pos, x, 0, z);

					for (int y = 0; y < config.verticalRange; ++y) {
						if (level.isStateAtPosition(mutableBlockPos, BlockBehaviour.BlockStateBase::isAir)) {
							mutableBlockPos.move(Direction.DOWN);
						} else if (level.isStateAtPosition(mutableBlockPos, stoneTest)) {
							mutableBlockPos.move(Direction.UP);
							break;
						}
					}

					BlockPos.MutableBlockPos mutableBlockPos1 = mutableBlockPos.offset(0, -1, 0).mutable();
					if (level.isEmptyBlock(mutableBlockPos) && level.getBlockState(mutableBlockPos1).isFaceSturdy(level, mutableBlockPos1, Direction.UP)) {
						if (placeStyphium(level, config, mutableBlockPos1)) {
							set.add(mutableBlockPos1.immutable());
						}
					}
				}
			}
		}

		return set;
	}

	private boolean placeStyphium(WorldGenLevel level, Configuration config, BlockPos.MutableBlockPos mutableBlockPos) {
		BlockState state = level.getBlockState(mutableBlockPos);

		if (state.is(Blocks.STONE)) {
			level.setBlock(mutableBlockPos, SBBlocks.STYPHIUM.get().defaultBlockState(), 2);
		} else if (state.is(Blocks.DEEPSLATE)) {
			level.setBlock(mutableBlockPos, SBBlocks.DEEPSLATE_STYPHIUM.get().defaultBlockState(), 2);
		} else if (state.is(SBTags.Blocks.STYPHIUM_REPLACEABLE) && config.isNatural) {
			level.setBlock(mutableBlockPos, state.is(BlockTags.BASE_STONE_OVERWORLD) ? SBBlocks.STYPHIUM.get().defaultBlockState() : Blocks.MYCELIUM.defaultBlockState(), 2);
		} else {
			return false;
		}

		return true;
	}

	private void placeVegetation(FeaturePlaceContext<Configuration> context, WorldGenLevel level, Configuration config, RandomSource random, Set<BlockPos> posList) {
		for (BlockPos pos : posList) {
			if (config.vegetationChance > 0.0F && random.nextFloat() < config.vegetationChance) {
				placeVegetation(level, config, context.chunkGenerator(), random, pos);
			}
		}
	}

	private void placeVegetation(WorldGenLevel level, Configuration config, ChunkGenerator chunkGen, RandomSource random, BlockPos pos) {
		config.vegetation.value().place(level, chunkGen, random, pos.above());
	}

	public record Configuration(Holder<PlacedFeature> vegetation, float vegetationChance, int verticalRange, IntProvider xzRadius, float edgeColumnChance, boolean isNatural) implements FeatureConfiguration {
		public static final Codec<Configuration> CODEC = RecordCodecBuilder.create(instance ->
				instance.group(PlacedFeature.CODEC.fieldOf("vegetation").forGetter(Configuration::vegetation),
						Codec.floatRange(0.0F, 1.0F).fieldOf("vegetation_chance").forGetter(Configuration::vegetationChance),
						Codec.intRange(1, 256).fieldOf("vertical_range").forGetter(Configuration::verticalRange),
						IntProvider.CODEC.fieldOf("xz_radius").forGetter(Configuration::xzRadius),
						Codec.floatRange(0.0F, 1.0F).fieldOf("edge_column_chance").forGetter(Configuration::edgeColumnChance),
						Codec.BOOL.fieldOf("isNatural").forGetter(Configuration::isNatural)
				).apply(instance, Configuration::new));
	}
}
