package net.invictusslayer.slayersbeasts.world.structure;

import com.mojang.datafixers.util.Pair;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.world.structure.pools.CryptPools;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

import java.util.List;
import java.util.function.Function;

public class SBPools {
    public static void bootstrap(BootstapContext<StructureTemplatePool> context) {
        CryptPools.bootstrap(context);
    }

    protected static ResourceKey<StructureTemplatePool> createKey(String parent, String name) {
        return ResourceKey.create(Registries.TEMPLATE_POOL, new ResourceLocation(SlayersBeasts.MOD_ID, parent + "/" + name));
    }

    protected static void register(BootstapContext<StructureTemplatePool> context, ResourceKey<StructureTemplatePool> key, Holder<StructureTemplatePool> fallback, StructureTemplatePool.Projection projection, List<Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer>> list) {
        context.register(key, new StructureTemplatePool(fallback, list, projection));
    }
}
