package net.invictusslayer.slayersbeasts.data;

import net.invictusslayer.scabbard.world.level.WoodFamily;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.SBBlockFamily;
import net.invictusslayer.slayersbeasts.block.SBWoodFamily;
import net.invictusslayer.slayersbeasts.init.SBBlocks;
import net.invictusslayer.slayersbeasts.init.SBItems;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class SBRecipeProvider extends RecipeProvider {
	private final HolderGetter<Item> items;

	public SBRecipeProvider(HolderLookup.Provider provider, RecipeOutput output) {
		super(provider, output);
		items = provider.lookupOrThrow(Registries.ITEM);
	}

	public void buildRecipes() {
		generateBlockFamilies();
		generateWoodFamilies(output);

		SimpleCookingRecipeBuilder.smoking(Ingredient.of(SBItems.TIED_LEATHER.get()), RecipeCategory.MISC, SBItems.TANNED_LEATHER.get(), 0.5F, 200).unlockedBy("has_tied_leather", has(SBItems.TIED_LEATHER.get())).save(output);
		ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, SBItems.TIED_LEATHER.get()).define('S', Items.STRING).define('L', Items.LEATHER).define('M', SBItems.MUD_BALL.get())
				.pattern("MSM").pattern("LSL").pattern("MSM").unlockedBy("has_leather", has(Items.LEATHER)).save(output);

		twoByTwoPacker(output, RecipeCategory.BUILDING_BLOCKS, Blocks.PACKED_MUD, SBItems.MUD_BALL.get());
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(Blocks.PACKED_MUD), RecipeCategory.BUILDING_BLOCKS, SBBlocks.CRACKED_MUD.get(), 0.1F, 200).unlockedBy("has_packed_mud", has(Blocks.PACKED_MUD)).save(output);

		ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, SBBlocks.PEAT.get(), 4).define('M', Blocks.MOSS_BLOCK).define('U', Blocks.MUD).pattern("MU").pattern("UM").unlockedBy("has_moss", has(Blocks.MOSS_BLOCK)).save(output);

		nineBlockStorageRecipes(output, RecipeCategory.MISC, SBItems.JADE.get(), RecipeCategory.BUILDING_BLOCKS, SBBlocks.JADE_BLOCK.get());

		twoByTwoPacker(output, RecipeCategory.BUILDING_BLOCKS, SBBlocks.BLACK_SANDSTONE.get(), SBBlocks.BLACK_SAND.get());
		slabBuilder(RecipeCategory.BUILDING_BLOCKS, SBBlocks.BLACK_SANDSTONE_SLAB.get(), Ingredient.of(SBBlocks.BLACK_SANDSTONE.get(), SBBlocks.CHISELED_BLACK_SANDSTONE.get())).unlockedBy("has_black_sandstone", has(SBBlocks.BLACK_SANDSTONE.get())).unlockedBy("has_chiseled_black_sandstone", has(SBBlocks.CHISELED_BLACK_SANDSTONE.get())).save(output);
		stairBuilder(SBBlocks.BLACK_SANDSTONE_STAIRS.get(), Ingredient.of(SBBlocks.BLACK_SANDSTONE.get(), SBBlocks.CHISELED_BLACK_SANDSTONE.get(), SBBlocks.CUT_BLACK_SANDSTONE.get())).unlockedBy("has_black_sandstone", has(SBBlocks.BLACK_SANDSTONE.get())).unlockedBy("has_chiseled_black_sandstone", has(SBBlocks.CHISELED_BLACK_SANDSTONE.get())).unlockedBy("has_cut_black_sandstone", has(SBBlocks.CUT_BLACK_SANDSTONE.get())).save(output);
		wall(RecipeCategory.DECORATIONS, SBBlocks.BLACK_SANDSTONE_WALL.get(), SBBlocks.BLACK_SANDSTONE.get());
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(SBBlocks.BLACK_SANDSTONE.get()), RecipeCategory.BUILDING_BLOCKS, SBBlocks.SMOOTH_BLACK_SANDSTONE.get().asItem(), 0.1F, 200).unlockedBy("has_black_sandstone", has(SBBlocks.BLACK_SANDSTONE.get())).save(output);
		stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, SBBlocks.BLACK_SANDSTONE_SLAB.get(), SBBlocks.BLACK_SANDSTONE.get(), 2);
		stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, SBBlocks.BLACK_SANDSTONE_STAIRS.get(), SBBlocks.BLACK_SANDSTONE.get());
		stonecutterResultFromBase(RecipeCategory.DECORATIONS, SBBlocks.BLACK_SANDSTONE_WALL.get(), SBBlocks.BLACK_SANDSTONE.get());
		stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, SBBlocks.SMOOTH_BLACK_SANDSTONE_SLAB.get(), SBBlocks.SMOOTH_BLACK_SANDSTONE.get(), 2);
		stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, SBBlocks.SMOOTH_BLACK_SANDSTONE_STAIRS.get(), SBBlocks.SMOOTH_BLACK_SANDSTONE.get());
		stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, SBBlocks.CUT_BLACK_SANDSTONE.get(), SBBlocks.BLACK_SANDSTONE.get());
		stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, SBBlocks.CUT_BLACK_SANDSTONE_SLAB.get(), SBBlocks.BLACK_SANDSTONE.get(), 2);
		stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, SBBlocks.CUT_BLACK_SANDSTONE_SLAB.get(), SBBlocks.CUT_BLACK_SANDSTONE.get(), 2);
		stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, SBBlocks.CHISELED_BLACK_SANDSTONE.get(), SBBlocks.BLACK_SANDSTONE.get());

		stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, SBBlocks.PEGMATITE_SLAB.get(), SBBlocks.PEGMATITE.get(), 2);
		stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, SBBlocks.PEGMATITE_STAIRS.get(), SBBlocks.PEGMATITE.get());
		stonecutterResultFromBase(RecipeCategory.DECORATIONS, SBBlocks.PEGMATITE_WALL.get(), SBBlocks.PEGMATITE.get());
		stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, SBBlocks.POLISHED_PEGMATITE.get(), SBBlocks.PEGMATITE.get());
		stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, SBBlocks.POLISHED_PEGMATITE_SLAB.get(), SBBlocks.PEGMATITE.get(), 2);
		stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, SBBlocks.POLISHED_PEGMATITE_SLAB.get(), SBBlocks.POLISHED_PEGMATITE.get(), 2);
		stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, SBBlocks.POLISHED_PEGMATITE_STAIRS.get(), SBBlocks.PEGMATITE.get());
		stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, SBBlocks.POLISHED_PEGMATITE_STAIRS.get(), SBBlocks.POLISHED_PEGMATITE.get());
	}

	private void generateWoodFamilies(RecipeOutput output) {
		SBWoodFamily.getAllFamilies().forEach(family -> {
			Block planks = (Block) family.get(WoodFamily.Variant.PLANKS).get();
			Ingredient ingredient = Ingredient.of(planks);

			family.getVariants().forEach((variant, supplier) -> {
				if (!(supplier.get() instanceof ItemLike item)) return;
				switch (variant) {
					case BOAT -> woodenBoat(item, planks);
					case BUTTON -> woodenRecipe(output, buttonBuilder(item, ingredient), planks, "button");
					case CHEST_BOAT -> chestBoat(item, (Item) family.get(WoodFamily.Variant.BOAT).get());
					case DOOR -> woodenRecipe(output, doorBuilder(item, ingredient), planks, "door");
					case FENCE -> woodenRecipe(output, fenceBuilder(item, ingredient), planks, "fence");
					case FENCE_GATE -> woodenRecipe(output, fenceGateBuilder(item, ingredient), planks, "fence_gate");
					case HANGING_SIGN_ITEM -> hangingSign(item, (Block) family.get(WoodFamily.Variant.STRIPPED_LOG).get());
					case PLANKS -> planksFromLog(item, family.getLogItems(), 4);
					case PRESSURE_PLATE -> woodenRecipe(output, pressurePlateBuilder(RecipeCategory.REDSTONE, item, ingredient), planks, "pressure_plate");
					case SIGN_ITEM -> woodenRecipe(output, signBuilder(item, ingredient), planks, "sign");
					case SLAB -> woodenRecipe(output, slabBuilder(RecipeCategory.BUILDING_BLOCKS, item, ingredient), planks, "slab");
					case STAIRS -> woodenRecipe(output, stairBuilder(item, ingredient), planks, "stairs");
					case STRIPPED_WOOD -> woodFromLogs(item, (Block) family.get(WoodFamily.Variant.STRIPPED_LOG).get());
					case TRAPDOOR -> woodenRecipe(output, trapdoorBuilder(item, ingredient), planks, "trapdoor");
					case WOOD -> woodFromLogs(item, (Block) family.get(WoodFamily.Variant.LOG).get());
				}
			});
		});
	}

	private void woodenRecipe(RecipeOutput output, RecipeBuilder builder, Block planks, String group) {
		builder.unlockedBy("has_planks", has(planks)).group("wooden_" + group).save(output);
	}

	private void generateBlockFamilies() {
		SBBlockFamily.getAllFamilies().filter(BlockFamily::shouldGenerateRecipe).forEach(family -> generateRecipes(family, FeatureFlagSet.of(FeatureFlags.VANILLA)));
	}

	protected void twoByTwoPacker(RecipeOutput output, RecipeCategory category, ItemLike pPacked, ItemLike pUnpacked) {
		ShapedRecipeBuilder.shaped(items, category, pPacked, 1).define('#', pUnpacked).pattern("##").pattern("##").unlockedBy(getHasName(pUnpacked), has(pUnpacked)).save(output, createRecipeKey(getSimpleRecipeName(pUnpacked)));
	}

	protected void nineBlockStorageRecipes(RecipeOutput output, RecipeCategory unpackedCategory, ItemLike unpacked, RecipeCategory packedCategory, ItemLike packed) {
		nineBlockStorageRecipes(output, unpackedCategory, unpacked, packedCategory, packed, getSimpleRecipeName(packed), getSimpleRecipeName(unpacked));
	}

	protected void nineBlockStorageRecipes(RecipeOutput output, RecipeCategory unpackedCategory, ItemLike unpacked, RecipeCategory packedCategory, ItemLike packed, String packedName, String unpackedName) {
		ShapelessRecipeBuilder.shapeless(items, unpackedCategory, unpacked, 9).requires(packed).group(null).unlockedBy(getHasName(packed), has(packed)).save(output, createRecipeKey(unpackedName));
		ShapedRecipeBuilder.shaped(items, packedCategory, packed).define('#', unpacked).pattern("###").pattern("###").pattern("###").group(null).unlockedBy(getHasName(unpacked), has(unpacked)).save(output, createRecipeKey(packedName));
	}

	private ResourceKey<Recipe<?>> createRecipeKey(String path) {
		return ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, path));
	}

	public static class Runner extends RecipeProvider.Runner {
		public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
			super(output, provider);
		}

		public String getName() {
			return "SBRecipeProvider";
		}

		protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput output) {
			return new SBRecipeProvider(provider, output);
		}
	}
}
