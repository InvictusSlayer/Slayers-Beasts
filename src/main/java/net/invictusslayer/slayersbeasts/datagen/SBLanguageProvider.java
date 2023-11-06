package net.invictusslayer.slayersbeasts.datagen;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.SBBlockFamily;
import net.invictusslayer.slayersbeasts.block.SBBlocks;
import net.invictusslayer.slayersbeasts.block.WoodFamily;
import net.invictusslayer.slayersbeasts.entity.SBEntities;
import net.invictusslayer.slayersbeasts.item.SBItems;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
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

		addBlock(SBBlocks.BLACK_SAND, "Black Sand");
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

		addWoodFamily(WoodFamily.ASPEN, "Aspen");
		addWoodFamily(WoodFamily.CAJOLE, "Cajole");
		addWoodFamily(WoodFamily.DESERT_OAK, "Desert Oak");
		addWoodFamily(WoodFamily.EUCALYPTUS, "Eucalyptus");
		addWoodFamily(WoodFamily.KAPOK, "Kapok");
		addWoodFamily(WoodFamily.REDWOOD, "Redwood");
		addWoodFamily(WoodFamily.WILLOW, "Willow");
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
		
		addEntityType(SBEntities.SB_BOAT, "Boat");
		addEntityType(SBEntities.SB_CHEST_BOAT, "Boat with Chest");
		
		add("creative_tab.sb_tab", "Slayer's Beasts");

		add("effect.slayersbeasts.paralysis", "Paralysis");
		
		add("sounds.slayersbeasts.mantis_ambient", "Mantis chirps");
		add("sounds.slayersbeasts.mantis_death", "Mantis dies");
		add("sounds.slayersbeasts.mantis_hurt", "Mantis hurts");
	}

	private void addWoodFamily(WoodFamily family, String prefix) {
		family.getVariants().forEach((variant, object) -> {
			if (variant.getName() != null && object.isPresent()) {
				String name = prefix + " " + variant.getName();
				if (object.get() instanceof Block block) {
					addBlock(() -> block, name);
				} else if (object.get() instanceof Item item) {
					addItem(() -> item, name);
				}
			}
		});
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
