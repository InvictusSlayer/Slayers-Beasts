package net.invictusslayer.slayersbeasts.forge;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.init.SBEntities;
import net.invictusslayer.slayersbeasts.forge.client.SBForgeClient;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SlayersBeasts.MOD_ID)
public class SBForge {
	public SBForge(final FMLJavaModLoadingContext context) {
		IEventBus bus = context.getModEventBus();

		SlayersBeasts.init();
		ForgePlatformHandler.register(bus);

		bus.addListener((FMLCommonSetupEvent event) -> event.enqueueWork(() -> {
			SlayersBeasts.commonSetup();
			SlayersBeasts.registerRegions();
		}));
		bus.addListener((EntityAttributeCreationEvent event) -> SBEntities.registerAttributes(event::put));
		bus.addListener((SpawnPlacementRegisterEvent event) -> SBEntities.registerSpawns(placement -> event.register(placement.entity(), placement.placement(), placement.heightmap(), placement.predicate(), SpawnPlacementRegisterEvent.Operation.OR)));

		DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> SBForgeClient.init(context));
	}
}
