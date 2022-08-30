package net.invictusslayer.slayersbeasts;

import net.invictusslayer.slayersbeasts.init.*;
import net.invictusslayer.slayersbeasts.util.ModBrewingRecipe;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
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
        ModStructures.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CAJOLE_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CAJOLE_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CAJOLE_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CAJOLE_TRAPDOOR.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EUCALYPTUS_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EUCALYPTUS_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EUCALYPTUS_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EUCALYPTUS_TRAPDOOR.get(), RenderType.cutout());
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
