package net.invictusslayer.slayersbeasts.fabric;

import com.google.auto.service.AutoService;
import net.fabricmc.loader.api.FabricLoader;
import net.invictusslayer.slayersbeasts.common.IPlatformHandler;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

import java.nio.file.Path;
import java.util.function.Supplier;

@AutoService(IPlatformHandler.class)
public class FabricPlatformHandler implements IPlatformHandler {
	@Override
	public Platform getPlatform() {
		return Platform.FABRIC;
	}

	@Override
	public Path configPath() {
		return FabricLoader.getInstance().getConfigDir().resolve(SlayersBeasts.MOD_ID);
	}

	@Override
	public <T> Supplier<T> register(Registry<? super T> registry, String name, Supplier<T> value) {
		T registered = Registry.register(registry, ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, name), value.get());
		return () -> registered;
	}

	@Override
	public <T> Supplier<Holder.Reference<T>> registerHolder(Registry<T> registry, String name, Supplier<T> value) {
		Holder.Reference<T> registered = Registry.registerForHolder(registry, ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, name), value.get());
		return () -> registered;
	}
}
