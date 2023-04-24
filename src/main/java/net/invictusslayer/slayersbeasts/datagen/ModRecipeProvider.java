package net.invictusslayer.slayersbeasts.datagen;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.ModBlocks;
import net.invictusslayer.slayersbeasts.item.ModItems;
import net.invictusslayer.slayersbeasts.util.ModTags;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        SimpleCookingRecipeBuilder.generic(Ingredient.of(ModItems.TIED_LEATHER.get()), RecipeCategory.MISC, ModItems.TANNED_LEATHER.get(), 0.5F, 400,
                RecipeSerializer.SMOKING_RECIPE).unlockedBy("has_tied_leather", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.TIED_LEATHER.get()).build())).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TIED_LEATHER.get()).define('S', Items.STRING)
                .define('L', Items.LEATHER).define('B', Items.SLIME_BALL).pattern("LSL").pattern("SBS").pattern("LSL")
                .unlockedBy("has_leather", inventoryTrigger(ItemPredicate.Builder.item().of(Items.LEATHER).build())).save(consumer);

        nineBlockStorageRecipes(consumer, RecipeCategory.MISC, ModItems.JADE.get(), RecipeCategory.BUILDING_BLOCKS, ModBlocks.JADE_BLOCK.get());

        generateForModBlockFamilies(consumer);
        planksFromLog(consumer, ModBlocks.CAJOLE_PLANKS.get(), ModTags.Items.CAJOLE_LOGS, 4);
        woodFromLogs(consumer, ModBlocks.CAJOLE_WOOD.get(), ModBlocks.CAJOLE_LOG.get());
        woodFromLogs(consumer, ModBlocks.STRIPPED_CAJOLE_WOOD.get(), ModBlocks.STRIPPED_CAJOLE_LOG.get());
        planksFromLog(consumer, ModBlocks.EUCALYPTUS_PLANKS.get(), ModTags.Items.EUCALYPTUS_LOGS, 4);
        woodFromLogs(consumer, ModBlocks.EUCALYPTUS_WOOD.get(), ModBlocks.EUCALYPTUS_LOG.get());
        woodFromLogs(consumer, ModBlocks.STRIPPED_EUCALYPTUS_WOOD.get(), ModBlocks.STRIPPED_EUCALYPTUS_LOG.get());
        planksFromLog(consumer, ModBlocks.ASPEN_PLANKS.get(), ModTags.Items.ASPEN_LOGS, 4);
        woodFromLogs(consumer, ModBlocks.ASPEN_WOOD.get(), ModBlocks.ASPEN_LOG.get());
        woodFromLogs(consumer, ModBlocks.STRIPPED_ASPEN_WOOD.get(), ModBlocks.STRIPPED_ASPEN_LOG.get());
    }

    protected void generateForModBlockFamilies(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        ModBlockFamilies.getAllFamilies().filter((family) -> family.shouldGenerateRecipe(FeatureFlagSet.of(FeatureFlags.VANILLA)))
                .forEach((family) -> generateRecipes(pFinishedRecipeConsumer, family));
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeCategory pUnpackedCategory, ItemLike pUnpacked, RecipeCategory pPackedCategory, ItemLike pPacked) {
        nineBlockStorageRecipes(pFinishedRecipeConsumer, pUnpackedCategory, pUnpacked, pPackedCategory, pPacked, getSimpleRecipeName(pPacked), null, getSimpleRecipeName(pUnpacked), null);
    }
    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeCategory pUnpackedCategory, ItemLike pUnpacked, RecipeCategory pPackedCategory, ItemLike pPacked, String pPackedName, @Nullable String pPackedGroup, String pUnpackedName, @Nullable String pUnpackedGroup) {
        ShapelessRecipeBuilder.shapeless(pUnpackedCategory, pUnpacked, 9).requires(pPacked).group(pUnpackedGroup).unlockedBy(getHasName(pPacked), has(pPacked)).save(pFinishedRecipeConsumer, new ResourceLocation(SlayersBeasts.MOD_ID, pUnpackedName));
        ShapedRecipeBuilder.shaped(pPackedCategory, pPacked).define('#', pUnpacked).pattern("###").pattern("###").pattern("###").group(pPackedGroup).unlockedBy(getHasName(pUnpacked), has(pUnpacked)).save(pFinishedRecipeConsumer, new ResourceLocation(SlayersBeasts.MOD_ID, pPackedName));
    }
}
