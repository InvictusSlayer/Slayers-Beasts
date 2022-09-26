package net.invictusslayer.slayersbeasts.entity;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.ForgeMod;

import javax.annotation.Nullable;

public class TinyAntEntity extends PathfinderMob {
    public TinyAntEntity(EntityType<TinyAntEntity> entityType, Level level) {
        super(entityType, level);
    }
    private static final EntityDataAccessor<Integer> DATA_ANT_TYPE = SynchedEntityData.defineId(TinyAntEntity.class, EntityDataSerializers.INT);
    private static final ResourceLocation WOOD_ANT = new ResourceLocation("wood_ant");
    private static final ResourceLocation LEAFCUTTER_ANT = new ResourceLocation("leafcutter_ant");
    private static final ResourceLocation MEADOW_ANT = new ResourceLocation("meadow_ant");

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.22F)
                .add(Attributes.MAX_HEALTH, 5.0F)
                .add(ForgeMod.ENTITY_GRAVITY.get(), 0.1F);
    }

    public static boolean canSpawn(EntityType<TinyAntEntity> entity, LevelAccessor levelAccess, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return PathfinderMob.checkMobSpawnRules(entity, levelAccess, spawnType, pos, random);
    }

    public MobType getMobType() {
        return MobType.ARTHROPOD;
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ANT_TYPE, 0);
    }

    public int getAntType() {
        return this.entityData.get(DATA_ANT_TYPE);
    }
    public void setAntType(int pTinyAntType) {
        if (pTinyAntType == 0) {
            if (!this.hasCustomName()) {
                this.setCustomName(Component.translatable(Util.makeDescriptionId("entity", WOOD_ANT)));
            }
        } else if (pTinyAntType == 1) {
            if (!this.hasCustomName()) {
                this.setCustomName(Component.translatable(Util.makeDescriptionId("entity", LEAFCUTTER_ANT)));
            }
        } else if (pTinyAntType == 2) {
            if (!this.hasCustomName()) {
                this.setCustomName(Component.translatable(Util.makeDescriptionId("entity", MEADOW_ANT)));
            }
        }

        this.entityData.set(DATA_ANT_TYPE, pTinyAntType);
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        int i = this.getRandomAntType(pLevel);
        if (pSpawnData instanceof TinyAntGroupData) {
            i = ((TinyAntGroupData)pSpawnData).tinyAntType;
        } else {
            pSpawnData = new TinyAntGroupData(i);
        }

        this.setAntType(i);
        return pSpawnData;
    }

    private int getRandomAntType(LevelAccessor pLevel) {
        Holder<Biome> holder = pLevel.getBiome(this.blockPosition());
        int i = pLevel.getRandom().nextInt(3);
        if (holder.is(BiomeTags.IS_FOREST) && !holder.is(Biomes.GROVE)) {
            return 0;
        } else if (holder.is(BiomeTags.IS_JUNGLE) || holder.is(BiomeTags.IS_SAVANNA)) {
            return 1;
        } else if (holder.is(Biomes.PLAINS) || holder.is(Biomes.MEADOW) || holder.is(Biomes.SUNFLOWER_PLAINS)) {
            return 2;
        } else {
            return i;
        }
    }

    public static class TinyAntGroupData implements SpawnGroupData {
        public final int tinyAntType;

        private TinyAntGroupData(int pAntType) {
            this.tinyAntType = pAntType;
        }
    }
}
