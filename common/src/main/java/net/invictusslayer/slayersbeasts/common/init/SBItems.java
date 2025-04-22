package net.invictusslayer.slayersbeasts.common.init;

import dev.architectury.core.item.ArchitecturySpawnEggItem;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.item.CryptPortalItem;
import net.invictusslayer.slayersbeasts.common.item.SBConsumables;
import net.invictusslayer.slayersbeasts.common.item.SBFoods;
import net.invictusslayer.slayersbeasts.common.item.SBJukeboxSongs;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;

public class SBItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(SlayersBeasts.MOD_ID, Registries.ITEM);

	public static final RegistrySupplier<Item> MUSIC_DISC_INKISH = ITEMS.register("music_disc_inkish", () -> new Item(new Item.Properties().setId(createKey("music_disc_inkish")).stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(SBJukeboxSongs.INKISH)));

	public static final RegistrySupplier<Item> JADE = ITEMS.register("jade", () -> new CryptPortalItem(new Item.Properties().setId(createKey("jade"))));
	public static final RegistrySupplier<Item> JADE_SHARD = ITEMS.register("jade_shard", () -> new Item(new Item.Properties().setId(createKey("jade_shard"))));
	public static final RegistrySupplier<Item> CRYSTALLINE_WING = ITEMS.register("crystalline_wing", () -> new Item(new Item.Properties().setId(createKey("crystalline_wing")).stacksTo(1)));
	public static final RegistrySupplier<Item> CRYSTALLINE_CLAW = ITEMS.register("crystalline_claw", () -> new Item(new Item.Properties().setId(createKey("crystalline_claw")).stacksTo(1)));
	public static final RegistrySupplier<Item> CRYSTALLINE_CARAPACE = ITEMS.register("crystalline_carapace", () -> new Item(new Item.Properties().setId(createKey("crystalline_carapace")).stacksTo(1)));

	public static final RegistrySupplier<Item> INSECT_WING = ITEMS.register("insect_wing", () -> new Item(new Item.Properties().setId(createKey("insect_wing"))));
	public static final RegistrySupplier<Item> INSECT_CLAW = ITEMS.register("insect_claw", () -> new Item(new Item.Properties().setId(createKey("insect_claw"))));
	public static final RegistrySupplier<Item> INSECT_EYE = ITEMS.register("insect_eye", () -> new Item(new Item.Properties().setId(createKey("insect_eye")).food(SBFoods.INSECT_EYE, SBConsumables.INSECT_EYE)));
	public static final RegistrySupplier<Item> INSECT_LEG = ITEMS.register("insect_leg", () -> new Item(new Item.Properties().setId(createKey("insect_leg")).food(SBFoods.INSECT_LEG)));
	public static final RegistrySupplier<Item> FRIED_INSECT_LEG = ITEMS.register("fried_insect_leg", () -> new Item(new Item.Properties().setId(createKey("fried_insect_leg")).food(SBFoods.FRIED_INSECT_LEG)));

	public static final RegistrySupplier<Item> WITHERBONE = ITEMS.register("witherbone", () -> new Item(new Item.Properties().setId(createKey("witherbone"))));
	public static final RegistrySupplier<Item> TIED_LEATHER = ITEMS.register("tied_leather", () -> new Item(new Item.Properties().setId(createKey("tied_leather"))));
	public static final RegistrySupplier<Item> TANNED_LEATHER = ITEMS.register("tanned_leather", () -> new Item(new Item.Properties().setId(createKey("tanned_leather"))));

	public static final RegistrySupplier<Item> MUD_BALL = ITEMS.register("mud_ball", () -> new Item(new Item.Properties().setId(createKey("mud_ball"))));

	public static final RegistrySupplier<Item> MANTIS_SPAWN_EGG = ITEMS.register("mantis_spawn_egg", () -> new ArchitecturySpawnEggItem(SBEntities.MANTIS, new Item.Properties().setId(createKey("mantis_spawn_egg"))));
	public static final RegistrySupplier<Item> ANT_WORKER_SPAWN_EGG = ITEMS.register("ant_worker_spawn_egg", () -> new ArchitecturySpawnEggItem(SBEntities.ANT_WORKER, new Item.Properties().setId(createKey("ant_worker_spawn_egg"))));
	public static final RegistrySupplier<Item> ANT_SOLDIER_SPAWN_EGG = ITEMS.register("ant_soldier_spawn_egg", () -> new ArchitecturySpawnEggItem(SBEntities.ANT_SOLDIER, new Item.Properties().setId(createKey("ant_soldier_spawn_egg"))));
	public static final RegistrySupplier<Item> ANT_QUEEN_SPAWN_EGG = ITEMS.register("ant_queen_spawn_egg", () -> new ArchitecturySpawnEggItem(SBEntities.ANT_QUEEN, new Item.Properties().setId(createKey("ant_queen_spawn_egg"))));
	public static final RegistrySupplier<Item> WITHER_SPIDER_SPAWN_EGG = ITEMS.register("wither_spider_spawn_egg", () -> new ArchitecturySpawnEggItem(SBEntities.WITHER_SPIDER, new Item.Properties().setId(createKey("wither_spider_spawn_egg"))));
	public static final RegistrySupplier<Item> TYRACHNID_SPAWN_EGG = ITEMS.register("tyrachnid_spawn_egg", () -> new ArchitecturySpawnEggItem(SBEntities.TYRACHNID, new Item.Properties().setId(createKey("tyrachnid_spawn_egg"))));
	public static final RegistrySupplier<Item> DAMSELFLY_SPAWN_EGG = ITEMS.register("damselfly_spawn_egg", () -> new ArchitecturySpawnEggItem(SBEntities.DAMSELFLY, new Item.Properties().setId(createKey("damselfly_spawn_egg"))));
	public static final RegistrySupplier<Item> ENT_SPAWN_EGG = ITEMS.register("ent_spawn_egg", () -> new ArchitecturySpawnEggItem(SBEntities.ENT_MEDIUM, new Item.Properties().setId(createKey("ent_spawn_egg"))));
	public static final RegistrySupplier<Item> WUDU_SPAWN_EGG = ITEMS.register("wudu_spawn_egg", () -> new ArchitecturySpawnEggItem(SBEntities.WUDU, new Item.Properties().setId(createKey("wudu_spawn_egg"))));
	public static final RegistrySupplier<Item> SPORETRAP_SPAWN_EGG = ITEMS.register("sporetrap_spawn_egg", () -> new ArchitecturySpawnEggItem(SBEntities.SPORETRAP, new Item.Properties().setId(createKey("sporetrap_spawn_egg"))));

	public static final RegistrySupplier<Item> ALGAE = ITEMS.register("algae", () -> new PlaceOnWaterBlockItem(SBBlocks.ALGAE.get(), new Item.Properties().setId(createKey("algae"))));

	public static final RegistrySupplier<Item> ASPEN_SIGN = ITEMS.register("aspen_sign", () -> new SignItem(SBBlocks.ASPEN_SIGN.get(), SBBlocks.ASPEN_WALL_SIGN.get(), new Item.Properties().setId(createKey("aspen_sign")).stacksTo(16)));
	public static final RegistrySupplier<Item> ASPEN_HANGING_SIGN = ITEMS.register("aspen_hanging_sign", () -> new HangingSignItem(SBBlocks.ASPEN_HANGING_SIGN.get(), SBBlocks.ASPEN_WALL_HANGING_SIGN.get(), new Item.Properties().setId(createKey("aspen_hanging_sign")).stacksTo(16)));
	public static final RegistrySupplier<Item> ASPEN_BOAT = ITEMS.register("aspen_boat", () -> new BoatItem(SBEntities.ASPEN_BOAT.get(), new Item.Properties().setId(createKey("aspen_boat")).stacksTo(1)));
	public static final RegistrySupplier<Item> ASPEN_CHEST_BOAT = ITEMS.register("aspen_chest_boat", () -> new BoatItem(SBEntities.ASPEN_CHEST_BOAT.get(), new Item.Properties().setId(createKey("aspen_chest_boat")).stacksTo(1)));

	public static final RegistrySupplier<Item> BLOODWOOD_SIGN = ITEMS.register("bloodwood_sign", () -> new SignItem(SBBlocks.BLOODWOOD_SIGN.get(), SBBlocks.BLOODWOOD_WALL_SIGN.get(), new Item.Properties().setId(createKey("bloodwood_sign")).stacksTo(16)));
	public static final RegistrySupplier<Item> BLOODWOOD_HANGING_SIGN = ITEMS.register("bloodwood_hanging_sign", () -> new HangingSignItem(SBBlocks.BLOODWOOD_HANGING_SIGN.get(), SBBlocks.BLOODWOOD_WALL_HANGING_SIGN.get(), new Item.Properties().setId(createKey("bloodwood_hanging_sign")).stacksTo(16)));
	public static final RegistrySupplier<Item> BLOODWOOD_BOAT = ITEMS.register("bloodwood_boat", () -> new BoatItem(SBEntities.BLOODWOOD_BOAT.get(), new Item.Properties().setId(createKey("bloodwood_boat")).stacksTo(1)));
	public static final RegistrySupplier<Item> BLOODWOOD_CHEST_BOAT = ITEMS.register("bloodwood_chest_boat", () -> new BoatItem(SBEntities.BLOODWOOD_CHEST_BOAT.get(), new Item.Properties().setId(createKey("bloodwood_chest_boat")).stacksTo(1)));

	public static final RegistrySupplier<Item> CYPRESS_SIGN = ITEMS.register("cypress_sign", () -> new SignItem(SBBlocks.CYPRESS_SIGN.get(), SBBlocks.CYPRESS_WALL_SIGN.get(), new Item.Properties().setId(createKey("cypress_sign")).stacksTo(16)));
	public static final RegistrySupplier<Item> CYPRESS_HANGING_SIGN = ITEMS.register("cypress_hanging_sign", () -> new HangingSignItem(SBBlocks.CYPRESS_HANGING_SIGN.get(), SBBlocks.CYPRESS_WALL_HANGING_SIGN.get(), new Item.Properties().setId(createKey("cypress_hanging_sign")).stacksTo(16)));
	public static final RegistrySupplier<Item> CYPRESS_BOAT = ITEMS.register("cypress_boat", () -> new BoatItem(SBEntities.CYPRESS_BOAT.get(), new Item.Properties().setId(createKey("cypress_boat")).stacksTo(1)));
	public static final RegistrySupplier<Item> CYPRESS_CHEST_BOAT = ITEMS.register("cypress_chest_boat", () -> new BoatItem(SBEntities.CYPRESS_CHEST_BOAT.get(), new Item.Properties().setId(createKey("cypress_chest_boat")).stacksTo(1)));

	public static final RegistrySupplier<Item> DESERT_OAK_SIGN = ITEMS.register("desert_oak_sign", () -> new SignItem(SBBlocks.DESERT_OAK_SIGN.get(), SBBlocks.DESERT_OAK_WALL_SIGN.get(), new Item.Properties().setId(createKey("desert_oak_sign")).stacksTo(16)));
	public static final RegistrySupplier<Item> DESERT_OAK_HANGING_SIGN = ITEMS.register("desert_oak_hanging_sign", () -> new HangingSignItem(SBBlocks.DESERT_OAK_HANGING_SIGN.get(), SBBlocks.DESERT_OAK_WALL_HANGING_SIGN.get(), new Item.Properties().setId(createKey("desert_oak_hanging_sign")).stacksTo(16)));
	public static final RegistrySupplier<Item> DESERT_OAK_BOAT = ITEMS.register("desert_oak_boat", () -> new BoatItem(SBEntities.DESERT_OAK_BOAT.get(), new Item.Properties().setId(createKey("desert_oak_boat")).stacksTo(1)));
	public static final RegistrySupplier<Item> DESERT_OAK_CHEST_BOAT = ITEMS.register("desert_oak_chest_boat", () -> new BoatItem(SBEntities.DESERT_OAK_CHEST_BOAT.get(), new Item.Properties().setId(createKey("desert_oak_chest_boat")).stacksTo(1)));

	public static final RegistrySupplier<Item> EUCALYPTUS_SIGN = ITEMS.register("eucalyptus_sign", () -> new SignItem(SBBlocks.EUCALYPTUS_SIGN.get(), SBBlocks.EUCALYPTUS_WALL_SIGN.get(), new Item.Properties().setId(createKey("eucalyptus_sign")).stacksTo(16)));
	public static final RegistrySupplier<Item> EUCALYPTUS_HANGING_SIGN = ITEMS.register("eucalyptus_hanging_sign", () -> new HangingSignItem(SBBlocks.EUCALYPTUS_HANGING_SIGN.get(), SBBlocks.EUCALYPTUS_WALL_HANGING_SIGN.get(), new Item.Properties().setId(createKey("eucalyptus_hanging_sign")).stacksTo(16)));
	public static final RegistrySupplier<Item> EUCALYPTUS_BOAT = ITEMS.register("eucalyptus_boat", () -> new BoatItem(SBEntities.EUCALYPTUS_BOAT.get(), new Item.Properties().setId(createKey("eucalyptus_boat")).stacksTo(1)));
	public static final RegistrySupplier<Item> EUCALYPTUS_CHEST_BOAT = ITEMS.register("eucalyptus_chest_boat", () -> new BoatItem(SBEntities.EUCALYPTUS_CHEST_BOAT.get(), new Item.Properties().setId(createKey("eucalyptus_chest_boat")).stacksTo(1)));

	public static final RegistrySupplier<Item> KAPOK_SIGN = ITEMS.register("kapok_sign", () -> new SignItem(SBBlocks.KAPOK_SIGN.get(), SBBlocks.KAPOK_WALL_SIGN.get(), new Item.Properties().setId(createKey("kapok_sign")).stacksTo(16)));
	public static final RegistrySupplier<Item> KAPOK_HANGING_SIGN = ITEMS.register("kapok_hanging_sign", () -> new HangingSignItem(SBBlocks.KAPOK_HANGING_SIGN.get(), SBBlocks.KAPOK_WALL_HANGING_SIGN.get(), new Item.Properties().setId(createKey("kapok_hanging_sign")).stacksTo(16)));
	public static final RegistrySupplier<Item> KAPOK_BOAT = ITEMS.register("kapok_boat", () -> new BoatItem(SBEntities.KAPOK_BOAT.get(), new Item.Properties().setId(createKey("kapok_boat")).stacksTo(1)));
	public static final RegistrySupplier<Item> KAPOK_CHEST_BOAT = ITEMS.register("kapok_chest_boat", () -> new BoatItem(SBEntities.KAPOK_CHEST_BOAT.get(), new Item.Properties().setId(createKey("kapok_chest_boat")).stacksTo(1)));

	public static final RegistrySupplier<Item> REDWOOD_SIGN = ITEMS.register("redwood_sign", () -> new SignItem(SBBlocks.REDWOOD_SIGN.get(), SBBlocks.REDWOOD_WALL_SIGN.get(), new Item.Properties().setId(createKey("redwood_sign")).stacksTo(16)));
	public static final RegistrySupplier<Item> REDWOOD_HANGING_SIGN = ITEMS.register("redwood_hanging_sign", () -> new HangingSignItem(SBBlocks.REDWOOD_HANGING_SIGN.get(), SBBlocks.REDWOOD_WALL_HANGING_SIGN.get(), new Item.Properties().setId(createKey("redwood_hanging_sign")).stacksTo(16)));
	public static final RegistrySupplier<Item> REDWOOD_BOAT = ITEMS.register("redwood_boat", () -> new BoatItem(SBEntities.REDWOOD_BOAT.get(), new Item.Properties().setId(createKey("redwood_boat")).stacksTo(1)));
	public static final RegistrySupplier<Item> REDWOOD_CHEST_BOAT = ITEMS.register("redwood_chest_boat", () -> new BoatItem(SBEntities.REDWOOD_CHEST_BOAT.get(), new Item.Properties().setId(createKey("redwood_chest_boat")).stacksTo(1)));

	public static final RegistrySupplier<Item> WILLOW_SIGN = ITEMS.register("willow_sign", () -> new SignItem(SBBlocks.WILLOW_SIGN.get(), SBBlocks.WILLOW_WALL_SIGN.get(), new Item.Properties().setId(createKey("willow_sign")).stacksTo(16)));
	public static final RegistrySupplier<Item> WILLOW_HANGING_SIGN = ITEMS.register("willow_hanging_sign", () -> new HangingSignItem(SBBlocks.WILLOW_HANGING_SIGN.get(), SBBlocks.WILLOW_WALL_HANGING_SIGN.get(), new Item.Properties().setId(createKey("willow_hanging_sign")).stacksTo(16)));
	public static final RegistrySupplier<Item> WILLOW_BOAT = ITEMS.register("willow_boat", () -> new BoatItem(SBEntities.WILLOW_BOAT.get(), new Item.Properties().setId(createKey("willow_boat")).stacksTo(1)));
	public static final RegistrySupplier<Item> WILLOW_CHEST_BOAT = ITEMS.register("willow_chest_boat", () -> new BoatItem(SBEntities.WILLOW_CHEST_BOAT.get(), new Item.Properties().setId(createKey("willow_chest_boat")).stacksTo(1)));

	private static ResourceKey<Item> createKey(String path) {
		return ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, path));
	}
}
