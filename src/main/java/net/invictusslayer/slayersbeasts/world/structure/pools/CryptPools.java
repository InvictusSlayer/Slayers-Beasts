package net.invictusslayer.slayersbeasts.world.structure.pools;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.invictusslayer.slayersbeasts.world.structure.SBProcessorLists;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

import java.util.function.Function;

public class CryptPools extends SBPools {
    public static final ResourceKey<StructureTemplatePool> START = createKey("entrance");
    private static final ResourceKey<StructureTemplatePool> CORRIDOR = createKey("corridor");
    private static final ResourceKey<StructureTemplatePool> JUNCTION = createKey("junction");
    private static final ResourceKey<StructureTemplatePool> ROOM = createKey("room");
    private static final ResourceKey<StructureTemplatePool> WALL = createKey("wall");

    public static void bootstrap(BootstapContext<StructureTemplatePool> context) {
        HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);
        HolderGetter<StructureProcessorList> processors = context.lookup(Registries.PROCESSOR_LIST);

        register(context, START, pools.getOrThrow(Pools.EMPTY), StructureTemplatePool.Projection.RIGID, ImmutableList.of(element("entrance1", 1)));
        register(context, CORRIDOR, pools.getOrThrow(ROOM), StructureTemplatePool.Projection.RIGID, ImmutableList.of(element("corridor_0", 2), element("corridor_1", 1), element("corridor_2", 2)));
        register(context, JUNCTION, pools.getOrThrow(ROOM), StructureTemplatePool.Projection.RIGID, ImmutableList.of(element("junction_0", 2, processors.getOrThrow(SBProcessorLists.STONE_FLOOR)), element("junction_1", 1, processors.getOrThrow(SBProcessorLists.STONE_FLOOR)), element("junction1", 1), element("junction_stair1", 1)));
        register(context, ROOM, pools.getOrThrow(WALL), StructureTemplatePool.Projection.RIGID, ImmutableList.of(element("room_chest_0", 1, processors.getOrThrow(SBProcessorLists.STONE_FLOOR)), element("room_spawner_0", 1)));
        register(context, WALL, pools.getOrThrow(Pools.EMPTY), StructureTemplatePool.Projection.RIGID, ImmutableList.of(element("wall_0", 2), element("wall_1", 2), element("wall_2", 2), element("wall_barrels_0", 1), element("wall_barrels_1", 1), element("wall_fountain_0", 1)));
    }

    private static Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer> element(String name, int weight) {
        return SBPools.parentElement("crypt", name, weight);
    }

    private static Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer> element(String name, int weight, Holder<StructureProcessorList> processor) {
        return SBPools.parentElement("crypt", name, weight, processor);
    }

    private static ResourceKey<StructureTemplatePool> createKey(String name) {
        return createParentKey("crypt", name);
    }
}
