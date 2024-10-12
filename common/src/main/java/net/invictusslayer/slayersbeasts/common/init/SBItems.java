package net.invictusslayer.slayersbeasts.common.init;

import dev.architectury.core.item.ArchitecturySpawnEggItem;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.entity.vehicle.SBBoatType;
import net.invictusslayer.slayersbeasts.common.item.CryptPortalItem;
import net.invictusslayer.slayersbeasts.common.item.SBFoods;
import net.invictusslayer.slayersbeasts.common.item.SBJukeboxSongs;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;

public class SBItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(SlayersBeasts.MOD_ID, Registries.ITEM);

	public static final RegistrySupplier<Item> MUSIC_DISC_INKISH = ITEMS.register("music_disc_inkish", () -> new Item(new Item.Properties().stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(SBJukeboxSongs.INKISH)));

	public static final RegistrySupplier<Item> JADE = ITEMS.register("jade", () -> new CryptPortalItem(new Item.Properties()));
	public static final RegistrySupplier<Item> JADE_SHARD = ITEMS.register("jade_shard", () -> new Item(new Item.Properties()));
	public static final RegistrySupplier<Item> CRYSTALLINE_WING = ITEMS.register("crystalline_wing", () -> new Item(new Item.Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> CRYSTALLINE_CLAW = ITEMS.register("crystalline_claw", () -> new Item(new Item.Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> CRYSTALLINE_CARAPACE = ITEMS.register("crystalline_carapace", () -> new Item(new Item.Properties().stacksTo(1)));

	public static final RegistrySupplier<Item> INSECT_WING = ITEMS.register("insect_wing", () -> new Item(new Item.Properties()));
	public static final RegistrySupplier<Item> INSECT_CLAW = ITEMS.register("insect_claw", () -> new Item(new Item.Properties()));
	public static final RegistrySupplier<Item> INSECT_EYE = ITEMS.register("insect_eye", () -> new Item(new Item.Properties().food(SBFoods.INSECT_EYE)));
	public static final RegistrySupplier<Item> INSECT_LEG = ITEMS.register("insect_leg", () -> new Item(new Item.Properties().food(SBFoods.INSECT_LEG)));
	public static final RegistrySupplier<Item> FRIED_INSECT_LEG = ITEMS.register("fried_insect_leg", () -> new Item(new Item.Properties().food(SBFoods.FRIED_INSECT_LEG)));

	public static final RegistrySupplier<Item> WITHERBONE = ITEMS.register("witherbone", () -> new Item(new Item.Properties()));
	public static final RegistrySupplier<Item> TIED_LEATHER = ITEMS.register("tied_leather", () -> new Item(new Item.Properties()));
	public static final RegistrySupplier<Item> TANNED_LEATHER = ITEMS.register("tanned_leather", () -> new Item(new Item.Properties()));

	public static final RegistrySupplier<Item> MUD_BALL = ITEMS.register("mud_ball", () -> new Item(new Item.Properties()));

	public static final RegistrySupplier<Item> MANTIS_SPAWN_EGG = ITEMS.register("mantis_spawn_egg", () -> new ArchitecturySpawnEggItem(SBEntities.MANTIS, 0x43df51, 0xecf171, new Item.Properties()));
	public static final RegistrySupplier<Item> ANT_WORKER_SPAWN_EGG = ITEMS.register("ant_worker_spawn_egg", () -> new ArchitecturySpawnEggItem(SBEntities.ANT_WORKER, 0xffffff, 0xffffff, new Item.Properties()));
	public static final RegistrySupplier<Item> ANT_SOLDIER_SPAWN_EGG = ITEMS.register("ant_soldier_spawn_egg", () -> new ArchitecturySpawnEggItem(SBEntities.ANT_SOLDIER, 0xffffff, 0xffffff, new Item.Properties()));
	public static final RegistrySupplier<Item> ANT_QUEEN_SPAWN_EGG = ITEMS.register("ant_queen_spawn_egg", () -> new ArchitecturySpawnEggItem(SBEntities.ANT_QUEEN, 0xffffff, 0xffffff, new Item.Properties()));
	public static final RegistrySupplier<Item> WITHER_SPIDER_SPAWN_EGG = ITEMS.register("wither_spider_spawn_egg", () -> new ArchitecturySpawnEggItem(SBEntities.WITHER_SPIDER, 0x3d0f0f, 0x171313, new Item.Properties()));
	public static final RegistrySupplier<Item> TYRACHNID_SPAWN_EGG = ITEMS.register("tyrachnid_spawn_egg", () -> new ArchitecturySpawnEggItem(SBEntities.TYRACHNID, 0x3d0f0f, 0xb34b05, new Item.Properties()));
	public static final RegistrySupplier<Item> DAMSELFLY_SPAWN_EGG = ITEMS.register("damselfly_spawn_egg", () -> new ArchitecturySpawnEggItem(SBEntities.DAMSELFLY, 0x4f1785, 0x4dcf29, new Item.Properties()));
	public static final RegistrySupplier<Item> ENT_SPAWN_EGG = ITEMS.register("ent_spawn_egg", () -> new ArchitecturySpawnEggItem(SBEntities.ENT_MEDIUM, 0xffffff, 0x71aa71, new Item.Properties()));
	public static final RegistrySupplier<Item> WUDU_SPAWN_EGG = ITEMS.register("wudu_spawn_egg", () -> new ArchitecturySpawnEggItem(SBEntities.WUDU, 0x917142, 0x4bb749, new Item.Properties()));
	public static final RegistrySupplier<Item> SPORETRAP_SPAWN_EGG = ITEMS.register("sporetrap_spawn_egg", () -> new ArchitecturySpawnEggItem(SBEntities.SPORETRAP, 0x2f7f2f, 0xffff31, new Item.Properties()));

	public static final RegistrySupplier<Item> ALGAE = ITEMS.register("algae", () -> new PlaceOnWaterBlockItem(SBBlocks.ALGAE.get(), new Item.Properties()));

	public static final RegistrySupplier<Item> ASPEN_SIGN = ITEMS.register("aspen_sign", () -> new SignItem(new Item.Properties().stacksTo(16), SBBlocks.ASPEN_SIGN.get(), SBBlocks.ASPEN_WALL_SIGN.get()));
	public static final RegistrySupplier<Item> ASPEN_HANGING_SIGN = ITEMS.register("aspen_hanging_sign", () -> new HangingSignItem(SBBlocks.ASPEN_HANGING_SIGN.get(), SBBlocks.ASPEN_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
	public static final RegistrySupplier<Item> ASPEN_BOAT = ITEMS.register("aspen_boat", () -> new BoatItem(false, SBBoatType.ASPEN, new Item.Properties()));
	public static final RegistrySupplier<Item> ASPEN_CHEST_BOAT = ITEMS.register("aspen_chest_boat", () -> new BoatItem(true, SBBoatType.ASPEN, new Item.Properties()));

	public static final RegistrySupplier<Item> DESERT_OAK_SIGN = ITEMS.register("desert_oak_sign", () -> new SignItem(new Item.Properties().stacksTo(16), SBBlocks.DESERT_OAK_SIGN.get(), SBBlocks.DESERT_OAK_WALL_SIGN.get()));
	public static final RegistrySupplier<Item> DESERT_OAK_HANGING_SIGN = ITEMS.register("desert_oak_hanging_sign", () -> new HangingSignItem(SBBlocks.DESERT_OAK_HANGING_SIGN.get(), SBBlocks.DESERT_OAK_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
	public static final RegistrySupplier<Item> DESERT_OAK_BOAT = ITEMS.register("desert_oak_boat", () -> new BoatItem(false, SBBoatType.DESERT_OAK, new Item.Properties()));
	public static final RegistrySupplier<Item> DESERT_OAK_CHEST_BOAT = ITEMS.register("desert_oak_chest_boat", () -> new BoatItem(true, SBBoatType.DESERT_OAK, new Item.Properties()));

	public static final RegistrySupplier<Item> EUCALYPTUS_SIGN = ITEMS.register("eucalyptus_sign", () -> new SignItem(new Item.Properties().stacksTo(16), SBBlocks.EUCALYPTUS_SIGN.get(), SBBlocks.EUCALYPTUS_WALL_SIGN.get()));
	public static final RegistrySupplier<Item> EUCALYPTUS_HANGING_SIGN = ITEMS.register("eucalyptus_hanging_sign", () -> new HangingSignItem(SBBlocks.EUCALYPTUS_HANGING_SIGN.get(), SBBlocks.EUCALYPTUS_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
	public static final RegistrySupplier<Item> EUCALYPTUS_BOAT = ITEMS.register("eucalyptus_boat", () -> new BoatItem(false, SBBoatType.EUCALYPTUS, new Item.Properties()));
	public static final RegistrySupplier<Item> EUCALYPTUS_CHEST_BOAT = ITEMS.register("eucalyptus_chest_boat", () -> new BoatItem(true, SBBoatType.EUCALYPTUS, new Item.Properties()));

	public static final RegistrySupplier<Item> KAPOK_SIGN = ITEMS.register("kapok_sign", () -> new SignItem(new Item.Properties().stacksTo(16), SBBlocks.KAPOK_SIGN.get(), SBBlocks.KAPOK_WALL_SIGN.get()));
	public static final RegistrySupplier<Item> KAPOK_HANGING_SIGN = ITEMS.register("kapok_hanging_sign", () -> new HangingSignItem(SBBlocks.KAPOK_HANGING_SIGN.get(), SBBlocks.KAPOK_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
	public static final RegistrySupplier<Item> KAPOK_BOAT = ITEMS.register("kapok_boat", () -> new BoatItem(false, SBBoatType.KAPOK, new Item.Properties()));
	public static final RegistrySupplier<Item> KAPOK_CHEST_BOAT = ITEMS.register("kapok_chest_boat", () -> new BoatItem(true, SBBoatType.KAPOK, new Item.Properties()));

	public static final RegistrySupplier<Item> REDWOOD_SIGN = ITEMS.register("redwood_sign", () -> new SignItem(new Item.Properties().stacksTo(16), SBBlocks.REDWOOD_SIGN.get(), SBBlocks.REDWOOD_WALL_SIGN.get()));
	public static final RegistrySupplier<Item> REDWOOD_HANGING_SIGN = ITEMS.register("redwood_hanging_sign", () -> new HangingSignItem(SBBlocks.REDWOOD_HANGING_SIGN.get(), SBBlocks.REDWOOD_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
	public static final RegistrySupplier<Item> REDWOOD_BOAT = ITEMS.register("redwood_boat", () -> new BoatItem(false, SBBoatType.REDWOOD, new Item.Properties()));
	public static final RegistrySupplier<Item> REDWOOD_CHEST_BOAT = ITEMS.register("redwood_chest_boat", () -> new BoatItem(true, SBBoatType.REDWOOD, new Item.Properties()));

	public static final RegistrySupplier<Item> WILLOW_SIGN = ITEMS.register("willow_sign", () -> new SignItem(new Item.Properties().stacksTo(16), SBBlocks.WILLOW_SIGN.get(), SBBlocks.WILLOW_WALL_SIGN.get()));
	public static final RegistrySupplier<Item> WILLOW_HANGING_SIGN = ITEMS.register("willow_hanging_sign", () -> new HangingSignItem(SBBlocks.WILLOW_HANGING_SIGN.get(), SBBlocks.WILLOW_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
	public static final RegistrySupplier<Item> WILLOW_BOAT = ITEMS.register("willow_boat", () -> new BoatItem(false, SBBoatType.WILLOW, new Item.Properties()));
	public static final RegistrySupplier<Item> WILLOW_CHEST_BOAT = ITEMS.register("willow_chest_boat", () -> new BoatItem(true, SBBoatType.WILLOW, new Item.Properties()));
}
