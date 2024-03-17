package net.invictusslayer.slayersbeasts.common.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.block.entity.AnthillBlockEntity;
import net.invictusslayer.slayersbeasts.common.block.entity.AnthillHatcheryBlockEntity;
import net.invictusslayer.slayersbeasts.common.block.entity.SBHangingSignBlockEntity;
import net.invictusslayer.slayersbeasts.common.block.entity.SBSignBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class SBBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(SlayersBeasts.MOD_ID, Registries.BLOCK_ENTITY_TYPE);

	public static final RegistrySupplier<BlockEntityType<AnthillBlockEntity>> ANTHILL = BLOCK_ENTITIES.register("anthill", () -> BlockEntityType.Builder.of(AnthillBlockEntity::new, SBBlocks.ANTHILL.get()).build(null));
	public static final RegistrySupplier<BlockEntityType<AnthillHatcheryBlockEntity>> ANTHILL_HATCHERY = BLOCK_ENTITIES.register("anthill_hatchery", () -> BlockEntityType.Builder.of(AnthillHatcheryBlockEntity::new, SBBlocks.ANTHILL_HATCHERY.get()).build(null));

	public static final RegistrySupplier<BlockEntityType<SBSignBlockEntity>> SIGN = BLOCK_ENTITIES.register("sign", () -> BlockEntityType.Builder.of(SBSignBlockEntity::new, SBBlocks.ASPEN_SIGN.get(), SBBlocks.ASPEN_WALL_SIGN.get(), SBBlocks.DESERT_OAK_SIGN.get(), SBBlocks.DESERT_OAK_WALL_SIGN.get(), SBBlocks.EUCALYPTUS_SIGN.get(), SBBlocks.EUCALYPTUS_WALL_SIGN.get(), SBBlocks.KAPOK_SIGN.get(), SBBlocks.KAPOK_WALL_SIGN.get(), SBBlocks.REDWOOD_SIGN.get(), SBBlocks.REDWOOD_WALL_SIGN.get(), SBBlocks.WILLOW_SIGN.get(), SBBlocks.WILLOW_WALL_SIGN.get()).build(null));
	public static final RegistrySupplier<BlockEntityType<SBHangingSignBlockEntity>> HANGING_SIGN = BLOCK_ENTITIES.register("hanging_sign", () -> BlockEntityType.Builder.of(SBHangingSignBlockEntity::new, SBBlocks.ASPEN_HANGING_SIGN.get(), SBBlocks.ASPEN_WALL_HANGING_SIGN.get(), SBBlocks.DESERT_OAK_HANGING_SIGN.get(), SBBlocks.DESERT_OAK_WALL_HANGING_SIGN.get(), SBBlocks.EUCALYPTUS_HANGING_SIGN.get(), SBBlocks.EUCALYPTUS_WALL_HANGING_SIGN.get(), SBBlocks.KAPOK_HANGING_SIGN.get(), SBBlocks.KAPOK_WALL_HANGING_SIGN.get(), SBBlocks.REDWOOD_HANGING_SIGN.get(), SBBlocks.REDWOOD_WALL_HANGING_SIGN.get(), SBBlocks.WILLOW_HANGING_SIGN.get(), SBBlocks.WILLOW_WALL_HANGING_SIGN.get()).build(null));
}
