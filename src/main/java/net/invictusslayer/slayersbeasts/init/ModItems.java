package net.invictusslayer.slayersbeasts.init;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SlayersBeasts.MOD_ID);

    public static final RegistryObject<Item> JADE = ITEMS.register("jade",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SLAYERS_BEASTS_TAB).stacksTo(16)));
    public static final RegistryObject<Item> CRYSTALLINE_WING = ITEMS.register("crystalline_wing",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SLAYERS_BEASTS_TAB).stacksTo(1)));
    public static final RegistryObject<Item> CRYSTALLINE_CLAW = ITEMS.register("crystalline_claw",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SLAYERS_BEASTS_TAB).stacksTo(1)));
    public static final RegistryObject<Item> CRYSTALLINE_CARAPACE = ITEMS.register("crystalline_carapace",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SLAYERS_BEASTS_TAB).stacksTo(1)));

    public static final RegistryObject<Item> INSECT_WING = ITEMS.register("insect_wing",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SLAYERS_BEASTS_TAB)));
    public static final RegistryObject<Item> INSECT_CLAW = ITEMS.register("insect_claw",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SLAYERS_BEASTS_TAB)));
    public static final RegistryObject<Item> INSECT_EYE = ITEMS.register("insect_eye",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SLAYERS_BEASTS_TAB).food(ModFoods.INSECT_EYE)));
    public static final RegistryObject<Item> INSECT_LEG = ITEMS.register("insect_leg",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SLAYERS_BEASTS_TAB).food(ModFoods.INSECT_LEG)));
    public static final RegistryObject<Item> FRIED_INSECT_LEG = ITEMS.register("fried_insect_leg",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SLAYERS_BEASTS_TAB).food(ModFoods.FRIED_INSECT_LEG)));

    public static final RegistryObject<Item> WITHERBONE = ITEMS.register("witherbone",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SLAYERS_BEASTS_TAB)));
    public static final RegistryObject<Item> TIED_LEATHER = ITEMS.register("tied_leather",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SLAYERS_BEASTS_TAB)));
    public static final RegistryObject<Item> TANNED_LEATHER = ITEMS.register("tanned_leather",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SLAYERS_BEASTS_TAB)));

    public static final RegistryObject<ForgeSpawnEggItem> MANTIS_SPAWN_EGG = ITEMS.register("mantis_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.MANTIS_ENTITY, 0x43df51, 0xecf171,
                    new Item.Properties().tab(ModCreativeModeTab.SLAYERS_BEASTS_TAB)));
    public static final RegistryObject<ForgeSpawnEggItem> TINY_ANT_SPAWN_EGG = ITEMS.register("tiny_ant_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.TINY_ANT_ENTITY, 0x32420a, 0x1e260f,
                    new Item.Properties().tab(ModCreativeModeTab.SLAYERS_BEASTS_TAB)));
    public static final RegistryObject<ForgeSpawnEggItem> AMBIENT_DRAGONFLY_SPAWN_EGG = ITEMS.register("ambient_dragonfly_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.AMBIENT_DRAGONFLY_ENTITY, 0x4f1785, 0x4dcf29,
                    new Item.Properties().tab(ModCreativeModeTab.SLAYERS_BEASTS_TAB)));
    public static final RegistryObject<ForgeSpawnEggItem> VENUS_FLYTRAP_SPAWN_EGG = ITEMS.register("venus_flytrap_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.VENUS_FLYTRAP_ENTITY, 0x2f7f2f, 0xffff31,
                    new Item.Properties().tab(ModCreativeModeTab.SLAYERS_BEASTS_TAB)));
    public static final RegistryObject<ForgeSpawnEggItem> WITHER_SPIDER_SPAWN_EGG = ITEMS.register("wither_spider_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.WITHER_SPIDER_ENTITY, 0x3d0f0f, 0x171313,
                    new Item.Properties().tab(ModCreativeModeTab.SLAYERS_BEASTS_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
