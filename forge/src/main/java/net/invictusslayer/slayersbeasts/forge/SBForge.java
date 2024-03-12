package net.invictusslayer.slayersbeasts.forge;

import dev.architectury.platform.forge.EventBuses;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.forge.config.SBConfig;
import net.invictusslayer.slayersbeasts.forge.event.SBClientEvents;
import net.invictusslayer.slayersbeasts.forge.event.SBCommonEvents;
import net.invictusslayer.slayersbeasts.forge.init.SBForgeBlocks;
import net.invictusslayer.slayersbeasts.forge.init.SBForgePois;
import net.invictusslayer.slayersbeasts.forge.world.SBBiomeModifiers;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SlayersBeasts.MOD_ID)
public class SBForge {
	public SBForge() {
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

		EventBuses.registerModEventBus(SlayersBeasts.MOD_ID, eventBus);
		SlayersBeasts.init();

		SBForgeBlocks.BLOCKS.register(eventBus);
		SBForgePois.POIS.register(eventBus);
		SBBiomeModifiers.BIOME_MODIFIERS.register(eventBus);

		eventBus.addListener(SBCommonEvents::commonSetup);
		eventBus.addListener(SBClientEvents::clientSetup);

		MinecraftForge.EVENT_BUS.register(this);

		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, SBConfig.COMMON_SPEC);
	}
}
