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
    public static final RegistryObject<Item> TIED_LEATHER = ITEMS.register("tied_leather",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SLAYERS_BEASTS_TAB)));
    public static final RegistryObject<Item> TANNED_LEATHER = ITEMS.register("tanned_leather",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SLAYERS_BEASTS_TAB)));
    public static final RegistryObject<Item> WITHERBONE = ITEMS.register("witherbone",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SLAYERS_BEASTS_TAB)));

    public static final RegistryObject<ForgeSpawnEggItem> MANTIS_SPAWN_EGG = ITEMS.register("mantis_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.MANTIS_ENTITY, 0x2f7f2f, 0xffff31,
                    new Item.Properties().tab(ModCreativeModeTab.SLAYERS_BEASTS_TAB)));
    public static final RegistryObject<ForgeSpawnEggItem> WITHER_SPIDER_SPAWN_EGG = ITEMS.register("wither_spider_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.WITHER_SPIDER_ENTITY, 0x3d0f0f, 0x171313,
                    new Item.Properties().tab(ModCreativeModeTab.SLAYERS_BEASTS_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
