package net.invictusslayer.slayersbeasts;

import net.invictusslayer.slayersbeasts.block.entity.ModBlockEntities;
import net.invictusslayer.slayersbeasts.init.*;
import net.invictusslayer.slayersbeasts.util.ModBrewingRecipe;
import net.invictusslayer.slayersbeasts.util.ModPoiTypes;
import net.invictusslayer.slayersbeasts.world.feature.foliageplacers.ModFoliagePlacerType;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SlayersBeasts.MOD_ID)
public class SlayersBeasts
{
    public static final String MOD_ID = "slayersbeasts";

    public SlayersBeasts()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModEntities.register(eventBus);
        //ModSounds.register(eventBus);
        ModEffects.register(eventBus);
        ModPotions.register(eventBus);

        ModPoiTypes.register(eventBus);

        ModBlockEntities.register(eventBus);

        ModFoliagePlacerType.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);

        MinecraftForge.EVENT_BUS.register(this);

        eventBus.addListener(this::addCreative);
    }

    private void clientSetup(final FMLClientSetupEvent event) {

    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModPoiTypes.registerPOIs();

            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.SLOWNESS,
                    ModItems.INSECT_EYE.get(), ModPotions.PARALYSIS_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.HARMING,
                    ModItems.WITHERBONE.get(), ModPotions.WITHER_POTION.get()));
        });
    }

    private void addCreative(CreativeModeTabEvent.BuildContents buildContents) {
        if (buildContents.getTab() == ModCreativeModeTab.SLAYERS_BEASTS_TAB) {
            buildContents.accept(ModItems.JADE);
        }
    }
}
