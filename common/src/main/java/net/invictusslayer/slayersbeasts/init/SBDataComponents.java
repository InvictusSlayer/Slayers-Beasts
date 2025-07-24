package net.invictusslayer.slayersbeasts.init;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.entity.AnthillBlockEntity;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.codec.ByteBufCodecs;

import java.util.List;
import java.util.function.Supplier;

public class SBDataComponents {
	public static final Supplier<DataComponentType<List<AnthillBlockEntity.Occupant>>> ANTS = register("ants", () -> DataComponentType.<List<AnthillBlockEntity.Occupant>>builder().persistent(AnthillBlockEntity.Occupant.LIST_CODEC).networkSynchronized(AnthillBlockEntity.Occupant.STREAM_CODEC.apply(ByteBufCodecs.list())).cacheEncoding().build());

	private static <T extends DataComponentType<?>> Supplier<T> register(String name, Supplier<T> supplier) {
		return SlayersBeasts.PLATFORM.register(BuiltInRegistries.DATA_COMPONENT_TYPE, SlayersBeasts.MOD_ID, name, supplier);
	}

	public static void register() {
		SlayersBeasts.LOGGER.info("Registering SBDataComponents...");
	}
}
