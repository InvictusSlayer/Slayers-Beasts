package net.invictusslayer.slayersbeasts.block;

import com.mojang.serialization.MapCodec;
import net.invictusslayer.slayersbeasts.block.entity.AnthillBlockEntity;
import net.invictusslayer.slayersbeasts.entity.AntSoldier;
import net.invictusslayer.slayersbeasts.init.SBBlockEntities;
import net.invictusslayer.slayersbeasts.init.SBBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.world.entity.vehicle.MinecartTNT;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.BlockItemStateProperties;
import net.minecraft.world.level.GameRules;
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
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;

public class AnthillBlock extends BaseEntityBlock {
	public static final MapCodec<AnthillBlock> CODEC = simpleCodec(AnthillBlock::new);
	public static final IntegerProperty FUNGUS_LEVEL = IntegerProperty.create("fungus_level", 0, 5);
	public static final IntegerProperty SUPPLY_LEVEL = IntegerProperty.create("supply_level", 0, 10);

	public AnthillBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FUNGUS_LEVEL, 0).setValue(SUPPLY_LEVEL, 0));
	}

	protected MapCodec<? extends BaseEntityBlock> codec() {
		return CODEC;
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FUNGUS_LEVEL, SUPPLY_LEVEL);
	}

	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new AnthillBlockEntity(pos, state);
	}

	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
		return createTickerHelper(type, SBBlockEntities.ANTHILL.get(), AnthillBlockEntity::serverTick);
	}

	public RenderShape getRenderShape(BlockState state) {
		return RenderShape.MODEL;
	}

	public static void dropMushroom(Level level, BlockPos pos) {
		popResource(level, pos, new ItemStack(SBBlocks.WHITE_MUSHROOM.get(), level.random.nextInt(1, 4)));
	}

	public void angerNearbyAnts(Level level, BlockPos pos) {
		List<AntSoldier> list = level.getEntitiesOfClass(AntSoldier.class, new AABB(pos).inflate(8, 6, 8));
		if (!list.isEmpty()) {
			List<Player> players = level.getEntitiesOfClass(Player.class, new AABB(pos).inflate(8, 6, 8));
			if (players.isEmpty()) return;
			int i = players.size();

			for (AntSoldier ant : list) {
				if (ant.getTarget() == null) {
					ant.setTarget(players.get(level.random.nextInt(i)));
				}
			}
		}
	}

	public InteractionResult useItemOn(ItemStack handItem, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
		int i = state.getValue(FUNGUS_LEVEL);
		boolean flag = false;
		if (i >= 5) {
			Item item = handItem.getItem();
//			if (handItem.canPerformAction(net.minecraftforge.common.ToolActions.SHEARS_HARVEST)) {
//				dropMushroom(level, pos);
//				handItem.hurtAndBreak(1, player, (onBroken) -> onBroken.broadcastBreakEvent(hand));
//				flag = true;
//				level.gameEvent(player, GameEvent.SHEAR, pos);
//			} else if (handItem.is(Items.DIRT)) {
//				handItem.shrink(1);
//				if (handItem.isEmpty()) {
//					player.setItemInHand(hand, new ItemStack(SBBlocks.ARIDISOL.get()));
//				} else if (!player.getInventory().add(new ItemStack(SBBlocks.ARIDISOL.get()))) {
//					player.drop(new ItemStack(SBBlocks.ARIDISOL.get()), false);
//				}
//
//				flag = true;
//				level.gameEvent(player, GameEvent.ENTITY_INTERACT, pos);
//			}

			if (!level.isClientSide && flag) {
				player.awardStat(Stats.ITEM_USED.get(item));
			}
		}

		if (flag) {
			if (this.nestContainsAnts(level, pos)) {
				this.angerNearbyAnts(level, pos);
			}

			this.releaseAntsAndResetMushroomLevel(level, state, pos, player, AnthillBlockEntity.AntReleaseStatus.EMERGENCY);
			return InteractionResult.SUCCESS;
		} else {
			return super.useItemOn(handItem, state, level, pos, player, hand, result);
		}
	}

	private boolean nestContainsAnts(Level level, BlockPos pos) {
		BlockEntity blockEntity = level.getBlockEntity(pos);
		if (blockEntity instanceof AnthillBlockEntity anthillBlockEntity) {
			return !anthillBlockEntity.isEmpty();
		} else {
			return false;
		}
	}

	public void releaseAntsAndResetMushroomLevel(Level level, BlockState state, BlockPos pos, Player player, AnthillBlockEntity.AntReleaseStatus releaseStatus) {
		this.resetMushroomLevel(level, state, pos);
		BlockEntity blockEntity = level.getBlockEntity(pos);
		if (blockEntity instanceof AnthillBlockEntity anthillBlockEntity) {
			anthillBlockEntity.emptyAntsFromNest(player, state, releaseStatus);
		}
	}

	public void resetMushroomLevel(Level level, BlockState state, BlockPos pos) {
		level.setBlock(pos, state.setValue(FUNGUS_LEVEL, 0), 3);
	}

	public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, BlockEntity blockEntity, ItemStack item) {
		super.playerDestroy(level, player, pos, state, blockEntity, item);
		if (!level.isClientSide && blockEntity instanceof AnthillBlockEntity anthillBlockEntity) {
			anthillBlockEntity.emptyAntsFromNest(player, state, AnthillBlockEntity.AntReleaseStatus.EMERGENCY);
			this.angerNearbyAnts(level, pos);
		}
	}

	public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
		if (!(level instanceof ServerLevel serverLevel)) return super.playerWillDestroy(level, pos, state, player);
		if (!level.isClientSide && player.isCreative() && serverLevel.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS)) {
			BlockEntity blockEntity = level.getBlockEntity(pos);
			if (blockEntity instanceof AnthillBlockEntity anthillBlockEntity) {
				int i = state.getValue(FUNGUS_LEVEL);
				int j = state.getValue(SUPPLY_LEVEL);
				boolean flag = !anthillBlockEntity.isEmpty();
				if (flag || i > 0 || j > 0) {
					ItemStack itemStack = new ItemStack(this);
					itemStack.applyComponents(anthillBlockEntity.collectComponents());
					itemStack.set(DataComponents.BLOCK_STATE, BlockItemStateProperties.EMPTY.with(FUNGUS_LEVEL, i).with(SUPPLY_LEVEL, j));
					ItemEntity itemEntity = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), itemStack);
					itemEntity.setDefaultPickUpDelay();
					level.addFreshEntity(itemEntity);
				}
			}
		}

		return super.playerWillDestroy(level, pos, state, player);
	}

	public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
		Entity entity = builder.getOptionalParameter(LootContextParams.THIS_ENTITY);
		if (entity instanceof PrimedTnt || entity instanceof Creeper || entity instanceof WitherSkull ||
				entity instanceof WitherBoss || entity instanceof MinecartTNT) {
			BlockEntity blockEntity = builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
			if (blockEntity instanceof AnthillBlockEntity anthillBlockEntity) {
				anthillBlockEntity.emptyAntsFromNest(null, state, AnthillBlockEntity.AntReleaseStatus.EMERGENCY);
			}
		}

		return super.getDrops(state, builder);
	}
}
