package net.invictusslayer.slayersbeasts.block.entity;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.SBBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SBBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SlayersBeasts.MOD_ID);

    public static final RegistryObject<BlockEntityType<AnthillBlockEntity>> ANTHILL_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("anthill", () -> BlockEntityType.Builder.of(
                    AnthillBlockEntity::new, SBBlocks.ANTHILL.get()).build(null));

    public static final RegistryObject<BlockEntityType<AnthillHatcheryBlockEntity>> ANTHILL_HATCHERY_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("anthill_hatchery", () -> BlockEntityType.Builder.of(
                    AnthillHatcheryBlockEntity::new, SBBlocks.ANTHILL_HATCHERY.get()).build(null));
}
