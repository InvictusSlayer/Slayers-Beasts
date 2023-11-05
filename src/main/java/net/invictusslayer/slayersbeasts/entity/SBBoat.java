package net.invictusslayer.slayersbeasts.entity;

import net.invictusslayer.slayersbeasts.block.SBBlocks;
import net.invictusslayer.slayersbeasts.item.SBItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.function.IntFunction;

public class SBBoat extends Boat {
	private static final EntityDataAccessor<Integer> DATA_TYPE = SynchedEntityData.defineId(SBBoat.class, EntityDataSerializers.INT);

	public SBBoat(EntityType<? extends Boat> type, Level level) {
		super(type, level);
	}

	public SBBoat(Level level, double x, double y, double z) {
		this(SBEntities.SB_BOAT.get(), level);
		setPos(x, y, z);
		xo = x;
		yo = y;
		zo = z;
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		entityData.define(DATA_TYPE, Type.ASPEN.ordinal());
	}

	protected void addAdditionalSaveData(CompoundTag tag) {
		tag.putString("Type", getSBVariant().getSerializedName());
	}

	protected void readAdditionalSaveData(CompoundTag tag) {
		if (tag.contains("Type", 8)) {
			setVariant(Type.byName(tag.getString("Type")));
		}
	}

	public Type getSBVariant() {
		return Type.byId(entityData.get(DATA_TYPE));
	}
	public void setVariant(Type type) {
		entityData.set(DATA_TYPE, type.ordinal());
	}

	public Item getDropItem() {
		return switch (getSBVariant()) {
			case ASPEN -> SBItems.ASPEN_BOAT.get();
			case DESERT_OAK -> SBItems.DESERT_OAK_BOAT.get();
			case EUCALYPTUS -> SBItems.EUCALYPTUS_BOAT.get();
			case KAPOK -> SBItems.KAPOK_BOAT.get();
			case REDWOOD -> SBItems.REDWOOD_BOAT.get();
			case WILLOW -> SBItems.WILLOW_BOAT.get();
		};
	}

	@SuppressWarnings("deprecation")
	public enum Type implements StringRepresentable {
		ASPEN(SBBlocks.ASPEN_PLANKS.get(), "aspen"),
		DESERT_OAK(SBBlocks.DESERT_OAK_PLANKS.get(), "desert_oak"),
		EUCALYPTUS(SBBlocks.EUCALYPTUS_PLANKS.get(), "eucalyptus"),
		KAPOK(SBBlocks.KAPOK_PLANKS.get(), "kapok"),
		REDWOOD(SBBlocks.REDWOOD_PLANKS.get(), "redwood"),
		WILLOW(SBBlocks.WILLOW_PLANKS.get(), "willow");

		private final String name;
		private final Block planks;
		public static final StringRepresentable.EnumCodec<Type> CODEC = StringRepresentable.fromEnum(Type::values);
		private static final IntFunction<Type> BY_ID = ByIdMap.continuous(Enum::ordinal, values(), ByIdMap.OutOfBoundsStrategy.ZERO);

		Type(Block planks, String name) {
			this.planks = planks;
			this.name = name;
		}

		public String getSerializedName() {
			return name;
		}

		public String getName() {
			return name;
		}

		public Block getPlanks() {
			return planks;
		}

		public String toString() {
			return name;
		}

		public static Type byId(int id) {
			return BY_ID.apply(id);
		}

		public static Type byName(String name) {
			return CODEC.byName(name, ASPEN);
		}
	}
}
