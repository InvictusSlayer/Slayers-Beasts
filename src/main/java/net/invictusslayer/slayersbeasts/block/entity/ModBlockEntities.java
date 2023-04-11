package net.invictusslayer.slayersbeasts.block.entity;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.init.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SlayersBeasts.MOD_ID);

    public static final RegistryObject<BlockEntityType<AnthillBlockEntity>> ANTHILL_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("anthill", () -> BlockEntityType.Builder.of(
                    AnthillBlockEntity::new, ModBlocks.ANTHILL.get()).build(null));

    public static final RegistryObject<BlockEntityType<AnthillHatcheryBlockEntity>> ANTHILL_HATCHERY_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("anthill_hatchery", () -> BlockEntityType.Builder.of(
                    AnthillHatcheryBlockEntity::new, ModBlocks.ANTHILL_HATCHERY.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
