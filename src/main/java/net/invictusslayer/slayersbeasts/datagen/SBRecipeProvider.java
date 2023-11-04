package net.invictusslayer.slayersbeasts.datagen;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.SBBlockFamily;
import net.invictusslayer.slayersbeasts.block.SBBlocks;
import net.invictusslayer.slayersbeasts.datagen.tags.SBTags;
import net.invictusslayer.slayersbeasts.item.SBItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

public class SBRecipeProvider extends RecipeProvider {
	public SBRecipeProvider(PackOutput output) {
		super(output);
	}

	protected void buildRecipes(RecipeOutput output) {
		generateBlockFamilies(output);

		SimpleCookingRecipeBuilder.smoking(Ingredient.of(SBItems.TIED_LEATHER.get()), RecipeCategory.MISC, SBItems.TANNED_LEATHER.get(), 0.5F, 200).unlockedBy("has_tied_leather", has(SBItems.TIED_LEATHER.get())).save(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SBItems.TIED_LEATHER.get()).define('S', Items.STRING).define('L', Items.LEATHER).define('M', SBItems.MUD_BALL.get())
				.pattern("MSM").pattern("LSL").pattern("MSM").unlockedBy("has_leather", has(Items.LEATHER)).save(output);

		twoByTwoPacker(output, RecipeCategory.BUILDING_BLOCKS, Blocks.PACKED_MUD, SBItems.MUD_BALL.get());
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(Blocks.PACKED_MUD), RecipeCategory.BUILDING_BLOCKS, SBBlocks.CRACKED_MUD.get(), 0.1F, 200).unlockedBy("has_packed_mud", has(Blocks.PACKED_MUD)).save(output);

		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, SBBlocks.PEAT.get(), 4).define('M', Blocks.MOSS_BLOCK).define('U', Blocks.MUD).pattern("MU").pattern("UM").unlockedBy("has_moss", has(Blocks.MOSS_BLOCK)).save(output);

		nineBlockStorageRecipes(output, RecipeCategory.MISC, SBItems.JADE.get(), RecipeCategory.BUILDING_BLOCKS, SBBlocks.JADE_BLOCK.get());

		twoByTwoPacker(output, RecipeCategory.BUILDING_BLOCKS, SBBlocks.BLACK_SANDSTONE.get(), SBBlocks.BLACK_SAND.get());
		slabBuilder(RecipeCategory.BUILDING_BLOCKS, SBBlocks.BLACK_SANDSTONE_SLAB.get(), Ingredient.of(SBBlocks.BLACK_SANDSTONE.get(), SBBlocks.CHISELED_BLACK_SANDSTONE.get())).unlockedBy("has_black_sandstone", has(SBBlocks.BLACK_SANDSTONE.get())).unlockedBy("has_chiseled_black_sandstone", has(SBBlocks.CHISELED_BLACK_SANDSTONE.get())).save(output);
		stairBuilder(SBBlocks.BLACK_SANDSTONE_STAIRS.get(), Ingredient.of(SBBlocks.BLACK_SANDSTONE.get(), SBBlocks.CHISELED_BLACK_SANDSTONE.get(), SBBlocks.CUT_BLACK_SANDSTONE.get())).unlockedBy("has_black_sandstone", has(SBBlocks.BLACK_SANDSTONE.get())).unlockedBy("has_chiseled_black_sandstone", has(SBBlocks.CHISELED_BLACK_SANDSTONE.get())).unlockedBy("has_cut_black_sandstone", has(SBBlocks.CUT_BLACK_SANDSTONE.get())).save(output);
		wall(output, RecipeCategory.DECORATIONS, SBBlocks.BLACK_SANDSTONE_WALL.get(), SBBlocks.BLACK_SANDSTONE.get());
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(SBBlocks.BLACK_SANDSTONE.get()), RecipeCategory.BUILDING_BLOCKS, SBBlocks.SMOOTH_BLACK_SANDSTONE.get().asItem(), 0.1F, 200).unlockedBy("has_black_sandstone", has(SBBlocks.BLACK_SANDSTONE.get())).save(output);
		stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, SBBlocks.BLACK_SANDSTONE_SLAB.get(), SBBlocks.BLACK_SANDSTONE.get(), 2);
		stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, SBBlocks.BLACK_SANDSTONE_STAIRS.get(), SBBlocks.BLACK_SANDSTONE.get());
		stonecutterResultFromBase(output, RecipeCategory.DECORATIONS, SBBlocks.BLACK_SANDSTONE_WALL.get(), SBBlocks.BLACK_SANDSTONE.get());
		stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, SBBlocks.SMOOTH_BLACK_SANDSTONE_SLAB.get(), SBBlocks.SMOOTH_BLACK_SANDSTONE.get(), 2);
		stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, SBBlocks.SMOOTH_BLACK_SANDSTONE_STAIRS.get(), SBBlocks.SMOOTH_BLACK_SANDSTONE.get());
		stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, SBBlocks.CUT_BLACK_SANDSTONE.get(), SBBlocks.BLACK_SANDSTONE.get());
		stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, SBBlocks.CUT_BLACK_SANDSTONE_SLAB.get(), SBBlocks.BLACK_SANDSTONE.get(), 2);
		stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, SBBlocks.CUT_BLACK_SANDSTONE_SLAB.get(), SBBlocks.CUT_BLACK_SANDSTONE.get(), 2);
		stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, SBBlocks.CHISELED_BLACK_SANDSTONE.get(), SBBlocks.BLACK_SANDSTONE.get());

		stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, SBBlocks.PEGMATITE_SLAB.get(), SBBlocks.PEGMATITE.get(), 2);
		stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, SBBlocks.PEGMATITE_STAIRS.get(), SBBlocks.PEGMATITE.get());
		stonecutterResultFromBase(output, RecipeCategory.DECORATIONS, SBBlocks.PEGMATITE_WALL.get(), SBBlocks.PEGMATITE.get());
		stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, SBBlocks.POLISHED_PEGMATITE.get(), SBBlocks.PEGMATITE.get());
		stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, SBBlocks.POLISHED_PEGMATITE_SLAB.get(), SBBlocks.PEGMATITE.get(), 2);
		stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, SBBlocks.POLISHED_PEGMATITE_SLAB.get(), SBBlocks.POLISHED_PEGMATITE.get(), 2);
		stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, SBBlocks.POLISHED_PEGMATITE_STAIRS.get(), SBBlocks.PEGMATITE.get());
		stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, SBBlocks.POLISHED_PEGMATITE_STAIRS.get(), SBBlocks.POLISHED_PEGMATITE.get());

		/* Wood Types */
		planksFromLog(output, SBBlocks.ASPEN_PLANKS.get(), SBTags.Items.ASPEN_LOGS, 4);
		woodFromLogs(output, SBBlocks.ASPEN_WOOD.get(), SBBlocks.ASPEN_LOG.get());
		woodFromLogs(output, SBBlocks.STRIPPED_ASPEN_WOOD.get(), SBBlocks.STRIPPED_ASPEN_LOG.get());
		hangingSign(output, SBItems.ASPEN_HANGING_SIGN.get(), SBBlocks.STRIPPED_ASPEN_LOG.get());
		woodenBoat(output, SBItems.ASPEN_BOAT.get(), SBBlocks.ASPEN_PLANKS.get());
		chestBoat(output, SBItems.ASPEN_CHEST_BOAT.get(), SBItems.ASPEN_BOAT.get());

		planksFromLog(output, SBBlocks.CAJOLE_PLANKS.get(), SBTags.Items.CAJOLE_LOGS, 4);
		woodFromLogs(output, SBBlocks.CAJOLE_WOOD.get(), SBBlocks.CAJOLE_LOG.get());
		woodFromLogs(output, SBBlocks.STRIPPED_CAJOLE_WOOD.get(), SBBlocks.STRIPPED_CAJOLE_LOG.get());

		planksFromLog(output, SBBlocks.DESERT_OAK_PLANKS.get(), SBTags.Items.DESERT_OAK_LOGS, 4);
		woodFromLogs(output, SBBlocks.DESERT_OAK_WOOD.get(), SBBlocks.DESERT_OAK_LOG.get());
		woodFromLogs(output, SBBlocks.STRIPPED_DESERT_OAK_WOOD.get(), SBBlocks.STRIPPED_DESERT_OAK_LOG.get());
		hangingSign(output, SBItems.DESERT_OAK_HANGING_SIGN.get(), SBBlocks.STRIPPED_DESERT_OAK_LOG.get());
		woodenBoat(output, SBItems.DESERT_OAK_BOAT.get(), SBBlocks.DESERT_OAK_PLANKS.get());
		chestBoat(output, SBItems.DESERT_OAK_CHEST_BOAT.get(), SBItems.DESERT_OAK_BOAT.get());
		
		planksFromLog(output, SBBlocks.EUCALYPTUS_PLANKS.get(), SBTags.Items.EUCALYPTUS_LOGS, 4);
		woodFromLogs(output, SBBlocks.EUCALYPTUS_WOOD.get(), SBBlocks.EUCALYPTUS_LOG.get());
		woodFromLogs(output, SBBlocks.STRIPPED_EUCALYPTUS_WOOD.get(), SBBlocks.STRIPPED_EUCALYPTUS_LOG.get());
		woodenBoat(output, SBItems.EUCALYPTUS_BOAT.get(), SBBlocks.EUCALYPTUS_PLANKS.get());
		chestBoat(output, SBItems.EUCALYPTUS_CHEST_BOAT.get(), SBItems.EUCALYPTUS_BOAT.get());

		planksFromLog(output, SBBlocks.KAPOK_PLANKS.get(), SBTags.Items.KAPOK_LOGS, 4);
		woodFromLogs(output, SBBlocks.KAPOK_WOOD.get(), SBBlocks.KAPOK_LOG.get());
		woodFromLogs(output, SBBlocks.STRIPPED_KAPOK_WOOD.get(), SBBlocks.STRIPPED_KAPOK_LOG.get());
		hangingSign(output, SBItems.KAPOK_HANGING_SIGN.get(), SBBlocks.STRIPPED_KAPOK_LOG.get());
		woodenBoat(output, SBItems.KAPOK_BOAT.get(), SBBlocks.KAPOK_PLANKS.get());
		chestBoat(output, SBItems.KAPOK_CHEST_BOAT.get(), SBItems.KAPOK_BOAT.get());
		
		planksFromLog(output, SBBlocks.REDWOOD_PLANKS.get(), SBTags.Items.REDWOOD_LOGS, 4);
		woodFromLogs(output, SBBlocks.REDWOOD_WOOD.get(), SBBlocks.REDWOOD_LOG.get());
		woodFromLogs(output, SBBlocks.STRIPPED_REDWOOD_WOOD.get(), SBBlocks.STRIPPED_REDWOOD_LOG.get());
		woodenBoat(output, SBItems.REDWOOD_BOAT.get(), SBBlocks.REDWOOD_PLANKS.get());
		chestBoat(output, SBItems.REDWOOD_CHEST_BOAT.get(), SBItems.REDWOOD_BOAT.get());

		planksFromLog(output, SBBlocks.WILLOW_PLANKS.get(), SBTags.Items.WILLOW_LOGS, 4);
		woodFromLogs(output, SBBlocks.WILLOW_WOOD.get(), SBBlocks.WILLOW_LOG.get());
		woodFromLogs(output, SBBlocks.STRIPPED_WILLOW_WOOD.get(), SBBlocks.STRIPPED_WILLOW_LOG.get());
		woodenBoat(output, SBItems.WILLOW_BOAT.get(), SBBlocks.WILLOW_PLANKS.get());
		chestBoat(output, SBItems.WILLOW_CHEST_BOAT.get(), SBItems.WILLOW_BOAT.get());
	}

	private void generateBlockFamilies(RecipeOutput output) {
		SBBlockFamily.getAllFamilies().filter(family -> family.shouldGenerateRecipe(FeatureFlagSet.of(FeatureFlags.VANILLA))).forEach(family -> generateRecipes(output, family));
	}

	protected static void twoByTwoPacker(RecipeOutput output, RecipeCategory category, ItemLike pPacked, ItemLike pUnpacked) {
		ShapedRecipeBuilder.shaped(category, pPacked, 1).define('#', pUnpacked).pattern("##").pattern("##").unlockedBy(getHasName(pUnpacked), has(pUnpacked)).save(output, new ResourceLocation(SlayersBeasts.MOD_ID, getSimpleRecipeName(pUnpacked)));
	}

	protected static void nineBlockStorageRecipes(RecipeOutput output, RecipeCategory unpackedCategory, ItemLike unpacked, RecipeCategory packedCategory, ItemLike packed) {
		nineBlockStorageRecipes(output, unpackedCategory, unpacked, packedCategory, packed, getSimpleRecipeName(packed), getSimpleRecipeName(unpacked));
	}
	protected static void nineBlockStorageRecipes(RecipeOutput output, RecipeCategory unpackedCategory, ItemLike unpacked, RecipeCategory packedCategory, ItemLike packed, String packedName, String unpackedName) {
		ShapelessRecipeBuilder.shapeless(unpackedCategory, unpacked, 9).requires(packed).group(null).unlockedBy(getHasName(packed), has(packed)).save(output, new ResourceLocation(SlayersBeasts.MOD_ID, unpackedName));
		ShapedRecipeBuilder.shaped(packedCategory, packed).define('#', unpacked).pattern("###").pattern("###").pattern("###").group(null).unlockedBy(getHasName(unpacked), has(unpacked)).save(output, new ResourceLocation(SlayersBeasts.MOD_ID, packedName));
	}
}
