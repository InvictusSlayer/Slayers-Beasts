package net.invictusslayer.slayersbeasts.common.init;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.block.entity.AnthillBlockEntity;
import net.invictusslayer.slayersbeasts.common.block.entity.AnthillHatcheryBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class SBBlockEntities {
	public static final Supplier<BlockEntityType<AnthillBlockEntity>> ANTHILL = register("anthill", () -> BlockEntityType.Builder.of(AnthillBlockEntity::new, SBBlocks.ANTHILL.get()).build(null));
	public static final Supplier<BlockEntityType<AnthillHatcheryBlockEntity>> ANTHILL_HATCHERY = register("anthill_hatchery", () -> BlockEntityType.Builder.of(AnthillHatcheryBlockEntity::new, SBBlocks.ANTHILL_HATCHERY.get()).build(null));

	private static <T extends BlockEntityType<?>> Supplier<T> register(String name, Supplier<T> supplier) {
		return SlayersBeasts.PLATFORM.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, name, supplier);
	}

	public static void register() {
		SlayersBeasts.LOGGER.info("Registering SBBlockEntities...");
	}
}
