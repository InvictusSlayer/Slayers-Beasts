package net.invictusslayer.slayersbeasts.block;

import net.invictusslayer.slayersbeasts.block.entity.AnthillBlockEntity;
import net.invictusslayer.slayersbeasts.block.entity.ModBlockEntities;
import net.invictusslayer.slayersbeasts.entity.SoldierAntEntity;
import net.invictusslayer.slayersbeasts.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
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
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AnthillBlock extends BaseEntityBlock {
    public static final IntegerProperty FUNGUS_LEVEL = IntegerProperty.create("fungus_level", 0, 5);
    public static final IntegerProperty SUPPLY_LEVEL = IntegerProperty.create("supply_level", 0, 10);

    public AnthillBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FUNGUS_LEVEL, 0).setValue(SUPPLY_LEVEL, 0));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FUNGUS_LEVEL, SUPPLY_LEVEL);
    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new AnthillBlockEntity(pPos, pState);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createTickerHelper(pBlockEntityType, ModBlockEntities.ANTHILL_BLOCK_ENTITY.get(), AnthillBlockEntity::serverTick);
    }

    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    public static void dropMushroom(Level pLevel, BlockPos pPos) {
        popResource(pLevel, pPos, new ItemStack(ModBlocks.WHITE_MUSHROOM.get(), pLevel.random.nextInt(1, 4)));
    }

    public void angerNearbyAnts(Level level, BlockPos pos) {
        List<SoldierAntEntity> list = level.getEntitiesOfClass(SoldierAntEntity.class, (new AABB(pos)).inflate(8, 6, 8));
        if (!list.isEmpty()) {
            List<Player> players = level.getEntitiesOfClass(Player.class, (new AABB(pos)).inflate(8, 6, 8));
            if (players.isEmpty()) return;
            int i = players.size();

            for (SoldierAntEntity ant : list) {
                if (ant.getTarget() == null) {
                    ant.setTarget(players.get(level.random.nextInt(i)));
                }
            }
        }
    }

    @SuppressWarnings("deprecation")
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack handItem = pPlayer.getItemInHand(pHand);
        int i = pState.getValue(FUNGUS_LEVEL);
        boolean flag = false;
        if (i >= 5) {
            Item item = handItem.getItem();
            if (handItem.canPerformAction(net.minecraftforge.common.ToolActions.SHEARS_HARVEST)) {
                dropMushroom(pLevel, pPos);
                handItem.hurtAndBreak(1, pPlayer, (onBroken) -> onBroken.broadcastBreakEvent(pHand));
                flag = true;
                pLevel.gameEvent(pPlayer, GameEvent.SHEAR, pPos);
            } else if (handItem.is(Items.DIRT)) {
                handItem.shrink(1);
                if (handItem.isEmpty()) {
                    pPlayer.setItemInHand(pHand, new ItemStack(ModBlocks.ANT_SOIL.get()));
                } else if (!pPlayer.getInventory().add(new ItemStack(ModBlocks.ANT_SOIL.get()))) {
                    pPlayer.drop(new ItemStack(ModBlocks.ANT_SOIL.get()), false);
                }

                flag = true;
                pLevel.gameEvent(pPlayer, GameEvent.ENTITY_INTERACT, pPos);
            }

            if (!pLevel.isClientSide && flag) {
                pPlayer.awardStat(Stats.ITEM_USED.get(item));
            }
        }

        if (flag) {
            if (this.nestContainsAnts(pLevel, pPos)) {
                this.angerNearbyAnts(pLevel, pPos);
            }

            this.releaseAntsAndResetMushroomLevel(pLevel, pState, pPos, pPlayer, AnthillBlockEntity.AntReleaseStatus.EMERGENCY);
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        } else {
            return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
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

    public void releaseAntsAndResetMushroomLevel(Level level, BlockState state, BlockPos pos, @Nullable Player player, AnthillBlockEntity.AntReleaseStatus releaseStatus) {
        this.resetMushroomLevel(level, state, pos);
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof AnthillBlockEntity anthillBlockEntity) {
            anthillBlockEntity.emptyAntsFromNest(player, state, releaseStatus);
        }
    }

    public void resetMushroomLevel(Level level, BlockState state, BlockPos pos) {
        level.setBlock(pos, state.setValue(FUNGUS_LEVEL, 0), 3);
    }

    public void playerDestroy(Level pLevel, Player pPlayer, BlockPos pPos, BlockState pState, @Nullable BlockEntity pBlockEntity, ItemStack pTool) {
        super.playerDestroy(pLevel, pPlayer, pPos, pState, pBlockEntity, pTool);
        if (!pLevel.isClientSide && pBlockEntity instanceof AnthillBlockEntity anthillBlockEntity) {
            anthillBlockEntity.emptyAntsFromNest(pPlayer, pState, AnthillBlockEntity.AntReleaseStatus.EMERGENCY);
            this.angerNearbyAnts(pLevel, pPos);
        }
    }

    public void playerWillDestroy(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        if (!pLevel.isClientSide && pPlayer.isCreative() && pLevel.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS)) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof AnthillBlockEntity anthillBlockEntity) {
                ItemStack itemStack = new ItemStack(this);
                int i = pState.getValue(FUNGUS_LEVEL);
                int j = pState.getValue(SUPPLY_LEVEL);
                boolean flag = !anthillBlockEntity.isEmpty();
                if (flag || i > 0 || j > 0) {
                    if (flag) {
                        CompoundTag compoundTag = new CompoundTag();
                        compoundTag.put("Ants", anthillBlockEntity.writeAnts());
                        BlockItem.setBlockEntityData(itemStack, ModBlockEntities.ANTHILL_BLOCK_ENTITY.get(), compoundTag);
                    }

                    CompoundTag compoundTag1 = new CompoundTag();
                    compoundTag1.putInt("fungus_level", i);
                    compoundTag1.putInt("supply_level", j);
                    itemStack.addTagElement("BlockStateTag", compoundTag1);
                    ItemEntity itemEntity = new ItemEntity(pLevel, pPos.getX(), pPos.getY(), pPos.getZ(), itemStack);
                    itemEntity.setDefaultPickUpDelay();
                    pLevel.addFreshEntity(itemEntity);
                }
            }
        }

        super.playerWillDestroy(pLevel, pPos, pState, pPlayer);
    }

    @SuppressWarnings("deprecation")
    public List<ItemStack> getDrops(BlockState pState, LootContext.Builder pBuilder) {
        Entity entity = pBuilder.getOptionalParameter(LootContextParams.THIS_ENTITY);
        if (entity instanceof PrimedTnt || entity instanceof Creeper || entity instanceof WitherSkull ||
                entity instanceof WitherBoss || entity instanceof MinecartTNT) {
            BlockEntity blockEntity = pBuilder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
            if (blockEntity instanceof AnthillBlockEntity anthillBlockEntity) {
                anthillBlockEntity.emptyAntsFromNest(null, pState, AnthillBlockEntity.AntReleaseStatus.EMERGENCY);
            }
        }

        return super.getDrops(pState, pBuilder);
    }
}
