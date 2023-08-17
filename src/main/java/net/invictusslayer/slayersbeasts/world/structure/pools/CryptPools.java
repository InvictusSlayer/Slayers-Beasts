package net.invictusslayer.slayersbeasts.world.structure.pools;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Either;
import com.mojang.datafixers.util.Pair;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
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

import java.util.List;
import java.util.function.Function;

public class CryptPools {
    public static final ResourceKey<StructureTemplatePool> START = createKey("entrance_pool");
    private static final ResourceKey<StructureTemplatePool> CORRIDORS = createKey("corridor_pool");
    private static final ResourceKey<StructureTemplatePool> JUNCTIONS = createKey("junction_pool");
    private static final ResourceKey<StructureTemplatePool> ROOMS = createKey("room_pool");
    private static final ResourceKey<StructureTemplatePool> WALLS = createKey("wall_pool");

    public static void bootstrap(BootstapContext<StructureTemplatePool> context) {
        HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);
        HolderGetter<StructureProcessorList> processors = context.lookup(Registries.PROCESSOR_LIST);

        register(context, START, pools.getOrThrow(Pools.EMPTY), StructureTemplatePool.Projection.RIGID, ImmutableList.of(element("crypt_entrance1", 1)));
        register(context, CORRIDORS, pools.getOrThrow(ROOMS), StructureTemplatePool.Projection.RIGID, ImmutableList.of(element("crypt_corridor1", 1)));
        register(context, JUNCTIONS, pools.getOrThrow(ROOMS), StructureTemplatePool.Projection.RIGID, ImmutableList.of(element("crypt_junction1", 1)));
        register(context, ROOMS, pools.getOrThrow(WALLS), StructureTemplatePool.Projection.RIGID, ImmutableList.of(element("crypt_room1", 3), element("crypt_wall1", 1)));
        register(context, WALLS, pools.getOrThrow(Pools.EMPTY), StructureTemplatePool.Projection.RIGID, ImmutableList.of(element("crypt_wall1", 1)));
    }

    private static Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer> element(String name, int weight) {
        return Pair.of(projection -> new SinglePoolElement(Either.left(new ResourceLocation(SlayersBeasts.MOD_ID, "crypt/" + name)), StructurePoolElement.EMPTY, projection), weight);
    }

    private static Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer> element(String name, int weight, Holder<StructureProcessorList> processor) {
        return Pair.of(projection -> new SinglePoolElement(Either.left(new ResourceLocation(SlayersBeasts.MOD_ID, "crypt/" + name)), processor, projection), weight);
    }

    private static ResourceKey<StructureTemplatePool> createKey(String name) {
        return ResourceKey.create(Registries.TEMPLATE_POOL, new ResourceLocation(SlayersBeasts.MOD_ID, "crypt/" + name));
    }

    private static void register(BootstapContext<StructureTemplatePool> context, ResourceKey<StructureTemplatePool> key, Holder<StructureTemplatePool> fallback, StructureTemplatePool.Projection projection, List<Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer>> list) {
        context.register(key, new StructureTemplatePool(fallback, list, projection));
    }
}
