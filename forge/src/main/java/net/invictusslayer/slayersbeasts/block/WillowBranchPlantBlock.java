package net.invictusslayer.slayersbeasts.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WillowBranchPlantBlock extends GrowingPlantBodyBlock {
	public static final MapCodec<WillowBranchPlantBlock> CODEC = simpleCodec(WillowBranchPlantBlock::new);
	public static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

	protected WillowBranchPlantBlock(Properties properties) {
		super(properties, Direction.DOWN, SHAPE, false);
	}

	protected GrowingPlantHeadBlock getHeadBlock() {
		return (GrowingPlantHeadBlock) SBBlocks.WILLOW_BRANCH.get();
	}

	protected MapCodec<? extends GrowingPlantBodyBlock> codec() {
		return CODEC;
	}
}
