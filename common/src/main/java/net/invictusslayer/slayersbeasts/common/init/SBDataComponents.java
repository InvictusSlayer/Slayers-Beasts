package net.invictusslayer.slayersbeasts.common.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.block.entity.AnthillBlockEntity;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;

import java.util.List;

public class SBDataComponents {
	public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENTS = DeferredRegister.create(SlayersBeasts.MOD_ID, Registries.DATA_COMPONENT_TYPE);

	public static final RegistrySupplier<DataComponentType<List<AnthillBlockEntity.Occupant>>> ANTS = DATA_COMPONENTS.register("ants", () -> DataComponentType.<List<AnthillBlockEntity.Occupant>>builder().persistent(AnthillBlockEntity.Occupant.LIST_CODEC).networkSynchronized(AnthillBlockEntity.Occupant.STREAM_CODEC.apply(ByteBufCodecs.list())).cacheEncoding().build());
}
