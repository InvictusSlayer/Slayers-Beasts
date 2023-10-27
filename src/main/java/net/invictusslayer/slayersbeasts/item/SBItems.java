package net.invictusslayer.slayersbeasts.item;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.entity.SBEntities;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class SBItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SlayersBeasts.MOD_ID);

    public static final RegistryObject<Item> JADE = ITEMS.register("jade", () -> new CryptPortalItem(new Item.Properties()));
    public static final RegistryObject<Item> JADE_SHARD = ITEMS.register("jade_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CRYSTALLINE_WING = ITEMS.register("crystalline_wing", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> CRYSTALLINE_CLAW = ITEMS.register("crystalline_claw", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> CRYSTALLINE_CARAPACE = ITEMS.register("crystalline_carapace", () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> INSECT_WING = ITEMS.register("insect_wing", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INSECT_CLAW = ITEMS.register("insect_claw", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INSECT_EYE = ITEMS.register("insect_eye", () -> new Item(new Item.Properties().food(SBFoods.INSECT_EYE)));
    public static final RegistryObject<Item> INSECT_LEG = ITEMS.register("insect_leg", () -> new Item(new Item.Properties().food(SBFoods.INSECT_LEG)));
    public static final RegistryObject<Item> FRIED_INSECT_LEG = ITEMS.register("fried_insect_leg", () -> new Item(new Item.Properties().food(SBFoods.FRIED_INSECT_LEG)));

    public static final RegistryObject<Item> WITHERBONE = ITEMS.register("witherbone", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TIED_LEATHER = ITEMS.register("tied_leather", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TANNED_LEATHER = ITEMS.register("tanned_leather", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MUD_BALL = ITEMS.register("mud_ball", () -> new Item(new Item.Properties()));

    public static final RegistryObject<ForgeSpawnEggItem> MANTIS_SPAWN_EGG = ITEMS.register("mantis_spawn_egg", () -> new ForgeSpawnEggItem(SBEntities.MANTIS, 0x43df51, 0xecf171, new Item.Properties()));
    public static final RegistryObject<ForgeSpawnEggItem> ANT_WORKER_SPAWN_EGG = ITEMS.register("ant_worker_spawn_egg", () -> new ForgeSpawnEggItem(SBEntities.ANT_WORKER, 0xffffff, 0xffffff, new Item.Properties()));
    public static final RegistryObject<ForgeSpawnEggItem> ANT_SOLDIER_SPAWN_EGG = ITEMS.register("ant_soldier_spawn_egg", () -> new ForgeSpawnEggItem(SBEntities.ANT_SOLDIER, 0xffffff, 0xffffff, new Item.Properties()));
    public static final RegistryObject<ForgeSpawnEggItem> ANT_QUEEN_SPAWN_EGG = ITEMS.register("ant_queen_spawn_egg", () -> new ForgeSpawnEggItem(SBEntities.ANT_QUEEN, 0xffffff, 0xffffff, new Item.Properties()));
    public static final RegistryObject<ForgeSpawnEggItem> WITHER_SPIDER_SPAWN_EGG = ITEMS.register("wither_spider_spawn_egg", () -> new ForgeSpawnEggItem(SBEntities.WITHER_SPIDER, 0x3d0f0f, 0x171313, new Item.Properties()));
    public static final RegistryObject<ForgeSpawnEggItem> TYRACHNID_SPAWN_EGG = ITEMS.register("tyrachnid_spawn_egg", () -> new ForgeSpawnEggItem(SBEntities.TYRACHNID, 0x3d0f0f, 0xb34b05, new Item.Properties()));
    public static final RegistryObject<ForgeSpawnEggItem> DAMSELFLY_SPAWN_EGG = ITEMS.register("damselfly_spawn_egg", () -> new ForgeSpawnEggItem(SBEntities.DAMSELFLY, 0x4f1785, 0x4dcf29, new Item.Properties()));
    public static final RegistryObject<ForgeSpawnEggItem> ENT_OAK_SPAWN_EGG = ITEMS.register("ent_oak_spawn_egg", () -> new ForgeSpawnEggItem(SBEntities.ENT_OAK, 0x6b3b1a, 0x126122, new Item.Properties()));
    public static final RegistryObject<ForgeSpawnEggItem> ENT_BIRCH_SPAWN_EGG = ITEMS.register("ent_birch_spawn_egg", () -> new ForgeSpawnEggItem(SBEntities.ENT_BIRCH, 0xbdc4b7, 0x1e7046, new Item.Properties()));
//    public static final RegistryObject<ForgeSpawnEggItem> VENUS_FLYTRAP_SPAWN_EGG = ITEMS.register("venus_flytrap_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.VENUS_FLYTRAP_ENTITY, 0x2f7f2f, 0xffff31, new Item.Properties()));
}
