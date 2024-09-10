package net.invictusslayer.slayersbeasts.common.world.structure.pools;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.invictusslayer.slayersbeasts.common.world.structure.SBProcessorLists;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

import java.util.function.Function;

public class RedwoodLodgePools extends SBPools {
	public static final ResourceKey<StructureTemplatePool> START = createKey("cabin");
	private static final ResourceKey<StructureTemplatePool> PATHS = createKey("paths");
	private static final ResourceKey<StructureTemplatePool> CAMP = createKey("camp");
	private static final ResourceKey<StructureTemplatePool> DECOR = createKey("decor");

	public static void bootstrap(BootstrapContext<StructureTemplatePool> context) {
		HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);
		HolderGetter<StructureProcessorList> processors = context.lookup(Registries.PROCESSOR_LIST);

		register(context, START, pools.getOrThrow(Pools.EMPTY), StructureTemplatePool.Projection.RIGID, ImmutableList.of(element("cabin", 1)));
		register(context, PATHS, pools.getOrThrow(DECOR), StructureTemplatePool.Projection.TERRAIN_MATCHING, ImmutableList.of(element("path_straight", 3, processors.getOrThrow(SBProcessorLists.REDWOOD_PATH)), element("path_corner", 2, processors.getOrThrow(SBProcessorLists.REDWOOD_PATH)), element("path_cross", 1, processors.getOrThrow(SBProcessorLists.REDWOOD_PATH))));
		register(context, CAMP, pools.getOrThrow(Pools.EMPTY), StructureTemplatePool.Projection.RIGID, ImmutableList.of(element("campfire", 3), element("shed_1", 1), element("shed_2", 1), element("storage", 4)));
		register(context, DECOR, pools.getOrThrow(Pools.EMPTY), StructureTemplatePool.Projection.RIGID, ImmutableList.of(element("logs_1", 1), element("logs_2", 1), element("well", 1)));
	}

	private static Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer> element(String name, int weight) {
		return parentElement("lodge/redwood", name, weight);
	}

	private static Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer> element(String name, int weight, Holder<StructureProcessorList> processor) {
		return parentElement("lodge/redwood", name, weight, processor);
	}

	private static ResourceKey<StructureTemplatePool> createKey(String name) {
		return createParentKey("lodge/redwood", name);
	}
}
