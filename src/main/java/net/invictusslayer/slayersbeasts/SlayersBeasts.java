package net.invictusslayer.slayersbeasts;

import net.invictusslayer.slayersbeasts.block.ModBlocks;
import net.invictusslayer.slayersbeasts.block.entity.ModBlockEntities;
import net.invictusslayer.slayersbeasts.datagen.tags.ModPois;
import net.invictusslayer.slayersbeasts.effect.ModEffects;
import net.invictusslayer.slayersbeasts.entity.ModEntities;
import net.invictusslayer.slayersbeasts.item.ModItems;
import net.invictusslayer.slayersbeasts.misc.ModBrewingRecipe;
import net.invictusslayer.slayersbeasts.misc.ModCreativeModeTab;
import net.invictusslayer.slayersbeasts.misc.ModPotions;
import net.invictusslayer.slayersbeasts.misc.ModSounds;
import net.invictusslayer.slayersbeasts.world.biome.*;
import net.invictusslayer.slayersbeasts.world.dimension.ModDimensions;
import net.invictusslayer.slayersbeasts.world.feature.ModFeatures;
import net.invictusslayer.slayersbeasts.world.feature.foliageplacer.ModFoliagePlacers;
import net.invictusslayer.slayersbeasts.world.feature.trunkplacer.ModTrunkPlacers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

@Mod(SlayersBeasts.MOD_ID)
public class SlayersBeasts {
    public static final String MOD_ID = "slayersbeasts";

    public SlayersBeasts() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTab.register(eventBus);
        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModBlockEntities.register(eventBus);
        ModEntities.register(eventBus);
        ModEffects.register(eventBus);
        ModPotions.register(eventBus);
        ModSounds.register(eventBus);
        ModFoliagePlacers.register(eventBus);
        ModTrunkPlacers.register(eventBus);
        ModFeatures.register(eventBus);
        ModPois.register(eventBus);
        ModBiomes.registerBiomes();
        ModDimensions.register();

        eventBus.addListener(this::commonSetup);
        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::addCreative);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.SLOWNESS, ModItems.INSECT_EYE.get(), ModPotions.PARALYSIS_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.POISON, ModItems.WITHERBONE.get(), ModPotions.WITHER_POTION.get()));

            Regions.register(new OverworldRegion(new ResourceLocation(MOD_ID, "overworld"), 2));

            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, ModSurfaceRuleData.makeRules());
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.NETHER, MOD_ID, ModSurfaceRuleData.makeRules());
        });
    }

    private void clientSetup(final FMLClientSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }
}
