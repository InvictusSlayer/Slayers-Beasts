package net.invictusslayer.slayersbeasts.block;

import com.mojang.serialization.MapCodec;
import net.invictusslayer.slayersbeasts.block.entity.AnthillBlockEntity;
import net.invictusslayer.slayersbeasts.block.entity.AnthillHatcheryBlockEntity;
import net.invictusslayer.slayersbeasts.block.entity.SBBlockEntities;
import net.invictusslayer.slayersbeasts.entity.AntSoldier;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AnthillHatcheryBlock extends BaseEntityBlock {
	public static final MapCodec<AnthillHatcheryBlock> CODEC = simpleCodec(AnthillHatcheryBlock::new);
	public static final IntegerProperty LARVAL_STAGE = IntegerProperty.create("larval_stage", 0, 5);
	public static final IntegerProperty LARVA = IntegerProperty.create("larva", 0, 3);

	public AnthillHatcheryBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(LARVAL_STAGE, 0).setValue(LARVA, 0));
	}

	protected MapCodec<? extends BaseEntityBlock> codec() {
		return CODEC;
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(LARVAL_STAGE, LARVA);
	}

	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		return new AnthillHatcheryBlockEntity(pPos, pState);
	}

	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
		return createTickerHelper(pBlockEntityType, SBBlockEntities.ANTHILL_HATCHERY_BLOCK_ENTITY.get(), AnthillHatcheryBlockEntity::serverTick);
	}

	@SuppressWarnings("deprecation")
	public RenderShape getRenderShape(BlockState pState) {
		return RenderShape.MODEL;
	}

	public void angerNearbyAnts(Level level, BlockPos pos) {
		List<AntSoldier> list = level.getEntitiesOfClass(AntSoldier.class, (new AABB(pos)).inflate(8, 6, 8));
		if (!list.isEmpty()) {
			List<Player> players = level.getEntitiesOfClass(Player.class, (new AABB(pos)).inflate(8, 6, 8));
			if (players.isEmpty()) return;
			int i = players.size();

			for (AntSoldier ant : list) {
				if (ant.getTarget() == null) {
					ant.setTarget(players.get(level.random.nextInt(i)));
				}
			}
		}
	}

	public void playerDestroy(Level pLevel, Player pPlayer, BlockPos pPos, BlockState pState, @Nullable BlockEntity pBlockEntity, ItemStack pTool) {
		super.playerDestroy(pLevel, pPlayer, pPos, pState, pBlockEntity, pTool);
		if (!pLevel.isClientSide && pBlockEntity instanceof AnthillHatcheryBlockEntity blockEntity) {
			BlockEntity base = pLevel.getBlockEntity(blockEntity.getParentNestPos());
			if (base instanceof AnthillBlockEntity anthill) {
				anthill.emptyAntsFromNest(pPlayer, anthill.getBlockState(), AnthillBlockEntity.AntReleaseStatus.EMERGENCY);
			}

			this.angerNearbyAnts(pLevel, blockEntity.getParentNestPos());
		}
	}
}
