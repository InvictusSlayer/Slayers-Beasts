package net.invictusslayer.slayersbeasts.block.entity;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.SBBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SBBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SlayersBeasts.MOD_ID);

	public static final RegistryObject<BlockEntityType<AnthillBlockEntity>> ANTHILL_BLOCK_ENTITY = BLOCK_ENTITIES.register("anthill", () -> BlockEntityType.Builder.of(AnthillBlockEntity::new, SBBlocks.ANTHILL.get()).build(null));
	public static final RegistryObject<BlockEntityType<AnthillHatcheryBlockEntity>> ANTHILL_HATCHERY_BLOCK_ENTITY = BLOCK_ENTITIES.register("anthill_hatchery", () -> BlockEntityType.Builder.of(AnthillHatcheryBlockEntity::new, SBBlocks.ANTHILL_HATCHERY.get()).build(null));

	public static final RegistryObject<BlockEntityType<SBSignBlockEntity>> SIGN = BLOCK_ENTITIES.register("sign", () -> BlockEntityType.Builder.of(SBSignBlockEntity::new, SBBlocks.ASPEN_SIGN.get(), SBBlocks.ASPEN_WALL_SIGN.get(), SBBlocks.DESERT_OAK_SIGN.get(), SBBlocks.DESERT_OAK_WALL_SIGN.get(), SBBlocks.EUCALYPTUS_SIGN.get(), SBBlocks.EUCALYPTUS_WALL_SIGN.get(), SBBlocks.KAPOK_SIGN.get(), SBBlocks.KAPOK_WALL_SIGN.get(), SBBlocks.REDWOOD_SIGN.get(), SBBlocks.REDWOOD_WALL_SIGN.get(), SBBlocks.WILLOW_SIGN.get(), SBBlocks.WILLOW_WALL_SIGN.get()).build(null));
	public static final RegistryObject<BlockEntityType<SBHangingSignBlockEntity>> HANGING_SIGN = BLOCK_ENTITIES.register("hanging_sign", () -> BlockEntityType.Builder.of(SBHangingSignBlockEntity::new, SBBlocks.ASPEN_HANGING_SIGN.get(), SBBlocks.ASPEN_WALL_HANGING_SIGN.get(), SBBlocks.DESERT_OAK_HANGING_SIGN.get(), SBBlocks.DESERT_OAK_WALL_HANGING_SIGN.get(), SBBlocks.EUCALYPTUS_HANGING_SIGN.get(), SBBlocks.EUCALYPTUS_WALL_HANGING_SIGN.get(), SBBlocks.KAPOK_HANGING_SIGN.get(), SBBlocks.KAPOK_WALL_HANGING_SIGN.get(), SBBlocks.REDWOOD_HANGING_SIGN.get(), SBBlocks.REDWOOD_WALL_HANGING_SIGN.get(), SBBlocks.WILLOW_HANGING_SIGN.get(), SBBlocks.WILLOW_WALL_HANGING_SIGN.get()).build(null));
}
