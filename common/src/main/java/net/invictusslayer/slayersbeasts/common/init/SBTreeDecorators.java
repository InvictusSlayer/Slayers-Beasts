package net.invictusslayer.slayersbeasts.common.init;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.world.feature.tree.decorator.ButtressRootDecorator;
import net.invictusslayer.slayersbeasts.common.world.feature.tree.decorator.HangingBranchDecorator;
import net.invictusslayer.slayersbeasts.common.world.feature.tree.decorator.OothecaDecorator;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

import java.util.function.Supplier;

public class SBTreeDecorators {
	public static final Supplier<TreeDecoratorType<?>> BUTTRESS_ROOT = register("buttress_root", () -> new TreeDecoratorType<>(ButtressRootDecorator.CODEC));
	public static final Supplier<TreeDecoratorType<?>> OOTHECA = register("ootheca", () -> new TreeDecoratorType<>(OothecaDecorator.CODEC));
	public static final Supplier<TreeDecoratorType<?>> HANGING_BRANCH = register("hanging_branch", () -> new TreeDecoratorType<>(HangingBranchDecorator.CODEC));

	private static <T extends TreeDecoratorType<?>> Supplier<T> register(String name, Supplier<T> supplier) {
		return SlayersBeasts.PLATFORM.register(BuiltInRegistries.TREE_DECORATOR_TYPE, name, supplier);
	}

	public static void register() {
		SlayersBeasts.LOGGER.info("Registering SBTreeDecorators...");
	}
}
