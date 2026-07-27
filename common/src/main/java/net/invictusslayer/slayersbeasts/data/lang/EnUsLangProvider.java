package net.invictusslayer.slayersbeasts.data.lang;

import net.invictusslayer.scabbard.data.LangProvider;
import net.invictusslayer.scabbard.world.level.WoodFamily;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.registries.*;
import net.invictusslayer.slayersbeasts.world.level.block.SBBlockFamily;
import net.invictusslayer.slayersbeasts.world.level.block.SBWoodFamily;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class EnUsLangProvider extends LangProvider {
    public EnUsLangProvider(PackOutput output) {
        super(output, SlayersBeasts.MOD_ID, "en_us");
    }

    protected void addTranslations() {
        addItem(SBItems.MUSIC_DISC_INKISH, "Music Disc");
        addItemDesc(SBItems.MUSIC_DISC_INKISH, "Sam Newham - inkish");

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
        addItem(SBItems.BUTTERFLY_SPAWN_EGG, "Butterfly Spawn Egg");
        addItem(SBItems.DAMSELFLY_SPAWN_EGG, "Damselfly Spawn Egg");
        addItem(SBItems.SNAIL_SPAWN_EGG, "Snail Spawn Egg");
        addItem(SBItems.ENT_SPAWN_EGG, "Ent Spawn Egg");
        addItem(SBItems.WUDU_SPAWN_EGG, "Wudu Spawn Egg");
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

        addBlock(SBBlocks.TALL_BROWN_MUSHROOM, "Tall Brown Mushroom");
        addBlock(SBBlocks.TALL_RED_MUSHROOM, "Tall Red Mushroom");
        addBlock(SBBlocks.BLACK_MUSHROOM_BLOCK, "Black Mushroom Block");
        addBlock(SBBlocks.BLACK_MUSHROOM, "Black Mushroom");
        addBlock(SBBlocks.TALL_BLACK_MUSHROOM, "Tall Black Mushroom");
        addBlock(SBBlocks.WHITE_MUSHROOM_BLOCK, "White Mushroom Block");
        addBlock(SBBlocks.WHITE_MUSHROOM, "White Mushroom");
        addBlock(SBBlocks.TALL_WHITE_MUSHROOM, "Tall White Mushroom");
//        addBlock(SBBlocks.THIN_MUSHROOM_STEM, "Thin Mushroom Stem");

        addWoodFamily(SBWoodFamily.ASPEN, "Aspen");
        addWoodFamily(SBWoodFamily.BLOODWOOD, "Bloodwood");
        addWoodFamily(SBWoodFamily.CAJOLE, "Cajole");
        addWoodFamily(SBWoodFamily.CYPRESS, "Cypress");
        addWoodFamily(SBWoodFamily.DESERT_OAK, "Desert Oak");
        addWoodFamily(SBWoodFamily.EUCALYPTUS, "Eucalyptus");
        addWoodFamily(SBWoodFamily.KAPOK, "Kapok");
        addWoodFamily(SBWoodFamily.REDWOOD, "Redwood");
        addBlock(SBBlocks.ALBINO_REDWOOD_LEAVES, "Albino Redwood Leaves");
        addBlock(SBBlocks.ALBINO_REDWOOD_SAPLING, "Albino Redwood Sapling");
        addWoodFamily(SBWoodFamily.WILLOW, "Willow");
        addBlock(SBBlocks.WILLOW_BRANCH, "Willow Branch");
        addBlock(SBBlocks.WILLOW_BRANCH_PLANT, "Willow Branch Plant");

        addEntityType(SBEntities.MANTIS, "Mantis");
        addEntityType(SBEntities.ANT_WORKER, "Worker Ant");
        addEntityType(SBEntities.ANT_SOLDIER, "Soldier Ant");
        addEntityType(SBEntities.ANT_QUEEN, "Queen Ant");
        addEntityType(SBEntities.WITHER_SPIDER, "Wither Spider");
        addEntityType(SBEntities.TYRACHNID, "Tyrachnid");
        addEntityType(SBEntities.BUTTERFLY, "Butterfly");
        addEntityType(SBEntities.DAMSELFLY, "Damselfly");
        addEntityType(SBEntities.SNAIL, "Snail");
        addEntityType(SBEntities.ENT_MEDIUM, "Ent");
        addEntityType(SBEntities.WUDU, "Wudu");
        addEntityType(SBEntities.SPORETRAP, "Sporetrap");
        addEntityType(SBEntities.IRK, "Irk");

        add("itemGroup.slayersbeasts.slayers_tab", "Slayer's Beasts");
        add("itemGroup.slayersbeasts.slayers_wood", "Slayer's Wood Types");

        addEffect(SBEffects.PARALYSIS, "Paralysis");

        addSound(SBSounds.MANTIS_AMBIENT, "Mantis chirps");
        addSound(SBSounds.MANTIS_DEATH, "Mantis dies");
        addSound(SBSounds.MANTIS_HURT, "Mantis hurts");

        addConfigTitle("Slayer's Beasts Config");
        addConfigOption("worldgen", "World Generation Settings");
        addConfigOptionPrefix("worldgen.overworld_biomes", "Overworld Biomes", "Biomes in the Overworld are enabled.");
        addConfigOptionPrefix("worldgen.overworld_region_weight", "Overworld Region Weight", "The weighting of biome regions in the Overworld.");
        addConfigOptionPrefix("worldgen.nether_biomes", "Nether Biomes", "Biomes in the Nether are enabled.");
        addConfigOptionPrefix("worldgen.nether_region_weight", "Nether Region Weight", "The weighting of biome regions in the Nether.");
        addConfigOptionPrefix("worldgen.end_biomes", "End Biomes", "Biomes in the End are enabled.");
        addConfigOptionPrefix("worldgen.end_region_weight", "End Region Weight", "The weighting of biome regions in the End.");
        addConfigOption("worldgen.enabled_biomes", "Enabled Biomes");
        addConfigOptionPrefix("worldgen.enabled_biomes.ancient_grove", "Ancient Grove", "Overworld Biomes:");
        addConfigOption("worldgen.enabled_biomes.aspen_forest", "Aspen Forest");
        addConfigOption("worldgen.enabled_biomes.bayou", "Bayou");
        addConfigOption("worldgen.enabled_biomes.black_dunes", "Black Dunes");
        addConfigOption("worldgen.enabled_biomes.brushland", "Brushland");
        addConfigOption("worldgen.enabled_biomes.rocky_brushland", "Rocky Brushland");
        addConfigOption("worldgen.enabled_biomes.wooded_brushland", "Wooded Brushland");
        addConfigOption("worldgen.enabled_biomes.chaparral", "Chaparral");
        addConfigOption("worldgen.enabled_biomes.dead_sands", "Dead Sands");
        addConfigOption("worldgen.enabled_biomes.eucalypt_woodland", "Eucalypt Woodland");
        addConfigOption("worldgen.enabled_biomes.frozen_thicket", "Frozen Thicket");
        addConfigOption("worldgen.enabled_biomes.glaciate_swamp", "Glaciate Swamp");
        addConfigOption("worldgen.enabled_biomes.inky_moor", "Inky Moor");
        addConfigOption("worldgen.enabled_biomes.murky_ocean", "Murky Ocean");
        addConfigOption("worldgen.enabled_biomes.deep_murky_ocean", "Deep Murky Ocean");
        addConfigOption("worldgen.enabled_biomes.mushroom_forest", "Mushroom Forest");
        addConfigOption("worldgen.enabled_biomes.outback", "Outback");
        addConfigOption("worldgen.enabled_biomes.petrified_woods", "Petrified Woods");
        addConfigOption("worldgen.enabled_biomes.rainforest", "Rainforest");
        addConfigOption("worldgen.enabled_biomes.redwood_grove", "Redwood Grove");
        addConfigOption("worldgen.enabled_biomes.old_growth_redwood_grove", "Old Growth Redwood Grove");
        addConfigOption("worldgen.enabled_biomes.volcanic_peaks", "Volcanic Peaks");
        addConfigOptionPrefix("worldgen.enabled_biomes.dusty_caverns", "Dusty Caverns", "Underground Biomes:");
        addConfigOption("worldgen.enabled_biomes.fungal_depths", "Fungal Depths");
        addConfigOption("worldgen.enabled_biomes.ice_caves", "Ice Caves");
        addConfigOption("worldgen.enabled_biomes.slime_caverns", "Slime Caverns");
        addConfigOptionPrefix("worldgen.enabled_biomes.toxic_jungle", "Toxic Jungle", "Nether Biomes:");
        addConfigOptionPrefix("worldgen.enabled_biomes.end_spikes", "End Spikes", "End Biomes:");
    }

    protected void addWoodFamily(WoodFamily family, String name) {
        family.getVariants().forEach((variant, object) -> {
            switch (variant) {
                case BOAT -> addItem((Supplier<? extends Item>) object, name + " Boat");
                case BUTTON -> addBlock((Supplier<? extends Block>) object, name + " Button");
                case CHEST_BOAT -> addItem((Supplier<? extends Item>) object, name + " Boat with Chest");
                case DOOR -> addBlock((Supplier<? extends Block>) object, name + " Door");
                case FENCE -> addBlock((Supplier<? extends Block>) object, name + " Fence");
                case FENCE_GATE -> addBlock((Supplier<? extends Block>) object, name + " Fence Gate");
                case HANGING_SIGN -> addBlock((Supplier<? extends Block>) object, name + " Hanging Sign");
                case LEAVES -> addBlock((Supplier<? extends Block>) object, name + " Leaves");
                case LOG -> addBlock((Supplier<? extends Block>) object, name + " Log");
                case PLANKS -> addBlock((Supplier<? extends Block>) object, name + " Planks");
                case POTTED_SAPLING -> addBlock((Supplier<? extends Block>) object, "Potted " + name + " Sapling");
                case PRESSURE_PLATE -> addBlock((Supplier<? extends Block>) object, name + " Pressure Plate");
                case SAPLING -> addBlock((Supplier<? extends Block>) object, name + " Sapling");
                case SIGN -> addBlock((Supplier<? extends Block>) object, name + " Sign");
                case STAIRS -> addBlock((Supplier<? extends Block>) object, name + " Stairs");
                case STRIPPED_LOG -> addBlock((Supplier<? extends Block>) object, "Stripped " + name + " Log");
                case STRIPPED_WOOD -> addBlock((Supplier<? extends Block>) object, "Stripped " + name + " Wood");
                case TRAPDOOR -> addBlock((Supplier<? extends Block>) object, name + " Trapdoor");
//                case WALL_HANGING_SIGN -> addBlock((Supplier<? extends Block>) object, name + " Wall Hanging Sign");
//                case WALL_SIGN -> addBlock((Supplier<? extends Block>) object, name + " Wall Sign");
                case WOOD -> addBlock((Supplier<? extends Block>) object, name + " Wood");
            }
        });
    }

    protected void addBlockFamily(BlockFamily family, String name) {
        addBlockFamily(family, name, false);
    }

    protected void addBlockFamily(BlockFamily family, String name, boolean ignoreBase) {
        if (!ignoreBase) addBlock(family::getBaseBlock, name);
        family.getVariants().forEach(((variant, block) -> {
            switch (variant) {
                case BUTTON -> addBlock(() -> block, name + " Button");
                case CHISELED -> addBlock(() -> block, "Chiseled " + name);
                case CRACKED -> addBlock(() -> block, "Cracked " + name);
                case DOOR -> addBlock(() -> block, name + " Door");
                case FENCE -> addBlock(() -> block, name + " Fence");
                case FENCE_GATE -> addBlock(() -> block, name + " Fence Gate");
                case SIGN -> addBlock(() -> block, name + " Sign");
                case SLAB -> addBlock(() -> block, name + " Slab");
                case STAIRS -> addBlock(() -> block, name + " Stairs");
                case PRESSURE_PLATE -> addBlock(() -> block, name + " Pressure Plate");
                case TRAPDOOR -> addBlock(() -> block, name + " Trapdoor");
                case WALL -> addBlock(() -> block, name + " Wall");
            }
        }));
    }
}
