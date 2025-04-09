package net.invictusslayer.slayersbeasts.init;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.entity.AnthillBlockEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.resources.ResourceLocation;

import java.util.List;
import java.util.function.Supplier;

public class SBDataComponents {
	//? if neoforge
	/*public static final net.neoforged.neoforge.registries.DeferredRegister<DataComponentType<?>> DATA_COMPONENTS = net.neoforged.neoforge.registries.DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, SlayersBeasts.MOD_ID);*/

	public static final Supplier<DataComponentType<List<AnthillBlockEntity.Occupant>>> ANTS = register("ants", DataComponentType.<List<AnthillBlockEntity.Occupant>>builder().persistent(AnthillBlockEntity.Occupant.LIST_CODEC).networkSynchronized(AnthillBlockEntity.Occupant.STREAM_CODEC.apply(ByteBufCodecs.list())).cacheEncoding().build());

	private static <T extends DataComponentType<?>> Supplier<T> register(String name, T component) {
		//? if fabric
		return () -> Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE, ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, name), component);
		//? if neoforge
		/*return DATA_COMPONENTS.register(name, () -> component);*/
	}

	public static void init() {
		SlayersBeasts.LOGGER.info("Initialised Data Components");
	}
}
