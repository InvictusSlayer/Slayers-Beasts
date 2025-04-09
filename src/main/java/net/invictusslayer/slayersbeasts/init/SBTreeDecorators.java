package net.invictusslayer.slayersbeasts.init;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.world.feature.tree.decorator.ButtressRootDecorator;
import net.invictusslayer.slayersbeasts.world.feature.tree.decorator.HangingBranchDecorator;
import net.invictusslayer.slayersbeasts.world.feature.tree.decorator.OothecaDecorator;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

import java.util.function.Supplier;

public class SBTreeDecorators {
	//? if neoforge
	/*public static final net.neoforged.neoforge.registries.DeferredRegister<TreeDecoratorType<?>> TREE_DECORATORS = net.neoforged.neoforge.registries.DeferredRegister.create(Registries.TREE_DECORATOR_TYPE, SlayersBeasts.MOD_ID);*/

	public static final Supplier<TreeDecoratorType<?>> BUTTRESS_ROOT = register("buttress_root", new TreeDecoratorType<>(ButtressRootDecorator.CODEC));
	public static final Supplier<TreeDecoratorType<?>> OOTHECA = register("ootheca", new TreeDecoratorType<>(OothecaDecorator.CODEC));
	public static final Supplier<TreeDecoratorType<?>> HANGING_BRANCH = register("hanging_branch", new TreeDecoratorType<>(HangingBranchDecorator.CODEC));

	private static <T extends TreeDecoratorType<?>> Supplier<T> register(String name, T decorator) {
		//? if fabric
		return () -> Registry.register(BuiltInRegistries.TREE_DECORATOR_TYPE, ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, name), decorator);
		//? if neoforge
		/*return TREE_DECORATORS.register(name, () -> decorator);*/
	}

	public static void init() {
		SlayersBeasts.LOGGER.info("Initialised Tree Decorators");
	}
}
