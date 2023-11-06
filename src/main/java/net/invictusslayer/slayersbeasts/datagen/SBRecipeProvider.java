package net.invictusslayer.slayersbeasts.datagen;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.SBBlockFamily;
import net.invictusslayer.slayersbeasts.block.SBBlocks;
import net.invictusslayer.slayersbeasts.block.WoodFamily;
import net.invictusslayer.slayersbeasts.item.SBItems;
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

import java.util.function.Consumer;

public class SBRecipeProvider extends RecipeProvider {
	public SBRecipeProvider(PackOutput output) {
		super(output);
	}

	protected void buildRecipes(Consumer<FinishedRecipe> output) {
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

	private void generateWoodFamilies(Consumer<FinishedRecipe> output) {
		WoodFamily.getAllFamilies().forEach(family -> {
			Block planks = (Block) family.get(WoodFamily.Variant.PLANKS).get();
			Block stripped = (Block) family.get(WoodFamily.Variant.STRIPPED_LOG).get();

			family.getVariants().forEach((variant, object) -> {
				if (object.isPresent()) {
					if (object.get() instanceof Block block) {
						if (variant.equals(WoodFamily.Variant.BUTTON))
							woodenRecipe(output, buttonBuilder(block, Ingredient.of(planks)), planks, "button");
						else if (variant.equals(WoodFamily.Variant.DOOR))
							woodenRecipe(output, doorBuilder((Block) family.get(WoodFamily.Variant.DOOR).get(), Ingredient.of(planks)), planks, "door");
						else if (variant.equals(WoodFamily.Variant.FENCE))
							woodenRecipe(output, fenceBuilder((Block) family.get(WoodFamily.Variant.FENCE).get(), Ingredient.of(planks)), planks, "fence");
						else if (variant.equals(WoodFamily.Variant.FENCE_GATE))
							woodenRecipe(output, fenceGateBuilder((Block) family.get(WoodFamily.Variant.FENCE_GATE).get(), Ingredient.of(planks)), planks, "fence_gate");
						else if (variant.equals(WoodFamily.Variant.SIGN))
							woodenRecipe(output, signBuilder((Block) family.get(WoodFamily.Variant.SIGN).get(), Ingredient.of(planks)), planks, "sign");
						else if (variant.equals(WoodFamily.Variant.SLAB))
							woodenRecipe(output, slabBuilder(RecipeCategory.BUILDING_BLOCKS, (Block) family.get(WoodFamily.Variant.SLAB).get(), Ingredient.of(planks)), planks, "slab");
						else if (variant.equals(WoodFamily.Variant.STAIRS))
							woodenRecipe(output, stairBuilder((Block) family.get(WoodFamily.Variant.STAIRS).get(), Ingredient.of(planks)), planks, "stairs");
						else if (variant.equals(WoodFamily.Variant.STRIPPED_WOOD))
							woodFromLogs(output, (Block) family.get(WoodFamily.Variant.STRIPPED_WOOD).get(), stripped);
						else if (variant.equals(WoodFamily.Variant.PLANKS))
							planksFromLog(output, planks, family.getLogItems(), 4);
						else if (variant.equals(WoodFamily.Variant.PRESSURE_PLATE))
							woodenRecipe(output, pressurePlateBuilder(RecipeCategory.REDSTONE, (Block) family.get(WoodFamily.Variant.PRESSURE_PLATE).get(), Ingredient.of(planks)), planks, "pressure_plate");
						else if (variant.equals(WoodFamily.Variant.TRAPDOOR))
							woodenRecipe(output, trapdoorBuilder((Block) family.get(WoodFamily.Variant.TRAPDOOR).get(), Ingredient.of(planks)), planks, "trapdoor");
						else if (variant.equals(WoodFamily.Variant.WOOD))
							woodFromLogs(output, (Block) family.get(WoodFamily.Variant.WOOD).get(), (Block) family.get(WoodFamily.Variant.LOG).get());
					} else if (object.get() instanceof Item item) {
						if (variant.equals(WoodFamily.Variant.BOAT)) woodenBoat(output, item, planks);
						else if (variant.equals(WoodFamily.Variant.CHEST_BOAT))
							chestBoat(output, item, (Item) family.get(WoodFamily.Variant.BOAT).get());
						else if (variant.equals(WoodFamily.Variant.HANGING_SIGN_ITEM))
							hangingSign(output, item, stripped);
					}
				}
			});
		});
	}

	private static void woodenRecipe(Consumer<FinishedRecipe> output, RecipeBuilder builder, Block planks, String group) {
		builder.unlockedBy("has_planks", has(planks)).group("wooden_" + group).save(output);
	}

	private void generateBlockFamilies(Consumer<FinishedRecipe> output) {
		SBBlockFamily.getAllFamilies().filter(family -> family.shouldGenerateRecipe(FeatureFlagSet.of(FeatureFlags.VANILLA))).forEach(family -> generateRecipes(output, family));
	}

	protected static void twoByTwoPacker(Consumer<FinishedRecipe> output, RecipeCategory category, ItemLike pPacked, ItemLike pUnpacked) {
		ShapedRecipeBuilder.shaped(category, pPacked, 1).define('#', pUnpacked).pattern("##").pattern("##").unlockedBy(getHasName(pUnpacked), has(pUnpacked)).save(output, new ResourceLocation(SlayersBeasts.MOD_ID, getSimpleRecipeName(pUnpacked)));
	}

	protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> output, RecipeCategory unpackedCategory, ItemLike unpacked, RecipeCategory packedCategory, ItemLike packed) {
		nineBlockStorageRecipes(output, unpackedCategory, unpacked, packedCategory, packed, getSimpleRecipeName(packed), getSimpleRecipeName(unpacked));
	}
	protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> output, RecipeCategory unpackedCategory, ItemLike unpacked, RecipeCategory packedCategory, ItemLike packed, String packedName, String unpackedName) {
		ShapelessRecipeBuilder.shapeless(unpackedCategory, unpacked, 9).requires(packed).group(null).unlockedBy(getHasName(packed), has(packed)).save(output, new ResourceLocation(SlayersBeasts.MOD_ID, unpackedName));
		ShapedRecipeBuilder.shaped(packedCategory, packed).define('#', unpacked).pattern("###").pattern("###").pattern("###").group(null).unlockedBy(getHasName(unpacked), has(unpacked)).save(output, new ResourceLocation(SlayersBeasts.MOD_ID, packedName));
	}
}
