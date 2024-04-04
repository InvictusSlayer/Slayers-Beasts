package net.invictusslayer.slayersbeasts.common.data;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.block.SBBlockFamily;
import net.invictusslayer.slayersbeasts.common.block.WoodFamily;
import net.invictusslayer.slayersbeasts.common.init.SBBlocks;
import net.invictusslayer.slayersbeasts.common.init.SBItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class SBRecipeProvider extends RecipeProvider {
	public SBRecipeProvider(PackOutput output) {
		super(output);
	}

	public void buildRecipes(RecipeOutput output) {
		generateBlockFamilies(output);
		generateWoodFamilies(output);

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
	}

	private void generateWoodFamilies(RecipeOutput output) {
		WoodFamily.getAllFamilies().forEach(family -> {
			Block planks = (Block) family.get(WoodFamily.Variant.PLANKS).get();
			Ingredient ingredient = Ingredient.of(planks);

			family.getVariants().forEach((variant, supplier) -> {
				if (!(supplier.isPresent())) return;
				ItemLike item = (ItemLike) supplier.get();
				switch (variant) {
					case BOAT -> woodenBoat(output, item, planks);
					case BUTTON -> woodenRecipe(output, buttonBuilder(item, ingredient), planks, "button");
					case CHEST_BOAT -> chestBoat(output, item, (Item) family.get(WoodFamily.Variant.BOAT).get());
					case DOOR -> woodenRecipe(output, doorBuilder(item, ingredient), planks, "door");
					case FENCE -> woodenRecipe(output, fenceBuilder(item, ingredient), planks, "fence");
					case FENCE_GATE -> woodenRecipe(output, fenceGateBuilder(item, ingredient), planks, "fence_gate");
					case HANGING_SIGN_ITEM -> hangingSign(output, item, (Block) family.get(WoodFamily.Variant.STRIPPED_LOG).get());
					case PLANKS -> planksFromLog(output, item, family.getLogItems(), 4);
					case PRESSURE_PLATE -> woodenRecipe(output, pressurePlateBuilder(RecipeCategory.REDSTONE, item, ingredient), planks, "pressure_plate");
					case SIGN_ITEM -> woodenRecipe(output, signBuilder(item, ingredient), planks, "sign");
					case SLAB -> woodenRecipe(output, slabBuilder(RecipeCategory.BUILDING_BLOCKS, item, ingredient), planks, "slab");
					case STAIRS -> woodenRecipe(output, stairBuilder(item, ingredient), planks, "stairs");
					case STRIPPED_WOOD -> woodFromLogs(output, item, (Block) family.get(WoodFamily.Variant.STRIPPED_LOG).get());
					case TRAPDOOR -> woodenRecipe(output, trapdoorBuilder(item, ingredient), planks, "trapdoor");
					case WOOD -> woodFromLogs(output, item, (Block) family.get(WoodFamily.Variant.LOG).get());
				}
			});
		});
	}

	private static void woodenRecipe(RecipeOutput output, RecipeBuilder builder, Block planks, String group) {
		builder.unlockedBy("has_planks", has(planks)).group("wooden_" + group).save(output);
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
