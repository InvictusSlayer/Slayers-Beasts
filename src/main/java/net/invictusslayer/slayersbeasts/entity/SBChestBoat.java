package net.invictusslayer.slayersbeasts.entity;

import net.invictusslayer.slayersbeasts.item.SBItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class SBChestBoat extends ChestBoat {
	private static final EntityDataAccessor<Integer> DATA_TYPE = SynchedEntityData.defineId(SBChestBoat.class, EntityDataSerializers.INT);

	public SBChestBoat(EntityType<? extends Boat> type, Level level) {
		super(type, level);
	}

	public SBChestBoat(Level level, double x, double y, double z) {
		this(SBEntities.SB_CHEST_BOAT.get(), level);
		setPos(x, y, z);
		xo = x;
		yo = y;
		zo = z;
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		entityData.define(DATA_TYPE, SBBoat.Type.ASPEN.ordinal());
	}

	protected void addAdditionalSaveData(CompoundTag tag) {
		tag.putString("Type", getSBVariant().getSerializedName());
	}

	protected void readAdditionalSaveData(CompoundTag tag) {
		if (tag.contains("Type", 8)) {
			setVariant(SBBoat.Type.byName(tag.getString("Type")));
		}
	}

	public SBBoat.Type getSBVariant() {
		return SBBoat.Type.byId(entityData.get(DATA_TYPE));
	}
	public void setVariant(SBBoat.Type type) {
		entityData.set(DATA_TYPE, type.ordinal());
	}

	public Item getDropItem() {
		return switch (getSBVariant()) {
			case ASPEN -> SBItems.ASPEN_CHEST_BOAT.get();
			case DESERT_OAK -> SBItems.DESERT_OAK_CHEST_BOAT.get();
			case EUCALYPTUS -> SBItems.EUCALYPTUS_CHEST_BOAT.get();
			case KAPOK -> SBItems.KAPOK_CHEST_BOAT.get();
			case REDWOOD -> SBItems.REDWOOD_CHEST_BOAT.get();
			case WILLOW -> SBItems.WILLOW_CHEST_BOAT.get();
		};
	}
}
