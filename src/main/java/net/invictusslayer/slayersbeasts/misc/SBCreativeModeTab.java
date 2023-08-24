package net.invictusslayer.slayersbeasts.misc;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.SBBlocks;
import net.invictusslayer.slayersbeasts.item.SBItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = SlayersBeasts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class SBCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SlayersBeasts.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SLAYERS_BEASTS_TAB = CREATIVE_MODE_TABS.register("slayers_beasts_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(SBBlocks.REDWOOD_SAPLING.get())).title(Component.translatable("creativemodetab.slayers_beasts_tab"))
                    .displayItems(((display, tab) -> {
                        tab.accept(SBItems.JADE.get());
                        tab.accept(SBItems.JADE_SHARD.get());
                        tab.accept(SBItems.CRYSTALLINE_WING.get());
                        tab.accept(SBItems.CRYSTALLINE_CLAW.get());
                        tab.accept(SBItems.CRYSTALLINE_CARAPACE.get());
                        tab.accept(SBItems.INSECT_WING.get());
                        tab.accept(SBItems.INSECT_CLAW.get());
                        tab.accept(SBItems.INSECT_EYE.get());
                        tab.accept(SBItems.INSECT_LEG.get());
                        tab.accept(SBItems.FRIED_INSECT_LEG.get());
                        tab.accept(SBItems.WITHERBONE.get());
                        tab.accept(SBItems.TIED_LEATHER.get());
                        tab.accept(SBItems.TANNED_LEATHER.get());
                        tab.accept(SBItems.MUD_BALL.get());

                        tab.accept(SBBlocks.CRYPTALITH.get());
                        tab.accept(SBBlocks.INFUSED_CRYPTALITH.get());
                        tab.accept(SBBlocks.DEPLETED_CRYPTALITH.get());
                        tab.accept(SBBlocks.JADE_BLOCK.get());
                        tab.accept(SBBlocks.EXOSKELETON_ORE.get());
                        tab.accept(SBBlocks.DEEPSLATE_EXOSKELETON_ORE.get());

                        tab.accept(SBBlocks.OOTHECA.get());
                        tab.accept(SBBlocks.ANT_SOIL.get());
                        tab.accept(SBBlocks.ANTHILL.get());
                        tab.accept(SBBlocks.ANTHILL_HATCHERY.get());
                        tab.accept(SBBlocks.ICICLE.get());
                        tab.accept(SBBlocks.TALL_DEAD_BUSH.get());
                        tab.accept(SBBlocks.CRACKED_MUD.get());
                        tab.accept(SBBlocks.PEAT.get());

                        tab.accept(SBBlocks.PEGMATITE.get());
                        tab.accept(SBBlocks.PEGMATITE_SLAB.get());
                        tab.accept(SBBlocks.PEGMATITE_STAIRS.get());
                        tab.accept(SBBlocks.PEGMATITE_WALL.get());
                        tab.accept(SBBlocks.POLISHED_PEGMATITE.get());
                        tab.accept(SBBlocks.POLISHED_PEGMATITE_SLAB.get());
                        tab.accept(SBBlocks.POLISHED_PEGMATITE_STAIRS.get());

                        tab.accept(SBBlocks.BLACK_SAND.get());
                        tab.accept(SBBlocks.BLACK_SANDSTONE.get());
                        tab.accept(SBBlocks.BLACK_SANDSTONE_SLAB.get());
                        tab.accept(SBBlocks.BLACK_SANDSTONE_STAIRS.get());
                        tab.accept(SBBlocks.BLACK_SANDSTONE_WALL.get());
                        tab.accept(SBBlocks.SMOOTH_BLACK_SANDSTONE.get());
                        tab.accept(SBBlocks.SMOOTH_BLACK_SANDSTONE_SLAB.get());
                        tab.accept(SBBlocks.SMOOTH_BLACK_SANDSTONE_STAIRS.get());
                        tab.accept(SBBlocks.CUT_BLACK_SANDSTONE.get());
                        tab.accept(SBBlocks.CUT_BLACK_SANDSTONE_SLAB.get());
                        tab.accept(SBBlocks.CHISELED_BLACK_SANDSTONE.get());

                        tab.accept(SBBlocks.WHITE_MUSHROOM_BLOCK.get());
                        tab.accept(SBBlocks.WHITE_MUSHROOM.get());

                        tab.accept(SBBlocks.ASPEN_LOG.get());
                        tab.accept(SBBlocks.STRIPPED_ASPEN_LOG.get());
                        tab.accept(SBBlocks.ASPEN_WOOD.get());
                        tab.accept(SBBlocks.STRIPPED_ASPEN_WOOD.get());
                        tab.accept(SBBlocks.ASPEN_LEAVES.get());
                        tab.accept(SBBlocks.ASPEN_SAPLING.get());
                        tab.accept(SBBlocks.ASPEN_PLANKS.get());
                        tab.accept(SBBlocks.ASPEN_SLAB.get());
                        tab.accept(SBBlocks.ASPEN_STAIRS.get());
                        tab.accept(SBBlocks.ASPEN_FENCE.get());
                        tab.accept(SBBlocks.ASPEN_FENCE_GATE.get());
                        tab.accept(SBBlocks.ASPEN_DOOR.get());
                        tab.accept(SBBlocks.ASPEN_TRAPDOOR.get());

                        tab.accept(SBBlocks.CAJOLE_LOG.get());
                        tab.accept(SBBlocks.STRIPPED_CAJOLE_LOG.get());
                        tab.accept(SBBlocks.CAJOLE_WOOD.get());
                        tab.accept(SBBlocks.STRIPPED_CAJOLE_WOOD.get());
                        tab.accept(SBBlocks.CAJOLE_LEAVES.get());
                        tab.accept(SBBlocks.CAJOLE_SAPLING.get());
                        tab.accept(SBBlocks.CAJOLE_PLANKS.get());
                        tab.accept(SBBlocks.CAJOLE_SLAB.get());
                        tab.accept(SBBlocks.CAJOLE_STAIRS.get());
                        tab.accept(SBBlocks.CAJOLE_FENCE.get());
                        tab.accept(SBBlocks.CAJOLE_FENCE_GATE.get());
                        tab.accept(SBBlocks.CAJOLE_DOOR.get());
                        tab.accept(SBBlocks.CAJOLE_TRAPDOOR.get());

                        tab.accept(SBBlocks.DESERT_OAK_LOG.get());
                        tab.accept(SBBlocks.STRIPPED_DESERT_OAK_LOG.get());
                        tab.accept(SBBlocks.DESERT_OAK_WOOD.get());
                        tab.accept(SBBlocks.STRIPPED_DESERT_OAK_WOOD.get());
                        tab.accept(SBBlocks.DESERT_OAK_LEAVES.get());
                        tab.accept(SBBlocks.DESERT_OAK_SAPLING.get());
                        tab.accept(SBBlocks.DESERT_OAK_PLANKS.get());
                        tab.accept(SBBlocks.DESERT_OAK_SLAB.get());
                        tab.accept(SBBlocks.DESERT_OAK_STAIRS.get());
                        tab.accept(SBBlocks.DESERT_OAK_FENCE.get());
                        tab.accept(SBBlocks.DESERT_OAK_FENCE_GATE.get());
                        tab.accept(SBBlocks.DESERT_OAK_DOOR.get());
                        tab.accept(SBBlocks.DESERT_OAK_TRAPDOOR.get());

                        tab.accept(SBBlocks.EUCALYPTUS_LOG.get());
                        tab.accept(SBBlocks.STRIPPED_EUCALYPTUS_LOG.get());
                        tab.accept(SBBlocks.EUCALYPTUS_WOOD.get());
                        tab.accept(SBBlocks.STRIPPED_EUCALYPTUS_WOOD.get());
                        tab.accept(SBBlocks.EUCALYPTUS_LEAVES.get());
                        tab.accept(SBBlocks.EUCALYPTUS_SAPLING.get());
                        tab.accept(SBBlocks.EUCALYPTUS_PLANKS.get());
                        tab.accept(SBBlocks.EUCALYPTUS_SLAB.get());
                        tab.accept(SBBlocks.EUCALYPTUS_STAIRS.get());
                        tab.accept(SBBlocks.EUCALYPTUS_FENCE.get());
                        tab.accept(SBBlocks.EUCALYPTUS_FENCE_GATE.get());
                        tab.accept(SBBlocks.EUCALYPTUS_DOOR.get());
                        tab.accept(SBBlocks.EUCALYPTUS_TRAPDOOR.get());

                        tab.accept(SBBlocks.KAPOK_LOG.get());
                        tab.accept(SBBlocks.STRIPPED_KAPOK_LOG.get());
                        tab.accept(SBBlocks.KAPOK_WOOD.get());
                        tab.accept(SBBlocks.STRIPPED_KAPOK_WOOD.get());
                        tab.accept(SBBlocks.KAPOK_LEAVES.get());
                        tab.accept(SBBlocks.KAPOK_SAPLING.get());
                        tab.accept(SBBlocks.KAPOK_PLANKS.get());
                        tab.accept(SBBlocks.KAPOK_SLAB.get());
                        tab.accept(SBBlocks.KAPOK_STAIRS.get());
                        tab.accept(SBBlocks.KAPOK_FENCE.get());
                        tab.accept(SBBlocks.KAPOK_FENCE_GATE.get());
                        tab.accept(SBBlocks.KAPOK_DOOR.get());
                        tab.accept(SBBlocks.KAPOK_TRAPDOOR.get());

                        tab.accept(SBBlocks.REDWOOD_LOG.get());
                        tab.accept(SBBlocks.STRIPPED_REDWOOD_LOG.get());
                        tab.accept(SBBlocks.REDWOOD_WOOD.get());
                        tab.accept(SBBlocks.STRIPPED_REDWOOD_WOOD.get());
                        tab.accept(SBBlocks.REDWOOD_LEAVES.get());
                        tab.accept(SBBlocks.REDWOOD_SAPLING.get());
                        tab.accept(SBBlocks.REDWOOD_PLANKS.get());
                        tab.accept(SBBlocks.REDWOOD_SLAB.get());
                        tab.accept(SBBlocks.REDWOOD_STAIRS.get());
                        tab.accept(SBBlocks.REDWOOD_FENCE.get());
                        tab.accept(SBBlocks.REDWOOD_FENCE_GATE.get());
                        tab.accept(SBBlocks.REDWOOD_DOOR.get());
                        tab.accept(SBBlocks.REDWOOD_TRAPDOOR.get());

                        tab.accept(SBBlocks.WILLOW_LOG.get());
                        tab.accept(SBBlocks.STRIPPED_WILLOW_LOG.get());
                        tab.accept(SBBlocks.WILLOW_WOOD.get());
                        tab.accept(SBBlocks.STRIPPED_WILLOW_WOOD.get());
                        tab.accept(SBBlocks.WILLOW_LEAVES.get());
                        tab.accept(SBBlocks.WILLOW_SAPLING.get());
                        tab.accept(SBBlocks.WILLOW_PLANKS.get());
                        tab.accept(SBBlocks.WILLOW_SLAB.get());
                        tab.accept(SBBlocks.WILLOW_STAIRS.get());
                        tab.accept(SBBlocks.WILLOW_FENCE.get());
                        tab.accept(SBBlocks.WILLOW_FENCE_GATE.get());
                        tab.accept(SBBlocks.WILLOW_DOOR.get());
                        tab.accept(SBBlocks.WILLOW_TRAPDOOR.get());
                        tab.accept(SBBlocks.WILLOW_BRANCH.get());

                        tab.accept(SBItems.MANTIS_SPAWN_EGG.get());
                        tab.accept(SBItems.WORKER_ANT_SPAWN_EGG.get());
                        tab.accept(SBItems.SOLDIER_ANT_SPAWN_EGG.get());
                        tab.accept(SBItems.QUEEN_ANT_SPAWN_EGG.get());
                        tab.accept(SBItems.DAMSELFLY_SPAWN_EGG.get());
                        tab.accept(SBItems.WITHER_SPIDER_SPAWN_EGG.get());
                    })).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
