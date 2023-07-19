package net.invictusslayer.slayersbeasts.datagen;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
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
    public SBRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(SBItems.TIED_LEATHER.get()), RecipeCategory.MISC, SBItems.TANNED_LEATHER.get(), 0.5F, 200).unlockedBy("has_tied_leather", has(SBItems.TIED_LEATHER.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SBItems.TIED_LEATHER.get()).define('S', Items.STRING).define('L', Items.LEATHER).define('B', Items.SLIME_BALL)
                .pattern("LSL").pattern("SBS").pattern("LSL").unlockedBy("has_leather", has(Items.LEATHER)).save(consumer);

        twoByTwoPacker(consumer, RecipeCategory.BUILDING_BLOCKS, Blocks.PACKED_MUD, SBItems.MUD_BALL.get());
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Blocks.PACKED_MUD), RecipeCategory.BUILDING_BLOCKS, SBBlocks.CRACKED_MUD.get(), 0.1F, 200).unlockedBy("has_packed_mud", has(Blocks.PACKED_MUD)).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, SBBlocks.PEAT.get(), 4).define('M', Blocks.MOSS_BLOCK).define('U', Blocks.MUD).pattern("MU").pattern("UM").unlockedBy("has_moss", has(Blocks.MOSS_BLOCK)).save(consumer);

        nineBlockStorageRecipes(consumer, RecipeCategory.MISC, SBItems.JADE.get(), RecipeCategory.BUILDING_BLOCKS, SBBlocks.JADE_BLOCK.get());

        generateForModBlockFamilies(consumer);
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
    }

    protected void generateForModBlockFamilies(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        SBBlockFamilies.getAllFamilies().filter((family) -> family.shouldGenerateRecipe(FeatureFlagSet.of(FeatureFlags.VANILLA)))
                .forEach((family) -> generateRecipes(pFinishedRecipeConsumer, family));
    }

    protected static void twoByTwoPacker(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeCategory pCategory, ItemLike pPacked, ItemLike pUnpacked) {
        ShapedRecipeBuilder.shaped(pCategory, pPacked, 1).define('#', pUnpacked).pattern("##").pattern("##").unlockedBy(getHasName(pUnpacked), has(pUnpacked)).save(pFinishedRecipeConsumer, new ResourceLocation(SlayersBeasts.MOD_ID, getSimpleRecipeName(pUnpacked)));
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeCategory pUnpackedCategory, ItemLike pUnpacked, RecipeCategory pPackedCategory, ItemLike pPacked) {
        nineBlockStorageRecipes(pFinishedRecipeConsumer, pUnpackedCategory, pUnpacked, pPackedCategory, pPacked, getSimpleRecipeName(pPacked), null, getSimpleRecipeName(pUnpacked), null);
    }
    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeCategory pUnpackedCategory, ItemLike pUnpacked, RecipeCategory pPackedCategory, ItemLike pPacked, String pPackedName, @Nullable String pPackedGroup, String pUnpackedName, @Nullable String pUnpackedGroup) {
        ShapelessRecipeBuilder.shapeless(pUnpackedCategory, pUnpacked, 9).requires(pPacked).group(pUnpackedGroup).unlockedBy(getHasName(pPacked), has(pPacked)).save(pFinishedRecipeConsumer, new ResourceLocation(SlayersBeasts.MOD_ID, pUnpackedName));
        ShapedRecipeBuilder.shaped(pPackedCategory, pPacked).define('#', pUnpacked).pattern("###").pattern("###").pattern("###").group(pPackedGroup).unlockedBy(getHasName(pUnpacked), has(pUnpacked)).save(pFinishedRecipeConsumer, new ResourceLocation(SlayersBeasts.MOD_ID, pPackedName));
    }
}