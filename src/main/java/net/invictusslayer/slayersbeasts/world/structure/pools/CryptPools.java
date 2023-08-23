package net.invictusslayer.slayersbeasts.world.structure.pools;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Either;
import com.mojang.datafixers.util.Pair;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.world.structure.SBPools;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.SinglePoolElement;
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
        register(context, CORRIDOR, pools.getOrThrow(ROOM), StructureTemplatePool.Projection.RIGID, ImmutableList.of(element("corridor1", 1)));
        register(context, JUNCTION, pools.getOrThrow(ROOM), StructureTemplatePool.Projection.RIGID, ImmutableList.of(element("junction1", 3), element("junction_stair1", 1)));
        register(context, ROOM, pools.getOrThrow(WALL), StructureTemplatePool.Projection.RIGID, ImmutableList.of(element("room1", 3), element("wall2", 1)));
        register(context, WALL, pools.getOrThrow(Pools.EMPTY), StructureTemplatePool.Projection.RIGID, ImmutableList.of(element("wall1", 1), element("wall2", 1)));
    }

    private static Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer> element(String name, int weight) {
        return Pair.of(projection -> new SinglePoolElement(Either.left(new ResourceLocation(SlayersBeasts.MOD_ID, "crypt/" + name)), StructurePoolElement.EMPTY, projection), weight);
    }

    private static Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer> element(String name, int weight, Holder<StructureProcessorList> processor) {
        return Pair.of(projection -> new SinglePoolElement(Either.left(new ResourceLocation(SlayersBeasts.MOD_ID, "crypt/" + name)), processor, projection), weight);
    }

    private static ResourceKey<StructureTemplatePool> createKey(String name) {
        return createKey("crypt", name);
    }
}
