package net.invictusslayer.slayersbeasts.common.world.feature.tree.trunk;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.invictusslayer.slayersbeasts.common.init.SBTrunkPlacers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;

public class ColossalTrunkPlacer extends TrunkPlacer {
	public static final MapCodec<ColossalTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(instance ->
			instance.group(Codec.intRange(0, 60).fieldOf("base_height").forGetter(placer -> placer.baseHeight),
							Codec.intRange(0, 24).fieldOf("height_rand_a").forGetter(placer -> placer.heightRandA),
							Codec.intRange(0, 24).fieldOf("height_rand_b").forGetter(placer -> placer.heightRandB))
					.apply(instance, ColossalTrunkPlacer::new));
	protected final int baseHeight;
	protected final int heightRandA;
	protected final int heightRandB;

	public ColossalTrunkPlacer(int baseHeight, int heightRandA, int heightRandB) {
		super(baseHeight, heightRandA, heightRandB);
		this.baseHeight = baseHeight;
		this.heightRandA = heightRandA;
		this.heightRandB = heightRandB;
	}

	protected TrunkPlacerType<?> type() {
		return SBTrunkPlacers.COLOSSAL_TRUNK_PLACER.get();
	}

	public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> blockSetter, RandomSource random, int freeTreeHeight, BlockPos pos, TreeConfiguration config) {
		for (int i = 1; i <= 2; i++) {
			BlockPos dirtPos = pos.relative(Direction.DOWN, i);
			setDirtAt(level, blockSetter, random, dirtPos, config);
			setDirtAt(level, blockSetter, random, dirtPos.east(), config);
			setDirtAt(level, blockSetter, random, dirtPos.east().east(), config);
			setDirtAt(level, blockSetter, random, dirtPos.south(), config);
			setDirtAt(level, blockSetter, random, dirtPos.south().east(), config);
			setDirtAt(level, blockSetter, random, dirtPos.south().east().east(), config);
			setDirtAt(level, blockSetter, random, dirtPos.south().south(), config);
			setDirtAt(level, blockSetter, random, dirtPos.south().south().east(), config);
			setDirtAt(level, blockSetter, random, dirtPos.south().south().east().east(), config);
			setDirtAt(level, blockSetter, random, dirtPos.south().west(), config);
			setDirtAt(level, blockSetter, random, dirtPos.north().east(), config);
			setDirtAt(level, blockSetter, random, dirtPos.south().south().south().east(), config);
			setDirtAt(level, blockSetter, random, dirtPos.south().east().east().east(), config);
		}
		BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();

		int root = 3 + random.nextInt(5);
		int base = root + 4 + random.nextInt(5);
		int top = 3 + random.nextInt(3);
		for (int i = 0; i < freeTreeHeight; ++i) {
			if (i < root) {
				placeLogIfFreeWithOffset(level, blockSetter, random, mutableBlockPos, config, pos, 1, i, -1);
				placeLogIfFreeWithOffset(level, blockSetter, random, mutableBlockPos, config, pos, -1, i, 1);
				placeLogIfFreeWithOffset(level, blockSetter, random, mutableBlockPos, config, pos, 1, i, 3);
				placeLogIfFreeWithOffset(level, blockSetter, random, mutableBlockPos, config, pos, 3, i, 1);
			}
			if (i < base) {
				placeLogIfFreeWithOffset(level, blockSetter, random, mutableBlockPos, config, pos, 0, i, 0);
				placeLogIfFreeWithOffset(level, blockSetter, random, mutableBlockPos, config, pos, 2, i, 0);
				placeLogIfFreeWithOffset(level, blockSetter, random, mutableBlockPos, config, pos, 0, i, 2);
				placeLogIfFreeWithOffset(level, blockSetter, random, mutableBlockPos, config, pos, 2, i, 2);
			}
			if (i < freeTreeHeight - top) {
				placeLogIfFreeWithOffset(level, blockSetter, random, mutableBlockPos, config, pos, 1, i, 0);
				placeLogIfFreeWithOffset(level, blockSetter, random, mutableBlockPos, config, pos, 0, i, 1);
				placeLogIfFreeWithOffset(level, blockSetter, random, mutableBlockPos, config, pos, 2, i, 1);
				placeLogIfFreeWithOffset(level, blockSetter, random, mutableBlockPos, config, pos, 1, i, 2);
			}
			placeLogIfFreeWithOffset(level, blockSetter, random, mutableBlockPos, config, pos, 1, i, 1);
		}

		return ImmutableList.of(new FoliagePlacer.FoliageAttachment(pos.above(freeTreeHeight).south().east(), 0, false));
	}

	private void placeLogIfFreeWithOffset(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> blockSetter, RandomSource random, BlockPos.MutableBlockPos pos, TreeConfiguration config, BlockPos origin, int x, int y, int z) {
		pos.setWithOffset(origin, x, y, z);
		this.placeLogIfFree(level, blockSetter, random, pos, config);
	}
}