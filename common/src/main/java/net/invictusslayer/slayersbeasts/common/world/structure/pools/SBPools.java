package net.invictusslayer.slayersbeasts.common.world.structure.pools;

import com.mojang.datafixers.util.Either;
import com.mojang.datafixers.util.Pair;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.SinglePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

import java.util.List;
import java.util.function.Function;

public class SBPools {
	public static void bootstrap(BootstapContext<StructureTemplatePool> context) {
		CryptPools.bootstrap(context);
	}

	protected static Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer> parentElement(String parent, String name, int weight) {
		return parentElement(parent, name, weight, Holder.direct(new StructureProcessorList(List.of())));
	}

	protected static Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer> parentElement(String parent, String name, int weight, Holder<StructureProcessorList> processor) {
		return Pair.of(projection -> new SinglePoolElement(Either.left(new ResourceLocation(SlayersBeasts.MOD_ID, parent + "/" + name)), processor, projection), weight);
	}

	protected static ResourceKey<StructureTemplatePool> createParentKey(String parent, String name) {
		return ResourceKey.create(Registries.TEMPLATE_POOL, new ResourceLocation(SlayersBeasts.MOD_ID, parent + "/" + name));
	}

	protected static void register(BootstapContext<StructureTemplatePool> context, ResourceKey<StructureTemplatePool> key, Holder<StructureTemplatePool> fallback, StructureTemplatePool.Projection projection, List<Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer>> list) {
		context.register(key, new StructureTemplatePool(fallback, list, projection));
	}
}
