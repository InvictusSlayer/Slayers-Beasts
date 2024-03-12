package net.invictusslayer.slayersbeasts.common.world.feature.tree.decorator;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.invictusslayer.slayersbeasts.common.init.SBTreeDecorators;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

public class HangingBranchDecorator extends TreeDecorator {
	public static final Codec<HangingBranchDecorator> CODEC = RecordCodecBuilder.create(instance ->
			instance.group(Codec.floatRange(0.0F, 1.0F).fieldOf("probability").forGetter(decorator -> decorator.probability),
							BlockStateProvider.CODEC.fieldOf("head_provider").forGetter(decorator -> decorator.headProvider),
							BlockStateProvider.CODEC.fieldOf("body_provider").forGetter(decorator -> decorator.bodyProvider))
					.apply(instance, HangingBranchDecorator::new));
	private final float probability;
	private final BlockStateProvider headProvider;
	private final BlockStateProvider bodyProvider;

	public HangingBranchDecorator(float probability, BlockStateProvider headProvider, BlockStateProvider bodyProvider) {
		this.probability = probability;
		this.headProvider = headProvider;
		this.bodyProvider = bodyProvider;
	}

	protected TreeDecoratorType<?> type() {
		return SBTreeDecorators.HANGING_BRANCH.get();
	}

	public void place(Context pContext) {
		for (BlockPos leafPos : Util.shuffledCopy(pContext.leaves(), pContext.random())) {
			BlockPos branchPos = leafPos.relative(Direction.DOWN);
			int height = pContext.random().nextInt(1, 6);
			if (pContext.isAir(branchPos) && pContext.random().nextFloat() < this.probability) {
				placeBranchColumn(pContext, branchPos, height);
			}
		}
	}

	private void placeBranchColumn(Context pContext, BlockPos pPos, int pHeight) {
		for (int i = 0; i < pHeight; ++i) {
			BlockPos blockPos = pPos.relative(Direction.DOWN, i);
			if (!pContext.isAir(blockPos.below())) {
				pContext.setBlock(blockPos, headProvider.getState(pContext.random(), blockPos));
				break;
			}
			pContext.setBlock(blockPos, bodyProvider.getState(pContext.random(), blockPos));
		}
	}
}
