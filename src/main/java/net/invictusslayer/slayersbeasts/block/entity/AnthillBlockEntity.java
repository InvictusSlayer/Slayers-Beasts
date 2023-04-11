package net.invictusslayer.slayersbeasts.block.entity;

import net.invictusslayer.slayersbeasts.block.AnthillBlock;
import net.invictusslayer.slayersbeasts.entity.AbstractAntEntity;
import net.invictusslayer.slayersbeasts.entity.QueenAntEntity;
import net.invictusslayer.slayersbeasts.init.ModBlocks;
import net.invictusslayer.slayersbeasts.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.apache.commons.compress.utils.Lists;

import javax.annotation.Nullable;
import java.util.*;

public class AnthillBlockEntity extends BlockEntity {
    private static final List<String> IGNORED_ANT_TAGS = Arrays.asList("Air", "ArmorDropChances", "ArmorItems", "Brain",
            "CanPickUpLoot", "DeathTime", "FallDistance", "FallFlying", "Fire", "HandDropChances", "HandItems",
            "HurtByTimestamp", "HurtTime", "LeftHanded", "Motion", "OnGround", "PortalCooldown", "Pos", "Rotation",
            "CooldownToEnterNest", "CooldownToLocateNest", "FailedForagingTime", "NestPos", "Passengers", "Leash", "UUID");
    private final List<AntData> storedAnts = new ArrayList<>();
    private final List<BlockPos> nestExpansions = new ArrayList<>();
    private final Map<BlockPos, UpgradeData> nestUpgrades = new HashMap<>();
    private int inhabitantType;
    public boolean hasQueen;

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
            compoundTag.putInt("BlockType", data.blockType);
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
            UpgradeData data = new UpgradeData(compoundTag.getInt("BlockType"), pos);
            this.nestUpgrades.put(pos, data);
        }

        this.setInhabitantType(pTag.getInt("InhabitantType"));
        this.hasQueen = pTag.getBoolean("HasQueen");
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
                antData.ticksInNest = 0;
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
        boolean expandFlag = false;
        boolean upgradeFlag = false;

//        for (Iterator<UpgradeData> iterator = blockEntity.nestUpgrades.values().iterator(); iterator.hasNext();) {
//            UpgradeData data = iterator.next();
//            if (data.blockType == 1 && level.getBlockEntity(data.pos) instanceof AnthillHatcheryBlockEntity hatcheryBlock) {
//                hatcheryBlock.getParentNestPos();
//            }
//        }

        int i = getSupplyLevel(blockState);
        if (i >= 3) {
            expandFlag = true;
        }
        if (i >= 5) {
            expandFlag = false;
            upgradeFlag = true;
        }

        if (blockEntity.nestUpgrades.size() <= 5 && upgradeFlag) {
            blockState.setValue(AnthillBlock.SUPPLY_LEVEL, getSupplyLevel(blockState) - 5);
            blockEntity.upgradeNest(level, pos, blockState, 1);
        }

        if (blockEntity.nestExpansions.size() <= 20 && expandFlag) {
            blockState.setValue(AnthillBlock.SUPPLY_LEVEL, getSupplyLevel(blockState) - 3);
            blockEntity.expandNest(level, pos, blockState);
        }
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

    public void emptyAntsFromNest(@Nullable Player player, BlockState blockState, AntReleaseStatus releaseStatus) {
        List<Entity> list = this.releaseAllOccupants(blockState, releaseStatus);
        if (player != null) {
            for (Entity entity : list) {
                if (entity instanceof AbstractAntEntity ant) {
                    ant.setCooldownToEnterNest(400);
                }
            }
        }
        setInhabitantType(99);
    }

    private List<Entity> releaseAllOccupants(BlockState blockState, AntReleaseStatus releaseStatus) {
        List<Entity> list = Lists.newArrayList();
        this.storedAnts.removeIf((data) -> releaseOccupant(this.level, this.worldPosition, blockState, data, list, releaseStatus));
        if (!list.isEmpty()) {
            super.setChanged();
        }

        return list;
    }

    public void addOccupant(Entity entity, int antType, boolean hasCargo) {
        setInhabitantType(antType);
        this.addOccupantWithPresetTicks(entity, hasCargo, 0);
    }

    public static int getFungusLevel(BlockState state) {
        return state.getValue(AnthillBlock.FUNGUS_LEVEL);
    }

    public static int getSupplyLevel(BlockState state) {
        return state.getValue(AnthillBlock.SUPPLY_LEVEL);
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
        this.storedAnts.add(new AntData(data, ticksInNest, hasCargo ? 2400 : 600, entity instanceof QueenAntEntity));
    }

    private static boolean releaseOccupant(Level level, BlockPos pos, BlockState state, AntData data,
                                           @Nullable List<Entity> storedInNest, AntReleaseStatus releaseStatus) {
        if (level.isRaining() && releaseStatus != AntReleaseStatus.EMERGENCY) {
            return false;
        }
        CompoundTag compoundTag = data.entityData.copy();
        removeIgnoredAntTags(compoundTag);
        compoundTag.put("NestPos", NbtUtils.writeBlockPos(pos));

        BlockPos blockPos = pos.above();
        boolean flag = level.getBlockState(blockPos).getCollisionShape(level, blockPos).isEmpty();
        if (!flag && releaseStatus != AntReleaseStatus.EMERGENCY) {
            return false;
        }

        Entity entity = EntityType.loadEntityRecursive(compoundTag, level, entity1 -> entity1);
        if (entity == null) {
            return false;
        }
        if (!entity.getType().is(ModTags.EntityTypes.ANTHILL_INHABITANTS)) {
            return false;
        }

        if (entity instanceof AbstractAntEntity ant) {
            if (releaseStatus == AntReleaseStatus.CARGO_DELIVERED) {
                ant.setCargoType(0);
                int cargo = ant.getCargoType();
                if (cargo == 1) {
                    if (state.is(ModTags.Blocks.ANTHILLS, stateBase ->
                            stateBase.hasProperty(AnthillBlock.FUNGUS_LEVEL))) {
                        int i = getFungusLevel(state);
                        if (i < 8) {
                            level.setBlockAndUpdate(pos, state.setValue(AnthillBlock.FUNGUS_LEVEL, i + 1));
                        }
                    }
                } else if (cargo == 2) {
                    if (state.is(ModTags.Blocks.ANTHILLS, stateBase ->
                            stateBase.hasProperty(AnthillBlock.SUPPLY_LEVEL))) {
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

            double d3 = flag ? 0.0D : 0.55D + entity.getBbWidth() * 0.5D;
            double d0 = (double) pos.getX() + 0.5D + d3;
            double d1 = (double) pos.getY() + 1.0D + entity.getBbHeight() * 0.5D;
            double d2 = (double) pos.getZ() + 0.5D + d3;
            entity.moveTo(d0, d1, d2, entity.getYRot(), entity.getXRot());
        }

        level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(entity, level.getBlockState(pos)));
        return level.addFreshEntity(entity);
    }

    private void scanNest(Level level, BlockPos nestPos, BlockState state) {
        List<UpgradeData> upgradeList = Lists.newArrayList();
        for (int y = 0; y > -4; y--) {
            int radius = y + 5;
            for (int x = -radius; x <= radius; x++) {
                for (int z = -radius; z <= radius; z++) {
                    BlockPos tempBlockPos = getBlockPos().offset(x, y, z);
                    if ((x^2) + (z^2) <= (radius^2) && !nestPos.equals(tempBlockPos)) {
                        if (level.getBlockState(tempBlockPos).is(ModTags.Blocks.ANTHILLS)) {
                            upgradeList.add(new UpgradeData(1, tempBlockPos));
                        }
                    }
                }
            }
        }
    }

    private void expandNest(Level level, BlockPos nestPos, BlockState state) {
        List<BlockPos> posList = Lists.newArrayList();
        for (int y = 0; y > -4; y--) {
            int radius = y + 5;
            for (int x = -radius; x <= radius; x++) {
                for (int z = -radius; z <= radius; z++) {
                    BlockPos tempBlockPos = nestPos.offset(x, y, z);
                    if ((x^2) + (z^2) <= (radius^2) && !nestPos.equals(tempBlockPos)) {
                        if (level.getBlockState(tempBlockPos).is(BlockTags.DIRT) || level.getBlockState(tempBlockPos).is(BlockTags.BASE_STONE_OVERWORLD)) {
                            posList.add(tempBlockPos);
                        }
                    }
                }
            }
        }

        if (posList.isEmpty()) return;

        BlockPos blockPos = posList.get(level.random.nextInt(posList.size()));
        if (level.setBlockAndUpdate(blockPos, ModBlocks.ANT_SOIL.get().defaultBlockState())) {
            this.nestExpansions.add(blockPos);
        }
    }

    private void upgradeNest(Level level, BlockPos nestPos, BlockState state, int blockType) {
        List<BlockPos> posList = Lists.newArrayList();
        Block block = null;

        for (int y = 0; y > -4; y--) {
            int radius = y + 5;
            for (int x = -radius; x <= radius; x++) {
                for (int z = -radius; z <= radius; z++) {
                    BlockPos tempBlockPos = nestPos.offset(x, y, z);
                    if ((x^2) + (z^2) <= (radius^2) && !nestPos.equals(tempBlockPos)) {
                        if (level.getBlockState(tempBlockPos).is(ModBlocks.ANT_SOIL.get())) {
                            posList.add(tempBlockPos);
                        }
                    }
                }
            }
        }
        if (posList.isEmpty() || nestUpgrades.size() > 5) return;

        BlockPos blockPos = posList.get(level.random.nextInt(posList.size()));
        if (blockType == 1) {
            block = ModBlocks.ANTHILL_HATCHERY.get();
        } else if (blockType == 2) {
            block = ModBlocks.ANT_SOIL.get();
        }

        if (block != null) {
            level.setBlockAndUpdate(blockPos, block.defaultBlockState());
            this.nestUpgrades.put(blockPos, new UpgradeData(blockType, blockPos));
            if (level.getBlockEntity(blockPos) instanceof BaseAnthillExtension blockEntity) {
                blockEntity.setParentNestPos(nestPos);
            }
        }
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

    static class UpgradeData {
        final int blockType;
        final BlockPos pos;
        int var1 = 0;
        int var2 = 0;

        UpgradeData(int blockType, BlockPos pos) {
            this.blockType = blockType;
            this.pos = pos;
        }
    }

    public enum AntReleaseStatus {
        CARGO_DELIVERED,
        ANT_RELEASED,
        PATROLLING,
        EMERGENCY
    }
}
