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
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(SBItems.JADE.get());
                        pOutput.accept(SBItems.JADE_SHARD.get());
                        pOutput.accept(SBItems.CRYSTALLINE_WING.get());
                        pOutput.accept(SBItems.CRYSTALLINE_CLAW.get());
                        pOutput.accept(SBItems.CRYSTALLINE_CARAPACE.get());
                        pOutput.accept(SBItems.INSECT_WING.get());
                        pOutput.accept(SBItems.INSECT_CLAW.get());
                        pOutput.accept(SBItems.INSECT_EYE.get());
                        pOutput.accept(SBItems.INSECT_LEG.get());
                        pOutput.accept(SBItems.FRIED_INSECT_LEG.get());
                        pOutput.accept(SBItems.WITHERBONE.get());
                        pOutput.accept(SBItems.TIED_LEATHER.get());
                        pOutput.accept(SBItems.TANNED_LEATHER.get());
                        pOutput.accept(SBItems.MUD_BALL.get());

                        pOutput.accept(SBBlocks.JADE_BLOCK.get());
                        pOutput.accept(SBBlocks.EXOSKELETON_ORE.get());
                        pOutput.accept(SBBlocks.DEEPSLATE_EXOSKELETON_ORE.get());

                        pOutput.accept(SBBlocks.OOTHECA.get());
                        pOutput.accept(SBBlocks.ANT_SOIL.get());
                        pOutput.accept(SBBlocks.ANTHILL.get());
                        pOutput.accept(SBBlocks.ANTHILL_HATCHERY.get());
                        pOutput.accept(SBBlocks.ICICLE.get());
                        pOutput.accept(SBBlocks.CRACKED_MUD.get());
                        pOutput.accept(SBBlocks.PEAT.get());

                        pOutput.accept(SBBlocks.PEGMATITE.get());
                        pOutput.accept(SBBlocks.PEGMATITE_SLAB.get());
                        pOutput.accept(SBBlocks.PEGMATITE_STAIRS.get());
                        pOutput.accept(SBBlocks.PEGMATITE_WALL.get());
                        pOutput.accept(SBBlocks.POLISHED_PEGMATITE.get());
                        pOutput.accept(SBBlocks.POLISHED_PEGMATITE_SLAB.get());
                        pOutput.accept(SBBlocks.POLISHED_PEGMATITE_STAIRS.get());

                        pOutput.accept(SBBlocks.BLACK_SAND.get());
                        pOutput.accept(SBBlocks.BLACK_SANDSTONE.get());
                        pOutput.accept(SBBlocks.BLACK_SANDSTONE_SLAB.get());
                        pOutput.accept(SBBlocks.BLACK_SANDSTONE_STAIRS.get());
                        pOutput.accept(SBBlocks.BLACK_SANDSTONE_WALL.get());
                        pOutput.accept(SBBlocks.SMOOTH_BLACK_SANDSTONE.get());
                        pOutput.accept(SBBlocks.SMOOTH_BLACK_SANDSTONE_SLAB.get());
                        pOutput.accept(SBBlocks.SMOOTH_BLACK_SANDSTONE_STAIRS.get());
                        pOutput.accept(SBBlocks.CUT_BLACK_SANDSTONE.get());
                        pOutput.accept(SBBlocks.CUT_BLACK_SANDSTONE_SLAB.get());
                        pOutput.accept(SBBlocks.CHISELED_BLACK_SANDSTONE.get());

                        pOutput.accept(SBBlocks.WHITE_MUSHROOM_BLOCK.get());
                        pOutput.accept(SBBlocks.WHITE_MUSHROOM.get());

                        pOutput.accept(SBBlocks.ASPEN_LOG.get());
                        pOutput.accept(SBBlocks.STRIPPED_ASPEN_LOG.get());
                        pOutput.accept(SBBlocks.ASPEN_WOOD.get());
                        pOutput.accept(SBBlocks.STRIPPED_ASPEN_WOOD.get());
                        pOutput.accept(SBBlocks.ASPEN_LEAVES.get());
                        pOutput.accept(SBBlocks.ASPEN_SAPLING.get());
                        pOutput.accept(SBBlocks.ASPEN_PLANKS.get());
                        pOutput.accept(SBBlocks.ASPEN_SLAB.get());
                        pOutput.accept(SBBlocks.ASPEN_STAIRS.get());
                        pOutput.accept(SBBlocks.ASPEN_FENCE.get());
                        pOutput.accept(SBBlocks.ASPEN_FENCE_GATE.get());
                        pOutput.accept(SBBlocks.ASPEN_DOOR.get());
                        pOutput.accept(SBBlocks.ASPEN_TRAPDOOR.get());

                        pOutput.accept(SBBlocks.CAJOLE_LOG.get());
                        pOutput.accept(SBBlocks.STRIPPED_CAJOLE_LOG.get());
                        pOutput.accept(SBBlocks.CAJOLE_WOOD.get());
                        pOutput.accept(SBBlocks.STRIPPED_CAJOLE_WOOD.get());
                        pOutput.accept(SBBlocks.CAJOLE_LEAVES.get());
                        pOutput.accept(SBBlocks.CAJOLE_SAPLING.get());
                        pOutput.accept(SBBlocks.CAJOLE_PLANKS.get());
                        pOutput.accept(SBBlocks.CAJOLE_SLAB.get());
                        pOutput.accept(SBBlocks.CAJOLE_STAIRS.get());
                        pOutput.accept(SBBlocks.CAJOLE_FENCE.get());
                        pOutput.accept(SBBlocks.CAJOLE_FENCE_GATE.get());
                        pOutput.accept(SBBlocks.CAJOLE_DOOR.get());
                        pOutput.accept(SBBlocks.CAJOLE_TRAPDOOR.get());

                        pOutput.accept(SBBlocks.DESERT_OAK_LOG.get());
                        pOutput.accept(SBBlocks.STRIPPED_DESERT_OAK_LOG.get());
                        pOutput.accept(SBBlocks.DESERT_OAK_WOOD.get());
                        pOutput.accept(SBBlocks.STRIPPED_DESERT_OAK_WOOD.get());
                        pOutput.accept(SBBlocks.DESERT_OAK_LEAVES.get());
                        pOutput.accept(SBBlocks.DESERT_OAK_SAPLING.get());
                        pOutput.accept(SBBlocks.DESERT_OAK_PLANKS.get());
                        pOutput.accept(SBBlocks.DESERT_OAK_SLAB.get());
                        pOutput.accept(SBBlocks.DESERT_OAK_STAIRS.get());
                        pOutput.accept(SBBlocks.DESERT_OAK_FENCE.get());
                        pOutput.accept(SBBlocks.DESERT_OAK_FENCE_GATE.get());
                        pOutput.accept(SBBlocks.DESERT_OAK_DOOR.get());
                        pOutput.accept(SBBlocks.DESERT_OAK_TRAPDOOR.get());

                        pOutput.accept(SBBlocks.EUCALYPTUS_LOG.get());
                        pOutput.accept(SBBlocks.STRIPPED_EUCALYPTUS_LOG.get());
                        pOutput.accept(SBBlocks.EUCALYPTUS_WOOD.get());
                        pOutput.accept(SBBlocks.STRIPPED_EUCALYPTUS_WOOD.get());
                        pOutput.accept(SBBlocks.EUCALYPTUS_LEAVES.get());
                        pOutput.accept(SBBlocks.EUCALYPTUS_SAPLING.get());
                        pOutput.accept(SBBlocks.EUCALYPTUS_PLANKS.get());
                        pOutput.accept(SBBlocks.EUCALYPTUS_SLAB.get());
                        pOutput.accept(SBBlocks.EUCALYPTUS_STAIRS.get());
                        pOutput.accept(SBBlocks.EUCALYPTUS_FENCE.get());
                        pOutput.accept(SBBlocks.EUCALYPTUS_FENCE_GATE.get());
                        pOutput.accept(SBBlocks.EUCALYPTUS_DOOR.get());
                        pOutput.accept(SBBlocks.EUCALYPTUS_TRAPDOOR.get());

                        pOutput.accept(SBBlocks.KAPOK_LOG.get());
                        pOutput.accept(SBBlocks.STRIPPED_KAPOK_LOG.get());
                        pOutput.accept(SBBlocks.KAPOK_WOOD.get());
                        pOutput.accept(SBBlocks.STRIPPED_KAPOK_WOOD.get());
                        pOutput.accept(SBBlocks.KAPOK_LEAVES.get());
                        pOutput.accept(SBBlocks.KAPOK_SAPLING.get());
                        pOutput.accept(SBBlocks.KAPOK_PLANKS.get());
                        pOutput.accept(SBBlocks.KAPOK_SLAB.get());
                        pOutput.accept(SBBlocks.KAPOK_STAIRS.get());
                        pOutput.accept(SBBlocks.KAPOK_FENCE.get());
                        pOutput.accept(SBBlocks.KAPOK_FENCE_GATE.get());
                        pOutput.accept(SBBlocks.KAPOK_DOOR.get());
                        pOutput.accept(SBBlocks.KAPOK_TRAPDOOR.get());

                        pOutput.accept(SBBlocks.REDWOOD_LOG.get());
                        pOutput.accept(SBBlocks.STRIPPED_REDWOOD_LOG.get());
                        pOutput.accept(SBBlocks.REDWOOD_WOOD.get());
                        pOutput.accept(SBBlocks.STRIPPED_REDWOOD_WOOD.get());
                        pOutput.accept(SBBlocks.REDWOOD_LEAVES.get());
                        pOutput.accept(SBBlocks.REDWOOD_SAPLING.get());
                        pOutput.accept(SBBlocks.REDWOOD_PLANKS.get());
                        pOutput.accept(SBBlocks.REDWOOD_SLAB.get());
                        pOutput.accept(SBBlocks.REDWOOD_STAIRS.get());
                        pOutput.accept(SBBlocks.REDWOOD_FENCE.get());
                        pOutput.accept(SBBlocks.REDWOOD_FENCE_GATE.get());
                        pOutput.accept(SBBlocks.REDWOOD_DOOR.get());
                        pOutput.accept(SBBlocks.REDWOOD_TRAPDOOR.get());

                        pOutput.accept(SBBlocks.WILLOW_LOG.get());
                        pOutput.accept(SBBlocks.STRIPPED_WILLOW_LOG.get());
                        pOutput.accept(SBBlocks.WILLOW_WOOD.get());
                        pOutput.accept(SBBlocks.STRIPPED_WILLOW_WOOD.get());
                        pOutput.accept(SBBlocks.WILLOW_LEAVES.get());
                        pOutput.accept(SBBlocks.WILLOW_SAPLING.get());
                        pOutput.accept(SBBlocks.WILLOW_PLANKS.get());
                        pOutput.accept(SBBlocks.WILLOW_SLAB.get());
                        pOutput.accept(SBBlocks.WILLOW_STAIRS.get());
                        pOutput.accept(SBBlocks.WILLOW_FENCE.get());
                        pOutput.accept(SBBlocks.WILLOW_FENCE_GATE.get());
                        pOutput.accept(SBBlocks.WILLOW_DOOR.get());
                        pOutput.accept(SBBlocks.WILLOW_TRAPDOOR.get());
                        pOutput.accept(SBBlocks.WILLOW_BRANCH.get());

                        pOutput.accept(SBItems.MANTIS_SPAWN_EGG.get());
                        pOutput.accept(SBItems.WORKER_ANT_SPAWN_EGG.get());
                        pOutput.accept(SBItems.SOLDIER_ANT_SPAWN_EGG.get());
                        pOutput.accept(SBItems.QUEEN_ANT_SPAWN_EGG.get());
                        pOutput.accept(SBItems.DAMSELFLY_SPAWN_EGG.get());
                        pOutput.accept(SBItems.WITHER_SPIDER_SPAWN_EGG.get());
                    })).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
