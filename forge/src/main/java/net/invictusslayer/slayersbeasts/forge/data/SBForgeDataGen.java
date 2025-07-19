package net.invictusslayer.slayersbeasts.forge.data;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.forge.data.tag.*;
import net.invictusslayer.slayersbeasts.forge.world.SBForgeBiomeModifiers;
import net.minecraft.core.Cloner;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = SlayersBeasts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SBForgeDataGen {
	private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
			.add(ForgeRegistries.Keys.BIOME_MODIFIERS, SBForgeBiomeModifiers::bootstrap);

	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator gen = event.getGenerator();
		PackOutput output = gen.getPackOutput();
		CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();
		ExistingFileHelper helper = event.getExistingFileHelper();
		boolean hasServer = event.includeServer();

		gen.addProvider(hasServer, new DatapackBuiltinEntriesProvider(output, provider, BUILDER, Collections.singleton(SlayersBeasts.MOD_ID)));

		gen.addProvider(hasServer, new SBBiomeTagsProvider(output, provider.thenApply(SBForgeDataGen::patchRegistry), helper));
	}

	private static HolderLookup.Provider patchRegistry(HolderLookup.Provider provider) {
		Cloner.Factory factory = new Cloner.Factory();
		RegistryDataLoader.WORLDGEN_REGISTRIES.forEach(data -> data.runWithArguments(factory::addCodec));
		return BUILDER.buildPatch(RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY), provider, factory).full();
	}
}
