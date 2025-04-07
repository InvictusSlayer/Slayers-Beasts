package net.invictusslayer.slayersbeasts.common.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.block.entity.AnthillBlockEntity;
import net.invictusslayer.slayersbeasts.common.block.entity.AnthillHatcheryBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.Set;

public class SBBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(SlayersBeasts.MOD_ID, Registries.BLOCK_ENTITY_TYPE);

	public static final RegistrySupplier<BlockEntityType<AnthillBlockEntity>> ANTHILL = BLOCK_ENTITIES.register("anthill", () -> new BlockEntityType<>(AnthillBlockEntity::new, Set.of(SBBlocks.ANTHILL.get())));
	public static final RegistrySupplier<BlockEntityType<AnthillHatcheryBlockEntity>> ANTHILL_HATCHERY = BLOCK_ENTITIES.register("anthill_hatchery", () -> new BlockEntityType<>(AnthillHatcheryBlockEntity::new, Set.of(SBBlocks.ANTHILL_HATCHERY.get())));
}
