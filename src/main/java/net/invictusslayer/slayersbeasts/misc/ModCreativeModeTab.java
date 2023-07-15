package net.invictusslayer.slayersbeasts.misc;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.ModBlocks;
import net.invictusslayer.slayersbeasts.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = SlayersBeasts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SlayersBeasts.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SLAYERS_BEASTS_TAB = CREATIVE_MODE_TABS.register("slayers_beasts_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.CAJOLE_SAPLING.get())).title(Component.translatable("creativemodetab.slayers_beasts_tab"))
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.JADE.get());
                        pOutput.accept(ModItems.JADE_SHARD.get());
                        pOutput.accept(ModItems.CRYSTALLINE_WING.get());
                        pOutput.accept(ModItems.CRYSTALLINE_CLAW.get());
                        pOutput.accept(ModItems.CRYSTALLINE_CARAPACE.get());
                        pOutput.accept(ModItems.INSECT_WING.get());
                        pOutput.accept(ModItems.INSECT_CLAW.get());
                        pOutput.accept(ModItems.INSECT_EYE.get());
                        pOutput.accept(ModItems.INSECT_LEG.get());
                        pOutput.accept(ModItems.FRIED_INSECT_LEG.get());
                        pOutput.accept(ModItems.WITHERBONE.get());
                        pOutput.accept(ModItems.TIED_LEATHER.get());
                        pOutput.accept(ModItems.TANNED_LEATHER.get());
                        pOutput.accept(ModItems.MUD_BALL.get());

                        pOutput.accept(ModBlocks.JADE_BLOCK.get());
                        pOutput.accept(ModBlocks.EXOSKELETON_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_EXOSKELETON_ORE.get());

                        pOutput.accept(ModBlocks.OOTHECA.get());
                        pOutput.accept(ModBlocks.ANT_SOIL.get());
                        pOutput.accept(ModBlocks.ANTHILL.get());
                        pOutput.accept(ModBlocks.ANTHILL_HATCHERY.get());
                        pOutput.accept(ModBlocks.CRACKED_MUD.get());
                        pOutput.accept(ModBlocks.PEAT.get());

                        pOutput.accept(ModBlocks.BLACK_SAND.get());
                        pOutput.accept(ModBlocks.BLACK_SANDSTONE.get());
                        pOutput.accept(ModBlocks.BLACK_SANDSTONE_SLAB.get());
                        pOutput.accept(ModBlocks.BLACK_SANDSTONE_STAIRS.get());
                        pOutput.accept(ModBlocks.BLACK_SANDSTONE_WALL.get());
                        pOutput.accept(ModBlocks.SMOOTH_BLACK_SANDSTONE.get());
                        pOutput.accept(ModBlocks.SMOOTH_BLACK_SANDSTONE_SLAB.get());
                        pOutput.accept(ModBlocks.SMOOTH_BLACK_SANDSTONE_STAIRS.get());
                        pOutput.accept(ModBlocks.CUT_BLACK_SANDSTONE.get());
                        pOutput.accept(ModBlocks.CUT_BLACK_SANDSTONE_SLAB.get());
                        pOutput.accept(ModBlocks.CHISELED_BLACK_SANDSTONE.get());

                        pOutput.accept(ModBlocks.WHITE_MUSHROOM.get());
                        pOutput.accept(ModBlocks.WHITE_MUSHROOM_BLOCK.get());

                        pOutput.accept(ModBlocks.ASPEN_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_ASPEN_LOG.get());
                        pOutput.accept(ModBlocks.ASPEN_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_ASPEN_WOOD.get());
                        pOutput.accept(ModBlocks.ASPEN_LEAVES.get());
                        pOutput.accept(ModBlocks.ASPEN_SAPLING.get());
                        pOutput.accept(ModBlocks.ASPEN_PLANKS.get());
                        pOutput.accept(ModBlocks.ASPEN_SLAB.get());
                        pOutput.accept(ModBlocks.ASPEN_STAIRS.get());
                        pOutput.accept(ModBlocks.ASPEN_FENCE.get());
                        pOutput.accept(ModBlocks.ASPEN_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.ASPEN_DOOR.get());
                        pOutput.accept(ModBlocks.ASPEN_TRAPDOOR.get());

                        pOutput.accept(ModBlocks.CAJOLE_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_CAJOLE_LOG.get());
                        pOutput.accept(ModBlocks.CAJOLE_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_CAJOLE_WOOD.get());
                        pOutput.accept(ModBlocks.CAJOLE_LEAVES.get());
                        pOutput.accept(ModBlocks.CAJOLE_SAPLING.get());
                        pOutput.accept(ModBlocks.CAJOLE_PLANKS.get());
                        pOutput.accept(ModBlocks.CAJOLE_SLAB.get());
                        pOutput.accept(ModBlocks.CAJOLE_STAIRS.get());
                        pOutput.accept(ModBlocks.CAJOLE_FENCE.get());
                        pOutput.accept(ModBlocks.CAJOLE_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.CAJOLE_DOOR.get());
                        pOutput.accept(ModBlocks.CAJOLE_TRAPDOOR.get());

                        pOutput.accept(ModBlocks.EUCALYPTUS_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_EUCALYPTUS_LOG.get());
                        pOutput.accept(ModBlocks.EUCALYPTUS_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_EUCALYPTUS_WOOD.get());
                        pOutput.accept(ModBlocks.EUCALYPTUS_LEAVES.get());
                        pOutput.accept(ModBlocks.EUCALYPTUS_SAPLING.get());
                        pOutput.accept(ModBlocks.EUCALYPTUS_PLANKS.get());
                        pOutput.accept(ModBlocks.EUCALYPTUS_SLAB.get());
                        pOutput.accept(ModBlocks.EUCALYPTUS_STAIRS.get());
                        pOutput.accept(ModBlocks.EUCALYPTUS_FENCE.get());
                        pOutput.accept(ModBlocks.EUCALYPTUS_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.EUCALYPTUS_DOOR.get());
                        pOutput.accept(ModBlocks.EUCALYPTUS_TRAPDOOR.get());

                        pOutput.accept(ModBlocks.REDWOOD_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_REDWOOD_LOG.get());
                        pOutput.accept(ModBlocks.REDWOOD_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_REDWOOD_WOOD.get());
                        pOutput.accept(ModBlocks.REDWOOD_LEAVES.get());
                        pOutput.accept(ModBlocks.REDWOOD_SAPLING.get());
                        pOutput.accept(ModBlocks.REDWOOD_PLANKS.get());
                        pOutput.accept(ModBlocks.REDWOOD_SLAB.get());
                        pOutput.accept(ModBlocks.REDWOOD_STAIRS.get());
                        pOutput.accept(ModBlocks.REDWOOD_FENCE.get());
                        pOutput.accept(ModBlocks.REDWOOD_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.REDWOOD_DOOR.get());
                        pOutput.accept(ModBlocks.REDWOOD_TRAPDOOR.get());

                        pOutput.accept(ModBlocks.WILLOW_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_WILLOW_LOG.get());
                        pOutput.accept(ModBlocks.WILLOW_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_WILLOW_WOOD.get());
                        pOutput.accept(ModBlocks.WILLOW_LEAVES.get());
                        pOutput.accept(ModBlocks.WILLOW_SAPLING.get());
                        pOutput.accept(ModBlocks.WILLOW_PLANKS.get());
                        pOutput.accept(ModBlocks.WILLOW_SLAB.get());
                        pOutput.accept(ModBlocks.WILLOW_STAIRS.get());
                        pOutput.accept(ModBlocks.WILLOW_FENCE.get());
                        pOutput.accept(ModBlocks.WILLOW_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.WILLOW_DOOR.get());
                        pOutput.accept(ModBlocks.WILLOW_TRAPDOOR.get());
                        pOutput.accept(ModBlocks.WILLOW_BRANCH.get());

                        pOutput.accept(ModItems.MANTIS_SPAWN_EGG.get());
                        pOutput.accept(ModItems.WORKER_ANT_SPAWN_EGG.get());
                        pOutput.accept(ModItems.SOLDIER_ANT_SPAWN_EGG.get());
                        pOutput.accept(ModItems.QUEEN_ANT_SPAWN_EGG.get());
                        pOutput.accept(ModItems.DAMSELFLY_SPAWN_EGG.get());
                        pOutput.accept(ModItems.WITHER_SPIDER_SPAWN_EGG.get());
                    })).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
