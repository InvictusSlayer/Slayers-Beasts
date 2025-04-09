package net.invictusslayer.slayersbeasts.init;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.entity.AnthillBlockEntity;
import net.invictusslayer.slayersbeasts.block.entity.AnthillHatcheryBlockEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.Set;
import java.util.function.Supplier;

public class SBBlockEntities {
	//? if neoforge
	/*public static final net.neoforged.neoforge.registries.DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = net.neoforged.neoforge.registries.DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, SlayersBeasts.MOD_ID);*/

	public static final Supplier<BlockEntityType<AnthillBlockEntity>> ANTHILL = register("anthill", new BlockEntityType<>(AnthillBlockEntity::new, Set.of(SBBlocks.ANTHILL.get())));
	public static final Supplier<BlockEntityType<AnthillHatcheryBlockEntity>> ANTHILL_HATCHERY = register("anthill_hatchery", new BlockEntityType<>(AnthillHatcheryBlockEntity::new, Set.of(SBBlocks.ANTHILL_HATCHERY.get())));

	private static <T extends BlockEntityType<?>> Supplier<T> register(String name, T blockEntity) {
		//? if fabric
		return () -> Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, name), blockEntity);
		//? if neoforge
		/*return BLOCK_ENTITIES.register(name, () -> blockEntity);*/
	}

	public static void init() {
		SlayersBeasts.LOGGER.info("Initialised Block Entities");
	}
}
