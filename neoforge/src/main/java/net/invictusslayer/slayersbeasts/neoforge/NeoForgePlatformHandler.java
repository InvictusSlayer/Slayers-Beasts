package net.invictusslayer.slayersbeasts.neoforge;

import com.google.auto.service.AutoService;
import it.unimi.dsi.fastutil.objects.Reference2ObjectOpenHashMap;
import net.invictusslayer.slayersbeasts.common.IPlatformHandler;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.nio.file.Path;
import java.util.Map;
import java.util.function.Supplier;

@AutoService(IPlatformHandler.class)
public class NeoForgePlatformHandler implements IPlatformHandler {
	@Override
	public Platform getPlatform() {
		return Platform.NEOFORGE;
	}

	@Override
	public Path configPath() {
		return FMLPaths.CONFIGDIR.get().resolve(SlayersBeasts.MOD_ID);
	}

	private static final Map<ResourceKey<?>, DeferredRegister> REGISTERS = new Reference2ObjectOpenHashMap<>();

	@Override
	public <T> Supplier<T> register(Registry<? super T> registry, String name, Supplier<T> value) {
		return REGISTERS.computeIfAbsent(registry.key(), key -> DeferredRegister.create(registry.key().location(), SlayersBeasts.MOD_ID)).register(name, value);
	}

	@Override
	public <T> Supplier<Holder.Reference<T>> registerHolder(Registry<T> registry, String name, Supplier<T> value) {
		DeferredHolder<?, ?> registryObject = REGISTERS.computeIfAbsent(registry.key(), key -> DeferredRegister.create(registry.key().location(), SlayersBeasts.MOD_ID)).register(name, value);
		return () -> (Holder.Reference<T>) registryObject.getDelegate();
	}

	public static void register(final IEventBus bus) {
		REGISTERS.values().forEach(deferredRegister -> deferredRegister.register(bus));
	}
}
