package net.invictusslayer.slayersbeasts.datagen;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.SBBlockFamilies;
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
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class SBRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public SBRecipeProvider(PackOutput output) {
        super(output);
    }

    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        generateBlockFamilies(consumer);

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(SBItems.TIED_LEATHER.get()), RecipeCategory.MISC, SBItems.TANNED_LEATHER.get(), 0.5F, 200).unlockedBy("has_tied_leather", has(SBItems.TIED_LEATHER.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SBItems.TIED_LEATHER.get()).define('S', Items.STRING).define('L', Items.LEATHER).define('B', Items.SLIME_BALL)
                .pattern("LSL").pattern("SBS").pattern("LSL").unlockedBy("has_leather", has(Items.LEATHER)).save(consumer);

        twoByTwoPacker(consumer, RecipeCategory.BUILDING_BLOCKS, Blocks.PACKED_MUD, SBItems.MUD_BALL.get());
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Blocks.PACKED_MUD), RecipeCategory.BUILDING_BLOCKS, SBBlocks.CRACKED_MUD.get(), 0.1F, 200).unlockedBy("has_packed_mud", has(Blocks.PACKED_MUD)).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, SBBlocks.PEAT.get(), 4).define('M', Blocks.MOSS_BLOCK).define('U', Blocks.MUD).pattern("MU").pattern("UM").unlockedBy("has_moss", has(Blocks.MOSS_BLOCK)).save(consumer);

        nineBlockStorageRecipes(consumer, RecipeCategory.MISC, SBItems.JADE.get(), RecipeCategory.BUILDING_BLOCKS, SBBlocks.JADE_BLOCK.get());

        planksFromLog(consumer, SBBlocks.ASPEN_PLANKS.get(), SBTags.Items.ASPEN_LOGS, 4);
        woodFromLogs(consumer, SBBlocks.ASPEN_WOOD.get(), SBBlocks.ASPEN_LOG.get());
        woodFromLogs(consumer, SBBlocks.STRIPPED_ASPEN_WOOD.get(), SBBlocks.STRIPPED_ASPEN_LOG.get());
        planksFromLog(consumer, SBBlocks.CAJOLE_PLANKS.get(), SBTags.Items.CAJOLE_LOGS, 4);
        woodFromLogs(consumer, SBBlocks.CAJOLE_WOOD.get(), SBBlocks.CAJOLE_LOG.get());
        woodFromLogs(consumer, SBBlocks.STRIPPED_CAJOLE_WOOD.get(), SBBlocks.STRIPPED_CAJOLE_LOG.get());
        planksFromLog(consumer, SBBlocks.EUCALYPTUS_PLANKS.get(), SBTags.Items.EUCALYPTUS_LOGS, 4);
        woodFromLogs(consumer, SBBlocks.EUCALYPTUS_WOOD.get(), SBBlocks.EUCALYPTUS_LOG.get());
        woodFromLogs(consumer, SBBlocks.STRIPPED_EUCALYPTUS_WOOD.get(), SBBlocks.STRIPPED_EUCALYPTUS_LOG.get());
        planksFromLog(consumer, SBBlocks.REDWOOD_PLANKS.get(), SBTags.Items.REDWOOD_LOGS, 4);
        woodFromLogs(consumer, SBBlocks.REDWOOD_WOOD.get(), SBBlocks.REDWOOD_LOG.get());
        woodFromLogs(consumer, SBBlocks.STRIPPED_REDWOOD_WOOD.get(), SBBlocks.STRIPPED_REDWOOD_LOG.get());
        planksFromLog(consumer, SBBlocks.WILLOW_PLANKS.get(), SBTags.Items.WILLOW_LOGS, 4);
        woodFromLogs(consumer, SBBlocks.WILLOW_WOOD.get(), SBBlocks.WILLOW_LOG.get());
        woodFromLogs(consumer, SBBlocks.STRIPPED_WILLOW_WOOD.get(), SBBlocks.STRIPPED_WILLOW_LOG.get());

        twoByTwoPacker(consumer, RecipeCategory.BUILDING_BLOCKS, SBBlocks.BLACK_SANDSTONE.get(), SBBlocks.BLACK_SAND.get());
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, SBBlocks.BLACK_SANDSTONE_SLAB.get(), Ingredient.of(SBBlocks.BLACK_SANDSTONE.get(), SBBlocks.CHISELED_BLACK_SANDSTONE.get())).unlockedBy("has_black_sandstone", has(SBBlocks.BLACK_SANDSTONE.get())).unlockedBy("has_chiseled_black_sandstone", has(SBBlocks.CHISELED_BLACK_SANDSTONE.get())).save(consumer);
        stairBuilder(SBBlocks.BLACK_SANDSTONE_STAIRS.get(), Ingredient.of(SBBlocks.BLACK_SANDSTONE.get(), SBBlocks.CHISELED_BLACK_SANDSTONE.get(), SBBlocks.CUT_BLACK_SANDSTONE.get())).unlockedBy("has_black_sandstone", has(SBBlocks.BLACK_SANDSTONE.get())).unlockedBy("has_chiseled_black_sandstone", has(SBBlocks.CHISELED_BLACK_SANDSTONE.get())).unlockedBy("has_cut_black_sandstone", has(SBBlocks.CUT_BLACK_SANDSTONE.get())).save(consumer);
        wall(consumer, RecipeCategory.DECORATIONS, SBBlocks.BLACK_SANDSTONE_WALL.get(), SBBlocks.BLACK_SANDSTONE.get());
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(SBBlocks.BLACK_SANDSTONE.get()), RecipeCategory.BUILDING_BLOCKS, SBBlocks.SMOOTH_BLACK_SANDSTONE.get().asItem(), 0.1F, 200).unlockedBy("has_black_sandstone", has(SBBlocks.BLACK_SANDSTONE.get())).save(consumer);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, SBBlocks.BLACK_SANDSTONE_SLAB.get(), SBBlocks.BLACK_SANDSTONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, SBBlocks.BLACK_SANDSTONE_STAIRS.get(), SBBlocks.BLACK_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.DECORATIONS, SBBlocks.BLACK_SANDSTONE_WALL.get(), SBBlocks.BLACK_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, SBBlocks.SMOOTH_BLACK_SANDSTONE_SLAB.get(), SBBlocks.SMOOTH_BLACK_SANDSTONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, SBBlocks.SMOOTH_BLACK_SANDSTONE_STAIRS.get(), SBBlocks.SMOOTH_BLACK_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, SBBlocks.CUT_BLACK_SANDSTONE.get(), SBBlocks.BLACK_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, SBBlocks.CUT_BLACK_SANDSTONE_SLAB.get(), SBBlocks.BLACK_SANDSTONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, SBBlocks.CUT_BLACK_SANDSTONE_SLAB.get(), SBBlocks.CUT_BLACK_SANDSTONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, SBBlocks.CHISELED_BLACK_SANDSTONE.get(), SBBlocks.BLACK_SANDSTONE.get());
        
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, SBBlocks.PEGMATITE_SLAB.get(), SBBlocks.PEGMATITE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, SBBlocks.PEGMATITE_STAIRS.get(), SBBlocks.PEGMATITE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.DECORATIONS, SBBlocks.PEGMATITE_WALL.get(), SBBlocks.PEGMATITE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, SBBlocks.POLISHED_PEGMATITE.get(), SBBlocks.PEGMATITE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, SBBlocks.POLISHED_PEGMATITE_SLAB.get(), SBBlocks.PEGMATITE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, SBBlocks.POLISHED_PEGMATITE_SLAB.get(), SBBlocks.POLISHED_PEGMATITE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, SBBlocks.POLISHED_PEGMATITE_STAIRS.get(), SBBlocks.PEGMATITE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, SBBlocks.POLISHED_PEGMATITE_STAIRS.get(), SBBlocks.POLISHED_PEGMATITE.get());
        
    }

    private void generateBlockFamilies(Consumer<FinishedRecipe> consumer) {
        SBBlockFamilies.getAllFamilies().filter(family -> family.shouldGenerateRecipe(FeatureFlagSet.of(FeatureFlags.VANILLA)))
                .forEach(family -> generateRecipes(consumer, family));
    }

    protected static void twoByTwoPacker(Consumer<FinishedRecipe> consumer, RecipeCategory category, ItemLike packed, ItemLike unpacked) {
        ShapedRecipeBuilder.shaped(category, packed, 1).define('#', unpacked).pattern("##").pattern("##").unlockedBy(getHasName(unpacked), has(unpacked)).save(consumer, new ResourceLocation(SlayersBeasts.MOD_ID, getSimpleRecipeName(unpacked)));
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> consumer, RecipeCategory unpackedCategory, ItemLike unpacked, RecipeCategory packedCategory, ItemLike packed) {
        nineBlockStorageRecipes(consumer, unpackedCategory, unpacked, packedCategory, packed, getSimpleRecipeName(packed), null, getSimpleRecipeName(unpacked), null);
    }
    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> consumer, RecipeCategory unpackedCategory, ItemLike unpacked, RecipeCategory packedCategory, ItemLike packed, String packedName, @Nullable String packedGroup, String unpackedName, @Nullable String unpackedGroup) {
        ShapelessRecipeBuilder.shapeless(unpackedCategory, unpacked, 9).requires(packed).group(unpackedGroup).unlockedBy(getHasName(packed), has(packed)).save(consumer, new ResourceLocation(SlayersBeasts.MOD_ID, unpackedName));
        ShapedRecipeBuilder.shaped(packedCategory, packed).define('#', unpacked).pattern("###").pattern("###").pattern("###").group(packedGroup).unlockedBy(getHasName(unpacked), has(unpacked)).save(consumer, new ResourceLocation(SlayersBeasts.MOD_ID, packedName));
    }
}
