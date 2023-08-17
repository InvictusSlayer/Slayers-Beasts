package net.invictusslayer.slayersbeasts.world.structure.structures;

import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;

import java.util.Optional;

public class CryptStructure extends Structure {
    protected CryptStructure(StructureSettings pSettings) {
        super(pSettings);
    }

    protected Optional<GenerationStub> findGenerationPoint(GenerationContext pContext) {
        return Optional.empty();
    }

    public StructureType<?> type() {
        return null;
    }
}
