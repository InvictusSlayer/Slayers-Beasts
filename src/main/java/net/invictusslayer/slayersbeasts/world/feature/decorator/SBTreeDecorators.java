package net.invictusslayer.slayersbeasts.world.feature.decorator;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SBTreeDecorators {
    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATORS = DeferredRegister.create(ForgeRegistries.TREE_DECORATOR_TYPES, SlayersBeasts.MOD_ID);

    public static final RegistryObject<TreeDecoratorType<?>> OOTHECA = TREE_DECORATORS.register("ootheca", () -> new TreeDecoratorType<>(OothecaDecorator.CODEC));

    public static void register(IEventBus eventBus) {
        TREE_DECORATORS.register(eventBus);
    }
}
