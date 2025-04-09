package net.invictusslayer.slayersbeasts.world.feature.tree.decorator;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.invictusslayer.slayersbeasts.init.SBTreeDecorators;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

import java.util.ArrayList;
import java.util.List;

public class ButtressRootDecorator extends TreeDecorator {
	public static final MapCodec<ButtressRootDecorator> CODEC = RecordCodecBuilder.mapCodec(instance ->
			instance.group(BlockStateProvider.CODEC.fieldOf("log_provider").forGetter(decorator -> decorator.logProvider),
							BlockStateProvider.CODEC.fieldOf("dirt_provider").forGetter(decorator -> decorator.dirtProvider))
					.apply(instance, ButtressRootDecorator::new));
	private final BlockStateProvider logProvider;
	private final BlockStateProvider dirtProvider;

	public ButtressRootDecorator(BlockStateProvider logProvider, BlockStateProvider dirtProvider) {
		this.logProvider = logProvider;
		this.dirtProvider = dirtProvider;
	}

	protected TreeDecoratorType<?> type() {
		return SBTreeDecorators.BUTTRESS_ROOT.get();
	}

	public void place(Context pContext) {
		List<BlockPos> list = pContext.logs();
		BlockPos basePos = list.get(0);

		for (BlockPos pPos : list.stream().toList()) {
			if (basePos.getX() > pPos.getX()) {
				basePos = new BlockPos(pPos.getX(), basePos.getY(), basePos.getZ());
			}
			if (basePos.getY() > pPos.getY()) {
				basePos = new BlockPos(basePos.getX(), pPos.getY(), basePos.getZ());
			}
			if (basePos.getZ() > pPos.getZ()) {
				basePos = new BlockPos(basePos.getX(), basePos.getY(), pPos.getZ());
			}
		}

		BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

		placeRoot(pContext, pContext.random(), mutablePos, basePos, Direction.NORTH);
		placeRoot(pContext, pContext.random(), mutablePos, basePos, Direction.SOUTH);
		placeRoot(pContext, pContext.random(), mutablePos, basePos, Direction.WEST);
		placeRoot(pContext, pContext.random(), mutablePos, basePos, Direction.EAST);
	}

	private void placeRoot(Context pContext, RandomSource pRandom, BlockPos.MutableBlockPos pMutablePos, BlockPos pBasePos, Direction pDirection) {
		List<BlockPos> posList = new ArrayList<>();
		posList.add(new BlockPos(-1, 0, -1));
		posList.add(new BlockPos(-1, 1, -1));
		posList.add(new BlockPos(-2, 0, -2));

		int x = pRandom.nextBoolean() ? 0 : 1;
		for (int z = -1; z >= -5; z--) {
			int h;
			if (z == -1) {
				h = 4;
			} else if (z > -4) {
				h = z + 4;
				if (pRandom.nextBoolean()) {
					posList.add(new BlockPos(pRandom.nextBoolean() ? x + 1 : x - 1, 0, z));
				}
			} else {
				h = 0;
			}

			for (int y = 0; y <= h; y++) {
				posList.add(new BlockPos(x, y, z));
			}

			x = pRandom.nextBoolean() ? x : pRandom.nextBoolean() ? x + 1 : x - 1;
		}

		if (pDirection == Direction.NORTH) {
			for (BlockPos pos : posList) {
				placeLog(pContext, pMutablePos.setWithOffset(pBasePos, pos));
				placeDirt(pContext, pMutablePos.setWithOffset(pBasePos, pos.getX(), -1, pos.getZ()));
			}
		} else if (pDirection == Direction.SOUTH) {
			for (BlockPos pos : posList) {
				placeLog(pContext, pMutablePos.setWithOffset(pBasePos, -pos.getX() + 1, pos.getY(), -pos.getZ() + 1));
				placeDirt(pContext, pMutablePos.setWithOffset(pBasePos, -pos.getX() + 1, -1, -pos.getZ() + 1));
			}
		} else if (pDirection == Direction.WEST) {
			for (BlockPos pos : posList) {
				placeLog(pContext, pMutablePos.setWithOffset(pBasePos, pos.getZ(), pos.getY(), -pos.getX() + 1));
				placeDirt(pContext, pMutablePos.setWithOffset(pBasePos, pos.getZ(), -1, -pos.getX() + 1));
			}
		} else if (pDirection == Direction.EAST) {
			for (BlockPos pos : posList) {
				placeLog(pContext, pMutablePos.setWithOffset(pBasePos, -pos.getZ() + 1, pos.getY(), pos.getX()));
				placeDirt(pContext, pMutablePos.setWithOffset(pBasePos, -pos.getZ() + 1, -1, pos.getX()));
			}
		}
	}

	private void placeLog(Context pContext, BlockPos pPos) {
		if (TreeFeature.validTreePos(pContext.level(), pPos)) {
			pContext.setBlock(pPos, logProvider.getState(pContext.random(), pPos));
		}
	}

	private void placeDirt(Context pContext, BlockPos pPos) {
		if (TreeFeature.validTreePos(pContext.level(), pPos)) {
			pContext.setBlock(pPos, dirtProvider.getState(pContext.random(), pPos));
		}
	}
}
