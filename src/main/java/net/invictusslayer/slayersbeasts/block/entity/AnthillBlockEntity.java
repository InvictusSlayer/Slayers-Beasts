package net.invictusslayer.slayersbeasts.block.entity;

import net.invictusslayer.slayersbeasts.block.AnthillBlock;
import net.invictusslayer.slayersbeasts.entity.AbstractAnt;
import net.invictusslayer.slayersbeasts.entity.QueenAnt;
import net.invictusslayer.slayersbeasts.entity.SoldierAnt;
import net.invictusslayer.slayersbeasts.block.ModBlocks;
import net.invictusslayer.slayersbeasts.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import javax.annotation.Nullable;
import java.util.*;

public class AnthillBlockEntity extends BlockEntity {
    private static final List<String> IGNORED_ANT_TAGS = Arrays.asList("Air", "ArmorDropChances", "ArmorItems", "Brain",
            "CanPickUpLoot", "DeathTime", "FallDistance", "FallFlying", "Fire", "HandDropChances", "HandItems",
            "HurtByTimestamp", "HurtTime", "LeftHanded", "Motion", "OnGround", "PortalCooldown", "Pos", "Rotation",
            "CooldownToEnterNest", "CooldownToLocateNest", "FailedForagingTime", "NestPos", "Passengers", "Leash", "UUID");
    private final List<AntData> storedAnts = new ArrayList<>();
    private final Map<BlockPos, UpgradeData> nestUpgrades = new HashMap<>();
    private int inhabitantType;
    private boolean hasQueen;

    public AnthillBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.ANTHILL_BLOCK_ENTITY.get(), pPos, pBlockState);
        this.inhabitantType = 99;
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        pTag.put("Ants", this.writeAnts());
        pTag.put("Upgrades", this.writeUpgrades());
        pTag.putInt("InhabitantType", this.getInhabitantType());
        pTag.putBoolean("HasQueen", this.hasQueen);
    }

    public ListTag writeAnts() {
        ListTag listTag = new ListTag();

        for (AntData data : this.storedAnts) {
            CompoundTag compoundTag = data.entityData.copy();
            compoundTag.remove("UUID");
            CompoundTag compoundTag1 = new CompoundTag();
            compoundTag1.put("EntityData", compoundTag);
            compoundTag1.putInt("TicksInNest", data.ticksInNest);
            compoundTag1.putInt("MinOccupationTicks", data.minOccupationTicks);
            compoundTag1.putBoolean("IsQueen", data.isQueen);
            listTag.add(compoundTag1);
        }
        return listTag;
    }

    public ListTag writeUpgrades() {
        ListTag listTag = new ListTag();

        for (UpgradeData data : this.nestUpgrades.values()) {
            CompoundTag compoundTag = new CompoundTag();
            compoundTag.putInt("UpgradeType", data.upgradeType);
            compoundTag.put("BlockPos", NbtUtils.writeBlockPos(data.pos));
            listTag.add(compoundTag);
        }
        return listTag;
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        this.storedAnts.clear();
        this.nestUpgrades.clear();
        ListTag antList = pTag.getList("Ants", 10);
        ListTag upgradeList = pTag.getList("Upgrades", 10);

        for (int i = 0; i < antList.size(); ++i) {
            CompoundTag compoundTag = antList.getCompound(i);
            AntData data = new AntData(compoundTag.getCompound("EntityData"), compoundTag.getInt("TicksInNest"),
                    compoundTag.getInt("MinOccupationTicks"), compoundTag.getBoolean("IsQueen"));
            this.storedAnts.add(data);
        }

        for (int j = 0; j < upgradeList.size(); ++j) {
            CompoundTag compoundTag = upgradeList.getCompound(j);
            BlockPos pos = NbtUtils.readBlockPos(compoundTag.getCompound("BlockPos"));
            UpgradeData data = new UpgradeData(compoundTag.getInt("UpgradeType"), pos);
            this.nestUpgrades.put(pos, data);
        }

        this.setInhabitantType(pTag.getInt("InhabitantType"));
        this.hasQueen = pTag.getBoolean("HasQueen");
    }

    public static int getFungusLevel(BlockState state) {
        return state.getValue(AnthillBlock.FUNGUS_LEVEL);
    }
    public static int getSupplyLevel(BlockState state) {
        return state.getValue(AnthillBlock.SUPPLY_LEVEL);
    }

    public boolean isEmpty() {
        return this.storedAnts.isEmpty();
    }
    public boolean isFull() {
        return this.storedAnts.size() == 10;
    }

    public int getInhabitantType() {
        return inhabitantType;
    }
    public void setInhabitantType(int type) {
        this.inhabitantType = type;
    }

    public static void serverTick(Level level, BlockPos pos, BlockState blockState, AnthillBlockEntity entity) {
        tickOccupants(level, pos, blockState, entity.storedAnts);
        tickExpansionsAndUpgrades(level, pos, blockState, entity);
    }

    private static void tickOccupants(Level level, BlockPos pos, BlockState blockState, List<AntData> dataList) {
        boolean flag = false;
        AntData antData;

        for (Iterator<AntData> iterator = dataList.iterator(); iterator.hasNext(); ++antData.ticksInNest) {
            antData = iterator.next();
            if (antData.isQueen) {
                continue;
            }
            if (antData.ticksInNest > antData.minOccupationTicks) {
                AntReleaseStatus releaseStatus = antData.entityData.getBoolean("HasCargo") ?
                        AntReleaseStatus.CARGO_DELIVERED : AntReleaseStatus.ANT_RELEASED;
                if (releaseOccupant(level, pos, blockState, antData, null, releaseStatus)) {
                    flag = true;
                    iterator.remove();
                }
            }
        }

        if (flag) {
            setChanged(level, pos, blockState);
        }
    }

    private static void tickExpansionsAndUpgrades(Level level, BlockPos pos, BlockState blockState, AnthillBlockEntity blockEntity) {
        if (level.getGameTime() % 200 == 0) {
            int blockType = 1;

            List<BlockPos> list = blockEntity.scanNest(level, pos, null, ModTags.Blocks.ANTHILLS);
            Set<BlockPos> set = blockEntity.nestUpgrades.keySet();

            for (BlockPos pos1 : list) {
                set.remove(pos1);
            }
            for (BlockPos pos1 : set) {
                blockEntity.nestUpgrades.remove(pos1);
            }
            if (!set.isEmpty()) {
                blockEntity.emptyAntsFromNest(null, blockState, AntReleaseStatus.PATROLLING);
            }

            for (UpgradeData data : blockEntity.nestUpgrades.values()) {
                BlockEntity blockEntity1 = level.getBlockEntity(data.pos);
                if (data.upgradeType == 1) {
                    if (blockEntity1 instanceof AnthillHatcheryBlockEntity hatchery) {
                        if (blockEntity.hasQueen) {
                            hatchery.storeEgg(level, data.pos);
                        }
                    }
                }
            }

            int i = getSupplyLevel(blockState);
            if (i >= 5) {
                blockEntity.upgradeNest(level, pos, blockState, blockType);
            } else if (i >= 3) {
                blockEntity.expandNest(level, pos, blockState);
            }
        }
    }

    private void upgradeNest(Level level, BlockPos nestPos, BlockState blockState, int upgradeType) {
        Block block = null;

        List<BlockPos> posList = scanNest(level, nestPos, ModBlocks.ANT_SOIL.get(), null);
        if (posList.isEmpty() || nestUpgrades.size() > 5) return;

        BlockPos blockPos = posList.get(level.random.nextInt(posList.size()));
        if (upgradeType == 1) {
            block = ModBlocks.ANTHILL_HATCHERY.get();
        } else if (upgradeType == 99) {
            block = ModBlocks.ANT_SOIL.get();
        }

        if (block != null) {
            this.nestUpgrades.put(blockPos, new UpgradeData(upgradeType, blockPos));
            level.setBlock(nestPos, blockState.setValue(AnthillBlock.SUPPLY_LEVEL, getSupplyLevel(blockState) - 5), 3);
            level.setBlockAndUpdate(blockPos, block.defaultBlockState());
            setChanged(level, nestPos, blockState);
            if (level.getBlockEntity(blockPos) instanceof BaseAnthillBlockEntity blockEntity) {
                blockEntity.setParentNestPos(nestPos);
            }
        }
    }

    private void expandNest(Level level, BlockPos nestPos, BlockState blockState) {
        List<BlockPos> posList = scanNest(level, nestPos, null, ModTags.Blocks.ANTHILL_REPLACEABLE);
        if (posList.isEmpty()) return;

        BlockPos blockPos = posList.get(level.random.nextInt(posList.size()));
        level.setBlockAndUpdate(blockPos, ModBlocks.ANT_SOIL.get().defaultBlockState());
        level.setBlock(nestPos, blockState.setValue(AnthillBlock.SUPPLY_LEVEL, getSupplyLevel(blockState) - 3), 3);
        setChanged(level, nestPos, blockState);
    }

    private List<BlockPos> scanNest(Level level, BlockPos nestPos, @Nullable Block block, @Nullable TagKey<Block> blocks) {
        List<BlockPos> posList = new ArrayList<>();
        for (int y = 0; y > -4; y--) {
            int radius = y + 5;
            if (nestPos.getY() + y < level.getMinBuildHeight()) break;

            for (int x = -radius; x <= radius; x++) {
                for (int z = -radius; z <= radius; z++) {
                    BlockPos tempBlockPos = getBlockPos().offset(x, y, z);
                    if ((x ^ 2) + (z ^ 2) <= (radius ^ 2) && !nestPos.equals(tempBlockPos)) {
                        if (level.getBlockState(tempBlockPos).is(block) || level.getBlockState(tempBlockPos).is(blocks)) {
                            posList.add(tempBlockPos);
                        }
                    }
                }
            }
        }
        return posList;
    }

    public void emptyAntsFromNest(@Nullable Player player, BlockState blockState, AntReleaseStatus releaseStatus) {
        List<Entity> list = this.releaseAllOccupants(blockState, releaseStatus);
        if (player != null) {
            for (Entity entity : list) {
                if (entity instanceof AbstractAnt ant) {
                    ant.setCooldownToEnterNest(400);
                }
            }
        }
        if (this.isEmpty()) {
            setInhabitantType(99);
        }
    }

    private List<Entity> releaseAllOccupants(BlockState blockState, AntReleaseStatus releaseStatus) {
        List<Entity> list = new ArrayList<>();
        if (level != null) {
            this.storedAnts.removeIf((data) -> releaseOccupant(this.level, this.worldPosition, blockState, data, list, releaseStatus));
        }
        if (!list.isEmpty()) {
            super.setChanged();
        }

        return list;
    }

    private static boolean releaseOccupant(Level level, BlockPos pos, BlockState state, AntData data, @Nullable List<Entity> storedInNest, AntReleaseStatus releaseStatus) {
        if (level.isRaining() && releaseStatus != AntReleaseStatus.EMERGENCY) {
            return false;
        }
        BlockPos above = pos.above();
        boolean flag = level.getBlockState(above).getCollisionShape(level, above).isEmpty();
        if (!flag && releaseStatus != AntReleaseStatus.EMERGENCY) {
            return false;
        }

        CompoundTag compoundTag = data.entityData.copy();
        removeIgnoredAntTags(compoundTag);
        compoundTag.put("NestPos", NbtUtils.writeBlockPos(pos));
        Entity entity = EntityType.loadEntityRecursive(compoundTag, level, entity1 -> entity1);
        if (entity == null) {
            return false;
        }
        if (!entity.getType().is(ModTags.EntityTypes.ANTHILL_INHABITANTS)) {
            return false;
        }
        if (releaseStatus == AntReleaseStatus.PATROLLING && !(entity instanceof SoldierAnt)) {
            return false;
        }

        if (entity instanceof AbstractAnt ant) {
             if (releaseStatus == AntReleaseStatus.CARGO_DELIVERED) {
                int cargo = ant.getCargoType();
                ant.setCargoType(99);
                if (cargo == 1) {
                    if (state.is(ModTags.Blocks.ANTHILLS, stateBase -> stateBase.hasProperty(AnthillBlock.FUNGUS_LEVEL))) {
                        int i = getFungusLevel(state);
                        if (i < 8) {
                            level.setBlockAndUpdate(pos, state.setValue(AnthillBlock.FUNGUS_LEVEL, i + 1));
                        }
                    }
                } else if (cargo == 2) {
                    if (state.is(ModTags.Blocks.ANTHILLS, stateBase -> stateBase.hasProperty(AnthillBlock.SUPPLY_LEVEL))) {
                        int i = getSupplyLevel(state);
                        if (i < 15) {
                            level.setBlockAndUpdate(pos, state.setValue(AnthillBlock.SUPPLY_LEVEL, i + 1));
                        }
                    }
                }
            }

            if (storedInNest != null) {
                storedInNest.add(ant);
            }

            double w = flag ? 0 : 0.55D + ant.getBbWidth() * 0.5D;
            double d0 = (double) pos.getX() + 0.5D + w;
            double d1 = (double) pos.getY() + 1D;
            double d2 = (double) pos.getZ() + 0.5D + w;
            ant.moveTo(d0, d1, d2, ant.getYRot(), ant.getXRot());
        }

        level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(entity, level.getBlockState(pos)));
        return level.addFreshEntity(entity);
    }

    public void addOccupant(Entity entity, int antType, boolean hasCargo) {
        setInhabitantType(antType);
        this.addOccupantWithPresetTicks(entity, hasCargo, 0);
    }

    public void addOccupantWithPresetTicks(Entity entity, boolean hasCargo, int timeInNest) {
        if (this.storedAnts.size() < 10) {
            entity.stopRiding();
            entity.ejectPassengers();
            CompoundTag compoundTag = new CompoundTag();
            entity.save(compoundTag);
            this.storeAnt(compoundTag, timeInNest, hasCargo, entity);
            if (this.level != null) {
                this.level.gameEvent(GameEvent.BLOCK_CHANGE, this.getBlockPos(), GameEvent.Context.of(entity, this.getBlockState()));
            }

            entity.discard();
            super.setChanged();
        }
    }

    public void storeAnt(CompoundTag data, int ticksInNest, boolean hasCargo, Entity entity) {
        boolean isQueen = entity instanceof QueenAnt;
        this.storedAnts.add(new AntData(data, ticksInNest, hasCargo ? 2400 : 600, isQueen));
    }

    static void removeIgnoredAntTags(CompoundTag tag) {
        for (String s : IGNORED_ANT_TAGS) {
            tag.remove(s);
        }
    }

    static class AntData {
        final CompoundTag entityData;
        int ticksInNest;
        final int minOccupationTicks;
        final boolean isQueen;

        AntData(CompoundTag data, int ticksInNest, int minOccupationTicks, boolean isQueen) {
            removeIgnoredAntTags(data);
            this.entityData = data;
            this.ticksInNest = ticksInNest;
            this.minOccupationTicks = minOccupationTicks;
            this.isQueen = isQueen;
        }
    }

    record UpgradeData(int upgradeType, BlockPos pos) {
    }

    public enum AntReleaseStatus {
        CARGO_DELIVERED,
        ANT_RELEASED,
        PATROLLING,
        EMERGENCY
    }
}
