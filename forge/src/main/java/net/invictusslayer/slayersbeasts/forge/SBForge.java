package net.invictusslayer.slayersbeasts.forge;

import dev.architectury.platform.forge.EventBuses;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.init.SBEntities;
import net.invictusslayer.slayersbeasts.common.world.biome.region.SBNetherRegion;
import net.invictusslayer.slayersbeasts.common.world.biome.region.SBOverworldRegion;
import net.invictusslayer.slayersbeasts.forge.config.SBConfig;
import net.invictusslayer.slayersbeasts.forge.init.SBForgeBlocks;
import net.invictusslayer.slayersbeasts.forge.init.SBForgePois;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import terrablender.api.Regions;

@Mod(SlayersBeasts.MOD_ID)
public class SBForge {
	public SBForge() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		EventBuses.registerModEventBus(SlayersBeasts.MOD_ID, bus);
		SlayersBeasts.init();

		SBForgeBlocks.BLOCKS.register(bus);
		SBForgePois.POIS.register(bus);

		bus.addListener(this::commonSetup);
		bus.addListener(this::clientSetup);

		SBEntities.registerLayersAndRenderers();

		MinecraftForge.EVENT_BUS.register(this);

		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, SBConfig.COMMON_SPEC);
	}

	public void commonSetup(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			SlayersBeasts.commonSetup();

//			BrewingRecipeRegistry.addRecipe(new SBBrewingRecipe(Potions.SLOWNESS, SBItems.INSECT_EYE.get(), SBPotions.PARALYSIS_POTION.get()));
//			BrewingRecipeRegistry.addRecipe(new SBBrewingRecipe(Potions.POISON, SBItems.WITHERBONE.get(), SBPotions.WITHER_POTION.get()));

			if (SBConfig.Common.overworldBiomes.get()) Regions.register(new SBOverworldRegion(SBConfig.Common.overworldRegionWeight.get()));
			if (SBConfig.Common.netherBiomes.get()) Regions.register(new SBNetherRegion(SBConfig.Common.netherRegionWeight.get()));
//			if (SBConfig.Common.endBiomes.get()) Regions.register(new SBEndRegion(SBConfig.Common.endRegionWeight.get()));
		});
	}

	@OnlyIn(Dist.CLIENT)
	public void clientSetup(FMLClientSetupEvent event) {
		event.enqueueWork(SlayersBeasts::clientSetup);
	}
}
