package net.invictusslayer.slayersbeasts.world.structure;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;

import java.util.List;

public class SBProcessorLists {


	public static void bootstrap(BootstapContext<StructureProcessorList> context) {
		HolderGetter<Block> blocks = context.lookup(Registries.BLOCK);


	}

	private static ProcessorRule rule(Block block, float chance, BlockState blockState) {
		return rule(new RandomBlockMatchTest(block, chance), AlwaysTrueTest.INSTANCE, blockState);
	}

	private static ProcessorRule rule(TagKey<Block> tag, BlockState blockState) {
		return rule(new TagMatchTest(tag), AlwaysTrueTest.INSTANCE, blockState);
	}

	private static ProcessorRule rule(Block block, BlockState blockState) {
		return rule(new BlockMatchTest(block), AlwaysTrueTest.INSTANCE, blockState);
	}

	private static ProcessorRule rule(RuleTest blockTest, RuleTest locTest, BlockState resultBlock) {
		return new ProcessorRule(blockTest, locTest, resultBlock);
	}

	private static ResourceKey<StructureProcessorList> createKey(String name) {
		return ResourceKey.create(Registries.PROCESSOR_LIST, new ResourceLocation(name));
	}

	private static void register(BootstapContext<StructureProcessorList> context, ResourceKey<StructureProcessorList> key, List<StructureProcessor> processors) {
		context.register(key, new StructureProcessorList(processors));
	}
}
