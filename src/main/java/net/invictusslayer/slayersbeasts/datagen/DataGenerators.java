package net.invictusslayer.slayersbeasts.datagen;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.datagen.tags.SBBlockTagsProvider;
import net.invictusslayer.slayersbeasts.datagen.tags.SBEntityTagsProvider;
import net.invictusslayer.slayersbeasts.datagen.tags.SBItemTagsProvider;
import net.invictusslayer.slayersbeasts.datagen.tags.SBPoiTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = SlayersBeasts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        SBBlockTagsProvider blockTags = new SBBlockTagsProvider(packOutput, lookupProvider, existingFileHelper);

        generator.addProvider(true, blockTags);
        generator.addProvider(true, new SBItemTagsProvider(packOutput, lookupProvider, blockTags, existingFileHelper));
        generator.addProvider(true, new SBEntityTagsProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(true, new SBPoiTagsProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(true, new SBRecipeProvider(packOutput));
        generator.addProvider(true, SBLootTableProvider.create(packOutput));
        generator.addProvider(true, new SBBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(true, new SBItemModelProvider(packOutput, existingFileHelper));

        generator.addProvider(event.includeServer(), new SBWorldGenProvider(packOutput, lookupProvider));
    }
}
