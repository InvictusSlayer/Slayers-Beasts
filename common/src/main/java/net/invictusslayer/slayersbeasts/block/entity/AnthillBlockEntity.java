package net.invictusslayer.slayersbeasts.block.entity;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.AnthillBlock;
import net.invictusslayer.slayersbeasts.init.SBDataComponents;
import net.invictusslayer.slayersbeasts.data.tag.SBTags;
import net.invictusslayer.slayersbeasts.entity.AbstractAnt;
import net.invictusslayer.slayersbeasts.entity.AntQueen;
import net.invictusslayer.slayersbeasts.entity.AntSoldier;
import net.invictusslayer.slayersbeasts.init.SBBlockEntities;
import net.invictusslayer.slayersbeasts.init.SBBlocks;
import net.invictusslayer.slayersbeasts.init.SBEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.*;

public class AnthillBlockEntity extends BlockEntity {
	private static final List<String> IGNORED_ANT_TAGS = Arrays.asList("Air", "ArmorDropChances", "ArmorItems", "Brain",
			"CanPickUpLoot", "DeathTime", "FallDistance", "FallFlying", "Fire", "HandDropChances", "HandItems",
			"HurtByTimestamp", "HurtTime", "LeftHanded", "Motion", "OnGround", "PortalCooldown", "Pos", "Rotation",
			"CooldownToEnterNest", "CooldownToLocateNest", "FailedForagingTime", "NestPos", "Passengers", "Leash", "UUID");
	private final List<AntData> storedAnts = new ArrayList<>();
	private final Map<BlockPos, UpgradeData> nestUpgrades = new HashMap<>();
	private AbstractAnt.Variant inhabitantVariant;
	private boolean hasQueen;

	public AnthillBlockEntity(BlockPos pos, BlockState state) {
		super(SBBlockEntities.ANTHILL.get(), pos, state);
		inhabitantVariant = null;
	}

	protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
		super.saveAdditional(tag, registries);
		tag.put("Ants", Occupant.LIST_CODEC.encodeStart(NbtOps.INSTANCE, getAnts()).getOrThrow());
		tag.put("Upgrades", writeUpgrades());
		if (getInhabitantVariant() != null) tag.putInt("InhabitantType", getInhabitantVariant().getId());
		tag.putBoolean("HasQueen", hasQueen);
	}

	private List<Occupant> getAnts() {
		return storedAnts.stream().map(AntData::toOccupant).toList();
	}

	public ListTag writeUpgrades() {
		ListTag listTag = new ListTag();

		for (UpgradeData data : nestUpgrades.values()) {
			CompoundTag tag = new CompoundTag();
			tag.putInt("UpgradeType", data.upgradeType);
			tag.put("BlockPos", NbtUtils.writeBlockPos(data.pos));
			listTag.add(tag);
		}
		return listTag;
	}

	public void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
		super.loadAdditional(tag, registries);
		storedAnts.clear();
		nestUpgrades.clear();
		ListTag upgradeList = tag.getList("Upgrades", 10);

		if (tag.contains("ants")) Occupant.LIST_CODEC.parse(NbtOps.INSTANCE, tag.get("ants")).resultOrPartial(s ->
				SlayersBeasts.LOGGER.error("Failed to parse Ants: {}", s)).ifPresent(list -> list.forEach(this::storeAnt));

		for (int j = 0; j < upgradeList.size(); ++j) {
			CompoundTag tag1 = upgradeList.getCompound(j);
			BlockPos pos = NbtUtils.readBlockPos(tag1, "BlockPos").orElse(null);
			UpgradeData data = new UpgradeData(tag1.getInt("UpgradeType"), pos);
			nestUpgrades.put(pos, data);
		}

		setInhabitantVariant(tag.contains("InhabitantType") ? AbstractAnt.Variant.byId(tag.getInt("InhabitantType")) : null);
		hasQueen = tag.getBoolean("HasQueen");
	}

	protected void applyImplicitComponents(BlockEntity.DataComponentInput componentInput) {
		super.applyImplicitComponents(componentInput);
		storedAnts.clear();
		List<Occupant> list = componentInput.getOrDefault(SBDataComponents.ANTS.get(), List.of());
		list.forEach(this::storeAnt);
	}

	protected void collectImplicitComponents(DataComponentMap.Builder components) {
		super.collectImplicitComponents(components);
		components.set(SBDataComponents.ANTS.get(), getAnts());
	}

	@SuppressWarnings("deprecation")
	public void removeComponentsFromTag(CompoundTag tag) {
		super.removeComponentsFromTag(tag);
		tag.remove("ants");
	}

	public static int getFungusLevel(BlockState state) {
		return state.getValue(AnthillBlock.FUNGUS_LEVEL);
	}
	public static int getSupplyLevel(BlockState state) {
		return state.getValue(AnthillBlock.SUPPLY_LEVEL);
	}

	public boolean isEmpty() {
		return storedAnts.isEmpty();
	}
	public boolean isFull() {
		return storedAnts.size() == 10;
	}

	public AbstractAnt.Variant getInhabitantVariant() {
		return inhabitantVariant;
	}

	public void setInhabitantVariant(AbstractAnt.Variant variant) {
		inhabitantVariant = variant;
	}

	public static void serverTick(Level level, BlockPos pos, BlockState blockState, AnthillBlockEntity entity) {
		tickOccupants(level, pos, blockState, entity.storedAnts);
		tickExpansionsAndUpgrades(level, pos, blockState, entity);
	}

	private static void tickOccupants(Level level, BlockPos pos, BlockState blockState, List<AntData> dataList) {
		boolean flag = false;
		Iterator<AntData> iterator = dataList.iterator();
		while (iterator.hasNext()) {
			AntData data = iterator.next();
			if (data.isQueen()) continue;
			if (data.tick()) {
				AntReleaseStatus releaseStatus = data.hasCargo() ? AntReleaseStatus.CARGO_DELIVERED : AntReleaseStatus.ANT_RELEASED;
				if (releaseOccupant(level, pos, blockState, data.toOccupant(), null, releaseStatus)) {
					flag = true;
					iterator.remove();
				}
			}
		}

		if (flag) setChanged(level, pos, blockState);
	}

	private static void tickExpansionsAndUpgrades(Level level, BlockPos pos, BlockState blockState, AnthillBlockEntity blockEntity) {
		if (level.getGameTime() % 200 == 0) {
			int blockType = 1;

			List<BlockPos> list = blockEntity.scanNest(level, pos, null, SBTags.Blocks.ANTHILLS);
			Set<BlockPos> set = blockEntity.nestUpgrades.keySet();

			for (BlockPos pos1 : list) set.remove(pos1);
			for (BlockPos pos1 : set) blockEntity.nestUpgrades.remove(pos1);
			if (!set.isEmpty()) blockEntity.emptyAntsFromNest(null, blockState, AntReleaseStatus.PATROLLING);

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
		List<BlockPos> posList = scanNest(level, nestPos, SBBlocks.ARIDISOL.get(), null);
		if (posList.isEmpty() || nestUpgrades.size() > 5) return;

		BlockPos blockPos = posList.get(level.random.nextInt(posList.size()));

		Block block = upgradeType == 1 ? SBBlocks.ANTHILL_HATCHERY.get() : SBBlocks.ARIDISOL.get();

		nestUpgrades.put(blockPos, new UpgradeData(upgradeType, blockPos));
		level.setBlock(nestPos, blockState.setValue(AnthillBlock.SUPPLY_LEVEL, getSupplyLevel(blockState) - 5), 3);
		level.setBlockAndUpdate(blockPos, block.defaultBlockState());
		setChanged(level, nestPos, blockState);
		if (level.getBlockEntity(blockPos) instanceof BaseAnthillBlockEntity blockEntity) {
			blockEntity.setParentNestPos(nestPos);
		}
	}

	private void expandNest(Level level, BlockPos nestPos, BlockState blockState) {
		List<BlockPos> posList = scanNest(level, nestPos, null, SBTags.Blocks.ANTHILL_REPLACEABLE);
		if (posList.isEmpty()) return;

		BlockPos blockPos = posList.get(level.random.nextInt(posList.size()));
		level.setBlockAndUpdate(blockPos, SBBlocks.ARIDISOL.get().defaultBlockState());
		level.setBlock(nestPos, blockState.setValue(AnthillBlock.SUPPLY_LEVEL, getSupplyLevel(blockState) - 3), 3);
		setChanged(level, nestPos, blockState);
	}

	private List<BlockPos> scanNest(Level level, BlockPos nestPos, Block block, TagKey<Block> blocks) {
		List<BlockPos> posList = new ArrayList<>();
		for (int y = 0; y > -4; y--) {
			int radius = y + 5;
			if (nestPos.getY() + y < level.getMinY()) break;

			for (int x = -radius; x <= radius; x++) {
				for (int z = -radius; z <= radius; z++) {
					BlockPos tempBlockPos = getBlockPos().offset(x, y, z);
					if ((x * x) + (z * z) <= (radius * radius) && !nestPos.equals(tempBlockPos)) {
						if (level.getBlockState(tempBlockPos).is(block) || level.getBlockState(tempBlockPos).is(blocks)) {
							posList.add(tempBlockPos);
						}
					}
				}
			}
		}
		return posList;
	}

	public void emptyAntsFromNest(Player player, BlockState blockState, AntReleaseStatus releaseStatus) {
		List<Entity> entities = releaseAllOccupants(blockState, releaseStatus);
		if (player != null) {
			for (Entity entity : entities) if (entity instanceof AbstractAnt ant) ant.setCooldownToEnterNest(400);
		}
		if (isEmpty()) setInhabitantVariant(null);
	}

	private List<Entity> releaseAllOccupants(BlockState state, AntReleaseStatus releaseStatus) {
		List<Entity> list = new ArrayList<>();
		if (level != null) {
			storedAnts.removeIf(data -> releaseOccupant(level, worldPosition, state, data.toOccupant(), list, releaseStatus));
		}
		if (!list.isEmpty()) {
			super.setChanged();
		}

		return list;
	}

	private static boolean releaseOccupant(Level level, BlockPos pos, BlockState state, Occupant occupant, List<Entity> storedInNest, AntReleaseStatus releaseStatus) {
		if (level.isRaining() && releaseStatus != AntReleaseStatus.EMERGENCY) return false;

		BlockPos above = pos.above();
		boolean flag = level.getBlockState(above).getCollisionShape(level, above).isEmpty();
		if (!flag && releaseStatus != AntReleaseStatus.EMERGENCY) return false;

//		CompoundTag compoundTag = occupant.entityData.copyTag();
//		removeIgnoredAntTags(compoundTag);
//		compoundTag.put("NestPos", NbtUtils.writeBlockPos(pos));

		Entity entity = occupant.createEntity(level, pos);
		if (entity == null) return false;
		if (!entity.getType().is(SBTags.EntityTypes.ANTHILL_INHABITANTS)) return false;
		if (releaseStatus == AntReleaseStatus.PATROLLING && !(entity instanceof AntSoldier)) return false;

		if (entity instanceof AbstractAnt ant) {

			if (releaseStatus == AntReleaseStatus.CARGO_DELIVERED) {
				int cargo = ant.getCargoType();
				ant.setCargoType(99);
				if (cargo == 1) {
					if (state.is(SBTags.Blocks.ANTHILLS, stateBase -> stateBase.hasProperty(AnthillBlock.FUNGUS_LEVEL))) {
						int i = getFungusLevel(state);
						if (i < 8) {
							level.setBlockAndUpdate(pos, state.setValue(AnthillBlock.FUNGUS_LEVEL, i + 1));
						}
					}
				} else if (cargo == 2) {
					if (state.is(SBTags.Blocks.ANTHILLS, stateBase -> stateBase.hasProperty(AnthillBlock.SUPPLY_LEVEL))) {
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

			double width = flag ? 0 : 0.55D + ant.getBbWidth() * 0.5D;
			ant.moveTo(pos.getX() + 0.5D + width, pos.getY() + 1D, pos.getZ() + 0.5D + width, ant.getYRot(), ant.getXRot());
		}

		level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(entity, level.getBlockState(pos)));
		return level.addFreshEntity(entity);
	}

	public void addOccupant(Entity entity, AbstractAnt.Variant variant) {
		setInhabitantVariant(variant);
		if (storedAnts.size() >= 10) return;
		entity.stopRiding();
		entity.ejectPassengers();
		CompoundTag tag = new CompoundTag();
		entity.save(tag);
		storeAnt(Occupant.of(entity));
		if (level != null) level.gameEvent(GameEvent.BLOCK_CHANGE, getBlockPos(), GameEvent.Context.of(entity, getBlockState()));

		entity.discard();
		super.setChanged();
	}

	public void storeAnt(Occupant occupant) {
		storedAnts.add(new AntData(occupant));
	}

	public record Occupant(CustomData entityData, int ticksInNest, int minTicksInNest, boolean isQueen) {
		public static final Codec<Occupant> CODEC = RecordCodecBuilder.create(instance -> instance.group(
				CustomData.CODEC.optionalFieldOf("entity_data", CustomData.EMPTY).forGetter(Occupant::entityData),
				Codec.INT.fieldOf("ticks_in_nest").forGetter(Occupant::ticksInNest),
				Codec.INT.fieldOf("min_ticks_in_nest").forGetter(Occupant::minTicksInNest),
				Codec.BOOL.fieldOf("is_queen").forGetter(Occupant::isQueen)
		).apply(instance, Occupant::new));
		public static final Codec<List<Occupant>> LIST_CODEC = CODEC.listOf();
		@SuppressWarnings("deprecation")
		public static final StreamCodec<ByteBuf, Occupant> STREAM_CODEC = StreamCodec.composite(CustomData.STREAM_CODEC, Occupant::entityData,
				ByteBufCodecs.VAR_INT, Occupant::ticksInNest, ByteBufCodecs.VAR_INT, Occupant::minTicksInNest, ByteBufCodecs.BOOL, Occupant::isQueen, Occupant::new);

		public static Occupant of(Entity entity) {
			CompoundTag tag = new CompoundTag();
			entity.save(tag);
			Objects.requireNonNull(tag);
			IGNORED_ANT_TAGS.forEach(tag::remove);
			boolean bl = tag.getBoolean("HasNectar");
			return new Occupant(CustomData.of(tag), 0, bl ? 2400 : 600, entity instanceof AntQueen);
		}

		public static Occupant create(int ticksInNest) {
			CompoundTag tag = new CompoundTag();
			tag.putString("id", BuiltInRegistries.ENTITY_TYPE.getKey(SBEntities.ANT_WORKER.get()).toString());
			return new Occupant(CustomData.of(tag), ticksInNest, 600, false);
		}

		public Entity createEntity(Level level, BlockPos pos) {
			CompoundTag tag = entityData.copyTag();
			Objects.requireNonNull(tag);
			IGNORED_ANT_TAGS.forEach(tag::remove);
			Entity entity = EntityType.loadEntityRecursive(tag, level, EntitySpawnReason.LOAD, entity1 -> entity1);
			if (entity != null && entity.getType().is(SBTags.EntityTypes.ANTHILL_INHABITANTS)) {
//				entity.setNoGravity(true);
				if (entity instanceof AbstractAnt ant) {
					ant.setNestPos(pos);
				}

				return entity;
			}
			return null;
		}

		public CustomData entityData() {
			return entityData;
		}

		public int ticksInNest() {
			return ticksInNest;
		}

		public int minTicksInNest() {
			return minTicksInNest;
		}
	}
	
	private static class AntData {
		private final Occupant occupant;
		private int ticksInNest;

		AntData(Occupant occupant) {
			this.occupant = occupant;
			this.ticksInNest = occupant.ticksInNest();
		}

		public boolean tick() {
			return ticksInNest++ > occupant.minTicksInNest();
		}

		public Occupant toOccupant() {
			return new Occupant(occupant.entityData(), ticksInNest, occupant.ticksInNest(), occupant.isQueen());
		}

		public boolean isQueen() {
			return occupant.isQueen();
		}

		@SuppressWarnings("deprecation")
		public boolean hasCargo() {
			return occupant.entityData().getUnsafe().getBoolean("HasCargo");
		}
	}

	record UpgradeData(int upgradeType, BlockPos pos) { }

	public enum AntReleaseStatus {
		CARGO_DELIVERED,
		ANT_RELEASED,
		PATROLLING,
		EMERGENCY
	}
}
