package net.invictusslayer.slayersbeasts.world.structure;

import net.invictusslayer.slayersbeasts.world.structure.pools.CryptPools;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

public class SBPools {
    public static void bootstrap(BootstapContext<StructureTemplatePool> context) {
        CryptPools.bootstrap(context);
    }
}
