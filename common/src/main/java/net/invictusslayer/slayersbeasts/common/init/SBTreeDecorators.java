package net.invictusslayer.slayersbeasts.common.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.world.feature.tree.decorator.ButtressRootDecorator;
import net.invictusslayer.slayersbeasts.common.world.feature.tree.decorator.HangingBranchDecorator;
import net.invictusslayer.slayersbeasts.common.world.feature.tree.decorator.OothecaDecorator;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

public class SBTreeDecorators {
	public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATORS = DeferredRegister.create(SlayersBeasts.MOD_ID, Registries.TREE_DECORATOR_TYPE);

	public static final RegistrySupplier<TreeDecoratorType<?>> BUTTRESS_ROOT = TREE_DECORATORS.register("buttress_root", () -> new TreeDecoratorType<>(ButtressRootDecorator.CODEC));
	public static final RegistrySupplier<TreeDecoratorType<?>> OOTHECA = TREE_DECORATORS.register("ootheca", () -> new TreeDecoratorType<>(OothecaDecorator.CODEC));
	public static final RegistrySupplier<TreeDecoratorType<?>> HANGING_BRANCH = TREE_DECORATORS.register("hanging_branch", () -> new TreeDecoratorType<>(HangingBranchDecorator.CODEC));
}
