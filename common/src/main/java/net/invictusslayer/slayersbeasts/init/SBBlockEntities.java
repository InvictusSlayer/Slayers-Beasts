package net.invictusslayer.slayersbeasts.init;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.entity.AnthillBlockEntity;
import net.invictusslayer.slayersbeasts.block.entity.AnthillHatcheryBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.Set;
import java.util.function.Supplier;

public class SBBlockEntities {
	public static final Supplier<BlockEntityType<AnthillBlockEntity>> ANTHILL = register("anthill", () -> new BlockEntityType<>(AnthillBlockEntity::new, Set.of(SBBlocks.ANTHILL.get())));
	public static final Supplier<BlockEntityType<AnthillHatcheryBlockEntity>> ANTHILL_HATCHERY = register("anthill_hatchery", () -> new BlockEntityType<>(AnthillHatcheryBlockEntity::new, Set.of(SBBlocks.ANTHILL_HATCHERY.get())));

	private static <T extends BlockEntityType<?>> Supplier<T> register(String name, Supplier<T> supplier) {
		return SlayersBeasts.PLATFORM.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, SlayersBeasts.MOD_ID, name, supplier);
	}

	public static void register() {
		SlayersBeasts.LOGGER.info("Registering SBBlockEntities...");
	}
}
