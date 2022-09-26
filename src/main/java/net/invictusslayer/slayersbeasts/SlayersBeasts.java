package net.invictusslayer.slayersbeasts;

import net.invictusslayer.slayersbeasts.init.*;
import net.invictusslayer.slayersbeasts.util.ModBrewingRecipe;
import net.invictusslayer.slayersbeasts.world.feature.ModConfiguredFeatures;
import net.invictusslayer.slayersbeasts.world.feature.ModPlacedFeatures;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
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
        ModSounds.register(eventBus);
        ModEffects.register(eventBus);
        ModPotions.register(eventBus);

        //ModStructures.register(eventBus);
        ModConfiguredFeatures.register(eventBus);
        ModPlacedFeatures.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event) {

    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.SLOWNESS,
                    ModItems.INSECT_EYE.get(), ModPotions.PARALYSIS_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.HARMING,
                    ModItems.WITHERBONE.get(), ModPotions.WITHER_POTION.get()));
        });
    }
}
