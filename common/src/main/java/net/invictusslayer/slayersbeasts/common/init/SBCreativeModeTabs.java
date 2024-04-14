package net.invictusslayer.slayersbeasts.common.init;

import dev.architectury.registry.CreativeTabRegistry;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.block.WoodFamily;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

import java.util.stream.Stream;

public class SBCreativeModeTabs {
	public static final CreativeTabRegistry.TabSupplier SLAYERS_TAB = CreativeTabRegistry.create(new ResourceLocation(SlayersBeasts.MOD_ID, "slayers_tab"), () -> new ItemStack(SBBlocks.WILLOW_SAPLING.get()));

	public static void setup() {
		CreativeTabRegistry.append(SLAYERS_TAB,
				SBItems.JADE
//				SBItems.JADE_SHARD,
//				SBItems.CRYSTALLINE_WING,
//				SBItems.CRYSTALLINE_CLAW,
//				SBItems.CRYSTALLINE_CARAPACE,
//				SBItems.INSECT_WING,
//				SBItems.INSECT_CLAW,
//				SBItems.INSECT_EYE,
//				SBItems.INSECT_LEG,
//				SBItems.FRIED_INSECT_LEG,
//				SBItems.WITHERBONE,
//				SBItems.TIED_LEATHER,
//				SBItems.TANNED_LEATHER,
//				SBItems.MUD_BALL,
		);
		CreativeTabRegistry.append(SLAYERS_TAB,
				SBBlocks.CRYPTALITH,
				SBBlocks.INFUSED_CRYPTALITH,
				SBBlocks.DEPLETED_CRYPTALITH,
				SBBlocks.JADE_BLOCK,
				SBBlocks.EXOSKELETON_ORE,
				SBBlocks.DEEPSLATE_EXOSKELETON_ORE,
				SBBlocks.STYPHIUM,
				SBBlocks.DEEPSLATE_STYPHIUM,

//				SBBlocks.RUDOSOL,
				SBBlocks.ARIDISOL,
				SBBlocks.ANTHILL,
				SBBlocks.ANTHILL_HATCHERY,
				SBBlocks.OOTHECA,

				SBBlocks.GLEAMING_ICE,
				SBBlocks.ICICLE,
				SBBlocks.OBSIDIAN_SPIKE,
				SBBlocks.TALL_DEAD_BUSH,
				SBBlocks.CRACKED_MUD,
				SBBlocks.PEAT,
				SBBlocks.ALGAE,

				SBBlocks.PEGMATITE,
				SBBlocks.PEGMATITE_SLAB,
				SBBlocks.PEGMATITE_STAIRS,
				SBBlocks.PEGMATITE_WALL,
				SBBlocks.POLISHED_PEGMATITE,
				SBBlocks.POLISHED_PEGMATITE_SLAB,
				SBBlocks.POLISHED_PEGMATITE_STAIRS,

				SBBlocks.BLACK_SAND,
				SBBlocks.BLACK_SANDSTONE,
				SBBlocks.BLACK_SANDSTONE_SLAB,
				SBBlocks.BLACK_SANDSTONE_STAIRS,
				SBBlocks.BLACK_SANDSTONE_WALL,
				SBBlocks.SMOOTH_BLACK_SANDSTONE,
				SBBlocks.SMOOTH_BLACK_SANDSTONE_SLAB,
				SBBlocks.SMOOTH_BLACK_SANDSTONE_STAIRS,
				SBBlocks.CUT_BLACK_SANDSTONE,
				SBBlocks.CUT_BLACK_SANDSTONE_SLAB,
				SBBlocks.CHISELED_BLACK_SANDSTONE,

				SBBlocks.BLACK_MUSHROOM_BLOCK,
				SBBlocks.BLACK_MUSHROOM,
				SBBlocks.WHITE_MUSHROOM_BLOCK,
				SBBlocks.WHITE_MUSHROOM
//				SBBlocks.THIN_MUSHROOM_STEM,
		);

		addWoodFamily(SLAYERS_TAB, WoodFamily.ASPEN);
		addWoodFamily(SLAYERS_TAB, WoodFamily.DESERT_OAK);
		addWoodFamily(SLAYERS_TAB, WoodFamily.EUCALYPTUS);
		addWoodFamily(SLAYERS_TAB, WoodFamily.KAPOK);
		addWoodFamily(SLAYERS_TAB, WoodFamily.REDWOOD);
		CreativeTabRegistry.append(SLAYERS_TAB, SBBlocks.ALBINO_REDWOOD_LEAVES, SBBlocks.ALBINO_REDWOOD_SAPLING);
		addWoodFamily(SLAYERS_TAB, WoodFamily.WILLOW);
		CreativeTabRegistry.append(SLAYERS_TAB, SBBlocks.WILLOW_BRANCH);

		CreativeTabRegistry.append(SLAYERS_TAB,
				SBItems.MUSIC_DISC_INKISH,

				SBItems.MANTIS_SPAWN_EGG,
				SBItems.ANT_WORKER_SPAWN_EGG,
				SBItems.ANT_SOLDIER_SPAWN_EGG,
				SBItems.ANT_QUEEN_SPAWN_EGG,
				SBItems.WITHER_SPIDER_SPAWN_EGG,
				SBItems.TYRACHNID_SPAWN_EGG,
				SBItems.DAMSELFLY_SPAWN_EGG,
				SBItems.ENT_SPAWN_EGG,
				SBItems.WUDU_SPAWN_EGG
		);
	}

	private static void addWoodFamily(CreativeTabRegistry.TabSupplier tab, WoodFamily family) {
		Stream.of(WoodFamily.Variant.LOG, WoodFamily.Variant.WOOD,
						WoodFamily.Variant.STRIPPED_LOG, WoodFamily.Variant.STRIPPED_WOOD,
						WoodFamily.Variant.LEAVES, WoodFamily.Variant.PLANKS,
						WoodFamily.Variant.STAIRS, WoodFamily.Variant.SLAB,
						WoodFamily.Variant.FENCE, WoodFamily.Variant.FENCE_GATE,
						WoodFamily.Variant.DOOR, WoodFamily.Variant.TRAPDOOR,
						WoodFamily.Variant.PRESSURE_PLATE, WoodFamily.Variant.BUTTON,
						WoodFamily.Variant.SIGN, WoodFamily.Variant.HANGING_SIGN,
						WoodFamily.Variant.BOAT, WoodFamily.Variant.CHEST_BOAT)
				.distinct().filter(variant -> family.get(variant).isPresent())
				.forEach(variant -> CreativeTabRegistry.append(tab, (ItemLike) family.get(variant).get()));
	}
}
