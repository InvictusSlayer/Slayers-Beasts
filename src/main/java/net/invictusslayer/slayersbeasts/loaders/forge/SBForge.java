//? if forge {
/*package net.invictusslayer.slayersbeasts.loaders.forge;

import dev.architectury.platform.forge.EventBuses;
import net.invictusslayer.slayersbeasts.loaders.SlayersBeasts;
import net.invictusslayer.slayersbeasts.init.SBEntities;
import net.invictusslayer.slayersbeasts.forge.init.SBForgeBlocks;
import net.invictusslayer.slayersbeasts.forge.init.SBForgePois;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SlayersBeasts.MOD_ID)
public class SBForge {
	public SBForge() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		EventBuses.registerModEventBus(SlayersBeasts.MOD_ID, bus);
		SlayersBeasts.init();

		bus.addListener(this::commonSetup);
		bus.addListener(this::clientSetup);

		SBEntities.registerLayersAndRenderers();

		MinecraftForge.EVENT_BUS.register(this);
	}

	public void commonSetup(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			SlayersBeasts.commonSetup();
			SlayersBeasts.registerRegions();
//			BrewingRecipeRegistry.addRecipe(new SBBrewingRecipe(Potions.SLOWNESS, SBItems.INSECT_EYE.get(), SBPotions.PARALYSIS_POTION.get()));
//			BrewingRecipeRegistry.addRecipe(new SBBrewingRecipe(Potions.POISON, SBItems.WITHERBONE.get(), SBPotions.WITHER_POTION.get()));
		});
	}

	@OnlyIn(Dist.CLIENT)
	public void clientSetup(FMLClientSetupEvent event) {
		event.enqueueWork(SlayersBeasts::clientSetup);
	}
}
*///?}