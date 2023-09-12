package net.invictusslayer.slayersbeasts.world.feature.tree.decorator;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SBTreeDecorators {
    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATORS = DeferredRegister.create(ForgeRegistries.TREE_DECORATOR_TYPES, SlayersBeasts.MOD_ID);

    public static final RegistryObject<TreeDecoratorType<?>> BUTTRESS_ROOT = TREE_DECORATORS.register("buttress_root", () -> new TreeDecoratorType<>(ButtressRootDecorator.CODEC));
    public static final RegistryObject<TreeDecoratorType<?>> OOTHECA = TREE_DECORATORS.register("ootheca", () -> new TreeDecoratorType<>(OothecaDecorator.CODEC));
    public static final RegistryObject<TreeDecoratorType<?>> HANGING_BRANCH = TREE_DECORATORS.register("hanging_branch", () -> new TreeDecoratorType<>(HangingBranchDecorator.CODEC));
}
