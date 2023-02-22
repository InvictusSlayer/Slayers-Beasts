package net.invictusslayer.slayersbeasts.block.entity;

import net.invictusslayer.slayersbeasts.block.AnthillBlock;
import net.invictusslayer.slayersbeasts.entity.AbstractAntEntity;
import net.invictusslayer.slayersbeasts.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.apache.commons.compress.utils.Lists;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class AnthillBlockEntity extends BlockEntity {
    public static final List<String> IGNORED_ANT_TAGS = Arrays.asList("Air", "ArmorDropChances", "ArmorItems", "Brain",
            "CanPickUpLoot", "DeathTime", "FallDistance", "FallFlying", "Fire", "HandDropChances", "HandItems",
            "HurtByTimestamp", "HurtTime", "LeftHanded", "Motion", "OnGround", "PortalCooldown", "Pos", "Rotation",
            "CooldownToEnterNest", "CooldownToLocateNest", "FailedForagingTime", "NestPos", "Passengers", "Leash", "UUID");
    public final List<AntData> stored = Lists.newArrayList();
    private int inhabitantType;

    public AnthillBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.ANTHILL_BLOCK_ENTITY.get(), pPos, pBlockState);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        pTag.put("Ants", this.writeAnts());
    }

    public ListTag writeAnts() {
        ListTag listTag = new ListTag();

        for (AntData data : this.stored) {
            CompoundTag compoundTag = data.entityData.copy();
            compoundTag.remove("UUID");
            CompoundTag compoundTag1 = new CompoundTag();
            compoundTag1.put("EntityData", compoundTag);
            compoundTag1.putInt("TicksInNest", data.ticksInNest);
            compoundTag1.putInt("MinOccupationTicks", data.minOccupationTicks);
            listTag.add(compoundTag1);
        }
        return listTag;
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        this.stored.clear();
        ListTag listTag = pTag.getList("Ants", 10);

        for (int i = 0; i < listTag.size(); ++i) {
            CompoundTag compoundTag = listTag.getCompound(i);
            AntData data = new AntData(compoundTag.getCompound("EntityData"), compoundTag.getInt("TicksInNest"),
                    compoundTag.getInt("MinOccupationTicks"));
            this.stored.add(data);
        }
    }

    public static void serverTick(Level level, BlockPos pos, BlockState blockState, AnthillBlockEntity entity) {
        tickOccupants(level, pos, blockState, entity.stored);
    }

    private static void tickOccupants(Level level, BlockPos pos, BlockState blockState, List<AntData> dataList) {
        boolean flag = false;
        AntData antData;

        for (Iterator<AntData> iterator = dataList.iterator(); iterator.hasNext(); ++antData.ticksInNest) {
            antData = iterator.next();
            if (antData.ticksInNest > antData.minOccupationTicks) {
                AntReleaseStatus releaseStatus = antData.entityData.getBoolean("HasFood") ?
                        AntReleaseStatus.FOOD_DELIVERED : antData.entityData.getBoolean("HasSupplies") ?
                        AntReleaseStatus.SUPPLIES_DELIVERED : AntReleaseStatus.ANT_RELEASED;
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

    public boolean isEmpty() {
        return this.stored.isEmpty();
    }

    public boolean isFull() {
        return this.stored.size() == 10;
    }

    public int getInhabitantType() {
        return inhabitantType;
    }

    public void emptyAllLivingFromNest(@Nullable Player player, BlockState blockState, AntReleaseStatus releaseStatus) {
        List<Entity> list = this.releaseAllOccupants(blockState, releaseStatus);
        if (player != null) {
            for (Entity entity : list) {
                if (entity instanceof AbstractAntEntity ant) {
                    ant.setCooldownToEnterNest(400);
                }
            }
        }
    }

    private List<Entity> releaseAllOccupants(BlockState blockState, AntReleaseStatus releaseStatus) {
        List<Entity> list = Lists.newArrayList();
        this.stored.removeIf((data) -> releaseOccupant(this.level, this.worldPosition, blockState, data, list, releaseStatus));
        if (!list.isEmpty()) {
            super.setChanged();
        }

        return list;
    }

    public void addOccupant(Entity entity, int antType, boolean hasCargo) {
        this.inhabitantType = antType;
        this.addOccupantWithPresetTicks(entity, hasCargo, 0);
    }

    public static int getFungusLevel(BlockState state) {
        return state.getValue(AnthillBlock.FUNGUS_LEVEL);
    }

    public static int getSupplyLevel(BlockState state) {
        return state.getValue(AnthillBlock.SUPPLY_LEVEL);
    }

    public void addOccupantWithPresetTicks(Entity entity, boolean hasCargo, int timeInNest) {
        if (this.stored.size() < 10) {
            entity.stopRiding();
            entity.ejectPassengers();
            CompoundTag compoundTag = new CompoundTag();
            entity.save(compoundTag);
            this.storeAnt(compoundTag, timeInNest, hasCargo);
            if (this.level != null) {
                this.level.gameEvent(GameEvent.BLOCK_CHANGE, this.getBlockPos(), GameEvent.Context.of(entity, this.getBlockState()));
            }

            entity.discard();
            super.setChanged();
        }
    }

    public void storeAnt(CompoundTag data, int ticksInNest, boolean hasCargo) {
        this.stored.add(new AntData(data, ticksInNest, hasCargo ? 2400 : 600));
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
            if (releaseStatus == AntReleaseStatus.FOOD_DELIVERED) {
                ant.dropOffCargo();
                if (state.is(ModTags.Blocks.ANTHILLS, stateBase ->
                        stateBase.hasProperty(AnthillBlock.FUNGUS_LEVEL))) {
                    int i = getFungusLevel(state);
                    if (i < 8) {
                        level.setBlockAndUpdate(pos, state.setValue(AnthillBlock.FUNGUS_LEVEL, i + 1));
                    }
                }
            } else if (releaseStatus == AntReleaseStatus.SUPPLIES_DELIVERED) {
                ant.dropOffCargo();
                if (state.is(ModTags.Blocks.ANTHILLS, stateBase ->
                        stateBase.hasProperty(AnthillBlock.SUPPLY_LEVEL))) {
                    int i = getSupplyLevel(state);
                    if (i < 15) {
                        level.setBlockAndUpdate(pos, state.setValue(AnthillBlock.SUPPLY_LEVEL, i + 1));
                    }
                }
            }

            if (storedInNest != null) {
                storedInNest.add(ant);
            }

            double d3 = flag ? 0.0D : 0.55D + (double) (entity.getBbWidth() / 2.0F);
            double d0 = (double) pos.getX() + 0.5D + d3;
            double d1 = (double) pos.getY() + 1.0D + entity.getBbHeight();
            double d2 = (double) pos.getZ() + 0.5D + d3;
            entity.moveTo(d0, d1, d2, entity.getYRot(), entity.getXRot());
        }

        level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(entity, level.getBlockState(pos)));
        return level.addFreshEntity(entity);
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

        AntData(CompoundTag data, int ticksInNest, int minOccupationTicks) {
            removeIgnoredAntTags(data);
            this.entityData = data;
            this.ticksInNest = ticksInNest;
            this.minOccupationTicks = minOccupationTicks;
        }
    }

    public enum AntReleaseStatus {
        FOOD_DELIVERED,
        SUPPLIES_DELIVERED,
        ANT_RELEASED,
        EMERGENCY
    }
}
