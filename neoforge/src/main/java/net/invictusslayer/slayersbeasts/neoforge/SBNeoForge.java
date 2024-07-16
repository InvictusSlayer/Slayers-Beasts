package net.invictusslayer.slayersbeasts.neoforge;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.init.SBEntities;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;

@Mod(SlayersBeasts.MOD_ID)
public class SBNeoForge {
	public SBNeoForge(IEventBus bus) {
		SlayersBeasts.init();

		bus.addListener(this::commonSetup);
		bus.addListener(this::clientSetup);

		SBEntities.registerLayersAndRenderers();

//		NeoForge.EVENT_BUS.register(this);
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
