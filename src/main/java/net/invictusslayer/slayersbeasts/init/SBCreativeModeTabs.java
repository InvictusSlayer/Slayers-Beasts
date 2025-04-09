package net.invictusslayer.slayersbeasts.init;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class SBCreativeModeTabs {
	//? if neoforge
	/*public static final net.neoforged.neoforge.registries.DeferredRegister<CreativeModeTab> CREATIVE_TABS = net.neoforged.neoforge.registries.DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SlayersBeasts.MOD_ID);*/

	public static final Supplier<CreativeModeTab> SLAYERS_TAB = register("slayers_tab", CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0).icon(() -> new ItemStack(SBBlocks.WILLOW_SAPLING.get())).title(Component.translatable("itemGroup.slayersbeasts.slayers_tab")).displayItems(((display, tab) -> {
				tab.accept(SBItems.JADE.get());
//				tab.accept(SBItems.JADE_SHARD.get());
//				tab.accept(SBItems.CRYSTALLINE_WING.get());
//				tab.accept(SBItems.CRYSTALLINE_CLAW.get());
//				tab.accept(SBItems.CRYSTALLINE_CARAPACE.get());
//				tab.accept(SBItems.INSECT_WING.get());
//				tab.accept(SBItems.INSECT_CLAW.get());
//				tab.accept(SBItems.INSECT_EYE.get());
//				tab.accept(SBItems.INSECT_LEG.get());
//				tab.accept(SBItems.FRIED_INSECT_LEG.get());
//				tab.accept(SBItems.WITHERBONE.get());
//				tab.accept(SBItems.TIED_LEATHER.get());
//				tab.accept(SBItems.TANNED_LEATHER.get());
//				tab.accept(SBItems.MUD_BALL.get());

				tab.accept(SBBlocks.CRYPTALITH.get());
				tab.accept(SBBlocks.INFUSED_CRYPTALITH.get());
				tab.accept(SBBlocks.DEPLETED_CRYPTALITH.get());
				tab.accept(SBBlocks.JADE_BLOCK.get());
				tab.accept(SBBlocks.EXOSKELETON_ORE.get());
				tab.accept(SBBlocks.DEEPSLATE_EXOSKELETON_ORE.get());
				tab.accept(SBBlocks.STYPHIUM.get());
				tab.accept(SBBlocks.DEEPSLATE_STYPHIUM.get());

//				tab.accept(SBBlocks.RUDOSOL.get());
				tab.accept(SBBlocks.ARIDISOL.get());
				tab.accept(SBBlocks.ANTHILL.get());
				tab.accept(SBBlocks.ANTHILL_HATCHERY.get());
				tab.accept(SBBlocks.OOTHECA.get());

				tab.accept(SBBlocks.GLEAMING_ICE.get());
				tab.accept(SBBlocks.ICICLE.get());
				tab.accept(SBBlocks.OBSIDIAN_SPIKE.get());
				tab.accept(SBBlocks.TALL_DEAD_BUSH.get());
				tab.accept(SBBlocks.CRACKED_MUD.get());
				tab.accept(SBBlocks.PEAT.get());
				tab.accept(SBBlocks.ALGAE.get());

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

				tab.accept(SBBlocks.TALL_BROWN_MUSHROOM.get());
				tab.accept(SBBlocks.TALL_RED_MUSHROOM.get());
				tab.accept(SBBlocks.BLACK_MUSHROOM_BLOCK.get());
				tab.accept(SBBlocks.BLACK_MUSHROOM.get());
				tab.accept(SBBlocks.TALL_BLACK_MUSHROOM.get());
				tab.accept(SBBlocks.WHITE_MUSHROOM_BLOCK.get());
				tab.accept(SBBlocks.WHITE_MUSHROOM.get());
				tab.accept(SBBlocks.TALL_WHITE_MUSHROOM.get());
//				tab.accept(SBBlocks.THIN_MUSHROOM_STEM.get());

				tab.accept(SBBlocks.ASPEN_LOG.get());
				tab.accept(SBBlocks.ASPEN_WOOD.get());
				tab.accept(SBBlocks.STRIPPED_ASPEN_LOG.get());
				tab.accept(SBBlocks.STRIPPED_ASPEN_WOOD.get());
				tab.accept(SBBlocks.ASPEN_LEAVES.get());
				tab.accept(SBBlocks.ASPEN_SAPLING.get());
				tab.accept(SBBlocks.ASPEN_PLANKS.get());
				tab.accept(SBBlocks.ASPEN_STAIRS.get());
				tab.accept(SBBlocks.ASPEN_SLAB.get());
				tab.accept(SBBlocks.ASPEN_FENCE.get());
				tab.accept(SBBlocks.ASPEN_FENCE_GATE.get());
				tab.accept(SBBlocks.ASPEN_DOOR.get());
				tab.accept(SBBlocks.ASPEN_TRAPDOOR.get());
				tab.accept(SBBlocks.ASPEN_PRESSURE_PLATE.get());
				tab.accept(SBBlocks.ASPEN_BUTTON.get());
				tab.accept(SBItems.ASPEN_SIGN.get());
				tab.accept(SBItems.ASPEN_HANGING_SIGN.get());
				tab.accept(SBItems.ASPEN_BOAT.get());
				tab.accept(SBItems.ASPEN_CHEST_BOAT.get());

				tab.accept(SBBlocks.DESERT_OAK_LOG.get());
				tab.accept(SBBlocks.DESERT_OAK_WOOD.get());
				tab.accept(SBBlocks.STRIPPED_DESERT_OAK_LOG.get());
				tab.accept(SBBlocks.STRIPPED_DESERT_OAK_WOOD.get());
				tab.accept(SBBlocks.DESERT_OAK_LEAVES.get());
				tab.accept(SBBlocks.DESERT_OAK_SAPLING.get());
				tab.accept(SBBlocks.DESERT_OAK_PLANKS.get());
				tab.accept(SBBlocks.DESERT_OAK_STAIRS.get());
				tab.accept(SBBlocks.DESERT_OAK_SLAB.get());
				tab.accept(SBBlocks.DESERT_OAK_FENCE.get());
				tab.accept(SBBlocks.DESERT_OAK_FENCE_GATE.get());
				tab.accept(SBBlocks.DESERT_OAK_DOOR.get());
				tab.accept(SBBlocks.DESERT_OAK_TRAPDOOR.get());
				tab.accept(SBBlocks.DESERT_OAK_PRESSURE_PLATE.get());
				tab.accept(SBBlocks.DESERT_OAK_BUTTON.get());
				tab.accept(SBItems.DESERT_OAK_SIGN.get());
				tab.accept(SBItems.DESERT_OAK_HANGING_SIGN.get());
				tab.accept(SBItems.DESERT_OAK_BOAT.get());
				tab.accept(SBItems.DESERT_OAK_CHEST_BOAT.get());

				tab.accept(SBBlocks.EUCALYPTUS_LOG.get());
				tab.accept(SBBlocks.EUCALYPTUS_WOOD.get());
				tab.accept(SBBlocks.STRIPPED_EUCALYPTUS_LOG.get());
				tab.accept(SBBlocks.STRIPPED_EUCALYPTUS_WOOD.get());
				tab.accept(SBBlocks.EUCALYPTUS_LEAVES.get());
				tab.accept(SBBlocks.EUCALYPTUS_SAPLING.get());
				tab.accept(SBBlocks.EUCALYPTUS_PLANKS.get());
				tab.accept(SBBlocks.EUCALYPTUS_STAIRS.get());
				tab.accept(SBBlocks.EUCALYPTUS_SLAB.get());
				tab.accept(SBBlocks.EUCALYPTUS_FENCE.get());
				tab.accept(SBBlocks.EUCALYPTUS_FENCE_GATE.get());
				tab.accept(SBBlocks.EUCALYPTUS_DOOR.get());
				tab.accept(SBBlocks.EUCALYPTUS_TRAPDOOR.get());
				tab.accept(SBBlocks.EUCALYPTUS_PRESSURE_PLATE.get());
				tab.accept(SBBlocks.EUCALYPTUS_BUTTON.get());
				tab.accept(SBItems.EUCALYPTUS_SIGN.get());
				tab.accept(SBItems.EUCALYPTUS_HANGING_SIGN.get());
				tab.accept(SBItems.EUCALYPTUS_BOAT.get());
				tab.accept(SBItems.EUCALYPTUS_CHEST_BOAT.get());

				tab.accept(SBBlocks.KAPOK_LOG.get());
				tab.accept(SBBlocks.KAPOK_WOOD.get());
				tab.accept(SBBlocks.STRIPPED_KAPOK_LOG.get());
				tab.accept(SBBlocks.STRIPPED_KAPOK_WOOD.get());
				tab.accept(SBBlocks.KAPOK_LEAVES.get());
				tab.accept(SBBlocks.KAPOK_SAPLING.get());
				tab.accept(SBBlocks.KAPOK_PLANKS.get());
				tab.accept(SBBlocks.KAPOK_STAIRS.get());
				tab.accept(SBBlocks.KAPOK_SLAB.get());
				tab.accept(SBBlocks.KAPOK_FENCE.get());
				tab.accept(SBBlocks.KAPOK_FENCE_GATE.get());
				tab.accept(SBBlocks.KAPOK_DOOR.get());
				tab.accept(SBBlocks.KAPOK_TRAPDOOR.get());
				tab.accept(SBBlocks.KAPOK_PRESSURE_PLATE.get());
				tab.accept(SBBlocks.KAPOK_BUTTON.get());
				tab.accept(SBItems.KAPOK_SIGN.get());
				tab.accept(SBItems.KAPOK_HANGING_SIGN.get());
				tab.accept(SBItems.KAPOK_BOAT.get());
				tab.accept(SBItems.KAPOK_CHEST_BOAT.get());

				tab.accept(SBBlocks.REDWOOD_LOG.get());
				tab.accept(SBBlocks.REDWOOD_WOOD.get());
				tab.accept(SBBlocks.STRIPPED_REDWOOD_LOG.get());
				tab.accept(SBBlocks.STRIPPED_REDWOOD_WOOD.get());
				tab.accept(SBBlocks.REDWOOD_LEAVES.get());
				tab.accept(SBBlocks.REDWOOD_SAPLING.get());
				tab.accept(SBBlocks.REDWOOD_PLANKS.get());
				tab.accept(SBBlocks.REDWOOD_STAIRS.get());
				tab.accept(SBBlocks.REDWOOD_SLAB.get());
				tab.accept(SBBlocks.REDWOOD_FENCE.get());
				tab.accept(SBBlocks.REDWOOD_FENCE_GATE.get());
				tab.accept(SBBlocks.REDWOOD_DOOR.get());
				tab.accept(SBBlocks.REDWOOD_TRAPDOOR.get());
				tab.accept(SBBlocks.REDWOOD_PRESSURE_PLATE.get());
				tab.accept(SBBlocks.REDWOOD_BUTTON.get());
				tab.accept(SBItems.REDWOOD_SIGN.get());
				tab.accept(SBItems.REDWOOD_HANGING_SIGN.get());
				tab.accept(SBItems.REDWOOD_BOAT.get());
				tab.accept(SBItems.REDWOOD_CHEST_BOAT.get());
				tab.accept(SBBlocks.ALBINO_REDWOOD_LEAVES.get());
				tab.accept(SBBlocks.ALBINO_REDWOOD_SAPLING.get());

				tab.accept(SBBlocks.WILLOW_LOG.get());
				tab.accept(SBBlocks.WILLOW_WOOD.get());
				tab.accept(SBBlocks.STRIPPED_WILLOW_LOG.get());
				tab.accept(SBBlocks.STRIPPED_WILLOW_WOOD.get());
				tab.accept(SBBlocks.WILLOW_LEAVES.get());
				tab.accept(SBBlocks.WILLOW_SAPLING.get());
				tab.accept(SBBlocks.WILLOW_PLANKS.get());
				tab.accept(SBBlocks.WILLOW_STAIRS.get());
				tab.accept(SBBlocks.WILLOW_SLAB.get());
				tab.accept(SBBlocks.WILLOW_FENCE.get());
				tab.accept(SBBlocks.WILLOW_FENCE_GATE.get());
				tab.accept(SBBlocks.WILLOW_DOOR.get());
				tab.accept(SBBlocks.WILLOW_TRAPDOOR.get());
				tab.accept(SBBlocks.WILLOW_PRESSURE_PLATE.get());
				tab.accept(SBBlocks.WILLOW_BUTTON.get());
				tab.accept(SBItems.WILLOW_SIGN.get());
				tab.accept(SBItems.WILLOW_HANGING_SIGN.get());
				tab.accept(SBItems.WILLOW_BOAT.get());
				tab.accept(SBItems.WILLOW_CHEST_BOAT.get());
				tab.accept(SBBlocks.WILLOW_BRANCH.get());

				tab.accept(SBItems.MUSIC_DISC_INKISH.get());

				tab.accept(SBItems.MANTIS_SPAWN_EGG.get());
				tab.accept(SBItems.ANT_WORKER_SPAWN_EGG.get());
				tab.accept(SBItems.ANT_SOLDIER_SPAWN_EGG.get());
				tab.accept(SBItems.ANT_QUEEN_SPAWN_EGG.get());
				tab.accept(SBItems.WITHER_SPIDER_SPAWN_EGG.get());
				tab.accept(SBItems.TYRACHNID_SPAWN_EGG.get());
				tab.accept(SBItems.DAMSELFLY_SPAWN_EGG.get());
				tab.accept(SBItems.ENT_SPAWN_EGG.get());
				tab.accept(SBItems.WUDU_SPAWN_EGG.get());
			})).build());

	private static Supplier<CreativeModeTab> register(String name, CreativeModeTab tab) {
		//? if fabric
		return () -> Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, name), tab);
		//? if neoforge
		/*return CREATIVE_TABS.register(name, () -> tab);*/
	}

	public static void init() {
		SlayersBeasts.LOGGER.info("Initialised CreativeModeTabs");
	}
}
