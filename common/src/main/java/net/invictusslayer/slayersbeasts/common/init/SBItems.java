package net.invictusslayer.slayersbeasts.common.init;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.item.CryptPortalItem;
import net.invictusslayer.slayersbeasts.common.item.SBConsumables;
import net.invictusslayer.slayersbeasts.common.item.SBFoods;
import net.invictusslayer.slayersbeasts.common.item.SBJukeboxSongs;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;

import java.util.function.Supplier;

public class SBItems {
	public static final Supplier<Item> MUSIC_DISC_INKISH = register("music_disc_inkish", () -> new Item(new Item.Properties().setId(createKey("music_disc_inkish")).stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(SBJukeboxSongs.INKISH)));

	public static final Supplier<Item> JADE = register("jade", () -> new CryptPortalItem(new Item.Properties().setId(createKey("jade"))));
	public static final Supplier<Item> JADE_SHARD = register("jade_shard", () -> new Item(new Item.Properties().setId(createKey("jade_shard"))));
	public static final Supplier<Item> CRYSTALLINE_WING = register("crystalline_wing", () -> new Item(new Item.Properties().setId(createKey("crystalline_wing")).stacksTo(1)));
	public static final Supplier<Item> CRYSTALLINE_CLAW = register("crystalline_claw", () -> new Item(new Item.Properties().setId(createKey("crystalline_claw")).stacksTo(1)));
	public static final Supplier<Item> CRYSTALLINE_CARAPACE = register("crystalline_carapace", () -> new Item(new Item.Properties().setId(createKey("crystalline_carapace")).stacksTo(1)));

	public static final Supplier<Item> INSECT_WING = register("insect_wing", () -> new Item(new Item.Properties().setId(createKey("insect_wing"))));
	public static final Supplier<Item> INSECT_CLAW = register("insect_claw", () -> new Item(new Item.Properties().setId(createKey("insect_claw"))));
	public static final Supplier<Item> INSECT_EYE = register("insect_eye", () -> new Item(new Item.Properties().setId(createKey("insect_eye")).food(SBFoods.INSECT_EYE, SBConsumables.INSECT_EYE)));
	public static final Supplier<Item> INSECT_LEG = register("insect_leg", () -> new Item(new Item.Properties().setId(createKey("insect_leg")).food(SBFoods.INSECT_LEG)));
	public static final Supplier<Item> FRIED_INSECT_LEG = register("fried_insect_leg", () -> new Item(new Item.Properties().setId(createKey("fried_insect_leg")).food(SBFoods.FRIED_INSECT_LEG)));

	public static final Supplier<Item> WITHERBONE = register("witherbone", () -> new Item(new Item.Properties().setId(createKey("witherbone"))));
	public static final Supplier<Item> TIED_LEATHER = register("tied_leather", () -> new Item(new Item.Properties().setId(createKey("tied_leather"))));
	public static final Supplier<Item> TANNED_LEATHER = register("tanned_leather", () -> new Item(new Item.Properties().setId(createKey("tanned_leather"))));

	public static final Supplier<Item> MUD_BALL = register("mud_ball", () -> new Item(new Item.Properties().setId(createKey("mud_ball"))));

	public static final Supplier<Item> MANTIS_SPAWN_EGG = register("mantis_spawn_egg", () -> new SpawnEggItem(SBEntities.MANTIS.get(), new Item.Properties().setId(createKey("mantis_spawn_egg"))));
	public static final Supplier<Item> ANT_WORKER_SPAWN_EGG = register("ant_worker_spawn_egg", () -> new SpawnEggItem(SBEntities.ANT_WORKER.get(), new Item.Properties().setId(createKey("ant_worker_spawn_egg"))));
	public static final Supplier<Item> ANT_SOLDIER_SPAWN_EGG = register("ant_soldier_spawn_egg", () -> new SpawnEggItem(SBEntities.ANT_SOLDIER.get(), new Item.Properties().setId(createKey("ant_soldier_spawn_egg"))));
	public static final Supplier<Item> ANT_QUEEN_SPAWN_EGG = register("ant_queen_spawn_egg", () -> new SpawnEggItem(SBEntities.ANT_QUEEN.get(), new Item.Properties().setId(createKey("ant_queen_spawn_egg"))));
	public static final Supplier<Item> WITHER_SPIDER_SPAWN_EGG = register("wither_spider_spawn_egg", () -> new SpawnEggItem(SBEntities.WITHER_SPIDER.get(), new Item.Properties().setId(createKey("wither_spider_spawn_egg"))));
	public static final Supplier<Item> TYRACHNID_SPAWN_EGG = register("tyrachnid_spawn_egg", () -> new SpawnEggItem(SBEntities.TYRACHNID.get(), new Item.Properties().setId(createKey("tyrachnid_spawn_egg"))));
	public static final Supplier<Item> DAMSELFLY_SPAWN_EGG = register("damselfly_spawn_egg", () -> new SpawnEggItem(SBEntities.DAMSELFLY.get(), new Item.Properties().setId(createKey("damselfly_spawn_egg"))));
	public static final Supplier<Item> ENT_SPAWN_EGG = register("ent_spawn_egg", () -> new SpawnEggItem(SBEntities.ENT_MEDIUM.get(), new Item.Properties().setId(createKey("ent_spawn_egg"))));
	public static final Supplier<Item> WUDU_SPAWN_EGG = register("wudu_spawn_egg", () -> new SpawnEggItem(SBEntities.WUDU.get(), new Item.Properties().setId(createKey("wudu_spawn_egg"))));
	public static final Supplier<Item> SPORETRAP_SPAWN_EGG = register("sporetrap_spawn_egg", () -> new SpawnEggItem(SBEntities.SPORETRAP.get(), new Item.Properties().setId(createKey("sporetrap_spawn_egg"))));

	public static final Supplier<Item> ASPEN_SIGN = register("aspen_sign", () -> new SignItem(SBBlocks.ASPEN_SIGN.get(), SBBlocks.ASPEN_WALL_SIGN.get(), new Item.Properties().setId(createKey("aspen_sign")).stacksTo(16)));
	public static final Supplier<Item> ASPEN_HANGING_SIGN = register("aspen_hanging_sign", () -> new HangingSignItem(SBBlocks.ASPEN_HANGING_SIGN.get(), SBBlocks.ASPEN_WALL_HANGING_SIGN.get(), new Item.Properties().setId(createKey("aspen_hanging_sign")).stacksTo(16)));
	public static final Supplier<Item> ASPEN_BOAT = register("aspen_boat", () -> new BoatItem(SBEntities.ASPEN_BOAT.get(), new Item.Properties().setId(createKey("aspen_boat")).stacksTo(1)));
	public static final Supplier<Item> ASPEN_CHEST_BOAT = register("aspen_chest_boat", () -> new BoatItem(SBEntities.ASPEN_CHEST_BOAT.get(), new Item.Properties().setId(createKey("aspen_chest_boat")).stacksTo(1)));

	public static final Supplier<Item> BLOODWOOD_SIGN = register("bloodwood_sign", () -> new SignItem(SBBlocks.BLOODWOOD_SIGN.get(), SBBlocks.BLOODWOOD_WALL_SIGN.get(), new Item.Properties().setId(createKey("bloodwood_sign")).stacksTo(16)));
	public static final Supplier<Item> BLOODWOOD_HANGING_SIGN = register("bloodwood_hanging_sign", () -> new HangingSignItem(SBBlocks.BLOODWOOD_HANGING_SIGN.get(), SBBlocks.BLOODWOOD_WALL_HANGING_SIGN.get(), new Item.Properties().setId(createKey("bloodwood_hanging_sign")).stacksTo(16)));
	public static final Supplier<Item> BLOODWOOD_BOAT = register("bloodwood_boat", () -> new BoatItem(SBEntities.BLOODWOOD_BOAT.get(), new Item.Properties().setId(createKey("bloodwood_boat")).stacksTo(1)));
	public static final Supplier<Item> BLOODWOOD_CHEST_BOAT = register("bloodwood_chest_boat", () -> new BoatItem(SBEntities.BLOODWOOD_CHEST_BOAT.get(), new Item.Properties().setId(createKey("bloodwood_chest_boat")).stacksTo(1)));

	public static final Supplier<Item> CYPRESS_SIGN = register("cypress_sign", () -> new SignItem(SBBlocks.CYPRESS_SIGN.get(), SBBlocks.CYPRESS_WALL_SIGN.get(), new Item.Properties().setId(createKey("cypress_sign")).stacksTo(16)));
	public static final Supplier<Item> CYPRESS_HANGING_SIGN = register("cypress_hanging_sign", () -> new HangingSignItem(SBBlocks.CYPRESS_HANGING_SIGN.get(), SBBlocks.CYPRESS_WALL_HANGING_SIGN.get(), new Item.Properties().setId(createKey("cypress_hanging_sign")).stacksTo(16)));
	public static final Supplier<Item> CYPRESS_BOAT = register("cypress_boat", () -> new BoatItem(SBEntities.CYPRESS_BOAT.get(), new Item.Properties().setId(createKey("cypress_boat")).stacksTo(1)));
	public static final Supplier<Item> CYPRESS_CHEST_BOAT = register("cypress_chest_boat", () -> new BoatItem(SBEntities.CYPRESS_CHEST_BOAT.get(), new Item.Properties().setId(createKey("cypress_chest_boat")).stacksTo(1)));

	public static final Supplier<Item> DESERT_OAK_SIGN = register("desert_oak_sign", () -> new SignItem(SBBlocks.DESERT_OAK_SIGN.get(), SBBlocks.DESERT_OAK_WALL_SIGN.get(), new Item.Properties().setId(createKey("desert_oak_sign")).stacksTo(16)));
	public static final Supplier<Item> DESERT_OAK_HANGING_SIGN = register("desert_oak_hanging_sign", () -> new HangingSignItem(SBBlocks.DESERT_OAK_HANGING_SIGN.get(), SBBlocks.DESERT_OAK_WALL_HANGING_SIGN.get(), new Item.Properties().setId(createKey("desert_oak_hanging_sign")).stacksTo(16)));
	public static final Supplier<Item> DESERT_OAK_BOAT = register("desert_oak_boat", () -> new BoatItem(SBEntities.DESERT_OAK_BOAT.get(), new Item.Properties().setId(createKey("desert_oak_boat")).stacksTo(1)));
	public static final Supplier<Item> DESERT_OAK_CHEST_BOAT = register("desert_oak_chest_boat", () -> new BoatItem(SBEntities.DESERT_OAK_CHEST_BOAT.get(), new Item.Properties().setId(createKey("desert_oak_chest_boat")).stacksTo(1)));

	public static final Supplier<Item> EUCALYPTUS_SIGN = register("eucalyptus_sign", () -> new SignItem(SBBlocks.EUCALYPTUS_SIGN.get(), SBBlocks.EUCALYPTUS_WALL_SIGN.get(), new Item.Properties().setId(createKey("eucalyptus_sign")).stacksTo(16)));
	public static final Supplier<Item> EUCALYPTUS_HANGING_SIGN = register("eucalyptus_hanging_sign", () -> new HangingSignItem(SBBlocks.EUCALYPTUS_HANGING_SIGN.get(), SBBlocks.EUCALYPTUS_WALL_HANGING_SIGN.get(), new Item.Properties().setId(createKey("eucalyptus_hanging_sign")).stacksTo(16)));
	public static final Supplier<Item> EUCALYPTUS_BOAT = register("eucalyptus_boat", () -> new BoatItem(SBEntities.EUCALYPTUS_BOAT.get(), new Item.Properties().setId(createKey("eucalyptus_boat")).stacksTo(1)));
	public static final Supplier<Item> EUCALYPTUS_CHEST_BOAT = register("eucalyptus_chest_boat", () -> new BoatItem(SBEntities.EUCALYPTUS_CHEST_BOAT.get(), new Item.Properties().setId(createKey("eucalyptus_chest_boat")).stacksTo(1)));

	public static final Supplier<Item> KAPOK_SIGN = register("kapok_sign", () -> new SignItem(SBBlocks.KAPOK_SIGN.get(), SBBlocks.KAPOK_WALL_SIGN.get(), new Item.Properties().setId(createKey("kapok_sign")).stacksTo(16)));
	public static final Supplier<Item> KAPOK_HANGING_SIGN = register("kapok_hanging_sign", () -> new HangingSignItem(SBBlocks.KAPOK_HANGING_SIGN.get(), SBBlocks.KAPOK_WALL_HANGING_SIGN.get(), new Item.Properties().setId(createKey("kapok_hanging_sign")).stacksTo(16)));
	public static final Supplier<Item> KAPOK_BOAT = register("kapok_boat", () -> new BoatItem(SBEntities.KAPOK_BOAT.get(), new Item.Properties().setId(createKey("kapok_boat")).stacksTo(1)));
	public static final Supplier<Item> KAPOK_CHEST_BOAT = register("kapok_chest_boat", () -> new BoatItem(SBEntities.KAPOK_CHEST_BOAT.get(), new Item.Properties().setId(createKey("kapok_chest_boat")).stacksTo(1)));

	public static final Supplier<Item> REDWOOD_SIGN = register("redwood_sign", () -> new SignItem(SBBlocks.REDWOOD_SIGN.get(), SBBlocks.REDWOOD_WALL_SIGN.get(), new Item.Properties().setId(createKey("redwood_sign")).stacksTo(16)));
	public static final Supplier<Item> REDWOOD_HANGING_SIGN = register("redwood_hanging_sign", () -> new HangingSignItem(SBBlocks.REDWOOD_HANGING_SIGN.get(), SBBlocks.REDWOOD_WALL_HANGING_SIGN.get(), new Item.Properties().setId(createKey("redwood_hanging_sign")).stacksTo(16)));
	public static final Supplier<Item> REDWOOD_BOAT = register("redwood_boat", () -> new BoatItem(SBEntities.REDWOOD_BOAT.get(), new Item.Properties().setId(createKey("redwood_boat")).stacksTo(1)));
	public static final Supplier<Item> REDWOOD_CHEST_BOAT = register("redwood_chest_boat", () -> new BoatItem(SBEntities.REDWOOD_CHEST_BOAT.get(), new Item.Properties().setId(createKey("redwood_chest_boat")).stacksTo(1)));

	public static final Supplier<Item> WILLOW_SIGN = register("willow_sign", () -> new SignItem(SBBlocks.WILLOW_SIGN.get(), SBBlocks.WILLOW_WALL_SIGN.get(), new Item.Properties().setId(createKey("willow_sign")).stacksTo(16)));
	public static final Supplier<Item> WILLOW_HANGING_SIGN = register("willow_hanging_sign", () -> new HangingSignItem(SBBlocks.WILLOW_HANGING_SIGN.get(), SBBlocks.WILLOW_WALL_HANGING_SIGN.get(), new Item.Properties().setId(createKey("willow_hanging_sign")).stacksTo(16)));
	public static final Supplier<Item> WILLOW_BOAT = register("willow_boat", () -> new BoatItem(SBEntities.WILLOW_BOAT.get(), new Item.Properties().setId(createKey("willow_boat")).stacksTo(1)));
	public static final Supplier<Item> WILLOW_CHEST_BOAT = register("willow_chest_boat", () -> new BoatItem(SBEntities.WILLOW_CHEST_BOAT.get(), new Item.Properties().setId(createKey("willow_chest_boat")).stacksTo(1)));

	static <T extends Item> Supplier<T> register(String name, Supplier<T> supplier) {
		return SlayersBeasts.PLATFORM.register(BuiltInRegistries.ITEM, name, supplier);
	}

	private static ResourceKey<Item> createKey(String path) {
		return ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, path));
	}

	public static void register() {
		SlayersBeasts.LOGGER.info("Registering SBItems...");
	}
}
