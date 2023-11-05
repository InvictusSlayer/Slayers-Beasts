package net.invictusslayer.slayersbeasts.datagen;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.SBBlockFamily;
import net.invictusslayer.slayersbeasts.block.SBBlocks;
import net.invictusslayer.slayersbeasts.entity.SBEntities;
import net.invictusslayer.slayersbeasts.item.SBItems;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Objects;

public class SBLanguageProvider extends LanguageProvider {
	public SBLanguageProvider(PackOutput output) {
		super(output, SlayersBeasts.MOD_ID, "en_us");
	}

	protected void addTranslations() {
		addItem(SBItems.JADE, "Jade");
		addItem(SBItems.JADE_SHARD, "Jade Shard");
		addItem(SBItems.CRYSTALLINE_WING, "Crystalline Wing");
		addItem(SBItems.CRYSTALLINE_CLAW, "Crystalline Claw");
		addItem(SBItems.CRYSTALLINE_CARAPACE, "Crystalline Carapace");
		addItem(SBItems.INSECT_WING, "Insect Wing");
		addItem(SBItems.INSECT_CLAW, "Insect Claw");
		addItem(SBItems.INSECT_EYE, "Insect Eye");
		addItem(SBItems.INSECT_LEG, "Insect Leg");
		addItem(SBItems.WITHERBONE, "Witherbone");
		addItem(SBItems.TIED_LEATHER, "Tied Leather");
		addItem(SBItems.TANNED_LEATHER, "Tanned Leather");
		addItem(SBItems.MUD_BALL, "Mud Ball");

		addItem(SBItems.MANTIS_SPAWN_EGG, "Mantis Spawn Egg");
		addItem(SBItems.ANT_WORKER_SPAWN_EGG, "Worker Ant Spawn Egg");
		addItem(SBItems.ANT_SOLDIER_SPAWN_EGG, "Soldier Ant Spawn Egg");
		addItem(SBItems.ANT_QUEEN_SPAWN_EGG, "Queen Ant Spawn Egg");
		addItem(SBItems.WITHER_SPIDER_SPAWN_EGG, "Wither Spider Spawn Egg");
		addItem(SBItems.TYRACHNID_SPAWN_EGG, "Tyrachnid Spawn Egg");
		addItem(SBItems.DAMSELFLY_SPAWN_EGG, "Damselfly Spawn Egg");
		addItem(SBItems.ENT_OAK_SPAWN_EGG, "Oak Ent Spawn Egg");
		addItem(SBItems.ENT_BIRCH_SPAWN_EGG, "Birch Ent Spawn Egg");
		addItem(SBItems.SPORETRAP_SPAWN_EGG, "Sporetrap Spawn Egg");
		
		add("item.minecraft.potion.effect.paralysis_potion", "Potion of Paralysis");
		add("item.minecraft.splash_potion.effect.paralysis_potion", "Splash Potion of Paralysis");
		add("item.minecraft.lingering_potion.effect.paralysis_potion", "Lingering Potion of Paralysis");
		add("item.minecraft.tipped_arrow.effect.paralysis_potion", "Arrow of Paralysis");
		add("item.minecraft.potion.effect.wither_potion", "Potion of Decay");
		add("item.minecraft.splash_potion.effect.wither_potion", "Splash Potion of Decay");
		add("item.minecraft.lingering_potion.effect.wither_potion", "Lingering Potion of Decay");
		add("item.minecraft.tipped_arrow.effect.wither_potion", "Arrow of Decay");
		
		addBlock(SBBlocks.CRYPTALITH, "Cryptalith");
		addBlock(SBBlocks.INFUSED_CRYPTALITH, "Infused Cryptalith");
		addBlock(SBBlocks.DEPLETED_CRYPTALITH, "Depleted Cryptalith");
		
		addBlock(SBBlocks.JADE_BLOCK, "Jade Block");
		addBlock(SBBlocks.EXOSKELETON_ORE, "Buried Exoskeleton Ore");
		addBlock(SBBlocks.DEEPSLATE_EXOSKELETON_ORE, "Embedded Exoskeleton Ore");
		addBlock(SBBlocks.STYPHIUM, "Styphium");
		addBlock(SBBlocks.DEEPSLATE_STYPHIUM, "Deepslate Styphium");

		addBlockFamily(SBBlockFamily.BLACK_SANDSTONE, "Black Sandstone");
		addBlockFamily(SBBlockFamily.SMOOTH_BLACK_SANDSTONE, "Smooth Black Sandstone");
		addBlockFamily(SBBlockFamily.CUT_BLACK_SANDSTONE, "Cut Black Sandstone");
		
		addBlockFamily(SBBlockFamily.PEGMATITE, "Pegmatite");
		addBlockFamily(SBBlockFamily.POLISHED_PEGMATITE, "Polished Pegmatite");
		
		addBlock(SBBlocks.RUDOSOL, "Rudosol");
		addBlock(SBBlocks.ARIDISOL, "Aridisol");
		addBlock(SBBlocks.ANTHILL, "Anthill");
		addBlock(SBBlocks.ANTHILL_HATCHERY, "Anthill Hatchery");
		addBlock(SBBlocks.OOTHECA, "Ootheca");

		addBlock(SBBlocks.GLEAMING_ICE, "Gleaming Ice");
		addBlock(SBBlocks.ICICLE, "Icicle");
		addBlock(SBBlocks.OBSIDIAN_SPIKE, "Obsidian Spike");
		addBlock(SBBlocks.CRACKED_MUD, "Cracked Mud");
		addBlock(SBBlocks.PEAT, "Peat");
		addBlock(SBBlocks.ALGAE, "Algae");
		addBlock(SBBlocks.TALL_DEAD_BUSH, "Tall Dead Bush");

		addBlock(SBBlocks.BLACK_MUSHROOM, "Black Mushroom");
		addBlock(SBBlocks.BLACK_MUSHROOM_BLOCK, "Black Mushroom Block");
		addBlock(SBBlocks.WHITE_MUSHROOM, "White Mushroom");
		addBlock(SBBlocks.WHITE_MUSHROOM_BLOCK, "White Mushroom Block");
		addBlock(SBBlocks.THIN_MUSHROOM_STEM, "Thin Mushroom Stem");
		
		addBlock(SBBlocks.ASPEN_LOG, "Aspen Log");
		addBlock(SBBlocks.ASPEN_WOOD, "Aspen Wood");
		addBlock(SBBlocks.STRIPPED_ASPEN_LOG, "Stripped Aspen Log");
		addBlock(SBBlocks.STRIPPED_ASPEN_WOOD, "Stripped Aspen Wood");
		addBlock(SBBlocks.ASPEN_LEAVES, "Aspen Leaves");
		addBlock(SBBlocks.ASPEN_SAPLING, "Aspen Sapling");
		addBlockFamily(SBBlockFamily.ASPEN, "Aspen");
		addBlock(SBBlocks.ASPEN_HANGING_SIGN, "Aspen Hanging Sign");
		addItem(SBItems.ASPEN_BOAT, "Aspen Boat");
		addItem(SBItems.ASPEN_CHEST_BOAT, "Aspen Boat with Chest");

		addBlock(SBBlocks.CAJOLE_LOG, "Cajole Log");
		addBlock(SBBlocks.CAJOLE_WOOD, "Cajole Wood");
		addBlock(SBBlocks.STRIPPED_CAJOLE_LOG, "Stripped Cajole Log");
		addBlock(SBBlocks.STRIPPED_CAJOLE_WOOD, "Stripped Cajole Wood");
		addBlock(SBBlocks.CAJOLE_LEAVES, "Cajole Leaves");
		addBlock(SBBlocks.CAJOLE_SAPLING, "Cajole Sapling");
		addBlockFamily(SBBlockFamily.CAJOLE, "Cajole");
		
		addBlock(SBBlocks.DESERT_OAK_LOG, "Desert Oak Log");
		addBlock(SBBlocks.DESERT_OAK_WOOD, "Desert Oak Wood");
		addBlock(SBBlocks.STRIPPED_DESERT_OAK_LOG, "Stripped Desert Oak Log");
		addBlock(SBBlocks.STRIPPED_DESERT_OAK_WOOD, "Stripped Desert Oak Wood");
		addBlock(SBBlocks.DESERT_OAK_LEAVES, "Desert Oak Leaves");
		addBlock(SBBlocks.DESERT_OAK_SAPLING, "Desert Oak Sapling");
		addBlockFamily(SBBlockFamily.DESERT_OAK, "Desert Oak");
		addBlock(SBBlocks.DESERT_OAK_HANGING_SIGN, "Desert Oak Hanging Sign");
		addItem(SBItems.DESERT_OAK_BOAT, "Desert Oak Boat");
		addItem(SBItems.DESERT_OAK_CHEST_BOAT, "Desert Oak Boat with Chest");

		addBlock(SBBlocks.EUCALYPTUS_LOG, "Eucalyptus Log");
		addBlock(SBBlocks.EUCALYPTUS_WOOD, "Eucalyptus Wood");
		addBlock(SBBlocks.STRIPPED_EUCALYPTUS_LOG, "Stripped Eucalyptus Log");
		addBlock(SBBlocks.STRIPPED_EUCALYPTUS_WOOD, "Stripped Eucalyptus Wood");
		addBlock(SBBlocks.EUCALYPTUS_LEAVES, "Eucalyptus Leaves");
		addBlock(SBBlocks.EUCALYPTUS_SAPLING, "Eucalyptus Sapling");
		addBlockFamily(SBBlockFamily.EUCALYPTUS, "Eucalyptus");
		addBlock(SBBlocks.EUCALYPTUS_HANGING_SIGN, "Eucalyptus Hanging Sign");
		addItem(SBItems.EUCALYPTUS_BOAT, "Eucalyptus Boat");
		addItem(SBItems.EUCALYPTUS_CHEST_BOAT, "Eucalyptus Boat with Chest");

		addBlock(SBBlocks.KAPOK_LOG, "Kapok Log");
		addBlock(SBBlocks.KAPOK_WOOD, "Kapok Wood");
		addBlock(SBBlocks.STRIPPED_KAPOK_LOG, "Stripped Kapok Log");
		addBlock(SBBlocks.STRIPPED_KAPOK_WOOD, "Stripped Kapok Wood");
		addBlock(SBBlocks.KAPOK_LEAVES, "Kapok Leaves");
		addBlock(SBBlocks.KAPOK_SAPLING, "Kapok Sapling");
		addBlockFamily(SBBlockFamily.KAPOK, "Kapok");
		addBlock(SBBlocks.KAPOK_HANGING_SIGN, "Kapok Hanging Sign");
		addItem(SBItems.KAPOK_BOAT, "Kapok Boat");
		addItem(SBItems.KAPOK_CHEST_BOAT, "Kapok Boat with Chest");

		addBlock(SBBlocks.REDWOOD_LOG, "Redwood Log");
		addBlock(SBBlocks.REDWOOD_WOOD, "Redwood Wood");
		addBlock(SBBlocks.STRIPPED_REDWOOD_LOG, "Stripped Redwood Log");
		addBlock(SBBlocks.STRIPPED_REDWOOD_WOOD, "Stripped Redwood Wood");
		addBlock(SBBlocks.REDWOOD_LEAVES, "Redwood Leaves");
		addBlock(SBBlocks.REDWOOD_SAPLING, "Redwood Sapling");
		addBlockFamily(SBBlockFamily.REDWOOD, "Redwood");
		addBlock(SBBlocks.REDWOOD_HANGING_SIGN, "Redwood Hanging Sign");
		addItem(SBItems.REDWOOD_BOAT, "Redwood Boat");
		addItem(SBItems.REDWOOD_CHEST_BOAT, "Redwood Boat with Chest");

		addBlock(SBBlocks.WILLOW_LOG, "Willow Log");
		addBlock(SBBlocks.WILLOW_WOOD, "Willow Wood");
		addBlock(SBBlocks.STRIPPED_WILLOW_LOG, "Stripped Willow Log");
		addBlock(SBBlocks.STRIPPED_WILLOW_WOOD, "Stripped Willow Wood");
		addBlock(SBBlocks.WILLOW_LEAVES, "Willow Leaves");
		addBlock(SBBlocks.WILLOW_SAPLING, "Willow Sapling");
		addBlockFamily(SBBlockFamily.WILLOW, "Willow");
		addBlock(SBBlocks.WILLOW_HANGING_SIGN, "Willow Hanging Sign");
		addItem(SBItems.WILLOW_BOAT, "Willow Boat");
		addItem(SBItems.WILLOW_CHEST_BOAT, "Willow Boat with Chest");
		addBlock(SBBlocks.WILLOW_BRANCH, "Willow Branch");
		addBlock(SBBlocks.WILLOW_BRANCH_PLANT, "Willow Branch Plant");
		
		addEntityType(SBEntities.MANTIS, "Mantis");
		addEntityType(SBEntities.ANT_WORKER, "Worker Ant");
		addEntityType(SBEntities.ANT_SOLDIER, "Soldier Ant");
		addEntityType(SBEntities.ANT_QUEEN, "Queen Ant");
		addEntityType(SBEntities.WITHER_SPIDER, "Wither Spider");
		addEntityType(SBEntities.TYRACHNID, "Tyrachnid");
		addEntityType(SBEntities.DAMSELFLY, "Damselfly");
		addEntityType(SBEntities.ENT_OAK, "Oak Ent");
		addEntityType(SBEntities.ENT_BIRCH, "Birch Ent");
		addEntityType(SBEntities.SPORETRAP, "Sporetrap");
		
		add("creative_tab.sb_tab", "Slayer's Beasts");

		add("effect.slayersbeasts.paralysis", "Paralysis");
		
		add("sounds.slayersbeasts.mantis_ambient", "Mantis chirps");
		add("sounds.slayersbeasts.mantis_death", "Mantis dies");
		add("sounds.slayersbeasts.mantis_hurt", "Mantis hurts");
	}
	
	private void addBlockFamily(BlockFamily family, String name) {
		String suffix = Objects.equals(family.getRecipeGroupPrefix().toString(), "wooden") ? " Planks" : "";
		addBlock(family::getBaseBlock, name + suffix);
		family.getVariants().forEach(((variant, block) -> {
			if (variant.equals(BlockFamily.Variant.BUTTON)) {
				addBlock(() -> block, name + " Button");
			} else if (variant.equals(BlockFamily.Variant.CHISELED)) {
				addBlock(() -> block, "Chiseled " + name);
			} else if (variant.equals(BlockFamily.Variant.DOOR)) {
				addBlock(() -> block, name + " Door");
			} else if (variant.equals(BlockFamily.Variant.FENCE)) {
				addBlock(() -> block, name + " Fence");
			} else if (variant.equals(BlockFamily.Variant.FENCE_GATE)) {
				addBlock(() -> block, name + " Fence Gate");
			} else if (variant.equals(BlockFamily.Variant.SIGN)) {
				addBlock(() -> block, name + " Sign");
			} else if (variant.equals(BlockFamily.Variant.SLAB)) {
				addBlock(() -> block, name + " Slab");
			} else if (variant.equals(BlockFamily.Variant.STAIRS)) {
				addBlock(() -> block, name + " Stairs");
			} else if (variant.equals(BlockFamily.Variant.PRESSURE_PLATE)) {
				addBlock(() -> block, name + " Pressure Plate");
			} else if (variant.equals(BlockFamily.Variant.TRAPDOOR)) {
				addBlock(() -> block, name + " Trapdoor");
			} else if (variant.equals(BlockFamily.Variant.WALL)) {
				addBlock(() -> block, name + " Wall");
			}
		}));
	}
}
