package net.invictusslayer.slayersbeasts.world.feature.tree;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class MediumMushroomFeature extends Feature<MediumMushroomFeature.Configuration> {
	public MediumMushroomFeature(Codec<Configuration> pCodec) {
		super(pCodec);
	}

	public boolean place(FeaturePlaceContext<Configuration> context) {
		WorldGenLevel level = context.level();
		BlockPos origin = context.origin();
		RandomSource random = context.random();
		Configuration config = context.config();

		int radius = config.radius.sample(random);
		BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();

		if (!isValidPosition(level, origin, radius * 2, mutableBlockPos, radius - 1)) return false;

		for (int y = 0; y < radius; ++y) {
			for (int x = 1 - radius; x < radius; ++x) {
				for (int z = 1 - radius; z < radius; ++z) {
					mutableBlockPos.setWithOffset(origin, x, y + radius, z);
					boolean north = z < 0;
					boolean south = z > 0;
					boolean east = x > 0;
					boolean west = x < 0;

					if (!level.getBlockState(mutableBlockPos).isSolidRender(level, mutableBlockPos)) {
						setBlock(level, mutableBlockPos, config.capProvider.getState(random, origin).setValue(HugeMushroomBlock.DOWN, false));
					}
				}
			}
			mutableBlockPos.set(origin).move(Direction.UP, y);

			if (!level.getBlockState(mutableBlockPos).isSolidRender(level, mutableBlockPos)) {
				setBlock(level, mutableBlockPos, config.stemProvider.getState(random, origin).setValue(HugeMushroomBlock.UP, false).setValue(HugeMushroomBlock.DOWN, false));
			}
		}

		return true;
	}

	private boolean isValidPosition(LevelAccessor level, BlockPos pos, int height, BlockPos.MutableBlockPos mutableBlockPos, int radius) {
		int i = pos.getY();
		if (i >= level.getMinBuildHeight() + 1 && i + height + 1 < level.getMaxBuildHeight()) {
			BlockState below = level.getBlockState(pos.below());
			if (!isDirt(below) && !below.is(BlockTags.MUSHROOM_GROW_BLOCK)) return false;

			for (int y = 0; y <= height; ++y) {
				for (int x = -radius; x <= radius; ++x) {
					for (int z = -radius; z <= radius; ++z) {
						BlockState state = level.getBlockState(mutableBlockPos.setWithOffset(pos, x, y, z));
						if (!state.isAir() && !state.is(BlockTags.LEAVES)) {
							return false;
						}
					}
				}
			}
			return true;
		}
		return false;
	}

	public record Configuration(IntProvider radius, BlockStateProvider capProvider, BlockStateProvider stemProvider) implements FeatureConfiguration {
		public static final Codec<Configuration> CODEC = RecordCodecBuilder.create(instance ->
				instance.group(IntProvider.CODEC.fieldOf("radius").forGetter(Configuration::radius),
								BlockStateProvider.CODEC.fieldOf("cap_provider").forGetter(Configuration::capProvider),
								BlockStateProvider.CODEC.fieldOf("stem_provider").forGetter(Configuration::stemProvider))
						.apply(instance, Configuration::new));
	}
}
