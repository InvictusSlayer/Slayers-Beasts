package net.invictusslayer.slayersbeasts.world.structure;

import com.google.common.collect.ImmutableList;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;

public class SBProcessorLists {
	public static final ResourceKey<StructureProcessorList> STONE_FLOOR = createKey("stone_floor");

	public static void bootstrap(BootstapContext<StructureProcessorList> context) {
		HolderGetter<Block> blocks = context.lookup(Registries.BLOCK);

		register(context, STONE_FLOOR, rule(Blocks.STONE, 0.1F, Blocks.POLISHED_ANDESITE.defaultBlockState()), rule(Blocks.STONE, 0.1F, Blocks.SMOOTH_STONE.defaultBlockState()), rule(Blocks.STONE, Blocks.STONE_BRICKS.defaultBlockState()));
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

	private static ProcessorRule rule(RuleTest blockTest, RuleTest locationTest, BlockState resultBlock) {
		return new ProcessorRule(blockTest, locationTest, resultBlock);
	}

	private static ResourceKey<StructureProcessorList> createKey(String name) {
		return ResourceKey.create(Registries.PROCESSOR_LIST, new ResourceLocation(SlayersBeasts.MOD_ID, name));
	}

	private static void register(BootstapContext<StructureProcessorList> context, ResourceKey<StructureProcessorList> key, ProcessorRule... processors) {
		context.register(key, new StructureProcessorList(ImmutableList.of(new RuleProcessor(ImmutableList.copyOf(processors)))));
	}
}
